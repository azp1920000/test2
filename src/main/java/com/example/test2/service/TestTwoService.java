package com.example.test2.service;


import com.example.test2.controller.Pararm.SkuSelectParamT;
import com.example.test2.dto.SkuSelectDTOT;

import java.util.List;

public interface TestTwoService {

    List<SkuSelectDTOT> mySelect (SkuSelectParamT skuSelectParamT);
}
