package com.example.test2.controller;

import com.example.test2.controller.Pararm.SkuSelectParamT;
import com.example.test2.dto.SkuSelectDTOT;

import com.example.test2.service.TestTwoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestTwoController {
    @Autowired
    TestTwoServiceImp testTwoServiceImp;

    @RequestMapping("/selectSku")
    public List<SkuSelectDTOT> myTest(@RequestBody SkuSelectParamT skuSelectParamT){
        return testTwoServiceImp.mySelect(skuSelectParamT);
    }
}
