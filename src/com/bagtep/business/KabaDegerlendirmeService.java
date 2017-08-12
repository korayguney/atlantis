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
	
	KabaDegerlendirmeKazanimCevap kdcevap;
	
	@PersistenceContext
	private EntityManager entityManager;

	public void degerlendirmeKaydet(int ogrenciId, String dersAd, String degerlendirici, Map<Integer, Boolean> ozelAmaclarMap , Map<Integer, String> yorum) {
		System.out.println("SERVICE : degerlendirmeKaydet GİRDİ !!!");
	
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
//		List<Kazanim> kazanimlar = entityManager.createQuery("select k from Kazanim k where k.id=:kazanimId").setParameter("kazanimId", kazanimId).getResultList();
//		System.out.println("Kazanım size ::::: " + kazanimlar.size());
		
		KabaDegerlendirme kd = new KabaDegerlendirme();
		kd.setDegerlendirmeTarihi(new Date());
		kd.setDegerlendirici(degerlendirici);
		kd.setDers(ders);
		kd.setOgrenci(ogrenci);
		
		entityManager.persist(kd);
		
//		Kazanim kazanim = new Kazanim();
//		System.out.println(kazanim);
		
		
		for (Integer key : ozelAmaclarMap.keySet()) {
			kdcevap = new KabaDegerlendirmeKazanimCevap();
			kdcevap.setKabaDegerlendirmeCevap(Boolean.parseBoolean(""+ozelAmaclarMap.get(key)));
			kdcevap.setYorum(""+yorum.get(key));
			kdcevap.setKabaDegerlendirme(kd);
//			kdcevap.setOzelAmacId(ozelAmacId.get(key));

			entityManager.persist(kdcevap);
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