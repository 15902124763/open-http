package com.yarm.aop;

import java.lang.reflect.Method;

/**
 * @program: open-http
 * @description: 代理接口
 * @author: yarm
 * @create: 2019-11-22 18:15
 */
public interface Aop {

    void after(Object proxy, Method method, Object[] args);

    void before(Object proxy, Method method, Object[] args);
}