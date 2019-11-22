package com.yarm.aop;
import java.lang.reflect.Method;
/**
 * @program: open-http
 * @description:
 * @author: yarm
 * @create: 2019-11-22 18:20
 */
public class DefaultAOPHandler extends AbstractAOPHandler {
    private Aop aop;

    public DefaultAOPHandler(Object object, Aop aop) {
        super(object);
        this.aop=aop;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object ret=null;
        //修改的地方在这里哦
        this.aop.before(proxy, method, args);
        ret=method.invoke(object, args);
        //修改的地方在这里哦
        this.aop.after(proxy, method, args);
        return ret;
    }
}