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
 * The persistent class for the GewfrWorkflowAttachmentS database table.
 */
@Entity
@NamedQuery(name = "GewfrWorkflowAttachment.findAll", query = "SELECT g FROM GewfrWorkflowAttachment g")
@Table(name = "GEWFR_WORKFLOW_ATTACHMENT", uniqueConstraints = { @UniqueConstraint(columnNames = { "WFLO_ID_WORKFLOW",
        "ATTA_CO_DOCUMENT" }) })
public class GewfrWorkflowAttachment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 100, name = "ATTA_CO_DOCUMENT", nullable = false)
    private String attaCoDocument;

    @Column(length = 100, name = "ATTA_NA_FILE", nullable = false)
    private String attaNaFile;

    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "WFAT_ID_WORKFLOW_ATTACHMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal wfatIdWorkflowAttachment;

    @JoinColumn(name = "WFLO_ID_WORKFLOW", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfpWorkflow gewfpWorkflow;

    public String getAttaCoDocument() {
        return this.attaCoDocument;
    }

    public void setAttaCoDocument(String attaCoDocument) {
        this.attaCoDocument = attaCoDocument;
    }

    public String getAttaNaFile() {
        return this.attaNaFile;
    }

    public void setAttaNaFile(String attaNaFile) {
        this.attaNaFile = attaNaFile;
    }

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

    public BigDecimal getWfatIdWorkflowAttachment() {
        return this.wfatIdWorkflowAttachment;
    }

    public void setWfatIdWorkflowAttachment(BigDecimal wfatIdWorkflowAttachment) {
        this.wfatIdWorkflowAttachment = wfatIdWorkflowAttachment;
    }

    public GewfpWorkflow getGewfpWorkflow() {
        return this.gewfpWorkflow;
    }

    public void setGewfpWorkflow(GewfpWorkflow gewfpWorkflow) {
        this.gewfpWorkflow = gewfpWorkflow;
    }

}
