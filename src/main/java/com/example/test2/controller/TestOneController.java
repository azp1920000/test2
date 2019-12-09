package com.example.test2.controller;

import com.example.test2.controller.Pararm.SkuAddOneParam;
import com.example.test2.controller.Pararm.SkuSelectParam;
import com.example.test2.dto.CategoryNameSelectDTO;
import com.example.test2.dto.SkuSelectDTO;
import com.example.test2.model.Sku;
import com.example.test2.service.TestOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestOneController {
    @Autowired
    TestOneService testOneService;

    @GetMapping("/getAll")
    public List<Sku> getAllInfo(){
        return testOneService.getAllInfo();
    }

    @PostMapping("/addOneRecord")
    public int addOneRecord(@RequestBody SkuAddOneParam skuAddOneDTO){
        return testOneService.addOneRecord(skuAddOneDTO);
    }

    @RequestMapping("/updateOneRecord/{skuId}")
    public int updateOneRecord(@RequestBody SkuAddOneParam skuAddOneDTO, @PathVariable Long skuId){
        return testOneService.updateOneRecord(skuAddOneDTO ,skuId);
    }

    @RequestMapping("/deletedOneRecord/{skuId}")
    public int deletedOneRecord(@PathVariable Long skuId){
        return testOneService.deletedOneRecord(skuId);
    }

    @PostMapping("/addList")
    public int addList(@RequestBody List<SkuAddOneParam> list){
        return testOneService.addList(list);
    }

    @RequestMapping("/functionsSelect")
    public List<SkuSelectDTO> functionsSelect(@RequestBody SkuSelectParam skuSelectParam){
        return testOneService.functionsSelect(skuSelectParam);
    }

    @GetMapping("/categoryNameSelect")
    public     List<CategoryNameSelectDTO> categoryNameSelect(){
        return testOneService.categoryName();
    }
}
