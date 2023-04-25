package com.hixtrip.sample.app.service;

import com.hixtrip.sample.app.api.OrderService;
import com.hixtrip.sample.client.CreateOrderRequest;
import com.hixtrip.sample.client.CreateOrderResponse;
import com.hixtrip.sample.domain.sample.model.Product;
import com.hixtrip.sample.domain.sample.model.ProductOrder;
import com.hixtrip.sample.infra.ProductMapper;
import com.hixtrip.sample.infra.ProductOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/26$
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductOrderMapper productOrderMapper;

    @Override
    @Transactional
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        // 检查商品是否存在
        Product product = productMapper.findById(request.getProductId());
        if (product == null) {
            return new CreateOrderResponse(null, "商品不存在");
        }

        // 计算总价
        BigDecimal totalPrice = product.getPrice().multiply(new BigDecimal(request.getProductNumber()));

        // 模拟支付操作
        // ...

        // 生成订单
        ProductOrder order = new ProductOrder();
        order.setUserId(request.getUserId());
        order.setAddressId(request.getAddressId());
        order.setProductId(request.getProductId());
        order.setProductNumber(request.getProductNumber());
        order.setAmount(totalPrice);
        order.setPayMethod(request.getPayMethod());
        order.setRemark(request.getRemark());
        order.setOrderNumber(UUID.randomUUID().toString().replace("-", ""));
        order.setStatus(1); // 设置订单状态为待付款
        order.setPayStatus(1); // 设置支付状态为已支付

        int result = productOrderMapper.insert(order);
        if (result > 0) {
            return new CreateOrderResponse(order.getOrderNumber(), "订单创建成功");
        } else {
            return new CreateOrderResponse(null, "订单创建失败");
        }
    }
}