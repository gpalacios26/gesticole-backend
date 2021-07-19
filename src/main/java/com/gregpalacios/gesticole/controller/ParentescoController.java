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
import com.gregpalacios.gesticole.model.Parentesco;
import com.gregpalacios.gesticole.service.IParentescoService;

@RestController
@RequestMapping("/api/parentesco")
public class ParentescoController {

	@Autowired
	private IParentescoService service;
	
	@GetMapping
	public ResponseEntity<List<Parentesco>> listar() throws Exception {
		List<Parentesco> lista = service.listar();
		return new ResponseEntity<List<Parentesco>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Parentesco> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Parentesco obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Parentesco>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Parentesco> registrar(@Valid @RequestBody Parentesco data) throws Exception {
		Parentesco obj = service.registrar(data);
		return new ResponseEntity<Parentesco>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Parentesco> modificar(@Valid @RequestBody Parentesco data) throws Exception {
		Parentesco obj = service.modificar(data);
		return new ResponseEntity<Parentesco>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Parentesco obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
