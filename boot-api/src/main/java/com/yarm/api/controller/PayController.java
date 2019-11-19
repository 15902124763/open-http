package com.yarm.api.controller;

import com.yarm.common.pojo.ApiResponse;
import com.yarm.service.PayService;
import com.yarm.service.pojo.request.PayRequest;
import com.yarm.service.pojo.response.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: open-http
 * @description: 支付
 * @author: yarm
 * @create: 2019-11-19 13:50
 */
@RestController
@RequestMapping("open/api/")
public class PayController {
    @Autowired
    private PayService payService;

    @PostMapping("pay")
    public ApiResponse<PayResponse> pay(@RequestBody @Valid PayRequest request){
        return this.payService.pay(request);
    }
}