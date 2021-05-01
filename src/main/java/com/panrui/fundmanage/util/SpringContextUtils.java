package com.panrui.fundmanage.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringContextUtils
 * @Description  创建一个工具类实现 ApplicationContextAware 接口，用来获取 ApplicationContext 上下文对象，
 *               然后通过 ApplicationContext.getBean() 来动态的获取实例。
 * @Param 
 **/
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    /**
     * 获取 ApplicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext(){return applicationContext;}

    public static Object getBean(String name){return applicationContext.getBean(name);}

    public static<T> T getBean(Class<T> clazz){return applicationContext.getBean(clazz);}

    public static<T> T getBean(String name, Class<T> clazz){return applicationContext.getBean(name,clazz);}

}
