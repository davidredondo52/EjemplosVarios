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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the CnalpFunctionalPoolS database table.
 */
@Entity
@NamedQuery(name = "CnalpFunctionalPool.findAll", query = "SELECT c FROM CnalpFunctionalPool c")
@Table(name = "CNALP_FUNCTIONAL_POOL")
public class CnalpFunctionalPool implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "FUPO_IN_MAILBOX_STATE", nullable = false, precision = 1)
    private Long fupoInMailboxState;

    @Column(name = "FUPO_IN_POOL_TYPE", nullable = false, precision = 1)
    private Long fupoInPoolType;

    @Column(name = "FUPO_IN_WORK_MODE", nullable = false, precision = 1)
    private Long fupoInWorkMode;

    @Column(length = 80, name = "FUPO_NA_FUNCTIONAL_POOL", nullable = false)
    private String fupoNaFunctionalPool;

    @Column(name = "FUPO_NU_SUPPORT", precision = 9)
    private Long fupoNuSupport;

    @Column(name = "FUPO_TI_END_VALIDITY")
    private Timestamp fupoTiEndValidity;

    @Column(name = "FUPO_TI_START_VALIDITY", nullable = false)
    private Timestamp fupoTiStartValidity;

    @Column(length = 200, name = "LFPO_DS_FUNCTIONAL_POOL", nullable = false)
    private String lfpoDsFunctionalPool;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @Column(name = "WPOO_ID_FUNCTIONAL_POOL", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal wpooIdFunctionalPool;

    @JoinColumn(name = "EFTN_ID_ENTE_FUNC_TREE_NODE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaEnteFunctionTreeNode cnalaEnteFunctionTreeNode;
    @OneToMany(mappedBy = "cnalpFunctionalPool")
    private List<CnalaTaskMailbox> cnalaTaskMailboxs;
    @JoinColumn(name = "COPA_ID_COMMUNICATION_PATTERN")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldCommunicationPattern cnaldCommunicationPattern;
    @JoinColumn(name = "SCHA_ID_SALES_CHANNEL")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldSalesChannel cnaldSalesChannel;
    @OneToMany(mappedBy = "cnalpFunctionalPool")
    private List<CnalpFuncPoolAssignment> cnalpFuncPoolAssignments;
    @JoinColumn(name = "FUPS_ID_FUNTIONAL_POOL_SPEC")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpFunctionalPoolSpec cnalpFunctionalPoolSpec;
    @OneToMany(mappedBy = "cnalpFunctionalPool")
    private List<CnalpToolAssignment> cnalpToolAssignments;
    @OneToMany(mappedBy = "cnalpFunctionalPool", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrFuncPoolMarketSegment> cnalrFuncPoolMarketSegments;
    @OneToMany(mappedBy = "cnalpFunctionalPool", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrFuncPoolProdCatalog> cnalrFuncPoolProdCatalogs;
    @OneToMany(mappedBy = "cnalpFunctionalPool", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrFuncPoolResourceSpec> cnalrFuncPoolResourceSpecs;
    @OneToMany(mappedBy = "cnalpFunctionalPool", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrFuncPoolServiceSpec> cnalrFuncPoolServiceSpecs;
    @JoinColumn(name = "PSCT_ID_FUNC_POOL_SP_CHAN_TY")
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private CnalrFuncPoolSpChannelTy cnalrFuncPoolSpChannelTy;
    @OneToMany(mappedBy = "cnalpFunctionalPool", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrFunctionalPoolL> cnalrFunctionalPoolLs;
    @OneToMany(mappedBy = "cnalpFunctionalPool")
    private List<CnalrOrgaPoolAssignment> cnalrOrgaPoolAssignments;

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

    public Long getFupoInMailboxState() {
        return this.fupoInMailboxState;
    }

    public void setFupoInMailboxState(Long fupoInMailboxState) {
        this.fupoInMailboxState = fupoInMailboxState;
    }

    public Long getFupoInPoolType() {
        return this.fupoInPoolType;
    }

    public void setFupoInPoolType(Long fupoInPoolType) {
        this.fupoInPoolType = fupoInPoolType;
    }

    public Long getFupoInWorkMode() {
        return this.fupoInWorkMode;
    }

    public void setFupoInWorkMode(Long fupoInWorkMode) {
        this.fupoInWorkMode = fupoInWorkMode;
    }

    public String getFupoNaFunctionalPool() {
        return this.fupoNaFunctionalPool;
    }

    public void setFupoNaFunctionalPool(String fupoNaFunctionalPool) {
        this.fupoNaFunctionalPool = fupoNaFunctionalPool;
    }

    public Long getFupoNuSupport() {
        return this.fupoNuSupport;
    }

    public void setFupoNuSupport(Long fupoNuSupport) {
        this.fupoNuSupport = fupoNuSupport;
    }

    public Timestamp getFupoTiEndValidity() {
        if (this.fupoTiEndValidity != null)
            return (Timestamp) this.fupoTiEndValidity.clone();
        else
            return null;
    }

    public void setFupoTiEndValidity(Timestamp fupoTiEndValidity) {
        if (fupoTiEndValidity != null)
            this.fupoTiEndValidity = (Timestamp) fupoTiEndValidity.clone();
        else
            this.fupoTiEndValidity = fupoTiEndValidity;
    }

    public Timestamp getFupoTiStartValidity() {
        if (this.fupoTiStartValidity != null)
            return (Timestamp) this.fupoTiStartValidity.clone();
        else
            return null;
    }

    public void setFupoTiStartValidity(Timestamp fupoTiStartValidity) {
        if (fupoTiStartValidity != null)
            this.fupoTiStartValidity = (Timestamp) fupoTiStartValidity.clone();
        else
            this.fupoTiStartValidity = fupoTiStartValidity;
    }

    public String getLfpoDsFunctionalPool() {
        return this.lfpoDsFunctionalPool;
    }

    public void setLfpoDsFunctionalPool(String lfpoDsFunctionalPool) {
        this.lfpoDsFunctionalPool = lfpoDsFunctionalPool;
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

    public BigDecimal getWpooIdFunctionalPool() {
        return this.wpooIdFunctionalPool;
    }

    public void setWpooIdFunctionalPool(BigDecimal wpooIdFunctionalPool) {
        this.wpooIdFunctionalPool = wpooIdFunctionalPool;
    }

    public CnalaEnteFunctionTreeNode getCnalaEnteFunctionTreeNode() {
        return this.cnalaEnteFunctionTreeNode;
    }

    public void setCnalaEnteFunctionTreeNode(CnalaEnteFunctionTreeNode cnalaEnteFunctionTreeNode) {
        this.cnalaEnteFunctionTreeNode = cnalaEnteFunctionTreeNode;
    }

    public List<CnalaTaskMailbox> getCnalaTaskMailboxs() {
        return this.cnalaTaskMailboxs;
    }

    public void setCnalaTaskMailboxs(List<CnalaTaskMailbox> cnalaTaskMailboxs) {
        this.cnalaTaskMailboxs = cnalaTaskMailboxs;
    }

    public void addCnalaTaskMailboxs(CnalaTaskMailbox cnalaTaskMailbox) {
        if (this.cnalaTaskMailboxs == null)
            this.cnalaTaskMailboxs = new ArrayList<CnalaTaskMailbox>();
        this.cnalaTaskMailboxs.add(cnalaTaskMailbox);
    }

    public void removeCnalaTaskMailboxs(CnalaTaskMailbox cnalaTaskMailboxToRemove) {
        if (cnalaTaskMailboxToRemove != null)
            this.cnalaTaskMailboxs.remove(cnalaTaskMailboxToRemove);
    }

    public CnaldCommunicationPattern getCnaldCommunicationPattern() {
        return this.cnaldCommunicationPattern;
    }

    public void setCnaldCommunicationPattern(CnaldCommunicationPattern cnaldCommunicationPattern) {
        this.cnaldCommunicationPattern = cnaldCommunicationPattern;
    }

    public CnaldSalesChannel getCnaldSalesChannel() {
        return this.cnaldSalesChannel;
    }

    public void setCnaldSalesChannel(CnaldSalesChannel cnaldSalesChannel) {
        this.cnaldSalesChannel = cnaldSalesChannel;
    }

    public List<CnalpFuncPoolAssignment> getCnalpFuncPoolAssignments() {
        return this.cnalpFuncPoolAssignments;
    }

    public void setCnalpFuncPoolAssignments(List<CnalpFuncPoolAssignment> cnalpFuncPoolAssignments) {
        this.cnalpFuncPoolAssignments = cnalpFuncPoolAssignments;
    }

    public void addCnalpFuncPoolAssignments(CnalpFuncPoolAssignment cnalpFuncPoolAssignment) {
        if (this.cnalpFuncPoolAssignments == null)
            this.cnalpFuncPoolAssignments = new ArrayList<CnalpFuncPoolAssignment>();
        this.cnalpFuncPoolAssignments.add(cnalpFuncPoolAssignment);
    }

    public void removeCnalpFuncPoolAssignments(CnalpFuncPoolAssignment cnalpFuncPoolAssignmentToRemove) {
        if (cnalpFuncPoolAssignmentToRemove != null)
            this.cnalpFuncPoolAssignments.remove(cnalpFuncPoolAssignmentToRemove);
    }

    public CnalpFunctionalPoolSpec getCnalpFunctionalPoolSpec() {
        return this.cnalpFunctionalPoolSpec;
    }

    public void setCnalpFunctionalPoolSpec(CnalpFunctionalPoolSpec cnalpFunctionalPoolSpec) {
        this.cnalpFunctionalPoolSpec = cnalpFunctionalPoolSpec;
    }

    public List<CnalpToolAssignment> getCnalpToolAssignments() {
        return this.cnalpToolAssignments;
    }

    public void setCnalpToolAssignments(List<CnalpToolAssignment> cnalpToolAssignments) {
        this.cnalpToolAssignments = cnalpToolAssignments;
    }

    public void addCnalpToolAssignments(CnalpToolAssignment cnalpToolAssignment) {
        if (this.cnalpToolAssignments == null)
            this.cnalpToolAssignments = new ArrayList<CnalpToolAssignment>();
        this.cnalpToolAssignments.add(cnalpToolAssignment);
    }

    public void removeCnalpToolAssignments(CnalpToolAssignment cnalpToolAssignmentToRemove) {
        if (cnalpToolAssignmentToRemove != null)
            this.cnalpToolAssignments.remove(cnalpToolAssignmentToRemove);
    }

    public List<CnalrFuncPoolMarketSegment> getCnalrFuncPoolMarketSegments() {
        return this.cnalrFuncPoolMarketSegments;
    }

    public void setCnalrFuncPoolMarketSegments(List<CnalrFuncPoolMarketSegment> cnalrFuncPoolMarketSegments) {
        this.cnalrFuncPoolMarketSegments = cnalrFuncPoolMarketSegments;
    }

    public void addCnalrFuncPoolMarketSegments(CnalrFuncPoolMarketSegment cnalrFuncPoolMarketSegment) {
        if (this.cnalrFuncPoolMarketSegments == null)
            this.cnalrFuncPoolMarketSegments = new ArrayList<CnalrFuncPoolMarketSegment>();
        this.cnalrFuncPoolMarketSegments.add(cnalrFuncPoolMarketSegment);
    }

    public void removeCnalrFuncPoolMarketSegments(CnalrFuncPoolMarketSegment cnalrFuncPoolMarketSegmentToRemove) {
        if (cnalrFuncPoolMarketSegmentToRemove != null)
            this.cnalrFuncPoolMarketSegments.remove(cnalrFuncPoolMarketSegmentToRemove);
    }

    public List<CnalrFuncPoolProdCatalog> getCnalrFuncPoolProdCatalogs() {
        return this.cnalrFuncPoolProdCatalogs;
    }

    public void setCnalrFuncPoolProdCatalogs(List<CnalrFuncPoolProdCatalog> cnalrFuncPoolProdCatalogs) {
        this.cnalrFuncPoolProdCatalogs = cnalrFuncPoolProdCatalogs;
    }

    public void addCnalrFuncPoolProdCatalogs(CnalrFuncPoolProdCatalog cnalrFuncPoolProdCatalog) {
        if (this.cnalrFuncPoolProdCatalogs == null)
            this.cnalrFuncPoolProdCatalogs = new ArrayList<CnalrFuncPoolProdCatalog>();
        this.cnalrFuncPoolProdCatalogs.add(cnalrFuncPoolProdCatalog);
    }

    public void removeCnalrFuncPoolProdCatalogs(CnalrFuncPoolProdCatalog cnalrFuncPoolProdCatalogToRemove) {
        if (cnalrFuncPoolProdCatalogToRemove != null)
            this.cnalrFuncPoolProdCatalogs.remove(cnalrFuncPoolProdCatalogToRemove);
    }

    public List<CnalrFuncPoolResourceSpec> getCnalrFuncPoolResourceSpecs() {
        return this.cnalrFuncPoolResourceSpecs;
    }

    public void setCnalrFuncPoolResourceSpecs(List<CnalrFuncPoolResourceSpec> cnalrFuncPoolResourceSpecs) {
        this.cnalrFuncPoolResourceSpecs = cnalrFuncPoolResourceSpecs;
    }

    public void addCnalrFuncPoolResourceSpecs(CnalrFuncPoolResourceSpec cnalrFuncPoolResourceSpec) {
        if (this.cnalrFuncPoolResourceSpecs == null)
            this.cnalrFuncPoolResourceSpecs = new ArrayList<CnalrFuncPoolResourceSpec>();
        this.cnalrFuncPoolResourceSpecs.add(cnalrFuncPoolResourceSpec);
    }

    public void removeCnalrFuncPoolResourceSpecs(CnalrFuncPoolResourceSpec cnalrFuncPoolResourceSpecToRemove) {
        if (cnalrFuncPoolResourceSpecToRemove != null)
            this.cnalrFuncPoolResourceSpecs.remove(cnalrFuncPoolResourceSpecToRemove);
    }

    public List<CnalrFuncPoolServiceSpec> getCnalrFuncPoolServiceSpecs() {
        return this.cnalrFuncPoolServiceSpecs;
    }

    public void setCnalrFuncPoolServiceSpecs(List<CnalrFuncPoolServiceSpec> cnalrFuncPoolServiceSpecs) {
        this.cnalrFuncPoolServiceSpecs = cnalrFuncPoolServiceSpecs;
    }

    public void addCnalrFuncPoolServiceSpecs(CnalrFuncPoolServiceSpec cnalrFuncPoolServiceSpec) {
        if (this.cnalrFuncPoolServiceSpecs == null)
            this.cnalrFuncPoolServiceSpecs = new ArrayList<CnalrFuncPoolServiceSpec>();
        this.cnalrFuncPoolServiceSpecs.add(cnalrFuncPoolServiceSpec);
    }

    public void removeCnalrFuncPoolServiceSpecs(CnalrFuncPoolServiceSpec cnalrFuncPoolServiceSpecToRemove) {
        if (cnalrFuncPoolServiceSpecToRemove != null)
            this.cnalrFuncPoolServiceSpecs.remove(cnalrFuncPoolServiceSpecToRemove);
    }

    public CnalrFuncPoolSpChannelTy getCnalrFuncPoolSpChannelTy() {
        return this.cnalrFuncPoolSpChannelTy;
    }

    public void setCnalrFuncPoolSpChannelTy(CnalrFuncPoolSpChannelTy cnalrFuncPoolSpChannelTy) {
        this.cnalrFuncPoolSpChannelTy = cnalrFuncPoolSpChannelTy;
    }

    public List<CnalrFunctionalPoolL> getCnalrFunctionalPoolLs() {
        return this.cnalrFunctionalPoolLs;
    }

    public void setCnalrFunctionalPoolLs(List<CnalrFunctionalPoolL> cnalrFunctionalPoolLs) {
        this.cnalrFunctionalPoolLs = cnalrFunctionalPoolLs;
    }

    public void addCnalrFunctionalPoolLs(CnalrFunctionalPoolL cnalrFunctionalPoolL) {
        if (this.cnalrFunctionalPoolLs == null)
            this.cnalrFunctionalPoolLs = new ArrayList<CnalrFunctionalPoolL>();
        this.cnalrFunctionalPoolLs.add(cnalrFunctionalPoolL);
    }

    public void removeCnalrFunctionalPoolLs(CnalrFunctionalPoolL cnalrFunctionalPoolLToRemove) {
        if (cnalrFunctionalPoolLToRemove != null)
            this.cnalrFunctionalPoolLs.remove(cnalrFunctionalPoolLToRemove);
    }

    public List<CnalrOrgaPoolAssignment> getCnalrOrgaPoolAssignments() {
        return this.cnalrOrgaPoolAssignments;
    }

    public void setCnalrOrgaPoolAssignments(List<CnalrOrgaPoolAssignment> cnalrOrgaPoolAssignments) {
        this.cnalrOrgaPoolAssignments = cnalrOrgaPoolAssignments;
    }

    public void addCnalrOrgaPoolAssignments(CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment) {
        if (this.cnalrOrgaPoolAssignments == null)
            this.cnalrOrgaPoolAssignments = new ArrayList<CnalrOrgaPoolAssignment>();
        this.cnalrOrgaPoolAssignments.add(cnalrOrgaPoolAssignment);
    }

    public void removeCnalrOrgaPoolAssignments(CnalrOrgaPoolAssignment cnalrOrgaPoolAssignmentToRemove) {
        if (cnalrOrgaPoolAssignmentToRemove != null)
            this.cnalrOrgaPoolAssignments.remove(cnalrOrgaPoolAssignmentToRemove);
    }

}
