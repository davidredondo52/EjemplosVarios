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

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the GewfrMailboxAccessS database table.
 */
@Entity
@NamedQuery(name = "GewfrMailboxAccess.findAll", query = "SELECT g FROM GewfrMailboxAccess g")
@Table(name = "GEWFR_MAILBOX_ACCESS", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "PARO_ID_FUNCTIONAL_ROLE", "MBOX_ID_MAILBOX" }) })
public class GewfrMailboxAccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "MAAC_ID_MAILBOX_ACCESS", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal maacIdMailboxAccess;

    @Column(name = "MAAC_IN_MAILBOX_ACCESS", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean maacInMailboxAccess;

    @Column(name = "MAAC_IN_MAILBOX_RESPONSIBLE", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean maacInMailboxResponsible;

    @Column(name = "PARO_ID_FUNCTIONAL_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdFunctionalRole;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "MBOX_ID_MAILBOX", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaTaskMailbox cnalaTaskMailbox;

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

    public BigDecimal getMaacIdMailboxAccess() {
        return this.maacIdMailboxAccess;
    }

    public void setMaacIdMailboxAccess(BigDecimal maacIdMailboxAccess) {
        this.maacIdMailboxAccess = maacIdMailboxAccess;
    }

    public Boolean getMaacInMailboxAccess() {
        return this.maacInMailboxAccess;
    }

    public void setMaacInMailboxAccess(Boolean maacInMailboxAccess) {
        this.maacInMailboxAccess = maacInMailboxAccess;
    }

    public Boolean getMaacInMailboxResponsible() {
        return this.maacInMailboxResponsible;
    }

    public void setMaacInMailboxResponsible(Boolean maacInMailboxResponsible) {
        this.maacInMailboxResponsible = maacInMailboxResponsible;
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

    public CnalaTaskMailbox getCnalaTaskMailbox() {
        return this.cnalaTaskMailbox;
    }

    public void setCnalaTaskMailbox(CnalaTaskMailbox cnalaTaskMailbox) {
        this.cnalaTaskMailbox = cnalaTaskMailbox;
    }

}
