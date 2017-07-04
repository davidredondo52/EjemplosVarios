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
 * The persistent class for the CnalrCommunicationPatternLS database table.
 */
@Entity
@NamedQuery(name = "CnalrCommunicationPatternL.findAll", query = "SELECT c FROM CnalrCommunicationPatternL c")
@Table(name = "CNALR_COMMUNICATION_PATTERN_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "COPA_ID_COMMUNICATION_PATTERN", "LANG_CO_LANGUAGE" }) })
public class CnalrCommunicationPatternL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(length = 75, name = "LCPA_DS_COMMUNICATION_PATTERN", nullable = false)
    private String lcpaDsCommunicationPattern;

    @Column(name = "LCPA_ID_LANG_COMMUNICA_PATTERN", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lcpaIdLangCommunicaPattern;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "COPA_ID_COMMUNICATION_PATTERN", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldCommunicationPattern cnaldCommunicationPattern;

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

    public Long getLangCoLanguage() {
        return this.langCoLanguage;
    }

    public void setLangCoLanguage(Long langCoLanguage) {
        this.langCoLanguage = langCoLanguage;
    }

    public String getLcpaDsCommunicationPattern() {
        return this.lcpaDsCommunicationPattern;
    }

    public void setLcpaDsCommunicationPattern(String lcpaDsCommunicationPattern) {
        this.lcpaDsCommunicationPattern = lcpaDsCommunicationPattern;
    }

    public BigDecimal getLcpaIdLangCommunicaPattern() {
        return this.lcpaIdLangCommunicaPattern;
    }

    public void setLcpaIdLangCommunicaPattern(BigDecimal lcpaIdLangCommunicaPattern) {
        this.lcpaIdLangCommunicaPattern = lcpaIdLangCommunicaPattern;
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

    public CnaldCommunicationPattern getCnaldCommunicationPattern() {
        return this.cnaldCommunicationPattern;
    }

    public void setCnaldCommunicationPattern(CnaldCommunicationPattern cnaldCommunicationPattern) {
        this.cnaldCommunicationPattern = cnaldCommunicationPattern;
    }

}
