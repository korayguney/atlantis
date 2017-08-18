package com.bagtep.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OzelAmac {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="ozelAmac")
	private List<Kazanim> kazanimlar;
	
	@OneToMany(mappedBy="ozelAmac")
	private List<KabaDegerlendirmeKazanimCevap> kabaDegerlendirmeKazanimCevap;
	
	@ManyToOne
	private GenelAmac genelAmac;
	private String icerik;
	private double degerlendirmePuani;
	
	public OzelAmac(GenelAmac genelAmac, String icerik) {
		super();
		this.genelAmac = genelAmac;
		this.icerik = icerik;
	}
	public OzelAmac() {
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
	public GenelAmac getGenelAmac() {
		return genelAmac;
	}
	public void setGenelAmac(GenelAmac genelAmac) {
		this.genelAmac = genelAmac;
	}
	public String getIcerik() {
		return icerik;
	}
	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}
	public List<KabaDegerlendirmeKazanimCevap> getKabaDegerlendirmeKazanimCevap() {
		return kabaDegerlendirmeKazanimCevap;
	}
	public void setKabaDegerlendirmeKazanimCevap(List<KabaDegerlendirmeKazanimCevap> kabaDegerlendirmeKazanimCevap) {
		this.kabaDegerlendirmeKazanimCevap = kabaDegerlendirmeKazanimCevap;
	}
	public double getDegerlendirmePuani() {
		return degerlendirmePuani;
	}
	public void setDegerlendirmePuani(double degerlendirmePuani) {
		this.degerlendirmePuani = degerlendirmePuani;
	}
	
	
	
	

}
