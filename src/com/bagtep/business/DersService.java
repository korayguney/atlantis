package com.bagtep.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bagtep.domain.Ders;
import com.bagtep.domain.User;

import com.bagtep.mbeans.MySessionScopedBean;

@Stateless

public class DersService {
	@PersistenceContext
	private EntityManager entityManager;
		
	public void saveDers(Ders newDers) {
		
		List<Ders> dersler = entityManager.createQuery("select d from Ders d where d.dersAd=:dersAd",Ders.class).setParameter("dersAd", newDers.getDersAd()).getResultList();
		entityManager.persist(newDers);
	}

	
	public int getId(int dersno){
		
		List<Ders> dersler = entityManager.createQuery("select d from Ders d where d.dersno=:dersno",Ders.class).setParameter("dersno", dersno).getResultList();		
		int id = dersler.get(0).getId();
		return id;
	}
	
	public String getDersAd(int dersno){
		
		List<Ders> dersler = entityManager.createQuery("select d from Ders d where d.dersno=:dersno",Ders.class).setParameter("dersno", dersno).getResultList();		
		String dersAd= dersler.get(0).getDersAd();
		return dersAd;
	}
	
	public List<Ders> getAllDers() {
		return entityManager.createQuery("select d from Ders d",Ders.class).getResultList();
	}

	public void deleteDers (int dersId) {
		Ders Ders = entityManager.find(Ders.class, dersId);
		entityManager.remove(Ders);
		
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


	public void updateDers(Ders ders) {
		entityManager.merge(ders);
	}


}