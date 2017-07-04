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
 * The persistent class for the CnalrFunctionalPoolSpecLS database table.
 */
@Entity
@NamedQuery(name = "CnalrFunctionalPoolSpecL.findAll", query = "SELECT c FROM CnalrFunctionalPoolSpecL c")
@Table(name = "CNALR_FUNCTIONAL_POOL_SPEC_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "FUPS_ID_FUNCTIONAL_POOL_SPEC", "LANG_CO_LANGUAGE" }) })
public class CnalrFunctionalPoolSpecL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(length = 200, name = "LFPS_DS_FUNCTIONAL_POOL_SPEC", nullable = false)
    private String lfpsDsFunctionalPoolSpec;

    @Column(name = "LFPS_ID_LANG_FUNC_POOL_SPEC", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lfpsIdLangFuncPoolSpec;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "FUPS_ID_FUNCTIONAL_POOL_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpFunctionalPoolSpec cnalpFunctionalPoolSpec;

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

    public String getLfpsDsFunctionalPoolSpec() {
        return this.lfpsDsFunctionalPoolSpec;
    }

    public void setLfpsDsFunctionalPoolSpec(String lfpsDsFunctionalPoolSpec) {
        this.lfpsDsFunctionalPoolSpec = lfpsDsFunctionalPoolSpec;
    }

    public BigDecimal getLfpsIdLangFuncPoolSpec() {
        return this.lfpsIdLangFuncPoolSpec;
    }

    public void setLfpsIdLangFuncPoolSpec(BigDecimal lfpsIdLangFuncPoolSpec) {
        this.lfpsIdLangFuncPoolSpec = lfpsIdLangFuncPoolSpec;
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

    public CnalpFunctionalPoolSpec getCnalpFunctionalPoolSpec() {
        return this.cnalpFunctionalPoolSpec;
    }

    public void setCnalpFunctionalPoolSpec(CnalpFunctionalPoolSpec cnalpFunctionalPoolSpec) {
        this.cnalpFunctionalPoolSpec = cnalpFunctionalPoolSpec;
    }

}
