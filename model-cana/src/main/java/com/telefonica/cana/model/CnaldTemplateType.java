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
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CnaldTemplateTypeS database table.
 */
@Entity
@NamedQuery(name = "CnaldTemplateType.findAll", query = "SELECT c FROM CnaldTemplateType c")
@Table(name = "CNALD_TEMPLATE_TYPE")
public class CnaldTemplateType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "TPTT_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date tpttDaEndValidity;

    @Column(columnDefinition = "DATE", name = "TPTT_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date tpttDaStartValidity;

    @Column(name = "TPTT_ID_TEMPLATE_TYPE", nullable = false, precision = 3, unique = true)
    @Id
    private Long tpttIdTemplateType;

    @Column(name = "TPTT_IN_RECIPIENT", nullable = false, precision = 1)
    private Long tpttInRecipient;

    @Column(length = 50, name = "TTYL_NA_TEMPLATE_TYPE", nullable = false)
    private String ttylNaTemplateType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnaldTemplateType")
    private List<CnalpTemplate> cnalpTemplates;
    @OneToMany(mappedBy = "cnaldTemplateType", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrTemplateTypeL> cnalrTemplateTypeLs;

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

    public Date getTpttDaEndValidity() {
        if (this.tpttDaEndValidity != null)
            return (Date) this.tpttDaEndValidity.clone();
        else
            return null;
    }

    public void setTpttDaEndValidity(Date tpttDaEndValidity) {
        if (tpttDaEndValidity != null)
            this.tpttDaEndValidity = (Date) tpttDaEndValidity.clone();
        else
            this.tpttDaEndValidity = tpttDaEndValidity;
    }

    public Date getTpttDaStartValidity() {
        if (this.tpttDaStartValidity != null)
            return (Date) this.tpttDaStartValidity.clone();
        else
            return null;
    }

    public void setTpttDaStartValidity(Date tpttDaStartValidity) {
        if (tpttDaStartValidity != null)
            this.tpttDaStartValidity = (Date) tpttDaStartValidity.clone();
        else
            this.tpttDaStartValidity = tpttDaStartValidity;
    }

    public Long getTpttIdTemplateType() {
        return this.tpttIdTemplateType;
    }

    public void setTpttIdTemplateType(Long tpttIdTemplateType) {
        this.tpttIdTemplateType = tpttIdTemplateType;
    }

    public Long getTpttInRecipient() {
        return this.tpttInRecipient;
    }

    public void setTpttInRecipient(Long tpttInRecipient) {
        this.tpttInRecipient = tpttInRecipient;
    }

    public String getTtylNaTemplateType() {
        return this.ttylNaTemplateType;
    }

    public void setTtylNaTemplateType(String ttylNaTemplateType) {
        this.ttylNaTemplateType = ttylNaTemplateType;
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

    public List<CnalpTemplate> getCnalpTemplates() {
        return this.cnalpTemplates;
    }

    public void setCnalpTemplates(List<CnalpTemplate> cnalpTemplates) {
        this.cnalpTemplates = cnalpTemplates;
    }

    public void addCnalpTemplates(CnalpTemplate cnalpTemplate) {
        if (this.cnalpTemplates == null)
            this.cnalpTemplates = new ArrayList<CnalpTemplate>();
        this.cnalpTemplates.add(cnalpTemplate);
    }

    public void removeCnalpTemplates(CnalpTemplate cnalpTemplateToRemove) {
        if (cnalpTemplateToRemove != null)
            this.cnalpTemplates.remove(cnalpTemplateToRemove);
    }

    public List<CnalrTemplateTypeL> getCnalrTemplateTypeLs() {
        return this.cnalrTemplateTypeLs;
    }

    public void setCnalrTemplateTypeLs(List<CnalrTemplateTypeL> cnalrTemplateTypeLs) {
        this.cnalrTemplateTypeLs = cnalrTemplateTypeLs;
    }

    public void addCnalrTemplateTypeLs(CnalrTemplateTypeL cnalrTemplateTypeL) {
        if (this.cnalrTemplateTypeLs == null)
            this.cnalrTemplateTypeLs = new ArrayList<CnalrTemplateTypeL>();
        this.cnalrTemplateTypeLs.add(cnalrTemplateTypeL);
    }

    public void removeCnalrTemplateTypeLs(CnalrTemplateTypeL cnalrTemplateTypeLToRemove) {
        if (cnalrTemplateTypeLToRemove != null)
            this.cnalrTemplateTypeLs.remove(cnalrTemplateTypeLToRemove);
    }

}
