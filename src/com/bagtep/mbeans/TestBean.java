package com.bagtep.mbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.bagtep.business.TestDataService;
import com.bagtep.domain.GenelAmac;

@ManagedBean
public class TestBean {
	
	private GenelAmac genelAmac;
	private GenelAmac genelAmac2;
	private GenelAmac genelAmac3;

	@EJB
	private TestDataService testDataService;
	
	@PostConstruct
	public void init()
	{
		this.genelAmac = testDataService.getGenelAmac(1);
		this.genelAmac2 = testDataService.getGenelAmac(2);
		this.genelAmac3 = testDataService.getGenelAmac(3);
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

	
	
	
}
