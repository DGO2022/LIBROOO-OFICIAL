package com.example.demo.controller;

import static com.example.demo.commons.librocontans.API_LIBRO;

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
import com.example.demo.entity.LibroEntity;
import com.example.demo.service.LibroService;


@RestController
@RequestMapping(API_LIBRO)
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/all")
	public List<LibroEntity> listar() {
		return libroService.readAll();
	}

	@GetMapping("/{asin}")
	public ResponseEntity<LibroEntity> listar2(@PathVariable("asin") long asin) {
		LibroEntity prod = libroService.read(asin);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<LibroEntity> createTutorial(@RequestBody LibroEntity p) {
	    try {
	    	LibroEntity prod = libroService.create(new LibroEntity(p.getAsin(),p.getTítulo(),p.getFechadelanzamiento(),p.getIdioma(),p.getPáginas(),p.getDescripcion(),p.getPortada(),p.getEditorialEntity(),p.getAutorEntity(),p.getCategoriaEntity(),p.getAlquileresEntity()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{asin}")
	  public ResponseEntity<LibroEntity> updateTutorial(@PathVariable("asin") long asin, @RequestBody LibroEntity p) {
		LibroEntity post = libroService.read(asin);

	    if (post!=null) {
	    	post.setAsin(p.getAsin());
	    	post.setTítulo(p.getTítulo());
	    	post.setFechadelanzamiento(p.getFechadelanzamiento());
	    	post.setAutorEntity(p.getAutorEntity());
	    	post.setCategoriaEntity(p.getCategoriaEntity());
	    	post.setEditorialEntity(p.getEditorialEntity());
	    	post.setIdioma(p.getIdioma());
	    	post.setPáginas(p.getPáginas());
	    	post.setDescripcion(p.getDescripcion());
	    	post.setPortada(p.getPortada());
	    	post.setAlquileresEntity(p.getAlquileresEntity());
	      return new ResponseEntity<>(libroService.create(post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/borrar/{asin}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("asin") long asin) {
	    try {
	    	libroService.delete(asin);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	
	
}