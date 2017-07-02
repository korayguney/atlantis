package com.bagtep.domain;

import java.util.List;

import javax.persistence.Entity;
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
	
	@ManyToOne
	private GenelAmac genelAmac;
	private String icerik;
	
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
	@Override
	public String toString() {
		return "OzelAmac [id=" + id + ", kazanimlar=" + kazanimlar + ", genelAmac=" + genelAmac + ", icerik=" + icerik
				+ "]";
	}
	
	
	

}
