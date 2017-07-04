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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the CnalaTaskMailboxS database table.
 */
@Entity
@NamedQuery(name = "CnalaTaskMailbox.findAll", query = "SELECT c FROM CnalaTaskMailbox c")
@Table(name = "CNALA_TASK_MAILBOX", uniqueConstraints = { @UniqueConstraint(columnNames = { "WPOO_ID_FUNCTIONAL_POOL",
        "PARO_ID_ORGANIZATION_ROLE" }) })
public class CnalaTaskMailbox implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "GENA_ID_APPLICATION", precision = 4)
    private Long genaIdApplication;

    @Column(length = 75, name = "LBOX_NA_MAILBOX", nullable = false)
    private String lboxNaMailbox;

    @Column(length = 25, name = "MBOX_CO_FUNC_MAILBOX", nullable = false, unique = true)
    private String mboxCoFuncMailbox;

    @Column(name = "MBOX_ID_MAILBOX", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal mboxIdMailbox;

    @Column(name = "MBOX_IN_BROTHER_REALLOCATION", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean mboxInBrotherReallocation;

    @Column(name = "MBOX_IN_DISTRIBUTION_MODE", precision = 1)
    private Long mboxInDistributionMode;

    @Column(name = "MBOX_IN_GROUP_DISTRIB_CRITERIA", precision = 1)
    private Long mboxInGroupDistribCriteria;

    @Column(name = "MBOX_IN_MANUAL_DISTRIB_MODE", precision = 1)
    private Long mboxInManualDistribMode;

    @Column(name = "MBOX_IN_STATE", nullable = false, precision = 1)
    private Long mboxInState;

    @Column(name = "MBOX_QU_MAXIMUM_AMOUNT", precision = 5)
    private Long mboxQuMaximumAmount;

    @Column(name = "MBOX_QU_VOLUME", precision = 3)
    private Long mboxQuVolume;

    @Column(name = "MBOX_TI_END_VALIDITY")
    private Timestamp mboxTiEndValidity;

    @Column(name = "MBOX_TI_START_VALIDITY", nullable = false)
    private Timestamp mboxTiStartValidity;

    @Column(name = "RULE_ID_RULE", precision = 38)
    private BigDecimal ruleIdRule;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnalaTaskMailbox")
    private List<CnalaDistributionLog> cnalaDistributionLogs;
    @JoinColumn(name = "WPOO_ID_FUNCTIONAL_POOL")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpFunctionalPool cnalpFunctionalPool;
    @JoinColumn(name = "OPAS_ID_ORGA_POOL_ASSIGNMENT")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment1;
    @JoinColumns({
            @JoinColumn(referencedColumnName = "PARO_ID_ORGANIZATION_ROLE", name = "PARO_ID_ORGANIZATION_ROLE"),
            @JoinColumn(referencedColumnName = "WPOO_ID_FUNCTIONAL_POOL", name = "WPOO_ID_FUNCTIONAL_POOL", updatable = false, insertable = false) })
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2;
    @OneToMany(mappedBy = "cnalaTaskMailbox", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrTaskMailboxL> cnalrTaskMailboxLs;
    @JoinColumn(name = "DISC_ID_DISTRIBUTION_CRITERIA")
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfdDistributionCriteria gewfdDistributionCriteria;
    @OneToMany(mappedBy = "cnalaTaskMailbox")
    private List<GewfrMailboxAccess> gewfrMailboxAccesses;
    @OneToMany(mappedBy = "cnalaTaskMailbox")
    private List<GewfrResolutorMailbox> gewfrResolutorMailboxs;
    @OneToMany(mappedBy = "cnalaTaskMailbox")
    private List<PrderUserTaskSpecMailbox> prderUserTaskSpecMailboxs;
    @OneToMany(mappedBy = "cnalaTaskMailbox1")
    private List<ProcaUserTaskMovement> procaUserTaskMovements1;
    @OneToMany(mappedBy = "cnalaTaskMailbox2")
    private List<ProcaUserTaskMovement> procaUserTaskMovements2;
    @JoinColumn(name = "FARE_ID_FUNCTIONAL_AREA")
    @ManyToOne(fetch = FetchType.LAZY)
    private ScprdFunctionalArea scprdFunctionalArea;
    @OneToMany(mappedBy = "cnalaTaskMailbox")
    private List<ScprrDefaultSubarea> scprrDefaultSubareas;
    @OneToMany(mappedBy = "cnalaTaskMailbox")
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

    public Long getGenaIdApplication() {
        return this.genaIdApplication;
    }

    public void setGenaIdApplication(Long genaIdApplication) {
        this.genaIdApplication = genaIdApplication;
    }

    public String getLboxNaMailbox() {
        return this.lboxNaMailbox;
    }

    public void setLboxNaMailbox(String lboxNaMailbox) {
        this.lboxNaMailbox = lboxNaMailbox;
    }

    public String getMboxCoFuncMailbox() {
        return this.mboxCoFuncMailbox;
    }

    public void setMboxCoFuncMailbox(String mboxCoFuncMailbox) {
        this.mboxCoFuncMailbox = mboxCoFuncMailbox;
    }

    public BigDecimal getMboxIdMailbox() {
        return this.mboxIdMailbox;
    }

    public void setMboxIdMailbox(BigDecimal mboxIdMailbox) {
        this.mboxIdMailbox = mboxIdMailbox;
    }

    public Boolean getMboxInBrotherReallocation() {
        return this.mboxInBrotherReallocation;
    }

    public void setMboxInBrotherReallocation(Boolean mboxInBrotherReallocation) {
        this.mboxInBrotherReallocation = mboxInBrotherReallocation;
    }

    public Long getMboxInDistributionMode() {
        return this.mboxInDistributionMode;
    }

    public void setMboxInDistributionMode(Long mboxInDistributionMode) {
        this.mboxInDistributionMode = mboxInDistributionMode;
    }

    public Long getMboxInGroupDistribCriteria() {
        return this.mboxInGroupDistribCriteria;
    }

    public void setMboxInGroupDistribCriteria(Long mboxInGroupDistribCriteria) {
        this.mboxInGroupDistribCriteria = mboxInGroupDistribCriteria;
    }

    public Long getMboxInManualDistribMode() {
        return this.mboxInManualDistribMode;
    }

    public void setMboxInManualDistribMode(Long mboxInManualDistribMode) {
        this.mboxInManualDistribMode = mboxInManualDistribMode;
    }

    public Long getMboxInState() {
        return this.mboxInState;
    }

    public void setMboxInState(Long mboxInState) {
        this.mboxInState = mboxInState;
    }

    public Long getMboxQuMaximumAmount() {
        return this.mboxQuMaximumAmount;
    }

    public void setMboxQuMaximumAmount(Long mboxQuMaximumAmount) {
        this.mboxQuMaximumAmount = mboxQuMaximumAmount;
    }

    public Long getMboxQuVolume() {
        return this.mboxQuVolume;
    }

    public void setMboxQuVolume(Long mboxQuVolume) {
        this.mboxQuVolume = mboxQuVolume;
    }

    public Timestamp getMboxTiEndValidity() {
        if (this.mboxTiEndValidity != null)
            return (Timestamp) this.mboxTiEndValidity.clone();
        else
            return null;
    }

    public void setMboxTiEndValidity(Timestamp mboxTiEndValidity) {
        if (mboxTiEndValidity != null)
            this.mboxTiEndValidity = (Timestamp) mboxTiEndValidity.clone();
        else
            this.mboxTiEndValidity = mboxTiEndValidity;
    }

    public Timestamp getMboxTiStartValidity() {
        if (this.mboxTiStartValidity != null)
            return (Timestamp) this.mboxTiStartValidity.clone();
        else
            return null;
    }

    public void setMboxTiStartValidity(Timestamp mboxTiStartValidity) {
        if (mboxTiStartValidity != null)
            this.mboxTiStartValidity = (Timestamp) mboxTiStartValidity.clone();
        else
            this.mboxTiStartValidity = mboxTiStartValidity;
    }

    public BigDecimal getRuleIdRule() {
        return this.ruleIdRule;
    }

    public void setRuleIdRule(BigDecimal ruleIdRule) {
        this.ruleIdRule = ruleIdRule;
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

    public List<CnalaDistributionLog> getCnalaDistributionLogs() {
        return this.cnalaDistributionLogs;
    }

    public void setCnalaDistributionLogs(List<CnalaDistributionLog> cnalaDistributionLogs) {
        this.cnalaDistributionLogs = cnalaDistributionLogs;
    }

    public void addCnalaDistributionLogs(CnalaDistributionLog cnalaDistributionLog) {
        if (this.cnalaDistributionLogs == null)
            this.cnalaDistributionLogs = new ArrayList<CnalaDistributionLog>();
        this.cnalaDistributionLogs.add(cnalaDistributionLog);
    }

    public void removeCnalaDistributionLogs(CnalaDistributionLog cnalaDistributionLogToRemove) {
        if (cnalaDistributionLogToRemove != null)
            this.cnalaDistributionLogs.remove(cnalaDistributionLogToRemove);
    }

    public CnalpFunctionalPool getCnalpFunctionalPool() {
        return this.cnalpFunctionalPool;
    }

    public void setCnalpFunctionalPool(CnalpFunctionalPool cnalpFunctionalPool) {
        this.cnalpFunctionalPool = cnalpFunctionalPool;
    }

    public CnalrOrgaPoolAssignment getCnalrOrgaPoolAssignment1() {
        return this.cnalrOrgaPoolAssignment1;
    }

    public void setCnalrOrgaPoolAssignment1(CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment1) {
        this.cnalrOrgaPoolAssignment1 = cnalrOrgaPoolAssignment1;
    }

    public CnalrOrgaPoolAssignment getCnalrOrgaPoolAssignment2() {
        return this.cnalrOrgaPoolAssignment2;
    }

    public void setCnalrOrgaPoolAssignment2(CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2) {
        this.cnalrOrgaPoolAssignment2 = cnalrOrgaPoolAssignment2;
    }

    public List<CnalrTaskMailboxL> getCnalrTaskMailboxLs() {
        return this.cnalrTaskMailboxLs;
    }

    public void setCnalrTaskMailboxLs(List<CnalrTaskMailboxL> cnalrTaskMailboxLs) {
        this.cnalrTaskMailboxLs = cnalrTaskMailboxLs;
    }

    public void addCnalrTaskMailboxLs(CnalrTaskMailboxL cnalrTaskMailboxL) {
        if (this.cnalrTaskMailboxLs == null)
            this.cnalrTaskMailboxLs = new ArrayList<CnalrTaskMailboxL>();
        this.cnalrTaskMailboxLs.add(cnalrTaskMailboxL);
    }

    public void removeCnalrTaskMailboxLs(CnalrTaskMailboxL cnalrTaskMailboxLToRemove) {
        if (cnalrTaskMailboxLToRemove != null)
            this.cnalrTaskMailboxLs.remove(cnalrTaskMailboxLToRemove);
    }

    public GewfdDistributionCriteria getGewfdDistributionCriteria() {
        return this.gewfdDistributionCriteria;
    }

    public void setGewfdDistributionCriteria(GewfdDistributionCriteria gewfdDistributionCriteria) {
        this.gewfdDistributionCriteria = gewfdDistributionCriteria;
    }

    public List<GewfrMailboxAccess> getGewfrMailboxAccesses() {
        return this.gewfrMailboxAccesses;
    }

    public void setGewfrMailboxAccesses(List<GewfrMailboxAccess> gewfrMailboxAccesses) {
        this.gewfrMailboxAccesses = gewfrMailboxAccesses;
    }

    public void addGewfrMailboxAccesses(GewfrMailboxAccess gewfrMailboxAccess) {
        if (this.gewfrMailboxAccesses == null)
            this.gewfrMailboxAccesses = new ArrayList<GewfrMailboxAccess>();
        this.gewfrMailboxAccesses.add(gewfrMailboxAccess);
    }

    public void removeGewfrMailboxAccesses(GewfrMailboxAccess gewfrMailboxAccessToRemove) {
        if (gewfrMailboxAccessToRemove != null)
            this.gewfrMailboxAccesses.remove(gewfrMailboxAccessToRemove);
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

    public List<PrderUserTaskSpecMailbox> getPrderUserTaskSpecMailboxs() {
        return this.prderUserTaskSpecMailboxs;
    }

    public void setPrderUserTaskSpecMailboxs(List<PrderUserTaskSpecMailbox> prderUserTaskSpecMailboxs) {
        this.prderUserTaskSpecMailboxs = prderUserTaskSpecMailboxs;
    }

    public void addPrderUserTaskSpecMailboxs(PrderUserTaskSpecMailbox prderUserTaskSpecMailbox) {
        if (this.prderUserTaskSpecMailboxs == null)
            this.prderUserTaskSpecMailboxs = new ArrayList<PrderUserTaskSpecMailbox>();
        this.prderUserTaskSpecMailboxs.add(prderUserTaskSpecMailbox);
    }

    public void removePrderUserTaskSpecMailboxs(PrderUserTaskSpecMailbox prderUserTaskSpecMailboxToRemove) {
        if (prderUserTaskSpecMailboxToRemove != null)
            this.prderUserTaskSpecMailboxs.remove(prderUserTaskSpecMailboxToRemove);
    }

    public List<ProcaUserTaskMovement> getProcaUserTaskMovements1() {
        return this.procaUserTaskMovements1;
    }

    public void setProcaUserTaskMovements1(List<ProcaUserTaskMovement> procaUserTaskMovements1) {
        this.procaUserTaskMovements1 = procaUserTaskMovements1;
    }

    public void addProcaUserTaskMovements1(ProcaUserTaskMovement procaUserTaskMovement) {
        if (this.procaUserTaskMovements1 == null)
            this.procaUserTaskMovements1 = new ArrayList<ProcaUserTaskMovement>();
        this.procaUserTaskMovements1.add(procaUserTaskMovement);
    }

    public void removeProcaUserTaskMovements1(ProcaUserTaskMovement procaUserTaskMovementToRemove) {
        if (procaUserTaskMovementToRemove != null)
            this.procaUserTaskMovements1.remove(procaUserTaskMovementToRemove);
    }

    public List<ProcaUserTaskMovement> getProcaUserTaskMovements2() {
        return this.procaUserTaskMovements2;
    }

    public void setProcaUserTaskMovements2(List<ProcaUserTaskMovement> procaUserTaskMovements2) {
        this.procaUserTaskMovements2 = procaUserTaskMovements2;
    }

    public void addProcaUserTaskMovements2(ProcaUserTaskMovement procaUserTaskMovement) {
        if (this.procaUserTaskMovements2 == null)
            this.procaUserTaskMovements2 = new ArrayList<ProcaUserTaskMovement>();
        this.procaUserTaskMovements2.add(procaUserTaskMovement);
    }

    public void removeProcaUserTaskMovements2(ProcaUserTaskMovement procaUserTaskMovementToRemove) {
        if (procaUserTaskMovementToRemove != null)
            this.procaUserTaskMovements2.remove(procaUserTaskMovementToRemove);
    }

    public ScprdFunctionalArea getScprdFunctionalArea() {
        return this.scprdFunctionalArea;
    }

    public void setScprdFunctionalArea(ScprdFunctionalArea scprdFunctionalArea) {
        this.scprdFunctionalArea = scprdFunctionalArea;
    }

    public List<ScprrDefaultSubarea> getScprrDefaultSubareas() {
        return this.scprrDefaultSubareas;
    }

    public void setScprrDefaultSubareas(List<ScprrDefaultSubarea> scprrDefaultSubareas) {
        this.scprrDefaultSubareas = scprrDefaultSubareas;
    }

    public void addScprrDefaultSubareas(ScprrDefaultSubarea scprrDefaultSubarea) {
        if (this.scprrDefaultSubareas == null)
            this.scprrDefaultSubareas = new ArrayList<ScprrDefaultSubarea>();
        this.scprrDefaultSubareas.add(scprrDefaultSubarea);
    }

    public void removeScprrDefaultSubareas(ScprrDefaultSubarea scprrDefaultSubareaToRemove) {
        if (scprrDefaultSubareaToRemove != null)
            this.scprrDefaultSubareas.remove(scprrDefaultSubareaToRemove);
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
