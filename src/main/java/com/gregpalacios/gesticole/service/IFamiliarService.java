package com.gregpalacios.gesticole.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gregpalacios.gesticole.model.Familiar;

public interface IFamiliarService extends ICRUD<Familiar, Integer> {

	Page<Familiar> listarPageable(Pageable pageable);
}
