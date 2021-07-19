package com.gregpalacios.gesticole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "anio")
public class Anio {

	@Id
	private Integer idAnio;

	@Column(name = "descripcion")
	private Integer descripcion;

	public Integer getIdAnio() {
		return idAnio;
	}

	public void setIdAnio(Integer idAnio) {
		this.idAnio = idAnio;
	}

	public Integer getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Integer descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Anio [idAnio=" + idAnio + ", descripcion=" + descripcion + "]";
	}
}
