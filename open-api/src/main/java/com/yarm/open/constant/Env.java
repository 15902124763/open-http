package com.yarm.open.constant;

/**
 * @program: open-http
 * @description: 服务的环境
 * @author: yarm
 * @create: 2019-11-20 11:46
 */
public enum Env {
    DEV("dev", "开发环境"),
    PRD("prd", "生产环境");

    private String key;
    private String name;

    Env(String key, String name){
        this.key = key;
        this.name = name;
    }

    public String getKey(){
        return key;
    }

    public String getName(){
        return name;
    }
}