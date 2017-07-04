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
 * The persistent class for the CnalfFuncPoolAssignmentPKS database table.
 */
@Embeddable
public class CnalfFuncPoolAssignmentPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(columnDefinition = "DATE", name = "FPAF_TI_STATEMENT", nullable = false, unique = true)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fpafTiStatement;

    @Column(name = "FPAS_ID_FUNC_POOL_ASSIGNMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    private BigDecimal fpasIdFuncPoolAssignment;

    public Date getFpafTiStatement() {
        if (this.fpafTiStatement != null)
            return (Date) this.fpafTiStatement.clone();
        else
            return null;
    }

    public void setFpafTiStatement(Date fpafTiStatement) {
        if (fpafTiStatement != null)
            this.fpafTiStatement = (Date) fpafTiStatement.clone();
        else
            this.fpafTiStatement = fpafTiStatement;
    }

    public BigDecimal getFpasIdFuncPoolAssignment() {
        return this.fpasIdFuncPoolAssignment;
    }

    public void setFpasIdFuncPoolAssignment(BigDecimal fpasIdFuncPoolAssignment) {
        this.fpasIdFuncPoolAssignment = fpasIdFuncPoolAssignment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fpafTiStatement == null) ? 0 : fpafTiStatement.hashCode());
        result = prime * result + ((fpasIdFuncPoolAssignment == null) ? 0 : fpasIdFuncPoolAssignment.hashCode());
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
        CnalfFuncPoolAssignmentPK other = (CnalfFuncPoolAssignmentPK) obj;
        if (fpafTiStatement == null) {
            if (other.fpafTiStatement != null)
                return false;
        } else if (!fpafTiStatement.equals(other.fpafTiStatement))
            return false;
        if (fpasIdFuncPoolAssignment == null) {
            if (other.fpasIdFuncPoolAssignment != null)
                return false;
        } else if (!fpasIdFuncPoolAssignment.equals(other.fpasIdFuncPoolAssignment))
            return false;
        return true;
    }

}
