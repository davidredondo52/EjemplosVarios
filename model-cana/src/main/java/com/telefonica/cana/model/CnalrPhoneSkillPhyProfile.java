package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the CnalrPhoneSkillPhyProfileS database table.
 */
@Entity
@NamedQuery(name = "CnalrPhoneSkillPhyProfile.findAll", query = "SELECT c FROM CnalrPhoneSkillPhyProfile c")
@Table(name = "CNALR_PHONE_SKILL_PHY_PROFILE", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "PPPR_ID_PHYSICAL_PHONE_PROFILE", "PHSK_CO_SKILL" }) })
public class CnalrPhoneSkillPhyProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "PHSK_CO_SKILL", nullable = false, precision = 4)
    private Long phskCoSkill;

    @Column(name = "PSPP_ID_PHONE_SKILL_PHY_PROF", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal psppIdPhoneSkillPhyProf;

    @Column(name = "PSPP_NU_ABILITY_LEVEL", nullable = false, precision = 1)
    private Long psppNuAbilityLevel;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "PPPR_ID_PHYSICAL_PHONE_PROFILE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldPhysicalPhoneProfile cnaldPhysicalPhoneProfile;

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

    public Long getPhskCoSkill() {
        return this.phskCoSkill;
    }

    public void setPhskCoSkill(Long phskCoSkill) {
        this.phskCoSkill = phskCoSkill;
    }

    public BigDecimal getPsppIdPhoneSkillPhyProf() {
        return this.psppIdPhoneSkillPhyProf;
    }

    public void setPsppIdPhoneSkillPhyProf(BigDecimal psppIdPhoneSkillPhyProf) {
        this.psppIdPhoneSkillPhyProf = psppIdPhoneSkillPhyProf;
    }

    public Long getPsppNuAbilityLevel() {
        return this.psppNuAbilityLevel;
    }

    public void setPsppNuAbilityLevel(Long psppNuAbilityLevel) {
        this.psppNuAbilityLevel = psppNuAbilityLevel;
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

    public CnaldPhysicalPhoneProfile getCnaldPhysicalPhoneProfile() {
        return this.cnaldPhysicalPhoneProfile;
    }

    public void setCnaldPhysicalPhoneProfile(CnaldPhysicalPhoneProfile cnaldPhysicalPhoneProfile) {
        this.cnaldPhysicalPhoneProfile = cnaldPhysicalPhoneProfile;
    }

}
