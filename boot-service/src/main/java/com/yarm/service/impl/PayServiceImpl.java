package com.yarm.service.impl;

import com.yarm.common.CommonConstant;
import com.yarm.common.PayUUID;
import com.yarm.common.pojo.ApiResponse;
import com.yarm.service.PayService;
import com.yarm.service.pojo.request.PayRequest;
import com.yarm.service.pojo.response.PayResponse;
import org.springframework.stereotype.Service;

/**
 * @program: open-http
 * @description: 支付
 * @author: yarm
 * @create: 2019-11-19 13:52
 */
@Service
public class PayServiceImpl implements PayService {
    @Override
    public ApiResponse<PayResponse> pay(PayRequest request) {

        // 返回对象
        ApiResponse<PayResponse> apiResponse = new ApiResponse<>();
        PayResponse response = new PayResponse();

        // 支付业务
        // 落库
        // 调用第三方支付
        // 返回
        response.setAmount(request.getAmount());
        response.setOno(request.getOno());
        response.setPayChannel(request.getPayChannel());
        response.setPayType(request.getPayType());
        response.setOnoType(request.getOnoType());
        response.setTraceId(request.getTraceId());
        response.setTradeNo(PayUUID.getOrderNo(CommonConstant.TRADE_NO));
        response.setThirdTradeNo(PayUUID.getOrderNo(CommonConstant.THIRD_TRADE_NO));

        apiResponse.setData(response);

        return apiResponse;
    }
}