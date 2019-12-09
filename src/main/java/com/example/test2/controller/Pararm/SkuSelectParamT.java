package com.example.test2.controller.Pararm;

import lombok.Data;

import java.util.List;

@Data
public class SkuSelectParamT {
    private Long skuId;
    private String skuName;
    private Float highPrice;
    private Float lowPrice;
//    private String brandName;
    private String categoryName;
    private List<String> brandNames;
}
