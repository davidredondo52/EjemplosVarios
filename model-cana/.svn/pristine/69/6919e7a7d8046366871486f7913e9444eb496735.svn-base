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
 * The persistent class for the GewffMailboxAccessPKS database table.
 */
@Embeddable
public class GewffMailboxAccessPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "MAAC_ID_MAILBOX_ACCESS", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    private BigDecimal maacIdMailboxAccess;

    @Column(columnDefinition = "DATE", name = "MAAF_TI_STATEMENT", nullable = false, unique = true)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date maafTiStatement;

    public BigDecimal getMaacIdMailboxAccess() {
        return this.maacIdMailboxAccess;
    }

    public void setMaacIdMailboxAccess(BigDecimal maacIdMailboxAccess) {
        this.maacIdMailboxAccess = maacIdMailboxAccess;
    }

    public Date getMaafTiStatement() {
        if (this.maafTiStatement != null)
            return (Date) this.maafTiStatement.clone();
        else
            return null;
    }

    public void setMaafTiStatement(Date maafTiStatement) {
        if (maafTiStatement != null)
            this.maafTiStatement = (Date) maafTiStatement.clone();
        else
            this.maafTiStatement = maafTiStatement;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maacIdMailboxAccess == null) ? 0 : maacIdMailboxAccess.hashCode());
        result = prime * result + ((maafTiStatement == null) ? 0 : maafTiStatement.hashCode());
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
        GewffMailboxAccessPK other = (GewffMailboxAccessPK) obj;
        if (maacIdMailboxAccess == null) {
            if (other.maacIdMailboxAccess != null)
                return false;
        } else if (!maacIdMailboxAccess.equals(other.maacIdMailboxAccess))
            return false;
        if (maafTiStatement == null) {
            if (other.maafTiStatement != null)
                return false;
        } else if (!maafTiStatement.equals(other.maafTiStatement))
            return false;
        return true;
    }

}
