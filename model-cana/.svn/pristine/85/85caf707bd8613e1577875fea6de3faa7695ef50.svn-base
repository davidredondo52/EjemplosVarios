package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CecadChannelAdequacyStateS database table.
 */
@Entity
@NamedQuery(name = "CecadChannelAdequacyState.findAll", query = "SELECT c FROM CecadChannelAdequacyState c")
@Table(name = "CECAD_CHANNEL_ADEQUACY_STATE")
public class CecadChannelAdequacyState implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "BIST_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bistDaEndValidity;

    @Column(columnDefinition = "DATE", name = "BIST_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bistDaStartValidity;

    @Column(name = "BIST_ID_CHANNEL_ADEQUACY_STATE", nullable = false, precision = 3, unique = true)
    @Id
    private Long bistIdChannelAdequacyState;

    @Column(length = 100, name = "LBIS_DS_CHANNEL_ADEQUACY_STATE")
    private String lbisDsChannelAdequacyState;

    @Column(length = 40, name = "LBIS_NA_CHANNEL_ADEQUACY_STATE", nullable = false)
    private String lbisNaChannelAdequacyState;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cecadChannelAdequacyState")
    private List<CecarChanAdeqStateRel> cecarChanAdeqStateRels;
    @OneToMany(mappedBy = "cecadChannelAdequacyState")
    private List<CecarChannelAdequacyStateL> cecarChannelAdequacyStateLs;

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

    public Date getBistDaEndValidity() {
        if (this.bistDaEndValidity != null)
            return (Date) this.bistDaEndValidity.clone();
        else
            return null;
    }

    public void setBistDaEndValidity(Date bistDaEndValidity) {
        if (bistDaEndValidity != null)
            this.bistDaEndValidity = (Date) bistDaEndValidity.clone();
        else
            this.bistDaEndValidity = bistDaEndValidity;
    }

    public Date getBistDaStartValidity() {
        if (this.bistDaStartValidity != null)
            return (Date) this.bistDaStartValidity.clone();
        else
            return null;
    }

    public void setBistDaStartValidity(Date bistDaStartValidity) {
        if (bistDaStartValidity != null)
            this.bistDaStartValidity = (Date) bistDaStartValidity.clone();
        else
            this.bistDaStartValidity = bistDaStartValidity;
    }

    public Long getBistIdChannelAdequacyState() {
        return this.bistIdChannelAdequacyState;
    }

    public void setBistIdChannelAdequacyState(Long bistIdChannelAdequacyState) {
        this.bistIdChannelAdequacyState = bistIdChannelAdequacyState;
    }

    public String getLbisDsChannelAdequacyState() {
        return this.lbisDsChannelAdequacyState;
    }

    public void setLbisDsChannelAdequacyState(String lbisDsChannelAdequacyState) {
        this.lbisDsChannelAdequacyState = lbisDsChannelAdequacyState;
    }

    public String getLbisNaChannelAdequacyState() {
        return this.lbisNaChannelAdequacyState;
    }

    public void setLbisNaChannelAdequacyState(String lbisNaChannelAdequacyState) {
        this.lbisNaChannelAdequacyState = lbisNaChannelAdequacyState;
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

    public List<CecarChanAdeqStateRel> getCecarChanAdeqStateRels() {
        return this.cecarChanAdeqStateRels;
    }

    public void setCecarChanAdeqStateRels(List<CecarChanAdeqStateRel> cecarChanAdeqStateRels) {
        this.cecarChanAdeqStateRels = cecarChanAdeqStateRels;
    }

    public void addCecarChanAdeqStateRels(CecarChanAdeqStateRel cecarChanAdeqStateRel) {
        if (this.cecarChanAdeqStateRels == null)
            this.cecarChanAdeqStateRels = new ArrayList<CecarChanAdeqStateRel>();
        this.cecarChanAdeqStateRels.add(cecarChanAdeqStateRel);
    }

    public void removeCecarChanAdeqStateRels(CecarChanAdeqStateRel cecarChanAdeqStateRelToRemove) {
        if (cecarChanAdeqStateRelToRemove != null)
            this.cecarChanAdeqStateRels.remove(cecarChanAdeqStateRelToRemove);
    }

    public List<CecarChannelAdequacyStateL> getCecarChannelAdequacyStateLs() {
        return this.cecarChannelAdequacyStateLs;
    }

    public void setCecarChannelAdequacyStateLs(List<CecarChannelAdequacyStateL> cecarChannelAdequacyStateLs) {
        this.cecarChannelAdequacyStateLs = cecarChannelAdequacyStateLs;
    }

    public void addCecarChannelAdequacyStateLs(CecarChannelAdequacyStateL cecarChannelAdequacyStateL) {
        if (this.cecarChannelAdequacyStateLs == null)
            this.cecarChannelAdequacyStateLs = new ArrayList<CecarChannelAdequacyStateL>();
        this.cecarChannelAdequacyStateLs.add(cecarChannelAdequacyStateL);
    }

    public void removeCecarChannelAdequacyStateLs(CecarChannelAdequacyStateL cecarChannelAdequacyStateLToRemove) {
        if (cecarChannelAdequacyStateLToRemove != null)
            this.cecarChannelAdequacyStateLs.remove(cecarChannelAdequacyStateLToRemove);
    }

}
