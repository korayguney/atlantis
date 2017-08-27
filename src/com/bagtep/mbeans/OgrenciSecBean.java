package com.bagtep.mbeans;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.bagtep.business.DersService;
import com.bagtep.business.KabaDegerlendirmeService;
import com.bagtep.business.OgrenciService;
import com.bagtep.business.SinifService;
import com.bagtep.domain.Ders;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.Sinif;
 
@ManagedBean
@ViewScoped
public class OgrenciSecBean implements Serializable {
     
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String ders;
    private String sinif; 
    private String ogrenci;  
    private Map<String,String> dersler;
    private Map<String,String> siniflar;
    private List<Sinif> tumsiniflar;
    private List<Ders> tumdersler;

    private Map<String,String> ogrenciler2;
    private List<Ogrenci> ogrenciler;
    private List<Ogrenci> ogrenciler3;
    static int x =0;

    
    @EJB
	private SinifService sinifService ;
    @EJB
	private DersService dersService ;
    @EJB
   	private OgrenciService ogrenciService ;
    @EJB
   	private KabaDegerlendirmeService kabaDegerlendirmeService ;

    @ManagedProperty("#{mySessionScopedBean}")
	private MySessionScopedBean mySessionScopedBean;
    
    // SINIF-ÖĞRENCİ MAP YAPMAMIZ GEREK! DERSLE MAP LEMEYE GEREK YOK!!
    
    @PostConstruct
    public void init() {
    	this.tumsiniflar = sinifService.getAllSinif();
    	this.tumdersler = dersService.getAllDers();
    	
    	
        siniflar  = new HashMap<String, String>();
        siniflar.put("USA", "USA");
        siniflar.put("Germany", "Germany");
        siniflar.put("Brazil", "Brazil");
         
        Map<String,String> map = new HashMap<String, String>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        data.put("USA", map);
         
        map = new HashMap<String, String>();
        map.put("Berlin", "Berlin");
        map.put("Munich", "Munich");
        map.put("Frankfurt", "Frankfurt");
        data.put("Germany", map);
         
        map = new HashMap<String, String>();
        map.put("Sao Paolo", "Sao Paolo");
        map.put("Rio de Janerio", "Rio de Janerio");
        map.put("Salvador", "Salvador");
        data.put("Brazil", map);
    }
 
    public Map<String, Map<String, String>> getData() {
        return data;
    }
 
    
 
    public String getDers() {
		return ders;
	}

	public void setDers(String ders) {
		this.ders = ders;
	}

	public Map<String, String> getDersler() {
		return dersler;
	}

	public void setDersler(Map<String, String> dersler) {
		this.dersler = dersler;
	}

		
	public String getSinif() {
		return sinif;
	}

	public void setSinif(String sinif) {
		this.sinif = sinif;
	}

	public Map<String, String> getSiniflar() {
		return siniflar;
	}

	public void setSiniflar(Map<String, String> siniflar) {
		this.siniflar = siniflar;
	}

    public String getOgrenci() {
		return ogrenci;
	}

	public void setOgrenci(String ogrenci) {
		this.ogrenci = ogrenci;
	}

	public Map<String, String> getOgrenciler2() {
		return ogrenciler2;
	}

	public void setOgrenciler2(Map<String, String> ogrenciler2) {
		this.ogrenciler2 = ogrenciler2;
	}

	public List<Sinif> getTumsiniflar() {
		return tumsiniflar;
	}

	public void setTumsiniflar(List<Sinif> tumsiniflar) {
		this.tumsiniflar = tumsiniflar;
	}

	public List<Ders> getTumdersler() {
		return tumdersler;
	}

	public void setTumdersler(List<Ders> tumdersler) {
		this.tumdersler = tumdersler;
	}

	public List<Ogrenci> getOgrenciler() {
		return ogrenciler;
	}

	public void setOgrenciler(List<Ogrenci> ogrenciler) {
		this.ogrenciler = ogrenciler;
	}

	public List<Ogrenci> getOgrenciler3() {
		return ogrenciler3;
	}

	public void setOgrenciler3(List<Ogrenci> ogrenciler3) {
		this.ogrenciler3 = ogrenciler3;
	}

	public void setData(Map<String, Map<String, String>> data) {
		this.data = data;
	}

	public MySessionScopedBean getMySessionScopedBean() {
		return mySessionScopedBean;
	}

