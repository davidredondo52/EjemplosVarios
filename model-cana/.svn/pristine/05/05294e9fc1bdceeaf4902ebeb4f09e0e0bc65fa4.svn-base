package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CnalhFuncPoolAssignmentS database table.
 */
@Entity
@NamedQuery(name = "CnalhFuncPoolAssignment.findAll", query = "SELECT c FROM CnalhFuncPoolAssignment c")
@Table(name = "CNALH_FUNC_POOL_ASSIGNMENT")
public class CnalhFuncPoolAssignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE", nullable = false)
    private Timestamp audiTiUpdate;

    @Column(name = "FPAS_ID_FUNC_POOL_ASSIGNMENT", nullable = false, precision = 38, unique = true)
    @Id
    private BigDecimal fpasIdFuncPoolAssignment;

    @Column(name = "FPAS_IN_DEFAULT_POOL", nullable = false, precision = 1)
    private Long fpasInDefaultPool;

    @Column(name = "FPAS_TI_END_VALIDITY", nullable = false)
    private Timestamp fpasTiEndValidity;

    @Column(name = "FPAS_TI_START_VALIDITY", nullable = false)
    private Timestamp fpasTiStartValidity;

    @Column(name = "PARO_ID_FUNCTIONAL_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdFunctionalRole;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdUpdaterParty;

    @Column(name = "WPOO_ID_FUNCTIONAL_POOL", nullable = false, precision = 38)
    private BigDecimal wpooIdFunctionalPool;

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

    public BigDecimal getFpasIdFuncPoolAssignment() {
        return this.fpasIdFuncPoolAssignment;
    }

    public void setFpasIdFuncPoolAssignment(BigDecimal fpasIdFuncPoolAssignment) {
        this.fpasIdFuncPoolAssignment = fpasIdFuncPoolAssignment;
    }

    public Long getFpasInDefaultPool() {
        return this.fpasInDefaultPool;
    }

    public void setFpasInDefaultPool(Long fpasInDefaultPool) {
        this.fpasInDefaultPool = fpasInDefaultPool;
    }

    public Timestamp getFpasTiEndValidity() {
        if (this.fpasTiEndValidity != null)
            return (Timestamp) this.fpasTiEndValidity.clone();
        else
            return null;
    }

    public void setFpasTiEndValidity(Timestamp fpasTiEndValidity) {
        if (fpasTiEndValidity != null)
            this.fpasTiEndValidity = (Timestamp) fpasTiEndValidity.clone();
        else
            this.fpasTiEndValidity = fpasTiEndValidity;
    }

    public Timestamp getFpasTiStartValidity() {
        if (this.fpasTiStartValidity != null)
            return (Timestamp) this.fpasTiStartValidity.clone();
        else
            return null;
    }

    public void setFpasTiStartValidity(Timestamp fpasTiStartValidity) {
        if (fpasTiStartValidity != null)
            this.fpasTiStartValidity = (Timestamp) fpasTiStartValidity.clone();
        else
            this.fpasTiStartValidity = fpasTiStartValidity;
    }

    public BigDecimal getParoIdFunctionalRole() {
        return this.paroIdFunctionalRole;
    }

    public void setParoIdFunctionalRole(BigDecimal paroIdFunctionalRole) {
        this.paroIdFunctionalRole = paroIdFunctionalRole;
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

    public BigDecimal getWpooIdFunctionalPool() {
        return this.wpooIdFunctionalPool;
    }

    public void setWpooIdFunctionalPool(BigDecimal wpooIdFunctionalPool) {
        this.wpooIdFunctionalPool = wpooIdFunctionalPool;
    }

}
