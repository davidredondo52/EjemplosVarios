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
 * The persistent class for the GewfrWorkflowSpecLS database table.
 */
@Entity
@NamedQuery(name = "GewfrWorkflowSpecL.findAll", query = "SELECT g FROM GewfrWorkflowSpecL g")
@Table(name = "GEWFR_WORKFLOW_SPEC_L", uniqueConstraints = { @UniqueConstraint(columnNames = { "WSPE_ID_WORKFLOW_SPEC",
        "LANG_CO_LANGUAGE" }) })
public class GewfrWorkflowSpecL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @Column(length = 500, name = "WSPL_DS_WORKFLOW_SPEC", nullable = false)
    private String wsplDsWorkflowSpec;

    @Column(name = "WSPL_ID_WORKFLOW_SPEC_LANG", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal wsplIdWorkflowSpecLang;

    @Column(length = 100, name = "WSPL_NA_WORKFLOW_SPEC", nullable = false)
    private String wsplNaWorkflowSpec;

    @JoinColumn(name = "WSPE_ID_WORKFLOW_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfpWorkflowSpec gewfpWorkflowSpec;

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

    public String getWsplDsWorkflowSpec() {
        return this.wsplDsWorkflowSpec;
    }

    public void setWsplDsWorkflowSpec(String wsplDsWorkflowSpec) {
        this.wsplDsWorkflowSpec = wsplDsWorkflowSpec;
    }

    public BigDecimal getWsplIdWorkflowSpecLang() {
        return this.wsplIdWorkflowSpecLang;
    }

    public void setWsplIdWorkflowSpecLang(BigDecimal wsplIdWorkflowSpecLang) {
        this.wsplIdWorkflowSpecLang = wsplIdWorkflowSpecLang;
    }

    public String getWsplNaWorkflowSpec() {
        return this.wsplNaWorkflowSpec;
    }

    public void setWsplNaWorkflowSpec(String wsplNaWorkflowSpec) {
        this.wsplNaWorkflowSpec = wsplNaWorkflowSpec;
    }

    public GewfpWorkflowSpec getGewfpWorkflowSpec() {
        return this.gewfpWorkflowSpec;
    }

    public void setGewfpWorkflowSpec(GewfpWorkflowSpec gewfpWorkflowSpec) {
        this.gewfpWorkflowSpec = gewfpWorkflowSpec;
    }

}
