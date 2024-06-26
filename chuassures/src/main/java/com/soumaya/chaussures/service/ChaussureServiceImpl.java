package com.soumaya.chaussures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.soumaya.chaussures.entities.Chaussure;
import com.soumaya.chaussures.entities.Lieu;
import com.soumaya.chaussures.repos.ChaussureRepository;

@Service
public class ChaussureServiceImpl implements ChaussureService {

	@Autowired
	ChaussureRepository chaussureRepository;
	
	@Override
	public Chaussure saveChaussure(Chaussure c) {
	return chaussureRepository.save(c);
	}
	@Override
	
	public Chaussure updateChaussure(Chaussure c) {
	return chaussureRepository.save(c);
	}
	@Override
	public void deleteChaussure(Chaussure c) {
		chaussureRepository.delete(c);
	}
	@Override
	public void deleteChaussureById(Long id) {
		chaussureRepository.deleteById(id);
	}
	@Override
	public Chaussure getChaussure(Long id) {
	return chaussureRepository.findById(id).get();
	}
	@Override
	public List<Chaussure> getAllChaussures() {
	return chaussureRepository.findAll();
	}
	@Override
	public Page<Chaussure> getAllChaussuresParPage(int page, int size) {
	return chaussureRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Chaussure> findByNomChaussure(String nom) {
	return chaussureRepository.findByNomChaussure(nom);
	}
	@Override
	public List<Chaussure> findByNomChaussureContains(String nom) {
	return chaussureRepository.findByNomChaussureContains(nom);
	}
	/*@Override
	public List<Chaussure> findByNomPrix(String nom, Double prix) {
	return chaussureRepository.findByNomPrix(nom, prix);
	}*/
	@Override
	public List<Chaussure> findByLieu(Lieu lieu) {
	return chaussureRepository.findByLieu(lieu);
	}
	@Override
	public List<Chaussure> findByLieuIdL(Long id) {
	return chaussureRepository.findByLieuIdLieu(id);
	}
	@Override
	public List<Chaussure> findByOrderByNomChaussureAsc() {
	return chaussureRepository.findByOrderByNomChaussureAsc();
	}
	@Override
	public List<Chaussure> trierChaussuresNomsPrix() {
	return chaussureRepository.trierChaussuresNomsPrix();
	}
}
