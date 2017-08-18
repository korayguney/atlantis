package com.bagtep.mbeans;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.bagtep.business.DersService;
import com.bagtep.business.KabaDegerlendirmeService;
import com.bagtep.business.OgrenciService;
import com.bagtep.business.TestDataService3;
import com.bagtep.domain.GenelAmac;
import com.bagtep.domain.Kazanim;
import com.bagtep.domain.OzelAmac;

@ManagedBean
@ViewScoped
public class BireyselEgitimPlaniBean {

	private int ogrenciId;
	private int dersId;
	private String dersAd;
	private String ogrenciAd;
	private String ogrenciSoyad;
	private GenelAmac genelAmac;
	private GenelAmac genelAmac2;
	private GenelAmac genelAmac3;
	private GenelAmac genelAmac4;
	private GenelAmac genelAmac5;
	private GenelAmac genelAmac6;
	private GenelAmac genelAmac7;
	private GenelAmac genelAmac8;
	private GenelAmac genelAmac9;
	private GenelAmac genelAmac10;
	private GenelAmac genelAmac11;
	private GenelAmac genelAmac12;
	private GenelAmac genelAmac13;
	private GenelAmac genelAmac14;
	private GenelAmac genelAmac15;
	private GenelAmac genelAmac16;
	private GenelAmac genelAmac17;
	private Map<Integer, Boolean> ozelAmaclarMap = new LinkedHashMap<Integer, Boolean>();
	private Map<Integer, String> ozelAmacYorum = new LinkedHashMap<Integer, String>();
	private Map<Integer, OzelAmac > ozelAmacIdMap = new LinkedHashMap<Integer, OzelAmac>();
	private OzelAmac ozelAmac;



	@EJB
	private TestDataService3 testDataService3;
	@EJB
	private KabaDegerlendirmeService kabaDegerlendirmeService;
	@EJB
	private OgrenciService ogrenciService;
	@EJB
	private DersService dersService;
	
	@ManagedProperty("#{mySessionScopedBean}")
	private MySessionScopedBean mySessionScopedBean;	
	
	@PostConstruct
	public void init() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		ogrenciId = Integer.parseInt(req.getParameter("oid"));
		this.dersAd = req.getParameter("did");
	
		System.out.println("Seçilen Ders adı : " + dersAd);
		System.out.println("Seçilen Ogrenci id : " + ogrenciId);
		
		this.ogrenciAd = ogrenciService.getOgrenciAd(ogrenciId);
		this.ogrenciSoyad = ogrenciService.getOgrenciSoyad(ogrenciId);
		this.dersId = dersService.getId(dersAd);
		
