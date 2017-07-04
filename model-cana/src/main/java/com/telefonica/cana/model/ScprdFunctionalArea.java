package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the ScprdFunctionalAreaS database table.
 */
@Entity
@NamedQuery(name = "ScprdFunctionalArea.findAll", query = "SELECT s FROM ScprdFunctionalArea s")
@Table(name = "SCPRD_FUNCTIONAL_AREA")
public class ScprdFunctionalArea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "FARE_ID_FUNCTIONAL_AREA", nullable = false, precision = 4, unique = true)
    @GeneratedValue(generator = "SCPRD_FUNCTIONAL_AREA_FAREIDFUNCTIONALAREA_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SCPRD_FUNCTIONAL_AREA_FAREIDFUNCTIONALAREA_GENERATOR", sequenceName = "SCPR_FUNCTIONAL_AREA_SEQ")
    private Long fareIdFunctionalArea;

    @Column(length = 100, name = "FARE_NA_FUNCTIONAL_AREA", nullable = false)
    private String fareNaFunctionalArea;

    @Column(name = "FARE_TI_END_VALIDITY")
    private Timestamp fareTiEndValidity;

    @Column(name = "FARE_TI_START_VALIDITY", nullable = false)
    private Timestamp fareTiStartValidity;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "scprdFunctionalArea", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalaTaskMailbox> cnalaTaskMailboxs;
    @OneToMany(mappedBy = "scprdFunctionalArea")
    private List<ScpraChannelProposalRole> scpraChannelProposalRoles;
    @OneToMany(mappedBy = "scprdFunctionalArea", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ScprrDefaultFuncArea> scprrDefaultFuncAreas;

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

    public Long getFareIdFunctionalArea() {
        return this.fareIdFunctionalArea;
    }

    public void setFareIdFunctionalArea(Long fareIdFunctionalArea) {
        this.fareIdFunctionalArea = fareIdFunctionalArea;
    }

    public String getFareNaFunctionalArea() {
        return this.fareNaFunctionalArea;
    }

    public void setFareNaFunctionalArea(String fareNaFunctionalArea) {
        this.fareNaFunctionalArea = fareNaFunctionalArea;
    }

    public Timestamp getFareTiEndValidity() {
        if (this.fareTiEndValidity != null)
            return (Timestamp) this.fareTiEndValidity.clone();
        else
            return null;
    }

    public void setFareTiEndValidity(Timestamp fareTiEndValidity) {
        if (fareTiEndValidity != null)
            this.fareTiEndValidity = (Timestamp) fareTiEndValidity.clone();
        else
            this.fareTiEndValidity = fareTiEndValidity;
    }

    public Timestamp getFareTiStartValidity() {
        if (this.fareTiStartValidity != null)
            return (Timestamp) this.fareTiStartValidity.clone();
        else
            return null;
    }

    public void setFareTiStartValidity(Timestamp fareTiStartValidity) {
        if (fareTiStartValidity != null)
            this.fareTiStartValidity = (Timestamp) fareTiStartValidity.clone();
        else
            this.fareTiStartValidity = fareTiStartValidity;
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

    public List<CnalaTaskMailbox> getCnalaTaskMailboxs() {
        return this.cnalaTaskMailboxs;
    }

    public void setCnalaTaskMailboxs(List<CnalaTaskMailbox> cnalaTaskMailboxs) {
        this.cnalaTaskMailboxs = cnalaTaskMailboxs;
    }

    public void addCnalaTaskMailboxs(CnalaTaskMailbox cnalaTaskMailbox) {
        if (this.cnalaTaskMailboxs == null)
            this.cnalaTaskMailboxs = new ArrayList<CnalaTaskMailbox>();
        this.cnalaTaskMailboxs.add(cnalaTaskMailbox);
    }

    public void removeCnalaTaskMailboxs(CnalaTaskMailbox cnalaTaskMailboxToRemove) {
        if (cnalaTaskMailboxToRemove != null)
            this.cnalaTaskMailboxs.remove(cnalaTaskMailboxToRemove);
    }

    public List<ScpraChannelProposalRole> getScpraChannelProposalRoles() {
        return this.scpraChannelProposalRoles;
    }

    public void setScpraChannelProposalRoles(List<ScpraChannelProposalRole> scpraChannelProposalRoles) {
        this.scpraChannelProposalRoles = scpraChannelProposalRoles;
    }

    public void addScpraChannelProposalRoles(ScpraChannelProposalRole scpraChannelProposalRole) {
        if (this.scpraChannelProposalRoles == null)
            this.scpraChannelProposalRoles = new ArrayList<ScpraChannelProposalRole>();
        this.scpraChannelProposalRoles.add(scpraChannelProposalRole);
    }

    public void removeScpraChannelProposalRoles(ScpraChannelProposalRole scpraChannelProposalRoleToRemove) {
        if (scpraChannelProposalRoleToRemove != null)
            this.scpraChannelProposalRoles.remove(scpraChannelProposalRoleToRemove);
    }

    public List<ScprrDefaultFuncArea> getScprrDefaultFuncAreas() {
        return this.scprrDefaultFuncAreas;
    }

    public void setScprrDefaultFuncAreas(List<ScprrDefaultFuncArea> scprrDefaultFuncAreas) {
        this.scprrDefaultFuncAreas = scprrDefaultFuncAreas;
    }

    public void addScprrDefaultFuncAreas(ScprrDefaultFuncArea scprrDefaultFuncArea) {
        if (this.scprrDefaultFuncAreas == null)
            this.scprrDefaultFuncAreas = new ArrayList<ScprrDefaultFuncArea>();
        this.scprrDefaultFuncAreas.add(scprrDefaultFuncArea);
    }

    public void removeScprrDefaultFuncAreas(ScprrDefaultFuncArea scprrDefaultFuncAreaToRemove) {
        if (scprrDefaultFuncAreaToRemove != null)
            this.scprrDefaultFuncAreas.remove(scprrDefaultFuncAreaToRemove);
    }

}
