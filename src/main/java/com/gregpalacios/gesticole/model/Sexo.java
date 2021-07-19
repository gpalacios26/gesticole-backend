package com.gregpalacios.gesticole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sexo")
public class Sexo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSexo;
	
	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(Integer idSexo) {
		this.idSexo = idSexo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Sexo [idSexo=" + idSexo + ", descripcion=" + descripcion + "]";
	}
}
