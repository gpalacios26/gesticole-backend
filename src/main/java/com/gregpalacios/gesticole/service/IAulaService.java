package com.gregpalacios.gesticole.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gregpalacios.gesticole.model.Aula;

public interface IAulaService extends ICRUD<Aula, Integer> {

	Page<Aula> listarPageable(Pageable pageable);
}
