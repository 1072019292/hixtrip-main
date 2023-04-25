package com.hixtrip.sample.entry;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/25$
 */

import com.hixtrip.sample.app.api.ProductService;
import com.hixtrip.sample.client.ProductResponse;
import com.hixtrip.sample.client.ReduceStockRequest;
import com.hixtrip.sample.client.ReduceStockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品控制器
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 根据ID查询商品信息
     */
    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    /**
     * 扣减库存
     */
    @PostMapping("/{id}/reduce-stock")
    public ReduceStockResponse reduceStock(@PathVariable Long id, @RequestBody ReduceStockRequest request) {
        return productService.reduceStock(id, request.getQuantity());
    }
}
