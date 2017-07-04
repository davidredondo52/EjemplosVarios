package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CnalfFuncPoolAssignmentS database table.
 */
@Entity
@NamedQuery(name = "CnalfFuncPoolAssignment.findAll", query = "SELECT c FROM CnalfFuncPoolAssignment c")
@Table(name = "CNALF_FUNC_POOL_ASSIGNMENT")
public class CnalfFuncPoolAssignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 1, name = "FPAF_IN_STATEMENT", nullable = false)
    private String fpafInStatement;

    @Column(name = "FPAS_IN_DEFAULT_POOL", nullable = false, precision = 1)
    private Long fpasInDefaultPool;

    @Column(name = "FPAS_TI_END_VALIDITY")
    private Timestamp fpasTiEndValidity;

    @Column(name = "FPAS_TI_START_VALIDITY", nullable = false)
    private Timestamp fpasTiStartValidity;

    @Column(name = "PARO_ID_FUNCTIONAL_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdFunctionalRole;

    @Column(name = "USER_ID_USER_UPDATER", precision = 38)
    private BigDecimal userIdUserUpdater;

    @Column(name = "WPOO_ID_FUNCTIONAL_POOL", nullable = false, precision = 38)
    private BigDecimal wpooIdFunctionalPool;

    @EmbeddedId
    private CnalfFuncPoolAssignmentPK id;

    public String getFpafInStatement() {
        return this.fpafInStatement;
    }

    public void setFpafInStatement(String fpafInStatement) {
        this.fpafInStatement = fpafInStatement;
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

    public BigDecimal getUserIdUserUpdater() {
        return this.userIdUserUpdater;
    }

    public void setUserIdUserUpdater(BigDecimal userIdUserUpdater) {
        this.userIdUserUpdater = userIdUserUpdater;
    }

    public BigDecimal getWpooIdFunctionalPool() {
        return this.wpooIdFunctionalPool;
    }

    public void setWpooIdFunctionalPool(BigDecimal wpooIdFunctionalPool) {
        this.wpooIdFunctionalPool = wpooIdFunctionalPool;
    }

    public CnalfFuncPoolAssignmentPK getId() {
        return this.id;
    }

    public void setId(CnalfFuncPoolAssignmentPK id) {
        this.id = id;
    }

}
