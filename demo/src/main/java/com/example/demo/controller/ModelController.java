package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modelList")
public class ModelController {

    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/")
    public List<Product> getAllModelList() {
        return modelService.getAllModelList();
    }

    @GetMapping("/{category}")
    public List<Product> getModelList(@PathVariable(name = "category") String cat) {
        return modelService.getModelList(cat);
    }

    @GetMapping("/search/{mdlCd}")
    public List<Product> getSearchModelList(@PathVariable(name = "mdlCd") String mdlCd) {
        return modelService.getSearchModelList(mdlCd);
    }
}
