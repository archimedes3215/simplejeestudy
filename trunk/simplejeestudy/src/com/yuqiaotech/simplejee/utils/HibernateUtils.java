package com.yuqiaotech.simplejee.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory factory;
	
	static{
		try{
			Configuration cfg=new AnnotationConfiguration().configure();
			factory=cfg.buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
		}
	
	public static Session getSession(){
		return factory.getCurrentSession();
	}
	
	public static void closeSession(Session session){
		if(session!=null){
			if(session.isOpen()){
				session.close();
			}
		}
	}
	}
