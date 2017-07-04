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
 * The persistent class for the GewfrValidActionTaskS database table.
 */
@Entity
@NamedQuery(name = "GewfrValidActionTask.findAll", query = "SELECT g FROM GewfrValidActionTask g")
@Table(name = "GEWFR_VALID_ACTION_TASK", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "WTAS_ID_WORKFLOW_TASK", "TASA_ID_TASK_ACTION" }) })
public class GewfrValidActionTask implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "VATA_ID_VALID_ACTION_TASK", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal vataIdValidActionTask;

    @JoinColumn(name = "TASA_ID_TASK_ACTION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfdTaskAction gewfdTaskAction;
    @JoinColumn(name = "WTAS_ID_WORKFLOW_TASK", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfdWorkflowTask gewfdWorkflowTask;

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

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public BigDecimal getVataIdValidActionTask() {
        return this.vataIdValidActionTask;
    }

    public void setVataIdValidActionTask(BigDecimal vataIdValidActionTask) {
        this.vataIdValidActionTask = vataIdValidActionTask;
    }

    public GewfdTaskAction getGewfdTaskAction() {
        return this.gewfdTaskAction;
    }

    public void setGewfdTaskAction(GewfdTaskAction gewfdTaskAction) {
        this.gewfdTaskAction = gewfdTaskAction;
    }

    public GewfdWorkflowTask getGewfdWorkflowTask() {
        return this.gewfdWorkflowTask;
    }

    public void setGewfdWorkflowTask(GewfdWorkflowTask gewfdWorkflowTask) {
        this.gewfdWorkflowTask = gewfdWorkflowTask;
    }

}
