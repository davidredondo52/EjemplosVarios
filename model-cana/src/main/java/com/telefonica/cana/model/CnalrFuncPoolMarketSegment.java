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
 * The persistent class for the CnalrFuncPoolMarketSegmentS database table.
 */
@Entity
@NamedQuery(name = "CnalrFuncPoolMarketSegment.findAll", query = "SELECT c FROM CnalrFuncPoolMarketSegment c")
@Table(name = "CNALR_FUNC_POOL_MARKET_SEGMENT", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "SEGM_ID_MARKET_SEGMENT", "WPOO_ID_FUNCTIONAL_POOL" }) })
public class CnalrFuncPoolMarketSegment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "FPSE_ID_FUNC_POOL_SEGMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal fpseIdFuncPoolSegment;

    @Column(name = "MSCA_ID_MARK_SEGM_CATE", nullable = false, precision = 3)
    private Long mscaIdMarkSegmCate;

    @Column(name = "SEGM_ID_MARKET_SEGMENT", nullable = false, precision = 3)
    private Long segmIdMarketSegment;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "WPOO_ID_FUNCTIONAL_POOL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpFunctionalPool cnalpFunctionalPool;

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

    public BigDecimal getFpseIdFuncPoolSegment() {
        return this.fpseIdFuncPoolSegment;
    }

    public void setFpseIdFuncPoolSegment(BigDecimal fpseIdFuncPoolSegment) {
        this.fpseIdFuncPoolSegment = fpseIdFuncPoolSegment;
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

    public CnalpFunctionalPool getCnalpFunctionalPool() {
        return this.cnalpFunctionalPool;
    }

    public void setCnalpFunctionalPool(CnalpFunctionalPool cnalpFunctionalPool) {
        this.cnalpFunctionalPool = cnalpFunctionalPool;
    }

}
