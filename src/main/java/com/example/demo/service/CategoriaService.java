package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.CategoriaEntity;


public interface CategoriaService {
	CategoriaEntity create(CategoriaEntity post);
	CategoriaEntity update(CategoriaEntity post);
	void delete(Long id_categoria);
	CategoriaEntity read(Long id_categoria);
	List<CategoriaEntity> readAll();
}
