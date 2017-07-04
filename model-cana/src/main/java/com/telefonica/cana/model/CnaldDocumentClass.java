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
 * The persistent class for the CnaldDocumentClassS database table.
 */
@Entity
@NamedQuery(name = "CnaldDocumentClass.findAll", query = "SELECT c FROM CnaldDocumentClass c")
@Table(name = "CNALD_DOCUMENT_CLASS")
public class CnaldDocumentClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "DOCL_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date doclDaEndValidity;

    @Column(columnDefinition = "DATE", name = "DOCL_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date doclDaStartValidity;

    @Column(name = "DOCL_ID_DOCUMENT_CLASS", nullable = false, precision = 2, unique = true)
    @GeneratedValue(generator = "CNALD_DOCUMENT_CLASS_DOCLIDDOCUMENTCLASS_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALD_DOCUMENT_CLASS_DOCLIDDOCUMENTCLASS_GENERATOR", sequenceName = "CNAL_DOCUMENT_CLASS_SEQ")
    private Long doclIdDocumentClass;

    @Column(length = 50, name = "LDCL_NA_DOCUMENT_CLASS", nullable = false)
    private String ldclNaDocumentClass;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnaldDocumentClass")
    private List<CnalpDocumentModel> cnalpDocumentModels;
    @OneToMany(mappedBy = "cnaldDocumentClass", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrDocumentClassL> cnalrDocumentClassLs;

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

    public Date getDoclDaEndValidity() {
        if (this.doclDaEndValidity != null)
            return (Date) this.doclDaEndValidity.clone();
        else
            return null;
    }

    public void setDoclDaEndValidity(Date doclDaEndValidity) {
        if (doclDaEndValidity != null)
            this.doclDaEndValidity = (Date) doclDaEndValidity.clone();
        else
            this.doclDaEndValidity = doclDaEndValidity;
    }

    public Date getDoclDaStartValidity() {
        if (this.doclDaStartValidity != null)
            return (Date) this.doclDaStartValidity.clone();
        else
            return null;
    }

    public void setDoclDaStartValidity(Date doclDaStartValidity) {
        if (doclDaStartValidity != null)
            this.doclDaStartValidity = (Date) doclDaStartValidity.clone();
        else
            this.doclDaStartValidity = doclDaStartValidity;
    }

    public Long getDoclIdDocumentClass() {
        return this.doclIdDocumentClass;
    }

    public void setDoclIdDocumentClass(Long doclIdDocumentClass) {
        this.doclIdDocumentClass = doclIdDocumentClass;
    }

    public String getLdclNaDocumentClass() {
        return this.ldclNaDocumentClass;
    }

    public void setLdclNaDocumentClass(String ldclNaDocumentClass) {
        this.ldclNaDocumentClass = ldclNaDocumentClass;
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

    public List<CnalpDocumentModel> getCnalpDocumentModels() {
        return this.cnalpDocumentModels;
    }

    public void setCnalpDocumentModels(List<CnalpDocumentModel> cnalpDocumentModels) {
        this.cnalpDocumentModels = cnalpDocumentModels;
    }

    public void addCnalpDocumentModels(CnalpDocumentModel cnalpDocumentModel) {
        if (this.cnalpDocumentModels == null)
            this.cnalpDocumentModels = new ArrayList<CnalpDocumentModel>();
        this.cnalpDocumentModels.add(cnalpDocumentModel);
    }

    public void removeCnalpDocumentModels(CnalpDocumentModel cnalpDocumentModelToRemove) {
        if (cnalpDocumentModelToRemove != null)
            this.cnalpDocumentModels.remove(cnalpDocumentModelToRemove);
    }

    public List<CnalrDocumentClassL> getCnalrDocumentClassLs() {
        return this.cnalrDocumentClassLs;
    }

    public void setCnalrDocumentClassLs(List<CnalrDocumentClassL> cnalrDocumentClassLs) {
        this.cnalrDocumentClassLs = cnalrDocumentClassLs;
    }

    public void addCnalrDocumentClassLs(CnalrDocumentClassL cnalrDocumentClassL) {
        if (this.cnalrDocumentClassLs == null)
            this.cnalrDocumentClassLs = new ArrayList<CnalrDocumentClassL>();
        this.cnalrDocumentClassLs.add(cnalrDocumentClassL);
    }

    public void removeCnalrDocumentClassLs(CnalrDocumentClassL cnalrDocumentClassLToRemove) {
        if (cnalrDocumentClassLToRemove != null)
            this.cnalrDocumentClassLs.remove(cnalrDocumentClassLToRemove);
    }

}
