package com.bagtep.business;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bagtep.domain.KabaDegerlendirme;



@Stateless
public class KabaDegerlendirmeService {
	@PersistenceContext
	private EntityManager entityManager;

	public void degerlendirmeKaydet(List<KabaDegerlendirme> kabadegerlendirme) {

		entityManager.persist(kabadegerlendirme);
		// yapılan değerlendirmeyi db ye kaydedecek. Sonuç dönecek...
		
	}
	
	public void getDegerlendirme() {
		System.out.println("SERVICE : getDegerlendirme GİRDİ !!!");
		// db den değerlendirme çekerek bean e return edecek.
	}

	public void getGelisim() {
		System.out.println("SERVICE : getGelisim GİRDİ !!!");
		// db den gelişim çekerek bean e return edecek.		
	}
	
	


}