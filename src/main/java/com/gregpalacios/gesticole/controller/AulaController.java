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

import com.gregpalacios.gesticole.exception.ModeloNotFoundException;
import com.gregpalacios.gesticole.model.Aula;
import com.gregpalacios.gesticole.service.IAulaService;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

	@Autowired
	private IAulaService service;
	
	@GetMapping
	public ResponseEntity<List<Aula>> listar() throws Exception {
		List<Aula> lista = service.listar();
		return new ResponseEntity<List<Aula>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Aula>> listarPageable(Pageable pageable) throws Exception {
		Page<Aula> lista = service.listarPageable(pageable);
		return new ResponseEntity<Page<Aula>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aula> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Aula obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Aula>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Aula> registrar(@Valid @RequestBody Aula data) throws Exception {
		Aula obj = service.registrar(data);
		return new ResponseEntity<Aula>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Aula> modificar(@Valid @RequestBody Aula data) throws Exception {
		Aula obj = service.modificar(data);
		return new ResponseEntity<Aula>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Aula obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
