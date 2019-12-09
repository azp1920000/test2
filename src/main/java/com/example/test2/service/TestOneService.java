package com.example.test2.service;


import com.example.test2.controller.Pararm.SkuAddOneParam;
import com.example.test2.controller.Pararm.SkuSelectParam;
import com.example.test2.dto.CategoryNameSelectDTO;
import com.example.test2.dto.SkuSelectDTO;
import com.example.test2.model.Sku;

import java.util.List;

public interface TestOneService {

     List<Sku> getAllInfo();

     int addOneRecord(SkuAddOneParam skuAddOneDTO);

     int updateOneRecord(SkuAddOneParam skuAddOneDTO, Long skuId);

     int deletedOneRecord(Long skuId);

     int addList(List<SkuAddOneParam> list);

     List<SkuSelectDTO> functionsSelect(SkuSelectParam skuSelectParam);

     List<CategoryNameSelectDTO> categoryName();
}
