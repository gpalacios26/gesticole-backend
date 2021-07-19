package com.gregpalacios.gesticole.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_personal")
public class TipoPersonal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoPersonal;
	
	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdTipoPersonal() {
		return idTipoPersonal;
	}

	public void setIdTipoPersonal(Integer idTipoPersonal) {
		this.idTipoPersonal = idTipoPersonal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoPersonal [idTipoPersonal=" + idTipoPersonal + ", descripcion=" + descripcion + "]";
	}
}
