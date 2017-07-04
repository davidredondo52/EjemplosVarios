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
 * The persistent class for the CnalrInquSpecChannelTypeS database table.
 */
@Entity
@NamedQuery(name = "CnalrInquSpecChannelType.findAll", query = "SELECT c FROM CnalrInquSpecChannelType c")
@Table(name = "CNALR_INQU_SPEC_CHANNEL_TYPE", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "CHAT_ID_CHANNEL_TYPE", "BISP_ID_CUST_INQUIRY_SPEC" }) })
public class CnalrInquSpecChannelType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "ISCT_ID_INQU_SP_CHANNEL_TYPE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal isctIdInquSpChannelType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "CHAT_ID_CHANNEL_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldChannelType cnaldChannelType;
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

    public BigDecimal getIsctIdInquSpChannelType() {
        return this.isctIdInquSpChannelType;
    }

    public void setIsctIdInquSpChannelType(BigDecimal isctIdInquSpChannelType) {
        this.isctIdInquSpChannelType = isctIdInquSpChannelType;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnaldChannelType getCnaldChannelType() {
        return this.cnaldChannelType;
    }

    public void setCnaldChannelType(CnaldChannelType cnaldChannelType) {
        this.cnaldChannelType = cnaldChannelType;
    }

    public CnalpCustomerInquirySpec getCnalpCustomerInquirySpec() {
        return this.cnalpCustomerInquirySpec;
    }

    public void setCnalpCustomerInquirySpec(CnalpCustomerInquirySpec cnalpCustomerInquirySpec) {
        this.cnalpCustomerInquirySpec = cnalpCustomerInquirySpec;
    }

}
