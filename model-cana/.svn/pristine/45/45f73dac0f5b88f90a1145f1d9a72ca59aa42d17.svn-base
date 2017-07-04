package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
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

/**
 * The persistent class for the GewfpWorkflowSpecS database table.
 */
@Entity
@NamedQuery(name = "GewfpWorkflowSpec.findAll", query = "SELECT g FROM GewfpWorkflowSpec g")
@Table(name = "GEWFP_WORKFLOW_SPEC")
public class GewfpWorkflowSpec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @Column(name = "WSPE_ID_WORKFLOW_SPEC", nullable = false, precision = 4, unique = true)
    @GeneratedValue(generator = "GEWFP_WORKFLOW_SPEC_WSPEIDWORKFLOWSPEC_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "GEWFP_WORKFLOW_SPEC_WSPEIDWORKFLOWSPEC_GENERATOR", sequenceName = "GEWF_WORKFLOW_SPEC_SEQ")
    private Long wspeIdWorkflowSpec;

    @Column(name = "WSPE_IN_WORKFLOW_SPEC_CLASS", nullable = false, precision = 1)
    private Long wspeInWorkflowSpecClass;

    @Column(name = "WSPE_TI_END_VALIDITY")
    private Timestamp wspeTiEndValidity;

    @Column(name = "WSPE_TI_START_VALIDITY", nullable = false)
    private Timestamp wspeTiStartValidity;

    @Column(length = 500, name = "WSPL_DS_WORKFLOW_SPEC", nullable = false)
    private String wsplDsWorkflowSpec;

    @Column(length = 100, name = "WSPL_NA_WORKFLOW_SPEC", nullable = false)
    private String wsplNaWorkflowSpec;

    @Column(name = "WSST_NU_WF_SPEC_FIRST_STEP", precision = 2)
    private Long wsstNuWfSpecFirstStep;

    @OneToMany(mappedBy = "gewfpWorkflowSpec")
    private List<CnalpCustomerInquirySpec> cnalpCustomerInquirySpecs;
    @OneToMany(mappedBy = "gewfpWorkflowSpec")
    private List<GewfaWorkflowSpecStep> gewfaWorkflowSpecSteps;
    @OneToMany(mappedBy = "gewfpWorkflowSpec")
    private List<GewfpWorkflow> gewfpWorkflows;
    @OneToMany(mappedBy = "gewfpWorkflowSpec", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<GewfrWorkflowSpecEnteFunc> gewfrWorkflowSpecEnteFuncs;
    @OneToMany(mappedBy = "gewfpWorkflowSpec", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<GewfrWorkflowSpecL> gewfrWorkflowSpecLs;

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

    public Long getWspeIdWorkflowSpec() {
        return this.wspeIdWorkflowSpec;
    }

    public void setWspeIdWorkflowSpec(Long wspeIdWorkflowSpec) {
        this.wspeIdWorkflowSpec = wspeIdWorkflowSpec;
    }

    public Long getWspeInWorkflowSpecClass() {
        return this.wspeInWorkflowSpecClass;
    }

    public void setWspeInWorkflowSpecClass(Long wspeInWorkflowSpecClass) {
        this.wspeInWorkflowSpecClass = wspeInWorkflowSpecClass;
    }

    public Timestamp getWspeTiEndValidity() {
        if (this.wspeTiEndValidity != null)
            return (Timestamp) this.wspeTiEndValidity.clone();
        else
            return null;
    }

    public void setWspeTiEndValidity(Timestamp wspeTiEndValidity) {
        if (wspeTiEndValidity != null)
            this.wspeTiEndValidity = (Timestamp) wspeTiEndValidity.clone();
        else
            this.wspeTiEndValidity = wspeTiEndValidity;
    }

    public Timestamp getWspeTiStartValidity() {
        if (this.wspeTiStartValidity != null)
            return (Timestamp) this.wspeTiStartValidity.clone();
        else
            return null;
    }

    public void setWspeTiStartValidity(Timestamp wspeTiStartValidity) {
        if (wspeTiStartValidity != null)
            this.wspeTiStartValidity = (Timestamp) wspeTiStartValidity.clone();
        else
            this.wspeTiStartValidity = wspeTiStartValidity;
    }

    public String getWsplDsWorkflowSpec() {
        return this.wsplDsWorkflowSpec;
    }

    public void setWsplDsWorkflowSpec(String wsplDsWorkflowSpec) {
        this.wsplDsWorkflowSpec = wsplDsWorkflowSpec;
    }

    public String getWsplNaWorkflowSpec() {
        return this.wsplNaWorkflowSpec;
    }

    public void setWsplNaWorkflowSpec(String wsplNaWorkflowSpec) {
        this.wsplNaWorkflowSpec = wsplNaWorkflowSpec;
    }

    public Long getWsstNuWfSpecFirstStep() {
        return this.wsstNuWfSpecFirstStep;
    }

    public void setWsstNuWfSpecFirstStep(Long wsstNuWfSpecFirstStep) {
        this.wsstNuWfSpecFirstStep = wsstNuWfSpecFirstStep;
    }

    public List<CnalpCustomerInquirySpec> getCnalpCustomerInquirySpecs() {
        return this.cnalpCustomerInquirySpecs;
    }

    public void setCnalpCustomerInquirySpecs(List<CnalpCustomerInquirySpec> cnalpCustomerInquirySpecs) {
        this.cnalpCustomerInquirySpecs = cnalpCustomerInquirySpecs;
    }

    public void addCnalpCustomerInquirySpecs(CnalpCustomerInquirySpec cnalpCustomerInquirySpec) {
        if (this.cnalpCustomerInquirySpecs == null)
            this.cnalpCustomerInquirySpecs = new ArrayList<CnalpCustomerInquirySpec>();
        this.cnalpCustomerInquirySpecs.add(cnalpCustomerInquirySpec);
    }

    public void removeCnalpCustomerInquirySpecs(CnalpCustomerInquirySpec cnalpCustomerInquirySpecToRemove) {
        if (cnalpCustomerInquirySpecToRemove != null)
            this.cnalpCustomerInquirySpecs.remove(cnalpCustomerInquirySpecToRemove);
    }

    public List<GewfaWorkflowSpecStep> getGewfaWorkflowSpecSteps() {
        return this.gewfaWorkflowSpecSteps;
    }

    public void setGewfaWorkflowSpecSteps(List<GewfaWorkflowSpecStep> gewfaWorkflowSpecSteps) {
        this.gewfaWorkflowSpecSteps = gewfaWorkflowSpecSteps;
    }

    public void addGewfaWorkflowSpecSteps(GewfaWorkflowSpecStep gewfaWorkflowSpecStep) {
        if (this.gewfaWorkflowSpecSteps == null)
            this.gewfaWorkflowSpecSteps = new ArrayList<GewfaWorkflowSpecStep>();
        this.gewfaWorkflowSpecSteps.add(gewfaWorkflowSpecStep);
    }

    public void removeGewfaWorkflowSpecSteps(GewfaWorkflowSpecStep gewfaWorkflowSpecStepToRemove) {
        if (gewfaWorkflowSpecStepToRemove != null)
            this.gewfaWorkflowSpecSteps.remove(gewfaWorkflowSpecStepToRemove);
    }

    public List<GewfpWorkflow> getGewfpWorkflows() {
        return this.gewfpWorkflows;
    }

    public void setGewfpWorkflows(List<GewfpWorkflow> gewfpWorkflows) {
        this.gewfpWorkflows = gewfpWorkflows;
    }

    public void addGewfpWorkflows(GewfpWorkflow gewfpWorkflow) {
        if (this.gewfpWorkflows == null)
            this.gewfpWorkflows = new ArrayList<GewfpWorkflow>();
        this.gewfpWorkflows.add(gewfpWorkflow);
    }

    public void removeGewfpWorkflows(GewfpWorkflow gewfpWorkflowToRemove) {
        if (gewfpWorkflowToRemove != null)
            this.gewfpWorkflows.remove(gewfpWorkflowToRemove);
    }

    public List<GewfrWorkflowSpecEnteFunc> getGewfrWorkflowSpecEnteFuncs() {
        return this.gewfrWorkflowSpecEnteFuncs;
    }

    public void setGewfrWorkflowSpecEnteFuncs(List<GewfrWorkflowSpecEnteFunc> gewfrWorkflowSpecEnteFuncs) {
        this.gewfrWorkflowSpecEnteFuncs = gewfrWorkflowSpecEnteFuncs;
    }

    public void addGewfrWorkflowSpecEnteFuncs(GewfrWorkflowSpecEnteFunc gewfrWorkflowSpecEnteFunc) {
        if (this.gewfrWorkflowSpecEnteFuncs == null)
            this.gewfrWorkflowSpecEnteFuncs = new ArrayList<GewfrWorkflowSpecEnteFunc>();
        this.gewfrWorkflowSpecEnteFuncs.add(gewfrWorkflowSpecEnteFunc);
    }

    public void removeGewfrWorkflowSpecEnteFuncs(GewfrWorkflowSpecEnteFunc gewfrWorkflowSpecEnteFuncToRemove) {
        if (gewfrWorkflowSpecEnteFuncToRemove != null)
            this.gewfrWorkflowSpecEnteFuncs.remove(gewfrWorkflowSpecEnteFuncToRemove);
    }

    public List<GewfrWorkflowSpecL> getGewfrWorkflowSpecLs() {
        return this.gewfrWorkflowSpecLs;
    }

    public void setGewfrWorkflowSpecLs(List<GewfrWorkflowSpecL> gewfrWorkflowSpecLs) {
        this.gewfrWorkflowSpecLs = gewfrWorkflowSpecLs;
    }

    public void addGewfrWorkflowSpecLs(GewfrWorkflowSpecL gewfrWorkflowSpecL) {
        if (this.gewfrWorkflowSpecLs == null)
            this.gewfrWorkflowSpecLs = new ArrayList<GewfrWorkflowSpecL>();
        this.gewfrWorkflowSpecLs.add(gewfrWorkflowSpecL);
    }

    public void removeGewfrWorkflowSpecLs(GewfrWorkflowSpecL gewfrWorkflowSpecLToRemove) {
        if (gewfrWorkflowSpecLToRemove != null)
            this.gewfrWorkflowSpecLs.remove(gewfrWorkflowSpecLToRemove);
    }

}
