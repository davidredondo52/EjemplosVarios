package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import javax.persistence.UniqueConstraint;

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the GewfaWorkflowSpecStepS database table.
 */
@Entity
@NamedQuery(name = "GewfaWorkflowSpecStep.findAll", query = "SELECT g FROM GewfaWorkflowSpecStep g")
@Table(name = "GEWFA_WORKFLOW_SPEC_STEP", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "WSPE_ID_WORKFLOW_SPEC", "WSSP_NU_WORKFLOW_SPEC_STEP" }) })
public class GewfaWorkflowSpecStep implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "UMEA_ID_UNIT_MEASURE", nullable = false, precision = 2)
    private Long umeaIdUnitMeasure;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @Column(name = "WSSP_ID_WORKFLOW_SPEC_STEP", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal wsspIdWorkflowSpecStep;

    @Column(name = "WSSP_IN_FORCE_DOCUMENT", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean wsspInForceDocument;

    @Column(name = "WSSP_NU_WORKFLOW_SPEC_STEP", precision = 2)
    private Long wsspNuWorkflowSpecStep;

    @Column(name = "WSSP_QU_EXECUTION_MEDIUM_TIME", nullable = false, precision = 3, scale = 1)
    private BigDecimal wsspQuExecutionMediumTime;

    @Column(name = "WSSP_TI_END_VALIDITY")
    private Timestamp wsspTiEndValidity;

    @Column(name = "WSSP_TI_START_VALIDITY", nullable = false)
    private Timestamp wsspTiStartValidity;

    @OneToMany(mappedBy = "gewfaWorkflowSpecStep")
    private List<GewfaWorkflowStep> gewfaWorkflowSteps;
    @JoinColumn(name = "WTAS_ID_WORKFLOW_TASK", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfdWorkflowTask gewfdWorkflowTask;
    @JoinColumn(name = "WSPE_ID_WORKFLOW_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfpWorkflowSpec gewfpWorkflowSpec;
    @OneToMany(mappedBy = "gewfaWorkflowSpecStep", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<GewfrResolutorMailbox> gewfrResolutorMailboxs;
    @OneToMany(mappedBy = "gewfaWorkflowSpecStep1", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<GewfrValidActionStep> gewfrValidActionSteps1;
    @OneToMany(mappedBy = "gewfaWorkflowSpecStep2", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<GewfrValidActionStep> gewfrValidActionSteps2;

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

    public Long getUmeaIdUnitMeasure() {
        return this.umeaIdUnitMeasure;
    }

    public void setUmeaIdUnitMeasure(Long umeaIdUnitMeasure) {
        this.umeaIdUnitMeasure = umeaIdUnitMeasure;
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

    public BigDecimal getWsspIdWorkflowSpecStep() {
        return this.wsspIdWorkflowSpecStep;
    }

    public void setWsspIdWorkflowSpecStep(BigDecimal wsspIdWorkflowSpecStep) {
        this.wsspIdWorkflowSpecStep = wsspIdWorkflowSpecStep;
    }

    public Boolean getWsspInForceDocument() {
        return this.wsspInForceDocument;
    }

    public void setWsspInForceDocument(Boolean wsspInForceDocument) {
        this.wsspInForceDocument = wsspInForceDocument;
    }

    public Long getWsspNuWorkflowSpecStep() {
        return this.wsspNuWorkflowSpecStep;
    }

    public void setWsspNuWorkflowSpecStep(Long wsspNuWorkflowSpecStep) {
        this.wsspNuWorkflowSpecStep = wsspNuWorkflowSpecStep;
    }

    public BigDecimal getWsspQuExecutionMediumTime() {
        return this.wsspQuExecutionMediumTime;
    }

    public void setWsspQuExecutionMediumTime(BigDecimal wsspQuExecutionMediumTime) {
        this.wsspQuExecutionMediumTime = wsspQuExecutionMediumTime;
    }

    public Timestamp getWsspTiEndValidity() {
        if (this.wsspTiEndValidity != null)
            return (Timestamp) this.wsspTiEndValidity.clone();
        else
            return null;
    }

    public void setWsspTiEndValidity(Timestamp wsspTiEndValidity) {
        if (wsspTiEndValidity != null)
            this.wsspTiEndValidity = (Timestamp) wsspTiEndValidity.clone();
        else
            this.wsspTiEndValidity = wsspTiEndValidity;
    }

    public Timestamp getWsspTiStartValidity() {
        if (this.wsspTiStartValidity != null)
            return (Timestamp) this.wsspTiStartValidity.clone();
        else
            return null;
    }

    public void setWsspTiStartValidity(Timestamp wsspTiStartValidity) {
        if (wsspTiStartValidity != null)
            this.wsspTiStartValidity = (Timestamp) wsspTiStartValidity.clone();
        else
            this.wsspTiStartValidity = wsspTiStartValidity;
    }

    public List<GewfaWorkflowStep> getGewfaWorkflowSteps() {
        return this.gewfaWorkflowSteps;
    }

    public void setGewfaWorkflowSteps(List<GewfaWorkflowStep> gewfaWorkflowSteps) {
        this.gewfaWorkflowSteps = gewfaWorkflowSteps;
    }

    public void addGewfaWorkflowSteps(GewfaWorkflowStep gewfaWorkflowStep) {
        if (this.gewfaWorkflowSteps == null)
            this.gewfaWorkflowSteps = new ArrayList<GewfaWorkflowStep>();
        this.gewfaWorkflowSteps.add(gewfaWorkflowStep);
    }

    public void removeGewfaWorkflowSteps(GewfaWorkflowStep gewfaWorkflowStepToRemove) {
        if (gewfaWorkflowStepToRemove != null)
            this.gewfaWorkflowSteps.remove(gewfaWorkflowStepToRemove);
    }

    public GewfdWorkflowTask getGewfdWorkflowTask() {
        return this.gewfdWorkflowTask;
    }

    public void setGewfdWorkflowTask(GewfdWorkflowTask gewfdWorkflowTask) {
        this.gewfdWorkflowTask = gewfdWorkflowTask;
    }

    public GewfpWorkflowSpec getGewfpWorkflowSpec() {
        return this.gewfpWorkflowSpec;
    }

    public void setGewfpWorkflowSpec(GewfpWorkflowSpec gewfpWorkflowSpec) {
        this.gewfpWorkflowSpec = gewfpWorkflowSpec;
    }

    public List<GewfrResolutorMailbox> getGewfrResolutorMailboxs() {
        return this.gewfrResolutorMailboxs;
    }

    public void setGewfrResolutorMailboxs(List<GewfrResolutorMailbox> gewfrResolutorMailboxs) {
        this.gewfrResolutorMailboxs = gewfrResolutorMailboxs;
    }

    public void addGewfrResolutorMailboxs(GewfrResolutorMailbox gewfrResolutorMailbox) {
        if (this.gewfrResolutorMailboxs == null)
            this.gewfrResolutorMailboxs = new ArrayList<GewfrResolutorMailbox>();
        this.gewfrResolutorMailboxs.add(gewfrResolutorMailbox);
    }

    public void removeGewfrResolutorMailboxs(GewfrResolutorMailbox gewfrResolutorMailboxToRemove) {
        if (gewfrResolutorMailboxToRemove != null)
            this.gewfrResolutorMailboxs.remove(gewfrResolutorMailboxToRemove);
    }

    public List<GewfrValidActionStep> getGewfrValidActionSteps1() {
        return this.gewfrValidActionSteps1;
    }

    public void setGewfrValidActionSteps1(List<GewfrValidActionStep> gewfrValidActionSteps1) {
        this.gewfrValidActionSteps1 = gewfrValidActionSteps1;
    }

    public void addGewfrValidActionSteps1(GewfrValidActionStep gewfrValidActionStep) {
        if (this.gewfrValidActionSteps1 == null)
            this.gewfrValidActionSteps1 = new ArrayList<GewfrValidActionStep>();
        this.gewfrValidActionSteps1.add(gewfrValidActionStep);
    }

    public void removeGewfrValidActionSteps1(GewfrValidActionStep gewfrValidActionStepToRemove) {
        if (gewfrValidActionStepToRemove != null)
            this.gewfrValidActionSteps1.remove(gewfrValidActionStepToRemove);
    }

    public List<GewfrValidActionStep> getGewfrValidActionSteps2() {
        return this.gewfrValidActionSteps2;
    }

    public void setGewfrValidActionSteps2(List<GewfrValidActionStep> gewfrValidActionSteps2) {
        this.gewfrValidActionSteps2 = gewfrValidActionSteps2;
    }

    public void addGewfrValidActionSteps2(GewfrValidActionStep gewfrValidActionStep) {
        if (this.gewfrValidActionSteps2 == null)
            this.gewfrValidActionSteps2 = new ArrayList<GewfrValidActionStep>();
        this.gewfrValidActionSteps2.add(gewfrValidActionStep);
    }

    public void removeGewfrValidActionSteps2(GewfrValidActionStep gewfrValidActionStepToRemove) {
        if (gewfrValidActionStepToRemove != null)
            this.gewfrValidActionSteps2.remove(gewfrValidActionStepToRemove);
    }

}
