package com.hixtrip.sample.client;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/26$
 */
/**
 * 订单请求类
 */
@Data
@Builder
public class CreateOrderRequest implements java.io.Serializable{
    private Long userId;
    private Long addressId;
    private Long productId;
    private Integer productNumber;
    private BigDecimal amount;
    private Integer payMethod;
    private String remark;
}
