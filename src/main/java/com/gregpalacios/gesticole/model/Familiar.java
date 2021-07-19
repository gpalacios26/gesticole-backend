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
@Table(name = "familiar")
public class Familiar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFamiliar;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_alumno", nullable = false, foreignKey = @ForeignKey(name = "FK_familiar_alumno"))
	private Alumno alumno;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_parentesco", nullable = false, foreignKey = @ForeignKey(name = "FK_familiar_parentesco"))
	private Parentesco parentesco;
	
	@Column(name = "nombres", nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false)
	private String apellidos;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_tipo_doc", nullable = false, foreignKey = @ForeignKey(name = "FK_familiar_tipo_doc"))
	private TipoDocumento tipoDocumento;
	
	@Column(name = "num_doc", nullable = false)
	private String numDocumento;
	
	@Column(name = "fecha_nac", nullable = false)
	private LocalDateTime fechaNac;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_sexo", nullable = false, foreignKey = @ForeignKey(name = "FK_familiar_sexo"))
	private Sexo sexo;
	
	@Column(name = "tel_celular", nullable = false)
	private String telCelular;
	
	@Column(name = "tel_fijo")
	private String telFijo;
	
	@Column(name = "correo", nullable = false, unique = true)
	private String correo;
	
	@Column(name = "foto")
	private String foto;

	@Column(name = "contacto_emergencia", nullable = false)
	private boolean contactoEmergencia;

	public Integer getIdFamiliar() {
		return idFamiliar;
	}

	public void setIdFamiliar(Integer idFamiliar) {
		this.idFamiliar = idFamiliar;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public LocalDateTime getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDateTime fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	public String getTelFijo() {
		return telFijo;
	}

	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public boolean isContactoEmergencia() {
		return contactoEmergencia;
	}

	public void setContactoEmergencia(boolean contactoEmergencia) {
		this.contactoEmergencia = contactoEmergencia;
	}

	@Override
	public String toString() {
		return "Familiar [idFamiliar=" + idFamiliar + ", alumno=" + alumno + ", parentesco=" + parentesco + ", nombres="
				+ nombres + ", apellidos=" + apellidos + ", tipoDocumento=" + tipoDocumento + ", numDocumento="
				+ numDocumento + ", fechaNac=" + fechaNac + ", sexo=" + sexo + ", telCelular=" + telCelular
				+ ", telFijo=" + telFijo + ", correo=" + correo + ", foto=" + foto + ", contactoEmergencia="
				+ contactoEmergencia + "]";
	}
}
