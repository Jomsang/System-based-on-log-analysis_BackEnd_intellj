package com.example.demo.home.service;

import com.example.demo.home.dto.ProductWithRankDTO;
import com.example.demo.home.repository.BestProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BestProductServiceImpl implements BestProductService {

    private final BestProductRepository bestProductRepository;

    public BestProductServiceImpl(BestProductRepository bestProductRepository) {
        this.bestProductRepository = bestProductRepository;
    }

    @Override
    public List<ProductWithRankDTO> getBestProducts() {
        List<Object[]> results = bestProductRepository.findProductsWithRank();
        List<ProductWithRankDTO> dtoList = new ArrayList<>();

        for (Object[] result : results) {
            ProductWithRankDTO dto = new ProductWithRankDTO(
                    (String) result[0],  // mdlCd
                    (String) result[1],  // mdlNm
                    (String) result[2],  // imgPath
                    (String) result[3],  // imgNm
                    (String) result[4],  // mdlDetail
                    (int) result[5],     // cost
                    (String) result[6],  // mdlRank
                    (String) result[7]   // ctgId
            );
            dtoList.add(dto);
        }

        return dtoList;
    }

}
