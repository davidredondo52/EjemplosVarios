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
 * The persistent class for the CnalpFunctionalPoolSpecS database table.
 */
@Entity
@NamedQuery(name = "CnalpFunctionalPoolSpec.findAll", query = "SELECT c FROM CnalpFunctionalPoolSpec c")
@Table(name = "CNALP_FUNCTIONAL_POOL_SPEC")
public class CnalpFunctionalPoolSpec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "FUPS_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fupsDaEndValidity;

    @Column(columnDefinition = "DATE", name = "FUPS_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date fupsDaStartValidity;

    @Column(name = "FUPS_ID_FUNCTIONAL_POOL_SPEC", nullable = false, precision = 4, unique = true)
    @GeneratedValue(generator = "CNALP_FUNCTIONAL_POOL_SPEC_FUPSIDFUNCTIONALPOOLSPEC_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALP_FUNCTIONAL_POOL_SPEC_FUPSIDFUNCTIONALPOOLSPEC_GENERATOR", sequenceName = "CNAL_FUNCTIONAL_POOL_SPEC_SEQ")
    private Long fupsIdFunctionalPoolSpec;

    @Column(length = 200, name = "LFPS_DS_FUNCTIONAL_POOL_SPEC", nullable = false)
    private String lfpsDsFunctionalPoolSpec;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnalpFunctionalPoolSpec")
    private List<CnalpFunctionalPool> cnalpFunctionalPools;
    @OneToMany(mappedBy = "cnalpFunctionalPoolSpec", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrFuncPoolSpChannelTy> cnalrFuncPoolSpChannelTies;
    @OneToMany(mappedBy = "cnalpFunctionalPoolSpec", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrFuncPoolSpEnteFunct> cnalrFuncPoolSpEnteFuncts;
    @OneToMany(mappedBy = "cnalpFunctionalPoolSpec", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrFuncPoolSpInquSpec> cnalrFuncPoolSpInquSpecs;
    @OneToMany(mappedBy = "cnalpFunctionalPoolSpec", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrFunctionalPoolSpecL> cnalrFunctionalPoolSpecLs;

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

    public Date getFupsDaEndValidity() {
        if (this.fupsDaEndValidity != null)
            return (Date) this.fupsDaEndValidity.clone();
        else
            return null;
    }

    public void setFupsDaEndValidity(Date fupsDaEndValidity) {
        if (fupsDaEndValidity != null)
            this.fupsDaEndValidity = (Date) fupsDaEndValidity.clone();
        else
            this.fupsDaEndValidity = fupsDaEndValidity;
    }

    public Date getFupsDaStartValidity() {
        if (this.fupsDaStartValidity != null)
            return (Date) this.fupsDaStartValidity.clone();
        else
            return null;
    }

    public void setFupsDaStartValidity(Date fupsDaStartValidity) {
        if (fupsDaStartValidity != null)
            this.fupsDaStartValidity = (Date) fupsDaStartValidity.clone();
        else
            this.fupsDaStartValidity = fupsDaStartValidity;
    }

    public Long getFupsIdFunctionalPoolSpec() {
        return this.fupsIdFunctionalPoolSpec;
    }

    public void setFupsIdFunctionalPoolSpec(Long fupsIdFunctionalPoolSpec) {
        this.fupsIdFunctionalPoolSpec = fupsIdFunctionalPoolSpec;
    }

    public String getLfpsDsFunctionalPoolSpec() {
        return this.lfpsDsFunctionalPoolSpec;
    }

    public void setLfpsDsFunctionalPoolSpec(String lfpsDsFunctionalPoolSpec) {
        this.lfpsDsFunctionalPoolSpec = lfpsDsFunctionalPoolSpec;
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

    public List<CnalrFuncPoolSpEnteFunct> getCnalrFuncPoolSpEnteFuncts() {
        return this.cnalrFuncPoolSpEnteFuncts;
    }

    public void setCnalrFuncPoolSpEnteFuncts(List<CnalrFuncPoolSpEnteFunct> cnalrFuncPoolSpEnteFuncts) {
        this.cnalrFuncPoolSpEnteFuncts = cnalrFuncPoolSpEnteFuncts;
    }

    public void addCnalrFuncPoolSpEnteFuncts(CnalrFuncPoolSpEnteFunct cnalrFuncPoolSpEnteFunct) {
        if (this.cnalrFuncPoolSpEnteFuncts == null)
            this.cnalrFuncPoolSpEnteFuncts = new ArrayList<CnalrFuncPoolSpEnteFunct>();
        this.cnalrFuncPoolSpEnteFuncts.add(cnalrFuncPoolSpEnteFunct);
    }

    public void removeCnalrFuncPoolSpEnteFuncts(CnalrFuncPoolSpEnteFunct cnalrFuncPoolSpEnteFunctToRemove) {
        if (cnalrFuncPoolSpEnteFunctToRemove != null)
            this.cnalrFuncPoolSpEnteFuncts.remove(cnalrFuncPoolSpEnteFunctToRemove);
    }

    public List<CnalrFuncPoolSpInquSpec> getCnalrFuncPoolSpInquSpecs() {
        return this.cnalrFuncPoolSpInquSpecs;
    }

    public void setCnalrFuncPoolSpInquSpecs(List<CnalrFuncPoolSpInquSpec> cnalrFuncPoolSpInquSpecs) {
        this.cnalrFuncPoolSpInquSpecs = cnalrFuncPoolSpInquSpecs;
    }

    public void addCnalrFuncPoolSpInquSpecs(CnalrFuncPoolSpInquSpec cnalrFuncPoolSpInquSpec) {
        if (this.cnalrFuncPoolSpInquSpecs == null)
            this.cnalrFuncPoolSpInquSpecs = new ArrayList<CnalrFuncPoolSpInquSpec>();
        this.cnalrFuncPoolSpInquSpecs.add(cnalrFuncPoolSpInquSpec);
    }

    public void removeCnalrFuncPoolSpInquSpecs(CnalrFuncPoolSpInquSpec cnalrFuncPoolSpInquSpecToRemove) {
        if (cnalrFuncPoolSpInquSpecToRemove != null)
            this.cnalrFuncPoolSpInquSpecs.remove(cnalrFuncPoolSpInquSpecToRemove);
    }

    public List<CnalrFunctionalPoolSpecL> getCnalrFunctionalPoolSpecLs() {
        return this.cnalrFunctionalPoolSpecLs;
    }

    public void setCnalrFunctionalPoolSpecLs(List<CnalrFunctionalPoolSpecL> cnalrFunctionalPoolSpecLs) {
        this.cnalrFunctionalPoolSpecLs = cnalrFunctionalPoolSpecLs;
    }

    public void addCnalrFunctionalPoolSpecLs(CnalrFunctionalPoolSpecL cnalrFunctionalPoolSpecL) {
        if (this.cnalrFunctionalPoolSpecLs == null)
            this.cnalrFunctionalPoolSpecLs = new ArrayList<CnalrFunctionalPoolSpecL>();
        this.cnalrFunctionalPoolSpecLs.add(cnalrFunctionalPoolSpecL);
    }

    public void removeCnalrFunctionalPoolSpecLs(CnalrFunctionalPoolSpecL cnalrFunctionalPoolSpecLToRemove) {
        if (cnalrFunctionalPoolSpecLToRemove != null)
            this.cnalrFunctionalPoolSpecLs.remove(cnalrFunctionalPoolSpecLToRemove);
    }

}
