package com.example.demo.goodsDetail.repository;

import com.example.demo.like.model.Like;
import com.example.demo.modelList.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface GoodsDetailRepository extends JpaRepository<Product, String> {
//    @Query("SELECT p FROM Product p WHERE p.id.mdlCd = :pCode")
//    Product selectGoodsDetailByPcode(String pCode);
    Product findByMdlCd(String mdlCd);

    @Query(value = "SELECT * FROM product ORDER BY RAND() LIMIT 4", nativeQuery = true)
    List<Product> findRandomProducts();
}
