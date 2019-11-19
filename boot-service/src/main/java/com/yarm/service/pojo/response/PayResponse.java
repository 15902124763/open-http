package com.yarm.service.pojo.response;

import lombok.Data;

/**
 * @program: open-http
 * @description: 支付返回
 * @author: yarm
 * @create: 2019-11-19 13:58
 */
@Data
public class PayResponse {
    // 支付渠道
    private String payChannel;

    // 支付方式
    private String payType;

    private int onoType;

    // 业务方订单号
    private String ono;

    // 支付金额
    private Integer amount;

    // 支付系统生成的交易单号
    private String tradeNo;

    // 第三方支付系统生成的交易单号
    private String thirdTradeNo;

    // 日志追踪id
    private String traceId;

}