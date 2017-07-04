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
 * The persistent class for the PrderExecProcInvRoleTypeS database table.
 */
@Entity
@NamedQuery(name = "PrderExecProcInvRoleType.findAll", query = "SELECT p FROM PrderExecProcInvRoleType p")
@Table(name = "PRDER_EXEC_PROC_INV_ROLE_TYPE", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "PRDE_ID_PROCESS_DEFINITION", "INRT_ID_INVOLVEMENT_ROLE_TYPE" }) })
public class PrderExecProcInvRoleType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "EPIR_ID_EXEC_PROC_INV_ROLE_TP", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal epirIdExecProcInvRoleTp;

    @Column(name = "INRT_ID_INVOLVEMENT_ROLE_TYPE", nullable = false, precision = 3)
    private Long inrtIdInvolvementRoleType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "PRDE_ID_PROCESS_DEFINITION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpProcessDefinition cnalpProcessDefinition;

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

    public BigDecimal getEpirIdExecProcInvRoleTp() {
        return this.epirIdExecProcInvRoleTp;
    }

    public void setEpirIdExecProcInvRoleTp(BigDecimal epirIdExecProcInvRoleTp) {
        this.epirIdExecProcInvRoleTp = epirIdExecProcInvRoleTp;
    }

    public Long getInrtIdInvolvementRoleType() {
        return this.inrtIdInvolvementRoleType;
    }

    public void setInrtIdInvolvementRoleType(Long inrtIdInvolvementRoleType) {
        this.inrtIdInvolvementRoleType = inrtIdInvolvementRoleType;
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

}
