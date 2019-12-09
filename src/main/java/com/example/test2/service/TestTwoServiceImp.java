package com.example.test2.service;

import com.example.test2.controller.Pararm.SkuSelectParamT;
import com.example.test2.dto.SkuSelectDTOT;
import com.example.test2.mapper.TestTwoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTwoServiceImp implements TestTwoService{

    @Autowired
    TestTwoMapper testTwoMapper;

    @Override
    public List<SkuSelectDTOT> mySelect(SkuSelectParamT skuSelectParamT) {
        return testTwoMapper.mySelect(skuSelectParamT);
    }
}
