package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CecacPartySessionS database table.
 */
@Entity
@NamedQuery(name = "CecacPartySession.findAll", query = "SELECT c FROM CecacPartySession c")
@Table(name = "CECAC_PARTY_SESSION")
public class CecacPartySession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PART_ID_PARTY", nullable = false, precision = 38, unique = true)
    @Id
    private BigDecimal partIdParty;

    @Column(name = "PASE_TI_END_VALIDITY")
    private Timestamp paseTiEndValidity;

    @Column(name = "PASE_TI_START_VALIDITY", nullable = false)
    private Timestamp paseTiStartValidity;

    public BigDecimal getPartIdParty() {
        return this.partIdParty;
    }

    public void setPartIdParty(BigDecimal partIdParty) {
        this.partIdParty = partIdParty;
    }

    public Timestamp getPaseTiEndValidity() {
        if (this.paseTiEndValidity != null)
            return (Timestamp) this.paseTiEndValidity.clone();
        else
            return null;
    }

    public void setPaseTiEndValidity(Timestamp paseTiEndValidity) {
        if (paseTiEndValidity != null)
            this.paseTiEndValidity = (Timestamp) paseTiEndValidity.clone();
        else
            this.paseTiEndValidity = paseTiEndValidity;
    }

    public Timestamp getPaseTiStartValidity() {
        if (this.paseTiStartValidity != null)
            return (Timestamp) this.paseTiStartValidity.clone();
        else
            return null;
    }

    public void setPaseTiStartValidity(Timestamp paseTiStartValidity) {
        if (paseTiStartValidity != null)
            this.paseTiStartValidity = (Timestamp) paseTiStartValidity.clone();
        else
            this.paseTiStartValidity = paseTiStartValidity;
    }

}
