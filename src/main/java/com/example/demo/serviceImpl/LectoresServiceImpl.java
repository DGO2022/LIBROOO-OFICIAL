package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LectoresEntity;
import com.example.demo.repository.LectoresRepository;
import com.example.demo.service.LectoresService;

@Service
public class LectoresServiceImpl implements LectoresService{

	
	@Autowired
	private LectoresRepository LectoresRepository;
	
	@Override
	public LectoresEntity create(LectoresEntity post) {
		// TODO Auto-generated method stub
		return LectoresRepository.save(post);
	}

	@Override
	public LectoresEntity update(LectoresEntity post) {
		// TODO Auto-generated method stub
		return LectoresRepository.save(post);
	}

	@Override
	public void delete(Long dni_lector) {
		// TODO Auto-generated method stub
		LectoresRepository.deleteById(dni_lector);
		
	}

	@Override
	public LectoresEntity read(Long dni_lector) {
		// TODO Auto-generated method stub
		return LectoresRepository.findById(dni_lector).get();
	}

	@Override
	public List<LectoresEntity> readAll() {
		// TODO Auto-generated method stub
		return LectoresRepository.findAll();
	}
	

}