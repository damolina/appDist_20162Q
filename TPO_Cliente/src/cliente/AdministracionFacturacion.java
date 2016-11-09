package cliente;

import java.rmi.RemoteException;
import java.util.List;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.EnvioDTO;
import dto.FacturaDTO;
import dto.RemitoDTO;
import exceptions.ClienteException;
import exceptions.EnvioException;
import exceptions.FacturaException;
import exceptions.RemitoException;
import interfaz.INegocioFacturacion;

public class AdministracionFacturacion {
	INegocioFacturacion controladorFacturacion;
	
	public AdministracionFacturacion(EnvioDTO envio){
		try{
			RemitoDTO remito = new BusinessDelegate().getBusinessService().generarRemito(envio);
		
			System.out.println("RemitoDTO: " + remito);
			
		}catch(RemoteException | EnvioException | RemitoException e){
			e.printStackTrace();
		}
		
		try{				
			FacturaDTO factura = new BusinessDelegate().getBusinessService().generarFactura(envio);
			
			System.out.println("FacturaDTO: " + factura);
			
		}catch(RemoteException | EnvioException | FacturaException e){
			e.printStackTrace();
		}
	}

	public AdministracionFacturacion(ClienteDTO cliente){
		try{
			List<RemitoDTO> remitos = new BusinessDelegate().getBusinessService().obtenerRemitosPorCliente(cliente);
		
			System.out.println("Cliente " + cliente.getNombre());
			if(remitos != null)
				for(RemitoDTO r:remitos)
					System.out.println("Remito: " + r.getNumero());
			else
				System.out.println("No se encontraron remitos");
			
		}catch(RemoteException | ClienteException | RemitoException e){
			e.printStackTrace();
		}
	}
}
