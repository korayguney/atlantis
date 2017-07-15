package com.bagtep.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bagtep.domain.Ders;
import com.bagtep.domain.Ogretmen;

@Stateless
public class OgretmenService {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Ogretmen> tumOgretmenleriGetir() {
		return entityManager.createQuery("select o from Ogretmen o", Ogretmen.class).getResultList();
	}

	public void ogretmeneDersAta(int ogretmenId, int dersId) {
		Ogretmen ogretmen = entityManager.find(Ogretmen.class, ogretmenId);
		Ders ders = entityManager.find(Ders.class, dersId);
		
		ogretmen.getDersler().add(ders);
		
		entityManager.merge(ogretmen);
		entityManager.merge(ders);		
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


}