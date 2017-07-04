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
 * The persistent class for the ScderDemandMarketSegmentS database table.
 */
@Entity
@NamedQuery(name = "ScderDemandMarketSegment.findAll", query = "SELECT s FROM ScderDemandMarketSegment s")
@Table(name = "SCDER_DEMAND_MARKET_SEGMENT", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "SEGM_ID_MARKET_SEGMENT", "BUIN_ID_SALES_CHANNEL_DEMAND" }) })
public class ScderDemandMarketSegment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "MSCA_ID_MARK_SEGM_CATE", precision = 3)
    private Long mscaIdMarkSegmCate;

    @Column(name = "SDSE_ID_DEMAND_MARKET_SEGMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal sdseIdDemandMarketSegment;

    @Column(name = "SEGM_ID_MARKET_SEGMENT", nullable = false, precision = 3)
    private Long segmIdMarketSegment;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "BUIN_ID_SALES_CHANNEL_DEMAND", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScdepSalesChannelDemand scdepSalesChannelDemand;

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

    public Long getMscaIdMarkSegmCate() {
        return this.mscaIdMarkSegmCate;
    }

    public void setMscaIdMarkSegmCate(Long mscaIdMarkSegmCate) {
        this.mscaIdMarkSegmCate = mscaIdMarkSegmCate;
    }

    public BigDecimal getSdseIdDemandMarketSegment() {
        return this.sdseIdDemandMarketSegment;
    }

    public void setSdseIdDemandMarketSegment(BigDecimal sdseIdDemandMarketSegment) {
        this.sdseIdDemandMarketSegment = sdseIdDemandMarketSegment;
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

    public ScdepSalesChannelDemand getScdepSalesChannelDemand() {
        return this.scdepSalesChannelDemand;
    }

    public void setScdepSalesChannelDemand(ScdepSalesChannelDemand scdepSalesChannelDemand) {
        this.scdepSalesChannelDemand = scdepSalesChannelDemand;
    }

}
