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
 * The persistent class for the CnaldChannelTypeS database table.
 */
@Entity
@NamedQuery(name = "CnaldChannelType.findAll", query = "SELECT c FROM CnaldChannelType c")
@Table(name = "CNALD_CHANNEL_TYPE")
public class CnaldChannelType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "CHAT_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date chatDaEndValidity;

    @Column(columnDefinition = "DATE", name = "CHAT_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date chatDaStartValidity;

    @Column(name = "CHAT_ID_CHANNEL_TYPE", nullable = false, precision = 2, unique = true)
    @GeneratedValue(generator = "CNALD_CHANNEL_TYPE_CHATIDCHANNELTYPE_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALD_CHANNEL_TYPE_CHATIDCHANNELTYPE_GENERATOR", sequenceName = "CNAL_CHANNEL_TYPE_SEQ")
    private Long chatIdChannelType;

    @Column(length = 20, name = "LCHT_NA_CHANNEL_TYPE", nullable = false)
    private String lchtNaChannelType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnaldChannelType", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrChannelTypeL> cnalrChannelTypeLs;
    @OneToMany(mappedBy = "cnaldChannelType")
    private List<CnalrFuncPoolSpChannelTy> cnalrFuncPoolSpChannelTies;
    @OneToMany(mappedBy = "cnaldChannelType")
    private List<CnalrInquSpecChannelType> cnalrInquSpecChannelTypes;
    @OneToMany(mappedBy = "cnaldChannelType")
    private List<CnalrTemplateChannelType> cnalrTemplateChannelTypes;
    @OneToMany(mappedBy = "cnaldChannelType")
    private List<ScderDemandChannelType> scderDemandChannelTypes;

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

    public Date getChatDaEndValidity() {
        if (this.chatDaEndValidity != null)
            return (Date) this.chatDaEndValidity.clone();
        else
            return null;
    }

    public void setChatDaEndValidity(Date chatDaEndValidity) {
        if (chatDaEndValidity != null)
            this.chatDaEndValidity = (Date) chatDaEndValidity.clone();
        else
            this.chatDaEndValidity = chatDaEndValidity;
    }

    public Date getChatDaStartValidity() {
        if (this.chatDaStartValidity != null)
            return (Date) this.chatDaStartValidity.clone();
        else
            return null;
    }

    public void setChatDaStartValidity(Date chatDaStartValidity) {
        if (chatDaStartValidity != null)
            this.chatDaStartValidity = (Date) chatDaStartValidity.clone();
        else
            this.chatDaStartValidity = chatDaStartValidity;
    }

    public Long getChatIdChannelType() {
        return this.chatIdChannelType;
    }

    public void setChatIdChannelType(Long chatIdChannelType) {
        this.chatIdChannelType = chatIdChannelType;
    }

    public String getLchtNaChannelType() {
        return this.lchtNaChannelType;
    }

    public void setLchtNaChannelType(String lchtNaChannelType) {
        this.lchtNaChannelType = lchtNaChannelType;
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

    public List<CnalrChannelTypeL> getCnalrChannelTypeLs() {
        return this.cnalrChannelTypeLs;
    }

    public void setCnalrChannelTypeLs(List<CnalrChannelTypeL> cnalrChannelTypeLs) {
        this.cnalrChannelTypeLs = cnalrChannelTypeLs;
    }

    public void addCnalrChannelTypeLs(CnalrChannelTypeL cnalrChannelTypeL) {
        if (this.cnalrChannelTypeLs == null)
            this.cnalrChannelTypeLs = new ArrayList<CnalrChannelTypeL>();
        this.cnalrChannelTypeLs.add(cnalrChannelTypeL);
    }

    public void removeCnalrChannelTypeLs(CnalrChannelTypeL cnalrChannelTypeLToRemove) {
        if (cnalrChannelTypeLToRemove != null)
            this.cnalrChannelTypeLs.remove(cnalrChannelTypeLToRemove);
    }

    public List<CnalrFuncPoolSpChannelTy> getCnalrFuncPoolSpChannelTies() {
        return this.cnalrFuncPoolSpChannelTies;
    }

    public void setCnalrFuncPoolSpChannelTies(List<CnalrFuncPoolSpChannelTy> cnalrFuncPoolSpChannelTies) {
        this.cnalrFuncPoolSpChannelTies = cnalrFuncPoolSpChannelTies;
    }

    public void addCnalrFuncPoolSpChannelTies(CnalrFuncPoolSpChannelTy cnalrFuncPoolSpChannelTy) {
        if (this.cnalrFuncPoolSpChannelTies == null)
            this.cnalrFuncPoolSpChannelTies = new ArrayList<CnalrFuncPoolSpChannelTy>();
        this.cnalrFuncPoolSpChannelTies.add(cnalrFuncPoolSpChannelTy);
    }

    public void removeCnalrFuncPoolSpChannelTies(CnalrFuncPoolSpChannelTy cnalrFuncPoolSpChannelTyToRemove) {
        if (cnalrFuncPoolSpChannelTyToRemove != null)
            this.cnalrFuncPoolSpChannelTies.remove(cnalrFuncPoolSpChannelTyToRemove);
    }

    public List<CnalrInquSpecChannelType> getCnalrInquSpecChannelTypes() {
        return this.cnalrInquSpecChannelTypes;
    }

    public void setCnalrInquSpecChannelTypes(List<CnalrInquSpecChannelType> cnalrInquSpecChannelTypes) {
        this.cnalrInquSpecChannelTypes = cnalrInquSpecChannelTypes;
    }

    public void addCnalrInquSpecChannelTypes(CnalrInquSpecChannelType cnalrInquSpecChannelType) {
        if (this.cnalrInquSpecChannelTypes == null)
            this.cnalrInquSpecChannelTypes = new ArrayList<CnalrInquSpecChannelType>();
        this.cnalrInquSpecChannelTypes.add(cnalrInquSpecChannelType);
    }

    public void removeCnalrInquSpecChannelTypes(CnalrInquSpecChannelType cnalrInquSpecChannelTypeToRemove) {
        if (cnalrInquSpecChannelTypeToRemove != null)
            this.cnalrInquSpecChannelTypes.remove(cnalrInquSpecChannelTypeToRemove);
    }

    public List<CnalrTemplateChannelType> getCnalrTemplateChannelTypes() {
        return this.cnalrTemplateChannelTypes;
    }

    public void setCnalrTemplateChannelTypes(List<CnalrTemplateChannelType> cnalrTemplateChannelTypes) {
        this.cnalrTemplateChannelTypes = cnalrTemplateChannelTypes;
    }

    public void addCnalrTemplateChannelTypes(CnalrTemplateChannelType cnalrTemplateChannelType) {
        if (this.cnalrTemplateChannelTypes == null)
            this.cnalrTemplateChannelTypes = new ArrayList<CnalrTemplateChannelType>();
        this.cnalrTemplateChannelTypes.add(cnalrTemplateChannelType);
    }

    public void removeCnalrTemplateChannelTypes(CnalrTemplateChannelType cnalrTemplateChannelTypeToRemove) {
        if (cnalrTemplateChannelTypeToRemove != null)
            this.cnalrTemplateChannelTypes.remove(cnalrTemplateChannelTypeToRemove);
    }

    public List<ScderDemandChannelType> getScderDemandChannelTypes() {
        return this.scderDemandChannelTypes;
    }

    public void setScderDemandChannelTypes(List<ScderDemandChannelType> scderDemandChannelTypes) {
        this.scderDemandChannelTypes = scderDemandChannelTypes;
    }

    public void addScderDemandChannelTypes(ScderDemandChannelType scderDemandChannelType) {
        if (this.scderDemandChannelTypes == null)
            this.scderDemandChannelTypes = new ArrayList<ScderDemandChannelType>();
        this.scderDemandChannelTypes.add(scderDemandChannelType);
    }

    public void removeScderDemandChannelTypes(ScderDemandChannelType scderDemandChannelTypeToRemove) {
        if (scderDemandChannelTypeToRemove != null)
            this.scderDemandChannelTypes.remove(scderDemandChannelTypeToRemove);
    }

}
