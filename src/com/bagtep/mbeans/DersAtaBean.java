package com.bagtep.mbeans;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.bagtep.business.DersService;
import com.bagtep.business.OgrenciService;
import com.bagtep.business.OgretmenService;
import com.bagtep.business.SinifService;
import com.bagtep.domain.Ders;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.Ogretmen;
import com.bagtep.domain.Sinif;

@ManagedBean
public class DersAtaBean {

	private List<Ogretmen> ogretmenler;
	private List<Ogrenci> ogrenciler;
	private List<Ders> dersler;
	private List<Sinif> siniflar;
	private Map<Ogretmen, Ders> ogretmenDers = new LinkedHashMap<>();
	
	private int ogretmenId;
	private int ogrenciId;
	private int dersId;
	private int sinifId;

	@EJB
	private DersService dersService;
	@EJB
	private OgretmenService ogretmenService;
	@EJB
	private OgrenciService ogrenciService;
	@EJB
	private SinifService sinifService;

	@PostConstruct
	public void init() {
		this.ogretmenler = ogretmenService.tumOgretmenleriGetir();
		this.dersler = dersService.getAllDers();
		this.ogrenciler = ogrenciService.getAllOgrenci();
		this.siniflar = sinifService.getAllSinif();

	}

	public void ekle() {
		ogretmenService.ogretmeneDersAta(ogretmenId, dersId);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bilgilendirme"));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ders Başarıyla Atandı!"));

	}
	
	public void ogretmeneAtananDersleriGetir() {
		this.ogretmenDers = ogretmenService.ogretmeneAtananDersleriGetir(ogretmenId,dersId);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bilgilendirme"));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ogretmeneAtananDersleriGetir! "+ogretmenDers.isEmpty()));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ogretmeneAtananDersleriGetir! "+ogretmenDers.size()));

	}
	
	public void dersAtaSinif() {
		sinifService.derseSinifAta(dersId, sinifId);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bilgilendirme"));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ders Başarıyla Atandı!"));

	}
	
	public void ekleSinif() {
		sinifService.ogretmeneSinifAta(ogretmenId, sinifId);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bilgilendirme"));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sinif Başarıyla Atandı!"));

	}
	
//	public void sil(int ogretmenId) {
//		
//		ogretmenService.ogretmeneAtananDersSil(ogretmenId);
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bilgilendirme"));
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atama Başarıyla Silindi!"));
//
//	}

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

	public int getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(int ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public List<Ogrenci> getOgrenciler() {
		return ogrenciler;
	}

	public void setOgrenciler(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}

	public List<Sinif> getSiniflar() {
		return siniflar;
	}

	public void setSiniflar(List<Sinif> siniflar) {
		this.siniflar = siniflar;
	}

	public int getSinifId() {
		return sinifId;
	}

	public void setSinifId(int sinifId) {
		this.sinifId = sinifId;
	}

	public Map<Ogretmen, Ders> getOgretmenDers() {
		return ogretmenDers;
	}

	public void setOgretmenDers(Map<Ogretmen, Ders> ogretmenDers) {
		this.ogretmenDers = ogretmenDers;
	}
	
	
	
	
}
