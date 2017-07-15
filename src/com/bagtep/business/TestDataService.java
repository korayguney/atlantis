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
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.Ogretmen;
import com.bagtep.domain.OzelAmac;
import com.bagtep.domain.Sinif;
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
			
			User u1 = new User("Koray", "Güney", "koray", "1234", "Admin");
			User u2 = new User("Zeki", "Çelik", "zeki", "1234", "Admin");
			User u3 = new User("Ahmet", "Demirelli", "ahmet", "1234", "Admin");
			User u4 = new User("Bülent", "Dertli", "bulent", "1234", "Öğretmen");
			User u5 = new User("Ulaş", "Yirmi", "ulas", "1234", "Öğretmen");
			User u6 = new User("Merve", "Tosun", "merve", "1234", "Öğretmen");
			User u7 = new User("Ali", "Bektaş", "ali", "1234", "Öğretmen");
			User u8 = new User("Veli", "Çakır", "veli", "1234", "Öğretmen");
			User u9 = new User("Serkan", "Doğuş", "serkan", "1234", "Öğretmen");

			
			u1.setPassword(Utilities.hashPassword(u1.getPassword()));
			u2.setPassword(Utilities.hashPassword(u2.getPassword()));
			u3.setPassword(Utilities.hashPassword(u3.getPassword()));
			u4.setPassword(Utilities.hashPassword(u4.getPassword()));
			u5.setPassword(Utilities.hashPassword(u5.getPassword()));
			u6.setPassword(Utilities.hashPassword(u6.getPassword()));
			u7.setPassword(Utilities.hashPassword(u7.getPassword()));
			u8.setPassword(Utilities.hashPassword(u8.getPassword()));
			u9.setPassword(Utilities.hashPassword(u9.getPassword()));
						
			Sinif sinif1= new Sinif("1-A");
			Sinif sinif2= new Sinif("1-B");
			Sinif sinif3= new Sinif("2-A");
			Sinif sinif4= new Sinif("2-B");
			Sinif sinif5= new Sinif("3-A");
			Sinif sinif6= new Sinif("3-B");
			Sinif sinif7= new Sinif("4-A");
			Sinif sinif8= new Sinif("4-B");
			Sinif sinif9= new Sinif("5-A");

			Ogrenci ogrenci1 = new Ogrenci("Leyla", "Şeker", 111, "Kız", "Veli", "Kurtuluş", "05305554433", "Tuzla/İstanbul");
			Ogrenci ogrenci2 = new Ogrenci("Ayşe", "Lale", 222, "Kız", "Ali", "Kurtuluş", "05305554444", "Kartal/İstanbul");
			Ogrenci ogrenci3 = new Ogrenci("Fatma", "Çakmak", 333, "Kız", "Remzi", "Kurtuluş", "05305554455", "Pendik/İstanbul");
			Ogrenci ogrenci4 = new Ogrenci("Eren", "Tarım", 444, "Erkek", "Haydar", "Kurtuluş", "05305554466", "Ataşehir/İstanbul");
			Ogrenci ogrenci5 = new Ogrenci("Şakir", "Parmak", 555, "Erkek", "Kemal", "Kurtuluş", "05305554477", "Kadıköy/İstanbul");
			Ogrenci ogrenci6 = new Ogrenci("Bülent", "Gerçek", 666, "Erkek", "Serdar", "Kurtuluş", "05305554488", "Üsküdar/İstanbul");
			
			Ogretmen ogretmen1 = new Ogretmen("Bülent", "Dertli");
			Ogretmen ogretmen2 = new Ogretmen("Ulaş", "Yirmi");
			Ogretmen ogretmen3 = new Ogretmen("Merve", "Tosun");
			Ogretmen ogretmen4 = new Ogretmen("Ali", "Bektaş");
			Ogretmen ogretmen5 = new Ogretmen("Veli", "Çakır");
			Ogretmen ogretmen6 = new Ogretmen("Serkan", "Doğuş");
					
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
	
			// Kullanıcıları KAYDET

			entityManager.persist(u1);
			entityManager.persist(u2);
			entityManager.persist(u3);
			entityManager.persist(u4);
			entityManager.persist(u5);
			entityManager.persist(u6);
			entityManager.persist(u7);
			entityManager.persist(u8);
			entityManager.persist(u9);

			// Sınıf KAYDET
			
			entityManager.persist(sinif1);
			entityManager.persist(sinif2);
			entityManager.persist(sinif3);
			entityManager.persist(sinif4);
			entityManager.persist(sinif5);
			entityManager.persist(sinif6);
			entityManager.persist(sinif7);
			entityManager.persist(sinif8);
			entityManager.persist(sinif9);
			
			// Öğrenci KAYDET
			
			entityManager.persist(ogrenci1);
			entityManager.persist(ogrenci2);
			entityManager.persist(ogrenci3);
			entityManager.persist(ogrenci4);
			entityManager.persist(ogrenci5);
			entityManager.persist(ogrenci6);
			
			// Öğretmen KAYDET
			
			entityManager.persist(ogretmen1);
			entityManager.persist(ogretmen2);
			entityManager.persist(ogretmen3);
			entityManager.persist(ogretmen4);
			entityManager.persist(ogretmen5);
			entityManager.persist(ogretmen6);

			try {
				InputStream in = getClass().getResourceAsStream("/com/bagtep/domain/testdata/matematik.txt");
				BufferedReader rd = new BufferedReader(new InputStreamReader(in, "utf-8"));
				
				
				
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
