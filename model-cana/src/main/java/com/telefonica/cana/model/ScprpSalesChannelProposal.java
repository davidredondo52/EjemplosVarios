package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the ScprpSalesChannelProposalS database table.
 */
@Entity
@NamedQuery(name = "ScprpSalesChannelProposal.findAll", query = "SELECT s FROM ScprpSalesChannelProposal s")
@Table(name = "SCPRP_SALES_CHANNEL_PROPOSAL")
public class ScprpSalesChannelProposal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(length = 14, name = "BUIN_CO_CHANNEL_PROPOSAL")
    private String buinCoChannelProposal;

    @Column(length = 500, name = "BUIN_DS_CHANNEL_PROPOSAL", nullable = false)
    private String buinDsChannelProposal;

    @Column(name = "BUIN_ID_SALES_CHANNEL_PROPOSAL", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal buinIdSalesChannelProposal;

    @Column(name = "BUIN_TI_END_INTERAC")
    private Timestamp buinTiEndInterac;

    @Column(name = "BUIN_TI_START_INTERAC", nullable = false)
    private Timestamp buinTiStartInterac;

    @Column(columnDefinition = "DATE", name = "SCPR_DA_DESIRED", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date scprDaDesired;

    @Column(columnDefinition = "DATE", name = "SCPR_DA_ESTIMATED")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date scprDaEstimated;

    @Column(length = 250, name = "SCPR_DS_NO_VIABILITY_CAUSE")
    private String scprDsNoViabilityCause;

    @Column(length = 500, name = "SCPR_DS_OPERATIONAL_IMPACT")
    private String scprDsOperationalImpact;

    @Column(name = "SCPR_IN_VIABILITY")
    @Convert("BigDecimalBooleanConverter")
    private Boolean scprInViability;

    @Column(name = "SCPT_ID_CHANNEL_PROPOSAL_TYPE", precision = 1)
    private Long scptIdChannelProposalType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    // bi-directional many-to-one association to CecaaChanAdeqStateMov
    @OneToMany(mappedBy = "scprpSalesChannelProposal", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CecaaChanAdeqStateMov> cecaaChanAdeqStateMovs;

    // bi-directional many-to-one association to CecarChanAdequacyAttachment
    @OneToMany(mappedBy = "scprpSalesChannelProposal")
    private List<CecarChanAdequacyAttachment> cecarChanAdequacyAttachments;

    @JoinColumn(name = "BUIN_ID_SALES_CHANNEL_DEMAND", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScdepSalesChannelDemand scdepSalesChannelDemand;
    @OneToMany(mappedBy = "scprpSalesChannelProposal", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ScpraChannelProposalRole> scpraChannelProposalRoles;
    @JoinColumn(name = "BISP_ID_CHANNEL_PROPOSAL_SPEC")
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

    public String getBuinCoChannelProposal() {
        return this.buinCoChannelProposal;
    }

    public void setBuinCoChannelProposal(String buinCoChannelProposal) {
        this.buinCoChannelProposal = buinCoChannelProposal;
    }

    public String getBuinDsChannelProposal() {
        return this.buinDsChannelProposal;
    }

    public void setBuinDsChannelProposal(String buinDsChannelProposal) {
        this.buinDsChannelProposal = buinDsChannelProposal;
    }

    public BigDecimal getBuinIdSalesChannelProposal() {
        return this.buinIdSalesChannelProposal;
    }

    public void setBuinIdSalesChannelProposal(BigDecimal buinIdSalesChannelProposal) {
        this.buinIdSalesChannelProposal = buinIdSalesChannelProposal;
    }

    public Timestamp getBuinTiEndInterac() {
        if (this.buinTiEndInterac != null)
            return (Timestamp) this.buinTiEndInterac.clone();
        else
            return null;
    }

    public void setBuinTiEndInterac(Timestamp buinTiEndInterac) {
        if (buinTiEndInterac != null)
            this.buinTiEndInterac = (Timestamp) buinTiEndInterac.clone();
        else
            this.buinTiEndInterac = buinTiEndInterac;
    }

    public Timestamp getBuinTiStartInterac() {
        if (this.buinTiStartInterac != null)
            return (Timestamp) this.buinTiStartInterac.clone();
        else
            return null;
    }

    public void setBuinTiStartInterac(Timestamp buinTiStartInterac) {
        if (buinTiStartInterac != null)
            this.buinTiStartInterac = (Timestamp) buinTiStartInterac.clone();
        else
            this.buinTiStartInterac = buinTiStartInterac;
    }

    public Date getScprDaDesired() {
        if (this.scprDaDesired != null)
            return (Date) this.scprDaDesired.clone();
        else
            return null;
    }

    public void setScprDaDesired(Date scprDaDesired) {
        if (scprDaDesired != null)
            this.scprDaDesired = (Date) scprDaDesired.clone();
        else
            this.scprDaDesired = scprDaDesired;
    }

    public Date getScprDaEstimated() {
        if (this.scprDaEstimated != null)
            return (Date) this.scprDaEstimated.clone();
        else
            return null;
    }

    public void setScprDaEstimated(Date scprDaEstimated) {
        if (scprDaEstimated != null)
            this.scprDaEstimated = (Date) scprDaEstimated.clone();
        else
            this.scprDaEstimated = scprDaEstimated;
    }

    public String getScprDsNoViabilityCause() {
        return this.scprDsNoViabilityCause;
    }

    public void setScprDsNoViabilityCause(String scprDsNoViabilityCause) {
        this.scprDsNoViabilityCause = scprDsNoViabilityCause;
    }

    public String getScprDsOperationalImpact() {
        return this.scprDsOperationalImpact;
    }

    public void setScprDsOperationalImpact(String scprDsOperationalImpact) {
        this.scprDsOperationalImpact = scprDsOperationalImpact;
    }

    public Boolean getScprInViability() {
        return this.scprInViability;
    }

    public void setScprInViability(Boolean scprInViability) {
        this.scprInViability = scprInViability;
    }

    public Long getScptIdChannelProposalType() {
        return this.scptIdChannelProposalType;
    }

    public void setScptIdChannelProposalType(Long scptIdChannelProposalType) {
        this.scptIdChannelProposalType = scptIdChannelProposalType;
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

    public List<CecaaChanAdeqStateMov> getCecaaChanAdeqStateMovs() {
        return this.cecaaChanAdeqStateMovs;
    }

    public void setCecaaChanAdeqStateMovs(List<CecaaChanAdeqStateMov> cecaaChanAdeqStateMovs) {
        this.cecaaChanAdeqStateMovs = cecaaChanAdeqStateMovs;
    }

    public void addCecaaChanAdeqStateMovs(CecaaChanAdeqStateMov cecaaChanAdeqStateMov) {
        if (this.cecaaChanAdeqStateMovs == null)
            this.cecaaChanAdeqStateMovs = new ArrayList<CecaaChanAdeqStateMov>();
        this.cecaaChanAdeqStateMovs.add(cecaaChanAdeqStateMov);
    }

    public void removeCecaaChanAdeqStateMovs(CecaaChanAdeqStateMov cecaaChanAdeqStateMovToRemove) {
        if (cecaaChanAdeqStateMovToRemove != null)
            this.cecaaChanAdeqStateMovs.remove(cecaaChanAdeqStateMovToRemove);
    }

    public List<CecarChanAdequacyAttachment> getCecarChanAdequacyAttachments() {
        return this.cecarChanAdequacyAttachments;
    }

    public void setCecarChanAdequacyAttachments(List<CecarChanAdequacyAttachment> cecarChanAdequacyAttachments) {
        this.cecarChanAdequacyAttachments = cecarChanAdequacyAttachments;
    }

    public void addCecarChanAdequacyAttachments(CecarChanAdequacyAttachment cecarChanAdequacyAttachment) {
        if (this.cecarChanAdequacyAttachments == null)
            this.cecarChanAdequacyAttachments = new ArrayList<CecarChanAdequacyAttachment>();
        this.cecarChanAdequacyAttachments.add(cecarChanAdequacyAttachment);
    }

    public void removeCecarChanAdequacyAttachments(CecarChanAdequacyAttachment cecarChanAdequacyAttachmentToRemove) {
        if (cecarChanAdequacyAttachmentToRemove != null)
            this.cecarChanAdequacyAttachments.remove(cecarChanAdequacyAttachmentToRemove);
    }

    public ScdepSalesChannelDemand getScdepSalesChannelDemand() {
        return this.scdepSalesChannelDemand;
    }

    public void setScdepSalesChannelDemand(ScdepSalesChannelDemand scdepSalesChannelDemand) {
        this.scdepSalesChannelDemand = scdepSalesChannelDemand;
    }

    public List<ScpraChannelProposalRole> getScpraChannelProposalRoles() {
        return this.scpraChannelProposalRoles;
    }

    public void setScpraChannelProposalRoles(List<ScpraChannelProposalRole> scpraChannelProposalRoles) {
        this.scpraChannelProposalRoles = scpraChannelProposalRoles;
    }

    public void addScpraChannelProposalRoles(ScpraChannelProposalRole scpraChannelProposalRole) {
        if (this.scpraChannelProposalRoles == null)
            this.scpraChannelProposalRoles = new ArrayList<ScpraChannelProposalRole>();
        this.scpraChannelProposalRoles.add(scpraChannelProposalRole);
    }

    public void removeScpraChannelProposalRoles(ScpraChannelProposalRole scpraChannelProposalRoleToRemove) {
        if (scpraChannelProposalRoleToRemove != null)
            this.scpraChannelProposalRoles.remove(scpraChannelProposalRoleToRemove);
    }

    public ScprdChannelProposalSpec getScprdChannelProposalSpec() {
        return this.scprdChannelProposalSpec;
    }

    public void setScprdChannelProposalSpec(ScprdChannelProposalSpec scprdChannelProposalSpec) {
        this.scprdChannelProposalSpec = scprdChannelProposalSpec;
    }

}
