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
 * The persistent class for the ScderCustomerImpactS database table.
 */
@Entity
@NamedQuery(name = "ScderCustomerImpact.findAll", query = "SELECT s FROM ScderCustomerImpact s")
@Table(name = "SCDER_CUSTOMER_IMPACT", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BUIN_ID_SALES_CHANNEL_DEMAND", "CITY_ID_CUSTOMER_ITEM_TYPE" }) })
public class ScderCustomerImpact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(length = 500, name = "CIMP_DS_CUSTOMER_IMPACT")
    private String cimpDsCustomerImpact;

    @Column(name = "CIMP_ID_CUSTOMER_IMPACT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal cimpIdCustomerImpact;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "CITY_ID_CUSTOMER_ITEM_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScdedCustomerItemType scdedCustomerItemType;
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

    public String getCimpDsCustomerImpact() {
        return this.cimpDsCustomerImpact;
    }

    public void setCimpDsCustomerImpact(String cimpDsCustomerImpact) {
        this.cimpDsCustomerImpact = cimpDsCustomerImpact;
    }

    public BigDecimal getCimpIdCustomerImpact() {
        return this.cimpIdCustomerImpact;
    }

    public void setCimpIdCustomerImpact(BigDecimal cimpIdCustomerImpact) {
        this.cimpIdCustomerImpact = cimpIdCustomerImpact;
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

    public ScdedCustomerItemType getScdedCustomerItemType() {
        return this.scdedCustomerItemType;
    }

    public void setScdedCustomerItemType(ScdedCustomerItemType scdedCustomerItemType) {
        this.scdedCustomerItemType = scdedCustomerItemType;
    }

    public ScdepSalesChannelDemand getScdepSalesChannelDemand() {
        return this.scdepSalesChannelDemand;
    }

    public void setScdepSalesChannelDemand(ScdepSalesChannelDemand scdepSalesChannelDemand) {
        this.scdepSalesChannelDemand = scdepSalesChannelDemand;
    }

}
