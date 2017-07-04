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
 * The persistent class for the GewfaWorkflowNoteS database table.
 */
@Entity
@NamedQuery(name = "GewfaWorkflowNote.findAll", query = "SELECT g FROM GewfaWorkflowNote g")
@Table(name = "GEWFA_WORKFLOW_NOTE", uniqueConstraints = { @UniqueConstraint(columnNames = { "WFLO_ID_WORKFLOW",
        "AUDI_TI_CREATION" }) })
public class GewfaWorkflowNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "PARO_ID_ORG_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdOrgRole;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "WFNO_ID_WORKFLOW_NOTE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal wfnoIdWorkflowNote;

    @Column(length = 500, name = "WFNO_OB_NOTE", nullable = false)
    private String wfnoObNote;

    @JoinColumn(name = "WFLO_ID_WORKFLOW", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfpWorkflow gewfpWorkflow;

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

    public BigDecimal getParoIdOrgRole() {
        return this.paroIdOrgRole;
    }

    public void setParoIdOrgRole(BigDecimal paroIdOrgRole) {
        this.paroIdOrgRole = paroIdOrgRole;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public BigDecimal getWfnoIdWorkflowNote() {
        return this.wfnoIdWorkflowNote;
    }

    public void setWfnoIdWorkflowNote(BigDecimal wfnoIdWorkflowNote) {
        this.wfnoIdWorkflowNote = wfnoIdWorkflowNote;
    }

    public String getWfnoObNote() {
        return this.wfnoObNote;
    }

    public void setWfnoObNote(String wfnoObNote) {
        this.wfnoObNote = wfnoObNote;
    }

    public GewfpWorkflow getGewfpWorkflow() {
        return this.gewfpWorkflow;
    }

    public void setGewfpWorkflow(GewfpWorkflow gewfpWorkflow) {
        this.gewfpWorkflow = gewfpWorkflow;
    }

}
