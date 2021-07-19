package com.gregpalacios.gesticole.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "asignacion_aula_detalle")
public class AsignacionAulaDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAsignacionDetalle;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_asignacion", nullable = false, foreignKey = @ForeignKey(name = "FK_asignacion_detalle_cabecera"))
	private AsignacionAula asignacion;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name = "FK_asignacion_detalle_curso"))
	private Curso curso;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_personal", nullable = false, foreignKey = @ForeignKey(name = "FK_asignacion_detalle_personal"))
	private Personal personal;

	public Integer getIdAsignacionDetalle() {
		return idAsignacionDetalle;
	}

	public void setIdAsignacionDetalle(Integer idAsignacionDetalle) {
		this.idAsignacionDetalle = idAsignacionDetalle;
	}

	public AsignacionAula getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(AsignacionAula asignacion) {
		this.asignacion = asignacion;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	@Override
	public String toString() {
		return "AsignacionAulaDetalle [idAsignacionDetalle=" + idAsignacionDetalle + ", asignacion=" + asignacion
				+ ", curso=" + curso + ", personal=" + personal + "]";
	}
}
