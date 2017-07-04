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
 * The persistent class for the ScprrWorkAttachmentS database table.
 */
@Entity
@NamedQuery(name = "ScprrWorkAttachment.findAll", query = "SELECT s FROM ScprrWorkAttachment s")
@Table(name = "SCPRR_WORK_ATTACHMENT", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "PLAN_ID_PLANIFICATION_WORKFLOW", "ATTA_CO_DOCUMENT" }) })
public class ScprrWorkAttachment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 100, name = "ATTA_CO_DOCUMENT", nullable = false)
    private String attaCoDocument;

    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "WOAT_ID_WORK_ATTACHMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal woatIdWorkAttachment;

    @JoinColumn(name = "PLAN_ID_PLANIFICATION_WORKFLOW", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScprrPlanificationWorkflow scprrPlanificationWorkflow;

    public String getAttaCoDocument() {
        return this.attaCoDocument;
    }

    public void setAttaCoDocument(String attaCoDocument) {
        this.attaCoDocument = attaCoDocument;
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

    public BigDecimal getWoatIdWorkAttachment() {
        return this.woatIdWorkAttachment;
    }

    public void setWoatIdWorkAttachment(BigDecimal woatIdWorkAttachment) {
        this.woatIdWorkAttachment = woatIdWorkAttachment;
    }

    public ScprrPlanificationWorkflow getScprrPlanificationWorkflow() {
        return this.scprrPlanificationWorkflow;
    }

    public void setScprrPlanificationWorkflow(ScprrPlanificationWorkflow scprrPlanificationWorkflow) {
        this.scprrPlanificationWorkflow = scprrPlanificationWorkflow;
    }

}
