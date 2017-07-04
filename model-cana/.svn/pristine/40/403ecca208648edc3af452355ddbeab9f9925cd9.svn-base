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

/**
 * The persistent class for the CnalrTemplateModelS database table.
 */
@Entity
@NamedQuery(name = "CnalrTemplateModel.findAll", query = "SELECT c FROM CnalrTemplateModel c")
@Table(name = "CNALR_TEMPLATE_MODEL")
public class CnalrTemplateModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "TEMO_ID_TEMPLATE_MODEL", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal temoIdTemplateModel;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "DOMO_ID_DOCUMENT_MODEL")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpDocumentModel cnalpDocumentModel;
    @JoinColumn(name = "STMO_ID_STATEMENT_MODEL")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpStatementModel cnalpStatementModel;
    @JoinColumn(name = "TPTE_ID_TEMPLATE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpTemplate cnalpTemplate;

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

    public BigDecimal getTemoIdTemplateModel() {
        return this.temoIdTemplateModel;
    }

    public void setTemoIdTemplateModel(BigDecimal temoIdTemplateModel) {
        this.temoIdTemplateModel = temoIdTemplateModel;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnalpDocumentModel getCnalpDocumentModel() {
        return this.cnalpDocumentModel;
    }

    public void setCnalpDocumentModel(CnalpDocumentModel cnalpDocumentModel) {
        this.cnalpDocumentModel = cnalpDocumentModel;
    }

    public CnalpStatementModel getCnalpStatementModel() {
        return this.cnalpStatementModel;
    }

    public void setCnalpStatementModel(CnalpStatementModel cnalpStatementModel) {
        this.cnalpStatementModel = cnalpStatementModel;
    }

    public CnalpTemplate getCnalpTemplate() {
        return this.cnalpTemplate;
    }

    public void setCnalpTemplate(CnalpTemplate cnalpTemplate) {
        this.cnalpTemplate = cnalpTemplate;
    }

}
