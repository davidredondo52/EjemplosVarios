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
 * The persistent class for the CnaldCommunicationPatternS database table.
 */
@Entity
@NamedQuery(name = "CnaldCommunicationPattern.findAll", query = "SELECT c FROM CnaldCommunicationPattern c")
@Table(name = "CNALD_COMMUNICATION_PATTERN")
public class CnaldCommunicationPattern implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "COPA_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date copaDaEndValidity;

    @Column(columnDefinition = "DATE", name = "COPA_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date copaDaStartValidity;

    @Column(name = "COPA_ID_COMMUNICATION_PATTERN", nullable = false, precision = 3, unique = true)
    @GeneratedValue(generator = "CNALD_COMMUNICATION_PATTERN_COPAIDCOMMUNICATIONPATTERN_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALD_COMMUNICATION_PATTERN_COPAIDCOMMUNICATIONPATTERN_GENERATOR", sequenceName = "CNAL_COMMUNICAT_PATTERN_SEQ")
    private Long copaIdCommunicationPattern;

    @Column(name = "COPA_IN_COMMUNICATION_TYPE", nullable = false, precision = 1)
    private Long copaInCommunicationType;

    @Column(name = "COPA_IN_WORK_MODE", nullable = false, precision = 1)
    private Long copaInWorkMode;

    @Column(length = 75, name = "LCPA_DS_COMMUNICATION_PATTERN", nullable = false)
    private String lcpaDsCommunicationPattern;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnaldCommunicationPattern", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnaldPhysicalPhoneProfile> cnaldPhysicalPhoneProfiles;
    @OneToMany(mappedBy = "cnaldCommunicationPattern")
    private List<CnalpFunctionalPool> cnalpFunctionalPools;
    @OneToMany(mappedBy = "cnaldCommunicationPattern", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrCommunicationPatternL> cnalrCommunicationPatternLs;

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

    public Date getCopaDaEndValidity() {
        if (this.copaDaEndValidity != null)
            return (Date) this.copaDaEndValidity.clone();
        else
            return null;
    }

    public void setCopaDaEndValidity(Date copaDaEndValidity) {
        if (copaDaEndValidity != null)
            this.copaDaEndValidity = (Date) copaDaEndValidity.clone();
        else
            this.copaDaEndValidity = copaDaEndValidity;
    }

    public Date getCopaDaStartValidity() {
        if (this.copaDaStartValidity != null)
            return (Date) this.copaDaStartValidity.clone();
        else
            return null;
    }

    public void setCopaDaStartValidity(Date copaDaStartValidity) {
        if (copaDaStartValidity != null)
            this.copaDaStartValidity = (Date) copaDaStartValidity.clone();
        else
            this.copaDaStartValidity = copaDaStartValidity;
    }

    public Long getCopaIdCommunicationPattern() {
        return this.copaIdCommunicationPattern;
    }

    public void setCopaIdCommunicationPattern(Long copaIdCommunicationPattern) {
        this.copaIdCommunicationPattern = copaIdCommunicationPattern;
    }

    public Long getCopaInCommunicationType() {
        return this.copaInCommunicationType;
    }

    public void setCopaInCommunicationType(Long copaInCommunicationType) {
        this.copaInCommunicationType = copaInCommunicationType;
    }

    public Long getCopaInWorkMode() {
        return this.copaInWorkMode;
    }

    public void setCopaInWorkMode(Long copaInWorkMode) {
        this.copaInWorkMode = copaInWorkMode;
    }

    public String getLcpaDsCommunicationPattern() {
        return this.lcpaDsCommunicationPattern;
    }

    public void setLcpaDsCommunicationPattern(String lcpaDsCommunicationPattern) {
        this.lcpaDsCommunicationPattern = lcpaDsCommunicationPattern;
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

    public List<CnaldPhysicalPhoneProfile> getCnaldPhysicalPhoneProfiles() {
        return this.cnaldPhysicalPhoneProfiles;
    }

    public void setCnaldPhysicalPhoneProfiles(List<CnaldPhysicalPhoneProfile> cnaldPhysicalPhoneProfiles) {
        this.cnaldPhysicalPhoneProfiles = cnaldPhysicalPhoneProfiles;
    }

    public void addCnaldPhysicalPhoneProfiles(CnaldPhysicalPhoneProfile cnaldPhysicalPhoneProfile) {
        if (this.cnaldPhysicalPhoneProfiles == null)
            this.cnaldPhysicalPhoneProfiles = new ArrayList<CnaldPhysicalPhoneProfile>();
        this.cnaldPhysicalPhoneProfiles.add(cnaldPhysicalPhoneProfile);
    }

    public void removeCnaldPhysicalPhoneProfiles(CnaldPhysicalPhoneProfile cnaldPhysicalPhoneProfileToRemove) {
        if (cnaldPhysicalPhoneProfileToRemove != null)
            this.cnaldPhysicalPhoneProfiles.remove(cnaldPhysicalPhoneProfileToRemove);
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

    public List<CnalrCommunicationPatternL> getCnalrCommunicationPatternLs() {
        return this.cnalrCommunicationPatternLs;
    }

    public void setCnalrCommunicationPatternLs(List<CnalrCommunicationPatternL> cnalrCommunicationPatternLs) {
        this.cnalrCommunicationPatternLs = cnalrCommunicationPatternLs;
    }

    public void addCnalrCommunicationPatternLs(CnalrCommunicationPatternL cnalrCommunicationPatternL) {
        if (this.cnalrCommunicationPatternLs == null)
            this.cnalrCommunicationPatternLs = new ArrayList<CnalrCommunicationPatternL>();
        this.cnalrCommunicationPatternLs.add(cnalrCommunicationPatternL);
    }

    public void removeCnalrCommunicationPatternLs(CnalrCommunicationPatternL cnalrCommunicationPatternLToRemove) {
        if (cnalrCommunicationPatternLToRemove != null)
            this.cnalrCommunicationPatternLs.remove(cnalrCommunicationPatternLToRemove);
    }

}
