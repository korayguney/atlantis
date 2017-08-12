package com.bagtep.mbeans;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

import com.bagtep.business.KabaDegerlendirmeService;
 
@ManagedBean
public class ChartView implements Serializable {
 
    private LineChartModel lineModel1;
     
    @EJB
   	private KabaDegerlendirmeService kabaDegerlendirmeService ;
    
    @PostConstruct
    public void init() {	
        createLineModels();
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
   
     
    private void createLineModels() {
    	lineModel1 = initLinearModel();
        lineModel1.setTitle("Gelişim Grafiği");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
         
    }
     
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Matematik");
 
//        kabaDegerlendirmeService.degerlendirmePuanHesapla();
        
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Din Kültürü ve Ahlak Bilgisi");
 
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
        
        LineChartSeries series3 = new LineChartSeries();
        series3.setLabel("Müzik");
 
        series3.set(1, 2);
        series3.set(2, 3);
        series3.set(3, 5);
        series3.set(4, 4);
        series3.set(5, 8);
        
        LineChartSeries series4 = new LineChartSeries();
        series4.setLabel("Hayat Bilgisi");
 
        series4.set(1, 1);
        series4.set(2, 2);
        series4.set(3, 5);
        series4.set(4, 4);
        series4.set(5, 7);
 
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
        model.addSeries(series4);
        
        return model;
    }
     
}