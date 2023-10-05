package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EditorialesEntity;
import com.example.demo.repository.EditorialesRepository;
import com.example.demo.service.EditorialesService;

@Service
public class EditorialesServiceImpl implements EditorialesService{

	
	@Autowired
	private EditorialesRepository EditorialesRepository;
	
	@Override
	public EditorialesEntity create(EditorialesEntity post) {
		// TODO Auto-generated method stub
		return EditorialesRepository.save(post);
	}

	@Override
	public EditorialesEntity update(EditorialesEntity post) {
		// TODO Auto-generated method stub
		return EditorialesRepository.save(post);
	}

	@Override
	public void delete(Long id_editorilales) {
		// TODO Auto-generated method stub
		EditorialesRepository.deleteById(id_editorilales);
		
	}

	@Override
	public EditorialesEntity read(Long id_editorilales) {
		// TODO Auto-generated method stub
		return EditorialesRepository.findById(id_editorilales).get();
	}

	@Override
	public List<EditorialesEntity> readAll() {
		// TODO Auto-generated method stub
		return EditorialesRepository.findAll();
	}
	

}