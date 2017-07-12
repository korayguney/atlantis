package com.bagtep.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.bagtep.business.KabaDegerlendirmeService;
import com.bagtep.business.OgrenciService;
import com.bagtep.domain.KabaDegerlendirme;
import com.bagtep.domain.Ogrenci;

@ManagedBean
public class KabaDegerlendirmeBean {

	List<KabaDegerlendirme> kabadegerlendirme2 = new ArrayList<>();
	KabaDegerlendirme kabadegerlendirme;
	private int ogrenciId;
	private String dersAd;
	private String ogrenciAd;
	
	
	@EJB
	private KabaDegerlendirmeService kabaDegerlendirmeService ;
	@EJB
	private OgrenciService ogrenciService ;
	
	@PostConstruct
	public void init()
	{
		HttpServletRequest req = (HttpServletRequest) 
				FacesContext.getCurrentInstance().getExternalContext().getRequest();
		int ogrenciId = Integer.parseInt( req.getParameter("oid"));
		this.ogrenciAd = ogrenciService.getOgrenciAd(ogrenciId);
	}
	
	
	
	public void degerlendirmeKaydet(){
		
//		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//		int ogrenciId = Integer.parseInt( req.getParameter("oid"));
//		System.out.println("Seçilen Ogrenci id : "+ogrenciId );
		

		kabaDegerlendirmeService.degerlendirmeKaydet(4, "Hayat Bilgisi");
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



	public int getOgrenciId() {
		return ogrenciId;
	}



	public void setOgrenciId(int ogrenciId) {
		this.ogrenciId = ogrenciId;
	}



	public String getDersAd() {
		return dersAd;
	}



	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}



	public String getOgrenciAd() {
		return ogrenciAd;
	}



	public void setOgrenciAd(String ogrenciAd) {
		this.ogrenciAd = ogrenciAd;
	}


	
	
	 		
	

}
