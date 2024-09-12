package com.example.demo.goodsDetail.model;

import com.example.demo.like.model.LikeId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
//@Data
@IdClass(LikeId.class)
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
public class Product_del {
    @Id
    @Column(name = "USER_ID")
    private String userId;
    @Id
    @Column(name = "MDL_CD")
    private String mdlCd;
    //    @Column(nullable = false)
    @Column(name = "LAST_MOD_USER_ID")
    private String lastModUserId;
    //    @Column(nullable = false)
    @Column(name = "LAST_MOD_DATE")
    private Date lastModDate;
}
