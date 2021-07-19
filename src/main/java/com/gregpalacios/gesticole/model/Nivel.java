package com.gregpalacios.gesticole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nivel")
public class Nivel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNivel;
	
	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Nivel [idNivel=" + idNivel + ", descripcion=" + descripcion + "]";
	}
}
