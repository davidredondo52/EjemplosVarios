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
 * The persistent class for the CnalaFunctionalRoleWorkS database table.
 */
@Entity
@NamedQuery(name = "CnalaFunctionalRoleWork.findAll", query = "SELECT c FROM CnalaFunctionalRoleWork c")
@Table(name = "CNALA_FUNCTIONAL_ROLE_WORK", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "PARO_ID_FUNCTIONAL_ROLE", "AUDI_TI_CREATION" }) })
public class CnalaFunctionalRoleWork implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "FRWO_ID_FUNCTIONAL_ROLE_WORK", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal frwoIdFunctionalRoleWork;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumns({
            @JoinColumn(referencedColumnName = "PARO_ID_FUNCTIONAL_ROLE", nullable = false, name = "PARO_ID_FUNCTIONAL_ROLE"),
            @JoinColumn(referencedColumnName = "WPOO_ID_FUNCTIONAL_POOL", nullable = false, name = "WPOO_ID_FUNCTIONAL_POOL") })
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpFuncPoolAssignment cnalpFuncPoolAssignment;

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

    public BigDecimal getFrwoIdFunctionalRoleWork() {
        return this.frwoIdFunctionalRoleWork;
    }

    public void setFrwoIdFunctionalRoleWork(BigDecimal frwoIdFunctionalRoleWork) {
        this.frwoIdFunctionalRoleWork = frwoIdFunctionalRoleWork;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnalpFuncPoolAssignment getCnalpFuncPoolAssignment() {
        return this.cnalpFuncPoolAssignment;
    }

    public void setCnalpFuncPoolAssignment(CnalpFuncPoolAssignment cnalpFuncPoolAssignment) {
        this.cnalpFuncPoolAssignment = cnalpFuncPoolAssignment;
    }

}
