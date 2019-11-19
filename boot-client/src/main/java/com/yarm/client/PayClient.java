package com.yarm.client;

import com.yarm.client.pojo.request.PayRequest;
import com.yarm.client.pojo.response.PayResponse;
import com.yarm.client.util.HttpUtil;
import com.yarm.common.OpenApiRequest;
import com.yarm.common.pojo.ApiResponse;
import sun.net.www.http.HttpClient;

import java.util.Map;

/**
 * @program: open-http
 * @description: 请求客户端
 * @author: yarm
 * @create: 2019-11-19 15:57
 */
public class PayClient {

    private static String HOST = "http://127.0.0.1:9990";

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
     * @return com.yarm.common.pojo.ApiResponse<com.yarm.client.pojo.response.PayResponse>
     * @Description: 开发支付api
     */
    public ApiResponse<PayResponse> openPay(OpenApiRequest<PayRequest> request) throws Exception {
        request.setUri("/open/api/pay");
        ApiResponse<PayResponse> responseApiResponse = new ApiResponse<>();
        Map<String, String> reqMap = request.getMapData();
        String response = HttpUtil.doPost(HOST + request.getUri(), reqMap);
        return null;
    }

    public static void main(String[] args) throws Exception {
        PayClient instance = PayClient.getInstance();
        OpenApiRequest<PayRequest> payRequestOpenApiRequest = new OpenApiRequest<>();
        payRequestOpenApiRequest.setData(new PayRequest());
        instance.openPay(payRequestOpenApiRequest);
    }
}