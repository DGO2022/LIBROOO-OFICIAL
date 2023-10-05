package com.example.demo.controller;

import static com.example.demo.commons.librocontans.API_AUTORES;


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
import com.example.demo.entity.AutoresEntity;
import com.example.demo.service.AutoresService;


@RestController
@RequestMapping(API_AUTORES)
public class AutoresController {
	
	@Autowired
	private AutoresService autoresService;
	
	@GetMapping("/all")
	public List<AutoresEntity> listar() {
		return autoresService.readAll();
	}

	@GetMapping("/{id_autor}")
	public ResponseEntity<AutoresEntity> listar2(@PathVariable("id_autor") long id_autor) {
		AutoresEntity prod = autoresService.read(id_autor);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<AutoresEntity> createTutorial(@RequestBody AutoresEntity p) {
	    try {
	    	AutoresEntity prod = autoresService.create(new AutoresEntity(p.getId_autor(),p.getAutor(),p.getLibrosEntity()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id_autor}")
	  public ResponseEntity<AutoresEntity> updateTutorial(@PathVariable("id_autor") long id_autor, @RequestBody AutoresEntity p) {
		AutoresEntity post = autoresService.read(id_autor);

	    if (post!=null) {
	    	post.setId_autor(p.getId_autor());
	    	post.setAutor(p.getAutor());
	    	post.setLibrosEntity(p.getLibrosEntity());
	      return new ResponseEntity<>(autoresService.create(post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/borrar/{id_autor}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id_autor") long id_autor) {
	    try {
	    	autoresService.delete(id_autor);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	
	
}