package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EditorialesEntity;



public interface EditorialesService {
	EditorialesEntity create(EditorialesEntity post);
	EditorialesEntity update(EditorialesEntity post);
	void delete(Long id_editorilales);
	EditorialesEntity read(Long id_editorilales);
	List<EditorialesEntity> readAll();
}
