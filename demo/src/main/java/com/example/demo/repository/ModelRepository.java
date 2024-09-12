package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p")
    List<Product> getAllModelList();

    @Query("SELECT p FROM Product p WHERE (:category IS NULL OR p.ctgId = :category)")
    List<Product> getModelList(@Param("cat") String category);

    @Query("SELECT p FROM Product p WHERE p.mdlCd LIKE %:modelCode% OR p.mdlNm LIKE %:modelCode% OR p.mdlDetail LIKE %:modelCode%")
    List<Product> getSearchModelList(@Param("modelCode") String modelCode);

    @Query("SELECT p FROM Product p WHERE (:category IS NULL OR p.ctgId = :category)")
    Page<Product> findProductsByCategory(@Param("category") String category, Pageable pageable);
}
