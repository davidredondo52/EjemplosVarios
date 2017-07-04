package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
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

/**
 * The persistent class for the CnalaEnteFunctionTreeNodeS database table.
 */
@Entity
@NamedQuery(name = "CnalaEnteFunctionTreeNode.findAll", query = "SELECT c FROM CnalaEnteFunctionTreeNode c")
@Table(name = "CNALA_ENTE_FUNCTION_TREE_NODE")
public class CnalaEnteFunctionTreeNode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "EFTN_ID_ENTE_FUNC_TREE_NODE", nullable = false, precision = 5, unique = true)
    @GeneratedValue(generator = "CNALA_ENTE_FUNCTION_TREE_NODE_EFTNIDENTEFUNCTREENODE_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALA_ENTE_FUNCTION_TREE_NODE_EFTNIDENTEFUNCTREENODE_GENERATOR", sequenceName = "CNAL_ENTE_FUNC_TREE_NODE_SEQ")
    private Long eftnIdEnteFuncTreeNode;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "EFTN_ID_FUNC_TREE_NODE_FATHER")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaEnteFunctionTreeNode cnalaEnteFunctionTreeNode;
    @OneToMany(mappedBy = "cnalaEnteFunctionTreeNode")
    private List<CnalaEnteFunctionTreeNode> cnalaEnteFunctionTreeNodes;
    @JoinColumn(name = "ENFU_ID_ENTERPRISE_FUNCTION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldEnterpriseFunction cnaldEnterpriseFunction;
    @OneToMany(mappedBy = "cnalaEnteFunctionTreeNode")
    private List<CnalpFunctionalPool> cnalpFunctionalPools;
    @OneToMany(mappedBy = "cnalaEnteFunctionTreeNode")
    private List<GewfrWorkflowSpecEnteFunc> gewfrWorkflowSpecEnteFuncs;

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

    public Long getEftnIdEnteFuncTreeNode() {
        return this.eftnIdEnteFuncTreeNode;
    }

    public void setEftnIdEnteFuncTreeNode(Long eftnIdEnteFuncTreeNode) {
        this.eftnIdEnteFuncTreeNode = eftnIdEnteFuncTreeNode;
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

    public CnalaEnteFunctionTreeNode getCnalaEnteFunctionTreeNode() {
        return this.cnalaEnteFunctionTreeNode;
    }

    public void setCnalaEnteFunctionTreeNode(CnalaEnteFunctionTreeNode cnalaEnteFunctionTreeNode) {
        this.cnalaEnteFunctionTreeNode = cnalaEnteFunctionTreeNode;
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

    public CnaldEnterpriseFunction getCnaldEnterpriseFunction() {
        return this.cnaldEnterpriseFunction;
    }

    public void setCnaldEnterpriseFunction(CnaldEnterpriseFunction cnaldEnterpriseFunction) {
        this.cnaldEnterpriseFunction = cnaldEnterpriseFunction;
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

}
