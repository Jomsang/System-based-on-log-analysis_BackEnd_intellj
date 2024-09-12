package com.example.demo.like.service;

import com.example.demo.like.model.Like;

import java.util.*;

public interface LikeService {

    void insertLike(Like like);

    void deleteLike(Like like);

    List<String> selectLikeMdlByUserId(String userId);

    String selectLikedModelDetailByUserId(String userId, String mdlCd);
}
