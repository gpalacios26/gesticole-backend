package com.gregpalacios.gesticole.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gregpalacios.gesticole.model.Alumno;

public interface IAlumnoService extends ICRUD<Alumno, Integer> {

	Page<Alumno> listarPageable(Pageable pageable);
}
