package com.hixtrip.sample.app.api;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/25$
 */

import com.hixtrip.sample.client.ProductResponse;
import com.hixtrip.sample.client.ReduceStockResponse;

/**
 * 商品服务接口
 */
public interface ProductService {

    /**
     * 根据ID查询商品信息
     */
    ProductResponse getProductById(Long id);

    /**
     * 扣减库存
     */
    ReduceStockResponse reduceStock(Long id, Integer quantity);
}