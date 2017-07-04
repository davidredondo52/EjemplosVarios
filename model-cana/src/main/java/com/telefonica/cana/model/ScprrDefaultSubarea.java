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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the ScprrDefaultSubareaS database table.
 */
@Entity
@NamedQuery(name = "ScprrDefaultSubarea.findAll", query = "SELECT s FROM ScprrDefaultSubarea s")
@Table(name = "SCPRR_DEFAULT_SUBAREA", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BISP_ID_CHANNEL_PROPOSAL_SPEC", "MBOX_ID_MAILBOX" }) })
public class ScprrDefaultSubarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "DMAI_AM_COST", nullable = false, precision = 9, scale = 2)
    private BigDecimal dmaiAmCost;

    @Column(name = "DMAI_ID_DEFAULT_SUBAREA", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal dmaiIdDefaultSubarea;

    @Column(name = "DMAI_QU_ESTIMATED_DURATION", nullable = false, precision = 5, scale = 2)
    private BigDecimal dmaiQuEstimatedDuration;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "MBOX_ID_MAILBOX", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaTaskMailbox cnalaTaskMailbox;
    @JoinColumns({
            @JoinColumn(referencedColumnName = "BISP_ID_CHANNEL_PROPOSAL_SPEC", nullable = false, name = "BISP_ID_CHANNEL_PROPOSAL_SPEC"),
            @JoinColumn(referencedColumnName = "FARE_ID_FUNCTIONAL_AREA", nullable = false, name = "FARE_ID_FUNCTIONAL_AREA") })
    @ManyToOne(fetch = FetchType.LAZY)
    private ScprrDefaultFuncArea scprrDefaultFuncArea;

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

    public BigDecimal getDmaiAmCost() {
        return this.dmaiAmCost;
    }

    public void setDmaiAmCost(BigDecimal dmaiAmCost) {
        this.dmaiAmCost = dmaiAmCost;
    }

    public BigDecimal getDmaiIdDefaultSubarea() {
        return this.dmaiIdDefaultSubarea;
    }

    public void setDmaiIdDefaultSubarea(BigDecimal dmaiIdDefaultSubarea) {
        this.dmaiIdDefaultSubarea = dmaiIdDefaultSubarea;
    }

    public BigDecimal getDmaiQuEstimatedDuration() {
        return this.dmaiQuEstimatedDuration;
    }

    public void setDmaiQuEstimatedDuration(BigDecimal dmaiQuEstimatedDuration) {
        this.dmaiQuEstimatedDuration = dmaiQuEstimatedDuration;
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

    public CnalaTaskMailbox getCnalaTaskMailbox() {
        return this.cnalaTaskMailbox;
    }

    public void setCnalaTaskMailbox(CnalaTaskMailbox cnalaTaskMailbox) {
        this.cnalaTaskMailbox = cnalaTaskMailbox;
    }

    public ScprrDefaultFuncArea getScprrDefaultFuncArea() {
        return this.scprrDefaultFuncArea;
    }

    public void setScprrDefaultFuncArea(ScprrDefaultFuncArea scprrDefaultFuncArea) {
        this.scprrDefaultFuncArea = scprrDefaultFuncArea;
    }

}
