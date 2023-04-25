package com.hixtrip.sample.infra;

import com.hixtrip.sample.domain.sample.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/25$
 */
/**
 * 商品映射器接口
 */
@Mapper
public interface ProductMapper {

    /**
     * 根据ID查询商品信息
     */
    Product findById(Long id);

    /**
     * 扣减库存
     */
    int reduceStock(@Param("id") Long id, @Param("quantity") Integer quantity);
}