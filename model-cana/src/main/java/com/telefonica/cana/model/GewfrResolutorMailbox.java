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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the GewfrResolutorMailboxS database table.
 */
@Entity
@NamedQuery(name = "GewfrResolutorMailbox.findAll", query = "SELECT g FROM GewfrResolutorMailbox g")
@Table(name = "GEWFR_RESOLUTOR_MAILBOX", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "WSPE_ID_WORKFLOW_SPEC", "WSST_NU_WORKFLOW_SPEC_STEP", "MBOX_ID_MAILBOX" }) })
public class GewfrResolutorMailbox implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "REMA_ID_RESOLUTOR_MAILBOX", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal remaIdResolutorMailbox;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "MBOX_ID_MAILBOX", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaTaskMailbox cnalaTaskMailbox;
    @JoinColumns({
            @JoinColumn(referencedColumnName = "WSPE_ID_WORKFLOW_SPEC", nullable = false, name = "WSPE_ID_WORKFLOW_SPEC"),
            @JoinColumn(referencedColumnName = "WSSP_NU_WORKFLOW_SPEC_STEP", nullable = false, name = "WSST_NU_WORKFLOW_SPEC_STEP") })
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfaWorkflowSpecStep gewfaWorkflowSpecStep;
    @OneToMany(mappedBy = "gewfrResolutorMailbox")
    private List<GewfaWorkflowStep> gewfaWorkflowSteps;

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

    public BigDecimal getRemaIdResolutorMailbox() {
        return this.remaIdResolutorMailbox;
    }

    public void setRemaIdResolutorMailbox(BigDecimal remaIdResolutorMailbox) {
        this.remaIdResolutorMailbox = remaIdResolutorMailbox;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnalaTaskMailbox getCnalaTaskMailbox() {
        return this.cnalaTaskMailbox;
    }

    public void setCnalaTaskMailbox(CnalaTaskMailbox cnalaTaskMailbox) {
        this.cnalaTaskMailbox = cnalaTaskMailbox;
    }

    public GewfaWorkflowSpecStep getGewfaWorkflowSpecStep() {
        return this.gewfaWorkflowSpecStep;
    }

    public void setGewfaWorkflowSpecStep(GewfaWorkflowSpecStep gewfaWorkflowSpecStep) {
        this.gewfaWorkflowSpecStep = gewfaWorkflowSpecStep;
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

}
