package com.example.demo.home.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface BestProductRepository extends JpaRepository<Product, String> {

    @Query(value = "SELECT A.MDL_CD, A.MDL_NM, A.IMG_PATH, A.IMG_NM, A.MDL_DETAIL, A.COST, B.MDL_RANK, A.CTG_ID " +
            "FROM product A " +
            "JOIN best_product B ON A.MDL_CD = B.MDL_CD AND A.CTG_ID = B.CTG_ID",
            nativeQuery = true)
    List<Object[]> findProductsWithRank();
}
