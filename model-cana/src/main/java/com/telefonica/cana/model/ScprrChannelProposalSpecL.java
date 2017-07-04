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
 * The persistent class for the ScprrChannelProposalSpecLS database table.
 */
@Entity
@NamedQuery(name = "ScprrChannelProposalSpecL.findAll", query = "SELECT s FROM ScprrChannelProposalSpecL s")
@Table(name = "SCPRR_CHANNEL_PROPOSAL_SPEC_L", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BISP_ID_CHANNEL_PROPOSAL_SPEC", "LANG_CO_LANGUAGE" }) })
public class ScprrChannelProposalSpecL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(length = 500, name = "BISL_DS_CHANNEL_PROPOSAL_SPEC")
    private String bislDsChannelProposalSpec;

    @Column(name = "BISL_ID_CHAN_PROP_SPEC_LANG", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal bislIdChanPropSpecLang;

    @Column(length = 100, name = "BISL_NA_CHANNEL_PROPOSAL_SPEC", nullable = false)
    private String bislNaChannelProposalSpec;

    @Column(name = "LANG_CO_LANGUAGE", nullable = false, precision = 3)
    private Long langCoLanguage;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "BISP_ID_CHANNEL_PROPOSAL_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScprdChannelProposalSpec scprdChannelProposalSpec;

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

    public String getBislDsChannelProposalSpec() {
        return this.bislDsChannelProposalSpec;
    }

    public void setBislDsChannelProposalSpec(String bislDsChannelProposalSpec) {
        this.bislDsChannelProposalSpec = bislDsChannelProposalSpec;
    }

    public BigDecimal getBislIdChanPropSpecLang() {
        return this.bislIdChanPropSpecLang;
    }

    public void setBislIdChanPropSpecLang(BigDecimal bislIdChanPropSpecLang) {
        this.bislIdChanPropSpecLang = bislIdChanPropSpecLang;
    }

    public String getBislNaChannelProposalSpec() {
        return this.bislNaChannelProposalSpec;
    }

    public void setBislNaChannelProposalSpec(String bislNaChannelProposalSpec) {
        this.bislNaChannelProposalSpec = bislNaChannelProposalSpec;
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

    public ScprdChannelProposalSpec getScprdChannelProposalSpec() {
        return this.scprdChannelProposalSpec;
    }

    public void setScprdChannelProposalSpec(ScprdChannelProposalSpec scprdChannelProposalSpec) {
        this.scprdChannelProposalSpec = scprdChannelProposalSpec;
    }

}
