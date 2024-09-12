package com.example.demo.goodsDetail.service;

import com.example.demo.goodsDetail.repository.GoodsDetailRepository;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsDetailService {
    @Autowired
    private GoodsDetailRepository goodsDetailRepository;

    public Product selectGoodsDetailByPcode(String mdlCd) {
        Product product = new Product();
        try{
            product = goodsDetailRepository.findByMdlCd(mdlCd);
        }catch (Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error selectGoodsDetailByPcode processing request.");
        }finally {
            return product;
        }
    }

    public List<Product> selectRelatedGoods() {
        List<Product> relatePrd = new ArrayList<>();
        try {
            relatePrd = goodsDetailRepository.findRandomProducts();
        } catch (Exception e) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error selectRelatedGoods processing request.");
        } finally {
            return relatePrd;
        }
    }
}
