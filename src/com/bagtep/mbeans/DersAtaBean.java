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
//	private Map<Ogretmen, Ders> ogretmenDers = new LinkedHashMap<>();
	private Ogretmen ogretmen;
	
	private int ogretmenId;
	private int ogrenciId;
	private int dersId;
	private int sinifId;
	private String ogretmenAd;
	private String ogretmenSoyad;
	private String dersAd;
	

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
		System.out.println("DERS ID ::::::XxX::::::" + dersId);
		System.out.println("OGRETMEN ID ::::::XxX::::::" + ogretmenId);
		this.ogretmenler = ogretmenService.tumOgretmenleriGetir();
		this.dersler = dersService.getAllDers();
		this.ogrenciler = ogrenciService.getAllOgrenci();
		this.siniflar = sinifService.getAllSinif();
//		this.ogretmen = ogretmenService.ogretmeneAtananDersleriGetir(ogretmenId,dersId);

	}

	public void ekle() {
		this.ogretmen = ogretmenService.ogretmeneDersAta(ogretmenId, dersId);
		System.out.println("EKLE METODUNDAKİ ÖĞRETMEN : " + ogretmen.getAd());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bilgilendirme"));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ders Başarıyla Atandı!"));
		
	}
	
	public void ogretmeneAtananDersleriGetir() {
		this.ogretmen = ogretmenService.ogretmeneAtananDersleriGetir(ogretmenId,dersId);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bilgilendirme"));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ogretmeneAtananDersleriGetir! "+ogretmen.getAd()));
		
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

	
	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

	public String getOgretmenAd() {
		return ogretmenAd;
	}

	public void setOgretmenAd(String ogretmenAd) {
		this.ogretmenAd = ogretmenAd;
	}

	public String getOgretmenSoyad() {
		return ogretmenSoyad;
	}

	public void setOgretmenSoyad(String ogretmenSoyad) {
		this.ogretmenSoyad = ogretmenSoyad;
	}

	public String getDersAd() {
		return dersAd;
	}

	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}
	
	
	
	
}
