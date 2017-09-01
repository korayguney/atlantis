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
import com.bagtep.domain.YilSonuDegerlendirme;
import com.bagtep.domain.YilSonuDegerlendirmeKazanimCevap;



@Stateless
public class YilSonuDegerlendirmeService {
	
	YilSonuDegerlendirmeKazanimCevap ysdcevap;
	static int i = 0;
	static double cevap = 0;

	@PersistenceContext
	private EntityManager entityManager;

	public String degerlendirmeKaydet(int ogrenciId, String dersAd, String degerlendirici, Map<Integer, Double> ozelAmaclarMap , Map<Integer, String> yorum, Map<Integer, OzelAmac> ozelAmacIdMap) {
		System.out.println("SERVICE : degerlendirmeKaydet GİRDİ !!!");
	
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
		
		Query q = entityManager.createNativeQuery("select * from YilSonuDegerlendirme where ders_id= "+ ders.getId() +" and ogrenci_id="+ ogrenci.getId());
		List<YilSonuDegerlendirme> res = (List<YilSonuDegerlendirme>)q.getResultList();
		
		if(res.isEmpty()){
			System.out.println(ogrenci.getAd() + " için " + ders.getDersAd() + " Yıl Sonu Değerlendirmesi Yapılmamış...");
		}else {
			System.out.println(ogrenci.getAd() + " için " + ders.getDersAd() + " Yıl Sonu Değerlendirmesi YAPILMIŞŞŞŞŞŞŞŞŞŞŞ...");
		}
			
		
		YilSonuDegerlendirme ysd = new YilSonuDegerlendirme();
		ysd.setDegerlendirmeTarihi(new Date());
		ysd.setDegerlendirici(degerlendirici);
		ysd.setDers(ders);
		ysd.setOgrenci(ogrenci);
		
		entityManager.persist(ysd);
		
		for (Integer key : ozelAmaclarMap.keySet()) {
			ysdcevap = new YilSonuDegerlendirmeKazanimCevap();
			ysdcevap.setYilSonuDegerlendirmeCevap(Double.parseDouble(""+ozelAmaclarMap.get(key)));
			ysdcevap.setYorum(""+yorum.get(key));
			ysdcevap.setYilSonuDegerlendirme(ysd);
			ysdcevap.setOzelAmac(ozelAmacIdMap.get(key));

			entityManager.persist(ysdcevap);
		}		
	
			String sinifAd = ogrenci.getSinif().getSinifAd();
			int sinifAd1 = Integer.valueOf(sinifAd.substring(0, 1));
			String sinifAd2 = sinifAd.substring(1);
			int sinifAd3 = sinifAd1 + 1;
			String yeniSinifAd = sinifAd3 + sinifAd2;
			System.out.println(ogrenci.getAd() + " YENI SINIFI ::::: " + yeniSinifAd);

			Sinif sinif =  entityManager.createQuery("select s from Sinif s where s.sinifAd=:sinifAd",Sinif.class).setParameter("sinifAd", yeniSinifAd).getSingleResult();	
			ogrenci.setSinif(sinif);
		
		return "";
		
	}
	
