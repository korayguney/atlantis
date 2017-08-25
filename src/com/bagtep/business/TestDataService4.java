package com.bagtep.business;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bagtep.domain.Ders;
import com.bagtep.domain.GenelAmac;
import com.bagtep.domain.KabaDegerlendirme;
import com.bagtep.domain.KabaDegerlendirmeKazanimCevap;
import com.bagtep.domain.Kazanim;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.Ogretmen;
import com.bagtep.domain.OzelAmac;
import com.bagtep.domain.Sinif;
import com.bagtep.domain.User;
import com.bagtep.utils.Utilities;

@Stateless
public class TestDataService4 {

	@PersistenceContext
	private EntityManager entityManager;

		
	public GenelAmac getGenelAmac(int dersId, int genelAmacId) {
	
		Query q = entityManager.createNativeQuery("SELECT g.id FROM genelamac g, ders d WHERE g.ders_id = ?");
		q.setParameter(1, dersId);
		List<GenelAmac> genelAmaclar = q.getResultList();
//		System.out.println("-----------------------");
//		System.out.println("GENEL AMAÇLAR MİKTAR : " + genelAmaclar.size());
	
		 GenelAmac genelAmac = entityManager.find(GenelAmac.class, genelAmaclar.get(genelAmacId));
				for (OzelAmac o : genelAmac.getOzelAmaclar()) {
					for (Kazanim k : o.getKazanimlar()) {

					}
				}
				return genelAmac;
		
	}

}
