package com.bagtep.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class KabaDegerlendirme {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date degerlendirmeTarihi;
	private String kabaDegerlendirmeCevap;
	private String yorum;
	
	@ManyToMany(mappedBy="kabadegerlendirmeler")
	private List<Kazanim> kazanimlar;
	
	@ManyToOne
	private Ogrenci ogrenci;
	
	@ManyToOne
	private Ders ders;	
	
		
	public KabaDegerlendirme(Date degerlendirmeTarihi, String kabaDegerlendirmeCevap) {
		super();
		this.degerlendirmeTarihi = degerlendirmeTarihi;
		this.kabaDegerlendirmeCevap = kabaDegerlendirmeCevap;
	}

	public KabaDegerlendirme() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Kazanim> getKazanimlar() {
		return kazanimlar;
	}

	public void setKazanimlar(List<Kazanim> kazanimlar) {
		this.kazanimlar = kazanimlar;
	}
	
	public Ogrenci getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}

	public Ders getDers() {
		return ders;
	}

	public void setDers(Ders ders) {
		this.ders = ders;
	}
		
	public Date getDegerlendirmeTarihi() {
		return degerlendirmeTarihi;
	}

	public void setDegerlendirmeTarihi(Date degerlendirmeTarihi) {
		this.degerlendirmeTarihi = degerlendirmeTarihi;
	}
	
	public String getKabaDegerlendirmeCevap() {
		return kabaDegerlendirmeCevap;
	}

	public void setKabaDegerlendirmeCevap(String kabaDegerlendirmeCevap) {
		this.kabaDegerlendirmeCevap = kabaDegerlendirmeCevap;
	}
	
	public String getYorum() {
		return yorum;
	}

	public void setYorum(String yorum) {
		this.yorum = yorum;
	}

	@Override
	public String toString() {
		return "KabaDegerlendirme [id=" + id + ", kazanimlar=" + kazanimlar + "]";
	}
	
	
	

}
