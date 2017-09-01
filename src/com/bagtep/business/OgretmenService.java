package com.bagtep.business;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bagtep.domain.Ders;
import com.bagtep.domain.Ogretmen;

@Stateless
public class OgretmenService {
	
	Ogretmen ogretmen;
	Ders ders;
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Ogretmen> tumOgretmenleriGetir() {
		return entityManager.createQuery("select o from Ogretmen o", Ogretmen.class).getResultList();
	}

	public Ogretmen ogretmeneDersAta(int ogretmenId, int dersId) {
		ogretmen = entityManager.find(Ogretmen.class, ogretmenId);
		ders = entityManager.find(Ders.class, dersId);
		
		ogretmen.getDersler().add(ders);
		
		entityManager.merge(ogretmen);
		entityManager.merge(ders);	
		
		return ogretmen;
	}


//	public void ogretmeneAtananDersSil(int ogretmenId) {
//		Ogretmen ogretmen = entityManager.find(Ogretmen.class, ogretmenId);	
//		entityManager.remove(ogretmen);		
//	}
	
	public void ogretmenKaydet(String firstname, String lastname) {
		Ogretmen ogretmen = new Ogretmen();
		ogretmen.setAd(firstname);
		ogretmen.setSoyad(lastname);
		entityManager.persist(ogretmen);
	}

	public Ogretmen ogretmeneAtananDersleriGetir(int ogretmenId, int dersId) {
		// FIXME Burada öğretmene atanan dersleri almam gerek

		Ogretmen ogretmen = entityManager.find(Ogretmen.class, ogretmenId);
		System.out.println("Atama yapılan öğretmen adı ::::::::: " + ogretmen.getAd());
		System.out.println("Atama yapılan ders ::::::::: " +ogretmen.getDersler().iterator().next().getDersAd());
		Ders ders = entityManager.find(Ders.class, dersId); 
		
		System.out.println("SUPER METODDAYIZZZZZZZZZZ");

		return ogretmen;
	}


}