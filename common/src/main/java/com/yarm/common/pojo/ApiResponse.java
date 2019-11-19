package com.yarm.common.pojo;

import com.yarm.common.CommonConstant;
import lombok.Data;

/**
 * @program: open-http
 * @description: 统一返回json格式
 * @author: yarm
 * @create: 2019-11-19 14:25
 */
@Data
public class ApiResponse<T> {
    // 约定状态码
    private int code;
    // 是否请求成功
    private boolean status;
    // 返回数据
    private T data;
    // 返回说明
    private String msg;

    public ApiResponse(){
        this.status = true;
        this.msg = CommonConstant.REQ_SUCCESS;
    }


    public ApiResponse(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}