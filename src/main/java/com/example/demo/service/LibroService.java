package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LibroEntity;


public interface LibroService {
	LibroEntity create(LibroEntity post);
	LibroEntity update(LibroEntity post);
	void delete(Long asin);
	LibroEntity read(Long asin);
	List<LibroEntity> readAll();
}
