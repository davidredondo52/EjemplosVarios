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
 * The persistent class for the PrderSelectedFieldS database table.
 */
@Entity
@NamedQuery(name = "PrderSelectedField.findAll", query = "SELECT p FROM PrderSelectedField p")
@Table(name = "PRDER_SELECTED_FIELD", uniqueConstraints = { @UniqueConstraint(columnNames = { "PARO_ID_ORG_ROLE",
        "WOFI_ID_WORKSPACE_FIELD" }) })
public class PrderSelectedField implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "PARO_ID_ORG_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdOrgRole;

    @Column(name = "SEFI_ID_SELECTED_FIELD", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal sefiIdSelectedField;

    @Column(length = 50, name = "SEFI_NA_LABEL")
    private String sefiNaLabel;

    @Column(name = "SEFI_NU_LENGTH", nullable = false, precision = 5, scale = 2)
    private BigDecimal sefiNuLength;

    @Column(name = "SEFI_NU_ORDER", nullable = false, precision = 4)
    private Long sefiNuOrder;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

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

    public BigDecimal getParoIdOrgRole() {
        return this.paroIdOrgRole;
    }

    public void setParoIdOrgRole(BigDecimal paroIdOrgRole) {
        this.paroIdOrgRole = paroIdOrgRole;
    }

    public BigDecimal getSefiIdSelectedField() {
        return this.sefiIdSelectedField;
    }

    public void setSefiIdSelectedField(BigDecimal sefiIdSelectedField) {
        this.sefiIdSelectedField = sefiIdSelectedField;
    }

    public String getSefiNaLabel() {
        return this.sefiNaLabel;
    }

    public void setSefiNaLabel(String sefiNaLabel) {
        this.sefiNaLabel = sefiNaLabel;
    }

    public BigDecimal getSefiNuLength() {
        return this.sefiNuLength;
    }

    public void setSefiNuLength(BigDecimal sefiNuLength) {
        this.sefiNuLength = sefiNuLength;
    }

    public Long getSefiNuOrder() {
        return this.sefiNuOrder;
    }

    public void setSefiNuOrder(Long sefiNuOrder) {
        this.sefiNuOrder = sefiNuOrder;
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

    public PrdedWorkspaceField getPrdedWorkspaceField() {
        return this.prdedWorkspaceField;
    }

    public void setPrdedWorkspaceField(PrdedWorkspaceField prdedWorkspaceField) {
        this.prdedWorkspaceField = prdedWorkspaceField;
    }

}
