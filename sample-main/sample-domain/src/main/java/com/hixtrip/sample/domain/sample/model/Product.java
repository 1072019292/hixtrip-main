package com.hixtrip.sample.domain.sample.model;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/25$
 */

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品实体类
 */
@Data
@Builder
public class Product implements java.io.Serializable{
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


}