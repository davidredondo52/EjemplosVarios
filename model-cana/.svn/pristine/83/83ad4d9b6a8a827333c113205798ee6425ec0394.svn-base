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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the GewfrValidActionStepS database table.
 */
@Entity
@NamedQuery(name = "GewfrValidActionStep.findAll", query = "SELECT g FROM GewfrValidActionStep g")
@Table(name = "GEWFR_VALID_ACTION_STEP")
public class GewfrValidActionStep implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @Column(name = "VAST_ID_VALID_ACTION_STEP", nullable = false, precision = 6, unique = true)
    @GeneratedValue(generator = "GEWFR_VALID_ACTION_STEP_VASTIDVALIDACTIONSTEP_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "GEWFR_VALID_ACTION_STEP_VASTIDVALIDACTIONSTEP_GENERATOR", sequenceName = "GEWF_VALID_ACTION_IN_STEP_SEQ")
    private Long vastIdValidActionStep;

    @Column(name = "VAST_IN_ACTION_ROLE", nullable = false, precision = 1)
    private Long vastInActionRole;

    @JoinColumns({
            @JoinColumn(referencedColumnName = "WSPE_ID_WORKFLOW_SPEC", nullable = false, name = "WSPE_ID_WORKFLOW_SPEC"),
            @JoinColumn(referencedColumnName = "WSSP_NU_WORKFLOW_SPEC_STEP", nullable = false, name = "WSST_NU_WORKFLOW_SPEC_STEP") })
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfaWorkflowSpecStep gewfaWorkflowSpecStep1;
    @JoinColumns({
            @JoinColumn(referencedColumnName = "WSPE_ID_WORKFLOW_SPEC", nullable = false, name = "WSPE_ID_WORKFLOW_SPEC", updatable = false, insertable = false),
            @JoinColumn(referencedColumnName = "WSSP_NU_WORKFLOW_SPEC_STEP", name = "WSST_NU_WF_SPEC_STEP_NEXT") })
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfaWorkflowSpecStep gewfaWorkflowSpecStep2;
    @JoinColumn(name = "TASA_ID_TASK_ACTION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfdTaskAction gewfdTaskAction;

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

    public Long getVastIdValidActionStep() {
        return this.vastIdValidActionStep;
    }

    public void setVastIdValidActionStep(Long vastIdValidActionStep) {
        this.vastIdValidActionStep = vastIdValidActionStep;
    }

    public Long getVastInActionRole() {
        return this.vastInActionRole;
    }

    public void setVastInActionRole(Long vastInActionRole) {
        this.vastInActionRole = vastInActionRole;
    }

    public GewfaWorkflowSpecStep getGewfaWorkflowSpecStep1() {
        return this.gewfaWorkflowSpecStep1;
    }

    public void setGewfaWorkflowSpecStep1(GewfaWorkflowSpecStep gewfaWorkflowSpecStep1) {
        this.gewfaWorkflowSpecStep1 = gewfaWorkflowSpecStep1;
    }

    public GewfaWorkflowSpecStep getGewfaWorkflowSpecStep2() {
        return this.gewfaWorkflowSpecStep2;
    }

    public void setGewfaWorkflowSpecStep2(GewfaWorkflowSpecStep gewfaWorkflowSpecStep2) {
        this.gewfaWorkflowSpecStep2 = gewfaWorkflowSpecStep2;
    }

    public GewfdTaskAction getGewfdTaskAction() {
        return this.gewfdTaskAction;
    }

    public void setGewfdTaskAction(GewfdTaskAction gewfdTaskAction) {
        this.gewfdTaskAction = gewfdTaskAction;
    }

}
