package com.example.demo.home.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "best_product")
public class BestProduct {
    @Id
    @Column(name = "MDL_CD")
    private String mdlCd;

    @Column(name = "CTG_ID")
    private String ctgId;

    @Column(name = "MDL_RANK")
    private String mdlRank;

    @Column(name = "FRST_REG_USER_ID")
    private String frstRegUserId;

    @Column(name = "FRST_REG_DATE")
    private String frstRegDate;

    @Column(name = "LAST_MOD_USER_ID")
    private String lastModUserId;

    @Column(name = "LAST_MOD_DATE")
    private String lastModDate;

    // Getters and Setters
    public String getMdlCd() {
        return mdlCd;
    }

    public void setMdlCd(String mdlCd) {
        this.mdlCd = mdlCd;
    }

    public String getCtgId() {
        return ctgId;
    }

    public void setCtgId(String ctgId) {
        this.ctgId = ctgId;
    }

    public String getMdlRank() {
        return mdlRank;
    }

    public void setMdlRank(String mdlRank) {
        this.mdlRank = mdlRank;
    }

    public String getFrstRegUserId() {
        return frstRegUserId;
    }

    public void setFrstRegUserId(String frstRegUserId) {
        this.frstRegUserId = frstRegUserId;
    }

    public String getFrstRegDate() {
        return frstRegDate;
    }

    public void setFrstRegDate(String frstRegDate) {
        this.frstRegDate = frstRegDate;
    }

    public String getLastModUserId() {
        return lastModUserId;
    }

    public void setLastModUserId(String lastModUserId) {
        this.lastModUserId = lastModUserId;
    }

    public String getLastModDate() {
        return lastModDate;
    }

    public void setLastModDate(String lastModDate) {
        this.lastModDate = lastModDate;
    }
}
