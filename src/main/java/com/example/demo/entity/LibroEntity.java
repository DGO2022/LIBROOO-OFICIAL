package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Libros")

public class LibroEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ASIN")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqlibro")
    @SequenceGenerator(sequenceName = "seqlibro", allocationSize = 1, name = "seqlibro")
	private Long asin;
  
  	@Column(name = "TÍTULO")
  	private String título;
  	
  	@Column(name = "FECHA DE LANZAMIENTO")
  	private String fechadelanzamiento;
  	
  	@Column(name = "IDIOMA")
  	private String idioma;
  	
  	@Column(name = "PÁGINAS")
  	private int páginas;
  	
  	@Column(name = "DESCRIPCION")
  	private String descripcion;

  	@Column(name = "PORTADA")
  	private String portada;
  	
  	@ManyToOne
  	@JoinColumn(name="ID_EDITORIAL", nullable=false)
  	private EditorialesEntity editorialEntity;
  	
  	@ManyToOne
  	@JoinColumn(name="ID_AUTOR", nullable=false)
  	private AutoresEntity autorEntity;
  	
  	@ManyToOne
  	@JoinColumn(name="ID_CATEGORIA", nullable=false)
  	private CategoriaEntity categoriaEntity;

  	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "librosEntity")
  	@JsonIgnore
  	Set<AlquileresEntity> alquileresEntity;
}



	

