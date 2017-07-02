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
import com.bagtep.domain.Ogrenci;


@ManagedBean
@ViewScoped
public class OgrenciDuzenleBean {
	
	private List<Ogrenci> ogrenciler;
	
	@EJB
	private OgrenciService ogrenciService;
	private Ogrenci newOgrenci = new Ogrenci();
	
	@PostConstruct
	public void init()
	{
		this.ogrenciler = ogrenciService.getAllOgrenci();
	}

	  public void onRowEdit(RowEditEvent event) {
	         Ogrenci ogrenci = (Ogrenci) event.getObject();
	         ogrenciService.updateOgrenci(ogrenci);
	         FacesContext.getCurrentInstance().addMessage(null, 
	        		 new FacesMessage(ogrenci.getAd()+" güncellendi."));
	    }
	  
	  public void deleteOgrenci(int ogrenciId)
	  {
		  System.out.println("Bu öğrenci silinecek --> "+ogrenciId);
		  ogrenciService.deleteOgrenci(ogrenciId);
		  this.ogrenciler=ogrenciService.getAllOgrenci();
	  }
	  
	  public void addOgrenci()
	  {
		  ogrenciService.addNewOgrenci(this.newOgrenci);
		  this.ogrenciler=ogrenciService.getAllOgrenci();
	  }

	public List<Ogrenci> getOgrenciler() {
		return ogrenciler;
	}

	public void setOgrenciler(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}

	public Ogrenci getNewOgrenci() {
		return newOgrenci;
	}

	public void setNewOgrenci(Ogrenci newOgrenci) {
		this.newOgrenci = newOgrenci;
	}
	
	

}
