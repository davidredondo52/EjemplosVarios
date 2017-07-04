package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * The persistent class for the PrdeaUtSpecAlarmS database table.
 */
@Entity
@NamedQuery(name = "PrdeaUtSpecAlarm.findAll", query = "SELECT p FROM PrdeaUtSpecAlarm p")
@Table(name = "PRDEA_UT_SPEC_ALARM")
public class PrdeaUtSpecAlarm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "BSES_ID_USER_TASK_SPEC", nullable = false, precision = 6, unique = true)
    @Id
    private Long bsesIdUserTaskSpec;

    @Column(name = "UMEA_ID_UNIT_MEASURE", precision = 2)
    private Long umeaIdUnitMeasure;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @Column(length = 100, name = "UTSA_DS_ALARM", nullable = false)
    private String utsaDsAlarm;

    @Column(name = "UTSA_IN_CONDITION", nullable = false, precision = 1)
    private Long utsaInCondition;

    @Column(length = 100, name = "UTSA_QU_FIELD_VALUE", nullable = false)
    private String utsaQuFieldValue;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "BSES_ID_USER_TASK_SPEC")
    private PrdedUserTaskSpec prdedUserTaskSpec;
    @JoinColumn(name = "WOFI_ID_WORKSPACE_FIELD", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private PrdedWorkspaceField prdedWorkspaceField;

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

    public Long getBsesIdUserTaskSpec() {
        return this.bsesIdUserTaskSpec;
    }

    public void setBsesIdUserTaskSpec(Long bsesIdUserTaskSpec) {
        this.bsesIdUserTaskSpec = bsesIdUserTaskSpec;
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

    public String getUtsaDsAlarm() {
        return this.utsaDsAlarm;
    }

    public void setUtsaDsAlarm(String utsaDsAlarm) {
        this.utsaDsAlarm = utsaDsAlarm;
    }

    public Long getUtsaInCondition() {
        return this.utsaInCondition;
    }

    public void setUtsaInCondition(Long utsaInCondition) {
        this.utsaInCondition = utsaInCondition;
    }

    public String getUtsaQuFieldValue() {
        return this.utsaQuFieldValue;
    }

    public void setUtsaQuFieldValue(String utsaQuFieldValue) {
        this.utsaQuFieldValue = utsaQuFieldValue;
    }

    public PrdedUserTaskSpec getPrdedUserTaskSpec() {
        return this.prdedUserTaskSpec;
    }

    public void setPrdedUserTaskSpec(PrdedUserTaskSpec prdedUserTaskSpec) {
        this.prdedUserTaskSpec = prdedUserTaskSpec;
    }

    public PrdedWorkspaceField getPrdedWorkspaceField() {
        return this.prdedWorkspaceField;
    }

    public void setPrdedWorkspaceField(PrdedWorkspaceField prdedWorkspaceField) {
        this.prdedWorkspaceField = prdedWorkspaceField;
    }

}
