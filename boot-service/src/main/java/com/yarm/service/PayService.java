package com.yarm.service;

import com.yarm.common.pojo.ApiResponse;
import com.yarm.service.pojo.request.PayRequest;
import com.yarm.service.pojo.response.PayResponse;

/**
 * @program: open-http
 * @description: 支付
 * @author: yarm
 * @create: 2019-11-19 13:51
 */
public interface PayService {
    /**
     * @author yarm
     * @date 2019/11/19
     * @return com.yarm.common.pojo.ApiResponse<com.yarm.service.pojo.response.PayResponse>
     * @Description: 支付
     */
    ApiResponse<PayResponse> pay(PayRequest payRequest);
}