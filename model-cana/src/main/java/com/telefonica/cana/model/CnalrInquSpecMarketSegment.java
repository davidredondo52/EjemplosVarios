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
 * The persistent class for the CnalrInquSpecMarketSegmentS database table.
 */
@Entity
@NamedQuery(name = "CnalrInquSpecMarketSegment.findAll", query = "SELECT c FROM CnalrInquSpecMarketSegment c")
@Table(name = "CNALR_INQU_SPEC_MARKET_SEGMENT", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "SEGM_ID_MARKET_SEGMENT", "BISP_ID_CUST_INQUIRY_SPEC" }) })
public class CnalrInquSpecMarketSegment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "ISSE_ID_INQU_SP_MARKET_SEGMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal isseIdInquSpMarketSegment;

    @Column(name = "MSCA_ID_MARK_SEGM_CATE", nullable = false, precision = 3)
    private Long mscaIdMarkSegmCate;

    @Column(name = "SEGM_ID_MARKET_SEGMENT", nullable = false, precision = 3)
    private Long segmIdMarketSegment;

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

    public BigDecimal getIsseIdInquSpMarketSegment() {
        return this.isseIdInquSpMarketSegment;
    }

    public void setIsseIdInquSpMarketSegment(BigDecimal isseIdInquSpMarketSegment) {
        this.isseIdInquSpMarketSegment = isseIdInquSpMarketSegment;
    }

    public Long getMscaIdMarkSegmCate() {
        return this.mscaIdMarkSegmCate;
    }

    public void setMscaIdMarkSegmCate(Long mscaIdMarkSegmCate) {
        this.mscaIdMarkSegmCate = mscaIdMarkSegmCate;
    }

    public Long getSegmIdMarketSegment() {
        return this.segmIdMarketSegment;
    }

    public void setSegmIdMarketSegment(Long segmIdMarketSegment) {
        this.segmIdMarketSegment = segmIdMarketSegment;
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
