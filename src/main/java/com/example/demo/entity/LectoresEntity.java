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
@Table(name="Lectores")

public class LectoresEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "DNI_LECTOR")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqlectores")
    @SequenceGenerator(sequenceName = "seqlectores", allocationSize = 1, name = "seqlectores")
	private Long dni_lector;
  
  	@Column(name = "NOMBRE")
  	private String nombre;
  	
  	@Column(name = "TELEFONO")
  	private String teléfono;
  	
  	@Column(name = "DIRECCIÓN")
  	private String dirección;
  	
  	@Column(name = "CODIGO POSTAL")
  	private String codigopostal;
  	
  	@Column(name = "OBSERVACIONES")
  	private String observaciones;
  	
  	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "lectoresEntity")
  	@JsonIgnore
  	Set<AlquileresEntity> alquileresEntity;
}


