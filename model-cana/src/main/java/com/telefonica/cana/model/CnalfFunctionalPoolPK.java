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
 * The persistent class for the CnalfFunctionalPoolPKS database table.
 */
@Embeddable
public class CnalfFunctionalPoolPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(columnDefinition = "DATE", name = "FUPF_TI_STATEMENT", nullable = false, unique = true)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fupfTiStatement;

    @Column(name = "WPOO_ID_FUNCTIONAL_POOL", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    private BigDecimal wpooIdFunctionalPool;

    public Date getFupfTiStatement() {
        if (this.fupfTiStatement != null)
            return (Date) this.fupfTiStatement.clone();
        else
            return null;
    }

    public void setFupfTiStatement(Date fupfTiStatement) {
        if (fupfTiStatement != null)
            this.fupfTiStatement = (Date) fupfTiStatement.clone();
        else
            this.fupfTiStatement = fupfTiStatement;
    }

    public BigDecimal getWpooIdFunctionalPool() {
        return this.wpooIdFunctionalPool;
    }

    public void setWpooIdFunctionalPool(BigDecimal wpooIdFunctionalPool) {
        this.wpooIdFunctionalPool = wpooIdFunctionalPool;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fupfTiStatement == null) ? 0 : fupfTiStatement.hashCode());
        result = prime * result + ((wpooIdFunctionalPool == null) ? 0 : wpooIdFunctionalPool.hashCode());
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
        CnalfFunctionalPoolPK other = (CnalfFunctionalPoolPK) obj;
        if (fupfTiStatement == null) {
            if (other.fupfTiStatement != null)
                return false;
        } else if (!fupfTiStatement.equals(other.fupfTiStatement))
            return false;
        if (wpooIdFunctionalPool == null) {
            if (other.wpooIdFunctionalPool != null)
                return false;
        } else if (!wpooIdFunctionalPool.equals(other.wpooIdFunctionalPool))
            return false;
        return true;
    }

}
