package com.bagtep.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.bagtep.business.KabaDegerlendirmeService;
import com.bagtep.domain.KabaDegerlendirme;

@ManagedBean
public class KabaDegerlendirmeBean {

	List<KabaDegerlendirme> kabadegerlendirme2 = new ArrayList<>();
	KabaDegerlendirme kabadegerlendirme;
	
	@EJB
	private KabaDegerlendirmeService kabaDegerlendirmeService ;
	
	public KabaDegerlendirmeBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init()
	{

	}
	
	
	public void degerlendirmeKaydet(){
		
		kabaDegerlendirmeService.degerlendirmeKaydet();
		FacesContext.getCurrentInstance().
		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "","Kaba Değerlendirme Başarıyla Kaydedildi !!!"));
		
	}

	public List<KabaDegerlendirme> getKabadegerlendirme2() {
		return kabadegerlendirme2;
	}

	public void setKabadegerlendirme2(List<KabaDegerlendirme> kabadegerlendirme2) {
		this.kabadegerlendirme2 = kabadegerlendirme2;
	}

	public KabaDegerlendirme getKabadegerlendirme() {
		return kabadegerlendirme;
	}

	public void setKabadegerlendirme(KabaDegerlendirme kabadegerlendirme) {
		this.kabadegerlendirme = kabadegerlendirme;
	}

	
	
	 		
	

}
