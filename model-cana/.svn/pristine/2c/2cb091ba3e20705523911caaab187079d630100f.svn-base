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
 * The persistent class for the CnaldSalesChannelS database table.
 */
@Entity
@NamedQuery(name = "CnaldSalesChannel.findAll", query = "SELECT c FROM CnaldSalesChannel c")
@Table(name = "CNALD_SALES_CHANNEL")
public class CnaldSalesChannel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(length = 100, name = "LSAC_NA_SALES_CHANNEL", nullable = false)
    private String lsacNaSalesChannel;

    @Column(columnDefinition = "DATE", name = "SCHA_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date schaDaEndValidity;

    @Column(columnDefinition = "DATE", name = "SCHA_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date schaDaStartValidity;

    @Column(name = "SCHA_ID_SALES_CHANNEL", nullable = false, precision = 3, unique = true)
    @GeneratedValue(generator = "CNALD_SALES_CHANNEL_SCHAIDSALESCHANNEL_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALD_SALES_CHANNEL_SCHAIDSALESCHANNEL_GENERATOR", sequenceName = "CNAL_SALES_CHANNEL_SEQ")
    private Long schaIdSalesChannel;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnaldSalesChannel")
    private List<CnalpFunctionalPool> cnalpFunctionalPools;
    @OneToMany(mappedBy = "cnaldSalesChannel", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrSalesChannelL> cnalrSalesChannelLs;
    @OneToMany(mappedBy = "cnaldSalesChannel")
    private List<ScderDemandSalesChannel> scderDemandSalesChannels;

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

    public String getLsacNaSalesChannel() {
        return this.lsacNaSalesChannel;
    }

    public void setLsacNaSalesChannel(String lsacNaSalesChannel) {
        this.lsacNaSalesChannel = lsacNaSalesChannel;
    }

    public Date getSchaDaEndValidity() {
        if (this.schaDaEndValidity != null)
            return (Date) this.schaDaEndValidity.clone();
        else
            return null;
    }

    public void setSchaDaEndValidity(Date schaDaEndValidity) {
        if (schaDaEndValidity != null)
            this.schaDaEndValidity = (Date) schaDaEndValidity.clone();
        else
            this.schaDaEndValidity = schaDaEndValidity;
    }

    public Date getSchaDaStartValidity() {
        if (this.schaDaStartValidity != null)
            return (Date) this.schaDaStartValidity.clone();
        else
            return null;
    }

    public void setSchaDaStartValidity(Date schaDaStartValidity) {
        if (schaDaStartValidity != null)
            this.schaDaStartValidity = (Date) schaDaStartValidity.clone();
        else
            this.schaDaStartValidity = schaDaStartValidity;
    }

    public Long getSchaIdSalesChannel() {
        return this.schaIdSalesChannel;
    }

    public void setSchaIdSalesChannel(Long schaIdSalesChannel) {
        this.schaIdSalesChannel = schaIdSalesChannel;
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

    public List<CnalpFunctionalPool> getCnalpFunctionalPools() {
        return this.cnalpFunctionalPools;
    }

    public void setCnalpFunctionalPools(List<CnalpFunctionalPool> cnalpFunctionalPools) {
        this.cnalpFunctionalPools = cnalpFunctionalPools;
    }

    public void addCnalpFunctionalPools(CnalpFunctionalPool cnalpFunctionalPool) {
        if (this.cnalpFunctionalPools == null)
            this.cnalpFunctionalPools = new ArrayList<CnalpFunctionalPool>();
        this.cnalpFunctionalPools.add(cnalpFunctionalPool);
    }

    public void removeCnalpFunctionalPools(CnalpFunctionalPool cnalpFunctionalPoolToRemove) {
        if (cnalpFunctionalPoolToRemove != null)
            this.cnalpFunctionalPools.remove(cnalpFunctionalPoolToRemove);
    }

    public List<CnalrSalesChannelL> getCnalrSalesChannelLs() {
        return this.cnalrSalesChannelLs;
    }

    public void setCnalrSalesChannelLs(List<CnalrSalesChannelL> cnalrSalesChannelLs) {
        this.cnalrSalesChannelLs = cnalrSalesChannelLs;
    }

    public void addCnalrSalesChannelLs(CnalrSalesChannelL cnalrSalesChannelL) {
        if (this.cnalrSalesChannelLs == null)
            this.cnalrSalesChannelLs = new ArrayList<CnalrSalesChannelL>();
        this.cnalrSalesChannelLs.add(cnalrSalesChannelL);
    }

    public void removeCnalrSalesChannelLs(CnalrSalesChannelL cnalrSalesChannelLToRemove) {
        if (cnalrSalesChannelLToRemove != null)
            this.cnalrSalesChannelLs.remove(cnalrSalesChannelLToRemove);
    }

    public List<ScderDemandSalesChannel> getScderDemandSalesChannels() {
        return this.scderDemandSalesChannels;
    }

    public void setScderDemandSalesChannels(List<ScderDemandSalesChannel> scderDemandSalesChannels) {
        this.scderDemandSalesChannels = scderDemandSalesChannels;
    }

    public void addScderDemandSalesChannels(ScderDemandSalesChannel scderDemandSalesChannel) {
        if (this.scderDemandSalesChannels == null)
            this.scderDemandSalesChannels = new ArrayList<ScderDemandSalesChannel>();
        this.scderDemandSalesChannels.add(scderDemandSalesChannel);
    }

    public void removeScderDemandSalesChannels(ScderDemandSalesChannel scderDemandSalesChannelToRemove) {
        if (scderDemandSalesChannelToRemove != null)
            this.scderDemandSalesChannels.remove(scderDemandSalesChannelToRemove);
    }

}
