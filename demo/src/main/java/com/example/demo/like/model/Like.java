package com.example.demo.like.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
//@Data
@IdClass(LikeId.class)
@Table(name = "LIKE_MS")
@AllArgsConstructor
@NoArgsConstructor
public class Like {
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
