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

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the CnalpStatementModelS database table.
 */
@Entity
@NamedQuery(name = "CnalpStatementModel.findAll", query = "SELECT c FROM CnalpStatementModel c")
@Table(name = "CNALP_STATEMENT_MODEL", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "STTP_ID_STATEMENT_TYPE", "CMTY_ID_CONTACT_MEDIUM_TYPE" }) })
public class CnalpStatementModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "CMTY_ID_CONTACT_MEDIUM_TYPE", nullable = false, precision = 3)
    private Long cmtyIdContactMediumType;

    @Column(length = 50, name = "LSMO_NA_STATEMENT_MODEL", nullable = false)
    private String lsmoNaStatementModel;

    @Column(columnDefinition = "DATE", name = "STMO_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date stmoDaEndValidity;

    @Column(columnDefinition = "DATE", name = "STMO_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date stmoDaStartValidity;

    @Column(name = "STMO_ID_STATEMENT_MODEL", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal stmoIdStatementModel;

    @Column(name = "STMO_IN_CONFIGURABLE", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean stmoInConfigurable;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "STTP_ID_STATEMENT_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private CnaldStatementType cnaldStatementType;
    @OneToMany(mappedBy = "cnalpStatementModel", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrStatementModelL> cnalrStatementModelLs;
    @OneToMany(mappedBy = "cnalpStatementModel", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrTemplateModel> cnalrTemplateModels;

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

    public Long getCmtyIdContactMediumType() {
        return this.cmtyIdContactMediumType;
    }

    public void setCmtyIdContactMediumType(Long cmtyIdContactMediumType) {
        this.cmtyIdContactMediumType = cmtyIdContactMediumType;
    }

    public String getLsmoNaStatementModel() {
        return this.lsmoNaStatementModel;
    }

    public void setLsmoNaStatementModel(String lsmoNaStatementModel) {
        this.lsmoNaStatementModel = lsmoNaStatementModel;
    }

    public Date getStmoDaEndValidity() {
        if (this.stmoDaEndValidity != null)
            return (Date) this.stmoDaEndValidity.clone();
        else
            return null;
    }

    public void setStmoDaEndValidity(Date stmoDaEndValidity) {
        if (stmoDaEndValidity != null)
            this.stmoDaEndValidity = (Date) stmoDaEndValidity.clone();
        else
            this.stmoDaEndValidity = stmoDaEndValidity;
    }

    public Date getStmoDaStartValidity() {
        if (this.stmoDaStartValidity != null)
            return (Date) this.stmoDaStartValidity.clone();
        else
            return null;
    }

    public void setStmoDaStartValidity(Date stmoDaStartValidity) {
        if (stmoDaStartValidity != null)
            this.stmoDaStartValidity = (Date) stmoDaStartValidity.clone();
        else
            this.stmoDaStartValidity = stmoDaStartValidity;
    }

    public BigDecimal getStmoIdStatementModel() {
        return this.stmoIdStatementModel;
    }

    public void setStmoIdStatementModel(BigDecimal stmoIdStatementModel) {
        this.stmoIdStatementModel = stmoIdStatementModel;
    }

    public Boolean getStmoInConfigurable() {
        return this.stmoInConfigurable;
    }

    public void setStmoInConfigurable(Boolean stmoInConfigurable) {
        this.stmoInConfigurable = stmoInConfigurable;
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

    public CnaldStatementType getCnaldStatementType() {
        return this.cnaldStatementType;
    }

    public void setCnaldStatementType(CnaldStatementType cnaldStatementType) {
        this.cnaldStatementType = cnaldStatementType;
    }

    public List<CnalrStatementModelL> getCnalrStatementModelLs() {
        return this.cnalrStatementModelLs;
    }

    public void setCnalrStatementModelLs(List<CnalrStatementModelL> cnalrStatementModelLs) {
        this.cnalrStatementModelLs = cnalrStatementModelLs;
    }

    public void addCnalrStatementModelLs(CnalrStatementModelL cnalrStatementModelL) {
        if (this.cnalrStatementModelLs == null)
            this.cnalrStatementModelLs = new ArrayList<CnalrStatementModelL>();
        this.cnalrStatementModelLs.add(cnalrStatementModelL);
    }

    public void removeCnalrStatementModelLs(CnalrStatementModelL cnalrStatementModelLToRemove) {
        if (cnalrStatementModelLToRemove != null)
            this.cnalrStatementModelLs.remove(cnalrStatementModelLToRemove);
    }

    public List<CnalrTemplateModel> getCnalrTemplateModels() {
        return this.cnalrTemplateModels;
    }

    public void setCnalrTemplateModels(List<CnalrTemplateModel> cnalrTemplateModels) {
        this.cnalrTemplateModels = cnalrTemplateModels;
    }

    public void addCnalrTemplateModels(CnalrTemplateModel cnalrTemplateModel) {
        if (this.cnalrTemplateModels == null)
            this.cnalrTemplateModels = new ArrayList<CnalrTemplateModel>();
        this.cnalrTemplateModels.add(cnalrTemplateModel);
    }

    public void removeCnalrTemplateModels(CnalrTemplateModel cnalrTemplateModelToRemove) {
        if (cnalrTemplateModelToRemove != null)
            this.cnalrTemplateModels.remove(cnalrTemplateModelToRemove);
    }

}
