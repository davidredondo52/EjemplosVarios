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
 * The persistent class for the CnalrCustInquirySubtypeLS database table.
 */
@Entity
@NamedQuery(name = "CnalrCustInquirySubtypeL.findAll", query = "SELECT c FROM CnalrCustInquirySubtypeL c")
@Table(name = "CNALR_CUST_INQUIRY_SUBTYPE_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "CIMT_ID_CUST_INQUIRY_SUBTYPE", "LANG_CO_LANGUAGE" }) })
public class CnalrCustInquirySubtypeL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "LBIT_ID_LANG_CUST_INQU_SUBTYPE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lbitIdLangCustInquSubtype;

    @Column(length = 500, name = "LIST_DS_CUST_INQUIRY_SUBTYPE")
    private String listDsCustInquirySubtype;

    @Column(length = 100, name = "LIST_NA_CUST_INQUIRY_SUBTYPE", nullable = false)
    private String listNaCustInquirySubtype;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "CIMT_ID_CUST_INQUIRY_SUBTYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldCustomerInquirySubtype cnaldCustomerInquirySubtype;

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

    public BigDecimal getLbitIdLangCustInquSubtype() {
        return this.lbitIdLangCustInquSubtype;
    }

    public void setLbitIdLangCustInquSubtype(BigDecimal lbitIdLangCustInquSubtype) {
        this.lbitIdLangCustInquSubtype = lbitIdLangCustInquSubtype;
    }

    public String getListDsCustInquirySubtype() {
        return this.listDsCustInquirySubtype;
    }

    public void setListDsCustInquirySubtype(String listDsCustInquirySubtype) {
        this.listDsCustInquirySubtype = listDsCustInquirySubtype;
    }

    public String getListNaCustInquirySubtype() {
        return this.listNaCustInquirySubtype;
    }

    public void setListNaCustInquirySubtype(String listNaCustInquirySubtype) {
        this.listNaCustInquirySubtype = listNaCustInquirySubtype;
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

    public CnaldCustomerInquirySubtype getCnaldCustomerInquirySubtype() {
        return this.cnaldCustomerInquirySubtype;
    }

    public void setCnaldCustomerInquirySubtype(CnaldCustomerInquirySubtype cnaldCustomerInquirySubtype) {
        this.cnaldCustomerInquirySubtype = cnaldCustomerInquirySubtype;
    }

}
