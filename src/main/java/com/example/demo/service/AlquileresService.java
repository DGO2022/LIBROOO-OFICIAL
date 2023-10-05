package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AlquileresEntity;



public interface AlquileresService {
	AlquileresEntity create(AlquileresEntity post);
	AlquileresEntity update(AlquileresEntity post);
	void delete(Long id_alquileres);
	AlquileresEntity read(Long id_alquileres);
	List<AlquileresEntity> readAll();
}

