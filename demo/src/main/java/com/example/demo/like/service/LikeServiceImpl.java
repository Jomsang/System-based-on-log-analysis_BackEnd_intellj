package com.example.demo.like.service;

import com.example.demo.like.model.Like;
import com.example.demo.like.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService{
    @Autowired
    private LikeRepository likeRepository;

    public void insertLike(Like like) {
        likeRepository.save(like);
    }


    public void deleteLike(Like like) {
        likeRepository.delete(like);
    }

    // 특정 유저가 좋아요 리스트
    public List<String> selectLikeMdlByUserId(String userId){
        List<String> likeList = Collections.singletonList(likeRepository.selectLikeMdlByUserId(userId));
        return likeList;
    }

    @Override
    public String selectLikedModelDetailByUserId(String userId, String mdlCd) {
        String likeYn = "";
        Like like  =likeRepository.findByUserIdAndMdlCd(userId, mdlCd);
        if(like != null){
            likeYn = "Y";
        }else{
            likeYn = "N";
        }
        return likeYn;
    }


}
