package com.bagtep.business;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bagtep.domain.Ders;
import com.bagtep.domain.GenelAmac;
import com.bagtep.domain.Kazanim;
import com.bagtep.domain.OzelAmac;
import com.bagtep.domain.User;
import com.bagtep.utils.Utilities;

@Stateless
public class TestDataService {

	@PersistenceContext
	private EntityManager entityManager;

	public void createTestData() {
		Kazanim k = entityManager.find(Kazanim.class, 1);
		if (k == null) {
			System.out.println("Hiç veri yok, yenisi giriliyor");
			GenelAmac genelAmac = null;
			OzelAmac ozelAmac = null;
			Kazanim kazanim = null;
			User u = new User("aaa", "aaa", "aaa", "aaa", "Admin");
			u.setPassword(Utilities.hashPassword(u.getPassword()));
			try {
				InputStream in = getClass().getResourceAsStream("/com/bagtep/domain/testdata/matematik.txt");
				BufferedReader rd = new BufferedReader(new InputStreamReader(in, "utf-8"));
				Ders matematik = new Ders("Matematik");
				entityManager.persist(matematik);
				entityManager.persist(u);
				while (true) {
					String line = rd.readLine();
					if (line == null)
						break;

					if (line.contains("ÜNİTE")) {
						genelAmac = new GenelAmac(matematik, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						ozelAmac = new OzelAmac(genelAmac, line);
						entityManager.persist(ozelAmac);
					}
					if (!line.contains("ÜNİTE") && !line.contains("Amaç ") && !line.contains("Davranışlar ")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Test data created");
		} else {
			System.out.println("Test data already exist");
		}

	}

	public GenelAmac getGenelAmac(int genelAmacId) {
		GenelAmac genelAmac =  entityManager.find(GenelAmac.class, genelAmacId);
		for(OzelAmac o : genelAmac.getOzelAmaclar())
		{
			for(Kazanim k : o.getKazanimlar())
			{
				
			}
		}
		return genelAmac;
	}

}
