package com.yarm.open.service;

import com.alibaba.fastjson.JSONObject;
import com.yarm.open.config.DefaultConfigFile;
import com.yarm.open.pojo.request.PayRequest;
import com.yarm.open.pojo.response.PayResponse;
import com.yarm.open.util.HttpUtil;
import com.yarm.common.OpenApiRequest;
import com.yarm.common.pojo.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @program: open-http
 * @description: 请求客户端
 * @author: yarm
 * @create: 2019-11-19 15:57
 */
@Slf4j
public class PayClient extends AbstractClient {

    private static final String LOG_PERFIX = "请求异常";
    private PayClient(){};

    private static PayClient payClient = null;

    public static PayClient getInstance(){
        if(payClient == null){
            synchronized (PayClient.class){
                payClient = new PayClient();
            }
        }
        return payClient;
    }

    /**
     * @author yarm
     * @date 2019/11/19
     * @return com.yarm.common.pojo.ApiResponse<com.yarm.PayResponse>
     * @Description: 开发支付api
     */
    public ApiResponse<PayResponse> openPay(OpenApiRequest<PayRequest> request) {
        // 每个接口约定好
        String host = getHost(request.getEnv());
        String uri = DefaultConfigFile.getProperty("uri.open.api.pay");
        String url = host + uri;
        request.setUri(uri);
        ApiResponse<PayResponse> responseApiResponse = new ApiResponse<>();
        Map<String, String> reqMap = request.getMapData();
        String response = null;
        try {
            response = HttpUtil.doPost(url, reqMap);
        } catch (Exception e) {
            log.error("请求异常路径：{},参数：{},异常信息：{}",url,request,JSONObject.toJSON(e.getMessage()).toString());
        }
        responseApiResponse = JSONObject.parseObject(response, ApiResponse.class);
        return responseApiResponse;
    }

    // 测试代码
    public static void main(String[] args) throws Exception {
        PayClient instance = PayClient.getInstance();
        OpenApiRequest<PayRequest> payRequestOpenApiRequest = new OpenApiRequest<>();
        payRequestOpenApiRequest.setEnv("prd");
        PayRequest payRequest = new PayRequest();
        payRequest.setOno("O3333");
        payRequest.setCallbackUrl("http://");
        payRequest.setPayType("alipay");
        payRequest.setPayChannel("ali");
        payRequest.setCpid("2221");
        payRequestOpenApiRequest.setData(payRequest);
        ApiResponse<PayResponse> payResponseApiResponse = instance.openPay(payRequestOpenApiRequest);
        System.out.println(payResponseApiResponse);
    }
}