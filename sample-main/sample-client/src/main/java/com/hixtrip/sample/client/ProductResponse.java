package com.hixtrip.sample.client;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/25$
 */
/**
 * 商品信息返回类
 */
@Data
@Builder
public class ProductResponse implements java.io.Serializable{
    private Long id;
    private String name;
    private Long categoryId;
    private BigDecimal price;
    private String image;
    private String description;
    private Integer status;
    private Integer stock;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Long createUser;
    private Long updateUser;
    public ProductResponse() {
    }
}
