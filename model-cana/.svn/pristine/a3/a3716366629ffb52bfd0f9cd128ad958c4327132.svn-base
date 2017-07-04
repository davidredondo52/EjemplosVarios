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
 * The persistent class for the ScderDemandSalesChannelS database table.
 */
@Entity
@NamedQuery(name = "ScderDemandSalesChannel.findAll", query = "SELECT s FROM ScderDemandSalesChannel s")
@Table(name = "SCDER_DEMAND_SALES_CHANNEL", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BUIN_ID_SALES_CHANNEL_DEMAND", "SCHA_ID_SALES_CHANNEL" }) })
public class ScderDemandSalesChannel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "CDSC_ID_DEMAND_SALES_CHANNEL", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal cdscIdDemandSalesChannel;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "SCHA_ID_SALES_CHANNEL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldSalesChannel cnaldSalesChannel;
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

    public BigDecimal getCdscIdDemandSalesChannel() {
        return this.cdscIdDemandSalesChannel;
    }

    public void setCdscIdDemandSalesChannel(BigDecimal cdscIdDemandSalesChannel) {
        this.cdscIdDemandSalesChannel = cdscIdDemandSalesChannel;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnaldSalesChannel getCnaldSalesChannel() {
        return this.cnaldSalesChannel;
    }

    public void setCnaldSalesChannel(CnaldSalesChannel cnaldSalesChannel) {
        this.cnaldSalesChannel = cnaldSalesChannel;
    }

    public ScdepSalesChannelDemand getScdepSalesChannelDemand() {
        return this.scdepSalesChannelDemand;
    }

    public void setScdepSalesChannelDemand(ScdepSalesChannelDemand scdepSalesChannelDemand) {
        this.scdepSalesChannelDemand = scdepSalesChannelDemand;
    }

}
