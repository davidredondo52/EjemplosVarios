package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CnalfTaskMailboxS database table.
 */
@Entity
@NamedQuery(name = "CnalfTaskMailbox.findAll", query = "SELECT c FROM CnalfTaskMailbox c")
@Table(name = "CNALF_TASK_MAILBOX")
public class CnalfTaskMailbox implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "DISC_ID_DISTRIBUTION_CRITERIA", precision = 1)
    private Long discIdDistributionCriteria;

    @Column(name = "FARE_ID_FUNCTIONAL_AREA", precision = 4)
    private Long fareIdFunctionalArea;

    @Column(name = "GENA_ID_APPLICATION", precision = 4)
    private Long genaIdApplication;

    @Column(length = 75, name = "LBOX_NA_MAILBOX", nullable = false)
    private String lboxNaMailbox;

    @Column(length = 1, name = "MBOF_IN_STATEMENT", nullable = false)
    private String mbofInStatement;

    @Column(length = 25, name = "MBOX_CO_FUNC_MAILBOX", nullable = false)
    private String mboxCoFuncMailbox;

    @Column(name = "MBOX_IN_BROTHER_REALLOCATION", nullable = false, precision = 1)
    private Long mboxInBrotherReallocation;

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

    @Column(name = "OPAS_ID_ORGA_POOL_ASSIGNMENT", precision = 38)
    private BigDecimal opasIdOrgaPoolAssignment;

    @Column(name = "PARO_ID_ORGANIZATION_ROLE", precision = 38)
    private BigDecimal paroIdOrganizationRole;

    @Column(name = "RULE_ID_RULE", precision = 38)
    private BigDecimal ruleIdRule;

    @Column(name = "USER_ID_USER_UPDATER", precision = 38)
    private BigDecimal userIdUserUpdater;

    @Column(name = "WPOO_ID_FUNCTIONAL_POOL", precision = 38)
    private BigDecimal wpooIdFunctionalPool;

    @EmbeddedId
    private CnalfTaskMailboxPK id;

    public Long getDiscIdDistributionCriteria() {
        return this.discIdDistributionCriteria;
    }

    public void setDiscIdDistributionCriteria(Long discIdDistributionCriteria) {
        this.discIdDistributionCriteria = discIdDistributionCriteria;
    }

    public Long getFareIdFunctionalArea() {
        return this.fareIdFunctionalArea;
    }

    public void setFareIdFunctionalArea(Long fareIdFunctionalArea) {
        this.fareIdFunctionalArea = fareIdFunctionalArea;
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

    public String getMbofInStatement() {
        return this.mbofInStatement;
    }

    public void setMbofInStatement(String mbofInStatement) {
        this.mbofInStatement = mbofInStatement;
    }

    public String getMboxCoFuncMailbox() {
        return this.mboxCoFuncMailbox;
    }

    public void setMboxCoFuncMailbox(String mboxCoFuncMailbox) {
        this.mboxCoFuncMailbox = mboxCoFuncMailbox;
    }

    public Long getMboxInBrotherReallocation() {
        return this.mboxInBrotherReallocation;
    }

    public void setMboxInBrotherReallocation(Long mboxInBrotherReallocation) {
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

    public BigDecimal getOpasIdOrgaPoolAssignment() {
        return this.opasIdOrgaPoolAssignment;
    }

    public void setOpasIdOrgaPoolAssignment(BigDecimal opasIdOrgaPoolAssignment) {
        this.opasIdOrgaPoolAssignment = opasIdOrgaPoolAssignment;
    }

    public BigDecimal getParoIdOrganizationRole() {
        return this.paroIdOrganizationRole;
    }

    public void setParoIdOrganizationRole(BigDecimal paroIdOrganizationRole) {
        this.paroIdOrganizationRole = paroIdOrganizationRole;
    }

    public BigDecimal getRuleIdRule() {
        return this.ruleIdRule;
    }

    public void setRuleIdRule(BigDecimal ruleIdRule) {
        this.ruleIdRule = ruleIdRule;
    }

    public BigDecimal getUserIdUserUpdater() {
        return this.userIdUserUpdater;
    }

    public void setUserIdUserUpdater(BigDecimal userIdUserUpdater) {
        this.userIdUserUpdater = userIdUserUpdater;
    }

    public BigDecimal getWpooIdFunctionalPool() {
        return this.wpooIdFunctionalPool;
    }

    public void setWpooIdFunctionalPool(BigDecimal wpooIdFunctionalPool) {
        this.wpooIdFunctionalPool = wpooIdFunctionalPool;
    }

    public CnalfTaskMailboxPK getId() {
        return this.id;
    }

    public void setId(CnalfTaskMailboxPK id) {
        this.id = id;
    }

}
