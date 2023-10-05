package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LibroEntity;
import com.example.demo.repository.LibroRepository;
import com.example.demo.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService{

	
	@Autowired
	private LibroRepository LibroRepository;
	
	@Override
	public LibroEntity create(LibroEntity post) {
		// TODO Auto-generated method stub
		return LibroRepository.save(post);
	}

	@Override
	public LibroEntity update(LibroEntity post) {
		// TODO Auto-generated method stub
		return LibroRepository.save(post);
	}

	@Override
	public void delete(Long asin) {
		// TODO Auto-generated method stub
		LibroRepository.deleteById(asin);
		
	}

	@Override
	public LibroEntity read(Long asin) {
		// TODO Auto-generated method stub
		return LibroRepository.findById(asin).get();
	}

	@Override
	public List<LibroEntity> readAll() {
		// TODO Auto-generated method stub
		return LibroRepository.findAll();
	}
	

}