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

import com.gregpalacios.gesticole.dto.AsignacionAulaDTO;
import com.gregpalacios.gesticole.exception.ModeloNotFoundException;
import com.gregpalacios.gesticole.model.AsignacionAula;
import com.gregpalacios.gesticole.model.AsignacionAulaDetalle;
import com.gregpalacios.gesticole.service.IAsignacionAulaDetalleService;
import com.gregpalacios.gesticole.service.IAsignacionAulaService;

@RestController
@RequestMapping("/api/asignacion/aula")
public class AsignacionAulaController {

	@Autowired
	private IAsignacionAulaService service;

	@Autowired
	private IAsignacionAulaDetalleService serviceDet;

	@GetMapping
	public ResponseEntity<List<AsignacionAula>> listar() throws Exception {
		List<AsignacionAula> lista = service.listar();
		return new ResponseEntity<List<AsignacionAula>>(lista, HttpStatus.OK);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<AsignacionAula>> listarPageable(Pageable pageable) throws Exception {
		Page<AsignacionAula> lista = service.listarPageable(pageable);
		return new ResponseEntity<Page<AsignacionAula>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AsignacionAula> listarPorId(@PathVariable("id") Integer id) throws Exception {
		AsignacionAula obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<AsignacionAula>(obj, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<AsignacionAula> registrar(@Valid @RequestBody AsignacionAulaDTO data) throws Exception {
		data.getAsignacion().setFecha(LocalDateTime.now());
		AsignacionAula obj = service.registrarTransaccional(data);
		return new ResponseEntity<AsignacionAula>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<AsignacionAula> modificar(@Valid @RequestBody AsignacionAulaDTO data) throws Exception {
		data.getAsignacion().setFecha(LocalDateTime.now());
		AsignacionAula obj = service.modificarTransaccional(data);
		return new ResponseEntity<AsignacionAula>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		AsignacionAula obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminarTransaccional(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/detalle/{id}")
	public ResponseEntity<List<AsignacionAulaDetalle>> listarPorIdAsignacion(@PathVariable("id") Integer id)
			throws Exception {
		List<AsignacionAulaDetalle> lista = serviceDet.listarPorAsignacion(id);

		if (lista == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<List<AsignacionAulaDetalle>>(lista, HttpStatus.OK);
	}
}
