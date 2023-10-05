package com.example.demo.controller;

import static com.example.demo.commons.librocontans.API_EDITORIALES;

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
import com.example.demo.entity.EditorialesEntity;
import com.example.demo.service.EditorialesService;


@RestController
@RequestMapping(API_EDITORIALES)
public class EditorialesController {
	
	@Autowired
	private EditorialesService editorialesService;
	
	@GetMapping("/all")
	public List<EditorialesEntity> listar() {
		return editorialesService.readAll();
	}

	@GetMapping("/{id_editorilales}")
	public ResponseEntity<EditorialesEntity> listar2(@PathVariable("id_editorilales") long id_editorilales) {
		EditorialesEntity prod = editorialesService.read(id_editorilales);
		if (prod!=null) {
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/agregar")
	  public ResponseEntity<EditorialesEntity> createTutorial(@RequestBody EditorialesEntity p) {
	    try {
	    	EditorialesEntity prod = editorialesService.create(new EditorialesEntity(p.getId_editorilales(),p.getEditorial(),p.getLibrosEntity()));

	      return new ResponseEntity<>(prod, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/editar/{id_editorilales}")
	  public ResponseEntity<EditorialesEntity> updateTutorial(@PathVariable("id_editorilales") long id_editorilales, @RequestBody EditorialesEntity p) {
		EditorialesEntity post = editorialesService.read(id_editorilales);

	    if (post!=null) {
	    	post.setId_editorilales(p.getId_editorilales());
	    	post.setEditorial(p.getEditorial());
	    	post.setLibrosEntity(p.getLibrosEntity());
	      return new ResponseEntity<>(editorialesService.create(post), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/borrar/{id_editorilales}")
	  public ResponseEntity<HttpStatus> deletePost(@PathVariable("id_editorilales") long id_editorilales) {
	    try {
	    	editorialesService.delete(id_editorilales);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	
	
}