package com.gregpalacios.gesticole.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
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
import com.gregpalacios.gesticole.model.Familiar;
import com.gregpalacios.gesticole.service.IFamiliarService;
import com.gregpalacios.gesticole.util.ExcelGeneratorFamiliar;
import com.gregpalacios.gesticole.util.FileDTO;
import com.gregpalacios.gesticole.util.FileUtil;
import com.gregpalacios.gesticole.util.PdfGeneratorFamiliar;

@RestController
@RequestMapping("/api/familiares")
public class FamiliarController {

	@Value("${upload.path.familiar}")
	private String basePath;
	
	@Autowired
	private IFamiliarService service;
	
	@GetMapping
	public ResponseEntity<List<Familiar>> listar() throws Exception {
		List<Familiar> lista = service.listar();
		return new ResponseEntity<List<Familiar>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Familiar>> listarPageable(Pageable pageable) throws Exception {
		Page<Familiar> lista = service.listarPageable(pageable);
		return new ResponseEntity<Page<Familiar>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Familiar> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Familiar obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Familiar>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Familiar> registrar(@Valid @RequestBody Familiar data) throws Exception {
		Familiar obj = service.registrar(data);
		return new ResponseEntity<Familiar>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Familiar> modificar(@Valid @RequestBody Familiar data) throws Exception {
		Familiar obj = service.modificar(data);
		return new ResponseEntity<Familiar>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Familiar obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/foto/{id}")
	public ResponseEntity<Familiar> cargarFoto(@PathVariable("id") Integer id, @RequestBody FileDTO fileDTO) throws Exception, IOException {
		Familiar obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		fileDTO.setFilePath(basePath);
		String fileName = FileUtil.createFileFromBase64(fileDTO);
		
		obj.setFoto(fileName);
		service.modificar(obj);

		return new ResponseEntity<Familiar>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/foto/{name}")
	public ResponseEntity<InputStreamResource> verFoto(@PathVariable("name") String name) throws Exception, IOException {
	    
		File file = new File(basePath+name);
		InputStream in = new FileInputStream(file.getPath());
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename="+name);
	    
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
	}
	
	@GetMapping("/descargar")
	public ResponseEntity<InputStreamResource> descargar() throws Exception, IOException {
		List<Familiar> lista = service.listar();
    
	    ByteArrayInputStream in = ExcelGeneratorFamiliar.listadoToExcel(lista);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attachment; filename=familiares.xlsx");
	    
	    return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }
	
	@GetMapping("/descargar/ficha/{id}")
	public ResponseEntity<InputStreamResource> descargarFicha(@PathVariable("id") Integer id) throws Exception, IOException {
		Familiar obj = service.listarPorId(id);
		
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
    
	    ByteArrayInputStream in = PdfGeneratorFamiliar.objetoToPdf(obj, basePath);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attachment; filename=familiar.pdf");
	    
	    return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }
}
