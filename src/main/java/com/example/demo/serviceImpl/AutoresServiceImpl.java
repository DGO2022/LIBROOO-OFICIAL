package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AutoresEntity;
import com.example.demo.repository.AutoresRepository;
import com.example.demo.service.AutoresService;

@Service
public class AutoresServiceImpl implements AutoresService{

	
	@Autowired
	private AutoresRepository AutoresRepository;
	
	@Override
	public AutoresEntity create(AutoresEntity post) {
		// TODO Auto-generated method stub
		return AutoresRepository.save(post);
	}

	@Override
	public AutoresEntity update(AutoresEntity post) {
		// TODO Auto-generated method stub
		return AutoresRepository.save(post);
	}

	@Override
	public void delete(Long id_autor) {
		// TODO Auto-generated method stub
		AutoresRepository.deleteById(id_autor);
		
	}

	@Override
	public AutoresEntity read(Long id_autor) {
		// TODO Auto-generated method stub
		return AutoresRepository.findById(id_autor).get();
	}

	@Override
	public List<AutoresEntity> readAll() {
		// TODO Auto-generated method stub
		return AutoresRepository.findAll();
	}
	

}