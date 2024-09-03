package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface ModelService {
    List<Product> getAllModelList();
    List<Product> getModelList(String cat);
    List<Product> getSearchModelList(String mdlCd);
}
