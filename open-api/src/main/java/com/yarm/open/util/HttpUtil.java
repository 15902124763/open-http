package com.yarm.open.util;

import com.yarm.common.http.HttpClientUtil;
import com.yarm.common.pojo.HttpClientResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: open-http
 * @description: 请求工具类
 * @author: yarm
 * @create: 2019-11-19 16:50
 */
public class HttpUtil {
    public static String doPost(String url, Map<String, String> reqMap) throws Exception {
        Map<String, String> headerMap = new HashMap<>(7);
        headerMap.put("Content-Type", "application/json;charset=UTF-8");
        HttpClientResult httpClientResult = HttpClientUtil.doPost(url, headerMap, reqMap);
        int code = httpClientResult.getCode();
        if(code == 200){
            String content = httpClientResult.getContent();
            return content;
        }
        return null;
    }
}