	public void setMySessionScopedBean(MySessionScopedBean mySessionScopedBean) {
		this.mySessionScopedBean = mySessionScopedBean;
	}

	public void sinifDegistiginde() {
        if(sinif !=null && !sinif.equals(""))
        	ogrenciler2 = data.get(ders);
        else
        	ogrenciler2 = new HashMap<String, String>();
    }
	
	
	public void ogrencilisteleBEP() {
		System.out.println("ogrencilisteleBEP METODUNA GİRDİ");
		mySessionScopedBean.setSinif(sinif);
		ogrenciler = ogrenciService.getSelectedOgrenciForClass(sinif);
		final int ogrencilerSayisi = ogrenciler.size();

		for (int i = 0; i < ogrencilerSayisi; i++) {
			Ogrenci ogrenci = ogrenciler.get(i-x);
			
			boolean degerlendirmeSonuc = ogrenciService.dahaOnceKabaDegerlendirilmismi(ogrenci.getId(), ders);
			
			if(!degerlendirmeSonuc){
				ogrenciler.remove(ogrenci);
				System.out.println("SİLİNEN ÖĞRENCİ :" + ogrenci.getAd());
				x++;
			}
		}
		
		if(ogrenciler.isEmpty()){
         	 FacesContext.getCurrentInstance().
      		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "",sinif + " sınıfında "+ ders +" için Kaba Değerlendirmesi yapılmış öğrenci yoktur."));
         }else {
         	 FacesContext.getCurrentInstance().
       		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "",sinif + " sınıfında "+ ders +" için Kaba Değerlendirmesi yapılmış öğrenci sayısı : " + ogrenciler.size()));
  		}    
		
        x = 0;
	}
	
	public void ogrencilisteleDonemDegerlendirme() {
		System.out.println("ogrencilisteleDonemDegerlendirme METODUNA GİRDİ");
		mySessionScopedBean.setSinif(sinif);
		ogrenciler = ogrenciService.getSelectedOgrenciForClass(sinif);
		final int ogrencilerSayisi = ogrenciler.size();

        for (int i = 0; i < ogrencilerSayisi; i++) {
			Ogrenci ogrenci = ogrenciler.get(i-x);
			
			boolean degerlendirmeSonuc = ogrenciService.dahaOnceDegerlendirilmismi(ogrenci.getId(), ders);
			
			if(degerlendirmeSonuc){
				ogrenciler.remove(ogrenci);
				System.out.println("SİLİNEN ÖĞRENCİ :" + ogrenci.getAd());
				x++;
			}
		}
        
        if(ogrenciler.isEmpty()){
          	 FacesContext.getCurrentInstance().
       		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "",sinif + " sınıfında "+ ders +" için Dönem Değerlendirmesi yapılmamış öğrenci yoktur."));
          }else {
          	 FacesContext.getCurrentInstance().
        		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "",sinif + " sınıfında "+ ders +" için Dönem Değerlendirmesi yapılmamış öğrenci sayısı : " + ogrenciler.size()));
   		}     
        
        x = 0;
	}
	
	public void ogrencilisteleDonemDegerlendirmeGoruntule() {
		System.out.println("ogrencilisteleDonemDegerlendirmeGoruntule METODUNA GİRDİ");
		mySessionScopedBean.setSinif(sinif);
		ogrenciler = ogrenciService.getSelectedOgrenciForClass(sinif);
		final int ogrencilerSayisi = ogrenciler.size();

        for (int i = 0; i < ogrencilerSayisi; i++) {
			Ogrenci ogrenci = ogrenciler.get(i-x);
			
			boolean degerlendirmeSonuc = ogrenciService.dahaOnceDegerlendirilmismi(ogrenci.getId(), ders);
			
			if(!degerlendirmeSonuc){
				ogrenciler.remove(ogrenci);
				System.out.println("SİLİNEN ÖĞRENCİ :" + ogrenci.getAd());
				x++;
			}
		}
        
        if(ogrenciler.isEmpty()){
          	 FacesContext.getCurrentInstance().
       		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "",sinif + " sınıfında "+ ders +" için Dönem Değerlendirmesi yapılmış öğrenci yoktur."));
          }else {
          	 FacesContext.getCurrentInstance().
        		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "",sinif + " sınıfında "+ ders +" için Dönem Değerlendirmesi yapılmış öğrenci sayısı : " + ogrenciler.size()));
   		}     
        
        x = 0;
	}
	
	
	public void ogrencilisteleKabaDegerlendirme() {
		System.out.println("ogrencilisteleKabaDegerlendirme METODUNA GİRDİ");
		mySessionScopedBean.setSinif(sinif);
		ogrenciler = ogrenciService.getSelectedOgrenciForClass(sinif);
		final int ogrencilerSayisi = ogrenciler.size();

        for (int i = 0; i < ogrencilerSayisi; i++) {
			Ogrenci ogrenci = ogrenciler.get(i-x);
			
			boolean degerlendirmeSonuc = ogrenciService.dahaOnceKabaDegerlendirilmismi(ogrenci.getId(), ders);
			
			if(degerlendirmeSonuc){
				ogrenciler.remove(ogrenci);
				System.out.println("SİLİNEN ÖĞRENCİ :" + ogrenci.getAd());
				x++;
			}
		}
        
        if(ogrenciler.isEmpty()){
       	 FacesContext.getCurrentInstance().
    		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "",sinif + " sınıfında "+ ders +" için Kaba Değerlendirmesi yapılmamış öğrenci yoktur."));
       }else {
       	 FacesContext.getCurrentInstance().
     		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "",sinif + " sınıfında "+ ders +" için Kaba Değerlendirmesi yapılmamış öğrenci sayısı : " + ogrenciler.size()));
		}     
        x = 0;
	}
	
	public void ogrencilisteleKabaDegerlendirmeGoruntule() {
		System.out.println("ogrencilisteleKabaDegerlendirmeGruntule METODUNA GİRDİ");
		mySessionScopedBean.setSinif(sinif);
		ogrenciler = ogrenciService.getSelectedOgrenciForClass(sinif);
		final int ogrencilerSayisi = ogrenciler.size();

        for (int i = 0; i < ogrencilerSayisi; i++) {
			Ogrenci ogrenci = ogrenciler.get(i-x);
			
			boolean degerlendirmeSonuc = ogrenciService.dahaOnceKabaDegerlendirilmismi(ogrenci.getId(), ders);
			
			if(!degerlendirmeSonuc){
				ogrenciler.remove(ogrenci);
				System.out.println("SİLİNEN ÖĞRENCİ :" + ogrenci.getAd());
				x++;
			}
		}
        if(ogrenciler.isEmpty()){
        	 FacesContext.getCurrentInstance().
     		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "",sinif + " sınıfında "+ ders +" için Kaba Değerlendirmesi yapılmış öğrenci yoktur."));
        }else {
        	 FacesContext.getCurrentInstance().
      		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "",sinif + " sınıfında "+ ders +" için Kaba Değerlendirmesi yapılmış öğrenci sayısı : " + ogrenciler.size()));
		}       
        x = 0;
	}
	
	public void degerlendirmegoruntule() {
        System.out.println("degerlendirmegoruntule METODUNA GİRDİ");
        kabaDegerlendirmeService.getDegerlendirme();
        // öğrencinin ilgili ders için service ten degerlendirmesini alarak UI a döndürecek...
	}
	
	public void gelisimGoruntule() {
        System.out.println("gelisimGoruntule METODUNA GİRDİ");
        kabaDegerlendirmeService.getGelisim();
        // öğrencinin ilgili ders için service ten degerlendirmesini alarak UI a döndürecek...
	}
	
    public String onay(Ogrenci ogrenci) {

    	System.out.println("ONAY METODA GİRDİ");
        
        mySessionScopedBean.setAd(ogrenci.getAd());
        mySessionScopedBean.setSoyad(ogrenci.getSoyad());
        mySessionScopedBean.setOgrenciId(ogrenci.getId());
        mySessionScopedBean.setSinif(ogrenci.getSinif().toString());
        mySessionScopedBean.setOgrencino(ogrenci.getOgrencino());

        // kabaDegerlendirmeService.degerlendirmeKaydet();
        
        
        return "users/admin/adminkabadegerlendirme";
//        return "users/admin/adminkabadegerlendirme";
        
//        DROPDOWN MENÜYÜ DÜZELTTİĞİMİZDE BURAYI AÇACAĞIZ! ŞİMDİLİK DOĞRUDAN ADMİNKABADEĞERLENDİRMEYE GİTSİN !!!
//       
//        FacesMessage msg;
//        if(ogrenci != null && sinif != null && ders != null)
//            msg = new FacesMessage("Selected", ogrenci + " of " + ders);
//        else
//            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hata!", "Öğrenci seçilmedi."); 
             
//        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
}
