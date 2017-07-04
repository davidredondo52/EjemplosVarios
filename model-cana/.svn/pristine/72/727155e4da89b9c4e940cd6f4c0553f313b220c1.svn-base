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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the ScprrDefaultFuncAreaS database table.
 */
@Entity
@NamedQuery(name = "ScprrDefaultFuncArea.findAll", query = "SELECT s FROM ScprrDefaultFuncArea s")
@Table(name = "SCPRR_DEFAULT_FUNC_AREA", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BISP_ID_CHANNEL_PROPOSAL_SPEC", "FARE_ID_FUNCTIONAL_AREA" }) })
public class ScprrDefaultFuncArea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "DEFA_ID_DEFAULT_FUNCT_AREA", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal defaIdDefaultFunctArea;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "BISP_ID_CHANNEL_PROPOSAL_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScprdChannelProposalSpec scprdChannelProposalSpec;
    @JoinColumn(name = "FARE_ID_FUNCTIONAL_AREA", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScprdFunctionalArea scprdFunctionalArea;
    @OneToMany(mappedBy = "scprrDefaultFuncArea")
    private List<ScprrDefaultSubarea> scprrDefaultSubareas;

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

    public BigDecimal getDefaIdDefaultFunctArea() {
        return this.defaIdDefaultFunctArea;
    }

    public void setDefaIdDefaultFunctArea(BigDecimal defaIdDefaultFunctArea) {
        this.defaIdDefaultFunctArea = defaIdDefaultFunctArea;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public ScprdChannelProposalSpec getScprdChannelProposalSpec() {
        return this.scprdChannelProposalSpec;
    }

    public void setScprdChannelProposalSpec(ScprdChannelProposalSpec scprdChannelProposalSpec) {
        this.scprdChannelProposalSpec = scprdChannelProposalSpec;
    }

    public ScprdFunctionalArea getScprdFunctionalArea() {
        return this.scprdFunctionalArea;
    }

    public void setScprdFunctionalArea(ScprdFunctionalArea scprdFunctionalArea) {
        this.scprdFunctionalArea = scprdFunctionalArea;
    }

    public List<ScprrDefaultSubarea> getScprrDefaultSubareas() {
        return this.scprrDefaultSubareas;
    }

    public void setScprrDefaultSubareas(List<ScprrDefaultSubarea> scprrDefaultSubareas) {
        this.scprrDefaultSubareas = scprrDefaultSubareas;
    }

    public void addScprrDefaultSubareas(ScprrDefaultSubarea scprrDefaultSubarea) {
        if (this.scprrDefaultSubareas == null)
            this.scprrDefaultSubareas = new ArrayList<ScprrDefaultSubarea>();
        this.scprrDefaultSubareas.add(scprrDefaultSubarea);
    }

    public void removeScprrDefaultSubareas(ScprrDefaultSubarea scprrDefaultSubareaToRemove) {
        if (scprrDefaultSubareaToRemove != null)
            this.scprrDefaultSubareas.remove(scprrDefaultSubareaToRemove);
    }

}
