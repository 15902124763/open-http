package com.yarm.open.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @program: open-http
 * @description: 文件操作类
 * @author: yarm
 * @create: 2019-11-20 10:18
 */
public class FileUtil {


    /**
     * @author yarm
     * @date 2019/11/22
     * @return java.util.Map<java.lang.String,java.lang.String>
     * @Description:uri resource下的文件相对路径
     */
    public static Map<String, String> getPropertis(String uri){
        Map<String, String> pMap = new HashMap<>();
        InputStream  inputStream = null;

        try {
            Properties properties = new Properties();
            inputStream = FileUtil.class.getClassLoader().getResourceAsStream(uri);
            if(inputStream != null)
                properties.load(inputStream);
            Set<Map.Entry<Object, Object>> entries = properties.entrySet();
            for (Map.Entry<Object, Object> entry : entries){
                pMap.put(entry.getKey() + "", entry.getValue() + "");
            }
        } catch (IOException e) {
            // ignore
        }finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // ignore
                }
            }
        }

        return pMap;
    }

    public static void main(String[] args) {
        Map<String, String> map = FileUtil.getPropertis("default.properties");
        System.out.println(map);
    }
}