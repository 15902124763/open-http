package com.yarm.common.pojo;

import lombok.Data;

/**
 * @program: base-parent
 * @description: http返回
 * @author: yarm
 * @create: 2019-11-18 10:51
 */
// 没有引入包的话自行写get set方法
@Data
public class HttpClientResult {
    private static final long serialVersionUID = 2168152194164783950L;

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    public HttpClientResult() {
    }

    public HttpClientResult(int code) {
        this.code = code;
    }

    public HttpClientResult(String content) {
        this.content = content;
    }

    public HttpClientResult(int code, String content) {
        this.code = code;
        this.content = content;
    }
}