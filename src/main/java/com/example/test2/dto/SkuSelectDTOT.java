package com.example.test2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SkuSelectDTOT {
    private Long skuId;
    private String skuName;
    private Float price;
    private String brandName;
    private String categoryName;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updateTime;
}
