package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.RemitoDTO;
import entities.Remito;

public class RemitoConverter implements Serializable{

	private static final long serialVersionUID = 1L;

	public static RemitoDTO remitoToDTO(Remito remito){
		RemitoDTO remitoDTO = new RemitoDTO(remito.getFecha(),
											ItemRemitoConverter.itemsRemitoToDTO(remito.getItemsRemito()),
											remito.getId());
		return remitoDTO;
	}

	public static List<RemitoDTO> remitosToDTO(List<Remito> remitos){
		List<RemitoDTO> remitosDTO = new ArrayList<RemitoDTO>();
		for(Remito r:remitos){
			RemitoDTO remitoDTO = new RemitoDTO(r.getFecha(), ItemRemitoConverter.itemsRemitoToDTO(r.getItemsRemito()), r.getId());
			remitosDTO.add(remitoDTO);
		}
		return remitosDTO;
	}
	
	public static Remito remitoToEntity(RemitoDTO remito){
		Remito remitoEntity = new Remito(remito.getFecha(), remito.getNumero(), ItemRemitoConverter.itemsRemitoToEntity(remito.getItemsRemito()));
		return remitoEntity;
	}
	
	public static List<RemitoDTO> remitosToEntity(List<Remito> remitos){
		List<RemitoDTO> remitosDTO = new ArrayList<RemitoDTO>();
		for(Remito r:remitos){
			RemitoDTO remitoDTO = new RemitoDTO(r.getFecha(), ItemRemitoConverter.itemsRemitoToDTO(r.getItemsRemito()), r.getId());
			remitosDTO.add(remitoDTO);
		}
		return remitosDTO;
	}

}
