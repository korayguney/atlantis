package com.bagtep.business;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bagtep.domain.Ders;
import com.bagtep.domain.KabaDegerlendirme;
import com.bagtep.domain.KabaDegerlendirmeKazanimCevap;
import com.bagtep.domain.Kazanim;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.OzelAmac;
import com.bagtep.mbeans.MySessionScopedBean;



@Stateless
public class KabaDegerlendirmeService {
	@PersistenceContext
	private EntityManager entityManager;

	public void degerlendirmeKaydet(int ogrenciId, String dersAd, String degerlendirici, Map<Integer, Boolean> ozelAmaclarMap ) {
		System.out.println("SERVICE : degerlendirmeKaydet GİRDİ !!!");
		
		KabaDegerlendirme kd = new KabaDegerlendirme();
		kd.setDegerlendirmeTarihi(new Date());
		kd.setDegerlendirici(degerlendirici);
		
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
		
		kd.setDers(ders);
		kd.setOgrenci(ogrenci);
		
		entityManager.persist(kd);
		
		KabaDegerlendirmeKazanimCevap kdcevap = new KabaDegerlendirmeKazanimCevap();
		
		for (Integer key : ozelAmaclarMap.keySet()) {
			 kdcevap.setKabaDegerlendirmeCevap((Boolean)ozelAmaclarMap.get(key));
			 entityManager.persist(kdcevap);
			
			 System.out.println("SONUCUM : ******** " + ozelAmaclarMap.get(key));
			 
//			if(ozelAmaclarMap.get(key) instanceof Boolean){
//				System.out.println(key + " : " + ozelAmaclarMap.get(key));
//			}else{
//				System.out.println("******************* BOOLEAN DEĞER DEĞİL !!!");
//			}
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
	
	


}