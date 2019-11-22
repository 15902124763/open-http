package com.yarm.open.service;

import com.yarm.open.config.DefaultConfigFile;
import com.yarm.open.constant.Env;
import org.apache.commons.lang3.StringUtils;

/**
 * @program: open-http
 * @description: 抽象类
 * @author: yarm
 * @create: 2019-11-20 11:34
 */
public abstract class AbstractClient {
    // 默认配置
    public static String DEFAULT_ENV = Env.DEV.getKey();
    public static String DEFAULT_HOST_END_PERFIX = "host.key";
    /**
     * @author yarm
     * @date 2019/11/20
     * @return java.lang.String
     * @Description: 获取域名，默认dev
     */
    public String getHost(String env){

        if(StringUtils.isNotBlank(env) && Env.PRD.getKey().equals(env)){
            return DefaultConfigFile.getProperty(env + "." + DEFAULT_HOST_END_PERFIX);
        }
        return DefaultConfigFile.getProperty(DEFAULT_ENV + "." + DEFAULT_HOST_END_PERFIX);
    }
}