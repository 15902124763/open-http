package com.yarm.aop;
import java.lang.reflect.Proxy;

/**
 * @program: open-http
 * @description: 默认代理类
 * @author: yarm
 * @create: 2019-11-22 18:19
 */
public class DefaultProxyObject extends AbstractProxy {
    @Override
    public  Object getProxyObject(Object obj, Aop aop) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new DefaultAOPHandler(obj,aop));
    }


    @Override
    public <T> T getProxyObjectByType(Class<T> clz, Aop aop){
        Object obj=null;
        try {
            obj= getProxyObject(clz.newInstance(),aop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)obj;
    }
}