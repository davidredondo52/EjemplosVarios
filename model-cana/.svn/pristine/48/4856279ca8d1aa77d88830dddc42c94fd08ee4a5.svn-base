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
 * The persistent class for the CnaldEnterpriseFunctionS database table.
 */
@Entity
@NamedQuery(name = "CnaldEnterpriseFunction.findAll", query = "SELECT c FROM CnaldEnterpriseFunction c")
@Table(name = "CNALD_ENTERPRISE_FUNCTION")
public class CnaldEnterpriseFunction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "ENFU_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date enfuDaEndValidity;

    @Column(columnDefinition = "DATE", name = "ENFU_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date enfuDaStartValidity;

    @Column(name = "ENFU_ID_ENTERPRISE_FUNCTION", nullable = false, precision = 3, unique = true)
    @GeneratedValue(generator = "CNALD_ENTERPRISE_FUNCTION_ENFUIDENTERPRISEFUNCTION_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALD_ENTERPRISE_FUNCTION_ENFUIDENTERPRISEFUNCTION_GENERATOR", sequenceName = "CNAL_ENTERPRISE_FUNCTION_SEQ")
    private Long enfuIdEnterpriseFunction;

    @Column(length = 50, name = "LEFU_NA_ENTERPRISE_FUNCTION", nullable = false, unique = true)
    private String lefuNaEnterpriseFunction;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnaldEnterpriseFunction")
    private List<CnalaEnteFunctionTreeNode> cnalaEnteFunctionTreeNodes;
    @OneToMany(mappedBy = "cnaldEnterpriseFunction", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrEnteFunctionToolType> cnalrEnteFunctionToolTypes;
    @OneToMany(mappedBy = "cnaldEnterpriseFunction", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrEnterpriseFunctionL> cnalrEnterpriseFunctionLs;
    @OneToMany(mappedBy = "cnaldEnterpriseFunction")
    private List<CnalrFuncPoolSpEnteFunct> cnalrFuncPoolSpEnteFuncts;
    @OneToMany(mappedBy = "cnaldEnterpriseFunction")
    private List<CnalrInquSpecEnteFunction> cnalrInquSpecEnteFunctions;

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

    public Date getEnfuDaEndValidity() {
        if (this.enfuDaEndValidity != null)
            return (Date) this.enfuDaEndValidity.clone();
        else
            return null;
    }

    public void setEnfuDaEndValidity(Date enfuDaEndValidity) {
        if (enfuDaEndValidity != null)
            this.enfuDaEndValidity = (Date) enfuDaEndValidity.clone();
        else
            this.enfuDaEndValidity = enfuDaEndValidity;
    }

    public Date getEnfuDaStartValidity() {
        if (this.enfuDaStartValidity != null)
            return (Date) this.enfuDaStartValidity.clone();
        else
            return null;
    }

    public void setEnfuDaStartValidity(Date enfuDaStartValidity) {
        if (enfuDaStartValidity != null)
            this.enfuDaStartValidity = (Date) enfuDaStartValidity.clone();
        else
            this.enfuDaStartValidity = enfuDaStartValidity;
    }

    public Long getEnfuIdEnterpriseFunction() {
        return this.enfuIdEnterpriseFunction;
    }

    public void setEnfuIdEnterpriseFunction(Long enfuIdEnterpriseFunction) {
        this.enfuIdEnterpriseFunction = enfuIdEnterpriseFunction;
    }

    public String getLefuNaEnterpriseFunction() {
        return this.lefuNaEnterpriseFunction;
    }

    public void setLefuNaEnterpriseFunction(String lefuNaEnterpriseFunction) {
        this.lefuNaEnterpriseFunction = lefuNaEnterpriseFunction;
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

    public List<CnalaEnteFunctionTreeNode> getCnalaEnteFunctionTreeNodes() {
        return this.cnalaEnteFunctionTreeNodes;
    }

    public void setCnalaEnteFunctionTreeNodes(List<CnalaEnteFunctionTreeNode> cnalaEnteFunctionTreeNodes) {
        this.cnalaEnteFunctionTreeNodes = cnalaEnteFunctionTreeNodes;
    }

    public void addCnalaEnteFunctionTreeNodes(CnalaEnteFunctionTreeNode cnalaEnteFunctionTreeNode) {
        if (this.cnalaEnteFunctionTreeNodes == null)
            this.cnalaEnteFunctionTreeNodes = new ArrayList<CnalaEnteFunctionTreeNode>();
        this.cnalaEnteFunctionTreeNodes.add(cnalaEnteFunctionTreeNode);
    }

    public void removeCnalaEnteFunctionTreeNodes(CnalaEnteFunctionTreeNode cnalaEnteFunctionTreeNodeToRemove) {
        if (cnalaEnteFunctionTreeNodeToRemove != null)
            this.cnalaEnteFunctionTreeNodes.remove(cnalaEnteFunctionTreeNodeToRemove);
    }

    public List<CnalrEnteFunctionToolType> getCnalrEnteFunctionToolTypes() {
        return this.cnalrEnteFunctionToolTypes;
    }

    public void setCnalrEnteFunctionToolTypes(List<CnalrEnteFunctionToolType> cnalrEnteFunctionToolTypes) {
        this.cnalrEnteFunctionToolTypes = cnalrEnteFunctionToolTypes;
    }

    public void addCnalrEnteFunctionToolTypes(CnalrEnteFunctionToolType cnalrEnteFunctionToolType) {
        if (this.cnalrEnteFunctionToolTypes == null)
            this.cnalrEnteFunctionToolTypes = new ArrayList<CnalrEnteFunctionToolType>();
        this.cnalrEnteFunctionToolTypes.add(cnalrEnteFunctionToolType);
    }

    public void removeCnalrEnteFunctionToolTypes(CnalrEnteFunctionToolType cnalrEnteFunctionToolTypeToRemove) {
        if (cnalrEnteFunctionToolTypeToRemove != null)
            this.cnalrEnteFunctionToolTypes.remove(cnalrEnteFunctionToolTypeToRemove);
    }

    public List<CnalrEnterpriseFunctionL> getCnalrEnterpriseFunctionLs() {
        return this.cnalrEnterpriseFunctionLs;
    }

    public void setCnalrEnterpriseFunctionLs(List<CnalrEnterpriseFunctionL> cnalrEnterpriseFunctionLs) {
        this.cnalrEnterpriseFunctionLs = cnalrEnterpriseFunctionLs;
    }

    public void addCnalrEnterpriseFunctionLs(CnalrEnterpriseFunctionL cnalrEnterpriseFunctionL) {
        if (this.cnalrEnterpriseFunctionLs == null)
            this.cnalrEnterpriseFunctionLs = new ArrayList<CnalrEnterpriseFunctionL>();
        this.cnalrEnterpriseFunctionLs.add(cnalrEnterpriseFunctionL);
    }

    public void removeCnalrEnterpriseFunctionLs(CnalrEnterpriseFunctionL cnalrEnterpriseFunctionLToRemove) {
        if (cnalrEnterpriseFunctionLToRemove != null)
            this.cnalrEnterpriseFunctionLs.remove(cnalrEnterpriseFunctionLToRemove);
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

}
