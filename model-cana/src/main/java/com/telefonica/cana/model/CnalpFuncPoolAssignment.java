package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the CnalpFuncPoolAssignmentS database table.
 */
@Entity
@NamedQuery(name = "CnalpFuncPoolAssignment.findAll", query = "SELECT c FROM CnalpFuncPoolAssignment c")
@Table(name = "CNALP_FUNC_POOL_ASSIGNMENT", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "WPOO_ID_FUNCTIONAL_POOL", "PARO_ID_FUNCTIONAL_ROLE" }) })
public class CnalpFuncPoolAssignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "FPAS_ID_FUNC_POOL_ASSIGNMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal fpasIdFuncPoolAssignment;

    @Column(name = "FPAS_IN_DEFAULT_POOL", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean fpasInDefaultPool;

    @Column(name = "FPAS_TI_END_VALIDITY")
    private Timestamp fpasTiEndValidity;

    @Column(name = "FPAS_TI_START_VALIDITY", nullable = false)
    private Timestamp fpasTiStartValidity;

    @Column(name = "PARO_ID_FUNCTIONAL_ROLE", precision = 38)
    private BigDecimal paroIdFunctionalRole;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnalpFuncPoolAssignment")
    private List<CnalaFunctionalRoleWork> cnalaFunctionalRoleWorks;
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

    public Boolean getFpasInDefaultPool() {
        return this.fpasInDefaultPool;
    }

    public void setFpasInDefaultPool(Boolean fpasInDefaultPool) {
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

    public List<CnalaFunctionalRoleWork> getCnalaFunctionalRoleWorks() {
        return this.cnalaFunctionalRoleWorks;
    }

    public void setCnalaFunctionalRoleWorks(List<CnalaFunctionalRoleWork> cnalaFunctionalRoleWorks) {
        this.cnalaFunctionalRoleWorks = cnalaFunctionalRoleWorks;
    }

    public void addCnalaFunctionalRoleWorks(CnalaFunctionalRoleWork cnalaFunctionalRoleWork) {
        if (this.cnalaFunctionalRoleWorks == null)
            this.cnalaFunctionalRoleWorks = new ArrayList<CnalaFunctionalRoleWork>();
        this.cnalaFunctionalRoleWorks.add(cnalaFunctionalRoleWork);
    }

    public void removeCnalaFunctionalRoleWorks(CnalaFunctionalRoleWork cnalaFunctionalRoleWorkToRemove) {
        if (cnalaFunctionalRoleWorkToRemove != null)
            this.cnalaFunctionalRoleWorks.remove(cnalaFunctionalRoleWorkToRemove);
    }

    public CnalpFunctionalPool getCnalpFunctionalPool() {
        return this.cnalpFunctionalPool;
    }

    public void setCnalpFunctionalPool(CnalpFunctionalPool cnalpFunctionalPool) {
        this.cnalpFunctionalPool = cnalpFunctionalPool;
    }

}
