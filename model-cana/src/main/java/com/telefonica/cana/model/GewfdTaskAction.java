package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the GewfdTaskActionS database table.
 */
@Entity
@NamedQuery(name = "GewfdTaskAction.findAll", query = "SELECT g FROM GewfdTaskAction g")
@Table(name = "GEWFD_TASK_ACTION")
public class GewfdTaskAction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(length = 50, name = "TAAL_NA_TASK_ACTION", nullable = false)
    private String taalNaTaskAction;

    @Column(columnDefinition = "DATE", name = "TASA_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date tasaDaEndValidity;

    @Column(columnDefinition = "DATE", name = "TASA_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date tasaDaStartValidity;

    @Column(name = "TASA_ID_TASK_ACTION", nullable = false, precision = 2, unique = true)
    @Id
    private Long tasaIdTaskAction;

    @Column(name = "TASA_IN_MADATORY_MAILBOX", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean tasaInMadatoryMailbox;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "gewfdTaskAction")
    private List<GewfaWorkflowStep> gewfaWorkflowSteps;
    @OneToMany(mappedBy = "gewfdTaskAction")
    private List<GewfrTaskActionL> gewfrTaskActionLs;
    @OneToMany(mappedBy = "gewfdTaskAction")
    private List<GewfrValidActionStep> gewfrValidActionSteps;
    @OneToMany(mappedBy = "gewfdTaskAction")
    private List<GewfrValidActionTask> gewfrValidActionTasks;

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

    public String getTaalNaTaskAction() {
        return this.taalNaTaskAction;
    }

    public void setTaalNaTaskAction(String taalNaTaskAction) {
        this.taalNaTaskAction = taalNaTaskAction;
    }

    public Date getTasaDaEndValidity() {
        if (this.tasaDaEndValidity != null)
            return (Date) this.tasaDaEndValidity.clone();
        else
            return null;
    }

    public void setTasaDaEndValidity(Date tasaDaEndValidity) {
        if (tasaDaEndValidity != null)
            this.tasaDaEndValidity = (Date) tasaDaEndValidity.clone();
        else
            this.tasaDaEndValidity = tasaDaEndValidity;
    }

    public Date getTasaDaStartValidity() {
        if (this.tasaDaStartValidity != null)
            return (Date) this.tasaDaStartValidity.clone();
        else
            return null;
    }

    public void setTasaDaStartValidity(Date tasaDaStartValidity) {
        if (tasaDaStartValidity != null)
            this.tasaDaStartValidity = (Date) tasaDaStartValidity.clone();
        else
            this.tasaDaStartValidity = tasaDaStartValidity;
    }

    public Long getTasaIdTaskAction() {
        return this.tasaIdTaskAction;
    }

    public void setTasaIdTaskAction(Long tasaIdTaskAction) {
        this.tasaIdTaskAction = tasaIdTaskAction;
    }

    public Boolean getTasaInMadatoryMailbox() {
        return this.tasaInMadatoryMailbox;
    }

    public void setTasaInMadatoryMailbox(Boolean tasaInMadatoryMailbox) {
        this.tasaInMadatoryMailbox = tasaInMadatoryMailbox;
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

    public List<GewfrTaskActionL> getGewfrTaskActionLs() {
        return this.gewfrTaskActionLs;
    }

    public void setGewfrTaskActionLs(List<GewfrTaskActionL> gewfrTaskActionLs) {
        this.gewfrTaskActionLs = gewfrTaskActionLs;
    }

    public void addGewfrTaskActionLs(GewfrTaskActionL gewfrTaskActionL) {
        if (this.gewfrTaskActionLs == null)
            this.gewfrTaskActionLs = new ArrayList<GewfrTaskActionL>();
        this.gewfrTaskActionLs.add(gewfrTaskActionL);
    }

    public void removeGewfrTaskActionLs(GewfrTaskActionL gewfrTaskActionLToRemove) {
        if (gewfrTaskActionLToRemove != null)
            this.gewfrTaskActionLs.remove(gewfrTaskActionLToRemove);
    }

    public List<GewfrValidActionStep> getGewfrValidActionSteps() {
        return this.gewfrValidActionSteps;
    }

    public void setGewfrValidActionSteps(List<GewfrValidActionStep> gewfrValidActionSteps) {
        this.gewfrValidActionSteps = gewfrValidActionSteps;
    }

    public void addGewfrValidActionSteps(GewfrValidActionStep gewfrValidActionStep) {
        if (this.gewfrValidActionSteps == null)
            this.gewfrValidActionSteps = new ArrayList<GewfrValidActionStep>();
        this.gewfrValidActionSteps.add(gewfrValidActionStep);
    }

    public void removeGewfrValidActionSteps(GewfrValidActionStep gewfrValidActionStepToRemove) {
        if (gewfrValidActionStepToRemove != null)
            this.gewfrValidActionSteps.remove(gewfrValidActionStepToRemove);
    }

    public List<GewfrValidActionTask> getGewfrValidActionTasks() {
        return this.gewfrValidActionTasks;
    }

    public void setGewfrValidActionTasks(List<GewfrValidActionTask> gewfrValidActionTasks) {
        this.gewfrValidActionTasks = gewfrValidActionTasks;
    }

    public void addGewfrValidActionTasks(GewfrValidActionTask gewfrValidActionTask) {
        if (this.gewfrValidActionTasks == null)
            this.gewfrValidActionTasks = new ArrayList<GewfrValidActionTask>();
        this.gewfrValidActionTasks.add(gewfrValidActionTask);
    }

    public void removeGewfrValidActionTasks(GewfrValidActionTask gewfrValidActionTaskToRemove) {
        if (gewfrValidActionTaskToRemove != null)
            this.gewfrValidActionTasks.remove(gewfrValidActionTaskToRemove);
    }

}
