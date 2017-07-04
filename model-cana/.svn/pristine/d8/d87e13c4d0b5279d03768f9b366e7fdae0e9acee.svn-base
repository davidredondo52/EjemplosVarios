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
 * The persistent class for the CnalrTemplateLS database table.
 */
@Entity
@NamedQuery(name = "CnalrTemplateL.findAll", query = "SELECT c FROM CnalrTemplateL c")
@Table(name = "CNALR_TEMPLATE_L", uniqueConstraints = { @UniqueConstraint(columnNames = { "TPTE_ID_TEMPLATE",
        "LANG_CO_LANGUAGE" }) })
public class CnalrTemplateL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "LETE_ID_TEMPLATE_LANG", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal leteIdTemplateLang;

    @Column(length = 50, name = "LETE_NA_TEMPLATE", nullable = false)
    private String leteNaTemplate;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

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

    public BigDecimal getLeteIdTemplateLang() {
        return this.leteIdTemplateLang;
    }

    public void setLeteIdTemplateLang(BigDecimal leteIdTemplateLang) {
        this.leteIdTemplateLang = leteIdTemplateLang;
    }

    public String getLeteNaTemplate() {
        return this.leteNaTemplate;
    }

    public void setLeteNaTemplate(String leteNaTemplate) {
        this.leteNaTemplate = leteNaTemplate;
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

    public CnalpTemplate getCnalpTemplate() {
        return this.cnalpTemplate;
    }

    public void setCnalpTemplate(CnalpTemplate cnalpTemplate) {
        this.cnalpTemplate = cnalpTemplate;
    }

}
