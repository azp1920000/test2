package com.example.test2.mapper;

import com.example.test2.controller.Pararm.SkuAddOneParam;
import com.example.test2.controller.Pararm.SkuSelectParam;
import com.example.test2.dto.CategoryNameSelectDTO;
import com.example.test2.dto.SkuSelectDTO;
import com.example.test2.model.Sku;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestOneMapper {

    //查询单表
    @Select({
          "<script>",
            "select",
            "*",
            "from",
            "Sku",
          "</script>"
    })
    List<Sku> getAllInfo();


    //插入一条记录
    @Insert({
            "<script>",
            "INSERT INTO",
            "Sku",
            "(skuName,price,categoryId,brandId,description)",
            "VALUES",
            "(#{skuAddOneParam.skuName},#{skuAddOneDTO.price},#{skuAddOneParam.categoryId},#{skuAddOneParam.brandId},#{skuAddOneParam.description})",
            "</script>",
    })
    int addOneRecord(@Param("skuAddOneDTO") SkuAddOneParam skuAddOneParam);


    //根据一条记录的ID修改商品的多种信息（目前只写了名字和价格），使用插入的DTO
//    @Update({
//            "<script>",
//            "UPDATE",
//            "Sku",
//            "SET",
//            "<if test=\" skuAddOneDTO.skuName != null\">",
//            "skuName = #{skuAddOneDTO.skuName},",
//            "</if>",
//            "<if test=\" skuAddOneDTO.price != null\">",
//            "price = #{skuAddOneDTO.price},",
//            "</if>",
//
//                /****拼进去的1=1******/
//            "<if test=\" skuId != null\">",
//            "skuId = #{skuId}",
//            "</if>",
//
//            "WHERE",
//            "skuId = #{skuId}",
//            "</script>"
//    })

    @Update({
            "<script>",
            "UPDATE Sku",
            "<trim prefix=\"SET\" suffixOverrides=\",\" >",
            "<if test=\" skuAddOneParam.skuName != null\">",
            "skuName = #{skuAddOneParam.skuName},",
            "</if>",
            "<if test=\" skuAddOneParam.price != null\">",
            "price = #{skuAddOneParam.price},",
            "</if>",
            "</trim>",

            "WHERE",
            "skuId = #{skuId}",
            "</script>",

    })
    int updateOneRecord(@Param("skuAddOneParam") SkuAddOneParam skuAddOneParam, @Param("skuId") Long skuId);

    //假的删除,根据ID
    @Update({
            "<script>",
            "UPDATE",
            "Sku",
            "SET",
            "deleted = 1",
            "WHERE",
            "skuId = #{skuId}",
            "</script>"
    })
    int deletedOneRecord(@Param("skuId") Long skuId);

    //多条信息插入
    @Insert({
            "<script>",
            "INSERT INTO",
            "Sku(skuName,price,categoryId,brandId,description)",
            "<foreach collection=\"list\" item=\"skuAddOneParam\" open=\"VALUES\" separator=\",\" close=\"\">",
            "(#{skuAddOneParam.skuName},#{skuAddOneParam.price},#{skuAddOneParam.categoryId},#{skuAddOneParam.brandId},#{skuAddOneParam.description})",
            "</foreach>",
            "</script>",
    })

    int addList(@Param("list") List<SkuAddOneParam> list);

    @Select({
            "<script>",
            "SELECT s.skuName,c.categoryName,s.categoryId,b.brandName,s.price",
            "FROM",
            "Sku as s",
            "JOIN",
            "Category as c ON s.categoryId=c.categoryId",
            "JOIN",
            "Brand as b ON b.brandId=s.brandId",
            "WHERE 1=1",
            //根据商品名称查询
            "<if test=\" skuSelectParam.skuName != null and skuSelectParam.skuName != '' \">",
            "AND s.skuName LIKE CONCAT('%',#{skuSelectParam.skuName},'%')",
            "</if>",
            //根据商品分类名称查询
            "<if test=\" skuSelectParam.categoryName != null and skuSelectParam.categoryName != '' \">",
            "AND c.categoryName LIKE CONCAT('%',#{skuSelectParam.categoryName},'%')",
            "</if>",
            //根据最后修改商品时间段查询
            "<if test=\" skuSelectParam.startTime != null and  skuSelectParam.endTime != null \">",
            "AND s.updateTime &lt;= #{skuSelectParam.endTime}",
            "AND s.updateTime &gt;= #{skuSelectParam.startTime}",
            "</if>",
            //根据商品多个类别查询
            "<if test=\" skuSelectParam.categoryIds != null and skuSelectParam.categoryIds.size >0   \">",
            "AND s.categoryId IN",
            "<foreach collection=\"skuSelectParam.categoryIds\" item=\"categoryId\"  index=\"index\"  open=\"(\" separator=\",\" close=\")\" >",
            "#{categoryId}",
            "</foreach>",
            "</if>",


            "</script>",
    })
    List<SkuSelectDTO> functionsSelect(@Param("skuSelectParam") SkuSelectParam skuSelectParam);

    @Select({
        "<script>",
        "SELECT categoryName FROM Category GROUP BY categoryName",
        "</script>"
    })
    List<CategoryNameSelectDTO> categoryNameSelect();
}
