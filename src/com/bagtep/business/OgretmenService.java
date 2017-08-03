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

	public Map<Ogretmen, Ders> ogretmeneAtananDersleriGetir(int ogretmenId, int dersId) {
		// FIXME Burada öğretmene atanan dersleri almam gerek
		Map<Ogretmen, Ders> ogretmenDers = new LinkedHashMap<>();
		
		Ogretmen ogretmen = entityManager.find(Ogretmen.class, ogretmenId);
		Ders ders = entityManager.find(Ders.class, dersId); 
		
		System.out.println("SUPER METODDAYIZZZZZZZZZZ");
//		String query = "select dersler_id from ogretmen_ders where ogretmenler_id=?";
		ogretmenDers.put(ogretmen, ders);
		System.out.println("Boş mu dolumu" + ogretmenDers.isEmpty());
//			
//		List<Integer> derslerID =  entityManager.createQuery("SELECT od.dersler_id FROM ogretmen_ders od WHERE od.ogretmenler_id =:ogretmenId").setParameter("ogretmenId", ogretmenId).getResultList();
//		List<Ders> dersler = entityManager.createQuery("SELECT d FROM Ders d WHERE d.id =:derslerID").setParameter("derslerID", derslerID).getResultList();
//		
//		
//		for (Ders ders : dersler) {
//			ogretmenDers.put(ogretmen, ders);
//		}
//		
		return ogretmenDers;
	}


}