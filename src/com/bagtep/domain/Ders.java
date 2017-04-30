package com.bagtep.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="ders")
	private List<GenelAmac> genelAmaclar;
	
	private String dersAd;

	public Ders(String dersAd) {
		super();
		this.dersAd = dersAd;
	}

	public Ders() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<GenelAmac> getGenelAmaclar() {
		return genelAmaclar;
	}

	public void setGenelAmaclar(List<GenelAmac> genelAmaclar) {
		this.genelAmaclar = genelAmaclar;
	}

	public String getDersAd() {
		return dersAd;
	}

	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}

}
