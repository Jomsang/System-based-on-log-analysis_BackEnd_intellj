package com.example.demo.home.dto;

public class ProductWithRankDTO {

    private String mdlCd;
    private String mdlNm;
    private String imgPath;
    private String imgNm;
    private String mdlDetail;
    private int cost;
    private String mdlRank;
    private String ctgId;

    // Constructor
    public ProductWithRankDTO(String mdlCd, String mdlNm, String imgPath, String imgNm, String mdlDetail, int cost, String mdlRank, String ctgId) {
        this.mdlCd = mdlCd;
        this.mdlNm = mdlNm;
        this.imgPath = imgPath;
        this.imgNm = imgNm;
        this.mdlDetail = mdlDetail;
        this.cost = cost;
        this.mdlRank = mdlRank;
        this.ctgId = ctgId;
    }

    // Getter and Setter methods

    public String getMdlCd() {
        return mdlCd;
    }

    public void setMdlCd(String mdlCd) {
        this.mdlCd = mdlCd;
    }

    public String getMdlNm() {
        return mdlNm;
    }

    public void setMdlNm(String mdlNm) {
        this.mdlNm = mdlNm;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImgNm() {
        return imgNm;
    }

    public void setImgNm(String imgNm) {
        this.imgNm = imgNm;
    }

    public String getMdlDetail() {
        return mdlDetail;
    }

    public void setMdlDetail(String mdlDetail) {
        this.mdlDetail = mdlDetail;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getMdlRank() {
        return mdlRank;
    }

    public void setMdlRank(String mdlRank) {
        this.mdlRank = mdlRank;
    }

    public String getCtgId() {
        return ctgId;
    }

    public void setCtgId(String ctgId) {
        this.ctgId = ctgId;
    }
}
