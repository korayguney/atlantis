package com.bagtep.business;


import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bagtep.domain.Ders;
import com.bagtep.domain.KabaDegerlendirme;
import com.bagtep.domain.Ogrenci;
import com.bagtep.mbeans.MySessionScopedBean;



@Stateless
public class KabaDegerlendirmeService {
	@PersistenceContext
	private EntityManager entityManager;

	public void degerlendirmeKaydet(int ogrenciId, String dersAd) {
		System.out.println("SERVICE : degerlendirmeKaydet GİRDİ !!!");
		
		KabaDegerlendirme kd = new KabaDegerlendirme();
		kd.setDegerlendirmeTarihi(new Date());

		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();		
		
		kd.setDers(ders);
		kd.setOgrenci(ogrenci);
		
		entityManager.persist(kd);
		
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