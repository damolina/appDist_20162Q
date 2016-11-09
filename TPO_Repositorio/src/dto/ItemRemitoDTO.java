package dto;

import java.io.Serializable;

public class ItemRemitoDTO implements Serializable{

	private static final long serialVersionUID = -1990273280620734269L;
	
	private CargaDTO carga;
	private RemitoDTO remito; //NUEVO

	public ItemRemitoDTO() {
		super();
	}

	public ItemRemitoDTO(CargaDTO carga) {
		super();
		this.carga = carga;
	}
	
	public ItemRemitoDTO(CargaDTO carga, RemitoDTO remito) { //NUEVO
		super();
		this.carga = carga;
		this.remito = remito;
	}
	
	public CargaDTO getCarga() {
		return carga;
	}

	public void setCarga(CargaDTO carga) {
		this.carga = carga;
	}

	public RemitoDTO getRemito() { //NUEVO
		return remito;
	}

	public void setRemito(RemitoDTO remito) { //NUEVO
		this.remito = remito;
	}

	@Override
	public String toString(){ //VER SI ES NECESARIO AGREGARLE EL REMITO
		return "[Carga=(" + carga + ")]";
//		return "[Remito=(" + remito + ") | Carga=(" + carga + ")]"; //NUEVO
	}
}
