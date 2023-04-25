package com.hixtrip.sample.app.service;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/25$
 */

import com.hixtrip.sample.app.api.ProductService;
import com.hixtrip.sample.client.ProductResponse;
import com.hixtrip.sample.client.ReduceStockResponse;
import com.hixtrip.sample.domain.sample.model.Product;
import com.hixtrip.sample.infra.ProductMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

/**
 * 商品服务实现类
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * 根据ID查询商品信息
     */
    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productMapper.findById(id);
        if (product == null) {
            return null;
        }

        // 使用BeanUtils.copyProperties方法将Product实体的属性值复制到ProductResponse对象
        ProductResponse productResponse = new ProductResponse();
        try {
            BeanUtils.copyProperties(productResponse, product);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


        return productResponse;
    }

    /**
     * 扣减库存
     */
    @Override
    public ReduceStockResponse reduceStock(Long id, Integer quantity) {
        Product product = productMapper.findById(id);
        if (product == null) {
            return new ReduceStockResponse(false, "商品不存在");
        }

        if (product.getStock() < quantity) {
            return new ReduceStockResponse(false, "库存不足");
        }

        int updatedRows = productMapper.reduceStock(id, quantity);
        if (updatedRows > 0) {
            return new ReduceStockResponse(true, "扣减库存成功");
        } else {
            return new ReduceStockResponse(false, "扣减库存失败");
        }
    }

}
