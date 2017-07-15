package com.bagtep.mbeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.bagtep.business.KabaDegerlendirmeService;
import com.bagtep.business.OgrenciService;
import com.bagtep.business.TestDataService;
import com.bagtep.domain.GenelAmac;
import com.bagtep.domain.KabaDegerlendirme;
import com.bagtep.domain.Kazanim;
import com.bagtep.domain.Ogrenci;
import com.bagtep.domain.OzelAmac;

@ManagedBean
@ViewScoped
public class KabaDegerlendirmeBean {

	List<KabaDegerlendirme> kabadegerlendirme2 = new ArrayList<>();
	KabaDegerlendirme kabadegerlendirme;
	private int ogrenciId;
	private String dersAd;
	private String ogrenciAd;
	private GenelAmac genelAmac;
	private GenelAmac genelAmac2;
	private GenelAmac genelAmac3;
	private Map<Integer, Boolean> ozelAmaclarMap = new LinkedHashMap<Integer, Boolean>();


	@EJB
	private TestDataService testDataService;
	@EJB
	private KabaDegerlendirmeService kabaDegerlendirmeService;
	@EJB
	private OgrenciService ogrenciService;
	
	@ManagedProperty("#{mySessionScopedBean}")
	private MySessionScopedBean mySessionScopedBean;	
	
	@PostConstruct
	public void init() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		ogrenciId = Integer.parseInt(req.getParameter("oid"));
		System.out.println("Seçilen Ogrenci id : " + ogrenciId);
		this.ogrenciAd = ogrenciService.getOgrenciAd(ogrenciId);
		this.genelAmac = testDataService.getGenelAmac(1);

		for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
			this.ozelAmaclarMap.put(o.getId(), false);
		}

		this.genelAmac2 = testDataService.getGenelAmac(2);
		this.genelAmac3 = testDataService.getGenelAmac(3);
	}

	public void degerlendirmeKaydet() {

		System.out.println("Seçilen Ogrenci id : " + ogrenciId);
		testMethod();
		
		String degerlendirici = mySessionScopedBean.getFirstname() +" "+ mySessionScopedBean.getLastname();

		kabaDegerlendirmeService.degerlendirmeKaydet(ogrenciId, "Matematik", degerlendirici);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Kaba Değerlendirme Başarıyla Kaydedildi !!!"));
	}
	
	// Konsoldan kabadeğerlendirme cevaplarını kontrol etmek için..
	public void testMethod() {
		for (Integer key : this.ozelAmaclarMap.keySet()) {
			System.out.println(key + " : " + this.ozelAmaclarMap.get(key));
		}
	}
	
	
	public GenelAmac getGenelAmac() {
		return genelAmac;
	}

	public void setGenelAmac(GenelAmac genelAmac) {
		this.genelAmac = genelAmac;
	}

	public GenelAmac getGenelAmac2() {
		return genelAmac2;
	}

	public void setGenelAmac2(GenelAmac genelAmac2) {
		this.genelAmac2 = genelAmac2;
	}

	public GenelAmac getGenelAmac3() {
		return genelAmac3;
	}

	public void setGenelAmac3(GenelAmac genelAmac3) {
		this.genelAmac3 = genelAmac3;
	}

	public Map<Integer, Boolean> getOzelAmaclarMap() {
		return ozelAmaclarMap;
	}

	public void setOzelAmaclarMap(Map<Integer, Boolean> ozelAmaclarMap) {
		this.ozelAmaclarMap = ozelAmaclarMap;
	}
	
	public List<KabaDegerlendirme> getKabadegerlendirme2() {
		return kabadegerlendirme2;
	}

	public void setKabadegerlendirme2(List<KabaDegerlendirme> kabadegerlendirme2) {
		this.kabadegerlendirme2 = kabadegerlendirme2;
	}

	public KabaDegerlendirme getKabadegerlendirme() {
		return kabadegerlendirme;
	}

	public void setKabadegerlendirme(KabaDegerlendirme kabadegerlendirme) {
		this.kabadegerlendirme = kabadegerlendirme;
	}

	public int getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(int ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public String getDersAd() {
		return dersAd;
	}

	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}

	public String getOgrenciAd() {
		return ogrenciAd;
	}

	public void setOgrenciAd(String ogrenciAd) {
		this.ogrenciAd = ogrenciAd;
	}
	public MySessionScopedBean getMySessionScopedBean() {
		return mySessionScopedBean;
	}

	public void setMySessionScopedBean(MySessionScopedBean mySessionScopedBean) {
		this.mySessionScopedBean = mySessionScopedBean;
	}
}
