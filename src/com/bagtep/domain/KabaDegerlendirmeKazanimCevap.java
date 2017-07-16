package com.bagtep.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class KabaDegerlendirmeKazanimCevap {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private boolean kabaDegerlendirmeCevap;
	private String yorum;
	
	@ManyToOne
	private KabaDegerlendirme kabaDegerlendirme;
	
	@ManyToOne
	private Kazanim kazanim;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public boolean isKabaDegerlendirmeCevap() {
		return kabaDegerlendirmeCevap;
	}

	public void setKabaDegerlendirmeCevap(boolean kabaDegerlendirmeCevap) {
		this.kabaDegerlendirmeCevap = kabaDegerlendirmeCevap;
	}

	public String getYorum() {
		return yorum;
	}

	public void setYorum(String yorum) {
		this.yorum = yorum;
	}

	public KabaDegerlendirme getKabaDegerlendirme() {
		return kabaDegerlendirme;
	}

	public void setKabaDegerlendirme(KabaDegerlendirme kabaDegerlendirme) {
		this.kabaDegerlendirme = kabaDegerlendirme;
	}

	public Kazanim getKazanim() {
		return kazanim;
	}

	public void setKazanim(Kazanim kazanim) {
		this.kazanim = kazanim;
	}
	
	
	
	
	
	
	
}
