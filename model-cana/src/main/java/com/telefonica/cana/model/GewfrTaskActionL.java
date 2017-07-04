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
 * The persistent class for the GewfrTaskActionLS database table.
 */
@Entity
@NamedQuery(name = "GewfrTaskActionL.findAll", query = "SELECT g FROM GewfrTaskActionL g")
@Table(name = "GEWFR_TASK_ACTION_L", uniqueConstraints = { @UniqueConstraint(columnNames = { "TASA_ID_TASK_ACTION",
        "LANG_CO_LANGUAGE" }) })
public class GewfrTaskActionL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(length = 50, name = "TAAL_NA_TASK_ACTION", nullable = false)
    private String taalNaTaskAction;

    @Column(name = "TACL_ID_TASK_ACTION_LANG", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal taclIdTaskActionLang;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "TASA_ID_TASK_ACTION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfdTaskAction gewfdTaskAction;

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

    public String getTaalNaTaskAction() {
        return this.taalNaTaskAction;
    }

    public void setTaalNaTaskAction(String taalNaTaskAction) {
        this.taalNaTaskAction = taalNaTaskAction;
    }

    public BigDecimal getTaclIdTaskActionLang() {
        return this.taclIdTaskActionLang;
    }

    public void setTaclIdTaskActionLang(BigDecimal taclIdTaskActionLang) {
        this.taclIdTaskActionLang = taclIdTaskActionLang;
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

    public GewfdTaskAction getGewfdTaskAction() {
        return this.gewfdTaskAction;
    }

    public void setGewfdTaskAction(GewfdTaskAction gewfdTaskAction) {
        this.gewfdTaskAction = gewfdTaskAction;
    }

}
