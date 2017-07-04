package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the ScpraChannelProposalRoleS database table.
 */
@Entity
@NamedQuery(name = "ScpraChannelProposalRole.findAll", query = "SELECT s FROM ScpraChannelProposalRole s")
@Table(name = "SCPRA_CHANNEL_PROPOSAL_ROLE", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BUIN_ID_CHANNEL_PROPOSAL", "FARE_ID_FUNCTIONAL_AREA" }) })
public class ScpraChannelProposalRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "BIRO_ID_CHANNEL_PROPOSAL_ROLE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal biroIdChannelProposalRole;

    @Column(columnDefinition = "DATE", name = "PROL_DA_PRELAUNCH_COMMITTED", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date prolDaPrelaunchCommitted;

    @Column(name = "PROL_IN_READY_CHECK", nullable = false, precision = 1)
    private Long prolInReadyCheck;

    @Column(name = "PROL_IN_VIABILITY", precision = 1)
    private Long prolInViability;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "FARE_ID_FUNCTIONAL_AREA", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScprdFunctionalArea scprdFunctionalArea;
    @JoinColumn(name = "BUIN_ID_CHANNEL_PROPOSAL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScprpSalesChannelProposal scprpSalesChannelProposal;
    @OneToMany(mappedBy = "scpraChannelProposalRole")
    private List<ScprrPlanificationWorkflow> scprrPlanificationWorkflows;

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

    public BigDecimal getBiroIdChannelProposalRole() {
        return this.biroIdChannelProposalRole;
    }

    public void setBiroIdChannelProposalRole(BigDecimal biroIdChannelProposalRole) {
        this.biroIdChannelProposalRole = biroIdChannelProposalRole;
    }

    public Date getProlDaPrelaunchCommitted() {
        if (this.prolDaPrelaunchCommitted != null)
            return (Date) this.prolDaPrelaunchCommitted.clone();
        else
            return null;
    }

    public void setProlDaPrelaunchCommitted(Date prolDaPrelaunchCommitted) {
        if (prolDaPrelaunchCommitted != null)
            this.prolDaPrelaunchCommitted = (Date) prolDaPrelaunchCommitted.clone();
        else
            this.prolDaPrelaunchCommitted = prolDaPrelaunchCommitted;
    }

    public Long getProlInReadyCheck() {
        return this.prolInReadyCheck;
    }

    public void setProlInReadyCheck(Long prolInReadyCheck) {
        this.prolInReadyCheck = prolInReadyCheck;
    }

    public Long getProlInViability() {
        return this.prolInViability;
    }

    public void setProlInViability(Long prolInViability) {
        this.prolInViability = prolInViability;
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

    public ScprdFunctionalArea getScprdFunctionalArea() {
        return this.scprdFunctionalArea;
    }

    public void setScprdFunctionalArea(ScprdFunctionalArea scprdFunctionalArea) {
        this.scprdFunctionalArea = scprdFunctionalArea;
    }

    public ScprpSalesChannelProposal getScprpSalesChannelProposal() {
        return this.scprpSalesChannelProposal;
    }

    public void setScprpSalesChannelProposal(ScprpSalesChannelProposal scprpSalesChannelProposal) {
        this.scprpSalesChannelProposal = scprpSalesChannelProposal;
    }

    public List<ScprrPlanificationWorkflow> getScprrPlanificationWorkflows() {
        return this.scprrPlanificationWorkflows;
    }

    public void setScprrPlanificationWorkflows(List<ScprrPlanificationWorkflow> scprrPlanificationWorkflows) {
        this.scprrPlanificationWorkflows = scprrPlanificationWorkflows;
    }

    public void addScprrPlanificationWorkflows(ScprrPlanificationWorkflow scprrPlanificationWorkflow) {
        if (this.scprrPlanificationWorkflows == null)
            this.scprrPlanificationWorkflows = new ArrayList<ScprrPlanificationWorkflow>();
        this.scprrPlanificationWorkflows.add(scprrPlanificationWorkflow);
    }

    public void removeScprrPlanificationWorkflows(ScprrPlanificationWorkflow scprrPlanificationWorkflowToRemove) {
        if (scprrPlanificationWorkflowToRemove != null)
            this.scprrPlanificationWorkflows.remove(scprrPlanificationWorkflowToRemove);
    }

}
