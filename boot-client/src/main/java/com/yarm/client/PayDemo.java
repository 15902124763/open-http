package com.yarm.client;

import com.yarm.common.OpenApiRequest;
import com.yarm.common.pojo.ApiResponse;
import com.yarm.open.pojo.request.PayRequest;
import com.yarm.open.pojo.response.PayResponse;
import com.yarm.open.service.PayClient;

/**
 * @program: open-http
 * @description: 调用api
 * @author: yarm
 * @create: 2019-11-20 13:50
 */
public class PayDemo {
    public void payDemo(){
        // 获取api实例
        PayClient instance = PayClient.getInstance();
        // 入参格式
        OpenApiRequest<PayRequest> payRequestOpenApiRequest = new OpenApiRequest<>();
        payRequestOpenApiRequest.setEnv("prd");
        // 请求参数
        PayRequest payRequest = new PayRequest();
        payRequest.setOno("O3333");
        payRequest.setCallbackUrl("http://");
        payRequest.setPayType("alipay");
        payRequest.setPayChannel("ali");
        payRequest.setCpid("2221");
        payRequestOpenApiRequest.setData(payRequest);
        ApiResponse<PayResponse> payResponseApiResponse = null;
        try {
            payResponseApiResponse = instance.openPay(payRequestOpenApiRequest);
        } catch (Exception e) {
            //ignor
        }
        System.out.println(payResponseApiResponse);
    }

    public static void main(String[] args) {
        PayDemo payDemo = new PayDemo();
        payDemo.payDemo();
    }
}