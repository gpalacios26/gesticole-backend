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
@Table(name = "matricula_aula_detalle")
public class MatriculaAulaDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMatriculaDetalle;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_matricula", nullable = false, foreignKey = @ForeignKey(name = "FK_matricula_detalle_cabecera"))
	private MatriculaAula matricula;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_alumno", nullable = false, foreignKey = @ForeignKey(name = "FK_matricula_detalle_alumno"))
	private Alumno alumno;

	public Integer getIdMatriculaDetalle() {
		return idMatriculaDetalle;
	}

	public void setIdMatriculaDetalle(Integer idMatriculaDetalle) {
		this.idMatriculaDetalle = idMatriculaDetalle;
	}

	public MatriculaAula getMatricula() {
		return matricula;
	}

	public void setMatricula(MatriculaAula matricula) {
		this.matricula = matricula;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		return "MatriculaAulaDetalle [idMatriculaDetalle=" + idMatriculaDetalle + ", matricula=" + matricula
				+ ", alumno=" + alumno + "]";
	}
}
