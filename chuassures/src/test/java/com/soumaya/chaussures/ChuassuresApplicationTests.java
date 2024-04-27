package com.soumaya.chaussures;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

import com.soumaya.chaussures.entities.Chaussure;
import com.soumaya.chaussures.entities.Lieu;
import com.soumaya.chaussures.repos.ChaussureRepository;
import com.soumaya.chaussures.service.ChaussureService;

@SpringBootTest
class ChuassuresApplicationTests {

	@Autowired
	private ChaussureRepository chaussureRepository;
	@Autowired
	private ChaussureService chaussureService;
	@Test
	public void testCreateChaussure() {
		Chaussure chauss = new Chaussure("Puma",290.500,new Date());
		chaussureRepository.save(chauss);
	}
	
	@Test
	public void testFindChaussure()
	{
		Chaussure c = chaussureRepository.findById(1L).get();
		System.out.println(c);
	}
	@Test
	public void testUpdateChaussure()
	{
		Chaussure c = chaussureRepository.findById(1L).get();
		c.setPrixChaussure(331.9);
	chaussureRepository.save(c);
	}
	@Test
	public void testDeleteChaussure()
	{
		chaussureRepository.deleteById(3L);;
	}
	@Test
	public void testListerTousChaussures()
	{
	List<Chaussure> chausss = chaussureRepository.findAll();
	for (Chaussure c : chausss)
	{
	System.out.println(c);
	}
	}
	
	@Test
	public void testFindByNomChaussureContains()
	{
	Page<Chaussure> chausss = chaussureService.getAllChaussuresParPage(0,2);
	System.out.println(chausss.getSize());
	System.out.println(chausss.getTotalElements());
	System.out.println(chausss.getTotalPages());
	chausss.getContent().forEach(c -> {System.out.println(c.toString());
	});
	/*ou bien
	for (Chaussure c : chausss)
	{
	System.out.println(c);
	} */
	}
	
	@Test
	public void testFindByNomChaussure()
	{
		List<Chaussure> chausss = chaussureRepository.findByNomChaussure("Aldo");
		for (Chaussure c : chausss)
		{
			System.out.println(c);
		}
	}
	
	@Test
	public void testFindByNomChaussurContains ()
	{
	List<Chaussure> chausss=chaussureRepository.findByNomChaussureContains("Al");
	for (Chaussure c : chausss)
	{
	System.out.println(c);
	} }
	
	@Test
	public void testfindByNomPrix()
	{
		List<Chaussure> chausss = chaussureRepository.findByNomPrix("Puma ", 250.0);
		for (Chaussure c : chausss)
		{
			System.out.println(c);
		}
	}
	
	@Test
	public void testfindByLieu()
	{
		Lieu lieu = new Lieu();
		lieu.setIdLieu(1L);
		List<Chaussure> chausss = chaussureRepository.findByLieu(lieu);
		for (Chaussure c : chausss)
		{
			System.out.println(c);
		}
	}
	
	@Test
	public void findByLieuIdL()
	{
	List<Chaussure> chausss = chaussureRepository.findByLieuIdLieu(1L);
	for (Chaussure c : chausss)
	{
	System.out.println(c);
	}
	}
	
	@Test
	public void testfindByOrderByNomChaussureAsc()
	{
	List<Chaussure> chausss =
	chaussureRepository.findByOrderByNomChaussureAsc();
	for (Chaussure c : chausss)
	{
	System.out.println(c);
	}
	}
	
	@Test
	public void testTrierChaussuresNomsPrix()
	{
	List<Chaussure> chausss = chaussureRepository.trierChaussuresNomsPrix();
	for (Chaussure c : chausss)
	{
	System.out.println(c);
	}
	}
	
	
	

}
