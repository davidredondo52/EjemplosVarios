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
 * The persistent class for the CnalrFuncPoolSpecProcessS database table.
 */
@Entity
@NamedQuery(name = "CnalrFuncPoolSpecProcess.findAll", query = "SELECT c FROM CnalrFuncPoolSpecProcess c")
@Table(name = "CNALR_FUNC_POOL_SPEC_PROCESS", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "PSIS_ID_FUNC_POOL_SPEC_INQU_SP", "PRDE_ID_PROCESS_DEFINITION" }) })
public class CnalrFuncPoolSpecProcess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "FPSP_ID_FUNC_POOL_SPEC_PROCESS", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal fpspIdFuncPoolSpecProcess;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "PRDE_ID_PROCESS_DEFINITION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpProcessDefinition cnalpProcessDefinition;
    @JoinColumn(name = "PSIS_ID_FUNC_POOL_SPEC_INQU_SP", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalrFuncPoolSpInquSpec cnalrFuncPoolSpInquSpec;

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

    public BigDecimal getFpspIdFuncPoolSpecProcess() {
        return this.fpspIdFuncPoolSpecProcess;
    }

    public void setFpspIdFuncPoolSpecProcess(BigDecimal fpspIdFuncPoolSpecProcess) {
        this.fpspIdFuncPoolSpecProcess = fpspIdFuncPoolSpecProcess;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnalpProcessDefinition getCnalpProcessDefinition() {
        return this.cnalpProcessDefinition;
    }

    public void setCnalpProcessDefinition(CnalpProcessDefinition cnalpProcessDefinition) {
        this.cnalpProcessDefinition = cnalpProcessDefinition;
    }

    public CnalrFuncPoolSpInquSpec getCnalrFuncPoolSpInquSpec() {
        return this.cnalrFuncPoolSpInquSpec;
    }

    public void setCnalrFuncPoolSpInquSpec(CnalrFuncPoolSpInquSpec cnalrFuncPoolSpInquSpec) {
        this.cnalrFuncPoolSpInquSpec = cnalrFuncPoolSpInquSpec;
    }

}
