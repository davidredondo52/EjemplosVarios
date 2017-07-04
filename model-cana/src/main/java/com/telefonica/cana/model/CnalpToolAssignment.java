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
 * The persistent class for the CnalpToolAssignmentS database table.
 */
@Entity
@NamedQuery(name = "CnalpToolAssignment.findAll", query = "SELECT c FROM CnalpToolAssignment c")
@Table(name = "CNALP_TOOL_ASSIGNMENT", uniqueConstraints = { @UniqueConstraint(columnNames = { "TOOL_ID_TOOL",
        "TOAS_TI_START_VALIDITY" }) })
public class CnalpToolAssignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "TOAS_ID_TOOL_ASSIGNMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal toasIdToolAssignment;

    @Column(name = "TOAS_TI_END_VALIDITY")
    private Timestamp toasTiEndValidity;

    @Column(name = "TOAS_TI_START_VALIDITY", nullable = false)
    private Timestamp toasTiStartValidity;

    @Column(name = "TOOL_ID_TOOL", nullable = false, precision = 38)
    private BigDecimal toolIdTool;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "WPOO_ID_FUNCTIONAL_POOL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpFunctionalPool cnalpFunctionalPool;

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

    public BigDecimal getToasIdToolAssignment() {
        return this.toasIdToolAssignment;
    }

    public void setToasIdToolAssignment(BigDecimal toasIdToolAssignment) {
        this.toasIdToolAssignment = toasIdToolAssignment;
    }

    public Timestamp getToasTiEndValidity() {
        if (this.toasTiEndValidity != null)
            return (Timestamp) this.toasTiEndValidity.clone();
        else
            return null;
    }

    public void setToasTiEndValidity(Timestamp toasTiEndValidity) {
        if (toasTiEndValidity != null)
            this.toasTiEndValidity = (Timestamp) toasTiEndValidity.clone();
        else
            this.toasTiEndValidity = toasTiEndValidity;
    }

    public Timestamp getToasTiStartValidity() {
        if (this.toasTiStartValidity != null)
            return (Timestamp) this.toasTiStartValidity.clone();
        else
            return null;
    }

    public void setToasTiStartValidity(Timestamp toasTiStartValidity) {
        if (toasTiStartValidity != null)
            this.toasTiStartValidity = (Timestamp) toasTiStartValidity.clone();
        else
            this.toasTiStartValidity = toasTiStartValidity;
    }

    public BigDecimal getToolIdTool() {
        return this.toolIdTool;
    }

    public void setToolIdTool(BigDecimal toolIdTool) {
        this.toolIdTool = toolIdTool;
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

    public CnalpFunctionalPool getCnalpFunctionalPool() {
        return this.cnalpFunctionalPool;
    }

    public void setCnalpFunctionalPool(CnalpFunctionalPool cnalpFunctionalPool) {
        this.cnalpFunctionalPool = cnalpFunctionalPool;
    }

}
