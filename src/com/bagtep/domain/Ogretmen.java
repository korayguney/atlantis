package com.bagtep.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ogretmen {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String ad;
	private String soyad;
	
	@ManyToMany(mappedBy="ogretmen")
	private List<Sinif> siniflar;
	
	@ManyToMany 
	private List<Ders> dersler;
	
	public Ogretmen() {
		// TODO Auto-generated constructor stub
	}
	
	public Ogretmen(String ad, String soyad) {
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

	public List<Ders> getDersler() {
		return dersler;
	}

	public void setDersler(List<Ders> dersler) {
		this.dersler = dersler;
	}

	public List<Sinif> getSiniflar() {
		return siniflar;
	}

	public void setSiniflar(List<Sinif> siniflar) {
		this.siniflar = siniflar;
	}

	
	
	
	
	
	
	
	

}
