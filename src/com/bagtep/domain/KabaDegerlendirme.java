package com.bagtep.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class KabaDegerlendirme {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	

}
