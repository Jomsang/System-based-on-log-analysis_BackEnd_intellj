package com.example.demo.home.controller;

import com.example.demo.home.dto.ProductWithRankDTO;
import com.example.demo.home.service.BestProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {

    private final BestProductService bestProductService;

    public MainController(BestProductService bestProductService) {
        this.bestProductService = bestProductService;
    }

    @GetMapping
    public List<ProductWithRankDTO> getBestProducts() {
        return bestProductService.getBestProducts();
    }

}