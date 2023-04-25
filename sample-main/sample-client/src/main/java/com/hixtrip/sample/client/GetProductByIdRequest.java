package com.hixtrip.sample.client;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lizhi
 * @version 1.0
 * @date 2023/4/25$
 */

/**
 * 商品信息请求类
 */
@Data
@Builder
public class GetProductByIdRequest implements Serializable {
    private Long id;
}
