package com.gregpalacios.gesticole.controller;

import java.time.LocalDateTime;
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

import com.gregpalacios.gesticole.dto.MatriculaAulaDTO;
import com.gregpalacios.gesticole.exception.ModeloNotFoundException;
import com.gregpalacios.gesticole.model.MatriculaAula;
import com.gregpalacios.gesticole.model.MatriculaAulaDetalle;
import com.gregpalacios.gesticole.service.IMatriculaAulaDetalleService;
import com.gregpalacios.gesticole.service.IMatriculaAulaService;

@RestController
@RequestMapping("/api/matricula/aula")
public class MatriculaAulaController {

	@Autowired
	private IMatriculaAulaService service;

	@Autowired
	private IMatriculaAulaDetalleService serviceDet;

	@GetMapping
	public ResponseEntity<List<MatriculaAula>> listar() throws Exception {
		List<MatriculaAula> lista = service.listar();
		return new ResponseEntity<List<MatriculaAula>>(lista, HttpStatus.OK);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<MatriculaAula>> listarPageable(Pageable pageable) throws Exception {
		Page<MatriculaAula> lista = service.listarPageable(pageable);
		return new ResponseEntity<Page<MatriculaAula>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MatriculaAula> listarPorId(@PathVariable("id") Integer id) throws Exception {
		MatriculaAula obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<MatriculaAula>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<MatriculaAula> registrar(@Valid @RequestBody MatriculaAulaDTO data) throws Exception {
		data.getMatricula().setFecha(LocalDateTime.now());
		MatriculaAula obj = service.registrarTransaccional(data);
		return new ResponseEntity<MatriculaAula>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<MatriculaAula> modificar(@Valid @RequestBody MatriculaAulaDTO data) throws Exception {
		data.getMatricula().setFecha(LocalDateTime.now());
		MatriculaAula obj = service.modificarTransaccional(data);
		return new ResponseEntity<MatriculaAula>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		MatriculaAula obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminarTransaccional(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/detalle/{id}")
	public ResponseEntity<List<MatriculaAulaDetalle>> listarPorIdMatricula(@PathVariable("id") Integer id)
			throws Exception {
		List<MatriculaAulaDetalle> lista = serviceDet.listarPorMatricula(id);

		if (lista == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<List<MatriculaAulaDetalle>>(lista, HttpStatus.OK);
	}
}
