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
import com.bagtep.domain.Kazanim;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.Ogretmen;
import com.bagtep.domain.OzelAmac;
import com.bagtep.domain.Sinif;
import com.bagtep.domain.User;
import com.bagtep.utils.Utilities;

@Stateless
public class TestDataService2 {

	@PersistenceContext
	private EntityManager entityManager;

	public void createTestData() {
		final long start = System.nanoTime();

		Kazanim k = entityManager.find(Kazanim.class, 1);
		if (k == null) {
			System.out.println("Hiç veri yok, yenisi giriliyor2");
			GenelAmac genelAmac = null;
			OzelAmac ozelAmac = null;
			Kazanim kazanim = null;
		

			Ders matematik = new Ders("Matematik");
			Ders dilvekonusma = new Ders("Dil ve Konuşma Gelişimi");
			Ders dinkulturu = new Ders("Din Kültürü ve Ahlak Bilgisi");
			Ders hayatbilgisi = new Ders("Hayat Bilgisi");
			Ders muzik = new Ders("Müzik");
			Ders beslenme = new Ders("Beslenme Bilgisi");
			Ders gorselsanat = new Ders("Görsel Sanatlar");
			Ders okumayazma = new Ders("Okuma Yazma");
			Ders trafik = new Ders("Trafik ve İlk Yardım Eğitimi");
			Ders bedenegitimi = new Ders("Beden Eğitimi");
			Ders toplumsaluyum = new Ders("Toplumsal Uyum Becerileri");

			// Dersleri KAYDET

			entityManager.persist(matematik);
			entityManager.persist(dilvekonusma);
			entityManager.persist(dinkulturu);
			entityManager.persist(muzik);
			entityManager.persist(hayatbilgisi);
			entityManager.persist(beslenme);
			entityManager.persist(gorselsanat);
			entityManager.persist(okumayazma);
			entityManager.persist(trafik);
			entityManager.persist(bedenegitimi);
			entityManager.persist(toplumsaluyum);

			try {
				// DİL VE KONUŞMA GELİŞİMİ DERSİ VERİLERİ GİRİLİYOR !!!
				InputStream in1 = getClass()
						.getResourceAsStream("/com/bagtep/domain/testdata/dilvekonusmagelisimi.txt");
				BufferedReader rd1 = new BufferedReader(new InputStreamReader(in1, "utf-8"));

				while (true) {
					String line = rd1.readLine();
					if (line == null)
						break;

					if (line.contains("Genel Amaç")) {
						genelAmac = new GenelAmac(dilvekonusma, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						
//						String[] lineWithoutPharantesis = line.split(Pattern.quote("("));
//						ozelAmac = new OzelAmac(genelAmac, lineWithoutPharantesis[0]);
						ozelAmac = new OzelAmac(genelAmac, line);

						entityManager.persist(ozelAmac);
					}
					if (!line.contains("Genel Amaç") && !line.contains("Amaç ") && !line.contains("Davranış")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}

				// DİN KÜLTÜRÜ VE AHLAK BİLGİSİ DERSİ VERİLERİ GİRİLİYOR !!!
				InputStream in2 = getClass()
						.getResourceAsStream("/com/bagtep/domain/testdata/dinkulturuveahlakbilgisi.txt");
				BufferedReader rd2 = new BufferedReader(new InputStreamReader(in2, "utf-8"));

				while (true) {
					String line = rd2.readLine();
					if (line == null)
						break;

					if (line.contains("Genel Amaç")) {
						genelAmac = new GenelAmac(dinkulturu, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						ozelAmac = new OzelAmac(genelAmac, line);
						entityManager.persist(ozelAmac);
					}
					if (!line.contains("Genel Amaç") && !line.contains("Amaç ") && !line.contains("Davranış")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}

				// HAYAT BİLGİSİ DERSİ VERİLERİ GİRİLİYOR !!!
				InputStream in3 = getClass().getResourceAsStream("/com/bagtep/domain/testdata/hayatbilgisi.txt");
				BufferedReader rd3 = new BufferedReader(new InputStreamReader(in3, "utf-8"));

				while (true) {
					String line = rd3.readLine();
					if (line == null)
						break;

					if (line.contains("Genel Amaç")) {
						genelAmac = new GenelAmac(hayatbilgisi, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						ozelAmac = new OzelAmac(genelAmac, line);
						entityManager.persist(ozelAmac);
					}
					if (!line.contains("Genel Amaç") && !line.contains("Amaç ") && !line.contains("Davranış")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}

				// MÜZİK DERSİ VERİLERİ GİRİLİYOR !!!
				InputStream in4 = getClass().getResourceAsStream("/com/bagtep/domain/testdata/muzik.txt");
				BufferedReader rd4 = new BufferedReader(new InputStreamReader(in4, "utf-8"));

				while (true) {
					String line = rd4.readLine();
					if (line == null)
						break;

					if (line.contains("Genel Amaç")) {
						genelAmac = new GenelAmac(muzik, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						ozelAmac = new OzelAmac(genelAmac, line);
						entityManager.persist(ozelAmac);
					}
					if (!line.contains("Genel Amaç") && !line.contains("Amaç ") && !line.contains("Davranış")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}

				// BESLENME DERSİ VERİLERİ GİRİLİYOR !!!
				InputStream in5 = getClass().getResourceAsStream("/com/bagtep/domain/testdata/beslenme.txt");
				BufferedReader rd5 = new BufferedReader(new InputStreamReader(in5, "utf-8"));

				while (true) {
					String line = rd5.readLine();
					if (line == null)
						break;

					if (line.contains("Genel Amaç")) {
						genelAmac = new GenelAmac(beslenme, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						ozelAmac = new OzelAmac(genelAmac, line);
						entityManager.persist(ozelAmac);
					}
					if (!line.contains("Genel Amaç") && !line.contains("Amaç ") && !line.contains("Davranış")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}

				// GÖRSEL SANATLAR VERİLERİ GİRİLİYOR !!!
				InputStream in6 = getClass().getResourceAsStream("/com/bagtep/domain/testdata/gorselsanatlar.txt");
				BufferedReader rd6 = new BufferedReader(new InputStreamReader(in6, "utf-8"));

				while (true) {
					String line = rd6.readLine();
					if (line == null)
						break;

					if (line.contains("Genel Amaç")) {
						genelAmac = new GenelAmac(gorselsanat, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						ozelAmac = new OzelAmac(genelAmac, line);
						entityManager.persist(ozelAmac);
					}
					if (!line.contains("Genel Amaç") && !line.contains("Amaç ") && !line.contains("Davranış")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}
				
				// OKUMA YAZMA DERSİ VERİLERİ GİRİLİYOR !!!
				InputStream in7 = getClass().getResourceAsStream("/com/bagtep/domain/testdata/okumayazma.txt");
				BufferedReader rd7 = new BufferedReader(new InputStreamReader(in7, "utf-8"));

				while (true) {
					String line = rd7.readLine();
					if (line == null)
						break;

					if (line.contains("Genel Amaç")) {
						genelAmac = new GenelAmac(okumayazma, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						ozelAmac = new OzelAmac(genelAmac, line);
						entityManager.persist(ozelAmac);
					}
					if (!line.contains("Genel Amaç") && !line.contains("Amaç ") && !line.contains("Davranış")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}

				// MATEMATİK DERSİ VERİLERİ GİRİLİYOR !!! (ASIL)
				InputStream in8 = getClass().getResourceAsStream("/com/bagtep/domain/testdata/matematik2.txt");
				BufferedReader rd8 = new BufferedReader(new InputStreamReader(in8, "utf-8"));

				while (true) {
					String line = rd8.readLine();
					if (line == null)
						break;

					if (line.contains("Genel Amaç")) {
						genelAmac = new GenelAmac(matematik, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						ozelAmac = new OzelAmac(genelAmac, line);
						entityManager.persist(ozelAmac);
					}
					if (!line.contains("Genel Amaç") && !line.contains("Amaç ") && !line.contains("Davranış")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}

				// TRAFİK VE İLKYARDIM DERSİ VERİLERİ GİRİLİYOR !!!
				InputStream in9 = getClass().getResourceAsStream("/com/bagtep/domain/testdata/trafik.txt");
				BufferedReader rd9 = new BufferedReader(new InputStreamReader(in9, "utf-8"));

				while (true) {
					String line = rd9.readLine();
					if (line == null)
						break;

					if (line.contains("Genel Amaç")) {
						genelAmac = new GenelAmac(trafik, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						ozelAmac = new OzelAmac(genelAmac, line);
						entityManager.persist(ozelAmac);
					}
					if (!line.contains("Genel Amaç") && !line.contains("Amaç ") && !line.contains("Davranış")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}

				// BEDEN EĞİTİMİ DERSİ VERİLERİ GİRİLİYOR !!!
				InputStream in10 = getClass().getResourceAsStream("/com/bagtep/domain/testdata/bedenegitimi.txt");
				BufferedReader rd10 = new BufferedReader(new InputStreamReader(in10, "utf-8"));

				while (true) {
					String line = rd10.readLine();
					if (line == null)
						break;

					if (line.contains("Genel Amaç")) {
						genelAmac = new GenelAmac(bedenegitimi, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						ozelAmac = new OzelAmac(genelAmac, line);
						entityManager.persist(ozelAmac);
					}
					if (!line.contains("Genel Amaç") && !line.contains("Amaç ") && !line.contains("Davranış")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}

				// TOPLUMSAL UYUM BECERİLERİ DERSİ VERİLERİ GİRİLİYOR !!!
				InputStream in11 = getClass().getResourceAsStream("/com/bagtep/domain/testdata/toplumsaluyum.txt");
				BufferedReader rd11 = new BufferedReader(new InputStreamReader(in11, "utf-8"));

				while (true) {
					String line = rd11.readLine();
					if (line == null)
						break;

					if (line.contains("Genel Amaç")) {
						genelAmac = new GenelAmac(toplumsaluyum, line);
						entityManager.persist(genelAmac);
					}
					if (line.contains("Amaç ")) {
						ozelAmac = new OzelAmac(genelAmac, line);
						entityManager.persist(ozelAmac);
					}
					if (!line.contains("Genel Amaç") && !line.contains("Amaç ") && !line.contains("Davranış")
							&& line.length() > 5) {
						kazanim = new Kazanim(line, ozelAmac);
						entityManager.persist(kazanim);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			final long end = System.nanoTime();
			System.out.println("Test data created in " + ((end - start) / 1000000) + "ms");
		} else {
			System.out.println("Test data already exist");
		}

	}

	public GenelAmac getGenelAmac(int dersId, int genelAmacId) {
	
		Query q = entityManager.createNativeQuery("SELECT g.id FROM genelamac g, ders d WHERE g.ders_id = ?");
		q.setParameter(1, dersId);
		List<GenelAmac> genelAmaclar = q.getResultList();
		
		 GenelAmac genelAmac = entityManager.find(GenelAmac.class, genelAmaclar.get(genelAmacId));
				for (OzelAmac o : genelAmac.getOzelAmaclar()) {
					for (Kazanim k : o.getKazanimlar()) {

					}
				}
				return genelAmac;
		
	}

}
