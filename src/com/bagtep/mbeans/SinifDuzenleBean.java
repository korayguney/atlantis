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
import com.bagtep.business.SinifService;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.Sinif;


@ManagedBean
@ViewScoped
public class SinifDuzenleBean {
	
	private List<Sinif> siniflar;
	
	@EJB
	private SinifService sinifService;
	private Sinif newSinif = new Sinif();
	
	@PostConstruct
	public void init()
	{
		this.siniflar = sinifService.getAllSinif();
	}

	public void onRowEdit(RowEditEvent event) {
	         Sinif sinif = (Sinif) event.getObject();
	         sinifService.updateSinif(sinif);
	         FacesContext.getCurrentInstance().addMessage(null, 
	        		 new FacesMessage("Sonuç : "));
	         FacesContext.getCurrentInstance().addMessage(null, 
	        		 new FacesMessage(sinif.getSinifAd()+" güncellendi."));
	    }
	  
	public void deleteSinif(int sinifId)
	  {
		  System.out.println("Bu sinif silinecek --> "+sinifId);
		  sinifService.deleteSinif(sinifId);
		  this.siniflar=sinifService.getAllSinif();
	  }

	public List<Sinif> getSiniflar() {
		return siniflar;
	}

	public void setSiniflar(List<Sinif> siniflar) {
		this.siniflar = siniflar;
	}

	public Sinif getNewSinif() {
		return newSinif;
	}

	public void setNewSinif(Sinif newSinif) {
		this.newSinif = newSinif;
	}
	 
	
	
	
	

}