		if(dersAd.equals("Matematik")){
		this.genelAmac = testDataService3.getGenelAmac(dersId, 1, ogrenciId);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac2 = testDataService3.getGenelAmac(dersId, 2, ogrenciId);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac3 = testDataService3.getGenelAmac(dersId, 3, ogrenciId);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac4 = testDataService3.getGenelAmac(dersId, 4, ogrenciId);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac5 = testDataService3.getGenelAmac(dersId, 5, ogrenciId);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac6 = testDataService3.getGenelAmac(dersId, 6, ogrenciId);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		}else if(dersAd.equals("Dil ve Konuşma Gelişimi")){
		this.genelAmac = testDataService3.getGenelAmac(dersId, 1, ogrenciId);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac2 = testDataService3.getGenelAmac(dersId, 2, ogrenciId);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac3 = testDataService3.getGenelAmac(dersId, 3, ogrenciId);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac4 = testDataService3.getGenelAmac(dersId, 4, ogrenciId);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac5 = testDataService3.getGenelAmac(dersId, 5, ogrenciId);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		
		this.genelAmac6 = testDataService3.getGenelAmac(dersId, 6, ogrenciId);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac7 = testDataService3.getGenelAmac(dersId, 7, ogrenciId);
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			
		}else if(dersAd.equals("Din Kültürü ve Ahlak Bilgisi")){
			this.genelAmac = testDataService3.getGenelAmac(dersId, 1, ogrenciId);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac2 = testDataService3.getGenelAmac(dersId, 2, ogrenciId);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		
		this.genelAmac3 = testDataService3.getGenelAmac(dersId, 3, ogrenciId);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac4 = testDataService3.getGenelAmac(dersId, 4, ogrenciId);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		}else if(dersAd.equals("Hayat Bilgisi")){
			this.genelAmac = testDataService3.getGenelAmac(dersId, 1, ogrenciId);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}

			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac2 = testDataService3.getGenelAmac(dersId, 2, ogrenciId);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac3 = testDataService3.getGenelAmac(dersId, 3, ogrenciId);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac4 = testDataService3.getGenelAmac(dersId, 4, ogrenciId);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac5 = testDataService3.getGenelAmac(dersId, 5, ogrenciId);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		
		this.genelAmac6 = testDataService3.getGenelAmac(dersId, 6, ogrenciId);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac7 = testDataService3.getGenelAmac(dersId, 7, ogrenciId);
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac8 = testDataService3.getGenelAmac(dersId, 8, ogrenciId);
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac9 = testDataService3.getGenelAmac(dersId, 9, ogrenciId);
			for (OzelAmac o : this.genelAmac9.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac9.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac9.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		
		this.genelAmac10 = testDataService3.getGenelAmac(dersId, 10, ogrenciId);
			for (OzelAmac o : this.genelAmac10.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac10.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac10.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac11 = testDataService3.getGenelAmac(dersId, 11, ogrenciId);
			for (OzelAmac o : this.genelAmac11.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac11.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac11.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac12 = testDataService3.getGenelAmac(dersId, 12, ogrenciId);
			for (OzelAmac o : this.genelAmac12.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac12.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac12.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac13 = testDataService3.getGenelAmac(dersId, 13, ogrenciId);
			for (OzelAmac o : this.genelAmac13.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac13.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac13.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac14 = testDataService3.getGenelAmac(dersId, 14, ogrenciId);
			for (OzelAmac o : this.genelAmac14.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac14.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac14.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac15 = testDataService3.getGenelAmac(dersId, 15, ogrenciId);
			for (OzelAmac o : this.genelAmac15.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac15.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac15.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac16 = testDataService3.getGenelAmac(dersId, 16, ogrenciId);
			for (OzelAmac o : this.genelAmac16.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac16.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac16.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac17 = testDataService3.getGenelAmac(dersId, 17, ogrenciId);
			for (OzelAmac o : this.genelAmac17.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac17.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac17.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			
		}else if(dersAd.equals("Müzik")){
			this.genelAmac = testDataService3.getGenelAmac(dersId, 1, ogrenciId);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac2 = testDataService3.getGenelAmac(dersId, 2, ogrenciId);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		
		this.genelAmac3 = testDataService3.getGenelAmac(dersId, 3, ogrenciId);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac4 = testDataService3.getGenelAmac(dersId, 4, ogrenciId);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac5 = testDataService3.getGenelAmac(dersId, 5, ogrenciId);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac6 = testDataService3.getGenelAmac(dersId, 6, ogrenciId);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac7 = testDataService3.getGenelAmac(dersId, 7, ogrenciId);
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac8 = testDataService3.getGenelAmac(dersId, 8, ogrenciId);
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac9 = testDataService3.getGenelAmac(dersId, 9, ogrenciId);
			for (OzelAmac o : this.genelAmac9.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac9.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac9.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac10 = testDataService3.getGenelAmac(dersId, 10, ogrenciId);
			for (OzelAmac o : this.genelAmac10.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac10.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac10.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac11 = testDataService3.getGenelAmac(dersId, 11, ogrenciId);
			for (OzelAmac o : this.genelAmac11.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac11.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac11.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		}else if(dersAd.equals("Beslenme Bilgisi")){
		this.genelAmac = testDataService3.getGenelAmac(dersId, 1, ogrenciId);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac2 = testDataService3.getGenelAmac(dersId, 2, ogrenciId);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac3 = testDataService3.getGenelAmac(dersId, 3, ogrenciId);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac4 = testDataService3.getGenelAmac(dersId, 4, ogrenciId);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac5 = testDataService3.getGenelAmac(dersId, 5, ogrenciId);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		}else if(dersAd.equals("Görsel Sanatlar")){
			this.genelAmac = testDataService3.getGenelAmac(dersId, 1, ogrenciId);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac2 = testDataService3.getGenelAmac(dersId, 2, ogrenciId);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac3 = testDataService3.getGenelAmac(dersId, 3, ogrenciId);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac4 = testDataService3.getGenelAmac(dersId, 4, ogrenciId);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac5 = testDataService3.getGenelAmac(dersId, 5, ogrenciId);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		
		this.genelAmac6 = testDataService3.getGenelAmac(dersId, 6, ogrenciId);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac7 = testDataService3.getGenelAmac(dersId, 7, ogrenciId);
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac8 = testDataService3.getGenelAmac(dersId, 8, ogrenciId);
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			
		}else if(dersAd.equals("Okuma Yazma")){
			this.genelAmac = testDataService3.getGenelAmac(dersId, 1, ogrenciId);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac2 = testDataService3.getGenelAmac(dersId, 2, ogrenciId);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac3 = testDataService3.getGenelAmac(dersId, 3, ogrenciId);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac4 = testDataService3.getGenelAmac(dersId, 4, ogrenciId);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac5 = testDataService3.getGenelAmac(dersId, 5, ogrenciId);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac6 = testDataService3.getGenelAmac(dersId, 6, ogrenciId);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		}else if(dersAd.equals("Trafik ve İlk Yardım Eğitimi")){
			this.genelAmac = testDataService3.getGenelAmac(dersId, 1, ogrenciId);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac2 = testDataService3.getGenelAmac(dersId, 2, ogrenciId);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac3 = testDataService3.getGenelAmac(dersId, 3, ogrenciId);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac4 = testDataService3.getGenelAmac(dersId, 4, ogrenciId);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}

			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac5 = testDataService3.getGenelAmac(dersId, 5, ogrenciId);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		
		this.genelAmac6 = testDataService3.getGenelAmac(dersId, 6, ogrenciId);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		}else if(dersAd.equals("Beden Eğitimi")){
			this.genelAmac = testDataService3.getGenelAmac(dersId, 1, ogrenciId);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac2 = testDataService3.getGenelAmac(dersId, 2, ogrenciId);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		
		this.genelAmac3 = testDataService3.getGenelAmac(dersId, 3, ogrenciId);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac4 = testDataService3.getGenelAmac(dersId, 4, ogrenciId);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}

		this.genelAmac5 = testDataService3.getGenelAmac(dersId, 5, ogrenciId);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac6 = testDataService3.getGenelAmac(dersId, 6, ogrenciId);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac7 = testDataService3.getGenelAmac(dersId, 7, ogrenciId);
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac8 = testDataService3.getGenelAmac(dersId, 8, ogrenciId);
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		}else if(dersAd.equals("Toplumsal Uyum Becerileri")){
			this.genelAmac = testDataService3.getGenelAmac(dersId, 1, ogrenciId);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac2 = testDataService3.getGenelAmac(dersId, 2, ogrenciId);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac3 = testDataService3.getGenelAmac(dersId, 3, ogrenciId);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac4 = testDataService3.getGenelAmac(dersId, 4, ogrenciId);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac5 = testDataService3.getGenelAmac(dersId, 5, ogrenciId);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		this.genelAmac6 = testDataService3.getGenelAmac(dersId, 6, ogrenciId);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacYorum.put(o.getId(), "");
			}
			
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
		}

		
	}

	public void degerlendirmeKaydet() {
		int kazanimId = new Kazanim().getId();
		System.out.println("Seçilen Ogrenci id : " + ogrenciId);
		
		// testMethod();
		
		String degerlendirici = mySessionScopedBean.getFirstname() +" "+ mySessionScopedBean.getLastname();
		
		kabaDegerlendirmeService.degerlendirmeKaydet(ogrenciId, dersAd, degerlendirici, ozelAmaclarMap, ozelAmacYorum, ozelAmacIdMap);
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
	
	
	public String getOgrenciSoyad() {
		return ogrenciSoyad;
	}

	public void setOgrenciSoyad(String ogrenciSoyad) {
		this.ogrenciSoyad = ogrenciSoyad;
	}

	public MySessionScopedBean getMySessionScopedBean() {
		return mySessionScopedBean;
	}

	public void setMySessionScopedBean(MySessionScopedBean mySessionScopedBean) {
		this.mySessionScopedBean = mySessionScopedBean;
	}

	public Map<Integer, String> getOzelAmacYorum() {
		return ozelAmacYorum;
	}

	public void setOzelAmacYorum(Map<Integer, String> ozelAmacYorum) {
		this.ozelAmacYorum = ozelAmacYorum;
	}

	public int getDersId() {
		return dersId;
	}

	public void setDersId(int dersId) {
		this.dersId = dersId;
	}

	public GenelAmac getGenelAmac4() {
		return genelAmac4;
	}

	public void setGenelAmac4(GenelAmac genelAmac4) {
		this.genelAmac4 = genelAmac4;
	}

	public GenelAmac getGenelAmac5() {
		return genelAmac5;
	}

	public void setGenelAmac5(GenelAmac genelAmac5) {
		this.genelAmac5 = genelAmac5;
	}

	public GenelAmac getGenelAmac6() {
		return genelAmac6;
	}

	public void setGenelAmac6(GenelAmac genelAmac6) {
		this.genelAmac6 = genelAmac6;
	}

	public GenelAmac getGenelAmac7() {
		return genelAmac7;
	}

	public void setGenelAmac7(GenelAmac genelAmac7) {
		this.genelAmac7 = genelAmac7;
	}

	public GenelAmac getGenelAmac8() {
		return genelAmac8;
	}

	public void setGenelAmac8(GenelAmac genelAmac8) {
		this.genelAmac8 = genelAmac8;
	}

	public GenelAmac getGenelAmac9() {
		return genelAmac9;
	}

	public void setGenelAmac9(GenelAmac genelAmac9) {
		this.genelAmac9 = genelAmac9;
	}

	public GenelAmac getGenelAmac10() {
		return genelAmac10;
	}

	public void setGenelAmac10(GenelAmac genelAmac10) {
		this.genelAmac10 = genelAmac10;
	}

	public GenelAmac getGenelAmac11() {
		return genelAmac11;
	}

	public void setGenelAmac11(GenelAmac genelAmac11) {
		this.genelAmac11 = genelAmac11;
	}

	public GenelAmac getGenelAmac12() {
		return genelAmac12;
	}

	public void setGenelAmac12(GenelAmac genelAmac12) {
		this.genelAmac12 = genelAmac12;
	}

	public GenelAmac getGenelAmac13() {
		return genelAmac13;
	}

	public void setGenelAmac13(GenelAmac genelAmac13) {
		this.genelAmac13 = genelAmac13;
	}

	public GenelAmac getGenelAmac14() {
		return genelAmac14;
	}

	public void setGenelAmac14(GenelAmac genelAmac14) {
		this.genelAmac14 = genelAmac14;
	}

	public GenelAmac getGenelAmac15() {
		return genelAmac15;
	}

	public void setGenelAmac15(GenelAmac genelAmac15) {
		this.genelAmac15 = genelAmac15;
	}

	public GenelAmac getGenelAmac16() {
		return genelAmac16;
	}

	public void setGenelAmac16(GenelAmac genelAmac16) {
		this.genelAmac16 = genelAmac16;
	}

	public GenelAmac getGenelAmac17() {
		return genelAmac17;
	}

	public void setGenelAmac17(GenelAmac genelAmac17) {
		this.genelAmac17 = genelAmac17;
	}

	
	public TestDataService3 getTestDataService3() {
		return testDataService3;
	}

	public void setTestDataService3(TestDataService3 testDataService3) {
		this.testDataService3 = testDataService3;
	}

	public KabaDegerlendirmeService getKabaDegerlendirmeService() {
		return kabaDegerlendirmeService;
	}

	public void setKabaDegerlendirmeService(KabaDegerlendirmeService kabaDegerlendirmeService) {
		this.kabaDegerlendirmeService = kabaDegerlendirmeService;
	}

	public OgrenciService getOgrenciService() {
		return ogrenciService;
	}

	public void setOgrenciService(OgrenciService ogrenciService) {
		this.ogrenciService = ogrenciService;
	}

	public DersService getDersService() {
		return dersService;
	}

	public void setDersService(DersService dersService) {
		this.dersService = dersService;
	}

	public OzelAmac getOzelAmac() {
		return ozelAmac;
	}

	public void setOzelAmac(OzelAmac ozelAmac) {
		this.ozelAmac = ozelAmac;
	}

	public Map<Integer, OzelAmac> getOzelAmacIdMap() {
		return ozelAmacIdMap;
	}

	public void setOzelAmacIdMap(Map<Integer, OzelAmac> ozelAmacIdMap) {
		this.ozelAmacIdMap = ozelAmacIdMap;
	}
	
}
