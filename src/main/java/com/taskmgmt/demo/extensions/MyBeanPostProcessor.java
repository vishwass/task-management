package com.taskmgmt.demo.extensions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor,Ordered{
	
	Logger logger = LoggerFactory.getLogger(MyBeanPostProcessor.class);
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.info("Bean before being initialized: " + beanName );
		return bean;
	}
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.info("Bean After being initialized: " + beanName );

		return bean;
	}
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
