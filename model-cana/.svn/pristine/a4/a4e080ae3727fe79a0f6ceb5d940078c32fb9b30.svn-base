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
 * The persistent class for the CnalaCustInquTypeTreeNodeS database table.
 */
@Entity
@NamedQuery(name = "CnalaCustInquTypeTreeNode.findAll", query = "SELECT c FROM CnalaCustInquTypeTreeNode c")
@Table(name = "CNALA_CUST_INQU_TYPE_TREE_NODE")
public class CnalaCustInquTypeTreeNode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "CITN_ID_INQU_TYPE_TREE_NODE", nullable = false, precision = 6, unique = true)
    @GeneratedValue(generator = "CNALA_CUST_INQU_TYPE_TREE_NODE_CITNIDINQUTYPETREENODE_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALA_CUST_INQU_TYPE_TREE_NODE_CITNIDINQUTYPETREENODE_GENERATOR", sequenceName = "CNAL_CUST_INQU_TREE_NODE_SEQ")
    private Long citnIdInquTypeTreeNode;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;
    
    @Column(name = "CITN_ID_TYPE_TREE_NODE_FATHER", insertable = false, updatable = false)
    private Long citnIdInquTypeTreeNodeFather;

    @JoinColumn(name = "CITN_ID_TYPE_TREE_NODE_FATHER")
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaCustInquTypeTreeNode cnalaCustInquTypeTreeNode;
    @OneToMany(mappedBy = "cnalaCustInquTypeTreeNode")
    private List<CnalaCustInquTypeTreeNode> cnalaCustInquTypeTreeNodes;
    @JoinColumn(name = "CIMT_ID_CUST_INQUIRY_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldCustomerInquiryType cnaldCustomerInquiryType;
    @OneToMany(mappedBy = "cnalaCustInquTypeTreeNode")
    private List<CnalpCustomerInquirySpec> cnalpCustomerInquirySpecs;

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

    public Long getCitnIdInquTypeTreeNode() {
        return this.citnIdInquTypeTreeNode;
    }

    public void setCitnIdInquTypeTreeNode(Long citnIdInquTypeTreeNode) {
        this.citnIdInquTypeTreeNode = citnIdInquTypeTreeNode;
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

    public List<CnalaCustInquTypeTreeNode> getCnalaCustInquTypeTreeNodes() {
        return this.cnalaCustInquTypeTreeNodes;
    }

    public void setCnalaCustInquTypeTreeNodes(List<CnalaCustInquTypeTreeNode> cnalaCustInquTypeTreeNodes) {
        this.cnalaCustInquTypeTreeNodes = cnalaCustInquTypeTreeNodes;
    }

    public void addCnalaCustInquTypeTreeNodes(CnalaCustInquTypeTreeNode cnalaCustInquTypeTreeNode) {
        if (this.cnalaCustInquTypeTreeNodes == null)
            this.cnalaCustInquTypeTreeNodes = new ArrayList<CnalaCustInquTypeTreeNode>();
        this.cnalaCustInquTypeTreeNodes.add(cnalaCustInquTypeTreeNode);
    }

    public void removeCnalaCustInquTypeTreeNodes(CnalaCustInquTypeTreeNode cnalaCustInquTypeTreeNodeToRemove) {
        if (cnalaCustInquTypeTreeNodeToRemove != null)
            this.cnalaCustInquTypeTreeNodes.remove(cnalaCustInquTypeTreeNodeToRemove);
    }

    public CnaldCustomerInquiryType getCnaldCustomerInquiryType() {
        return this.cnaldCustomerInquiryType;
    }

    public void setCnaldCustomerInquiryType(CnaldCustomerInquiryType cnaldCustomerInquiryType) {
        this.cnaldCustomerInquiryType = cnaldCustomerInquiryType;
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

    public Long getCitnIdInquTypeTreeNodeFather() {
        return citnIdInquTypeTreeNodeFather;
    }

    public void setCitnIdInquTypeTreeNodeFather(Long citnIdInquTypeTreeNodeFather) {
        this.citnIdInquTypeTreeNodeFather = citnIdInquTypeTreeNodeFather;
    }

}
