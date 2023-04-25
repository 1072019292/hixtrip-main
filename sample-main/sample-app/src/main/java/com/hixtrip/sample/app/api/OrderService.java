package com.hixtrip.sample.app.api;

import com.hixtrip.sample.client.CreateOrderRequest;
import com.hixtrip.sample.client.CreateOrderResponse;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/26$
 */
public interface OrderService {
    CreateOrderResponse createOrder(CreateOrderRequest request);
}