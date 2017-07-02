package com.bagtep.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.User;
import com.bagtep.exceptions.UsernameExistsException;

import com.bagtep.mbeans.MySessionScopedBean;
import com.bagtep.utils.Utilities;

@Stateless

public class OgrenciService {
	@PersistenceContext
	private EntityManager entityManager;
		
	public void saveOgrenci(Ogrenci newOgrenci) {
		
		List<Ogrenci> ogrenciler = entityManager.createQuery("select o from Ogrenci o where o.ad=:ad",Ogrenci.class).setParameter("ad", newOgrenci.getAd()).getResultList();
		entityManager.persist(newOgrenci);
	}

	
	public int getId(int ogrencino){
		
		List<Ogrenci> ogrenciler = entityManager.createQuery("select o from Ogrenci o where o.ogrencino=:ogrencino",Ogrenci.class).setParameter("ogrencino", ogrencino).getResultList();		
		int id = ogrenciler.get(0).getId();
		return id;
	}
	
	public String getOgrenciAd(int ogrencino){
		
		List<Ogrenci> ogrenciler = entityManager.createQuery("select o from Ogrenci o where o.ogrencino=:ogrencino",Ogrenci.class).setParameter("ogrencino", ogrencino).getResultList();		
		String ogrenciad = ogrenciler.get(0).getAd();
		return ogrenciad;
	}
	
	public String getOgrenciSoyad(int ogrencino){
		
		List<Ogrenci> ogrenciler = entityManager.createQuery("select o from Ogrenci o where o.ogrencino=:ogrencino",Ogrenci.class).setParameter("ogrencino", ogrencino).getResultList();		
		String ogrencisoyad = ogrenciler.get(0).getSoyad();
		return ogrencisoyad;
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


}