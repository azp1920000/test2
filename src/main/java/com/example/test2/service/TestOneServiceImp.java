package com.example.test2.service;

import com.example.test2.controller.Pararm.SkuAddOneParam;
import com.example.test2.controller.Pararm.SkuSelectParam;
import com.example.test2.dto.CategoryNameSelectDTO;
import com.example.test2.dto.SkuSelectDTO;
import com.example.test2.mapper.TestOneMapper;
import com.example.test2.model.Sku;
//import com.leading.common.exception.LeadingServiceException;
//import com.leading.domain.product.error.SkuError;
//import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestOneServiceImp implements TestOneService{

    @Autowired
    TestOneMapper testOneMapper;

    @Override
    public List<Sku> getAllInfo() {
        return testOneMapper.getAllInfo();
    }

    @Override
    public int addOneRecord(SkuAddOneParam skuAddOneDTO) {
//        checkParam(skuAddOneDTO);

        return testOneMapper.addOneRecord(skuAddOneDTO);
    }

    @Override
    public int updateOneRecord(SkuAddOneParam skuAddOneDTO, Long skuId) {
        return testOneMapper.updateOneRecord(skuAddOneDTO,skuId);
    }

    @Override
    public int deletedOneRecord(Long skuId) {
        return testOneMapper.deletedOneRecord(skuId);
    }

    @Override
    public int addList(List<SkuAddOneParam> list) {
        return testOneMapper.addList(list);
    }

    @Override
    public List<SkuSelectDTO> functionsSelect(SkuSelectParam skuSelectParam) {
        return testOneMapper.functionsSelect(skuSelectParam);
    }

    @Override
    public List<CategoryNameSelectDTO> categoryName() {
        return testOneMapper.categoryNameSelect();
    }


//    /**
//     * 检验商品信息
//     */
//    private void checkParam(Sku sku){
//        if(sku == null){
//            throw new LeadingServiceException(SkuError.SKU_NULL.getCode(),
//                    SkuError.SKU_NULL.getMessage());
//        }
//        if (StringUtils.isBlank(sku.getSkuName())){
//            throw new LeadingServiceException(SkuError.SKU_NULL.getCode(),
//                    SkuError.SKU_NULL.getMessage());
//        }
//    }
//
//    private void checkParam(SkuAddOneParam skuAddOneDTO){
//        if (skuAddOneDTO == null){
//            throw new LeadingServiceException(SkuError.SKU_NULL.getCode(),
//                    SkuError.SKU_NULL.getMessage());
//        }
//        if (StringUtils.isBlank(skuAddOneDTO.getSkuName())){
//            throw new LeadingServiceException(SkuError.SKU_NULL.getCode(),
//                    SkuError.SKU_NULL.getMessage());
//        }
//    }


}
