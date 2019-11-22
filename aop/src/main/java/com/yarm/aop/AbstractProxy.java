package com.yarm.aop;

/**
 * @program: open-http
 * @description: 抽象类
 * @author: yarm
 * @create: 2019-11-22 18:16
 */
public abstract class AbstractProxy implements Proxy {

    <T> T getProxyObjectBytype(Object obj,Aop aop){
        return (T)getProxyObject(obj, aop);
    }

    <T> T getProxyObjectByClassName(String className,Aop aop) throws Exception{
        return getProxyObjectBytype(Class.forName(className).newInstance(),aop);
    }

    <T> T  getProxyObjectByType(Class<T> clz,Aop aop) throws Exception{
        return getProxyObjectBytype(clz.newInstance(),aop);
    }
}