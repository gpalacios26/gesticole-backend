package com.gregpalacios.gesticole.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gregpalacios.gesticole.model.Personal;

public interface IPersonalService extends ICRUD<Personal, Integer> {

	Page<Personal> listarPageable(Pageable pageable);
}
