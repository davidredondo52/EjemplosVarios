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
 * The persistent class for the CnalhFunctionalRoleWorkS database table.
 */
@Entity
@NamedQuery(name = "CnalhFunctionalRoleWork.findAll", query = "SELECT c FROM CnalhFunctionalRoleWork c")
@Table(name = "CNALH_FUNCTIONAL_ROLE_WORK")
public class CnalhFunctionalRoleWork implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "FRWO_ID_FUNCTIONAL_ROLE_WORK", nullable = false, precision = 38, unique = true)
    @Id
    private BigDecimal frwoIdFunctionalRoleWork;

    @Column(name = "PARO_ID_FUNCTIONAL_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdFunctionalRole;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

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

    public BigDecimal getFrwoIdFunctionalRoleWork() {
        return this.frwoIdFunctionalRoleWork;
    }

    public void setFrwoIdFunctionalRoleWork(BigDecimal frwoIdFunctionalRoleWork) {
        this.frwoIdFunctionalRoleWork = frwoIdFunctionalRoleWork;
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

    public BigDecimal getWpooIdFunctionalPool() {
        return this.wpooIdFunctionalPool;
    }

    public void setWpooIdFunctionalPool(BigDecimal wpooIdFunctionalPool) {
        this.wpooIdFunctionalPool = wpooIdFunctionalPool;
    }

}
