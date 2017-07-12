package com.bagtep.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sinif {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(fetch=FetchType.EAGER , mappedBy="sinif")
	private List<Ogrenci> ogrenciler;
	
	@OneToOne(mappedBy="sinif")
	private Ogretmen ogretmen;
	
	private String sinifAd;

	
	public Sinif() {
		super();
	}
	
	public Sinif(List<Ogrenci> ogrenciler, String sinifAd) {
		super();
		this.ogrenciler = ogrenciler;
		this.sinifAd = sinifAd;
	}
	
	public Sinif(String sinifAd) {
		super();
		this.sinifAd = sinifAd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Ogrenci> getOgrenciler() {
		return ogrenciler;
	}

	public void setOgrenciler(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}

	public String getSinifAd() {
		return sinifAd;
	}

	public void setSinifAd(String sinifAd) {
		this.sinifAd = sinifAd;
	}

	public Ogretmen getOgretmen() {
		return ogretmen;
	}

	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}

	@Override
	public String toString() {
		return sinifAd;
	}

	

}
