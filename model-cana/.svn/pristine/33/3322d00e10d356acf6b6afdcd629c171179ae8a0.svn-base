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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CnaldPhysicalPhoneProfileS database table.
 */
@Entity
@NamedQuery(name = "CnaldPhysicalPhoneProfile.findAll", query = "SELECT c FROM CnaldPhysicalPhoneProfile c")
@Table(name = "CNALD_PHYSICAL_PHONE_PROFILE")
public class CnaldPhysicalPhoneProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "PARO_ID_ORGANIZATION_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdOrganizationRole;

    @Column(length = 4, name = "PPPR_CO_PHYSICAL_PHONE_PROFILE", nullable = false)
    private String ppprCoPhysicalPhoneProfile;

    @Column(columnDefinition = "DATE", name = "PPPR_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date ppprDaEndValidity;

    @Column(columnDefinition = "DATE", name = "PPPR_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date ppprDaStartValidity;

    @Column(name = "PPPR_ID_PHYSICAL_PHONE_PROFILE", nullable = false, precision = 4, unique = true)
    @GeneratedValue(generator = "CNALD_PHYSICAL_PHONE_PROFILE_PPPRIDPHYSICALPHONEPROFILE_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALD_PHYSICAL_PHONE_PROFILE_PPPRIDPHYSICALPHONEPROFILE_GENERATOR", sequenceName = "CNAL_PHYS_PHONE_PROFILE_SEQ")
    private Long ppprIdPhysicalPhoneProfile;

    @Column(length = 75, name = "PPPR_NA_PHY_PHONE_PROFILE", nullable = false, unique = true)
    private String ppprNaPhyPhoneProfile;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "COPA_ID_COMMUNICATION_PATTERN")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldCommunicationPattern cnaldCommunicationPattern;
    @OneToMany(mappedBy = "cnaldPhysicalPhoneProfile")
    private List<CnalrPhoneSkillPhyProfile> cnalrPhoneSkillPhyProfiles;

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

    public BigDecimal getParoIdOrganizationRole() {
        return this.paroIdOrganizationRole;
    }

    public void setParoIdOrganizationRole(BigDecimal paroIdOrganizationRole) {
        this.paroIdOrganizationRole = paroIdOrganizationRole;
    }

    public String getPpprCoPhysicalPhoneProfile() {
        return this.ppprCoPhysicalPhoneProfile;
    }

    public void setPpprCoPhysicalPhoneProfile(String ppprCoPhysicalPhoneProfile) {
        this.ppprCoPhysicalPhoneProfile = ppprCoPhysicalPhoneProfile;
    }

    public Date getPpprDaEndValidity() {
        if (this.ppprDaEndValidity != null)
            return (Date) this.ppprDaEndValidity.clone();
        else
            return null;
    }

    public void setPpprDaEndValidity(Date ppprDaEndValidity) {
        if (ppprDaEndValidity != null)
            this.ppprDaEndValidity = (Date) ppprDaEndValidity.clone();
        else
            this.ppprDaEndValidity = ppprDaEndValidity;
    }

    public Date getPpprDaStartValidity() {
        if (this.ppprDaStartValidity != null)
            return (Date) this.ppprDaStartValidity.clone();
        else
            return null;
    }

    public void setPpprDaStartValidity(Date ppprDaStartValidity) {
        if (ppprDaStartValidity != null)
            this.ppprDaStartValidity = (Date) ppprDaStartValidity.clone();
        else
            this.ppprDaStartValidity = ppprDaStartValidity;
    }

    public Long getPpprIdPhysicalPhoneProfile() {
        return this.ppprIdPhysicalPhoneProfile;
    }

    public void setPpprIdPhysicalPhoneProfile(Long ppprIdPhysicalPhoneProfile) {
        this.ppprIdPhysicalPhoneProfile = ppprIdPhysicalPhoneProfile;
    }

    public String getPpprNaPhyPhoneProfile() {
        return this.ppprNaPhyPhoneProfile;
    }

    public void setPpprNaPhyPhoneProfile(String ppprNaPhyPhoneProfile) {
        this.ppprNaPhyPhoneProfile = ppprNaPhyPhoneProfile;
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

    public CnaldCommunicationPattern getCnaldCommunicationPattern() {
        return this.cnaldCommunicationPattern;
    }

    public void setCnaldCommunicationPattern(CnaldCommunicationPattern cnaldCommunicationPattern) {
        this.cnaldCommunicationPattern = cnaldCommunicationPattern;
    }

    public List<CnalrPhoneSkillPhyProfile> getCnalrPhoneSkillPhyProfiles() {
        return this.cnalrPhoneSkillPhyProfiles;
    }

    public void setCnalrPhoneSkillPhyProfiles(List<CnalrPhoneSkillPhyProfile> cnalrPhoneSkillPhyProfiles) {
        this.cnalrPhoneSkillPhyProfiles = cnalrPhoneSkillPhyProfiles;
    }

    public void addCnalrPhoneSkillPhyProfiles(CnalrPhoneSkillPhyProfile cnalrPhoneSkillPhyProfile) {
        if (this.cnalrPhoneSkillPhyProfiles == null)
            this.cnalrPhoneSkillPhyProfiles = new ArrayList<CnalrPhoneSkillPhyProfile>();
        this.cnalrPhoneSkillPhyProfiles.add(cnalrPhoneSkillPhyProfile);
    }

    public void removeCnalrPhoneSkillPhyProfiles(CnalrPhoneSkillPhyProfile cnalrPhoneSkillPhyProfileToRemove) {
        if (cnalrPhoneSkillPhyProfileToRemove != null)
            this.cnalrPhoneSkillPhyProfiles.remove(cnalrPhoneSkillPhyProfileToRemove);
    }

}
