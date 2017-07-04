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
 * The persistent class for the CnalaLabelSubtemplateS database table.
 */
@Entity
@NamedQuery(name = "CnalaLabelSubtemplate.findAll", query = "SELECT c FROM CnalaLabelSubtemplate c")
@Table(name = "CNALA_LABEL_SUBTEMPLATE", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "TLAB_ID_TEMPLATE_LABEL", "AUDI_TI_CREATION" }) })
public class CnalaLabelSubtemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "LSBT_ID_LABEL_SUBTEMPLATE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal lsbtIdLabelSubtemplate;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "TLAB_ID_TEMPLATE_LABEL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaTemplateLabel cnalaTemplateLabel;
    @JoinColumn(name = "TPTE_ID_SUBTEMPLATE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpTemplate cnalpTemplate1;
    @JoinColumn(name = "TPTE_ID_TEMPLATE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpTemplate cnalpTemplate2;

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

    public BigDecimal getLsbtIdLabelSubtemplate() {
        return this.lsbtIdLabelSubtemplate;
    }

    public void setLsbtIdLabelSubtemplate(BigDecimal lsbtIdLabelSubtemplate) {
        this.lsbtIdLabelSubtemplate = lsbtIdLabelSubtemplate;
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

    public CnalaTemplateLabel getCnalaTemplateLabel() {
        return this.cnalaTemplateLabel;
    }

    public void setCnalaTemplateLabel(CnalaTemplateLabel cnalaTemplateLabel) {
        this.cnalaTemplateLabel = cnalaTemplateLabel;
    }

    public CnalpTemplate getCnalpTemplate1() {
        return this.cnalpTemplate1;
    }

    public void setCnalpTemplate1(CnalpTemplate cnalpTemplate1) {
        this.cnalpTemplate1 = cnalpTemplate1;
    }

    public CnalpTemplate getCnalpTemplate2() {
        return this.cnalpTemplate2;
    }

    public void setCnalpTemplate2(CnalpTemplate cnalpTemplate2) {
        this.cnalpTemplate2 = cnalpTemplate2;
    }

}
