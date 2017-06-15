package com.bagtep.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.jws.soap.SOAPBinding.Use;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.bagtep.exceptions.UsernameExistsException;
import com.bagtep.business.OgrenciService;
import com.bagtep.domain.Ogrenci;

@ManagedBean
public class OgrenciEkleBean {

	private Ogrenci newOgrenci = new Ogrenci();
		
	private List<Ogrenci> ogrenciler ;
	
	@EJB
	private OgrenciService ogrenciService ;
	
	public OgrenciEkleBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init()
	{
		this.ogrenciler = ogrenciService.getAllOgrenci();
	}
	
	
	public String add()
	{
		ogrenciService.saveOgrenci(this.newOgrenci);
		this.ogrenciler = ogrenciService.getAllOgrenci();
		FacesContext.getCurrentInstance().
		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "","Yeni öğrenci başarıyla eklendi!!"));
		return "foofoo";//forwarding
	}
	
	 public void deleteOgrenci(int ogrenciId) {
	        
	        ogrenciService.deleteOgrenci(ogrenciId);
	        this.ogrenciler=ogrenciService.getAllOgrenci();
	        FacesContext.getCurrentInstance().
			addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "","Öğrenci başarıyla silindi!!"));
	    }
	 	 
	 public void onRowEdit(RowEditEvent event) {
         Ogrenci ogrenci = (Ogrenci) event.getObject();
        // ogrenciService.updateUserWithEdit(ogrenci);
         FacesContext.getCurrentInstance().addMessage(null, 
        		 new FacesMessage(ogrenci.getAd()+" düzenlendi"));
    }

	public Ogrenci getNewOgrenci() {
		return newOgrenci;
	}

	public void setNewOgrenci(Ogrenci newOgrenci) {
		this.newOgrenci = newOgrenci;
	}

	public List<Ogrenci> getOgrenciler() {
		return ogrenciler;
	}

	public void setOgrenciler(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}
	 		
	

}
