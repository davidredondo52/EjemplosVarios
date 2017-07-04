package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.UniqueConstraint;

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the ScprrPlanificationWorkflowS database table.
 */
@Entity
@NamedQuery(name = "ScprrPlanificationWorkflow.findAll", query = "SELECT s FROM ScprrPlanificationWorkflow s")
@Table(name = "SCPRR_PLANIFICATION_WORKFLOW", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BIRO_ID_CHANNEL_PROPOSAL_ROLE", "MBOX_ID_MAILBOX" }) })
public class ScprrPlanificationWorkflow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "PLAN_ID_PLANIFICATION_WORKFLOW", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal planIdPlanificationWorkflow;

    @Column(name = "PLAN_IN_PROPOSAL_READY")
    @Convert("BigDecimalBooleanConverter")
    private Boolean planInProposalReady;

    @Column(name = "PLAN_IN_VIABILITY", precision = 1)
    private Long planInViability;

    @Column(length = 500, name = "PLAN_OB_VIABILITY_COMMENT")
    private String planObViabilityComment;

    @Column(name = "PLAN_QU_COST", precision = 10, scale = 2)
    private BigDecimal planQuCost;

    @Column(name = "PLAN_QU_DURATION", precision = 5, scale = 2)
    private BigDecimal planQuDuration;

    @Column(name = "PLAN_TI_END")
    private Timestamp planTiEnd;

    @Column(name = "PLAN_TI_PROPOSAL_READY")
    private Timestamp planTiProposalReady;

    @Column(name = "PLAN_TI_START")
    private Timestamp planTiStart;

    @Column(name = "PLAN_TI_VIABILITY")
    private Timestamp planTiViability;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "MBOX_ID_MAILBOX", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaTaskMailbox cnalaTaskMailbox;
    @JoinColumn(name = "BIRO_ID_CHANNEL_PROPOSAL_ROLE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScpraChannelProposalRole scpraChannelProposalRole;
    @OneToMany(mappedBy = "scprrPlanificationWorkflow")
    private List<ScprrWorkAttachment> scprrWorkAttachments;

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

    public BigDecimal getPlanIdPlanificationWorkflow() {
        return this.planIdPlanificationWorkflow;
    }

    public void setPlanIdPlanificationWorkflow(BigDecimal planIdPlanificationWorkflow) {
        this.planIdPlanificationWorkflow = planIdPlanificationWorkflow;
    }

    public Boolean getPlanInProposalReady() {
        return this.planInProposalReady;
    }

    public void setPlanInProposalReady(Boolean planInProposalReady) {
        this.planInProposalReady = planInProposalReady;
    }

    public Long getPlanInViability() {
        return this.planInViability;
    }

    public void setPlanInViability(Long planInViability) {
        this.planInViability = planInViability;
    }

    public String getPlanObViabilityComment() {
        return this.planObViabilityComment;
    }

    public void setPlanObViabilityComment(String planObViabilityComment) {
        this.planObViabilityComment = planObViabilityComment;
    }

    public BigDecimal getPlanQuCost() {
        return this.planQuCost;
    }

    public void setPlanQuCost(BigDecimal planQuCost) {
        this.planQuCost = planQuCost;
    }

    public BigDecimal getPlanQuDuration() {
        return this.planQuDuration;
    }

    public void setPlanQuDuration(BigDecimal planQuDuration) {
        this.planQuDuration = planQuDuration;
    }

    public Timestamp getPlanTiEnd() {
        if (this.planTiEnd != null)
            return (Timestamp) this.planTiEnd.clone();
        else
            return null;
    }

    public void setPlanTiEnd(Timestamp planTiEnd) {
        if (planTiEnd != null)
            this.planTiEnd = (Timestamp) planTiEnd.clone();
        else
            this.planTiEnd = planTiEnd;
    }

    public Timestamp getPlanTiProposalReady() {
        if (this.planTiProposalReady != null)
            return (Timestamp) this.planTiProposalReady.clone();
        else
            return null;
    }

    public void setPlanTiProposalReady(Timestamp planTiProposalReady) {
        if (planTiProposalReady != null)
            this.planTiProposalReady = (Timestamp) planTiProposalReady.clone();
        else
            this.planTiProposalReady = planTiProposalReady;
    }

    public Timestamp getPlanTiStart() {
        if (this.planTiStart != null)
            return (Timestamp) this.planTiStart.clone();
        else
            return null;
    }

    public void setPlanTiStart(Timestamp planTiStart) {
        if (planTiStart != null)
            this.planTiStart = (Timestamp) planTiStart.clone();
        else
            this.planTiStart = planTiStart;
    }

    public Timestamp getPlanTiViability() {
        if (this.planTiViability != null)
            return (Timestamp) this.planTiViability.clone();
        else
            return null;
    }

    public void setPlanTiViability(Timestamp planTiViability) {
        if (planTiViability != null)
            this.planTiViability = (Timestamp) planTiViability.clone();
        else
            this.planTiViability = planTiViability;
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

    public CnalaTaskMailbox getCnalaTaskMailbox() {
        return this.cnalaTaskMailbox;
    }

    public void setCnalaTaskMailbox(CnalaTaskMailbox cnalaTaskMailbox) {
        this.cnalaTaskMailbox = cnalaTaskMailbox;
    }

    public ScpraChannelProposalRole getScpraChannelProposalRole() {
        return this.scpraChannelProposalRole;
    }

    public void setScpraChannelProposalRole(ScpraChannelProposalRole scpraChannelProposalRole) {
        this.scpraChannelProposalRole = scpraChannelProposalRole;
    }

    public List<ScprrWorkAttachment> getScprrWorkAttachments() {
        return this.scprrWorkAttachments;
    }

    public void setScprrWorkAttachments(List<ScprrWorkAttachment> scprrWorkAttachments) {
        this.scprrWorkAttachments = scprrWorkAttachments;
    }

    public void addScprrWorkAttachments(ScprrWorkAttachment scprrWorkAttachment) {
        if (this.scprrWorkAttachments == null)
            this.scprrWorkAttachments = new ArrayList<ScprrWorkAttachment>();
        this.scprrWorkAttachments.add(scprrWorkAttachment);
    }

    public void removeScprrWorkAttachments(ScprrWorkAttachment scprrWorkAttachmentToRemove) {
        if (scprrWorkAttachmentToRemove != null)
            this.scprrWorkAttachments.remove(scprrWorkAttachmentToRemove);
    }

}
