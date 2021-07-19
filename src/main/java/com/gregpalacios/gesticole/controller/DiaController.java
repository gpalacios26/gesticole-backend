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
import com.gregpalacios.gesticole.model.Dia;
import com.gregpalacios.gesticole.service.IDiaService;

@RestController
@RequestMapping("/api/dias")
public class DiaController {

	@Autowired
	private IDiaService service;
	
	@GetMapping
	public ResponseEntity<List<Dia>> listar() throws Exception {
		List<Dia> lista = service.listar();
		return new ResponseEntity<List<Dia>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dia> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Dia obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Dia>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Dia> registrar(@Valid @RequestBody Dia data) throws Exception {
		Dia obj = service.registrar(data);
		return new ResponseEntity<Dia>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Dia> modificar(@Valid @RequestBody Dia data) throws Exception {
		Dia obj = service.modificar(data);
		return new ResponseEntity<Dia>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Dia obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
