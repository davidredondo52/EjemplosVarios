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
 * The persistent class for the CnalrFuncPoolServiceSpecS database table.
 */
@Entity
@NamedQuery(name = "CnalrFuncPoolServiceSpec.findAll", query = "SELECT c FROM CnalrFuncPoolServiceSpec c")
@Table(name = "CNALR_FUNC_POOL_SERVICE_SPEC", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "WPOO_ID_FUNCTIONAL_POOL", "SESP_ID_SERVICE_SPEC" }) })
public class CnalrFuncPoolServiceSpec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "FPSS_ID_FUNC_POOL_SERVICE_SPEC", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal fpssIdFuncPoolServiceSpec;

    @Column(name = "SESP_ID_SERVICE_SPEC", nullable = false, precision = 7)
    private Long sespIdServiceSpec;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

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

    public BigDecimal getFpssIdFuncPoolServiceSpec() {
        return this.fpssIdFuncPoolServiceSpec;
    }

    public void setFpssIdFuncPoolServiceSpec(BigDecimal fpssIdFuncPoolServiceSpec) {
        this.fpssIdFuncPoolServiceSpec = fpssIdFuncPoolServiceSpec;
    }

    public Long getSespIdServiceSpec() {
        return this.sespIdServiceSpec;
    }

    public void setSespIdServiceSpec(Long sespIdServiceSpec) {
        this.sespIdServiceSpec = sespIdServiceSpec;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnalpFunctionalPool getCnalpFunctionalPool() {
        return this.cnalpFunctionalPool;
    }

    public void setCnalpFunctionalPool(CnalpFunctionalPool cnalpFunctionalPool) {
        this.cnalpFunctionalPool = cnalpFunctionalPool;
    }

}
