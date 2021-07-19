package com.gregpalacios.gesticole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parentesco")
public class Parentesco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idParentesco;
	
	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdParentesco() {
		return idParentesco;
	}

	public void setIdParentesco(Integer idParentesco) {
		this.idParentesco = idParentesco;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Parentesco [idParentesco=" + idParentesco + ", descripcion=" + descripcion + "]";
	}
}
