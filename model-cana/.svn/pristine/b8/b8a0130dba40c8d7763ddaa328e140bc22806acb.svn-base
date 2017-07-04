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
 * The persistent class for the CecadChanAdeqStateReasonS database table.
 */
@Entity
@NamedQuery(name = "CecadChanAdeqStateReason.findAll", query = "SELECT c FROM CecadChanAdeqStateReason c")
@Table(name = "CECAD_CHAN_ADEQ_STATE_REASON")
public class CecadChanAdeqStateReason implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "BCSR_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bcsrDaEndValidity;

    @Column(columnDefinition = "DATE", name = "BCSR_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bcsrDaStartValidity;

    @Column(length = 250, name = "BCSR_DS_CHAN_ADEQ_STATE_REASON")
    private String bcsrDsChanAdeqStateReason;

    @Column(name = "BCSR_ID_CHAN_ADEQ_STATE_REASON", nullable = false, precision = 2, unique = true)
    @Id
    private Long bcsrIdChanAdeqStateReason;

    @Column(length = 40, name = "BCSR_NA_CHAN_ADEQ_STATE_REASON", nullable = false)
    private String bcsrNaChanAdeqStateReason;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cecadChanAdeqStateReason")
    private List<CecaaChanAdeqStateMov> cecaaChanAdeqStateMovs;

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

    public Date getBcsrDaEndValidity() {
        if (this.bcsrDaEndValidity != null)
            return (Date) this.bcsrDaEndValidity.clone();
        else
            return null;
    }

    public void setBcsrDaEndValidity(Date bcsrDaEndValidity) {
        if (bcsrDaEndValidity != null)
            this.bcsrDaEndValidity = (Date) bcsrDaEndValidity.clone();
        else
            this.bcsrDaEndValidity = bcsrDaEndValidity;
    }

    public Date getBcsrDaStartValidity() {
        if (this.bcsrDaStartValidity != null)
            return (Date) this.bcsrDaStartValidity.clone();
        else
            return null;
    }

    public void setBcsrDaStartValidity(Date bcsrDaStartValidity) {
        if (bcsrDaStartValidity != null)
            this.bcsrDaStartValidity = (Date) bcsrDaStartValidity.clone();
        else
            this.bcsrDaStartValidity = bcsrDaStartValidity;
    }

    public String getBcsrDsChanAdeqStateReason() {
        return this.bcsrDsChanAdeqStateReason;
    }

    public void setBcsrDsChanAdeqStateReason(String bcsrDsChanAdeqStateReason) {
        this.bcsrDsChanAdeqStateReason = bcsrDsChanAdeqStateReason;
    }

    public Long getBcsrIdChanAdeqStateReason() {
        return this.bcsrIdChanAdeqStateReason;
    }

    public void setBcsrIdChanAdeqStateReason(Long bcsrIdChanAdeqStateReason) {
        this.bcsrIdChanAdeqStateReason = bcsrIdChanAdeqStateReason;
    }

    public String getBcsrNaChanAdeqStateReason() {
        return this.bcsrNaChanAdeqStateReason;
    }

    public void setBcsrNaChanAdeqStateReason(String bcsrNaChanAdeqStateReason) {
        this.bcsrNaChanAdeqStateReason = bcsrNaChanAdeqStateReason;
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

}
