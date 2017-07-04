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
 * The persistent class for the CnalrChannelTypeLS database table.
 */
@Entity
@NamedQuery(name = "CnalrChannelTypeL.findAll", query = "SELECT c FROM CnalrChannelTypeL c")
@Table(name = "CNALR_CHANNEL_TYPE_L", uniqueConstraints = { @UniqueConstraint(columnNames = { "CHAT_ID_CHANNEL_TYPE",
        "LANG_CO_LANGUAGE" }) })
public class CnalrChannelTypeL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "LCHT_ID_LANG_CHANNEL_TYPE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lchtIdLangChannelType;

    @Column(length = 20, name = "LCHT_NA_CHANNEL_TYPE", nullable = false)
    private String lchtNaChannelType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "CHAT_ID_CHANNEL_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldChannelType cnaldChannelType;

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

    public BigDecimal getLchtIdLangChannelType() {
        return this.lchtIdLangChannelType;
    }

    public void setLchtIdLangChannelType(BigDecimal lchtIdLangChannelType) {
        this.lchtIdLangChannelType = lchtIdLangChannelType;
    }

    public String getLchtNaChannelType() {
        return this.lchtNaChannelType;
    }

    public void setLchtNaChannelType(String lchtNaChannelType) {
        this.lchtNaChannelType = lchtNaChannelType;
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

    public CnaldChannelType getCnaldChannelType() {
        return this.cnaldChannelType;
    }

    public void setCnaldChannelType(CnaldChannelType cnaldChannelType) {
        this.cnaldChannelType = cnaldChannelType;
    }

}
