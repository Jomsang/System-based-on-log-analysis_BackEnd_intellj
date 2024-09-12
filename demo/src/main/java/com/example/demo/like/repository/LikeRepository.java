package com.example.demo.like.repository;

import com.example.demo.like.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface LikeRepository extends JpaRepository<Like, String> {

//    Optional<Like> findByUsername(String username);

    @Query("SELECT l.id.mdlCd FROM Like l WHERE l.id.userId = :userId")
    String selectLikeMdlByUserId(String userId);

    // findById.userIdAndId.mdlCd는 자동으로 쿼리를 생성합니다.

    Like findByUserIdAndMdlCd(String userId, String mdlCd);


}
