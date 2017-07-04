package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ScdedChannelDemandTypeS database table.
 */
@Entity
@NamedQuery(name = "ScdedChannelDemandType.findAll", query = "SELECT s FROM ScdedChannelDemandType s")
@Table(name = "SCDED_CHANNEL_DEMAND_TYPE")
public class ScdedChannelDemandType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "SCDT_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date scdtDaEndValidity;

    @Column(columnDefinition = "DATE", name = "SCDT_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date scdtDaStartValidity;

    @Column(name = "SCDT_ID_CHANNEL_DEMAND_TYPE", nullable = false, precision = 2, unique = true)
    @Id
    private Long scdtIdChannelDemandType;

    @Column(length = 100, name = "SCDT_NA_CHANNEL_DEMAND_TYPE", nullable = false)
    private String scdtNaChannelDemandType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "scdedChannelDemandType")
    private List<ScdepSalesChannelDemand> scdepSalesChannelDemands;
    @OneToMany(mappedBy = "scdedChannelDemandType")
    private List<ScderDemandTypeTemplate> scderDemandTypeTemplates;

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

    public Date getScdtDaEndValidity() {
        if (this.scdtDaEndValidity != null)
            return (Date) this.scdtDaEndValidity.clone();
        else
            return null;
    }

    public void setScdtDaEndValidity(Date scdtDaEndValidity) {
        if (scdtDaEndValidity != null)
            this.scdtDaEndValidity = (Date) scdtDaEndValidity.clone();
        else
            this.scdtDaEndValidity = scdtDaEndValidity;
    }

    public Date getScdtDaStartValidity() {
        if (this.scdtDaStartValidity != null)
            return (Date) this.scdtDaStartValidity.clone();
        else
            return null;
    }

    public void setScdtDaStartValidity(Date scdtDaStartValidity) {
        if (scdtDaStartValidity != null)
            this.scdtDaStartValidity = (Date) scdtDaStartValidity.clone();
        else
            this.scdtDaStartValidity = scdtDaStartValidity;
    }

    public Long getScdtIdChannelDemandType() {
        return this.scdtIdChannelDemandType;
    }

    public void setScdtIdChannelDemandType(Long scdtIdChannelDemandType) {
        this.scdtIdChannelDemandType = scdtIdChannelDemandType;
    }

    public String getScdtNaChannelDemandType() {
        return this.scdtNaChannelDemandType;
    }

    public void setScdtNaChannelDemandType(String scdtNaChannelDemandType) {
        this.scdtNaChannelDemandType = scdtNaChannelDemandType;
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

    public List<ScdepSalesChannelDemand> getScdepSalesChannelDemands() {
        return this.scdepSalesChannelDemands;
    }

    public void setScdepSalesChannelDemands(List<ScdepSalesChannelDemand> scdepSalesChannelDemands) {
        this.scdepSalesChannelDemands = scdepSalesChannelDemands;
    }

    public void addScdepSalesChannelDemands(ScdepSalesChannelDemand scdepSalesChannelDemand) {
        if (this.scdepSalesChannelDemands == null)
            this.scdepSalesChannelDemands = new ArrayList<ScdepSalesChannelDemand>();
        this.scdepSalesChannelDemands.add(scdepSalesChannelDemand);
    }

    public void removeScdepSalesChannelDemands(ScdepSalesChannelDemand scdepSalesChannelDemandToRemove) {
        if (scdepSalesChannelDemandToRemove != null)
            this.scdepSalesChannelDemands.remove(scdepSalesChannelDemandToRemove);
    }

    public List<ScderDemandTypeTemplate> getScderDemandTypeTemplates() {
        return this.scderDemandTypeTemplates;
    }

    public void setScderDemandTypeTemplates(List<ScderDemandTypeTemplate> scderDemandTypeTemplates) {
        this.scderDemandTypeTemplates = scderDemandTypeTemplates;
    }

    public void addScderDemandTypeTemplates(ScderDemandTypeTemplate scderDemandTypeTemplate) {
        if (this.scderDemandTypeTemplates == null)
            this.scderDemandTypeTemplates = new ArrayList<ScderDemandTypeTemplate>();
        this.scderDemandTypeTemplates.add(scderDemandTypeTemplate);
    }

    public void removeScderDemandTypeTemplates(ScderDemandTypeTemplate scderDemandTypeTemplateToRemove) {
        if (scderDemandTypeTemplateToRemove != null)
            this.scderDemandTypeTemplates.remove(scderDemandTypeTemplateToRemove);
    }

}
