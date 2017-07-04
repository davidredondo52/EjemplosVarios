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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the GewfaWorkflowStepS database table.
 */
@Entity
@NamedQuery(name = "GewfaWorkflowStep.findAll", query = "SELECT g FROM GewfaWorkflowStep g")
@Table(name = "GEWFA_WORKFLOW_STEP", uniqueConstraints = { @UniqueConstraint(columnNames = { "WFLO_ID_WORKFLOW",
        "WSTE_NU_ORDER_STEP" }) })
public class GewfaWorkflowStep implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "PARO_ID_CREATOR_ORG_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdCreatorOrgRole;

    @Column(name = "PARO_ID_EMISSOR_ORG_ROLE", precision = 38)
    private BigDecimal paroIdEmissorOrgRole;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @Column(name = "WSTE_DA_COMMITTED")
    private Timestamp wsteDaCommitted;

    @Column(name = "WSTE_ID_WORKFLOW_STEP", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal wsteIdWorkflowStep;

    @Column(name = "WSTE_NU_ORDER_STEP", nullable = false, precision = 3)
    private Long wsteNuOrderStep;

    @Column(name = "WSTE_TI_OBJETIVE", nullable = false)
    private Timestamp wsteTiObjetive;

    @JoinColumns({
            @JoinColumn(referencedColumnName = "WSPE_ID_WORKFLOW_SPEC", nullable = false, name = "WSPE_ID_WORKFLOW_SPEC"),
            @JoinColumn(referencedColumnName = "WSSP_NU_WORKFLOW_SPEC_STEP", nullable = false, name = "WSST_NU_WORKFLOW_SPEC_STEP") })
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfaWorkflowSpecStep gewfaWorkflowSpecStep;
    @JoinColumn(name = "TASA_ID_TASK_ACTION")
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfdTaskAction gewfdTaskAction;
    @JoinColumn(name = "WFLO_ID_WORKFLOW", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfpWorkflow gewfpWorkflow;
    @JoinColumns({
            @JoinColumn(referencedColumnName = "MBOX_ID_MAILBOX", name = "MBOX_ID_MAILBOX"),
            @JoinColumn(referencedColumnName = "WSPE_ID_WORKFLOW_SPEC", nullable = false, name = "WSPE_ID_WORKFLOW_SPEC", updatable = false, insertable = false),
            @JoinColumn(referencedColumnName = "WSST_NU_WORKFLOW_SPEC_STEP", nullable = false, name = "WSST_NU_WORKFLOW_SPEC_STEP", updatable = false, insertable = false) })
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfrResolutorMailbox gewfrResolutorMailbox;

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

    public BigDecimal getParoIdCreatorOrgRole() {
        return this.paroIdCreatorOrgRole;
    }

    public void setParoIdCreatorOrgRole(BigDecimal paroIdCreatorOrgRole) {
        this.paroIdCreatorOrgRole = paroIdCreatorOrgRole;
    }

    public BigDecimal getParoIdEmissorOrgRole() {
        return this.paroIdEmissorOrgRole;
    }

    public void setParoIdEmissorOrgRole(BigDecimal paroIdEmissorOrgRole) {
        this.paroIdEmissorOrgRole = paroIdEmissorOrgRole;
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

    public Timestamp getWsteDaCommitted() {
        if (this.wsteDaCommitted != null)
            return (Timestamp) this.wsteDaCommitted.clone();
        else
            return null;
    }

    public void setWsteDaCommitted(Timestamp wsteDaCommitted) {
        if (wsteDaCommitted != null)
            this.wsteDaCommitted = (Timestamp) wsteDaCommitted.clone();
        else
            this.wsteDaCommitted = wsteDaCommitted;
    }

    public BigDecimal getWsteIdWorkflowStep() {
        return this.wsteIdWorkflowStep;
    }

    public void setWsteIdWorkflowStep(BigDecimal wsteIdWorkflowStep) {
        this.wsteIdWorkflowStep = wsteIdWorkflowStep;
    }

    public Long getWsteNuOrderStep() {
        return this.wsteNuOrderStep;
    }

    public void setWsteNuOrderStep(Long wsteNuOrderStep) {
        this.wsteNuOrderStep = wsteNuOrderStep;
    }

    public Timestamp getWsteTiObjetive() {
        if (this.wsteTiObjetive != null)
            return (Timestamp) this.wsteTiObjetive.clone();
        else
            return null;
    }

    public void setWsteTiObjetive(Timestamp wsteTiObjetive) {
        if (wsteTiObjetive != null)
            this.wsteTiObjetive = (Timestamp) wsteTiObjetive.clone();
        else
            this.wsteTiObjetive = wsteTiObjetive;
    }

    public GewfaWorkflowSpecStep getGewfaWorkflowSpecStep() {
        return this.gewfaWorkflowSpecStep;
    }

    public void setGewfaWorkflowSpecStep(GewfaWorkflowSpecStep gewfaWorkflowSpecStep) {
        this.gewfaWorkflowSpecStep = gewfaWorkflowSpecStep;
    }

    public GewfdTaskAction getGewfdTaskAction() {
        return this.gewfdTaskAction;
    }

    public void setGewfdTaskAction(GewfdTaskAction gewfdTaskAction) {
        this.gewfdTaskAction = gewfdTaskAction;
    }

    public GewfpWorkflow getGewfpWorkflow() {
        return this.gewfpWorkflow;
    }

    public void setGewfpWorkflow(GewfpWorkflow gewfpWorkflow) {
        this.gewfpWorkflow = gewfpWorkflow;
    }

    public GewfrResolutorMailbox getGewfrResolutorMailbox() {
        return this.gewfrResolutorMailbox;
    }

    public void setGewfrResolutorMailbox(GewfrResolutorMailbox gewfrResolutorMailbox) {
        this.gewfrResolutorMailbox = gewfrResolutorMailbox;
    }

}
