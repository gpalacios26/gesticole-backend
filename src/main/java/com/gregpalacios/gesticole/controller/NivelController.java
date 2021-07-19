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
import com.gregpalacios.gesticole.model.Nivel;
import com.gregpalacios.gesticole.service.INivelService;

@RestController
@RequestMapping("/api/niveles")
public class NivelController {

	@Autowired
	private INivelService service;
	
	@GetMapping
	public ResponseEntity<List<Nivel>> listar() throws Exception {
		List<Nivel> lista = service.listar();
		return new ResponseEntity<List<Nivel>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Nivel> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Nivel obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Nivel>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Nivel> registrar(@Valid @RequestBody Nivel data) throws Exception {
		Nivel obj = service.registrar(data);
		return new ResponseEntity<Nivel>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Nivel> modificar(@Valid @RequestBody Nivel data) throws Exception {
		Nivel obj = service.modificar(data);
		return new ResponseEntity<Nivel>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Nivel obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
