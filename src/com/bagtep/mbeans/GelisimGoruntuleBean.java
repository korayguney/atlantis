package com.bagtep.mbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import com.bagtep.business.DersService;
import com.bagtep.business.DonemDegerlendirmeService;
import com.bagtep.business.KabaDegerlendirmeService;
import com.bagtep.business.OgrenciService;
import com.bagtep.domain.Ders;
import com.bagtep.domain.DonemDegerlendirme;
import com.bagtep.domain.KabaDegerlendirme;

@ManagedBean
public class GelisimGoruntuleBean implements Serializable {

	private LineChartModel lineModel1;
	private int ogrenciId;
	private int dersId;
	private String dersAd;
	private String ogrenciAd;
	private String ogrenciSoyad;
	private Ders ders;
	private List<Ders> tumdersler;

	@EJB
	private KabaDegerlendirmeService kabaDegerlendirmeService;
	@EJB
	private DonemDegerlendirmeService donemDegerlendirmeService;
	@EJB
	private OgrenciService ogrenciService;
	@EJB
	private DersService dersService;

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
		this.tumdersler = dersService.getAllDers();

		createLineModels();
	}

	public LineChartModel getLineModel1() {
		return lineModel1;
	}

	private void createLineModels() {
		lineModel1 = initCategoryModel();
		lineModel1.setTitle("Gelişim Grafiği");
		lineModel1.setLegendPosition("e");
		lineModel1.setShowPointLabels(true);
		lineModel1.setAnimate(true);
		lineModel1.getAxes().put(AxisType.X, new CategoryAxis("degerlendirme"));
		Axis yAxis = lineModel1.getAxis(AxisType.Y);
		yAxis.setLabel("Değerlendirme Notu");
		yAxis.setMin(0);
		yAxis.setMax(100);

		Axis xAxis = lineModel1.getAxis(AxisType.X);
		xAxis.setLabel("Değerlendirme Takvimi");

	}

	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();

		ChartSeries series1 = new ChartSeries();
		series1.setLabel(dersAd);

		int kabaDegerlendirmePuan = kabaDegerlendirmeService.degerlendirmePuanHesapla(ogrenciId, dersAd);
		KabaDegerlendirme kd = kabaDegerlendirmeService.kabaDegerlendirmeGetir(ogrenciId, dersId);

		int donemDegerlendirmePuan = donemDegerlendirmeService.degerlendirmePuanHesapla(ogrenciId, dersAd);
		DonemDegerlendirme dd = donemDegerlendirmeService.donemDegerlendirmeGetir(ogrenciId, dersId);
		
		if(!kd.equals(null)){
			System.out.println(dersAd + " KD YAPILMIŞŞŞŞŞŞŞŞŞŞş" );
//			Date kdtarihi = kd.getDegerlendirmeTarihi();
//			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
//			String date = DATE_FORMAT.format(kdtarihi);

//			series1.set("Kaba Değerlendirme (" + date + ")", evetSayisi2);
			series1.set(kd.toString(), kabaDegerlendirmePuan);
//			model.addSeries(series1);
		}else {
			 FacesContext.getCurrentInstance().
	      		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, "",ogrenciAd + " " + ogrenciSoyad + " ın "+ dersAd + " için Kaba Değerlendirmesi yapılmamıştır."));
		}
		
		if(!dd.equals(null)){
			System.out.println(dersAd + " DD YAPILMIŞŞŞŞŞŞŞŞŞŞş" );

			series1.set(dd.toString(), donemDegerlendirmePuan);
			
			model.addSeries(series1);
		}else {
			 FacesContext.getCurrentInstance().
	      		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, "",ogrenciAd + " " + ogrenciSoyad + " ın "+ dersAd + " için Kaba Değerlendirmesi yapılmamıştır."));
		}

		return model;
	}

	public int getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(int ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public int getDersId() {
		return dersId;
	}

	public void setDersId(int dersId) {
		this.dersId = dersId;
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

	public void setLineModel1(LineChartModel lineModel1) {
		this.lineModel1 = lineModel1;
	}

	public Ders getDers() {
		return ders;
	}

	public void setDers(Ders ders) {
		this.ders = ders;
	}

	public List<Ders> getTumdersler() {
		return tumdersler;
	}

	public void setTumdersler(List<Ders> tumdersler) {
		this.tumdersler = tumdersler;
	}

	public void denemeMetodu() {
		System.out.println("denemeMetodu na GİRDİİİİİİİİİİİ");
		System.out.println("deneme metodu ::::::::: " + ders.getDersAd());
	}

}