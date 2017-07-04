package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the CnalpProcessDefinitionS database table.
 */
@Entity
@NamedQuery(name = "CnalpProcessDefinition.findAll", query = "SELECT c FROM CnalpProcessDefinition c")
@Table(name = "CNALP_PROCESS_DEFINITION")
public class CnalpProcessDefinition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "EXPD_DO_JSON_OBJECT")
    @Lob
    private String expdDoJsonObject;

    @Column(name = "EXPD_IN_PROCESS_CLASS", precision = 1)
    private Long expdInProcessClass;

    @Column(length = 200, name = "EXPL_DS_PROCESS_OPERATIVE")
    private String explDsProcessOperative;

    @Column(name = "FELE_ID_FINAL_ELEMENT", precision = 4)
    private Long feleIdFinalElement;

    @Column(length = 100, name = "LPRD_DS_PROCESS_DEFINITION", nullable = false)
    private String lprdDsProcessDefinition;

    @Column(name = "PRDE_DA_START_VALIDITY", nullable = false)
    private Timestamp prdeDaStartValidity;

    @Column(name = "PRDE_ID_PROCESS_DEFINITION", nullable = false, precision = 6, unique = true)
    @GeneratedValue(generator = "CNALP_PROCESS_DEFINITION_PRDEIDPROCESSDEFINITION_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALP_PROCESS_DEFINITION_PRDEIDPROCESSDEFINITION_GENERATOR", sequenceName = "CNAL_PROCESS_DEF_SEQ")
    private Long prdeIdProcessDefinition;

    @Column(name = "PRDE_IN_PROCESS_TYPE", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean prdeInProcessType;

    @Column(length = 200, name = "PRDE_NO_LINK")
    private String prdeNoLink;

    @Column(name = "PROS_DA_END_VALIDITY")
    private Timestamp prosDaEndValidity;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "PRDE_ID_PROCESS_DEF_SUPPORT")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpProcessDefinition cnalpProcessDefinition;
    @OneToMany(mappedBy = "cnalpProcessDefinition")
    private List<CnalpProcessDefinition> cnalpProcessDefinitions;
    @OneToMany(mappedBy = "cnalpProcessDefinition")
    private List<CnalrCisDefaultExecProcess> cnalrCisDefaultExecProcesses;
    @OneToMany(mappedBy = "cnalpProcessDefinition")
    private List<CnalrFuncPoolSpecProcess> cnalrFuncPoolSpecProcesses;
    @OneToMany(mappedBy = "cnalpProcessDefinition", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrProcessDefinitionL> cnalrProcessDefinitionLs;
    @OneToMany(mappedBy = "cnalpProcessDefinition", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<PrderExecProcInvRoleType> prderExecProcInvRoleTypes;

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

    public String getExpdDoJsonObject() {
        return this.expdDoJsonObject;
    }

    public void setExpdDoJsonObject(String expdDoJsonObject) {
        this.expdDoJsonObject = expdDoJsonObject;
    }

    public Long getExpdInProcessClass() {
        return this.expdInProcessClass;
    }

    public void setExpdInProcessClass(Long expdInProcessClass) {
        this.expdInProcessClass = expdInProcessClass;
    }

    public String getExplDsProcessOperative() {
        return this.explDsProcessOperative;
    }

    public void setExplDsProcessOperative(String explDsProcessOperative) {
        this.explDsProcessOperative = explDsProcessOperative;
    }

    public Long getFeleIdFinalElement() {
        return this.feleIdFinalElement;
    }

    public void setFeleIdFinalElement(Long feleIdFinalElement) {
        this.feleIdFinalElement = feleIdFinalElement;
    }

    public String getLprdDsProcessDefinition() {
        return this.lprdDsProcessDefinition;
    }

    public void setLprdDsProcessDefinition(String lprdDsProcessDefinition) {
        this.lprdDsProcessDefinition = lprdDsProcessDefinition;
    }

    public Timestamp getPrdeDaStartValidity() {
        if (this.prdeDaStartValidity != null)
            return (Timestamp) this.prdeDaStartValidity.clone();
        else
            return null;
    }

    public void setPrdeDaStartValidity(Timestamp prdeDaStartValidity) {
        if (prdeDaStartValidity != null)
            this.prdeDaStartValidity = (Timestamp) prdeDaStartValidity.clone();
        else
            this.prdeDaStartValidity = prdeDaStartValidity;
    }

    public Long getPrdeIdProcessDefinition() {
        return this.prdeIdProcessDefinition;
    }

    public void setPrdeIdProcessDefinition(Long prdeIdProcessDefinition) {
        this.prdeIdProcessDefinition = prdeIdProcessDefinition;
    }

    public Boolean getPrdeInProcessType() {
        return this.prdeInProcessType;
    }

    public void setPrdeInProcessType(Boolean prdeInProcessType) {
        this.prdeInProcessType = prdeInProcessType;
    }

    public String getPrdeNoLink() {
        return this.prdeNoLink;
    }

    public void setPrdeNoLink(String prdeNoLink) {
        this.prdeNoLink = prdeNoLink;
    }

    public Timestamp getProsDaEndValidity() {
        if (this.prosDaEndValidity != null)
            return (Timestamp) this.prosDaEndValidity.clone();
        else
            return null;
    }

    public void setProsDaEndValidity(Timestamp prosDaEndValidity) {
        if (prosDaEndValidity != null)
            this.prosDaEndValidity = (Timestamp) prosDaEndValidity.clone();
        else
            this.prosDaEndValidity = prosDaEndValidity;
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

    public CnalpProcessDefinition getCnalpProcessDefinition() {
        return this.cnalpProcessDefinition;
    }

    public void setCnalpProcessDefinition(CnalpProcessDefinition cnalpProcessDefinition) {
        this.cnalpProcessDefinition = cnalpProcessDefinition;
    }

    public List<CnalpProcessDefinition> getCnalpProcessDefinitions() {
        return this.cnalpProcessDefinitions;
    }

    public void setCnalpProcessDefinitions(List<CnalpProcessDefinition> cnalpProcessDefinitions) {
        this.cnalpProcessDefinitions = cnalpProcessDefinitions;
    }

    public void addCnalpProcessDefinitions(CnalpProcessDefinition cnalpProcessDefinition) {
        if (this.cnalpProcessDefinitions == null)
            this.cnalpProcessDefinitions = new ArrayList<CnalpProcessDefinition>();
        this.cnalpProcessDefinitions.add(cnalpProcessDefinition);
    }

    public void removeCnalpProcessDefinitions(CnalpProcessDefinition cnalpProcessDefinitionToRemove) {
        if (cnalpProcessDefinitionToRemove != null)
            this.cnalpProcessDefinitions.remove(cnalpProcessDefinitionToRemove);
    }

    public List<CnalrCisDefaultExecProcess> getCnalrCisDefaultExecProcesses() {
        return this.cnalrCisDefaultExecProcesses;
    }

    public void setCnalrCisDefaultExecProcesses(List<CnalrCisDefaultExecProcess> cnalrCisDefaultExecProcesses) {
        this.cnalrCisDefaultExecProcesses = cnalrCisDefaultExecProcesses;
    }

    public void addCnalrCisDefaultExecProcesses(CnalrCisDefaultExecProcess cnalrCisDefaultExecProcess) {
        if (this.cnalrCisDefaultExecProcesses == null)
            this.cnalrCisDefaultExecProcesses = new ArrayList<CnalrCisDefaultExecProcess>();
        this.cnalrCisDefaultExecProcesses.add(cnalrCisDefaultExecProcess);
    }

    public void removeCnalrCisDefaultExecProcesses(CnalrCisDefaultExecProcess cnalrCisDefaultExecProcessToRemove) {
        if (cnalrCisDefaultExecProcessToRemove != null)
            this.cnalrCisDefaultExecProcesses.remove(cnalrCisDefaultExecProcessToRemove);
    }

    public List<CnalrFuncPoolSpecProcess> getCnalrFuncPoolSpecProcesses() {
        return this.cnalrFuncPoolSpecProcesses;
    }

    public void setCnalrFuncPoolSpecProcesses(List<CnalrFuncPoolSpecProcess> cnalrFuncPoolSpecProcesses) {
        this.cnalrFuncPoolSpecProcesses = cnalrFuncPoolSpecProcesses;
    }

    public void addCnalrFuncPoolSpecProcesses(CnalrFuncPoolSpecProcess cnalrFuncPoolSpecProcess) {
        if (this.cnalrFuncPoolSpecProcesses == null)
            this.cnalrFuncPoolSpecProcesses = new ArrayList<CnalrFuncPoolSpecProcess>();
        this.cnalrFuncPoolSpecProcesses.add(cnalrFuncPoolSpecProcess);
    }

    public void removeCnalrFuncPoolSpecProcesses(CnalrFuncPoolSpecProcess cnalrFuncPoolSpecProcessToRemove) {
        if (cnalrFuncPoolSpecProcessToRemove != null)
            this.cnalrFuncPoolSpecProcesses.remove(cnalrFuncPoolSpecProcessToRemove);
    }

    public List<CnalrProcessDefinitionL> getCnalrProcessDefinitionLs() {
        return this.cnalrProcessDefinitionLs;
    }

    public void setCnalrProcessDefinitionLs(List<CnalrProcessDefinitionL> cnalrProcessDefinitionLs) {
        this.cnalrProcessDefinitionLs = cnalrProcessDefinitionLs;
    }

    public void addCnalrProcessDefinitionLs(CnalrProcessDefinitionL cnalrProcessDefinitionL) {
        if (this.cnalrProcessDefinitionLs == null)
            this.cnalrProcessDefinitionLs = new ArrayList<CnalrProcessDefinitionL>();
        this.cnalrProcessDefinitionLs.add(cnalrProcessDefinitionL);
    }

    public void removeCnalrProcessDefinitionLs(CnalrProcessDefinitionL cnalrProcessDefinitionLToRemove) {
        if (cnalrProcessDefinitionLToRemove != null)
            this.cnalrProcessDefinitionLs.remove(cnalrProcessDefinitionLToRemove);
    }

    public List<PrderExecProcInvRoleType> getPrderExecProcInvRoleTypes() {
        return this.prderExecProcInvRoleTypes;
    }

    public void setPrderExecProcInvRoleTypes(List<PrderExecProcInvRoleType> prderExecProcInvRoleTypes) {
        this.prderExecProcInvRoleTypes = prderExecProcInvRoleTypes;
    }

    public void addPrderExecProcInvRoleTypes(PrderExecProcInvRoleType prderExecProcInvRoleType) {
        if (this.prderExecProcInvRoleTypes == null)
            this.prderExecProcInvRoleTypes = new ArrayList<PrderExecProcInvRoleType>();
        this.prderExecProcInvRoleTypes.add(prderExecProcInvRoleType);
    }

    public void removePrderExecProcInvRoleTypes(PrderExecProcInvRoleType prderExecProcInvRoleTypeToRemove) {
        if (prderExecProcInvRoleTypeToRemove != null)
            this.prderExecProcInvRoleTypes.remove(prderExecProcInvRoleTypeToRemove);
    }

}
