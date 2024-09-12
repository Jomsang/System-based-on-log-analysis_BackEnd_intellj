package com.example.demo.goodsDetail.controller;

import com.example.demo.goodsDetail.service.GoodsDetailService;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/modelDetail")
@CrossOrigin(origins ="http://localhost:3000")
public class GoodsDetailController {

    @Autowired
    private GoodsDetailService goodsDetailService;

    @GetMapping("/{mdlCd}")
    public Map<String, Object> selectModelByPrdCode(@PathVariable String mdlCd) {
        Map<String, Object> returnMap = new HashMap<>();
        Product product = new Product();
        List<Product> relatePrd = new ArrayList<>();
        try {
            //상품 상세 정보 가져오기
            product = goodsDetailService.selectGoodsDetailByPcode(mdlCd);
            returnMap.put("product", product);

            //관련 상품 정보 랜덤으로 가져오기
            relatePrd = goodsDetailService.selectRelatedGoods();
            returnMap.put("relatePrd", relatePrd);

        } catch (Exception e) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing request.");
        } finally {
            return returnMap;
        }

    }
}
