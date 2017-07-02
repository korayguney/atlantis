package com.bagtep.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class BransOgretmeni {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String ad;
	private String soyad;
	
	@ManyToMany
	private List<Sinif> sinif;
	
	@ManyToMany 
	private List<Ders> dersler;
	
	public BransOgretmeni(String ad, String soyad) {
		super();
		this.ad = ad;
		this.soyad = soyad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public List<Sinif> getSinif() {
		return sinif;
	}

	public void setSinif(List<Sinif> sinif) {
		this.sinif = sinif;
	}

	public List<Ders> getDersler() {
		return dersler;
	}

	public void setDersler(List<Ders> dersler) {
		this.dersler = dersler;
	}

	@Override
	public String toString() {
		return "SinifOgretmeni [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", sinif=" + sinif + ", dersler="
				+ dersler + "]";
	}
	
	
	
	
	
	

}
