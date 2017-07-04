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
 * The persistent class for the CnalrTaskMailboxLS database table.
 */
@Entity
@NamedQuery(name = "CnalrTaskMailboxL.findAll", query = "SELECT c FROM CnalrTaskMailboxL c")
@Table(name = "CNALR_TASK_MAILBOX_L", uniqueConstraints = { @UniqueConstraint(columnNames = { "MBOX_ID_MAILBOX",
        "LANG_CO_LANGUAGE" }) })
public class CnalrTaskMailboxL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "LBOX_ID_LANG_TASK_MAILBOX", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lboxIdLangTaskMailbox;

    @Column(length = 75, name = "LBOX_NA_MAILBOX", nullable = false)
    private String lboxNaMailbox;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "MBOX_ID_MAILBOX", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaTaskMailbox cnalaTaskMailbox;

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

    public BigDecimal getLboxIdLangTaskMailbox() {
        return this.lboxIdLangTaskMailbox;
    }

    public void setLboxIdLangTaskMailbox(BigDecimal lboxIdLangTaskMailbox) {
        this.lboxIdLangTaskMailbox = lboxIdLangTaskMailbox;
    }

    public String getLboxNaMailbox() {
        return this.lboxNaMailbox;
    }

    public void setLboxNaMailbox(String lboxNaMailbox) {
        this.lboxNaMailbox = lboxNaMailbox;
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

    public CnalaTaskMailbox getCnalaTaskMailbox() {
        return this.cnalaTaskMailbox;
    }

    public void setCnalaTaskMailbox(CnalaTaskMailbox cnalaTaskMailbox) {
        this.cnalaTaskMailbox = cnalaTaskMailbox;
    }

}
