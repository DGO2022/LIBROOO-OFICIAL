package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Alquileres")

public class AlquileresEntity implements Serializable{
	private static final long serialVersionUID = -2170897015344177815L;

	@Id
  	@Column(name = "ID_ALQUILERES")
  	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqalquileres")
    @SequenceGenerator(sequenceName = "seqalquileres", allocationSize = 1, name = "seqalquileres")
	private Long id_alquileres;
  
  	@Column(name = "FECHA SALIDA")
  	private String fechasalida;
  	
  	@Column(name = "FECHA ENTRADA")
  	private String fechaentrada;
  	
  	@ManyToOne
  	@JoinColumn(name="DNI_LECTOR", nullable=false)
  	private LectoresEntity lectoresEntity;
  	
  	@ManyToOne
  	@JoinColumn(name="ASIN", nullable=false)
  	private LibroEntity librosEntity;
  	
  	

}


