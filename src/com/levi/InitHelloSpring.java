package com.levi;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

public class InitHelloSpring implements BeanPostProcessor
{
	public Object postProcessBeforeInitialization(Object bean, String beanName)
	throws BeansException
	{
		System.out.println(new StringBuilder("BeforeInitialization: ").append(beanName));
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
	throws BeansException
	{
		System.out.println(new StringBuilder("AfterInitialization: ").append(beanName));
		return bean;
	}
}
