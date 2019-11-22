package com.yarm.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: open-http
 * @description:
 * @author: yarm
 * @create: 2019-11-22 18:20
 */
public class AbstractAOPHandler implements InvocationHandler {
    protected Object object;
    public AbstractAOPHandler(Object object){
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object ret = method.invoke(object, args);
        return ret;
    }
}