package com.bagtep.mbeans;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import com.bagtep.business.YilSonuDegerlendirmeService;
import com.bagtep.domain.Ders;
import com.bagtep.domain.DonemDegerlendirme;
import com.bagtep.domain.KabaDegerlendirme;
import com.bagtep.domain.YilSonuDegerlendirme;
import com.bagtep.utils.PartialScreenCaptureExample;

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
	private YilSonuDegerlendirmeService yilSonuDegerlendirmeService;
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

		KabaDegerlendirme kd = kabaDegerlendirmeService.kabaDegerlendirmeGetir(ogrenciId, dersId);
		DonemDegerlendirme dd = null;
		try{
			dd = donemDegerlendirmeService.donemDegerlendirmeGetir(ogrenciId, dersId);
		}catch (Exception e) {
			System.err.println("DONEM DEGERLENDİRME YAPILMAMIŞ ::::: " + dersAd + " / " + ogrenciAd);
		}
		
		YilSonuDegerlendirme ysd = null;
		try{
			ysd =yilSonuDegerlendirmeService.yilSonuDegerlendirmeGetir(ogrenciId, dersId);
		}catch (Exception e) {
			System.err.println("YILSONU DEGERLENDİRME YAPILMAMIŞ ::::: " + dersAd + " / " + ogrenciAd);
		}
			
		if(kd != null){
			int kabaDegerlendirmePuan = kabaDegerlendirmeService.degerlendirmePuanHesapla(ogrenciId, dersAd);

			series1.set(kd.toString(), kabaDegerlendirmePuan);
			model.addSeries(series1);
		}else {
			 FacesContext.getCurrentInstance().
	      		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, "",ogrenciAd + " " + ogrenciSoyad + " ın "+ dersAd + " için Kaba Değerlendirmesi yapılmamıştır."));
		}
		
		if(dd != null){
			int donemDegerlendirmePuan = donemDegerlendirmeService.degerlendirmePuanHesapla(ogrenciId, dersAd);

			series1.set(dd.toString(), donemDegerlendirmePuan);
			model.addSeries(series1);
		}else {
			 FacesContext.getCurrentInstance().
	      		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, "",ogrenciAd + " " + ogrenciSoyad + " için "+ dersAd + " dersi Durum Değerlendirmesi yapılmamıştır."));
		}
		
		if(ysd != null){
			int yilSonuDegerlendirmePuan = yilSonuDegerlendirmeService.degerlendirmePuanHesapla(ogrenciId, dersAd);

			series1.set(ysd.toString(), yilSonuDegerlendirmePuan);
			model.addSeries(series1);
		}else {
			 FacesContext.getCurrentInstance().
	      		addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, "",ogrenciAd + " " + ogrenciSoyad + " için "+ dersAd + " dersi Yıl Sonu Değerlendirmesi yapılmamıştır."));
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

	public void ekranResmiCek() {
		System.out.println("ekranResmiCek() metoda girdiiiii");
		PartialScreenCaptureExample psc = new PartialScreenCaptureExample();
	}
	
	public void pressPrintScreen() throws AWTException{
		System.out.println("BEAN  pressPrintScreen() metoduna GİRDİİİİİ");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PRINTSCREEN);
		r.keyRelease(KeyEvent.VK_PRINTSCREEN);
	}

}