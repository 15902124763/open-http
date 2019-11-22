package com.yarm.open.pojo.request;

import lombok.Data;

/**
 * @program: open-http
 * @description: 支付请求
 * @author: yarm
 * @create: 2019-11-19 13:58
 */
@Data
public class PayRequest {

    // 支付渠道不能为空
    private String payChannel;

    // 支付方式不能为空
    private String payType;

    private byte onoType;

    // 业务方订单号不能为空
    private String ono;

    // 支付金额不能小于1分,支付金额不能大于999999999
    private Integer amount;

    // 交易过期时间不能小于5分钟,交易过期时间不能大于1440分钟
    private Integer expireTime;

    // 回调地址不能为空
    private String callbackUrl;

    private String openid;

    // 业务方用户ID不能为空
    private String cpid;

    private String ip;

    private String traceId;

}