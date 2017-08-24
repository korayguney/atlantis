package com.bagtep.domain;

import java.io.Serializable;
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
public class DonemDegerlendirme implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7178144692990724278L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date degerlendirmeTarihi;
	private String degerlendirici;
	
	@OneToMany(mappedBy="donemDegerlendirme")
	private List<DonemDegerlendirmeKazanimCevap> donemDegerlendirmeKazanimCevap;
	
	@ManyToOne
	private Ogrenci ogrenci;
	
	@ManyToOne
	private Ders ders;	
	

	public DonemDegerlendirme() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public List<DonemDegerlendirmeKazanimCevap> getDonemDegerlendirmeKazanimCevap() {
		return donemDegerlendirmeKazanimCevap;
	}

	public void setDonemDegerlendirmeKazanimCevap(List<DonemDegerlendirmeKazanimCevap> donemDegerlendirmeKazanimCevap) {
		this.donemDegerlendirmeKazanimCevap = donemDegerlendirmeKazanimCevap;
	}

	public String getDegerlendirici() {
		return degerlendirici;
	}

	public void setDegerlendirici(String degerlendirici) {
		this.degerlendirici = degerlendirici;
	}

	@Override
	public String toString() {
		return "KabaDegerlendirme [id=" + id + "]";
	}
	
	
	

}
