package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the CnalrCustomerInquiryTypeLS database table.
 */
@Entity
@NamedQuery(name = "CnalrCustomerInquiryTypeL.findAll", query = "SELECT c FROM CnalrCustomerInquiryTypeL c")
@Table(name = "CNALR_CUSTOMER_INQUIRY_TYPE_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "CIMT_ID_CUST_INQUIRY_TYPE", "LANG_CO_LANGUAGE" }) })
public class CnalrCustomerInquiryTypeL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(length = 500, name = "LCIT_DS_CUST_INQUIRY_TYPE")
    private String lcitDsCustInquiryType;

    @Column(name = "LCIT_ID_LANG_CUST_INQUIRY_TYPE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lcitIdLangCustInquiryType;

    @Column(length = 100, name = "LCIT_NA_CUST_INQUIRY_TYPE", nullable = false)
    private String lcitNaCustInquiryType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "CIMT_ID_CUST_INQUIRY_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldCustomerInquiryType cnaldCustomerInquiryType;

    public Timestamp getAudiTiCreation() {
        if (this.audiTiCreation != null)
            return (Timestamp) this.audiTiCreation.clone();
        else
            return null;
    }

    public void setAudiTiCreation(Timestamp audiTiCreation) {
        if (audiTiCreation != null)
            this.audiTiCreation = (Timestamp) audiTiCreation.clone();
        else
            this.audiTiCreation = audiTiCreation;
    }

    public Timestamp getAudiTiUpdate() {
        if (this.audiTiUpdate != null)
            return (Timestamp) this.audiTiUpdate.clone();
        else
            return null;
    }

    public void setAudiTiUpdate(Timestamp audiTiUpdate) {
        if (audiTiUpdate != null)
            this.audiTiUpdate = (Timestamp) audiTiUpdate.clone();
        else
            this.audiTiUpdate = audiTiUpdate;
    }

    public Long getLangCoLanguage() {
        return this.langCoLanguage;
    }

    public void setLangCoLanguage(Long langCoLanguage) {
        this.langCoLanguage = langCoLanguage;
    }

    public String getLcitDsCustInquiryType() {
        return this.lcitDsCustInquiryType;
    }

    public void setLcitDsCustInquiryType(String lcitDsCustInquiryType) {
        this.lcitDsCustInquiryType = lcitDsCustInquiryType;
    }

    public BigDecimal getLcitIdLangCustInquiryType() {
        return this.lcitIdLangCustInquiryType;
    }

    public void setLcitIdLangCustInquiryType(BigDecimal lcitIdLangCustInquiryType) {
        this.lcitIdLangCustInquiryType = lcitIdLangCustInquiryType;
    }

    public String getLcitNaCustInquiryType() {
        return this.lcitNaCustInquiryType;
    }

    public void setLcitNaCustInquiryType(String lcitNaCustInquiryType) {
        this.lcitNaCustInquiryType = lcitNaCustInquiryType;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public BigDecimal getUserIdUpdaterParty() {
        return this.userIdUpdaterParty;
    }

    public void setUserIdUpdaterParty(BigDecimal userIdUpdaterParty) {
        this.userIdUpdaterParty = userIdUpdaterParty;
    }

    public CnaldCustomerInquiryType getCnaldCustomerInquiryType() {
        return this.cnaldCustomerInquiryType;
    }

    public void setCnaldCustomerInquiryType(CnaldCustomerInquiryType cnaldCustomerInquiryType) {
        this.cnaldCustomerInquiryType = cnaldCustomerInquiryType;
    }

}
