package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the GewfrDistributionCriteriaLS database table.
 */
@Entity
@NamedQuery(name = "GewfrDistributionCriteriaL.findAll", query = "SELECT g FROM GewfrDistributionCriteriaL g")
@Table(name = "GEWFR_DISTRIBUTION_CRITERIA_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "DISC_ID_DISTRIBUTION_CRITERIA", "LANG_CO_LANGUAGE" }) })
public class GewfrDistributionCriteriaL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "DICL_ID_DISTRIB_CRITERIA_LANG", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal diclIdDistribCriteriaLang;

    @Column(length = 15, name = "DICL_NA_DISTRIBUTION_CRITERIA", nullable = false)
    private String diclNaDistributionCriteria;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "DISC_ID_DISTRIBUTION_CRITERIA", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfdDistributionCriteria gewfdDistributionCriteria;

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

    public BigDecimal getDiclIdDistribCriteriaLang() {
        return this.diclIdDistribCriteriaLang;
    }

    public void setDiclIdDistribCriteriaLang(BigDecimal diclIdDistribCriteriaLang) {
        this.diclIdDistribCriteriaLang = diclIdDistribCriteriaLang;
    }

    public String getDiclNaDistributionCriteria() {
        return this.diclNaDistributionCriteria;
    }

    public void setDiclNaDistributionCriteria(String diclNaDistributionCriteria) {
        this.diclNaDistributionCriteria = diclNaDistributionCriteria;
    }

    public Long getLangCoLanguage() {
        return this.langCoLanguage;
    }

    public void setLangCoLanguage(Long langCoLanguage) {
        this.langCoLanguage = langCoLanguage;
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

    public GewfdDistributionCriteria getGewfdDistributionCriteria() {
        return this.gewfdDistributionCriteria;
    }

    public void setGewfdDistributionCriteria(GewfdDistributionCriteria gewfdDistributionCriteria) {
        this.gewfdDistributionCriteria = gewfdDistributionCriteria;
    }

}
