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
 * The persistent class for the PrderUserTaskSpecMailboxS database table.
 */
@Entity
@NamedQuery(name = "PrderUserTaskSpecMailbox.findAll", query = "SELECT p FROM PrderUserTaskSpecMailbox p")
@Table(name = "PRDER_USER_TASK_SPEC_MAILBOX", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BSES_ID_USER_TASK_SPEC", "MBOX_ID_MAILBOX" }) })
public class PrderUserTaskSpecMailbox implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "UTSM_ID_USER_TASK_SPEC_MAILBOX", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal utsmIdUserTaskSpecMailbox;

    @JoinColumn(name = "MBOX_ID_MAILBOX", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaTaskMailbox cnalaTaskMailbox;
    @JoinColumn(name = "BSES_ID_USER_TASK_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private PrdedUserTaskSpec prdedUserTaskSpec;

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

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public BigDecimal getUtsmIdUserTaskSpecMailbox() {
        return this.utsmIdUserTaskSpecMailbox;
    }

    public void setUtsmIdUserTaskSpecMailbox(BigDecimal utsmIdUserTaskSpecMailbox) {
        this.utsmIdUserTaskSpecMailbox = utsmIdUserTaskSpecMailbox;
    }

    public CnalaTaskMailbox getCnalaTaskMailbox() {
        return this.cnalaTaskMailbox;
    }

    public void setCnalaTaskMailbox(CnalaTaskMailbox cnalaTaskMailbox) {
        this.cnalaTaskMailbox = cnalaTaskMailbox;
    }

    public PrdedUserTaskSpec getPrdedUserTaskSpec() {
        return this.prdedUserTaskSpec;
    }

    public void setPrdedUserTaskSpec(PrdedUserTaskSpec prdedUserTaskSpec) {
        this.prdedUserTaskSpec = prdedUserTaskSpec;
    }

}
