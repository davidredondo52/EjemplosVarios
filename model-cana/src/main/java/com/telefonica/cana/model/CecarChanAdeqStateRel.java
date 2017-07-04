package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the CecarChanAdeqStateRelS database table.
 */
@Entity
@NamedQuery(name = "CecarChanAdeqStateRel.findAll", query = "SELECT c FROM CecarChanAdeqStateRel c")
@Table(name = "CECAR_CHAN_ADEQ_STATE_REL", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BINT_ID_CHANNEL_ADEQUACY_TYPE", "BIST_ID_CHANNEL_ADEQUACY_STATE" }) })
public class CecarChanAdeqStateRel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "BINT_ID_CHANNEL_ADEQUACY_TYPE", precision = 3)
    private Long bintIdChannelAdequacyType;

    @Column(columnDefinition = "DATE", name = "BISR_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bisrDaEndValidity;

    @Column(columnDefinition = "DATE", name = "BISR_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bisrDaStartValidity;

    @Column(name = "BISR_ID_CHAN_ADEQ_STATE_REL", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal bisrIdChanAdeqStateRel;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cecarChanAdeqStateRel")
    private List<CecaaChanAdeqStateMov> cecaaChanAdeqStateMovs;
    @JoinColumn(name = "BIST_ID_CHANNEL_ADEQUACY_STATE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CecadChannelAdequacyState cecadChannelAdequacyState;

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

    public Long getBintIdChannelAdequacyType() {
        return this.bintIdChannelAdequacyType;
    }

    public void setBintIdChannelAdequacyType(Long bintIdChannelAdequacyType) {
        this.bintIdChannelAdequacyType = bintIdChannelAdequacyType;
    }

    public Date getBisrDaEndValidity() {
        if (this.bisrDaEndValidity != null)
            return (Date) this.bisrDaEndValidity.clone();
        else
            return null;
    }

    public void setBisrDaEndValidity(Date bisrDaEndValidity) {
        if (bisrDaEndValidity != null)
            this.bisrDaEndValidity = (Date) bisrDaEndValidity.clone();
        else
            this.bisrDaEndValidity = bisrDaEndValidity;
    }

    public Date getBisrDaStartValidity() {
        if (this.bisrDaStartValidity != null)
            return (Date) this.bisrDaStartValidity.clone();
        else
            return null;
    }

    public void setBisrDaStartValidity(Date bisrDaStartValidity) {
        if (bisrDaStartValidity != null)
            this.bisrDaStartValidity = (Date) bisrDaStartValidity.clone();
        else
            this.bisrDaStartValidity = bisrDaStartValidity;
    }

    public BigDecimal getBisrIdChanAdeqStateRel() {
        return this.bisrIdChanAdeqStateRel;
    }

    public void setBisrIdChanAdeqStateRel(BigDecimal bisrIdChanAdeqStateRel) {
        this.bisrIdChanAdeqStateRel = bisrIdChanAdeqStateRel;
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

    public List<CecaaChanAdeqStateMov> getCecaaChanAdeqStateMovs() {
        return this.cecaaChanAdeqStateMovs;
    }

    public void setCecaaChanAdeqStateMovs(List<CecaaChanAdeqStateMov> cecaaChanAdeqStateMovs) {
        this.cecaaChanAdeqStateMovs = cecaaChanAdeqStateMovs;
    }

    public void addCecaaChanAdeqStateMovs(CecaaChanAdeqStateMov cecaaChanAdeqStateMov) {
        if (this.cecaaChanAdeqStateMovs == null)
            this.cecaaChanAdeqStateMovs = new ArrayList<CecaaChanAdeqStateMov>();
        this.cecaaChanAdeqStateMovs.add(cecaaChanAdeqStateMov);
    }

    public void removeCecaaChanAdeqStateMovs(CecaaChanAdeqStateMov cecaaChanAdeqStateMovToRemove) {
        if (cecaaChanAdeqStateMovToRemove != null)
            this.cecaaChanAdeqStateMovs.remove(cecaaChanAdeqStateMovToRemove);
    }

    public CecadChannelAdequacyState getCecadChannelAdequacyState() {
        return this.cecadChannelAdequacyState;
    }

    public void setCecadChannelAdequacyState(CecadChannelAdequacyState cecadChannelAdequacyState) {
        this.cecadChannelAdequacyState = cecadChannelAdequacyState;
    }

}
