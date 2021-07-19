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
@Table(name = "aula")
public class Aula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAula;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_anio", nullable = false, foreignKey = @ForeignKey(name = "FK_aula_anio"))
	private Anio anio;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_nivel", nullable = false, foreignKey = @ForeignKey(name = "FK_aula_nivel"))
	private Nivel nivel;

	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "vacantes", nullable = false)
	private Integer vacantes;

	public Integer getIdAula() {
		return idAula;
	}

	public void setIdAula(Integer idAula) {
		this.idAula = idAula;
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

	public Integer getVacantes() {
		return vacantes;
	}

	public void setVacantes(Integer vacantes) {
		this.vacantes = vacantes;
	}

	@Override
	public String toString() {
		return "Aula [idAula=" + idAula + ", anio=" + anio + ", nivel=" + nivel + ", descripcion=" + descripcion
				+ ", vacantes=" + vacantes + "]";
	}
}
