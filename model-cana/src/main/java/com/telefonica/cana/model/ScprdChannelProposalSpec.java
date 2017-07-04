package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ScprdChannelProposalSpecS database table.
 */
@Entity
@NamedQuery(name = "ScprdChannelProposalSpec.findAll", query = "SELECT s FROM ScprdChannelProposalSpec s")
@Table(name = "SCPRD_CHANNEL_PROPOSAL_SPEC")
public class ScprdChannelProposalSpec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(length = 500, name = "BISL_DS_CHANNEL_PROPOSAL_SPEC")
    private String bislDsChannelProposalSpec;

    @Column(length = 100, name = "BISL_NA_CHANNEL_PROPOSAL_SPEC", nullable = false)
    private String bislNaChannelProposalSpec;

    @Column(columnDefinition = "DATE", name = "BISP_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bispDaEndValidity;

    @Column(columnDefinition = "DATE", name = "BISP_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bispDaStartValidity;

    @Column(name = "BISP_ID_CHANNEL_PROPOSAL_SPEC", nullable = false, precision = 6, unique = true)
    @GeneratedValue(generator = "SCPRD_CHANNEL_PROPOSAL_SPEC_BISPIDCHANNELPROPOSALSPEC_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SCPRD_CHANNEL_PROPOSAL_SPEC_BISPIDCHANNELPROPOSALSPEC_GENERATOR", sequenceName = "SCPR_CHANNEL_PROPOSAL_SPEC_SEQ")
    private Long bispIdChannelProposalSpec;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "scprdChannelProposalSpec")
    private List<ScprpSalesChannelProposal> scprpSalesChannelProposals;
    @OneToMany(mappedBy = "scprdChannelProposalSpec", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ScprrChannelProposalSpecL> scprrChannelProposalSpecLs;
    @OneToMany(mappedBy = "scprdChannelProposalSpec", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
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

    public String getBislDsChannelProposalSpec() {
        return this.bislDsChannelProposalSpec;
    }

    public void setBislDsChannelProposalSpec(String bislDsChannelProposalSpec) {
        this.bislDsChannelProposalSpec = bislDsChannelProposalSpec;
    }

    public String getBislNaChannelProposalSpec() {
        return this.bislNaChannelProposalSpec;
    }

    public void setBislNaChannelProposalSpec(String bislNaChannelProposalSpec) {
        this.bislNaChannelProposalSpec = bislNaChannelProposalSpec;
    }

    public Date getBispDaEndValidity() {
        if (this.bispDaEndValidity != null)
            return (Date) this.bispDaEndValidity.clone();
        else
            return null;
    }

    public void setBispDaEndValidity(Date bispDaEndValidity) {
        if (bispDaEndValidity != null)
            this.bispDaEndValidity = (Date) bispDaEndValidity.clone();
        else
            this.bispDaEndValidity = bispDaEndValidity;
    }

    public Date getBispDaStartValidity() {
        if (this.bispDaStartValidity != null)
            return (Date) this.bispDaStartValidity.clone();
        else
            return null;
    }

    public void setBispDaStartValidity(Date bispDaStartValidity) {
        if (bispDaStartValidity != null)
            this.bispDaStartValidity = (Date) bispDaStartValidity.clone();
        else
            this.bispDaStartValidity = bispDaStartValidity;
    }

    public Long getBispIdChannelProposalSpec() {
        return this.bispIdChannelProposalSpec;
    }

    public void setBispIdChannelProposalSpec(Long bispIdChannelProposalSpec) {
        this.bispIdChannelProposalSpec = bispIdChannelProposalSpec;
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

    public List<ScprpSalesChannelProposal> getScprpSalesChannelProposals() {
        return this.scprpSalesChannelProposals;
    }

    public void setScprpSalesChannelProposals(List<ScprpSalesChannelProposal> scprpSalesChannelProposals) {
        this.scprpSalesChannelProposals = scprpSalesChannelProposals;
    }

    public void addScprpSalesChannelProposals(ScprpSalesChannelProposal scprpSalesChannelProposal) {
        if (this.scprpSalesChannelProposals == null)
            this.scprpSalesChannelProposals = new ArrayList<ScprpSalesChannelProposal>();
        this.scprpSalesChannelProposals.add(scprpSalesChannelProposal);
    }

    public void removeScprpSalesChannelProposals(ScprpSalesChannelProposal scprpSalesChannelProposalToRemove) {
        if (scprpSalesChannelProposalToRemove != null)
            this.scprpSalesChannelProposals.remove(scprpSalesChannelProposalToRemove);
    }

    public List<ScprrChannelProposalSpecL> getScprrChannelProposalSpecLs() {
        return this.scprrChannelProposalSpecLs;
    }

    public void setScprrChannelProposalSpecLs(List<ScprrChannelProposalSpecL> scprrChannelProposalSpecLs) {
        this.scprrChannelProposalSpecLs = scprrChannelProposalSpecLs;
    }

    public void addScprrChannelProposalSpecLs(ScprrChannelProposalSpecL scprrChannelProposalSpecL) {
        if (this.scprrChannelProposalSpecLs == null)
            this.scprrChannelProposalSpecLs = new ArrayList<ScprrChannelProposalSpecL>();
        this.scprrChannelProposalSpecLs.add(scprrChannelProposalSpecL);
    }

    public void removeScprrChannelProposalSpecLs(ScprrChannelProposalSpecL scprrChannelProposalSpecLToRemove) {
        if (scprrChannelProposalSpecLToRemove != null)
            this.scprrChannelProposalSpecLs.remove(scprrChannelProposalSpecLToRemove);
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
