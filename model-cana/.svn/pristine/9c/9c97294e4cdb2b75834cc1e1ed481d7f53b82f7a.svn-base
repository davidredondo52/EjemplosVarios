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
 * The persistent class for the ScderDemandChannelTypeS database table.
 */
@Entity
@NamedQuery(name = "ScderDemandChannelType.findAll", query = "SELECT s FROM ScderDemandChannelType s")
@Table(name = "SCDER_DEMAND_CHANNEL_TYPE", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BUIN_ID_SALES_CHANNEL_DEMAND", "CHAT_ID_CHANNEL_TYPE" }) })
public class ScderDemandChannelType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "SDCT_ID_DEMAND_CHANNEL_TYPE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal sdctIdDemandChannelType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "CHAT_ID_CHANNEL_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldChannelType cnaldChannelType;
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

    public BigDecimal getSdctIdDemandChannelType() {
        return this.sdctIdDemandChannelType;
    }

    public void setSdctIdDemandChannelType(BigDecimal sdctIdDemandChannelType) {
        this.sdctIdDemandChannelType = sdctIdDemandChannelType;
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

    public ScdepSalesChannelDemand getScdepSalesChannelDemand() {
        return this.scdepSalesChannelDemand;
    }

    public void setScdepSalesChannelDemand(ScdepSalesChannelDemand scdepSalesChannelDemand) {
        this.scdepSalesChannelDemand = scdepSalesChannelDemand;
    }

}
