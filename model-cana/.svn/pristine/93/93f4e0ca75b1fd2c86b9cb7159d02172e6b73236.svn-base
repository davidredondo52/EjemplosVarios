package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CnalfTaskMailboxPKS database table.
 */
@Embeddable
public class CnalfTaskMailboxPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(columnDefinition = "DATE", name = "MBOF_TI_STATEMENT", nullable = false, unique = true)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date mbofTiStatement;

    @Column(name = "MBOX_ID_MAILBOX", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    private BigDecimal mboxIdMailbox;

    public Date getMbofTiStatement() {
        if (this.mbofTiStatement != null)
            return (Date) this.mbofTiStatement.clone();
        else
            return null;
    }

    public void setMbofTiStatement(Date mbofTiStatement) {
        if (mbofTiStatement != null)
            this.mbofTiStatement = (Date) mbofTiStatement.clone();
        else
            this.mbofTiStatement = mbofTiStatement;
    }

    public BigDecimal getMboxIdMailbox() {
        return this.mboxIdMailbox;
    }

    public void setMboxIdMailbox(BigDecimal mboxIdMailbox) {
        this.mboxIdMailbox = mboxIdMailbox;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mbofTiStatement == null) ? 0 : mbofTiStatement.hashCode());
        result = prime * result + ((mboxIdMailbox == null) ? 0 : mboxIdMailbox.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CnalfTaskMailboxPK other = (CnalfTaskMailboxPK) obj;
        if (mbofTiStatement == null) {
            if (other.mbofTiStatement != null)
                return false;
        } else if (!mbofTiStatement.equals(other.mbofTiStatement))
            return false;
        if (mboxIdMailbox == null) {
            if (other.mboxIdMailbox != null)
                return false;
        } else if (!mboxIdMailbox.equals(other.mboxIdMailbox))
            return false;
        return true;
    }

}
