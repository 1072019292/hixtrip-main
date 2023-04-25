package com.hixtrip.sample.client;


import lombok.Builder;
import lombok.Data;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/25$
 */
/**
 * 扣减库存返回类
 */
@Data
@Builder
public class ReduceStockResponse implements java.io.Serializable{
    private boolean success;
    private String message;

    // 修改构造方法的访问修饰符为 public
    public ReduceStockResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
