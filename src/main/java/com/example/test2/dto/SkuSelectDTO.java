package com.example.test2.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SkuSelectDTO implements Serializable {

    private String skuName;
    private String categoryName;
    private Long categoryId;
    private String brandName;
    private Float price;

}
