package com.bagtep.listeners;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bagtep.business.TestDataService;
import com.bagtep.business.TestDataService2;

/**
 * Application Lifecycle Listener implementation class AtlantisListener
 *
 */
@WebListener
public class AtlantisListener implements ServletContextListener {

  @EJB
  private TestDataService testDataService;

	
	
    public void contextInitialized(ServletContextEvent arg0)  { 
       
        testDataService.createTestData();
        
        System.out.println("Context Initialized");
        
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	
	}
	
}
