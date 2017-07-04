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
 * The persistent class for the GewfrWorkflowTaskLS database table.
 */
@Entity
@NamedQuery(name = "GewfrWorkflowTaskL.findAll", query = "SELECT g FROM GewfrWorkflowTaskL g")
@Table(name = "GEWFR_WORKFLOW_TASK_L", uniqueConstraints = { @UniqueConstraint(columnNames = { "WTAS_ID_WORKFLOW_TASK",
        "LANG_CO_LANGUAGE" }) })
public class GewfrWorkflowTaskL implements Serializable {
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

    @Column(length = 500, name = "WTAL_DS_WORKFLOW_TASK", nullable = false)
    private String wtalDsWorkflowTask;

    @Column(name = "WTAL_ID_WORKFLOW_TASK_LANG", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal wtalIdWorkflowTaskLang;

    @Column(length = 100, name = "WTAL_NA_WORKFLOW_TASK", nullable = false)
    private String wtalNaWorkflowTask;

    @JoinColumn(name = "WTAS_ID_WORKFLOW_TASK", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfdWorkflowTask gewfdWorkflowTask;

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

    public String getWtalDsWorkflowTask() {
        return this.wtalDsWorkflowTask;
    }

    public void setWtalDsWorkflowTask(String wtalDsWorkflowTask) {
        this.wtalDsWorkflowTask = wtalDsWorkflowTask;
    }

    public BigDecimal getWtalIdWorkflowTaskLang() {
        return this.wtalIdWorkflowTaskLang;
    }

    public void setWtalIdWorkflowTaskLang(BigDecimal wtalIdWorkflowTaskLang) {
        this.wtalIdWorkflowTaskLang = wtalIdWorkflowTaskLang;
    }

    public String getWtalNaWorkflowTask() {
        return this.wtalNaWorkflowTask;
    }

    public void setWtalNaWorkflowTask(String wtalNaWorkflowTask) {
        this.wtalNaWorkflowTask = wtalNaWorkflowTask;
    }

    public GewfdWorkflowTask getGewfdWorkflowTask() {
        return this.gewfdWorkflowTask;
    }

    public void setGewfdWorkflowTask(GewfdWorkflowTask gewfdWorkflowTask) {
        this.gewfdWorkflowTask = gewfdWorkflowTask;
    }

}
