package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the CnaldNoDistributedMotiveS database table.
 */
@Entity
@NamedQuery(name = "CnaldNoDistributedMotive.findAll", query = "SELECT c FROM CnaldNoDistributedMotive c")
@Table(name = "CNALD_NO_DISTRIBUTED_MOTIVE")
public class CnaldNoDistributedMotive implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "NODM_ID_NO_DISTRIBUTED_MOTIVE", nullable = false, precision = 3, unique = true)
    @Id
    private Long nodmIdNoDistributedMotive;

    @Column(length = 100, name = "NODM_NA_NO_DISTRIBUTED_MOTIVE", nullable = false)
    private String nodmNaNoDistributedMotive;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnaldNoDistributedMotive")
    private List<CnalaDistributionLogItem> cnalaDistributionLogItems;

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

    public Long getNodmIdNoDistributedMotive() {
        return this.nodmIdNoDistributedMotive;
    }

    public void setNodmIdNoDistributedMotive(Long nodmIdNoDistributedMotive) {
        this.nodmIdNoDistributedMotive = nodmIdNoDistributedMotive;
    }

    public String getNodmNaNoDistributedMotive() {
        return this.nodmNaNoDistributedMotive;
    }

    public void setNodmNaNoDistributedMotive(String nodmNaNoDistributedMotive) {
        this.nodmNaNoDistributedMotive = nodmNaNoDistributedMotive;
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

    public List<CnalaDistributionLogItem> getCnalaDistributionLogItems() {
        return this.cnalaDistributionLogItems;
    }

    public void setCnalaDistributionLogItems(List<CnalaDistributionLogItem> cnalaDistributionLogItems) {
        this.cnalaDistributionLogItems = cnalaDistributionLogItems;
    }

    public void addCnalaDistributionLogItems(CnalaDistributionLogItem cnalaDistributionLogItem) {
        if (this.cnalaDistributionLogItems == null)
            this.cnalaDistributionLogItems = new ArrayList<CnalaDistributionLogItem>();
        this.cnalaDistributionLogItems.add(cnalaDistributionLogItem);
    }

    public void removeCnalaDistributionLogItems(CnalaDistributionLogItem cnalaDistributionLogItemToRemove) {
        if (cnalaDistributionLogItemToRemove != null)
            this.cnalaDistributionLogItems.remove(cnalaDistributionLogItemToRemove);
    }

}
