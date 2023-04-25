package com.hixtrip.sample.client;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/25$
 */

import lombok.Builder;
import lombok.Data;

/**
 * 扣减库存请求类
 */
@Data
@Builder
public class ReduceStockRequest implements java.io.Serializable{
    private Long id;
    private Integer quantity;
}