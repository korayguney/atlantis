package com.bagtep.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bagtep.domain.User;
import com.bagtep.exceptions.UsernameExistsException;

import com.bagtep.mbeans.MySessionScopedBean;
import com.bagtep.utils.Utilities;

@Stateless

public class UserService {
	@PersistenceContext
	private EntityManager entityManager;
		
	public void saveUser(User newUser) throws UsernameExistsException{
		
		List<User> users = entityManager.createQuery("select u from User u where u.username=:username",User.class).setParameter("username", newUser.getUsername()).getResultList();
		if (users != null && users.size() > 0){
			throw new UsernameExistsException();
		}	
		//newUser.hashPassword();
		entityManager.persist(newUser);
	}
	
	public boolean checkUser(String username, String password){

		List<User> users = entityManager.createQuery("select u from User u where u.username=:username",User.class).setParameter("username", username).getResultList();
		if(users != null && users.size() == 1){
			String passw = users.get(0).getPassword();
			
			password = Utilities.hashPassword(password);
			if(passw.equals(password)){
				System.out.println("SERVICE KULLANILDI !!!");
				return true;
			}		
		}
		System.out.println("SERVICE KULLANILMADI !!!");
		return false;
	}

	public String getRole(String username){
		
		List<User> users = entityManager.createQuery("select u from User u where u.username=:username",User.class).setParameter("username", username).getResultList();		
		String role = users.get(0).getRole();
		return role;
	}
	
	public int getId(String username){
		
		List<User> users = entityManager.createQuery("select u from User u where u.username=:username",User.class).setParameter("username", username).getResultList();		
		int id = users.get(0).getId();
		return id;
	}
	
	public String getFirstname(String username){
		
		List<User> users = entityManager.createQuery("select u from User u where u.username=:username",User.class).setParameter("username", username).getResultList();		
		String firstname = users.get(0).getFirstname();
		return firstname;
	}
	
	public String getLastname(String username){
		
		List<User> users = entityManager.createQuery("select u from User u where u.username=:username",User.class).setParameter("username", username).getResultList();		
		String lastname = users.get(0).getLastname();
		return lastname;
	}
	
	

	public List<User> getAllUsers() {
		return entityManager.createQuery("select u from User u",User.class).getResultList();
	}

	public void deleteUser(int userId) {
		User user = entityManager.find(User.class, userId);
		entityManager.remove(user);
		
	}


	public List<User> getUsersExceptAdmin() {
		
		return entityManager.createQuery("select u from User u where role = 'Student' or role = 'Instructor' ",User.class).getResultList();
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


}