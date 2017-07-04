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
 * The persistent class for the CnalrTemplateChannelTypeS database table.
 */
@Entity
@NamedQuery(name = "CnalrTemplateChannelType.findAll", query = "SELECT c FROM CnalrTemplateChannelType c")
@Table(name = "CNALR_TEMPLATE_CHANNEL_TYPE", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "CHAT_ID_CHANNEL_TYPE", "TPTE_ID_TEMPLATE" }) })
public class CnalrTemplateChannelType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "TECT_ID_TEMPLATE_CHANNEL_TYPE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal tectIdTemplateChannelType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "CHAT_ID_CHANNEL_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldChannelType cnaldChannelType;
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

    public BigDecimal getTectIdTemplateChannelType() {
        return this.tectIdTemplateChannelType;
    }

    public void setTectIdTemplateChannelType(BigDecimal tectIdTemplateChannelType) {
        this.tectIdTemplateChannelType = tectIdTemplateChannelType;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnaldChannelType getCnaldChannelType() {
        return this.cnaldChannelType;
    }

    public void setCnaldChannelType(CnaldChannelType cnaldChannelType) {
        this.cnaldChannelType = cnaldChannelType;
    }

    public CnalpTemplate getCnalpTemplate() {
        return this.cnalpTemplate;
    }

    public void setCnalpTemplate(CnalpTemplate cnalpTemplate) {
        this.cnalpTemplate = cnalpTemplate;
    }

}
