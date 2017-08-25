package com.bagtep.mbeans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.bagtep.business.BireyselEgitimPlaniService;
import com.bagtep.business.DersService;
import com.bagtep.business.KabaDegerlendirmeService;
import com.bagtep.business.OgrenciService;
import com.bagtep.business.TestDataService4;
import com.bagtep.domain.GenelAmac;
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
	private Map<Integer, OzelAmac > ozelAmacIdMap = new LinkedHashMap<Integer, OzelAmac>();

	private List<OzelAmac> ozelAmacHayirVerilen = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen1 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen2 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen3 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen4 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen5 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen6 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen7 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen8 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen9 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen10 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen11 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen12 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen13 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen14 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen15 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen16 = new ArrayList<>();
	private List<OzelAmac> ozelAmacHayirVerilen17 = new ArrayList<>();


	@EJB
	private TestDataService4 testDataService4;
	@EJB
	private KabaDegerlendirmeService kabaDegerlendirmeService;
	@EJB
	private OgrenciService ogrenciService;
	@EJB
	private DersService dersService;
	@EJB
	private BireyselEgitimPlaniService bireyselEgitimPlaniService;
	
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
		
		ozelAmacHayirVerilen = bireyselEgitimPlaniService.kabaDegerlendirmedeHayirVerilenCevaplariGetir(dersId, ogrenciId);	
		
		if(dersAd.equals("Matematik")){
			this.genelAmac = testDataService4.getGenelAmac(dersId, 1);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac2 = testDataService4.getGenelAmac(dersId, 2);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac3 = testDataService4.getGenelAmac(dersId, 3);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac4 = testDataService4.getGenelAmac(dersId, 4);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac5 = testDataService4.getGenelAmac(dersId, 5);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac6 = testDataService4.getGenelAmac(dersId, 6);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			}else if(dersAd.equals("Dil ve Konuşma Gelişimi")){
			this.genelAmac = testDataService4.getGenelAmac(dersId, 1);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac2 = testDataService4.getGenelAmac(dersId, 2);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac3 = testDataService4.getGenelAmac(dersId, 3);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac4 = testDataService4.getGenelAmac(dersId, 4);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac5 = testDataService4.getGenelAmac(dersId, 5);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}		
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac6 = testDataService4.getGenelAmac(dersId, 6);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac7 = testDataService4.getGenelAmac(dersId, 7);
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			}else if(dersAd.equals("Din Kültürü ve Ahlak Bilgisi")){
			this.genelAmac = testDataService4.getGenelAmac(dersId, 1);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac2 = testDataService4.getGenelAmac(dersId, 2);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac3 = testDataService4.getGenelAmac(dersId, 3);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac4 = testDataService4.getGenelAmac(dersId, 4);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			}else if(dersAd.equals("Hayat Bilgisi")){
				this.genelAmac = testDataService4.getGenelAmac(dersId, 1);
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmaclarMap.put(o.getId(), false);
				}
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmacIdMap.put(o.getId(), o);
				}
			this.genelAmac2 = testDataService4.getGenelAmac(dersId, 2);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac3 = testDataService4.getGenelAmac(dersId, 3);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac4 = testDataService4.getGenelAmac(dersId, 4);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac5 = testDataService4.getGenelAmac(dersId, 5);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac6 = testDataService4.getGenelAmac(dersId, 6);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac7 = testDataService4.getGenelAmac(dersId, 7);
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac8 = testDataService4.getGenelAmac(dersId, 8);
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac9 = testDataService4.getGenelAmac(dersId, 9);
			for (OzelAmac o : this.genelAmac9.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac9.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac10 = testDataService4.getGenelAmac(dersId, 10);
			for (OzelAmac o : this.genelAmac10.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac10.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac11 = testDataService4.getGenelAmac(dersId, 11);
			for (OzelAmac o : this.genelAmac11.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac11.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac12 = testDataService4.getGenelAmac(dersId, 12);
			for (OzelAmac o : this.genelAmac12.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac12.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac13 = testDataService4.getGenelAmac(dersId, 13);
			for (OzelAmac o : this.genelAmac13.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac13.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac14 = testDataService4.getGenelAmac(dersId, 14);
			for (OzelAmac o : this.genelAmac14.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac14.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac15 = testDataService4.getGenelAmac(dersId, 15);
			for (OzelAmac o : this.genelAmac15.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac15.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac16 = testDataService4.getGenelAmac(dersId, 16);
			for (OzelAmac o : this.genelAmac16.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac16.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac17 = testDataService4.getGenelAmac(dersId, 17);
			for (OzelAmac o : this.genelAmac17.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac17.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			}else if(dersAd.equals("Müzik")){
				this.genelAmac = testDataService4.getGenelAmac(dersId, 1);
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmaclarMap.put(o.getId(), false);
				}
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmacIdMap.put(o.getId(), o);
				}
			this.genelAmac2 = testDataService4.getGenelAmac(dersId, 2);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}	
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac3 = testDataService4.getGenelAmac(dersId, 3);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac4 = testDataService4.getGenelAmac(dersId, 4);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac5 = testDataService4.getGenelAmac(dersId, 5);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac6 = testDataService4.getGenelAmac(dersId, 6);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac7 = testDataService4.getGenelAmac(dersId, 7);
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac8 = testDataService4.getGenelAmac(dersId, 8);
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac9 = testDataService4.getGenelAmac(dersId, 9);
			for (OzelAmac o : this.genelAmac9.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac9.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac10 = testDataService4.getGenelAmac(dersId, 10);
			for (OzelAmac o : this.genelAmac10.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac10.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac11 = testDataService4.getGenelAmac(dersId, 11);
			for (OzelAmac o : this.genelAmac11.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac11.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			}else if(dersAd.equals("Beslenme Bilgisi")){
			this.genelAmac = testDataService4.getGenelAmac(dersId, 1);
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac2 = testDataService4.getGenelAmac(dersId, 2);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac3 = testDataService4.getGenelAmac(dersId, 3);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac4 = testDataService4.getGenelAmac(dersId, 4);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac5 = testDataService4.getGenelAmac(dersId, 5);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			}else if(dersAd.equals("Görsel Sanatlar")){
				this.genelAmac = testDataService4.getGenelAmac(dersId, 1);
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmaclarMap.put(o.getId(), false);
				}
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmacIdMap.put(o.getId(), o);
				}
			this.genelAmac2 = testDataService4.getGenelAmac(dersId, 2);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac3 = testDataService4.getGenelAmac(dersId, 3);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac4 = testDataService4.getGenelAmac(dersId, 4);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac5 = testDataService4.getGenelAmac(dersId, 5);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}	
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac6 = testDataService4.getGenelAmac(dersId, 6);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac7 = testDataService4.getGenelAmac(dersId, 7);
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac8 = testDataService4.getGenelAmac(dersId, 8);
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			}else if(dersAd.equals("Okuma Yazma")){
				this.genelAmac = testDataService4.getGenelAmac(dersId, 1);
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmaclarMap.put(o.getId(), false);
				}
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmacIdMap.put(o.getId(), o);
				}
			this.genelAmac2 = testDataService4.getGenelAmac(dersId, 2);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac3 = testDataService4.getGenelAmac(dersId, 3);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac4 = testDataService4.getGenelAmac(dersId, 4);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac5 = testDataService4.getGenelAmac(dersId, 5);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac6 = testDataService4.getGenelAmac(dersId, 6);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			}else if(dersAd.equals("Trafik ve İlk Yardım Eğitimi")){
				this.genelAmac = testDataService4.getGenelAmac(dersId, 1);
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmaclarMap.put(o.getId(), false);
				}
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmacIdMap.put(o.getId(), o);
				}
			this.genelAmac2 = testDataService4.getGenelAmac(dersId, 2);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac3 = testDataService4.getGenelAmac(dersId, 3);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac4 = testDataService4.getGenelAmac(dersId, 4);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac5 = testDataService4.getGenelAmac(dersId, 5);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac6 = testDataService4.getGenelAmac(dersId, 6);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			}else if(dersAd.equals("Beden Eğitimi")){
				this.genelAmac = testDataService4.getGenelAmac(dersId, 1);
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmaclarMap.put(o.getId(), false);
				}
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmacIdMap.put(o.getId(), o);
				}
			this.genelAmac2 = testDataService4.getGenelAmac(dersId, 2);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac3 = testDataService4.getGenelAmac(dersId, 3);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac4 = testDataService4.getGenelAmac(dersId, 4);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac5 = testDataService4.getGenelAmac(dersId, 5);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac6 = testDataService4.getGenelAmac(dersId, 6);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac7 = testDataService4.getGenelAmac(dersId, 7);
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac7.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac8 = testDataService4.getGenelAmac(dersId, 8);
			for (OzelAmac o : this.genelAmac8.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac9.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			}else if(dersAd.equals("Toplumsal Uyum Becerileri")){
				this.genelAmac = testDataService4.getGenelAmac(dersId, 1);
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmaclarMap.put(o.getId(), false);
				}
				for (OzelAmac o : this.genelAmac.getOzelAmaclar()) {
					this.ozelAmacIdMap.put(o.getId(), o);
				}
			this.genelAmac2 = testDataService4.getGenelAmac(dersId, 2);
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac2.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac3 = testDataService4.getGenelAmac(dersId, 3);
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac3.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac4 = testDataService4.getGenelAmac(dersId, 4);
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac4.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac5 = testDataService4.getGenelAmac(dersId, 5);
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac5.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			this.genelAmac6 = testDataService4.getGenelAmac(dersId, 6);
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmaclarMap.put(o.getId(), false);
			}
			for (OzelAmac o : this.genelAmac6.getOzelAmaclar()) {
				this.ozelAmacIdMap.put(o.getId(), o);
			}
			}
		
		for (OzelAmac ozelAmac : ozelAmacHayirVerilen) {
			if(ozelAmac.getGenelAmac().getId() == genelAmac.getId()){
				ozelAmacHayirVerilen1.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac2.getId()){
				ozelAmacHayirVerilen2.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac3.getId()){
				ozelAmacHayirVerilen3.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac4.getId()){
				ozelAmacHayirVerilen4.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac5.getId()){
				ozelAmacHayirVerilen5.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac6.getId()){
				ozelAmacHayirVerilen6.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac7.getId()){
				ozelAmacHayirVerilen7.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac8.getId()){
				ozelAmacHayirVerilen8.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac9.getId()){
				ozelAmacHayirVerilen9.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac10.getId()){
				ozelAmacHayirVerilen10.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac11.getId()){
				ozelAmacHayirVerilen11.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac12.getId()){
				ozelAmacHayirVerilen12.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac13.getId()){
				ozelAmacHayirVerilen13.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac14.getId()){
				ozelAmacHayirVerilen14.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac15.getId()){
				ozelAmacHayirVerilen15.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac16.getId()){
				ozelAmacHayirVerilen16.add(ozelAmac);
			}else if(ozelAmac.getGenelAmac().getId() == genelAmac17.getId()){
				ozelAmacHayirVerilen17.add(ozelAmac);
			}
		}
	
		}


	public void bireyselEgitimPlaniAl() {

		String degerlendirici = mySessionScopedBean.getFirstname() + " " + mySessionScopedBean.getLastname();

		bireyselEgitimPlaniService.bireyselEgitimPlaniAl(ogrenciId, dersAd, degerlendirici, ozelAmaclarMap, ozelAmacIdMap);
		
		// FIXME Burada PDF için gerekli işlemler de yapılacak...

		
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

	public List<OzelAmac> getOzelAmacHayirVerilen() {
		return ozelAmacHayirVerilen;
	}


	public void setOzelAmacHayirVerilen(List<OzelAmac> ozelAmacHayirVerilen) {
		this.ozelAmacHayirVerilen = ozelAmacHayirVerilen;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen1() {
		return ozelAmacHayirVerilen1;
	}


	public void setOzelAmacHayirVerilen1(List<OzelAmac> ozelAmacHayirVerilen1) {
		this.ozelAmacHayirVerilen1 = ozelAmacHayirVerilen1;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen2() {
		return ozelAmacHayirVerilen2;
	}


	public void setOzelAmacHayirVerilen2(List<OzelAmac> ozelAmacHayirVerilen2) {
		this.ozelAmacHayirVerilen2 = ozelAmacHayirVerilen2;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen3() {
		return ozelAmacHayirVerilen3;
	}


	public void setOzelAmacHayirVerilen3(List<OzelAmac> ozelAmacHayirVerilen3) {
		this.ozelAmacHayirVerilen3 = ozelAmacHayirVerilen3;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen4() {
		return ozelAmacHayirVerilen4;
	}


	public void setOzelAmacHayirVerilen4(List<OzelAmac> ozelAmacHayirVerilen4) {
		this.ozelAmacHayirVerilen4 = ozelAmacHayirVerilen4;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen5() {
		return ozelAmacHayirVerilen5;
	}


	public void setOzelAmacHayirVerilen5(List<OzelAmac> ozelAmacHayirVerilen5) {
		this.ozelAmacHayirVerilen5 = ozelAmacHayirVerilen5;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen6() {
		return ozelAmacHayirVerilen6;
	}


	public void setOzelAmacHayirVerilen6(List<OzelAmac> ozelAmacHayirVerilen6) {
		this.ozelAmacHayirVerilen6 = ozelAmacHayirVerilen6;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen7() {
		return ozelAmacHayirVerilen7;
	}


	public void setOzelAmacHayirVerilen7(List<OzelAmac> ozelAmacHayirVerilen7) {
		this.ozelAmacHayirVerilen7 = ozelAmacHayirVerilen7;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen8() {
		return ozelAmacHayirVerilen8;
	}


	public void setOzelAmacHayirVerilen8(List<OzelAmac> ozelAmacHayirVerilen8) {
		this.ozelAmacHayirVerilen8 = ozelAmacHayirVerilen8;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen9() {
		return ozelAmacHayirVerilen9;
	}


	public void setOzelAmacHayirVerilen9(List<OzelAmac> ozelAmacHayirVerilen9) {
		this.ozelAmacHayirVerilen9 = ozelAmacHayirVerilen9;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen10() {
		return ozelAmacHayirVerilen10;
	}


	public void setOzelAmacHayirVerilen10(List<OzelAmac> ozelAmacHayirVerilen10) {
		this.ozelAmacHayirVerilen10 = ozelAmacHayirVerilen10;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen11() {
		return ozelAmacHayirVerilen11;
	}


	public void setOzelAmacHayirVerilen11(List<OzelAmac> ozelAmacHayirVerilen11) {
		this.ozelAmacHayirVerilen11 = ozelAmacHayirVerilen11;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen12() {
		return ozelAmacHayirVerilen12;
	}


	public void setOzelAmacHayirVerilen12(List<OzelAmac> ozelAmacHayirVerilen12) {
		this.ozelAmacHayirVerilen12 = ozelAmacHayirVerilen12;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen13() {
		return ozelAmacHayirVerilen13;
	}


	public void setOzelAmacHayirVerilen13(List<OzelAmac> ozelAmacHayirVerilen13) {
		this.ozelAmacHayirVerilen13 = ozelAmacHayirVerilen13;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen14() {
		return ozelAmacHayirVerilen14;
	}


	public void setOzelAmacHayirVerilen14(List<OzelAmac> ozelAmacHayirVerilen14) {
		this.ozelAmacHayirVerilen14 = ozelAmacHayirVerilen14;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen15() {
		return ozelAmacHayirVerilen15;
	}


	public void setOzelAmacHayirVerilen15(List<OzelAmac> ozelAmacHayirVerilen15) {
		this.ozelAmacHayirVerilen15 = ozelAmacHayirVerilen15;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen16() {
		return ozelAmacHayirVerilen16;
	}


	public void setOzelAmacHayirVerilen16(List<OzelAmac> ozelAmacHayirVerilen16) {
		this.ozelAmacHayirVerilen16 = ozelAmacHayirVerilen16;
	}


	public List<OzelAmac> getOzelAmacHayirVerilen17() {
		return ozelAmacHayirVerilen17;
	}


	public void setOzelAmacHayirVerilen17(List<OzelAmac> ozelAmacHayirVerilen17) {
		this.ozelAmacHayirVerilen17 = ozelAmacHayirVerilen17;
	}


	public Map<Integer, OzelAmac> getOzelAmacIdMap() {
		return ozelAmacIdMap;
	}


	public void setOzelAmacIdMap(Map<Integer, OzelAmac> ozelAmacIdMap) {
		this.ozelAmacIdMap = ozelAmacIdMap;
	}
	
	
	
	
	
}
