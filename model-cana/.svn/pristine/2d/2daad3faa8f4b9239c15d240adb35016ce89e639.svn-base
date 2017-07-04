package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the GewfdDistributionCriteriaS database table.
 */
@Entity
@NamedQuery(name = "GewfdDistributionCriteria.findAll", query = "SELECT g FROM GewfdDistributionCriteria g")
@Table(name = "GEWFD_DISTRIBUTION_CRITERIA")
public class GewfdDistributionCriteria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(length = 15, name = "DICL_NA_DISTRIBUTION_CRITERIA", nullable = false)
    private String diclNaDistributionCriteria;

    @Column(columnDefinition = "DATE", name = "DISC_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date discDaEndValidity;

    @Column(columnDefinition = "DATE", name = "DISC_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date discDaStartValidity;

    @Column(name = "DISC_ID_DISTRIBUTION_CRITERIA", nullable = false, precision = 1, unique = true)
    @Id
    private Long discIdDistributionCriteria;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "gewfdDistributionCriteria")
    private List<CnalaTaskMailbox> cnalaTaskMailboxs;
    @OneToMany(mappedBy = "gewfdDistributionCriteria")
    private List<GewfrDistributionCriteriaL> gewfrDistributionCriteriaLs;

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

    public String getDiclNaDistributionCriteria() {
        return this.diclNaDistributionCriteria;
    }

    public void setDiclNaDistributionCriteria(String diclNaDistributionCriteria) {
        this.diclNaDistributionCriteria = diclNaDistributionCriteria;
    }

    public Date getDiscDaEndValidity() {
        if (this.discDaEndValidity != null)
            return (Date) this.discDaEndValidity.clone();
        else
            return null;
    }

    public void setDiscDaEndValidity(Date discDaEndValidity) {
        if (discDaEndValidity != null)
            this.discDaEndValidity = (Date) discDaEndValidity.clone();
        else
            this.discDaEndValidity = discDaEndValidity;
    }

    public Date getDiscDaStartValidity() {
        if (this.discDaStartValidity != null)
            return (Date) this.discDaStartValidity.clone();
        else
            return null;
    }

    public void setDiscDaStartValidity(Date discDaStartValidity) {
        if (discDaStartValidity != null)
            this.discDaStartValidity = (Date) discDaStartValidity.clone();
        else
            this.discDaStartValidity = discDaStartValidity;
    }

    public Long getDiscIdDistributionCriteria() {
        return this.discIdDistributionCriteria;
    }

    public void setDiscIdDistributionCriteria(Long discIdDistributionCriteria) {
        this.discIdDistributionCriteria = discIdDistributionCriteria;
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

    public List<CnalaTaskMailbox> getCnalaTaskMailboxs() {
        return this.cnalaTaskMailboxs;
    }

    public void setCnalaTaskMailboxs(List<CnalaTaskMailbox> cnalaTaskMailboxs) {
        this.cnalaTaskMailboxs = cnalaTaskMailboxs;
    }

    public void addCnalaTaskMailboxs(CnalaTaskMailbox cnalaTaskMailbox) {
        if (this.cnalaTaskMailboxs == null)
            this.cnalaTaskMailboxs = new ArrayList<CnalaTaskMailbox>();
        this.cnalaTaskMailboxs.add(cnalaTaskMailbox);
    }

    public void removeCnalaTaskMailboxs(CnalaTaskMailbox cnalaTaskMailboxToRemove) {
        if (cnalaTaskMailboxToRemove != null)
            this.cnalaTaskMailboxs.remove(cnalaTaskMailboxToRemove);
    }

    public List<GewfrDistributionCriteriaL> getGewfrDistributionCriteriaLs() {
        return this.gewfrDistributionCriteriaLs;
    }

    public void setGewfrDistributionCriteriaLs(List<GewfrDistributionCriteriaL> gewfrDistributionCriteriaLs) {
        this.gewfrDistributionCriteriaLs = gewfrDistributionCriteriaLs;
    }

    public void addGewfrDistributionCriteriaLs(GewfrDistributionCriteriaL gewfrDistributionCriteriaL) {
        if (this.gewfrDistributionCriteriaLs == null)
            this.gewfrDistributionCriteriaLs = new ArrayList<GewfrDistributionCriteriaL>();
        this.gewfrDistributionCriteriaLs.add(gewfrDistributionCriteriaL);
    }

    public void removeGewfrDistributionCriteriaLs(GewfrDistributionCriteriaL gewfrDistributionCriteriaLToRemove) {
        if (gewfrDistributionCriteriaLToRemove != null)
            this.gewfrDistributionCriteriaLs.remove(gewfrDistributionCriteriaLToRemove);
    }

}
