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
import com.gregpalacios.gesticole.model.Competencia;
import com.gregpalacios.gesticole.service.ICompetenciaService;

@RestController
@RequestMapping("/api/competencias")
public class CompetenciaController {

	@Autowired
	private ICompetenciaService service;
	
	@GetMapping
	public ResponseEntity<List<Competencia>> listar() throws Exception {
		List<Competencia> lista = service.listar();
		return new ResponseEntity<List<Competencia>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Competencia> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Competencia obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Competencia>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/curso/{idCurso}")
	public ResponseEntity<List<Competencia>> listarPorCurso(@PathVariable("idCurso") Integer idCurso) throws Exception {
		List<Competencia> lista = service.listarPorCurso(idCurso);
		return new ResponseEntity<List<Competencia>>(lista, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Competencia> registrar(@Valid @RequestBody Competencia data) throws Exception {
		Competencia obj = service.registrar(data);
		return new ResponseEntity<Competencia>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Competencia> modificar(@Valid @RequestBody Competencia data) throws Exception {
		Competencia obj = service.modificar(data);
		return new ResponseEntity<Competencia>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Competencia obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
