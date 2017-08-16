package com.bagtep.business;


import java.util.Date;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bagtep.domain.Ders;
import com.bagtep.domain.DonemDegerlendirme;
import com.bagtep.domain.DonemDegerlendirmeKazanimCevap;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.OzelAmac;



@Stateless
public class DonemDegerlendirmeService {
	
	DonemDegerlendirmeKazanimCevap ddcevap;
	
	@PersistenceContext
	private EntityManager entityManager;

	public void degerlendirmeKaydet(int ogrenciId, String dersAd, String degerlendirici, Map<Integer, Double> ozelAmaclarMap , Map<Integer, String> yorum, Map<Integer, OzelAmac> ozelAmacIdMap) {
		System.out.println("SERVICE : degerlendirmeKaydet GİRDİ !!!");
	
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
		
		DonemDegerlendirme dd = new DonemDegerlendirme();
		dd.setDegerlendirmeTarihi(new Date());
		dd.setDegerlendirici(degerlendirici);
		dd.setDers(ders);
		dd.setOgrenci(ogrenci);
		
		entityManager.persist(dd);
		
		for (Integer key : ozelAmaclarMap.keySet()) {
			ddcevap = new DonemDegerlendirmeKazanimCevap();
			ddcevap.setDonemDegerlendirmeCevap(Double.parseDouble(""+ozelAmaclarMap.get(key)));
			ddcevap.setYorum(""+yorum.get(key));
			ddcevap.setDonemDegerlendirme(dd);
			ddcevap.setOzelAmac(ozelAmacIdMap.get(key));

			entityManager.persist(ddcevap);
		}		
		
	}
	
	public void getDegerlendirme() {
		System.out.println("SERVICE : getDegerlendirme GİRDİ !!!");
		// db den değerlendirme çekerek bean e return edecek.
	}

	public void getGelisim() {
		System.out.println("SERVICE : getGelisim GİRDİ !!!");
		// db den gelişim çekerek bean e return edecek.		
	}

	public int degerlendirmePuanHesapla(int ogrenciId, String dersAd) {
//		
//		kdcevap.isKabaDegerlendirmeCevap();
//		return ogrenciId;
		
		return 0;
	}
	
	


}