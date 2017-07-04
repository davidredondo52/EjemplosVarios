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
 * The persistent class for the CnalrInquSpecContactSesTyS database table.
 */
@Entity
@NamedQuery(name = "CnalrInquSpecContactSesTy.findAll", query = "SELECT c FROM CnalrInquSpecContactSesTy c")
@Table(name = "CNALR_INQU_SPEC_CONTACT_SES_TY", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "COST_ID_CONTACT_SESSION_TYPE", "BISP_ID_CUST_INQUIRY_SPEC" }) })
public class CnalrInquSpecContactSesTy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "COST_ID_CONTACT_SESSION_TYPE", nullable = false, precision = 2)
    private Long costIdContactSessionType;

    @Column(name = "ISCS_ID_INQU_SP_CONTACT_SES_TY", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal iscsIdInquSpContactSesTy;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

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

    public Long getCostIdContactSessionType() {
        return this.costIdContactSessionType;
    }

    public void setCostIdContactSessionType(Long costIdContactSessionType) {
        this.costIdContactSessionType = costIdContactSessionType;
    }

    public BigDecimal getIscsIdInquSpContactSesTy() {
        return this.iscsIdInquSpContactSesTy;
    }

    public void setIscsIdInquSpContactSesTy(BigDecimal iscsIdInquSpContactSesTy) {
        this.iscsIdInquSpContactSesTy = iscsIdInquSpContactSesTy;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnalpCustomerInquirySpec getCnalpCustomerInquirySpec() {
        return this.cnalpCustomerInquirySpec;
    }

    public void setCnalpCustomerInquirySpec(CnalpCustomerInquirySpec cnalpCustomerInquirySpec) {
        this.cnalpCustomerInquirySpec = cnalpCustomerInquirySpec;
    }

}
