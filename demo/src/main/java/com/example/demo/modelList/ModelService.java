package com.example.demo.modelList;

import java.util.List;

public interface ModelService {
    List<Product> getAllModelList();
    List<Product> getModelList(String cat);
    List<Product> getSearchModelList(String mdlCd);
}