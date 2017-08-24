package com.bagtep.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Kazanim implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -5515962866275174728L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String icerik;
	
	@ManyToOne
	private OzelAmac ozelAmac;
	
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

	
	
	
	

}
