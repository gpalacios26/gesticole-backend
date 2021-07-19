package com.gregpalacios.gesticole.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gregpalacios.gesticole.dto.CursoCompetenciasDTO;
import com.gregpalacios.gesticole.exception.ModeloNotFoundException;
import com.gregpalacios.gesticole.model.Curso;
import com.gregpalacios.gesticole.service.ICursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	@Autowired
	private ICursoService service;
	
	@GetMapping
	public ResponseEntity<List<Curso>> listar() throws Exception {
		List<Curso> lista = service.listar();
		return new ResponseEntity<List<Curso>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Curso>> listarPageable(Pageable pageable) throws Exception {
		Page<Curso> lista = service.listarPageable(pageable);
		return new ResponseEntity<Page<Curso>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Curso obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Curso>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Curso> registrar(@Valid @RequestBody CursoCompetenciasDTO data) throws Exception {
		Curso obj = service.registrarTransaccional(data);
		return new ResponseEntity<Curso>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Curso> modificar(@Valid @RequestBody CursoCompetenciasDTO data) throws Exception {
		Curso obj = service.modificarTransaccional(data);
		return new ResponseEntity<Curso>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Curso obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminarTransaccional(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
