package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "MDL_CD", length = 10, nullable = false)
    private String mdlCd;

    @Column(name = "MDL_NM", length = 10)
    private String mdlNm;

    @Column(name = "IMG_PATH", length = 100)
    private String imgPath;

    @Column(name = "IMG_NM", length = 10)
    private String imgNm;

    @Column(name = "MDL_DETAIL", length = 10)
    private String mdlDetail;

    @Column(name = "VILD_STRT_DT")
    @Temporal(TemporalType.DATE)
    private Date vildStrtDt;

    @Column(name = "VILD_END_DT")
    @Temporal(TemporalType.DATE)
    private Date vildEndDt;

    @Setter
    @Getter
    @Column(name = "COST")
    private Integer cost;

    @Column(name = "DEL_YN", length = 1)
    private String delYn;

    @Column(name = "FRST_REG_USER_ID", length = 10)
    private String frstRegUserId;

    @Column(name = "FRST_REG_DT")
    @Temporal(TemporalType.DATE)
    private Date frstRegDt;

    @Setter
    @Getter
    @Column(name = "LAST_MOD_USER_ID", length = 10)
    private String lastModUserId;

    @Column(name = "LAST_MOD_DT")
    @Temporal(TemporalType.DATE)
    private Date lastModDt;

    @Column(name = "CTG_ID", length = 10)
    private String mdlType;

    // Getters and Setters

    public String getModelCode() {
        return mdlCd;
    }

    public void setModelCode(String modelCode) {
        this.mdlCd = modelCode;
    }

    public String getModelName() {
        return mdlNm;
    }

    public void setModelName(String modelName) {
        this.mdlNm = modelName;
    }

    public String getImagePath() {
        return imgPath;
    }

    public void setImagePath(String imagePath) {
        this.imgPath = imagePath;
    }

    public String getImageName() {
        return imgNm;
    }

    public void setImageName(String imageName) {
        this.imgNm = imageName;
    }

    public String getModelDetail() {
        return mdlDetail;
    }

    public void setModelDetail(String modelDetail) {
        this.mdlDetail = modelDetail;
    }

    public Date getValidStartDate() {
        return vildStrtDt;
    }

    public void setValidStartDate(Date validStartDate) {
        this.vildStrtDt = validStartDate;
    }

    public Date getValidEndDate() {
        return vildEndDt;
    }

    public void setValidEndDate(Date validEndDate) {
        this.vildEndDt = validEndDate;
    }

    public String getDeleteYn() {
        return delYn;
    }

    public void setDeleteYn(String deleteYn) {
        this.delYn = deleteYn;
    }

    public String getFirstRegUserId() {
        return frstRegUserId;
    }

    public void setFirstRegUserId(String firstRegUserId) {
        this.frstRegUserId = firstRegUserId;
    }

    public Date getFirstRegDate() {
        return frstRegDt;
    }

    public void setFirstRegDate(Date firstRegDate) {
        this.frstRegDt = firstRegDate;
    }

    public Date getLastModDate() {
        return lastModDt;
    }

    public void setLastModDate(Date lastModDate) {
        this.lastModDt = lastModDate;
    }

    public String getModelType() {
        return mdlType;
    }

    public void setModelType(String modelType) {
        this.mdlType = modelType;
    }
}
