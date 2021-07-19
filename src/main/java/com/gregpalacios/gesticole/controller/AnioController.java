package com.gregpalacios.gesticole.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.gregpalacios.gesticole.model.Anio;
import com.gregpalacios.gesticole.service.IAnioService;

@RestController
@RequestMapping("/api/anios")
public class AnioController {
	
	@Autowired
	private IAnioService service;
	
	@GetMapping
	public ResponseEntity<List<Anio>> listar() throws Exception {
		List<Anio> lista = service.listar();
		return new ResponseEntity<List<Anio>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Anio> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Anio obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Anio>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Anio> registrar(@Valid @RequestBody Anio data) throws Exception {
		Anio obj = service.registrar(data);
		return new ResponseEntity<Anio>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Anio> modificar(@Valid @RequestBody Anio data) throws Exception {
		Anio obj = service.modificar(data);
		return new ResponseEntity<Anio>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Anio obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
