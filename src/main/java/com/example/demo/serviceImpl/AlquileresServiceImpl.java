package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AlquileresEntity;
import com.example.demo.repository.AlquileresRepository;
import com.example.demo.service.AlquileresService;

@Service
public class AlquileresServiceImpl implements AlquileresService{

	
	@Autowired
	private AlquileresRepository AlquileresRepository;
	
	@Override
	public AlquileresEntity create(AlquileresEntity post) {
		// TODO Auto-generated method stub
		return AlquileresRepository.save(post);
	}

	@Override
	public AlquileresEntity update(AlquileresEntity post) {
		// TODO Auto-generated method stub
		return AlquileresRepository.save(post);
	}

	@Override
	public void delete(Long id_alquileres) {
		// TODO Auto-generated method stub
		AlquileresRepository.deleteById(id_alquileres);
		
	}

	@Override
	public AlquileresEntity read(Long id_alquileres) {
		// TODO Auto-generated method stub
		return AlquileresRepository.findById(id_alquileres).get();
	}

	@Override
	public List<AlquileresEntity> readAll() {
		// TODO Auto-generated method stub
		return AlquileresRepository.findAll();
	}
	

}