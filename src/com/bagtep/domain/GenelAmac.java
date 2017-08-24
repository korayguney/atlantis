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
public class GenelAmac implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1880186859779551734L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@OneToMany(mappedBy="genelAmac")
	private List<OzelAmac> ozelAmaclar;
	
	@ManyToOne
	private Ders ders;
	
	private String icerik;

	public GenelAmac(Ders ders, String icerik) {
		super();
		this.ders = ders;
		this.icerik = icerik;
	}

	public GenelAmac() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OzelAmac> getOzelAmaclar() {
		return ozelAmaclar;
	}

	public void setOzelAmaclar(List<OzelAmac> ozelAmaclar) {
		this.ozelAmaclar = ozelAmaclar;
	}

	public Ders getDers() {
		return ders;
	}

	public void setDers(Ders ders) {
		this.ders = ders;
	}

	public String getIcerik() {
		return icerik;
	}

	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}

}
