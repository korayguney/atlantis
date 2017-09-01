package com.bagtep.business;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bagtep.domain.Ders;
import com.bagtep.domain.DonemDegerlendirme;
import com.bagtep.domain.DonemDegerlendirmeKazanimCevap;
import com.bagtep.domain.KabaDegerlendirme;
import com.bagtep.domain.KabaDegerlendirmeKazanimCevap;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.OzelAmac;
import com.bagtep.domain.Sinif;



@Stateless
public class DonemDegerlendirmeService {
	
	DonemDegerlendirmeKazanimCevap ddcevap;
	static int i = 0;
	static double cevap = 0;

	@PersistenceContext
	private EntityManager entityManager;

	public String degerlendirmeKaydet(int ogrenciId, String dersAd, String degerlendirici, Map<Integer, Double> ozelAmaclarMap , Map<Integer, String> yorum, Map<Integer, OzelAmac> ozelAmacIdMap) {
		System.out.println("SERVICE : degerlendirmeKaydet GİRDİ !!!");
	
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
		
		Query q = entityManager.createNativeQuery("select * from DonemDegerlendirme where ders_id= "+ ders.getId() +" and ogrenci_id="+ ogrenci.getId());
		List<DonemDegerlendirme> res = (List<DonemDegerlendirme>)q.getResultList();
		
		if(res.isEmpty()){
			System.out.println(ogrenci.getAd() + " için " + ders.getDersAd() + " Dönem Değerlendirmesi Yapılmamış...");
		}else {
			System.out.println(ogrenci.getAd() + " için " + ders.getDersAd() + " Dönem Değerlendirmesi YAPILMIŞŞŞŞŞŞŞŞŞŞŞ...");
		}
			
		
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
		
		return "";
		
	}
	
	public void degerlendirmeGoruntuleKaydet(int ogrenciId, String dersAd, String degerlendirici, Map<Integer, Double> ozelAmaclarMap , Map<Integer, String> yorum, Map<Integer, OzelAmac> ozelAmacIdMap) {
		System.out.println("DONEMDEGERLENDIRME SERVICE : degerlendirmeGoruntuleKaydet GİRDİ !!!");
	
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
		
		DonemDegerlendirme dd = donemDegerlendirmeGetir(ogrenciId, ders.getId());
				
		dd.setDegerlendirmeTarihi(new Date());
		dd.setDegerlendirici(degerlendirici);
		dd.setDers(ders);
		dd.setOgrenci(ogrenci);
		
		entityManager.merge(dd);
		
		List<DonemDegerlendirmeKazanimCevap> ddcevap = (List<DonemDegerlendirmeKazanimCevap>) entityManager.createQuery("select d from DonemDegerlendirmeKazanimCevap d where d.donemDegerlendirme.id=:donemId").setParameter("donemId", dd.getId()).getResultList();
		System.out.println("SIZE OF ozelAmaclarMap.size() ::::::::::::::::::: " + ozelAmaclarMap.size());
	
			for (Integer key : ozelAmaclarMap.keySet()) {
				ddcevap.get(i).setDonemDegerlendirmeCevap(Double.parseDouble(""+ozelAmaclarMap.get(key)));
				ddcevap.get(i).setYorum(""+yorum.get(key));
				ddcevap.get(i).setDonemDegerlendirme(dd);
				ddcevap.get(i).setOzelAmac(ozelAmacIdMap.get(key));
				
				entityManager.merge(ddcevap.get(i));
				i++;
				if(i ==  ozelAmaclarMap.size()){
					break;
				}
			}
		i=0;
		}
	
	
	public boolean dahaOnceDegerlendirilmismi(int ogrenciId, String dersAd){
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
		
		Query q = entityManager.createNativeQuery("select * from DonemDegerlendirme where ders_id= "+ ders.getId() +" and ogrenci_id="+ ogrenci.getId());
		List<DonemDegerlendirme> res = (List<DonemDegerlendirme>)q.getResultList();
		
		if(res.isEmpty()){
			System.out.println(ogrenci.getAd() + " için " + ders.getDersAd() + " Dönem Değerlendirmesi Yapılmamış...");
			return false;
		}else {
			System.out.println(ogrenci.getAd() + " için " + ders.getDersAd() + " Dönem Değerlendirmesi YAPILMIŞŞŞŞŞŞŞŞŞŞŞ...");
			return true;
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
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		System.out.println("degerlendirmePuanHesapla SERVICE METOD DERS AD ::::::::::. " + ders.getDersAd());
		DonemDegerlendirme dd = null;
		try {
			dd = (DonemDegerlendirme) entityManager.createQuery("select d from DonemDegerlendirme d where d.ogrenci.id=:ogrenciId and d.ders.id=:dersId").setParameter("ogrenciId", ogrenciId).setParameter("dersId", ders.getId()).getSingleResult();
		} catch (Exception e) {
			System.out.println("DEĞERLENDİRME YAPILMAMIŞ");
		}
		
		for (int i = 0; i <dd.getDonemDegerlendirmeKazanimCevap().size(); i++) {
			cevap = cevap + dd.getDonemDegerlendirmeKazanimCevap().get(i).getDonemDegerlendirmeCevap();
		}
		
		double sonuc = 60 + ((cevap/ders.getGenelAmaclar().size())*0.4); 
		System.out.println("ders.getGenelAmaclar().size() " + ders.getGenelAmaclar().size());
		System.out.println("EVET CEVAp :::::::::::::::." + cevap);
		System.out.println("TOPLAM BAŞARI ::::::::::::::::::  " + sonuc);
		cevap = 0;
		return (int) sonuc;
	}

	public DonemDegerlendirme donemDegerlendirmeGetir(int ogrenciId, int dersId) {
		System.out.println("SERVICE : donemDegerlendirmeGetir service e GİRDİ !" );
		DonemDegerlendirme dd = (DonemDegerlendirme) entityManager.createQuery("select d from DonemDegerlendirme d where d.ogrenci.id=:ogrenciId and d.ders.id=:dersId").setParameter("ogrenciId", ogrenciId).setParameter("dersId", dersId).getSingleResult();
		return dd;
	}

	public DonemDegerlendirmeKazanimCevap getDdcevap() {
		return ddcevap;
	}

	public void setDdcevap(DonemDegerlendirmeKazanimCevap ddcevap) {
		this.ddcevap = ddcevap;
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		DonemDegerlendirmeService.i = i;
	}

	public static double getCevap() {
		return cevap;
	}

	public static void setCevap(double cevap) {
		DonemDegerlendirmeService.cevap = cevap;
	}
	
	
	
	


}