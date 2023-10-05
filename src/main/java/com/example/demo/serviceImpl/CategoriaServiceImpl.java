package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoriaEntity;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	
	@Autowired
	private CategoriaRepository CategoriaRepository;
	
	@Override
	public CategoriaEntity create(CategoriaEntity post) {
		// TODO Auto-generated method stub
		return CategoriaRepository.save(post);
	}

	@Override
	public CategoriaEntity update(CategoriaEntity post) {
		// TODO Auto-generated method stub
		return CategoriaRepository.save(post);
	}

	@Override
	public void delete(Long id_categoria) {
		// TODO Auto-generated method stub
		CategoriaRepository.deleteById(id_categoria);
		
	}

	@Override
	public CategoriaEntity read(Long id_categoria) {
		// TODO Auto-generated method stub
		return CategoriaRepository.findById(id_categoria).get();
	}

	@Override
	public List<CategoriaEntity> readAll() {
		// TODO Auto-generated method stub
		return CategoriaRepository.findAll();
	}
	

}