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
 * The persistent class for the GewfrWorkflowSpecEnteFuncS database table.
 */
@Entity
@NamedQuery(name = "GewfrWorkflowSpecEnteFunc.findAll", query = "SELECT g FROM GewfrWorkflowSpecEnteFunc g")
@Table(name = "GEWFR_WORKFLOW_SPEC_ENTE_FUNC", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "WSPE_ID_WORKFLOW_SPEC", "EFTN_ID_ENTE_FUNC_TREE_NODE" }) })
public class GewfrWorkflowSpecEnteFunc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "WSEF_ID_WF_SPEC_ENTE_FUNC", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal wsefIdWfSpecEnteFunc;

    @JoinColumn(name = "EFTN_ID_ENTE_FUNC_TREE_NODE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaEnteFunctionTreeNode cnalaEnteFunctionTreeNode;
    @JoinColumn(name = "WSPE_ID_WORKFLOW_SPEC", nullable = false)
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

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public BigDecimal getWsefIdWfSpecEnteFunc() {
        return this.wsefIdWfSpecEnteFunc;
    }

    public void setWsefIdWfSpecEnteFunc(BigDecimal wsefIdWfSpecEnteFunc) {
        this.wsefIdWfSpecEnteFunc = wsefIdWfSpecEnteFunc;
    }

    public CnalaEnteFunctionTreeNode getCnalaEnteFunctionTreeNode() {
        return this.cnalaEnteFunctionTreeNode;
    }

    public void setCnalaEnteFunctionTreeNode(CnalaEnteFunctionTreeNode cnalaEnteFunctionTreeNode) {
        this.cnalaEnteFunctionTreeNode = cnalaEnteFunctionTreeNode;
    }

    public GewfpWorkflowSpec getGewfpWorkflowSpec() {
        return this.gewfpWorkflowSpec;
    }

    public void setGewfpWorkflowSpec(GewfpWorkflowSpec gewfpWorkflowSpec) {
        this.gewfpWorkflowSpec = gewfpWorkflowSpec;
    }

}
