package com.example.demo.like.controller;

import com.example.demo.like.model.Like;
import com.example.demo.like.service.LikeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/like")
@CrossOrigin(origins ="http://localhost:3000")
public class LikeController {
    @Autowired
    private LikeServiceImpl likeServiceImpl;

    // 좋아요 저장
    @RequestMapping("/insertLike")
    public String insertLike(@RequestBody Like like){
        likeServiceImpl.insertLike(like);
        return like.getMdlCd() + "상품을 좋아요!";
    }

    // 좋아요 삭제
    @RequestMapping("/deleteLike")
    public String deleteLike(@RequestBody Like like){
        likeServiceImpl.deleteLike(like);
        return like.getMdlCd() + "상품의 좋아요가 취소되었습니다.";
    }


    @RequestMapping("/selectLikedModel")
    public List<String> selectLikeMdlByUserId(@RequestBody String UserId){
        List<String> likeList = likeServiceImpl.selectLikeMdlByUserId(UserId);
//        System.out.println("userId : " + like.getUserId());

//        for(String k : likeList){
//            System.out.println("mdl_cd : " + k);
//        }
        System.out.println("userId!!!!!!!!!!!!!!!!!!!! : " + UserId);
        return likeList;

    }

    @RequestMapping("/selectLikedModelDetail")
    public String selectLikedModelDetailByUserId(@RequestBody Like like){
            System.out.println("userId!!!!!!!!!!!!!!!!!!!! : " + like.getUserId());
            String userId = like.getUserId();
            String mdlCd = like.getMdlCd();
            String likeYn = likeServiceImpl.selectLikedModelDetailByUserId(userId, mdlCd);
        return likeYn;

    }


}
