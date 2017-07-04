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

/**
 * The persistent class for the GewfpWorkflowS database table.
 */
@Entity
@NamedQuery(name = "GewfpWorkflow.findAll", query = "SELECT g FROM GewfpWorkflow g")
@Table(name = "GEWFP_WORKFLOW")
public class GewfpWorkflow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "BUIN_ID_CUST_INQUIRY", precision = 38)
    private BigDecimal buinIdCustInquiry;

    @Column(name = "PARO_ID_CREATOR_ORG_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdCreatorOrgRole;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @Column(length = 12, name = "WFLO_CO_WORKFLOW", nullable = false, unique = true)
    private String wfloCoWorkflow;

    @Column(length = 500, name = "WFLO_DS_WORKFLOW", nullable = false)
    private String wfloDsWorkflow;

    @Column(name = "WFLO_ID_WORKFLOW", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal wfloIdWorkflow;

    @Column(name = "WFLO_IN_STATE", nullable = false, precision = 1)
    private Long wfloInState;

    @Column(length = 100, name = "WFLO_NA_TITLE")
    private String wfloNaTitle;

    @Column(name = "WFLO_TI_DESIRED", nullable = false)
    private Timestamp wfloTiDesired;

    @Column(name = "WFLO_TI_END_VALIDITY")
    private Timestamp wfloTiEndValidity;

    // bi-directional many-to-one association to GewfaWorkflowNote
    @OneToMany(mappedBy = "gewfpWorkflow", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<GewfaWorkflowNote> gewfaWorkflowNotes;
    @OneToMany(mappedBy = "gewfpWorkflow")
    private List<GewfaWorkflowStep> gewfaWorkflowSteps;
    @JoinColumn(name = "WSPE_ID_WORKFLOW_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfpWorkflowSpec gewfpWorkflowSpec;

    @OneToMany(mappedBy = "gewfpWorkflow", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<GewfrWorkflowAttachment> gewfrWorkflowAttachments;

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

    public BigDecimal getBuinIdCustInquiry() {
        return this.buinIdCustInquiry;
    }

    public void setBuinIdCustInquiry(BigDecimal buinIdCustInquiry) {
        this.buinIdCustInquiry = buinIdCustInquiry;
    }

    public BigDecimal getParoIdCreatorOrgRole() {
        return this.paroIdCreatorOrgRole;
    }

    public void setParoIdCreatorOrgRole(BigDecimal paroIdCreatorOrgRole) {
        this.paroIdCreatorOrgRole = paroIdCreatorOrgRole;
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

    public String getWfloCoWorkflow() {
        return this.wfloCoWorkflow;
    }

    public void setWfloCoWorkflow(String wfloCoWorkflow) {
        this.wfloCoWorkflow = wfloCoWorkflow;
    }

    public String getWfloDsWorkflow() {
        return this.wfloDsWorkflow;
    }

    public void setWfloDsWorkflow(String wfloDsWorkflow) {
        this.wfloDsWorkflow = wfloDsWorkflow;
    }

    public BigDecimal getWfloIdWorkflow() {
        return this.wfloIdWorkflow;
    }

    public void setWfloIdWorkflow(BigDecimal wfloIdWorkflow) {
        this.wfloIdWorkflow = wfloIdWorkflow;
    }

    public Long getWfloInState() {
        return this.wfloInState;
    }

    public void setWfloInState(Long wfloInState) {
        this.wfloInState = wfloInState;
    }

    public String getWfloNaTitle() {
        return this.wfloNaTitle;
    }

    public void setWfloNaTitle(String wfloNaTitle) {
        this.wfloNaTitle = wfloNaTitle;
    }

    public Timestamp getWfloTiDesired() {
        if (this.wfloTiDesired != null)
            return (Timestamp) this.wfloTiDesired.clone();
        else
            return null;
    }

    public void setWfloTiDesired(Timestamp wfloTiDesired) {
        if (wfloTiDesired != null)
            this.wfloTiDesired = (Timestamp) wfloTiDesired.clone();
        else
            this.wfloTiDesired = wfloTiDesired;
    }

    public Timestamp getWfloTiEndValidity() {
        if (this.wfloTiEndValidity != null)
            return (Timestamp) this.wfloTiEndValidity.clone();
        else
            return null;
    }

    public void setWfloTiEndValidity(Timestamp wfloTiEndValidity) {
        if (wfloTiEndValidity != null)
            this.wfloTiEndValidity = (Timestamp) wfloTiEndValidity.clone();
        else
            this.wfloTiEndValidity = wfloTiEndValidity;
    }

    public List<GewfaWorkflowNote> getGewfaWorkflowNotes() {
        return this.gewfaWorkflowNotes;
    }

    public void setGewfaWorkflowNotes(List<GewfaWorkflowNote> gewfaWorkflowNotes) {
        this.gewfaWorkflowNotes = gewfaWorkflowNotes;
    }

    public void addGewfaWorkflowNotes(GewfaWorkflowNote gewfaWorkflowNote) {
        if (this.gewfaWorkflowNotes == null)
            this.gewfaWorkflowNotes = new ArrayList<GewfaWorkflowNote>();
        this.gewfaWorkflowNotes.add(gewfaWorkflowNote);
    }

    public void removeGewfaWorkflowNotes(GewfaWorkflowNote gewfaWorkflowNoteToRemove) {
        if (gewfaWorkflowNoteToRemove != null)
            this.gewfaWorkflowNotes.remove(gewfaWorkflowNoteToRemove);
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

    public GewfpWorkflowSpec getGewfpWorkflowSpec() {
        return this.gewfpWorkflowSpec;
    }

    public void setGewfpWorkflowSpec(GewfpWorkflowSpec gewfpWorkflowSpec) {
        this.gewfpWorkflowSpec = gewfpWorkflowSpec;
    }

    public List<GewfrWorkflowAttachment> getGewfrWorkflowAttachments() {
        return this.gewfrWorkflowAttachments;
    }

    public void setGewfrWorkflowAttachments(List<GewfrWorkflowAttachment> gewfrWorkflowAttachments) {
        this.gewfrWorkflowAttachments = gewfrWorkflowAttachments;
    }

    public void addGewfrWorkflowAttachments(GewfrWorkflowAttachment gewfrWorkflowAttachment) {
        if (this.gewfrWorkflowAttachments == null)
            this.gewfrWorkflowAttachments = new ArrayList<GewfrWorkflowAttachment>();
        this.gewfrWorkflowAttachments.add(gewfrWorkflowAttachment);
    }

    public void removeGewfrWorkflowAttachments(GewfrWorkflowAttachment gewfrWorkflowAttachmentToRemove) {
        if (gewfrWorkflowAttachmentToRemove != null)
            this.gewfrWorkflowAttachments.remove(gewfrWorkflowAttachmentToRemove);
    }

}
