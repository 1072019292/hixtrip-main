package com.hixtrip.sample.domain.sample.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/26$
 */
/**
 * 订单实体类
 */
@Data
@Builder
public class ProductOrder implements java.io.Serializable{
    private Long id;
    private String orderNumber;
    private Integer status;
    private Long userId;
    private Long addressId;
    private Long productId;
    private Date orderTime;
    private Integer productNumber;
    private BigDecimal productPrices;
    private Date checkoutTime;
    private Integer payMethod;
    private Integer payStatus;
    private BigDecimal amount;
    private String remark;
    private String phone;
    private String address;
    private String userName;
    private String consignee;
    private String cancelReason;
    private String rejectionReason;
    private Date cancelTime;
    private Date deliveryTime;

    public ProductOrder() {
    }
}
