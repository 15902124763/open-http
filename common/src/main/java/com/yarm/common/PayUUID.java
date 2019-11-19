package com.yarm.common;

import java.util.UUID;

/**
 * @program: open-http
 * @description: 支付单号
 * @author: yarm
 * @create: 2019-11-19 14:46
 */
public class PayUUID {

    /**
     * @author yarm
     * @date 2019/11/19
     * @return java.lang.String
     * @Description: 单号，临时用的，请依据自身业务生成，如分库分表等
     */
    public static String getOrderNo(String perfix){
        String replace = UUID.randomUUID().toString().replace("-", "");
        return perfix + replace;
    }
}