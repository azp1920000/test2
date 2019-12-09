package com.example.test2.controller.Pararm;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class SkuAddOneParam implements Serializable {
    private String skuName;
    private Float price;
    private Long categoryId;
    private Long brandId;
    private String description;
}
