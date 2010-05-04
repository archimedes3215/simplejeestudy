package com.yuqiaotech.simplejee.servlet;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountOnlineListener implements HttpSessionListener,
		HttpSessionAttributeListener,ServletContextListener {

	private ServletContext application=null;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		List<String> l=(List<String>)this.application.getAttribute("allusers");
		l.add((String)se.getValue());
		this.application.setAttribute("allusers", l);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		List<String> l=(List<String>)this.application.getAttribute("allusers");
		l.remove((String)se.getValue());
		this.application.setAttribute("allusers", l);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent sbe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		this.application=sce.getServletContext();
		this.application.setAttribute("allusers", new ArrayList<String>());
	}


}
