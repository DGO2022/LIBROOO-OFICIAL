package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.LectoresEntity;



public interface LectoresService {
	LectoresEntity create(LectoresEntity post);
	LectoresEntity update(LectoresEntity post);
	void delete(Long LectoresEntity);
	LectoresEntity read(Long LectoresEntity);
	List<LectoresEntity> readAll();
}
