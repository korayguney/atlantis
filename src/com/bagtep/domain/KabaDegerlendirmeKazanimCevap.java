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
	
	private String kabaDegerlendirmeCevap;
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
