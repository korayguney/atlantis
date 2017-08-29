package com.bagtep.business;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	static int i = 0;
	
	@PersistenceContext
	private EntityManager entityManager;

	public void degerlendirmeKaydet(int ogrenciId, String dersAd, String degerlendirici, Map<Integer, Boolean> ozelAmaclarMap , Map<Integer, String> yorum, Map<Integer, OzelAmac> ozelAmacIdMap) {
		System.out.println("SERVICE : degerlendirmeKaydet GİRDİ !!!");
	
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
//		List<Kazanim> kazanimlar = entityManager.createQuery("select k from Kazanim k where k.id=:kazanimId").setParameter("kazanimId", kazanimId).getResultList();
		
		KabaDegerlendirme kd = new KabaDegerlendirme();
		kd.setDegerlendirmeTarihi(new Date());
		kd.setDegerlendirici(degerlendirici);
		kd.setDers(ders);
		kd.setOgrenci(ogrenci);
		
		entityManager.persist(kd);
		
		for (Integer key : ozelAmaclarMap.keySet()) {
			kdcevap = new KabaDegerlendirmeKazanimCevap();
			kdcevap.setKabaDegerlendirmeCevap(Boolean.parseBoolean(""+ozelAmaclarMap.get(key)));
			kdcevap.setYorum(""+yorum.get(key));
			kdcevap.setKabaDegerlendirme(kd);
			kdcevap.setOzelAmac(ozelAmacIdMap.get(key));

			entityManager.persist(kdcevap);
		}		
		
	}
	
	public void degerlendirmeGoruntuleKaydet(int ogrenciId, String dersAd, String degerlendirici, Map<Integer, Boolean> ozelAmaclarMap , Map<Integer, String> yorum, Map<Integer, OzelAmac> ozelAmacIdMap) {
		System.out.println("SERVICE : degerlendirmeGoruntuleKaydet GİRDİ !!!");
	
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
		
		KabaDegerlendirme kd = kabaDegerlendirmeGetir(ogrenciId, ders.getId());
				
		kd.setDegerlendirmeTarihi(new Date());
		kd.setDegerlendirici(degerlendirici);
		kd.setDers(ders);
		kd.setOgrenci(ogrenci);
		
		entityManager.merge(kd);
		
		List<KabaDegerlendirmeKazanimCevap> kdcevap = (List<KabaDegerlendirmeKazanimCevap>) entityManager.createQuery("select k from KabaDegerlendirmeKazanimCevap k where k.kabaDegerlendirme.id=:kabaId").setParameter("kabaId", kd.getId()).getResultList();
		System.out.println("SIZE OF ozelAmaclarMap.size() ::::::::::::::::::: " + ozelAmaclarMap.size());
	
			for (Integer key : ozelAmaclarMap.keySet()) {
				kdcevap.get(i).setKabaDegerlendirmeCevap(Boolean.parseBoolean(""+ozelAmaclarMap.get(key)));
				kdcevap.get(i).setYorum(""+yorum.get(key));
				kdcevap.get(i).setKabaDegerlendirme(kd);
				kdcevap.get(i).setOzelAmac(ozelAmacIdMap.get(key));

				entityManager.merge(kdcevap.get(i));
				i++;
				if(i ==  ozelAmaclarMap.size()){
					break;
				}
			}
		i=0;
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




	public KabaDegerlendirme kabaDegerlendirmeGetir(int ogrenciId, int dersId) {
		System.out.println("SERVICE : kabaDegerlendirmeGetir service e GİRDİ !" );
//		Query query = entityManager.createNativeQuery("select * from KabaDegerlendirme where ogrenci_id=? and ders_id=?");
//		query.setParameter(1, ogrenciId);
//		query.setParameter(2, dersId);
//		KabaDegerlendirme kd = (KabaDegerlendirme) query.getSingleResult();
		
		KabaDegerlendirme kd2 = (KabaDegerlendirme) entityManager.createQuery("select k from KabaDegerlendirme k where k.ogrenci.id=:ogrenciId and k.ders.id=:dersId").setParameter("ogrenciId", ogrenciId).setParameter("dersId", dersId).getSingleResult();
		System.out.println("Değerlendirici ::::::::::::::::: " + kd2.getDegerlendirici());
		
		return kd2;
	}



	/*
	 * Şuan kullanılmıyor
	 */
	public List<Boolean> cevaplariGetir(String dersAd, int id) {
		List<Boolean> cevaplar =   entityManager.createQuery("select k.kabaDegerlendirmeCevap from KabaDegerlendirmeKazanimCevap k where k.ozelAmac.genelAmac.id=:genelAmacId and k.kabaDegerlendirme.ders.dersAd=:dersAd").setParameter("genelAmacId", id).setParameter("dersAd", dersAd).getResultList();
		return cevaplar;
	}
	
	/*
	 * Şuan kullanılmıyor
	 */
	public List<String> yorumlariGetir(String dersAd, int id) {
		List<String> yorumlar =   entityManager.createQuery("select k.yorum from KabaDegerlendirmeKazanimCevap k where k.ozelAmac.genelAmac.id=:genelAmacId and k.kabaDegerlendirme.ders.dersAd=:dersAd").setParameter("genelAmacId", id).setParameter("dersAd", dersAd).getResultList();
		return yorumlar;	
	}

}