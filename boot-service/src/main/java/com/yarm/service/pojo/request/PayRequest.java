package com.yarm.service.pojo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @program: open-http
 * @description: 支付请求
 * @author: yarm
 * @create: 2019-11-19 13:58
 */
@Data
public class PayRequest {

    @NotBlank(message = "支付渠道不能为空！")
    private String payChannel;

    @NotBlank(message = "支付方式不能为空！")
    private String payType;

    @JsonProperty(value = "onoType")
    private int onoType;

    @NotBlank(message = "业务方订单号不能为空！")
    private String ono;

    @Min(value = 1, message = "支付金额不能小于1分！")
    @Max(value = 999999999, message = "支付金额不能大于999999999！")
    private Integer amount;

    @Min(value = 5, message = "交易过期时间不能小于5分钟！")
    @Max(value = 1440, message = "交易过期时间不能大于1440分钟！")
    private Integer expireTime;

    @NotBlank(message = "回调地址不能为空！")
    private String callbackUrl;

    private String openid;

    @NotBlank(message = "业务方用户ID不能为空！")
    private String cpid;

    private String ip;

    private String traceId;

//    @NotBlank(message = "签名字段不能为空！")
//    @Length(min = 32, max = 32,message = "签名字段必须32位！")
//    private String sign;
}