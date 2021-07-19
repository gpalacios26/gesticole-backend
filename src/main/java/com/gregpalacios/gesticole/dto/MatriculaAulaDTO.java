package com.gregpalacios.gesticole.dto;

import java.util.List;

import com.gregpalacios.gesticole.model.MatriculaAula;
import com.gregpalacios.gesticole.model.MatriculaAulaDetalle;

public class MatriculaAulaDTO {

	private MatriculaAula matricula;
	
	private List<MatriculaAulaDetalle> detalle;

	public MatriculaAula getMatricula() {
		return matricula;
	}

	public void setMatricula(MatriculaAula matricula) {
		this.matricula = matricula;
	}

	public List<MatriculaAulaDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<MatriculaAulaDetalle> detalle) {
		this.detalle = detalle;
	}
}
