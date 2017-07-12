package com.bagtep.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.bagtep.business.DersService;
import com.bagtep.business.OgretmenService;
import com.bagtep.domain.BransOgretmeni;
import com.bagtep.domain.Ders;
import com.bagtep.domain.Ogretmen;

@ManagedBean
public class DersAtaBean {

	private List<Ogretmen> ogretmenler;
	private List<Ders> dersler;

	private int ogretmenId;
	private int dersId;


	@EJB
	private DersService dersService;
	@EJB
	private OgretmenService ogretmenService;

	@PostConstruct
	public void init() {
		this.ogretmenler = ogretmenService.tumSinifOgretmenleriniGetir();
		this.dersler = dersService.getAllDers();
	}

	public void ekle()
	{
		ogretmenService.ogretmeneDersAta(ogretmenId,dersId);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Bilgilendirme"));
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Ders Başarıyla Atandı!"));
		
	}
	
	public List<Ogretmen> getOgretmenler() {
		return ogretmenler;
	}

	public void setOgretmenler(List<Ogretmen> ogretmenler) {
		this.ogretmenler = ogretmenler;
	}

	public int getOgretmenId() {
		return ogretmenId;
	}

	public void setOgretmenId(int ogretmenId) {
		this.ogretmenId = ogretmenId;
	}

	public int getDersId() {
		return dersId;
	}

	public void setDersId(int dersId) {
		this.dersId = dersId;
	}

	public List<Ders> getDersler() {
		return dersler;
	}

	public void setDersler(List<Ders> dersler) {
		this.dersler = dersler;
	}

	
	
	
}
