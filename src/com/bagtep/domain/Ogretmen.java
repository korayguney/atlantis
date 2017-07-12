package com.bagtep.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Ogretmen {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String ad;
	private String soyad;
	
	@OneToOne
	private Sinif sinif;
	
	@ManyToMany 
	private List<Ders> dersler;
	
	public Ogretmen() {
		// TODO Auto-generated constructor stub
	}
	
	public Ogretmen(String ad, String soyad, Sinif sinif) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.sinif = sinif;
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

	public Sinif getSinif() {
		return sinif;
	}

	public void setSinif(Sinif sinif) {
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
		return "Ogretmen [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", sinif=" + sinif + ", dersler="
				+ dersler + "]";
	}
	
	
	
	
	
	

}
