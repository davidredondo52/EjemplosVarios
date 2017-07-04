package com.telefonica.cana.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CecacMarketSegmentS database table.
 */
@Entity
@NamedQuery(name = "CecacMarketSegment.findAll", query = "SELECT c FROM CecacMarketSegment c")
@Table(name = "CECAC_MARKET_SEGMENT")
public class CecacMarketSegment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "MSCA_ID_MARK_SEGMENT_CATEGORY", nullable = false, precision = 3)
    private Long mscaIdMarkSegmentCategory;

    @Column(name = "SEGM_ID_MARKET_SEGMENT", nullable = false, precision = 3, unique = true)
    @Id
    private Long segmIdMarketSegment;

    @Column(length = 25, name = "SEGM_NA_MARKET_SEGMENT", nullable = false)
    private String segmNaMarketSegment;

    public Long getMscaIdMarkSegmentCategory() {
        return this.mscaIdMarkSegmentCategory;
    }

    public void setMscaIdMarkSegmentCategory(Long mscaIdMarkSegmentCategory) {
        this.mscaIdMarkSegmentCategory = mscaIdMarkSegmentCategory;
    }

    public Long getSegmIdMarketSegment() {
        return this.segmIdMarketSegment;
    }

    public void setSegmIdMarketSegment(Long segmIdMarketSegment) {
        this.segmIdMarketSegment = segmIdMarketSegment;
    }

    public String getSegmNaMarketSegment() {
        return this.segmNaMarketSegment;
    }

    public void setSegmNaMarketSegment(String segmNaMarketSegment) {
        this.segmNaMarketSegment = segmNaMarketSegment;
    }

}
