package com.example.demo.controller;

import static com.example.demo.commons.librocontans.API_LECTORES;

import java.util.List;

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
import com.example.demo.entity.LectoresEntity;
import com.example.demo.service.LectoresService;


@RestController
@RequestMapping(API_LECTORES)
public class LectoresController {
	
	@Autowired
	private LectoresService lectoresService;
	
	@GetMapping("/all")
	public List<LectoresEntity> listar() {
		return lectoresService.readAll();
	}

	@GetMapping("/{dni_lector}")
	public ResponseEntity<LectoresEntity> listar2(@PathVariable("dni_lector") long dni_lector) {
		LectoresEntity prod = lectoresService.read(dni_lector);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<LectoresEntity> createTutorial(@RequestBody LectoresEntity p) {
	    try {
	    	LectoresEntity prod = lectoresService.create(new LectoresEntity(p.getDni_lector(),p.getNombre(), p.getTeléfono(),p.getDirección(),p.getCodigopostal(),p.getObservaciones(),p.getAlquileresEntity()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{dni_lector}")
	  public ResponseEntity<LectoresEntity> updateTutorial(@PathVariable("dni_lector") long dni_lector, @RequestBody LectoresEntity p) {
		LectoresEntity post = lectoresService.read(dni_lector);

	    if (post!=null) {
	    	post.setDni_lector(p.getDni_lector());
	    	post.setNombre(p.getNombre());
	    	post.setTeléfono(p.getTeléfono());
	    	post.setDirección(p.getDirección());
	    	post.setCodigopostal(p.getCodigopostal());
	    	post.setObservaciones(p.getObservaciones());
	    	post.setAlquileresEntity(p.getAlquileresEntity());
	      return new ResponseEntity<>(lectoresService.create(post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/borrar/{dni_lector}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("dni_lector") long dni_lector) {
	    try {
	    	lectoresService.delete(dni_lector);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	
	
}