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
 * The persistent class for the ScderDemandTypeTemplateS database table.
 */
@Entity
@NamedQuery(name = "ScderDemandTypeTemplate.findAll", query = "SELECT s FROM ScderDemandTypeTemplate s")
@Table(name = "SCDER_DEMAND_TYPE_TEMPLATE", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "SCDT_ID_CHANNEL_DEMAND_TYPE", "TPTE_ID_TEMPLATE" }) })
public class ScderDemandTypeTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "DTTE_ID_DEMAND_TYPE_TEMPLATE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal dtteIdDemandTypeTemplate;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "TPTE_ID_TEMPLATE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpTemplate cnalpTemplate;
    @JoinColumn(name = "SCDT_ID_CHANNEL_DEMAND_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScdedChannelDemandType scdedChannelDemandType;

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

    public BigDecimal getDtteIdDemandTypeTemplate() {
        return this.dtteIdDemandTypeTemplate;
    }

    public void setDtteIdDemandTypeTemplate(BigDecimal dtteIdDemandTypeTemplate) {
        this.dtteIdDemandTypeTemplate = dtteIdDemandTypeTemplate;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnalpTemplate getCnalpTemplate() {
        return this.cnalpTemplate;
    }

    public void setCnalpTemplate(CnalpTemplate cnalpTemplate) {
        this.cnalpTemplate = cnalpTemplate;
    }

    public ScdedChannelDemandType getScdedChannelDemandType() {
        return this.scdedChannelDemandType;
    }

    public void setScdedChannelDemandType(ScdedChannelDemandType scdedChannelDemandType) {
        this.scdedChannelDemandType = scdedChannelDemandType;
    }

}
