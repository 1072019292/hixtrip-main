package com.hixtrip.sample.infra;

import com.hixtrip.sample.domain.sample.model.ProductOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/26$
 */
@Mapper
public interface ProductOrderMapper {

    int insert(ProductOrder order);
}