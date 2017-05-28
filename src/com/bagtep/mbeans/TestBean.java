package com.bagtep.mbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.bagtep.business.TestDataService;
import com.bagtep.domain.GenelAmac;

@ManagedBean
public class TestBean {
	
	private GenelAmac genelAmac;
	@EJB
	private TestDataService testDataService;
	
	@PostConstruct
	public void init()
	{
		this.genelAmac = testDataService.getGenelAmac(1);
	}

	public GenelAmac getGenelAmac() {
		return genelAmac;
	}

	public void setGenelAmac(GenelAmac genelAmac) {
		this.genelAmac = genelAmac;
	}

}
