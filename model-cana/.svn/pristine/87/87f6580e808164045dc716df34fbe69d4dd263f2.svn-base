package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CecacLoggedManagerPKS database table.
 */
@Embeddable
public class CecacLoggedManagerPK implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(columnDefinition = "DATE", name = "LOMA_DA_QUERY", nullable = false, unique = true)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lomaDaQuery;

    @Column(name = "PART_ID_PARTY", nullable = false, precision = 38, unique = true)
    private BigDecimal partIdParty;

    public Date getLomaDaQuery() {
        if (this.lomaDaQuery != null)
            return (Date) this.lomaDaQuery.clone();
        else
            return null;
    }

    public void setLomaDaQuery(Date lomaDaQuery) {
        if (lomaDaQuery != null)
            this.lomaDaQuery = (Date) lomaDaQuery.clone();
        else
            this.lomaDaQuery = lomaDaQuery;
    }

    public BigDecimal getPartIdParty() {
        return this.partIdParty;
    }

    public void setPartIdParty(BigDecimal partIdParty) {
        this.partIdParty = partIdParty;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lomaDaQuery == null) ? 0 : lomaDaQuery.hashCode());
        result = prime * result + ((partIdParty == null) ? 0 : partIdParty.hashCode());
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
        CecacLoggedManagerPK other = (CecacLoggedManagerPK) obj;
        if (lomaDaQuery == null) {
            if (other.lomaDaQuery != null)
                return false;
        } else if (!lomaDaQuery.equals(other.lomaDaQuery))
            return false;
        if (partIdParty == null) {
            if (other.partIdParty != null)
                return false;
        } else if (!partIdParty.equals(other.partIdParty))
            return false;
        return true;
    }

}
