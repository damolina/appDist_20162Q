package converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dto.ItemRemitoDTO;
import entities.ItemRemito;

public class ItemRemitoConverter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6603573328053220056L;
	
	public static ItemRemitoDTO itemRemitoToDTO(ItemRemito itemRemito){
		ItemRemitoDTO itemRemitoDTO = new ItemRemitoDTO(CargaConverter.cargaToDTO(itemRemito.getCarga()));
		return itemRemitoDTO;
	}
	
	public static List<ItemRemitoDTO> itemsRemitoToDTO(List<ItemRemito> itemsRemito){
		List<ItemRemitoDTO> itemsRemitoDTO = new ArrayList<ItemRemitoDTO>();
		for(ItemRemito i:itemsRemito){
			itemsRemitoDTO.add(itemRemitoToDTO(i));
		}
		return itemsRemitoDTO;
	}

	public static ItemRemito itemRemitoToEntity(ItemRemitoDTO itemRemitoDTO){
		ItemRemito itemRemito = new ItemRemito(RemitoConverter.remitoToEntity(itemRemitoDTO.getRemito()), 
				CargaConverter.cargaToEntity(itemRemitoDTO.getCarga()));
		return itemRemito;
	}
	
	public static List<ItemRemito> itemsRemitoToEntity(List<ItemRemitoDTO> itemsRemitoDTO){
		List<ItemRemito> itemsRemito = new ArrayList<ItemRemito>();
		for(ItemRemitoDTO i:itemsRemitoDTO){
			itemsRemito.add(itemRemitoToEntity(i));
		}
		return itemsRemito;
	}

}
