package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CecacPartyNameS database table.
 */
@Entity
@NamedQuery(name = "CecacPartyName.findAll", query = "SELECT c FROM CecacPartyName c")
@Table(name = "CECAC_PARTY_NAME")
public class CecacPartyName implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 160, name = "PANA_NA_PARTY_NAME")
    private String panaNaPartyName;

    @Column(name = "PART_ID_PARTY", nullable = false, precision = 38, unique = true)
    @Id
    private BigDecimal partIdParty;

    public String getPanaNaPartyName() {
        return this.panaNaPartyName;
    }

    public void setPanaNaPartyName(String panaNaPartyName) {
        this.panaNaPartyName = panaNaPartyName;
    }

    public BigDecimal getPartIdParty() {
        return this.partIdParty;
    }

    public void setPartIdParty(BigDecimal partIdParty) {
        this.partIdParty = partIdParty;
    }

}
