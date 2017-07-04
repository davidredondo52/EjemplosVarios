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
 * The persistent class for the CnalrEnterpriseFunctionLS database table.
 */
@Entity
@NamedQuery(name = "CnalrEnterpriseFunctionL.findAll", query = "SELECT c FROM CnalrEnterpriseFunctionL c")
@Table(name = "CNALR_ENTERPRISE_FUNCTION_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "CUFU_ID_ENTERPRISE_FUNCTION", "LANG_CO_LANGUAGE" }) })
public class CnalrEnterpriseFunctionL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "LEFU_ID_LANG_ENTE_FUNCTION", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lefuIdLangEnteFunction;

    @Column(length = 50, name = "LEFU_NA_ENTERPRISE_FUNCTION", nullable = false)
    private String lefuNaEnterpriseFunction;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "CUFU_ID_ENTERPRISE_FUNCTION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldEnterpriseFunction cnaldEnterpriseFunction;

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

    public BigDecimal getLefuIdLangEnteFunction() {
        return this.lefuIdLangEnteFunction;
    }

    public void setLefuIdLangEnteFunction(BigDecimal lefuIdLangEnteFunction) {
        this.lefuIdLangEnteFunction = lefuIdLangEnteFunction;
    }

    public String getLefuNaEnterpriseFunction() {
        return this.lefuNaEnterpriseFunction;
    }

    public void setLefuNaEnterpriseFunction(String lefuNaEnterpriseFunction) {
        this.lefuNaEnterpriseFunction = lefuNaEnterpriseFunction;
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

    public CnaldEnterpriseFunction getCnaldEnterpriseFunction() {
        return this.cnaldEnterpriseFunction;
    }

    public void setCnaldEnterpriseFunction(CnaldEnterpriseFunction cnaldEnterpriseFunction) {
        this.cnaldEnterpriseFunction = cnaldEnterpriseFunction;
    }

}
