package com.bagtep.business;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bagtep.domain.BireyselEgitimPlani;
import com.bagtep.domain.BireyselEgitimPlaniRaporSecim;
import com.bagtep.domain.Ders;
import com.bagtep.domain.GenelAmac;
import com.bagtep.domain.KabaDegerlendirme;
import com.bagtep.domain.KabaDegerlendirmeKazanimCevap;
import com.bagtep.domain.Kazanim;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.OzelAmac;
import com.cete.dynamicpdf.Font;
import com.cete.dynamicpdf.Page;
import com.cete.dynamicpdf.merger.MergeDocument;
import com.cete.dynamicpdf.pageelements.Label;

@Stateless
public class BireyselEgitimPlaniService {

	BireyselEgitimPlaniRaporSecim bepCevap;
	
	@PersistenceContext
	private EntityManager entityManager;

	// Kaba Değerlendirmede "HAYIR" verilen özel amaçlar listelenir.
	public List<OzelAmac> kabaDegerlendirmedeHayirVerilenCevaplariGetir(int dersId, int ogrenciId) {

		Ogrenci ogrenci = entityManager.find(Ogrenci.class, ogrenciId);
		Ders ders = entityManager.find(Ders.class, dersId);

		Query q = entityManager
				.createNativeQuery("SELECT id FROM KabaDegerlendirme WHERE ogrenci_id = ? and ders_id = ?");
		q.setParameter(1, ogrenciId);
		q.setParameter(2, dersId);
		int kabaDegerlendirmeId = (int) q.getSingleResult();
		if (kabaDegerlendirmeId != 0) {
			System.out.println(ogrenci.getAd() + " " + ogrenci.getSoyad() + "ın kabaDeğerlendirmesi " + ders.getDersAd()
					+ " için yapılmış.");
			System.out.println("****** Alınan Kaba Değerlendirme Id : " + kabaDegerlendirmeId);
		} else {
			System.out.println("kabaDegerlendirmeId boş GELDİ.. ");
			System.out.println(ogrenci.getAd() + " " + ogrenci.getSoyad() + "ın kabaDeğerlendirmesi " + ders.getDersAd()
					+ " için YAPILMAMIŞ.");
		}

//		Query q2 = entityManager.createNativeQuery("SELECT kabaDegerlendirmeCevap FROM KabaDegerlendirmeKazanimCevap WHERE kabaDegerlendirme_id = ? ");
//		q2.setParameter(1, kabaDegerlendirmeId);
		
//		Query q2 = entityManager.createNativeQuery("SELECT kabaDegerlendirmeCevap FROM KabaDegerlendirmeKazanimCevap WHERE kabaDegerlendirme_id = ? ");
//		q2.setParameter(1, kabaDegerlendirmeId);
//
//		List<Boolean> kabaDegerlendirmeKazanimCevap = q2.getResultList();
//		
//		for (KabaDegerlendirmeKazanimCevap kabaDegerlendirmeKazanimCevap2 : kabaDegerlendirmeKazanimCevap) {
//			System.out.println("kabaDegerlendirmeKazanimCevap " + kabaDegerlendirmeKazanimCevap2.getOzelAmac().getIcerik());
//		}
		
		List<OzelAmac> ozelAmaclarHayirVerilen = entityManager.createQuery("SELECT k.ozelAmac FROM KabaDegerlendirmeKazanimCevap k WHERE k.kabaDegerlendirme.ogrenci.id =:ogrenciId and k.kabaDegerlendirme.ders.id =:dersId and k.kabaDegerlendirmeCevap=0").setParameter("ogrenciId", ogrenciId).setParameter("dersId", dersId).getResultList();
//		for (OzelAmac ozelAmac : ozelAmaclarHayirVerilen) {
//			System.out.println("Hayır verilen Özel Amaç :  ÖZEL " + ozelAmac.getGenelAmac().getIcerik());
//		}
		
		// Aşağıdaki query ile Cevabına hayır dediği özel amaçları konsola yazdırabiliyorum.
//		Query q2 = entityManager.createNativeQuery("SELECT icerik FROM OzelAmac WHERE id IN (SELECT ozelAmac_id FROM KabaDegerlendirmeKazanimCevap WHERE kabaDegerlendirme_id = ? and kabaDegerlendirmeCevap = 0)");
//		q2.setParameter(1, kabaDegerlendirmeId);
//		
//		List<String> kabaDegerlendirmeKazanimCevap = q2.getResultList();
//		
//		Query q3 = entityManager.createNativeQuery("SELECT id FROM OzelAmac WHERE id IN (SELECT ozelAmac_id FROM KabaDegerlendirmeKazanimCevap WHERE kabaDegerlendirme_id = ? and kabaDegerlendirmeCevap = 0)");
//		q3.setParameter(1, kabaDegerlendirmeId);
//		
//		List<Integer> kabaDegerlendirmeKazanimCevap2 = q3.getResultList();
//		
//		Map<Integer, String> ozelAmacMap = new LinkedHashMap<Integer, String>();
//		for (int j = 0; j < kabaDegerlendirmeKazanimCevap.size(); j++) {
//			ozelAmacMap.put(kabaDegerlendirmeKazanimCevap2.get(j),
//					kabaDegerlendirmeKazanimCevap.get(j));
//		}
//		
//		for (Map.Entry<Integer, String> entry : ozelAmacMap.entrySet())
//		{
//		    System.out.println(entry.getKey() + "/" + entry.getValue());
//		}
		
		
//		kabaDegerlendirmeKazanimCevap.stream().forEach(t -> System.out.println("Özel " + t));
//		
//		Query q2 = entityManager.createNativeQuery("SELECT * FROM OzelAmac WHERE id IN (SELECT ozelAmac_id FROM KabaDegerlendirmeKazanimCevap WHERE kabaDegerlendirme_id = ? and kabaDegerlendirmeCevap = 0)");
//		q2.setParameter(1, kabaDegerlendirmeId);
//		
//		List<OzelAmac> kabaDegerlendirmeOzelAmacList = q2.getResultList();
//
//		for (OzelAmac ozelAmac : kabaDegerlendirmeOzelAmacList) {
//			System.out.println(ozelAmac.getIcerik());
//		}
		
		
		return ozelAmaclarHayirVerilen;

	}

	public void bireyselEgitimPlaniAl(int ogrenciId, String dersAd, String degerlendirici,
			Map<Integer, Boolean> ozelAmaclarMap, Map<Integer, OzelAmac> ozelAmacIdMap) {
		
		System.out.println("SERVICE : bireyselEgitimPlaniAl GİRDİ !!!");
		
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
		
		BireyselEgitimPlani bep = new BireyselEgitimPlani();
		bep.setDegerlendirmeTarihi(new Date());
		bep.setDegerlendirici(degerlendirici);
		bep.setDers(ders);
		bep.setOgrenci(ogrenci);
		
		entityManager.persist(bep);
		
		for (Integer key : ozelAmaclarMap.keySet()) {
			bepCevap = new BireyselEgitimPlaniRaporSecim();
			bepCevap.setBireyselEgitimPlaniCevap(Boolean.parseBoolean(""+ozelAmaclarMap.get(key)));
			bepCevap.setBireyselEgitimPlani(bep);
			bepCevap.setOzelAmac(ozelAmacIdMap.get(key));
			
			// sadece  BEP'e eklemek istediklerinin kontrolü (yani EVET seçtiklerinin)
			if(Boolean.parseBoolean(""+ozelAmaclarMap.get(key))){
				entityManager.persist(bepCevap);
			}else {
				continue;
			}
		}				
		
	}
}
