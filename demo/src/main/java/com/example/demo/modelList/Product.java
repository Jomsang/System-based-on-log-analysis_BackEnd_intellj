package com.example.demo.modelList;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "MDL_CD", length = 10, nullable = false)
    private String mdlCd;

    @Column(name = "MDL_NM", length = 200, nullable = false)
    private String mdlNm;

    @Column(name = "CTG_ID", length = 30, nullable = false)
    private String ctgId;

    @Column(name = "IMG_PATH", length = 300)
    private String imgPath;

    @Column(name = "IMG_NM", length = 300)
    private String imgNm;

    @Column(name = "MDL_COLOR", length = 100)
    private String mdlColor;

    @Column(name = "MDL_DETAIL", length = 1000)
    private String mdlDetail;

    @Column(name = "VLID_STRT_DT", nullable = false)
    private LocalDate vildStrtDt;

    @Column(name = "VLID_END_DT", nullable = false)
    private LocalDate vildEndDt;

    @Column(name = "COST", nullable = false)
    private int cost;

    @Column(name = "DEL_YN", length = 1, nullable = false)
    private String delYn;

    @Column(name = "FRST_REG_USER_ID", length = 10, nullable = false)
    private String frstRegUserId;

    @Column(name = "FRST_REG_DATE", nullable = false)
    private LocalDateTime frstRegDate;

    @Column(name = "LAST_MOD_USER_ID", length = 10, nullable = false)
    private String lastModUserId;

    @Column(name = "LAST_MOD_DATE", nullable = false)
    private LocalDateTime lastModDate;

    // Getters and Setters

    public String getModelCode() {
        return mdlCd;
    }

    public void setModelCode(String mdlCd) {
        this.mdlCd = mdlCd;
    }

    public String getModelName() {
        return mdlNm;
    }

    public void setModelName(String mdlNm) {
        this.mdlNm = mdlNm;
    }

    public String getCategoryId() {
        return ctgId;
    }

    public void setCategoryId(String ctgId) {
        this.ctgId = ctgId;
    }

    public String getImagePath() {
        return imgPath;
    }

    public void setImagePath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImageName() {
        return imgNm;
    }

    public void setImageName(String imgNm) {
        this.imgNm = imgNm;
    }

    public String getModelColor() {
        return mdlColor;
    }

    public void setModelColor(String mdlColor) {
        this.mdlColor = mdlColor;
    }

    public String getModelDetail() {
        return mdlDetail;
    }

    public void setModelDetail(String mdlDetail) {
        this.mdlDetail = mdlDetail;
    }

    public LocalDate getValidStartDate() {
        return vildStrtDt;
    }

    public void setValidStartDate(LocalDate vildStrtDt) {
        this.vildStrtDt = vildStrtDt;
    }

    public LocalDate getValidEndDate() {
        return vildEndDt;
    }

    public void setValidEndDate(LocalDate vildEndDt) {
        this.vildEndDt = vildEndDt;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDeleteYn() {
        return delYn;
    }

    public void setDeleteYn(String delYn) {
        this.delYn = delYn;
    }

    public String getFirstRegisteredUserId() {
        return frstRegUserId;
    }

    public void setFirstRegisteredUserId(String frstRegUserId) {
        this.frstRegUserId = frstRegUserId;
    }

    public LocalDateTime getFirstRegisteredDate() {
        return frstRegDate;
    }

    public void setFirstRegisteredDate(LocalDateTime frstRegDate) {
        this.frstRegDate = frstRegDate;
    }

    public String getLastModifiedUserId() {
        return lastModUserId;
    }

    public void setLastModifiedUserId(String lastModUserId) {
        this.lastModUserId = lastModUserId;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModDate) {
        this.lastModDate = lastModDate;
    }
}
