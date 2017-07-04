package com.telefonica.cana.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the PrdefUserTaskSpecPKS database table.
 */
@Embeddable
public class PrdefUserTaskSpecPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "BSES_ID_USER_TASK_SPEC", nullable = false, precision = 6, unique = true)
    private Long bsesIdUserTaskSpec;

    @Column(columnDefinition = "DATE", name = "UTSF_TI_STATEMENT", nullable = false, unique = true)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date utsfTiStatement;

    public Long getBsesIdUserTaskSpec() {
        return this.bsesIdUserTaskSpec;
    }

    public void setBsesIdUserTaskSpec(Long bsesIdUserTaskSpec) {
        this.bsesIdUserTaskSpec = bsesIdUserTaskSpec;
    }

    public Date getUtsfTiStatement() {
        if (this.utsfTiStatement != null)
            return (Date) this.utsfTiStatement.clone();
        else
            return null;
    }

    public void setUtsfTiStatement(Date utsfTiStatement) {
        if (utsfTiStatement != null)
            this.utsfTiStatement = (Date) utsfTiStatement.clone();
        else
            this.utsfTiStatement = utsfTiStatement;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bsesIdUserTaskSpec == null) ? 0 : bsesIdUserTaskSpec.hashCode());
        result = prime * result + ((utsfTiStatement == null) ? 0 : utsfTiStatement.hashCode());
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
        PrdefUserTaskSpecPK other = (PrdefUserTaskSpecPK) obj;
        if (bsesIdUserTaskSpec == null) {
            if (other.bsesIdUserTaskSpec != null)
                return false;
        } else if (!bsesIdUserTaskSpec.equals(other.bsesIdUserTaskSpec))
            return false;
        if (utsfTiStatement == null) {
            if (other.utsfTiStatement != null)
                return false;
        } else if (!utsfTiStatement.equals(other.utsfTiStatement))
            return false;
        return true;
    }

}
