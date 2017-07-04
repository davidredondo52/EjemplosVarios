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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the CnalpCustomerInquirySpecS database table.
 */
@Entity
@NamedQuery(name = "CnalpCustomerInquirySpec.findAll", query = "SELECT c FROM CnalpCustomerInquirySpec c")
@Table(name = "CNALP_CUSTOMER_INQUIRY_SPEC")
public class CnalpCustomerInquirySpec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "BINT_ID_BUSI_INTERAC_TYPE", precision = 3)
    private Long bintIdBusiInteracType;

    @Column(length = 500, name = "BISL_DS_CUSTOMER_INQUIRY_SPEC", nullable = false)
    private String bislDsCustomerInquirySpec;

    @Column(length = 100, name = "BISL_NA_CUSTOMER_INQUIRY_SPEC", nullable = false)
    private String bislNaCustomerInquirySpec;

    @Column(columnDefinition = "DATE", name = "BISP_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bispDaEndValidity;

    @Column(columnDefinition = "DATE", name = "BISP_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bispDaStartValidity;

    @Column(name = "BISP_ID_CUSTOMER_INQUIRY_SPEC", nullable = false, precision = 7, unique = true)
    @GeneratedValue(generator = "CNALP_CUSTOMER_INQUIRY_SPEC_BISPIDCUSTOMERINQUIRYSPEC_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALP_CUSTOMER_INQUIRY_SPEC_BISPIDCUSTOMERINQUIRYSPEC_GENERATOR", sequenceName = "CNAL_CUST_INQUIRY_SPEC_SEQ")
    private Long bispIdCustomerInquirySpec;

    @Column(name = "CIMT_ID_CUST_INQUIRY_TYPE", precision = 3)
    private Long cimtIdCustInquiryType;

    @Column(name = "CISP_IN_DEBT", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean cispInDebt;

    @Column(name = "CISP_IN_MULTISELECTION", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean cispInMultiselection;

    @Column(name = "CISP_IN_NBO_INQUIRY")
    @Convert("BigDecimalBooleanConverter")
    private Boolean cispInNboInquiry;

    @Column(name = "CISP_IN_UNREGISTERED_PARTY", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean cispInUnregisteredParty;

    @Column(name = "PSPT_ID_PROD_SPEC_TYPE", precision = 2)
    private Long psptIdProdSpecType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "CITN_ID_TREE_NODE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaCustInquTypeTreeNode cnalaCustInquTypeTreeNode;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnaldCallLabel> cnaldCallLabels;
    @JoinColumn(name = "BINT_ID_CUST_INQUIRY_SUBTYPE")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldCustomerInquirySubtype cnaldCustomerInquirySubtype;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec")
    private List<CnalpCustInquirySpecItem> cnalpCustInquirySpecItems;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec")
    private List<CnalrCisDefaultExecProcess> cnalrCisDefaultExecProcesses;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec")
    private List<CnalrCisState> cnalrCisStates;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrCustomerInquirySpecL> cnalrCustomerInquirySpecLs;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec")
    private List<CnalrFuncPoolSpInquSpec> cnalrFuncPoolSpInquSpecs;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec")
    private List<CnalrInquSpecChannelType> cnalrInquSpecChannelTypes;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec")
    private List<CnalrInquSpecContactSesTy> cnalrInquSpecContactSesTies;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec")
    private List<CnalrInquSpecEnteFunction> cnalrInquSpecEnteFunctions;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec")
    private List<CnalrInquSpecMarketSegment> cnalrInquSpecMarketSegments;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec")
    private List<CnalrInquSpecProblemType> cnalrInquSpecProblemTypes;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec")
    private List<CnalrInquSpecRoleSpec> cnalrInquSpecRoleSpecs;
    @OneToMany(mappedBy = "cnalpCustomerInquirySpec")
    private List<CnalrInquSpecRoleState> cnalrInquSpecRoleStates;
    @JoinColumn(name = "WSPE_ID_WORKFLOW_SPEC")
    @ManyToOne(fetch = FetchType.LAZY)
    private GewfpWorkflowSpec gewfpWorkflowSpec;

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

    public Long getBintIdBusiInteracType() {
        return this.bintIdBusiInteracType;
    }

    public void setBintIdBusiInteracType(Long bintIdBusiInteracType) {
        this.bintIdBusiInteracType = bintIdBusiInteracType;
    }

    public String getBislDsCustomerInquirySpec() {
        return this.bislDsCustomerInquirySpec;
    }

    public void setBislDsCustomerInquirySpec(String bislDsCustomerInquirySpec) {
        this.bislDsCustomerInquirySpec = bislDsCustomerInquirySpec;
    }

    public String getBislNaCustomerInquirySpec() {
        return this.bislNaCustomerInquirySpec;
    }

    public void setBislNaCustomerInquirySpec(String bislNaCustomerInquirySpec) {
        this.bislNaCustomerInquirySpec = bislNaCustomerInquirySpec;
    }

    public Date getBispDaEndValidity() {
        if (this.bispDaEndValidity != null)
            return (Date) this.bispDaEndValidity.clone();
        else
            return null;
    }

    public void setBispDaEndValidity(Date bispDaEndValidity) {
        if (bispDaEndValidity != null)
            this.bispDaEndValidity = (Date) bispDaEndValidity.clone();
        else
            this.bispDaEndValidity = bispDaEndValidity;
    }

    public Date getBispDaStartValidity() {
        if (this.bispDaStartValidity != null)
            return (Date) this.bispDaStartValidity.clone();
        else
            return null;
    }

    public void setBispDaStartValidity(Date bispDaStartValidity) {
        if (bispDaStartValidity != null)
            this.bispDaStartValidity = (Date) bispDaStartValidity.clone();
        else
            this.bispDaStartValidity = bispDaStartValidity;
    }

    public Long getBispIdCustomerInquirySpec() {
        return this.bispIdCustomerInquirySpec;
    }

    public void setBispIdCustomerInquirySpec(Long bispIdCustomerInquirySpec) {
        this.bispIdCustomerInquirySpec = bispIdCustomerInquirySpec;
    }

    public Long getCimtIdCustInquiryType() {
        return this.cimtIdCustInquiryType;
    }

    public void setCimtIdCustInquiryType(Long cimtIdCustInquiryType) {
        this.cimtIdCustInquiryType = cimtIdCustInquiryType;
    }

    public Boolean getCispInDebt() {
        return this.cispInDebt;
    }

    public void setCispInDebt(Boolean cispInDebt) {
        this.cispInDebt = cispInDebt;
    }

    public Boolean getCispInMultiselection() {
        return this.cispInMultiselection;
    }

    public void setCispInMultiselection(Boolean cispInMultiselection) {
        this.cispInMultiselection = cispInMultiselection;
    }

    public Boolean getCispInNboInquiry() {
        return this.cispInNboInquiry;
    }

    public void setCispInNboInquiry(Boolean cispInNboInquiry) {
        this.cispInNboInquiry = cispInNboInquiry;
    }

    public Boolean getCispInUnregisteredParty() {
        return this.cispInUnregisteredParty;
    }

    public void setCispInUnregisteredParty(Boolean cispInUnregisteredParty) {
        this.cispInUnregisteredParty = cispInUnregisteredParty;
    }

    public Long getPsptIdProdSpecType() {
        return this.psptIdProdSpecType;
    }

    public void setPsptIdProdSpecType(Long psptIdProdSpecType) {
        this.psptIdProdSpecType = psptIdProdSpecType;
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

    public CnalaCustInquTypeTreeNode getCnalaCustInquTypeTreeNode() {
        return this.cnalaCustInquTypeTreeNode;
    }

    public void setCnalaCustInquTypeTreeNode(CnalaCustInquTypeTreeNode cnalaCustInquTypeTreeNode) {
        this.cnalaCustInquTypeTreeNode = cnalaCustInquTypeTreeNode;
    }

    public List<CnaldCallLabel> getCnaldCallLabels() {
        return this.cnaldCallLabels;
    }

    public void setCnaldCallLabels(List<CnaldCallLabel> cnaldCallLabels) {
        this.cnaldCallLabels = cnaldCallLabels;
    }

    public void addCnaldCallLabels(CnaldCallLabel cnaldCallLabel) {
        if (this.cnaldCallLabels == null)
            this.cnaldCallLabels = new ArrayList<CnaldCallLabel>();
        this.cnaldCallLabels.add(cnaldCallLabel);
    }

    public void removeCnaldCallLabels(CnaldCallLabel cnaldCallLabelToRemove) {
        if (cnaldCallLabelToRemove != null)
            this.cnaldCallLabels.remove(cnaldCallLabelToRemove);
    }

    public CnaldCustomerInquirySubtype getCnaldCustomerInquirySubtype() {
        return this.cnaldCustomerInquirySubtype;
    }

    public void setCnaldCustomerInquirySubtype(CnaldCustomerInquirySubtype cnaldCustomerInquirySubtype) {
        this.cnaldCustomerInquirySubtype = cnaldCustomerInquirySubtype;
    }

    public List<CnalpCustInquirySpecItem> getCnalpCustInquirySpecItems() {
        return this.cnalpCustInquirySpecItems;
    }

    public void setCnalpCustInquirySpecItems(List<CnalpCustInquirySpecItem> cnalpCustInquirySpecItems) {
        this.cnalpCustInquirySpecItems = cnalpCustInquirySpecItems;
    }

    public void addCnalpCustInquirySpecItems(CnalpCustInquirySpecItem cnalpCustInquirySpecItem) {
        if (this.cnalpCustInquirySpecItems == null)
            this.cnalpCustInquirySpecItems = new ArrayList<CnalpCustInquirySpecItem>();
        this.cnalpCustInquirySpecItems.add(cnalpCustInquirySpecItem);
    }

    public void removeCnalpCustInquirySpecItems(CnalpCustInquirySpecItem cnalpCustInquirySpecItemToRemove) {
        if (cnalpCustInquirySpecItemToRemove != null)
            this.cnalpCustInquirySpecItems.remove(cnalpCustInquirySpecItemToRemove);
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

    public List<CnalrCisState> getCnalrCisStates() {
        return this.cnalrCisStates;
    }

    public void setCnalrCisStates(List<CnalrCisState> cnalrCisStates) {
        this.cnalrCisStates = cnalrCisStates;
    }

    public void addCnalrCisStates(CnalrCisState cnalrCisState) {
        if (this.cnalrCisStates == null)
            this.cnalrCisStates = new ArrayList<CnalrCisState>();
        this.cnalrCisStates.add(cnalrCisState);
    }

    public void removeCnalrCisStates(CnalrCisState cnalrCisStateToRemove) {
        if (cnalrCisStateToRemove != null)
            this.cnalrCisStates.remove(cnalrCisStateToRemove);
    }

    public List<CnalrCustomerInquirySpecL> getCnalrCustomerInquirySpecLs() {
        return this.cnalrCustomerInquirySpecLs;
    }

    public void setCnalrCustomerInquirySpecLs(List<CnalrCustomerInquirySpecL> cnalrCustomerInquirySpecLs) {
        this.cnalrCustomerInquirySpecLs = cnalrCustomerInquirySpecLs;
    }

    public void addCnalrCustomerInquirySpecLs(CnalrCustomerInquirySpecL cnalrCustomerInquirySpecL) {
        if (this.cnalrCustomerInquirySpecLs == null)
            this.cnalrCustomerInquirySpecLs = new ArrayList<CnalrCustomerInquirySpecL>();
        this.cnalrCustomerInquirySpecLs.add(cnalrCustomerInquirySpecL);
    }

    public void removeCnalrCustomerInquirySpecLs(CnalrCustomerInquirySpecL cnalrCustomerInquirySpecLToRemove) {
        if (cnalrCustomerInquirySpecLToRemove != null)
            this.cnalrCustomerInquirySpecLs.remove(cnalrCustomerInquirySpecLToRemove);
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

    public List<CnalrInquSpecContactSesTy> getCnalrInquSpecContactSesTies() {
        return this.cnalrInquSpecContactSesTies;
    }

    public void setCnalrInquSpecContactSesTies(List<CnalrInquSpecContactSesTy> cnalrInquSpecContactSesTies) {
        this.cnalrInquSpecContactSesTies = cnalrInquSpecContactSesTies;
    }

    public void addCnalrInquSpecContactSesTies(CnalrInquSpecContactSesTy cnalrInquSpecContactSesTy) {
        if (this.cnalrInquSpecContactSesTies == null)
            this.cnalrInquSpecContactSesTies = new ArrayList<CnalrInquSpecContactSesTy>();
        this.cnalrInquSpecContactSesTies.add(cnalrInquSpecContactSesTy);
    }

    public void removeCnalrInquSpecContactSesTies(CnalrInquSpecContactSesTy cnalrInquSpecContactSesTyToRemove) {
        if (cnalrInquSpecContactSesTyToRemove != null)
            this.cnalrInquSpecContactSesTies.remove(cnalrInquSpecContactSesTyToRemove);
    }

    public List<CnalrInquSpecEnteFunction> getCnalrInquSpecEnteFunctions() {
        return this.cnalrInquSpecEnteFunctions;
    }

    public void setCnalrInquSpecEnteFunctions(List<CnalrInquSpecEnteFunction> cnalrInquSpecEnteFunctions) {
        this.cnalrInquSpecEnteFunctions = cnalrInquSpecEnteFunctions;
    }

    public void addCnalrInquSpecEnteFunctions(CnalrInquSpecEnteFunction cnalrInquSpecEnteFunction) {
        if (this.cnalrInquSpecEnteFunctions == null)
            this.cnalrInquSpecEnteFunctions = new ArrayList<CnalrInquSpecEnteFunction>();
        this.cnalrInquSpecEnteFunctions.add(cnalrInquSpecEnteFunction);
    }

    public void removeCnalrInquSpecEnteFunctions(CnalrInquSpecEnteFunction cnalrInquSpecEnteFunctionToRemove) {
        if (cnalrInquSpecEnteFunctionToRemove != null)
            this.cnalrInquSpecEnteFunctions.remove(cnalrInquSpecEnteFunctionToRemove);
    }

    public List<CnalrInquSpecMarketSegment> getCnalrInquSpecMarketSegments() {
        return this.cnalrInquSpecMarketSegments;
    }

    public void setCnalrInquSpecMarketSegments(List<CnalrInquSpecMarketSegment> cnalrInquSpecMarketSegments) {
        this.cnalrInquSpecMarketSegments = cnalrInquSpecMarketSegments;
    }

    public void addCnalrInquSpecMarketSegments(CnalrInquSpecMarketSegment cnalrInquSpecMarketSegment) {
        if (this.cnalrInquSpecMarketSegments == null)
            this.cnalrInquSpecMarketSegments = new ArrayList<CnalrInquSpecMarketSegment>();
        this.cnalrInquSpecMarketSegments.add(cnalrInquSpecMarketSegment);
    }

    public void removeCnalrInquSpecMarketSegments(CnalrInquSpecMarketSegment cnalrInquSpecMarketSegmentToRemove) {
        if (cnalrInquSpecMarketSegmentToRemove != null)
            this.cnalrInquSpecMarketSegments.remove(cnalrInquSpecMarketSegmentToRemove);
    }

    public List<CnalrInquSpecProblemType> getCnalrInquSpecProblemTypes() {
        return this.cnalrInquSpecProblemTypes;
    }

    public void setCnalrInquSpecProblemTypes(List<CnalrInquSpecProblemType> cnalrInquSpecProblemTypes) {
        this.cnalrInquSpecProblemTypes = cnalrInquSpecProblemTypes;
    }

    public void addCnalrInquSpecProblemTypes(CnalrInquSpecProblemType cnalrInquSpecProblemType) {
        if (this.cnalrInquSpecProblemTypes == null)
            this.cnalrInquSpecProblemTypes = new ArrayList<CnalrInquSpecProblemType>();
        this.cnalrInquSpecProblemTypes.add(cnalrInquSpecProblemType);
    }

    public void removeCnalrInquSpecProblemTypes(CnalrInquSpecProblemType cnalrInquSpecProblemTypeToRemove) {
        if (cnalrInquSpecProblemTypeToRemove != null)
            this.cnalrInquSpecProblemTypes.remove(cnalrInquSpecProblemTypeToRemove);
    }

    public List<CnalrInquSpecRoleSpec> getCnalrInquSpecRoleSpecs() {
        return this.cnalrInquSpecRoleSpecs;
    }

    public void setCnalrInquSpecRoleSpecs(List<CnalrInquSpecRoleSpec> cnalrInquSpecRoleSpecs) {
        this.cnalrInquSpecRoleSpecs = cnalrInquSpecRoleSpecs;
    }

    public void addCnalrInquSpecRoleSpecs(CnalrInquSpecRoleSpec cnalrInquSpecRoleSpec) {
        if (this.cnalrInquSpecRoleSpecs == null)
            this.cnalrInquSpecRoleSpecs = new ArrayList<CnalrInquSpecRoleSpec>();
        this.cnalrInquSpecRoleSpecs.add(cnalrInquSpecRoleSpec);
    }

    public void removeCnalrInquSpecRoleSpecs(CnalrInquSpecRoleSpec cnalrInquSpecRoleSpecToRemove) {
        if (cnalrInquSpecRoleSpecToRemove != null)
            this.cnalrInquSpecRoleSpecs.remove(cnalrInquSpecRoleSpecToRemove);
    }

    public List<CnalrInquSpecRoleState> getCnalrInquSpecRoleStates() {
        return this.cnalrInquSpecRoleStates;
    }

    public void setCnalrInquSpecRoleStates(List<CnalrInquSpecRoleState> cnalrInquSpecRoleStates) {
        this.cnalrInquSpecRoleStates = cnalrInquSpecRoleStates;
    }

    public void addCnalrInquSpecRoleStates(CnalrInquSpecRoleState cnalrInquSpecRoleState) {
        if (this.cnalrInquSpecRoleStates == null)
            this.cnalrInquSpecRoleStates = new ArrayList<CnalrInquSpecRoleState>();
        this.cnalrInquSpecRoleStates.add(cnalrInquSpecRoleState);
    }

    public void removeCnalrInquSpecRoleStates(CnalrInquSpecRoleState cnalrInquSpecRoleStateToRemove) {
        if (cnalrInquSpecRoleStateToRemove != null)
            this.cnalrInquSpecRoleStates.remove(cnalrInquSpecRoleStateToRemove);
    }

    public GewfpWorkflowSpec getGewfpWorkflowSpec() {
        return this.gewfpWorkflowSpec;
    }

    public void setGewfpWorkflowSpec(GewfpWorkflowSpec gewfpWorkflowSpec) {
        this.gewfpWorkflowSpec = gewfpWorkflowSpec;
    }

}
