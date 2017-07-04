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
 * The persistent class for the CnalrDocumentTypeLS database table.
 */
@Entity
@NamedQuery(name = "CnalrDocumentTypeL.findAll", query = "SELECT c FROM CnalrDocumentTypeL c")
@Table(name = "CNALR_DOCUMENT_TYPE_L", uniqueConstraints = { @UniqueConstraint(columnNames = { "DOTY_ID_DOCUMENT_TYPE",
        "LANG_CO_LANGUAGE" }) })
public class CnalrDocumentTypeL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "LDTY_ID_LANG_DOCUMENT_TYPE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal ldtyIdLangDocumentType;

    @Column(length = 50, name = "LDTY_NA_DOCUMENT_TYPE", nullable = false)
    private String ldtyNaDocumentType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "DOTY_ID_DOCUMENT_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldDocumentType cnaldDocumentType;

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

    public BigDecimal getLdtyIdLangDocumentType() {
        return this.ldtyIdLangDocumentType;
    }

    public void setLdtyIdLangDocumentType(BigDecimal ldtyIdLangDocumentType) {
        this.ldtyIdLangDocumentType = ldtyIdLangDocumentType;
    }

    public String getLdtyNaDocumentType() {
        return this.ldtyNaDocumentType;
    }

    public void setLdtyNaDocumentType(String ldtyNaDocumentType) {
        this.ldtyNaDocumentType = ldtyNaDocumentType;
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

    public CnaldDocumentType getCnaldDocumentType() {
        return this.cnaldDocumentType;
    }

    public void setCnaldDocumentType(CnaldDocumentType cnaldDocumentType) {
        this.cnaldDocumentType = cnaldDocumentType;
    }

}
