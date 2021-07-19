package com.gregpalacios.gesticole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dia")
public class Dia {

	@Id
	private Integer idDia;

	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdDia() {
		return idDia;
	}

	public void setIdDia(Integer idDia) {
		this.idDia = idDia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Dia [idDia=" + idDia + ", descripcion=" + descripcion + "]";
	}
}
