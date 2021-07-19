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
import com.gregpalacios.gesticole.model.TipoDocumento;
import com.gregpalacios.gesticole.service.ITipoDocumentoService;

@RestController
@RequestMapping("/api/tipo-documento")
public class TipoDocumentoController {

	@Autowired
	private ITipoDocumentoService service;
	
	@GetMapping
	public ResponseEntity<List<TipoDocumento>> listar() throws Exception {
		List<TipoDocumento> lista = service.listar();
		return new ResponseEntity<List<TipoDocumento>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoDocumento> listarPorId(@PathVariable("id") Integer id) throws Exception {
		TipoDocumento obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<TipoDocumento>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TipoDocumento> registrar(@Valid @RequestBody TipoDocumento data) throws Exception {
		TipoDocumento obj = service.registrar(data);
		return new ResponseEntity<TipoDocumento>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<TipoDocumento> modificar(@Valid @RequestBody TipoDocumento data) throws Exception {
		TipoDocumento obj = service.modificar(data);
		return new ResponseEntity<TipoDocumento>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		TipoDocumento obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
