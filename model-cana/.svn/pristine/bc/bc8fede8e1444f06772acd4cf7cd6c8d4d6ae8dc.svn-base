package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the GewffMailboxAccessS database table.
 */
@Entity
@NamedQuery(name = "GewffMailboxAccess.findAll", query = "SELECT g FROM GewffMailboxAccess g")
@Table(name = "GEWFF_MAILBOX_ACCESS")
public class GewffMailboxAccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "MAAC_IN_MAILBOX_ACCESS", nullable = false, precision = 1)
    private Long maacInMailboxAccess;

    @Column(name = "MAAC_IN_MAILBOX_RESPONSIBLE", nullable = false, precision = 1)
    private Long maacInMailboxResponsible;

    @Column(length = 1, name = "MAAF_IN_STATEMENT", nullable = false)
    private String maafInStatement;

    @Column(name = "MBOX_ID_MAILBOX", nullable = false, precision = 38)
    private BigDecimal mboxIdMailbox;

    @Column(name = "PARO_ID_FUNCTIONAL_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdFunctionalRole;

    @Column(name = "USER_ID_USER_UPDATER", precision = 38)
    private BigDecimal userIdUserUpdater;

    @EmbeddedId
    private GewffMailboxAccessPK id;

    public Long getMaacInMailboxAccess() {
        return this.maacInMailboxAccess;
    }

    public void setMaacInMailboxAccess(Long maacInMailboxAccess) {
        this.maacInMailboxAccess = maacInMailboxAccess;
    }

    public Long getMaacInMailboxResponsible() {
        return this.maacInMailboxResponsible;
    }

    public void setMaacInMailboxResponsible(Long maacInMailboxResponsible) {
        this.maacInMailboxResponsible = maacInMailboxResponsible;
    }

    public String getMaafInStatement() {
        return this.maafInStatement;
    }

    public void setMaafInStatement(String maafInStatement) {
        this.maafInStatement = maafInStatement;
    }

    public BigDecimal getMboxIdMailbox() {
        return this.mboxIdMailbox;
    }

    public void setMboxIdMailbox(BigDecimal mboxIdMailbox) {
        this.mboxIdMailbox = mboxIdMailbox;
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

    public GewffMailboxAccessPK getId() {
        return this.id;
    }

    public void setId(GewffMailboxAccessPK id) {
        this.id = id;
    }

}
