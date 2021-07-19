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
import com.gregpalacios.gesticole.model.Sexo;
import com.gregpalacios.gesticole.service.ISexoService;

@RestController
@RequestMapping("/api/sexo")
public class SexoController {

	@Autowired
	private ISexoService service;
	
	@GetMapping
	public ResponseEntity<List<Sexo>> listar() throws Exception {
		List<Sexo> lista = service.listar();
		return new ResponseEntity<List<Sexo>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sexo> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Sexo obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Sexo>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Sexo> registrar(@Valid @RequestBody Sexo data) throws Exception {
		Sexo obj = service.registrar(data);
		return new ResponseEntity<Sexo>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Sexo> modificar(@Valid @RequestBody Sexo data) throws Exception {
		Sexo obj = service.modificar(data);
		return new ResponseEntity<Sexo>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Sexo obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
