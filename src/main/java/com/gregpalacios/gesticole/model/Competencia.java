package com.gregpalacios.gesticole.model;

import javax.persistence.Column;
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
@Table(name = "competencia")
public class Competencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompetencia;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name = "FK_competencia_curso"))
	private Curso curso;
	
	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdCompetencia() {
		return idCompetencia;
	}

	public void setIdCompetencia(Integer idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Competencia [idCompetencia=" + idCompetencia + ", curso=" + curso + ", descripcion=" + descripcion
				+ "]";
	}
}
