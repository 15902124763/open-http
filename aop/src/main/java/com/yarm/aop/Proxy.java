package com.yarm.aop;

/**
 * @program: open-http
 * @description: 代理
 * @author: yarm
 * @create: 2019-11-22 18:18
 */
public interface Proxy {
    //获得代理类的对象
    Object getProxyObject(Object obj,Aop aop);
}