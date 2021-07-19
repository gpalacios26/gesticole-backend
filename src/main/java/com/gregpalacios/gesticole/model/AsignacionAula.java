package com.gregpalacios.gesticole.model;

import java.time.LocalDateTime;

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
@Table(name = "asignacion_aula")
public class AsignacionAula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAsignacion;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_aula", nullable = false, foreignKey = @ForeignKey(name = "FK_asignacion_aula"))
	private Aula aula;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_asignacion_usuario"))
	private Usuario usuario;
	
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;

	public Integer getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(Integer idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "AsignacionAula [idAsignacion=" + idAsignacion + ", aula=" + aula + ", usuario=" + usuario + ", fecha="
				+ fecha + "]";
	}
}
