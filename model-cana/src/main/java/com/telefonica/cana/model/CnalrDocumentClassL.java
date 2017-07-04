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
 * The persistent class for the CnalrDocumentClassLS database table.
 */
@Entity
@NamedQuery(name = "CnalrDocumentClassL.findAll", query = "SELECT c FROM CnalrDocumentClassL c")
@Table(name = "CNALR_DOCUMENT_CLASS_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "DOCL_ID_DOCUMENT_CLASS", "LANG_CO_LANGUAGE" }) })
public class CnalrDocumentClassL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "LDCL_ID_LANG_DOCUMENT_CLASS", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal ldclIdLangDocumentClass;

    @Column(length = 50, name = "LDCL_NA_DOCUMENT_CLASS", nullable = false)
    private String ldclNaDocumentClass;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "DOCL_ID_DOCUMENT_CLASS", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldDocumentClass cnaldDocumentClass;

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

    public BigDecimal getLdclIdLangDocumentClass() {
        return this.ldclIdLangDocumentClass;
    }

    public void setLdclIdLangDocumentClass(BigDecimal ldclIdLangDocumentClass) {
        this.ldclIdLangDocumentClass = ldclIdLangDocumentClass;
    }

    public String getLdclNaDocumentClass() {
        return this.ldclNaDocumentClass;
    }

    public void setLdclNaDocumentClass(String ldclNaDocumentClass) {
        this.ldclNaDocumentClass = ldclNaDocumentClass;
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

    public CnaldDocumentClass getCnaldDocumentClass() {
        return this.cnaldDocumentClass;
    }

    public void setCnaldDocumentClass(CnaldDocumentClass cnaldDocumentClass) {
        this.cnaldDocumentClass = cnaldDocumentClass;
    }

}
