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
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCurso;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_anio", nullable = false, foreignKey = @ForeignKey(name = "FK_curso_anio"))
	private Anio anio;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_nivel", nullable = false, foreignKey = @ForeignKey(name = "FK_curso_nivel"))
	private Nivel nivel;
	
	@Column(name = "descripcion")
	private String descripcion;

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Anio getAnio() {
		return anio;
	}

	public void setAnio(Anio anio) {
		this.anio = anio;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Curso [idCurso=" + idCurso + ", anio=" + anio + ", nivel=" + nivel + ", descripcion=" + descripcion
				+ "]";
	}
}
