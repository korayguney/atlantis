package com.bagtep.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.bagtep.business.OgrenciService;
import com.bagtep.business.UserService;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.User;


@ManagedBean
@ViewScoped
public class KullaniciDuzenleBean {
	
	private List<User> users;
	
	@EJB
	private UserService userService;
	
	@PostConstruct
	public void init()
	{
		this.users = userService.getAllUsers();
	}

	  public void onRowEdit(RowEditEvent event) {
	         User user = (User) event.getObject();
	         userService.updateUser(user);
	         FacesContext.getCurrentInstance().addMessage(null, 
	        		 new FacesMessage("Sonuç : "));
	         FacesContext.getCurrentInstance().addMessage(null, 
	        		 new FacesMessage(user.getUsername()+" güncellendi."));
	    }
	  
	  public void deleteUser(int userId)
	  {
		  System.out.println("Bu kullanıcı silinecek --> "+userId);
		  userService.deleteUser(userId);
		  this.users=userService.getAllUsers();
	  }

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	
	

}
