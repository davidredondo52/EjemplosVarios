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
 * The persistent class for the CnalrDocumentModelLS database table.
 */
@Entity
@NamedQuery(name = "CnalrDocumentModelL.findAll", query = "SELECT c FROM CnalrDocumentModelL c")
@Table(name = "CNALR_DOCUMENT_MODEL_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "DOMO_ID_DOCUMENT_MODEL", "LANG_CO_LANGUAGE" }) })
public class CnalrDocumentModelL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "LDMO_ID_LANG_DOCUMENT_MODEL", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal ldmoIdLangDocumentModel;

    @Column(length = 50, name = "LDMO_NA_DOCUMENT_MODEL", nullable = false)
    private String ldmoNaDocumentModel;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "DOMO_ID_DOCUMENT_MODEL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpDocumentModel cnalpDocumentModel;

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

    public BigDecimal getLdmoIdLangDocumentModel() {
        return this.ldmoIdLangDocumentModel;
    }

    public void setLdmoIdLangDocumentModel(BigDecimal ldmoIdLangDocumentModel) {
        this.ldmoIdLangDocumentModel = ldmoIdLangDocumentModel;
    }

    public String getLdmoNaDocumentModel() {
        return this.ldmoNaDocumentModel;
    }

    public void setLdmoNaDocumentModel(String ldmoNaDocumentModel) {
        this.ldmoNaDocumentModel = ldmoNaDocumentModel;
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

    public CnalpDocumentModel getCnalpDocumentModel() {
        return this.cnalpDocumentModel;
    }

    public void setCnalpDocumentModel(CnalpDocumentModel cnalpDocumentModel) {
        this.cnalpDocumentModel = cnalpDocumentModel;
    }

}
