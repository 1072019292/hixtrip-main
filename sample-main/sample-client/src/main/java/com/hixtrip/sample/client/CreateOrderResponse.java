package com.hixtrip.sample.client;

import lombok.Builder;
import lombok.Data;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/26$
 */
@Data
@Builder
public class CreateOrderResponse implements java.io.Serializable{
    private String orderNumber;
    private String message;
    public CreateOrderResponse(String orderNumber, String message) {
        this.orderNumber = orderNumber;
        this.message = message;
    }

}
