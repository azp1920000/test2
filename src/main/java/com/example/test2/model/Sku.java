package com.example.test2.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Sku {
    private Long skuId;
    private String skuName;
    private Float price;
    private Long categoryId;
    private Long brandId;
    private String description;

    private LocalDateTime createTime;
    //????格式化
    private LocalDateTime updateTime;
    private Short deleted;
}
