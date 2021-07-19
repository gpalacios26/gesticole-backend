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
import com.gregpalacios.gesticole.model.Personal;
import com.gregpalacios.gesticole.service.IPersonalService;
import com.gregpalacios.gesticole.util.ExcelGeneratorPersonal;
import com.gregpalacios.gesticole.util.FileDTO;
import com.gregpalacios.gesticole.util.FileUtil;
import com.gregpalacios.gesticole.util.PdfGeneratorPersonal;

@RestController
@RequestMapping("/api/personal")
public class PersonalController {

	@Value("${upload.path.personal}")
	private String basePath;
	
	@Autowired
	private IPersonalService service;
	
	@GetMapping
	public ResponseEntity<List<Personal>> listar() throws Exception {
		List<Personal> lista = service.listar();
		return new ResponseEntity<List<Personal>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Personal>> listarPageable(Pageable pageable) throws Exception {
		Page<Personal> lista = service.listarPageable(pageable);
		return new ResponseEntity<Page<Personal>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Personal> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Personal obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		return new ResponseEntity<Personal>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Personal> registrar(@Valid @RequestBody Personal data) throws Exception {
		Personal obj = service.registrar(data);
		return new ResponseEntity<Personal>(obj, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Personal> modificar(@Valid @RequestBody Personal data) throws Exception {
		Personal obj = service.modificar(data);
		return new ResponseEntity<Personal>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Personal obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/foto/{id}")
	public ResponseEntity<Personal> cargarFoto(@PathVariable("id") Integer id, @RequestBody FileDTO fileDTO) throws Exception, IOException {
		Personal obj = service.listarPorId(id);

		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		fileDTO.setFilePath(basePath);
		String fileName = FileUtil.createFileFromBase64(fileDTO);
		
		obj.setFoto(fileName);
		service.modificar(obj);

		return new ResponseEntity<Personal>(obj, HttpStatus.OK);
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
		List<Personal> lista = service.listar();
    
	    ByteArrayInputStream in = ExcelGeneratorPersonal.listadoToExcel(lista);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attachment; filename=personal.xlsx");
	    
	    return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }
	
	@GetMapping("/descargar/ficha/{id}")
	public ResponseEntity<InputStreamResource> descargarFicha(@PathVariable("id") Integer id) throws Exception, IOException {
		Personal obj = service.listarPorId(id);
		
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
    
	    ByteArrayInputStream in = PdfGeneratorPersonal.objetoToPdf(obj, basePath);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Disposition", "attachment; filename=personal.pdf");
	    
	    return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }
}
