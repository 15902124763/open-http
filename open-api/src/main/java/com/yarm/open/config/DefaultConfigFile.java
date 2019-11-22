package com.yarm.open.config;

import com.yarm.open.util.FileUtil;

import java.util.Map;

/**
 * @program: open-http
 * @description: 配置文件加载类
 * @author: yarm
 * @create: 2019-11-20 10:06
 */
public class DefaultConfigFile {
    // 实例
    private static DefaultConfigFile defaultConfigFile = null;
    // 默认的配置文件
    private static Map<String, String> DEFAULT_CONFIG_MAP = null;

    // 默认配置文件名
    private static String DEFAULT_FILE_NAME = "default.properties";

    private DefaultConfigFile(){}

    static {
        // 加载默认配置
        DEFAULT_CONFIG_MAP = FileUtil.getPropertis(DEFAULT_FILE_NAME);
    }

    // 获取实例
    public static DefaultConfigFile getInstance(){

        if(defaultConfigFile == null){
            synchronized (DefaultConfigFile.class){
                defaultConfigFile = new DefaultConfigFile();
            }
        }
        return defaultConfigFile;
    }

    public static String getProperty(String key){
        if(DEFAULT_CONFIG_MAP == null){
            DEFAULT_CONFIG_MAP = FileUtil.getPropertis(DEFAULT_FILE_NAME);
        }
        return DEFAULT_CONFIG_MAP.get(key);
    }
}