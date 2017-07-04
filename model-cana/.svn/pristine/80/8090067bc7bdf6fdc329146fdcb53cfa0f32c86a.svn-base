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
 * The persistent class for the CnalrCustomerInquirySpecLS database table.
 */
@Entity
@NamedQuery(name = "CnalrCustomerInquirySpecL.findAll", query = "SELECT c FROM CnalrCustomerInquirySpecL c")
@Table(name = "CNALR_CUSTOMER_INQUIRY_SPEC_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BISP_ID_CUST_INQUIRY_SPEC", "LANG_CO_LANGUAGE" }) })
public class CnalrCustomerInquirySpecL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(length = 500, name = "LCIS_DS_CUST_INQUIRY_SPEC", nullable = false)
    private String lcisDsCustInquirySpec;

    @Column(name = "LCIS_ID_LANG_CUST_INQUIRY_SPEC", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lcisIdLangCustInquirySpec;

    @Column(length = 100, name = "LCIS_NA_CUST_INQUIRY_SPEC", nullable = false)
    private String lcisNaCustInquirySpec;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "BISP_ID_CUST_INQUIRY_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpCustomerInquirySpec cnalpCustomerInquirySpec;

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

    public String getLcisDsCustInquirySpec() {
        return this.lcisDsCustInquirySpec;
    }

    public void setLcisDsCustInquirySpec(String lcisDsCustInquirySpec) {
        this.lcisDsCustInquirySpec = lcisDsCustInquirySpec;
    }

    public BigDecimal getLcisIdLangCustInquirySpec() {
        return this.lcisIdLangCustInquirySpec;
    }

    public void setLcisIdLangCustInquirySpec(BigDecimal lcisIdLangCustInquirySpec) {
        this.lcisIdLangCustInquirySpec = lcisIdLangCustInquirySpec;
    }

    public String getLcisNaCustInquirySpec() {
        return this.lcisNaCustInquirySpec;
    }

    public void setLcisNaCustInquirySpec(String lcisNaCustInquirySpec) {
        this.lcisNaCustInquirySpec = lcisNaCustInquirySpec;
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

    public CnalpCustomerInquirySpec getCnalpCustomerInquirySpec() {
        return this.cnalpCustomerInquirySpec;
    }

    public void setCnalpCustomerInquirySpec(CnalpCustomerInquirySpec cnalpCustomerInquirySpec) {
        this.cnalpCustomerInquirySpec = cnalpCustomerInquirySpec;
    }

}
