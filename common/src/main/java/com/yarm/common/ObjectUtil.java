package com.yarm.common;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: open-http
 * @description: 对象工具类
 * @author: yarm
 * @create: 2019-11-19 16:15
 */
public class ObjectUtil {

    public static Map<String, String> strToMap(String str){
        JSONObject jsonObject = JSONObject.parseObject(str);
        Map<String,Object> map = (Map)jsonObject;
        HashMap<String, String> reqHashMap = new HashMap();
        map.forEach((k,v)->{
            reqHashMap.put(k, v + "");
        });
        return reqHashMap;
    }
}