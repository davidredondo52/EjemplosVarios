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
 * The persistent class for the CecarChannelAdequacyStateLS database table.
 */
@Entity
@NamedQuery(name = "CecarChannelAdequacyStateL.findAll", query = "SELECT c FROM CecarChannelAdequacyStateL c")
@Table(name = "CECAR_CHANNEL_ADEQUACY_STATE_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BIST_ID_CHANNEL_ADEQUACY_STATE", "LANG_CO_LANGUAGE" }) })
public class CecarChannelAdequacyStateL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(length = 100, name = "LBIS_DS_CHANNEL_ADEQUACY_STATE")
    private String lbisDsChannelAdequacyState;

    @Column(name = "LBIS_ID_LANG_CHAN_ADEQ_STATE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lbisIdLangChanAdeqState;

    @Column(length = 40, name = "LBIS_NA_CHANNEL_ADEQUACY_STATE", nullable = false)
    private String lbisNaChannelAdequacyState;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "BIST_ID_CHANNEL_ADEQUACY_STATE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CecadChannelAdequacyState cecadChannelAdequacyState;

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

    public String getLbisDsChannelAdequacyState() {
        return this.lbisDsChannelAdequacyState;
    }

    public void setLbisDsChannelAdequacyState(String lbisDsChannelAdequacyState) {
        this.lbisDsChannelAdequacyState = lbisDsChannelAdequacyState;
    }

    public BigDecimal getLbisIdLangChanAdeqState() {
        return this.lbisIdLangChanAdeqState;
    }

    public void setLbisIdLangChanAdeqState(BigDecimal lbisIdLangChanAdeqState) {
        this.lbisIdLangChanAdeqState = lbisIdLangChanAdeqState;
    }

    public String getLbisNaChannelAdequacyState() {
        return this.lbisNaChannelAdequacyState;
    }

    public void setLbisNaChannelAdequacyState(String lbisNaChannelAdequacyState) {
        this.lbisNaChannelAdequacyState = lbisNaChannelAdequacyState;
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

    public CecadChannelAdequacyState getCecadChannelAdequacyState() {
        return this.cecadChannelAdequacyState;
    }

    public void setCecadChannelAdequacyState(CecadChannelAdequacyState cecadChannelAdequacyState) {
        this.cecadChannelAdequacyState = cecadChannelAdequacyState;
    }

}