	public void degerlendirmeGoruntuleKaydet(int ogrenciId, String dersAd, String degerlendirici, Map<Integer, Double> ozelAmaclarMap , Map<Integer, String> yorum, Map<Integer, OzelAmac> ozelAmacIdMap) {
		System.out.println("YILSONU DEGERLENDIRME SERVICE : degerlendirmeGoruntuleKaydet GİRDİ !!!");
	
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
		
		YilSonuDegerlendirme ysd = yilSonuDegerlendirmeGetir(ogrenciId, ders.getId());
				
		ysd.setDegerlendirmeTarihi(new Date());
		ysd.setDegerlendirici(degerlendirici);
		ysd.setDers(ders);
		ysd.setOgrenci(ogrenci);
		
		entityManager.merge(ysd);
		
		List<YilSonuDegerlendirmeKazanimCevap> ysdcevap = (List<YilSonuDegerlendirmeKazanimCevap>) entityManager.createQuery("select y from YilSonuDegerlendirmeKazanimCevap y where y.yilSonuDegerlendirme.id=:yilSonuId").setParameter("yilSonuId", ysd.getId()).getResultList();
	
			for (Integer key : ozelAmaclarMap.keySet()) {
				ysdcevap.get(i).setYilSonuDegerlendirmeCevap(Double.parseDouble(""+ozelAmaclarMap.get(key)));
				ysdcevap.get(i).setYorum(""+yorum.get(key));
				ysdcevap.get(i).setYilSonuDegerlendirme(ysd);
				ysdcevap.get(i).setOzelAmac(ozelAmacIdMap.get(key));
				
				entityManager.merge(ysdcevap.get(i));
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
		
		Query q = entityManager.createNativeQuery("select * from YilSonuDegerlendirme where ders_id= "+ ders.getId() +" and ogrenci_id="+ ogrenci.getId());
		List<YilSonuDegerlendirmeKazanimCevap> res = (List<YilSonuDegerlendirmeKazanimCevap>)q.getResultList();
		
		if(res.isEmpty()){
			System.out.println(ogrenci.getAd() + " için " + ders.getDersAd() + " Yıl Sonu Değerlendirmesi Yapılmamış...");
			return false;
		}else {
			System.out.println(ogrenci.getAd() + " için " + ders.getDersAd() + " Yıl Sonu Değerlendirmesi YAPILMIŞŞŞŞŞŞŞŞŞŞŞ...");
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
		YilSonuDegerlendirme ysd = null;
		try {
			ysd = (YilSonuDegerlendirme) entityManager.createQuery("select y from YilSonuDegerlendirme y where y.ogrenci.id=:ogrenciId and y.ders.id=:dersId").setParameter("ogrenciId", ogrenciId).setParameter("dersId", ders.getId()).getSingleResult();
		} catch (Exception e) {
			System.out.println("DEĞERLENDİRME YAPILMAMIŞ");
		}
		
		for (int i = 0; i <ysd.getYilSonuDegerlendirmeKazanimCevap().size(); i++) {
			cevap = cevap + ysd.getYilSonuDegerlendirmeKazanimCevap().get(i).getYilSonuDegerlendirmeCevap();
		}
		
		double sonuc = 60 + ((cevap/ders.getGenelAmaclar().size())*0.4); 
		System.out.println("ders.getGenelAmaclar().size() " + ders.getGenelAmaclar().size());
		System.out.println("EVET CEVAp :::::::::::::::." + cevap);
		System.out.println("TOPLAM BAŞARI ::::::::::::::::::  " + sonuc);
		cevap = 0;
		return (int) sonuc;
	}

	public YilSonuDegerlendirme yilSonuDegerlendirmeGetir(int ogrenciId, int dersId) {
		System.out.println("SERVICE : yilSonuDegerlendirmeGetir service e GİRDİ !" );
		YilSonuDegerlendirme ysd = (YilSonuDegerlendirme) entityManager.createQuery("select y from YilSonuDegerlendirme y where y.ogrenci.id=:ogrenciId and y.ders.id=:dersId").setParameter("ogrenciId", ogrenciId).setParameter("dersId", dersId).getSingleResult();
		return ysd;
	}

	public YilSonuDegerlendirmeKazanimCevap getYsdcevap() {
		return ysdcevap;
	}

	public void setYsdcevap(YilSonuDegerlendirmeKazanimCevap ysdcevap) {
		this.ysdcevap = ysdcevap;
	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		YilSonuDegerlendirmeService.i = i;
	}

	public static double getCevap() {
		return cevap;
	}

	public static void setCevap(double cevap) {
		YilSonuDegerlendirmeService.cevap = cevap;
	}


}