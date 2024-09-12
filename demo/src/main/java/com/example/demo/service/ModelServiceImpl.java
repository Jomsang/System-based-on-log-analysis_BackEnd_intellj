package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<Product> getAllModelList(){
        return modelRepository.getAllModelList();
    }

    @Override
    public List<Product> getModelList(String cat){
        return modelRepository.getModelList(cat);
    }

    @Override
    public List<Product> getSearchModelList(String mdlCd){
        return modelRepository.getSearchModelList(mdlCd);
    }
}
