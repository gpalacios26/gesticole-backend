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
import com.gregpalacios.gesticole.model.TipoPersonal;
import com.gregpalacios.gesticole.service.ITipoPersonalService;

@RestController
@RequestMapping("/api/tipo-personal")
public class TipoPersonalController {

	@Autowired
	private ITipoPersonalService service;
	
	@GetMapping
	public ResponseEntity<List<TipoPersonal>> listar() throws Exception {
		List<TipoPersonal> lista = service.listar();
		return new ResponseEntity<List<TipoPersonal>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoPersonal> listarPorId(@PathVariable("id") Integer id) throws Exception {
		TipoPersonal obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<TipoPersonal>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TipoPersonal> registrar(@Valid @RequestBody TipoPersonal data) throws Exception {
		TipoPersonal obj = service.registrar(data);
		return new ResponseEntity<TipoPersonal>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<TipoPersonal> modificar(@Valid @RequestBody TipoPersonal data) throws Exception {
		TipoPersonal obj = service.modificar(data);
		return new ResponseEntity<TipoPersonal>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		TipoPersonal obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
