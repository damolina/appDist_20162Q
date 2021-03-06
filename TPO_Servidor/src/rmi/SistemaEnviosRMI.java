package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dto.CargaDTO;
import dto.ClienteDTO;
import dto.EmpleadoDTO;
import dto.EnvioDTO;
import dto.FacturaDTO;
import dto.RemitoDTO;
import dto.RolEmpleadoDTO;
import dto.RutaDTO;
import dto.SucursalDTO;
import dto.VehiculoDTO;
import dto.ViajeDTO;
import exceptions.CargaException;
import exceptions.ClienteException;
import exceptions.EmpleadoException;
import exceptions.EnvioException;
import exceptions.FacturaException;
import exceptions.RemitoException;
import exceptions.RolEmpleadoException;
import exceptions.RutaException;
import exceptions.SucursalException;
import exceptions.VehiculoException;
import exceptions.ViajeException;
import interfaz.ISistemaEnvios;
import srv.EmpleadoSRV;
import srv.EnvioSRV;
import srv.FacturaSRV;
import srv.RemitoSRV;
import srv.RolEmpleadoSRV;
import srv.RutaSRV;
import srv.SucursalSRV;
import srv.VehiculoSRV;
import srv.ViajeSRV;

public class SistemaEnviosRMI extends UnicastRemoteObject implements ISistemaEnvios{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1666433271782283950L;

	public SistemaEnviosRMI() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public EnvioDTO gestionarEnvio(ClienteDTO cliente, List<CargaDTO> cargas, SucursalDTO sOrigen, SucursalDTO sDestino)
			throws ClienteException, CargaException, RemoteException {
		return EnvioSRV.gestionarEnvio(cliente, cargas, sOrigen, sDestino);
	}

	@Override
	public List<EnvioDTO> obtenerEnviosPorCliente(ClienteDTO cliente) throws ClienteException, RemoteException {
		return EnvioSRV.obtenerEnviosPorCliente(cliente);
	}

	@Override
	public List<CargaDTO> obtenerCargasPorEnvio(EnvioDTO envio) throws EnvioException, RemoteException {
		return EnvioSRV.obtenerCargasPorEnvio(envio);
	}

	@Override
	public List<ViajeDTO> gestionarViaje(List<EmpleadoDTO> choferesDisponibles, List<EnvioDTO> enviosPendientes,
			List<VehiculoDTO> vehiculosDisponibles)
			throws EmpleadoException, EnvioException, VehiculoException, RemoteException, ViajeException {
		return ViajeSRV.gestionarViaje(choferesDisponibles, enviosPendientes, vehiculosDisponibles);
	}

	@Override
	public List<EnvioDTO> getEnviosPendientes() throws EnvioException, RemoteException {
		return ViajeSRV.getEnviosPendientes();
	}

	@Override
	public List<VehiculoDTO> getVehiculosDisponibles() throws VehiculoException, RemoteException {
		return VehiculoSRV.getVehiculosDisponibles();
	}

	@Override
	public List<EmpleadoDTO> getChoferesDisponibles() throws EmpleadoException, RemoteException {
		return EmpleadoSRV.getChoferesDisponibles();
	}

	@Override
	public List<RutaDTO> getRutasDisponibles() throws RutaException, RemoteException {
		return RutaSRV.getRutas();
	}

	@Override
	public FacturaDTO generarFactura(EnvioDTO envio) throws EnvioException, FacturaException, RemoteException {
		return FacturaSRV.generarFactura(envio);
	}

	@Override
	public List<FacturaDTO> obtenerFacturasPorCliente(ClienteDTO cliente)
			throws ClienteException, FacturaException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FacturaDTO obtenerUltimaFactura(ClienteDTO cliente)
			throws ClienteException, FacturaException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RemitoDTO generarRemito(EnvioDTO envio) throws EnvioException, RemitoException, RemoteException {
		return RemitoSRV.generarRemito(envio);
	}

	@Override
	public List<RemitoDTO> obtenerRemitosPorCliente(ClienteDTO cliente)
			throws ClienteException, RemitoException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RemitoDTO obtenerUltimoRemito(ClienteDTO cliente) throws ClienteException, RemitoException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SucursalDTO crearSucursal(SucursalDTO sucursal) throws RemoteException, SucursalException {
		return SucursalSRV.crearSucursal(sucursal);
	}

	@Override
	public SucursalDTO modificarSucursal(int idSucursal) throws RemoteException, SucursalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SucursalDTO eliminarSucursal(int idSucursal) throws RemoteException, SucursalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SucursalDTO getSucursalById(int idSucursal) throws RemoteException, SucursalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SucursalDTO> getSucursales() throws RemoteException, SucursalException {
		return SucursalSRV.getSucursales();
	}

	@Override
	public RutaDTO crearRuta(RutaDTO ruta) throws RemoteException, RutaException {
		return RutaSRV.crearRuta(ruta);
	}

	@Override
	public List<RutaDTO> getRutas() throws RemoteException, RutaException {
		return RutaSRV.getRutas();
	}

	@Override
	public RolEmpleadoDTO crearRolEmpleado(RolEmpleadoDTO rolEmpleado) throws RemoteException, RolEmpleadoException {
		return RolEmpleadoSRV.crearRolEmpleado(rolEmpleado);
	}

	@Override
	public List<RolEmpleadoDTO> getRoles() throws RemoteException, RolEmpleadoException {
		return RolEmpleadoSRV.getRoles();
	}

	@Override
	public List<EmpleadoDTO> getEmpleados() throws RemoteException, EmpleadoException {
		return EmpleadoSRV.getEmpleados();
	}

	@Override
	public EmpleadoDTO crearEmpleado(EmpleadoDTO empleado) throws RemoteException, EmpleadoException {
		return EmpleadoSRV.crearEmpleado(empleado);
	}
	
	@Override
	public boolean existeEmpleado(String cuit) throws RemoteException, EmpleadoException {
		return EmpleadoSRV.existeEmpleado(cuit);
	}



}
