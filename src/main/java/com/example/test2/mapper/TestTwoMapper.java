package com.example.test2.mapper;

import com.example.test2.controller.Pararm.SkuSelectParamT;
import com.example.test2.dto.SkuSelectDTOT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestTwoMapper {

    @Select({
            "<script>",
            "SELECT skuId,skuName,price,brandName,categoryName,description,updateTime",
            "FROM Sku as s",
            "JOIN Category as c ON s.categoryId = c.categoryId",
            "JOIN Brand as b ON s.brandId = b.brandId",
            "WHERE deleted=0",
            //根据商品ID精确查询
            "<if test=\"data.skuId != null \">",
            "AND s.skuId = #{data.skuId}",
            "</if>",
            //按照商品名称模糊
            "<if test=\"data.skuName != null and data.skuName != ''\">",
            "AND s.skuName LIKE CONCAT('%',#{data.skuName},'%')",
            "</if>",
            //根据商品价格范围查询
            "<if test=\"data.highPrice != null and data.lowPrice != null\">",
            "AND s.price &lt;= #{data.highPrice}",
            "AND s.price &gt;= #{data.lowPrice}",
            "</if>",
            //根据多种品牌  来筛选精确查询
            "<if test=\"data.brandNames != null and data.brandNames.size>0\">",
            "AND b.brandName IN",
            "<foreach collection=\"data.brandNames\" item=\"brandName\" index=\"index\" open=\"(\" separator=\",\" close=\")\">",
            "#{brandName}",
            "</foreach>",
            "</if>",
            //根据单个类别 筛选模糊查询
            "<if test=\"data.categoryName != null and data.categoryName !=''\">",
            "AND c.categoryName LIKE CONCAT('%',#{data.categoryName},'%')",
            "</if>",
            "</script>",
    })
    List<SkuSelectDTOT> mySelect(@Param("data")SkuSelectParamT skuSelectParamT);
}
