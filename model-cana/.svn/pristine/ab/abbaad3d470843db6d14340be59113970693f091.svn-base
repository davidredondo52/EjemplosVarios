package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the CecaaChanAdeqStateMovS database table.
 */
@Entity
@NamedQuery(name = "CecaaChanAdeqStateMov.findAll", query = "SELECT c FROM CecaaChanAdeqStateMov c")
@Table(name = "CECAA_CHAN_ADEQ_STATE_MOV", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "SCPR_ID_SALES_CHANNEL_ADEQUACY", "BINT_ID_CHANNEL_ADEQUACY_TYPE", "AUDI_TI_CREATION" }) })
public class CecaaChanAdeqStateMov implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "BISM_ID_CHAN_ADEQ_STATE_MOV", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal bismIdChanAdeqStateMov;

    @Column(length = 500, name = "BISM_OB_CHAN_ADEQ_STATE_MOV")
    private String bismObChanAdeqStateMov;

    @Column(name = "PARO_ID_ORG_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdOrgRole;

    @Column(name = "SCPR_ID_SALES_CHANNEL_ADEQUACY", nullable = false, precision = 38)
    private BigDecimal scprIdSalesChannelAdequacy;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "BCSR_ID_CHAN_ADEQ_STATE_REASON")
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private CecadChanAdeqStateReason cecadChanAdeqStateReason;
    @JoinColumns({
            @JoinColumn(referencedColumnName = "BINT_ID_CHANNEL_ADEQUACY_TYPE", nullable = false, name = "BINT_ID_CHANNEL_ADEQUACY_TYPE"),
            @JoinColumn(referencedColumnName = "BIST_ID_CHANNEL_ADEQUACY_STATE", nullable = false, name = "BIST_ID_CHANNEL_ADEQUACY_STATE") })
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private CecarChanAdeqStateRel cecarChanAdeqStateRel;
    
    @JoinColumn(name = "SCPR_ID_SALES_CHANNEL_ADEQUACY", nullable = false, insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScdepSalesChannelDemand scdepSalesChannelDemand;
    @JoinColumn(insertable = false, name = "SCPR_ID_SALES_CHANNEL_ADEQUACY", nullable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScprpSalesChannelProposal scprpSalesChannelProposal;

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

    public BigDecimal getBismIdChanAdeqStateMov() {
        return this.bismIdChanAdeqStateMov;
    }

    public void setBismIdChanAdeqStateMov(BigDecimal bismIdChanAdeqStateMov) {
        this.bismIdChanAdeqStateMov = bismIdChanAdeqStateMov;
    }

    public String getBismObChanAdeqStateMov() {
        return this.bismObChanAdeqStateMov;
    }

    public void setBismObChanAdeqStateMov(String bismObChanAdeqStateMov) {
        this.bismObChanAdeqStateMov = bismObChanAdeqStateMov;
    }

    public BigDecimal getParoIdOrgRole() {
        return this.paroIdOrgRole;
    }

    public void setParoIdOrgRole(BigDecimal paroIdOrgRole) {
        this.paroIdOrgRole = paroIdOrgRole;
    }

    public BigDecimal getScprIdSalesChannelAdequacy() {
        return this.scprIdSalesChannelAdequacy;
    }

    public void setScprIdSalesChannelAdequacy(BigDecimal scprIdSalesChannelAdequacy) {
        this.scprIdSalesChannelAdequacy = scprIdSalesChannelAdequacy;
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

    public CecadChanAdeqStateReason getCecadChanAdeqStateReason() {
        return this.cecadChanAdeqStateReason;
    }

    public void setCecadChanAdeqStateReason(CecadChanAdeqStateReason cecadChanAdeqStateReason) {
        this.cecadChanAdeqStateReason = cecadChanAdeqStateReason;
    }

    public CecarChanAdeqStateRel getCecarChanAdeqStateRel() {
        return this.cecarChanAdeqStateRel;
    }

    public void setCecarChanAdeqStateRel(CecarChanAdeqStateRel cecarChanAdeqStateRel) {
        this.cecarChanAdeqStateRel = cecarChanAdeqStateRel;
    }

    public ScdepSalesChannelDemand getScdepSalesChannelDemand() {
        return this.scdepSalesChannelDemand;
    }
    public void setScdepSalesChannelDemand(ScdepSalesChannelDemand scdepSalesChannelDemand) {
        this.scdepSalesChannelDemand = scdepSalesChannelDemand;
    }
    public ScprpSalesChannelProposal getScprpSalesChannelProposal() {
        return this.scprpSalesChannelProposal;
    }

    public void setScprpSalesChannelProposal(ScprpSalesChannelProposal scprpSalesChannelProposal) {
        this.scprpSalesChannelProposal = scprpSalesChannelProposal;
    }
    
}
