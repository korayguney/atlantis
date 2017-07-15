package com.bagtep.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Kazanim {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String icerik;
	
	@ManyToOne
	private OzelAmac ozelAmac;
	
	@OneToMany(mappedBy="kazanim")
	private List<KabaDegerlendirmeKazanimCevap> kabaDegerlendirmeKazanimCevap;
	
	public Kazanim(String icerik, OzelAmac ozelAmac) {
		super();
		this.icerik = icerik;
		this.ozelAmac = ozelAmac;
	}

	public Kazanim() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIcerik() {
		return icerik;
	}

	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}

	public OzelAmac getOzelAmac() {
		return ozelAmac;
	}

	public void setOzelAmac(OzelAmac ozelAmac) {
		this.ozelAmac = ozelAmac;
	}

	public List<KabaDegerlendirmeKazanimCevap> getKabaDegerlendirmeKazanimCevap() {
		return kabaDegerlendirmeKazanimCevap;
	}

	public void setKabaDegerlendirmeKazanimCevap(List<KabaDegerlendirmeKazanimCevap> kabaDegerlendirmeKazanimCevap) {
		this.kabaDegerlendirmeKazanimCevap = kabaDegerlendirmeKazanimCevap;
	}
	
	
	
	

}
