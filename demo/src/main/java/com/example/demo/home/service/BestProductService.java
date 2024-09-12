package com.example.demo.home.service;

import com.example.demo.home.dto.ProductWithRankDTO;

import java.util.List;

public interface BestProductService {
    List<ProductWithRankDTO> getBestProducts();
}
