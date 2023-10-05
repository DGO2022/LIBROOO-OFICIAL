package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AutoresEntity;


public interface AutoresService {
	AutoresEntity create(AutoresEntity post);
	AutoresEntity update(AutoresEntity post);
	void delete(Long id_autor);
	AutoresEntity read(Long id_autor);
	List<AutoresEntity> readAll();
}

