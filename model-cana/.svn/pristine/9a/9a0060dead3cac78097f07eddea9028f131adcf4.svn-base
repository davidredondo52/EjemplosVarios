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
 * The persistent class for the CnalrProcessDefinitionLS database table.
 */
@Entity
@NamedQuery(name = "CnalrProcessDefinitionL.findAll", query = "SELECT c FROM CnalrProcessDefinitionL c")
@Table(name = "CNALR_PROCESS_DEFINITION_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "PRDE_ID_PROCESS_DEFINITION", "LANG_CO_LANGUAGE" }) })
public class CnalrProcessDefinitionL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(length = 200, name = "EXPL_DS_PROCESS_OPERATIVE")
    private String explDsProcessOperative;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(length = 100, name = "LPRD_DS_PROCESS_DEFINITION", nullable = false)
    private String lprdDsProcessDefinition;

    @Column(name = "LPRD_ID_LANG_PROCESS_DEF", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lprdIdLangProcessDef;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "PRDE_ID_PROCESS_DEFINITION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpProcessDefinition cnalpProcessDefinition;

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

    public String getExplDsProcessOperative() {
        return this.explDsProcessOperative;
    }

    public void setExplDsProcessOperative(String explDsProcessOperative) {
        this.explDsProcessOperative = explDsProcessOperative;
    }

    public Long getLangCoLanguage() {
        return this.langCoLanguage;
    }

    public void setLangCoLanguage(Long langCoLanguage) {
        this.langCoLanguage = langCoLanguage;
    }

    public String getLprdDsProcessDefinition() {
        return this.lprdDsProcessDefinition;
    }

    public void setLprdDsProcessDefinition(String lprdDsProcessDefinition) {
        this.lprdDsProcessDefinition = lprdDsProcessDefinition;
    }

    public BigDecimal getLprdIdLangProcessDef() {
        return this.lprdIdLangProcessDef;
    }

    public void setLprdIdLangProcessDef(BigDecimal lprdIdLangProcessDef) {
        this.lprdIdLangProcessDef = lprdIdLangProcessDef;
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

    public CnalpProcessDefinition getCnalpProcessDefinition() {
        return this.cnalpProcessDefinition;
    }

    public void setCnalpProcessDefinition(CnalpProcessDefinition cnalpProcessDefinition) {
        this.cnalpProcessDefinition = cnalpProcessDefinition;
    }

}
