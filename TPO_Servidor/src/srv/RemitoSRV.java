package srv;

import java.util.List;

import converters.RemitoConverter;
import dao.RemitoDAO;
import dto.ClienteDTO;
import dto.EnvioDTO;
import dto.RemitoDTO;
import entities.Remito;

public class RemitoSRV {
	public static RemitoDAO dao;
	
	static{
		dao = RemitoDAO.getInstancia();
	}
	
	public static RemitoDTO generarRemito(EnvioDTO envio){
		Remito remito = dao.generarRemito(envio);
		RemitoDTO remitoDTO = RemitoConverter.remitoToDTO(remito);
		return remitoDTO;
	}
	
	public static List<RemitoDTO> obtenerRemitosPorCliente(ClienteDTO cliente){
		List<Remito> remitos = dao.obtenerRemitosPorCliente(cliente);
		List<RemitoDTO> remitosDTO = RemitoConverter.remitosToDTO(remitos);
		return remitosDTO;
	}

}
