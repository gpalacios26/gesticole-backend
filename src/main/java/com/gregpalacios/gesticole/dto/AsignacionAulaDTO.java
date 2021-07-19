package com.gregpalacios.gesticole.dto;

import java.util.List;

import com.gregpalacios.gesticole.model.AsignacionAula;
import com.gregpalacios.gesticole.model.AsignacionAulaDetalle;

public class AsignacionAulaDTO {

	private AsignacionAula asignacion;
	
	private List<AsignacionAulaDetalle> detalle;

	public AsignacionAula getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(AsignacionAula asignacion) {
		this.asignacion = asignacion;
	}

	public List<AsignacionAulaDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<AsignacionAulaDetalle> detalle) {
		this.detalle = detalle;
	}
}
