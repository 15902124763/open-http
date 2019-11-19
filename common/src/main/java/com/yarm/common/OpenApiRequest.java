package com.yarm.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Map;

/**
 * @program: open-http
 * @description: 请求Client的API的入参
 * @author: yarm
 * @create: 2019-11-19 16:12
 */
@Data
public class OpenApiRequest<T> {
    // host
    private String host;
    // uri
    private String uri;
    // 请求入参
    private T data;

    /**
     * @author yarm
     * @date 2019/11/19
     * @return java.util.Map<java.lang.String,java.lang.String>
     * @Description: 获取请求参数
     */
    public Map<String, String> getMapData(){
        String jsonString = JSONObject.toJSONString(data);
        Map<String, String> map = ObjectUtil.strToMap(jsonString);
        return map;
    }
}