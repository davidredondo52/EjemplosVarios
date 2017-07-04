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
 * The persistent class for the CnalrSalesChannelLS database table.
 */
@Entity
@NamedQuery(name = "CnalrSalesChannelL.findAll", query = "SELECT c FROM CnalrSalesChannelL c")
@Table(name = "CNALR_SALES_CHANNEL_L", uniqueConstraints = { @UniqueConstraint(columnNames = { "SCHA_ID_SALES_CHANNEL",
        "LANG_CO_LANGUAGE" }) })
public class CnalrSalesChannelL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "LSAC_ID_LANG_SALES_CHANNEL", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lsacIdLangSalesChannel;

    @Column(length = 100, name = "LSAC_NA_SALES_CHANNEL", nullable = false)
    private String lsacNaSalesChannel;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "SCHA_ID_SALES_CHANNEL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldSalesChannel cnaldSalesChannel;

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

    public BigDecimal getLsacIdLangSalesChannel() {
        return this.lsacIdLangSalesChannel;
    }

    public void setLsacIdLangSalesChannel(BigDecimal lsacIdLangSalesChannel) {
        this.lsacIdLangSalesChannel = lsacIdLangSalesChannel;
    }

    public String getLsacNaSalesChannel() {
        return this.lsacNaSalesChannel;
    }

    public void setLsacNaSalesChannel(String lsacNaSalesChannel) {
        this.lsacNaSalesChannel = lsacNaSalesChannel;
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

    public CnaldSalesChannel getCnaldSalesChannel() {
        return this.cnaldSalesChannel;
    }

    public void setCnaldSalesChannel(CnaldSalesChannel cnaldSalesChannel) {
        this.cnaldSalesChannel = cnaldSalesChannel;
    }

}
