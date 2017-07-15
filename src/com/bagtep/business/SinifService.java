package com.bagtep.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bagtep.domain.Ders;
import com.bagtep.domain.Ogretmen;
import com.bagtep.domain.Sinif;
import com.bagtep.domain.User;
import com.bagtep.mbeans.MySessionScopedBean;

@Stateless

public class SinifService {
	@PersistenceContext
	private EntityManager entityManager;
		
	public void saveSinif(Sinif newSinif) {
		
		List<Sinif> siniflar = entityManager.createQuery("select s from Sinif s where s.sinifAd=:sinifAd",Sinif.class).setParameter("sinifAd", newSinif.getSinifAd()).getResultList();
		entityManager.persist(newSinif);
	}

	
	public int getId(int sinifno){
		
		List<Sinif> siniflar = entityManager.createQuery("select s from Sinif s where s.sinifno=:sinifno",Sinif.class).setParameter("sinifno", sinifno).getResultList();		
		int id = siniflar.get(0).getId();
		return id;
	}
	
	public String getSinifAd(int sinifno){
		
		List<Sinif> siniflar = entityManager.createQuery("select s from Sinif s where s.sinifno=:sinifno",Sinif.class).setParameter("sinifno", sinifno).getResultList();		
		String sinifAd= siniflar.get(0).getSinifAd();
		return sinifAd;
	}
	
	public List<Sinif> getAllSinif() {
		System.out.println("GetAllSinif Servisi'ne girdiiiiii");
		return entityManager.createQuery("select s from Sinif s",Sinif.class).getResultList();
	}
	
	public void deleteSinif (int sinifId) {
		Sinif sinif = entityManager.find(Sinif.class, sinifId);
		entityManager.remove(sinif);
		
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


	public void updateSinif(Sinif sinif) {
		entityManager.merge(sinif);
	}


	public void ogretmeneSinifAta(int ogretmenId, int sinifId) {
		Ogretmen ogretmen = entityManager.find(Ogretmen.class, ogretmenId);
		Sinif sinif = entityManager.find(Sinif.class, sinifId);
		
		sinif.getOgretmen().add(ogretmen);

		entityManager.merge(ogretmen);
		entityManager.merge(sinif);			
	}


	public void derseSinifAta(int dersId, int sinifId) {
		Ders ders = entityManager.find(Ders.class, dersId);
		Sinif sinif = entityManager.find(Sinif.class, sinifId);
		
		sinif.getDersler().add(ders);
		
		entityManager.merge(ders);
		entityManager.merge(sinif);					
	}


}