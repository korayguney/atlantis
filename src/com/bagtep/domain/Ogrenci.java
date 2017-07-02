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

@Entity
public class Ogrenci {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String ad;
	private String soyad;
	private int ogrencino;
	private String cinsiyet;
	private Date dogumTarih;
	private String veliad;
	private String velisoyad;
	private long telefon;
	private String evadres;
	
	@ManyToOne
	private Sinif sinif;
	
	@ManyToMany(mappedBy="ogrenciler")
	private List<Ders> dersler;
	
	@OneToMany(mappedBy="ogrenci")
	private List<KabaDegerlendirme> kabadegerlendirmeler;
	
	public Ogrenci() {
		// TODO Auto-generated constructor stub
	}
	
	public Ogrenci(String ad, String soyad, int ogrencino, String cinsiyet, Date dogumTarih, Sinif sinif,
			String veliad, String velisoyad, long telefon, String evadres) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.ogrencino = ogrencino;
		this.cinsiyet = cinsiyet;
		this.dogumTarih = dogumTarih;
		this.sinif = sinif;
		this.veliad = veliad;
		this.velisoyad = velisoyad;
		this.telefon = telefon;
		this.evadres = evadres;
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
	public int getOgrencino() {
		return ogrencino;
	}
	public void setOgrencino(int ogrencino) {
		this.ogrencino = ogrencino;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public Date getDogumTarih() {
		return dogumTarih;
	}
	public void setDogumTarih(Date dogumTarih) {
		this.dogumTarih = dogumTarih;
	}
	
	public Sinif getSinif() {
		return sinif;
	}

	public void setSinif(Sinif sinif) {
		this.sinif = sinif;
	}

	public String getVeliad() {
		return veliad;
	}
	public void setVeliad(String veliad) {
		this.veliad = veliad;
	}
	public String getVelisoyad() {
		return velisoyad;
	}
	public void setVelisoyad(String velisoyad) {
		this.velisoyad = velisoyad;
	}
	public long getTelefon() {
		return telefon;
	}
	public void setTelefon(long telefon) {
		this.telefon = telefon;
	}
	public String getEvadres() {
		return evadres;
	}
	public void setEvadres(String evadres) {
		this.evadres = evadres;
	}

	public List<Ders> getDersler() {
		return dersler;
	}

	public void setDersler(List<Ders> dersler) {
		this.dersler = dersler;
	}
	
	public List<KabaDegerlendirme> getKabadegerlendirmeler() {
		return kabadegerlendirmeler;
	}

	public void setKabadegerlendirmeler(List<KabaDegerlendirme> kabadegerlendirmeler) {
		this.kabadegerlendirmeler = kabadegerlendirmeler;
	}

	@Override
	public String toString() {
		return ad + " " + soyad ;
	}
	
	
	
	

}
