package com.bagtep.business;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bagtep.domain.Ders;
import com.bagtep.domain.DonemDegerlendirme;
import com.bagtep.domain.KabaDegerlendirme;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.Ogretmen;
import com.bagtep.domain.Sinif;
import com.bagtep.domain.User;
import com.bagtep.exceptions.UsernameExistsException;

import com.bagtep.mbeans.MySessionScopedBean;
import com.bagtep.utils.Utilities;

@Stateless

public class OgrenciService {
	@PersistenceContext
	private EntityManager entityManager;
		
	public void saveOgrenci(Ogrenci newOgrenci, int sinifId) {
		Sinif sinif = entityManager.find(Sinif.class, sinifId);
		newOgrenci.setSinif(sinif);
		entityManager.persist(newOgrenci);
	}

	
	public int getId(int ogrencino) {

		List<Ogrenci> ogrenciler = entityManager
				.createQuery("select o from Ogrenci o where o.ogrencino=:ogrencino", Ogrenci.class)
				.setParameter("ogrencino", ogrencino).getResultList();
		int id = ogrenciler.get(0).getId();
		return id;
	}

	public String getOgrenciAd(int oid){		
		return entityManager.find(Ogrenci.class, oid).getAd();
	}
	
	public String getOgrenciSoyad(int oid){

		return entityManager.find(Ogrenci.class, oid).getSoyad();

	}
		

	public List<Ogrenci> getAllOgrenci() {
		return entityManager.createQuery("select o from Ogrenci o",Ogrenci.class).getResultList();
	}

	public void deleteOgrenci (int ogrenciId) {
		Ogrenci ogrenci = entityManager.find(Ogrenci.class, ogrenciId);
		entityManager.remove(ogrenci);
		
	}


/*
	public User getUser(int userId) {
		User user = entityManager.find(User.class, userId);
		for(Course c : user.getCourses())
		{
			
		}
		
		return user; 
	}
	public void updateUserWithEdit(User user) {
		entityManager.merge(user);
		
	}
/*
   
	/*
	public void addCourseToUser(int selectedStuId, int selectedCourseId) {
		User selectedUser = entityManager.find(User.class, selectedStuId);
		Course selectedCourse = entityManager.find(Course.class, selectedCourseId);
		
		selectedUser.getCourses().add(selectedCourse);
		
		entityManager.merge(selectedUser);
		entityManager.merge(selectedCourse);
		
	}*/
	

	@SuppressWarnings("null")
	public User getUserInSession() {
		MySessionScopedBean mysess = null;
		return  entityManager.find(User.class, mysess.getId());
	}


	public List<Ogrenci> getSelectedOgrenciForClass(String sinif) {
		System.out.println("getSelectedOgrenciForClass  SERVICE METODUNA GİRDİ !!!");
		String ogrencisinif = sinif;
		List<Ogrenci> ogrenciler = entityManager.createQuery("select o from Ogrenci o where o.sinif.sinifAd=:sinif",Ogrenci.class).setParameter("sinif", sinif).getResultList();		
		return ogrenciler;
	}

	public void updateOgrenci(Ogrenci ogrenci) {
		entityManager.merge(ogrenci);
	}


	public void addNewOgrenci(Ogrenci newOgrenci) {
		entityManager.persist(newOgrenci);		
	}


	public void ogrenciyeDersAta(int ogrenciId, int dersId) {
		System.out.println("SERVICE GELEN OGRENCI ID : "+  ogrenciId);
		System.out.println("SERVICE GELEN DERS ID : "+  dersId);

		Ogrenci ogrenci = entityManager.find(Ogrenci.class, ogrenciId);
		Ders ders = entityManager.find(Ders.class, dersId);
		
		ogrenci.getDersler().add(ders);
		
		entityManager.merge(ogrenci);
		entityManager.merge(ders);	
		
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
	
	public boolean dahaOnceKabaDegerlendirilmismi(int ogrenciId, String dersAd){
		Ders ders =  entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", dersAd).getSingleResult();	
		Ogrenci ogrenci = entityManager.createQuery("select o from Ogrenci o where o.id=:ogrenciId",Ogrenci.class).setParameter("ogrenciId", ogrenciId).getSingleResult();	
		
		System.out.println("dahaOnceKabaDegerlendirilmismi METODUNA GELEN ÖĞRENCİ : " + ogrenci.getAd() + " " +ogrenci.getSoyad());
		
		Query q = entityManager.createNativeQuery("select * from KabaDegerlendirme where ders_id= "+ ders.getId() +" and ogrenci_id="+ ogrenci.getId());
		List<KabaDegerlendirme> res = (List<KabaDegerlendirme>)q.getResultList();
		
		if(res.isEmpty()){
			System.out.println(ogrenci.getAd() + " için " + ders.getDersAd() + " Kaba Değerlendirmesi Yapılmamış...");
			return false;
		}else {
			System.out.println(ogrenci.getAd() + " için " + ders.getDersAd() + " Kaba Değerlendirmesi YAPILMIŞŞŞŞŞŞŞŞŞŞŞ...");
			return true;
		}
	}
	
	
//	public List<Ogrenci> degerlendirmesiYapilanlariGetir(String ders, String sinif) {
//		
//		List<Ogrenci> ogrenciler = getSelectedOgrenciForClass(sinif);
//		
//		List<Ogrenci> ogrenciler5 =	entityManager.createNativeQuery("select o from kabadegerlendirme k, ogrenci o where o.id = ogrenci_id & ders.id = ders_id").getResultList();
//		for (Ogrenci ogrenci : ogrenciler5) {
//			System.out.println("Değerlendirmesi yapılmış Öğrenciler : " + ogrenci.getAd());
//		}
//		
//		return ogrenciler;
//	}


}