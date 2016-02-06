package com.hyf.openapi.interfaces.global;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GlobalContainer
{

	public static ClassPathXmlApplicationContext applicationContext = null;

	public static ClassPathXmlApplicationContext getApplicationContext()
	{
		return applicationContext;
	}

	public static void setApplicationContext(ClassPathXmlApplicationContext applicationContext)
	{
		GlobalContainer.applicationContext = applicationContext;
	}
}
