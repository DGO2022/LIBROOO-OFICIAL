package com.example.demo.controller;

import static com.example.demo.commons.librocontans.API_ALQUILERES;

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
import com.example.demo.entity.AlquileresEntity;
import com.example.demo.service.AlquileresService;


@RestController
@RequestMapping(API_ALQUILERES)
public class AlquileresController {
	
	@Autowired
	private AlquileresService alquileresService;
	
	@GetMapping("/all")
	public List<AlquileresEntity> listar() {
		return alquileresService.readAll();
	}

	@GetMapping("/{id_alquileres}")
	public ResponseEntity<AlquileresEntity> listar2(@PathVariable("id_alquileres") long id_alquileres) {
		AlquileresEntity prod = alquileresService.read(id_alquileres);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<AlquileresEntity> createTutorial(@RequestBody AlquileresEntity p) {
	    try {
	    	AlquileresEntity prod = alquileresService.create(new AlquileresEntity(p.getId_alquileres(),p.getFechasalida(), p.getFechaentrada(),p.getLectoresEntity(),p.getLibrosEntity()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id_alquileres}")
	  public ResponseEntity<AlquileresEntity> updateTutorial(@PathVariable("id_alquileres") long id_alquileres, @RequestBody AlquileresEntity p) {
		AlquileresEntity post = alquileresService.read(id_alquileres);

	    if (post!=null) {
	    	post.setId_alquileres(p.getId_alquileres());
	    	post.setFechasalida(p.getFechasalida());
	    	post.setFechaentrada(p.getFechaentrada());
	    	post.setLectoresEntity(p.getLectoresEntity());
	    	post.setLibrosEntity(p.getLibrosEntity());
	      return new ResponseEntity<>(alquileresService.create(post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/borrar/{id_alquileres}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id_alquileres") long id_alquileres) {
	    try {
	    	alquileresService.delete(id_alquileres);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	
	
}