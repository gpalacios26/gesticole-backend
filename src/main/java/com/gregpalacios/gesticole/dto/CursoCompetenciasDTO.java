package com.gregpalacios.gesticole.dto;

import java.util.List;

import com.gregpalacios.gesticole.model.Competencia;
import com.gregpalacios.gesticole.model.Curso;

public class CursoCompetenciasDTO {

	private Curso curso;
	
	private List<Competencia> competencias;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Competencia> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<Competencia> competencias) {
		this.competencias = competencias;
	}
}
