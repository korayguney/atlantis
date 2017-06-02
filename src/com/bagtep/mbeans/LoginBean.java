package com.bagtep.mbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.servlet.http.HttpServletRequest;

import com.bagtep.business.UserService;

import com.bagtep.domain.User;

@ManagedBean
public class LoginBean {

	private String username;
	private String password;
	
	private String text;
	
	@EJB
	private UserService userService;
	
	@ManagedProperty("#{mySessionScopedBean}")
	private MySessionScopedBean mySessionScopedBean;
	

	public String login() {
		if (userService.checkUser(username, password)) 
		{
			mySessionScopedBean.setUsername(username);
			
			String role = userService.getRole(username);
			mySessionScopedBean.setRole(role);
			
			String firstname = userService.getFirstname(username);
			mySessionScopedBean.setFirstname(firstname);
			
			String lastname = userService.getLastname(username);
			mySessionScopedBean.setLastname(lastname);
			
			int id = userService.getId(username);
			mySessionScopedBean.setId(id);
			
			System.out.println("BEAN'DEN GEÇTİ !!!");
			return "users/admin/adminanasayfa";
		} else {
			FacesContext.getCurrentInstance().
			addMessage(null,new FacesMessage("Yanlış Parola!"));
			System.out.println("BEAN'DE TAKILDI !!!");
			return "index";
		}
	}
	public String logout() {

		mySessionScopedBean.setUsername("");
		return "index";
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public MySessionScopedBean getMySessionScopedBean() {
		return mySessionScopedBean;
	}

	public void setMySessionScopedBean(MySessionScopedBean mySessionScopedBean) {
		this.mySessionScopedBean = mySessionScopedBean;
	}

}