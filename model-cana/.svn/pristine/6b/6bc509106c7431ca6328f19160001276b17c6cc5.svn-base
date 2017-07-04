package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CnalfFunctionalPoolS database table.
 */
@Entity
@NamedQuery(name = "CnalfFunctionalPool.findAll", query = "SELECT c FROM CnalfFunctionalPool c")
@Table(name = "CNALF_FUNCTIONAL_POOL")
public class CnalfFunctionalPool implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "COPA_ID_COMMUNICATION_PATTERN", precision = 3)
    private Long copaIdCommunicationPattern;

    @Column(name = "EFTN_ID_ENTE_FUNC_TREE_NODE", nullable = false, precision = 5)
    private Long eftnIdEnteFuncTreeNode;

    @Column(length = 1, name = "FUPF_IN_STATEMENT", nullable = false)
    private String fupfInStatement;

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

    @Column(name = "FUPS_ID_FUNTIONAL_POOL_SPEC", precision = 4)
    private Long fupsIdFuntionalPoolSpec;

    @Column(length = 200, name = "LFPO_DS_FUNCTIONAL_POOL", nullable = false)
    private String lfpoDsFunctionalPool;

    @Column(name = "PSCT_ID_FUNC_POOL_SP_CHAN_TY", precision = 38)
    private BigDecimal psctIdFuncPoolSpChanTy;

    @Column(name = "SCHA_ID_SALES_CHANNEL", precision = 3)
    private Long schaIdSalesChannel;

    @Column(name = "USER_ID_USER_UPDATER", precision = 38)
    private BigDecimal userIdUserUpdater;

    @EmbeddedId
    private CnalfFunctionalPoolPK id;

    public Long getCopaIdCommunicationPattern() {
        return this.copaIdCommunicationPattern;
    }

    public void setCopaIdCommunicationPattern(Long copaIdCommunicationPattern) {
        this.copaIdCommunicationPattern = copaIdCommunicationPattern;
    }

    public Long getEftnIdEnteFuncTreeNode() {
        return this.eftnIdEnteFuncTreeNode;
    }

    public void setEftnIdEnteFuncTreeNode(Long eftnIdEnteFuncTreeNode) {
        this.eftnIdEnteFuncTreeNode = eftnIdEnteFuncTreeNode;
    }

    public String getFupfInStatement() {
        return this.fupfInStatement;
    }

    public void setFupfInStatement(String fupfInStatement) {
        this.fupfInStatement = fupfInStatement;
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

    public Long getFupsIdFuntionalPoolSpec() {
        return this.fupsIdFuntionalPoolSpec;
    }

    public void setFupsIdFuntionalPoolSpec(Long fupsIdFuntionalPoolSpec) {
        this.fupsIdFuntionalPoolSpec = fupsIdFuntionalPoolSpec;
    }

    public String getLfpoDsFunctionalPool() {
        return this.lfpoDsFunctionalPool;
    }

    public void setLfpoDsFunctionalPool(String lfpoDsFunctionalPool) {
        this.lfpoDsFunctionalPool = lfpoDsFunctionalPool;
    }

    public BigDecimal getPsctIdFuncPoolSpChanTy() {
        return this.psctIdFuncPoolSpChanTy;
    }

    public void setPsctIdFuncPoolSpChanTy(BigDecimal psctIdFuncPoolSpChanTy) {
        this.psctIdFuncPoolSpChanTy = psctIdFuncPoolSpChanTy;
    }

    public Long getSchaIdSalesChannel() {
        return this.schaIdSalesChannel;
    }

    public void setSchaIdSalesChannel(Long schaIdSalesChannel) {
        this.schaIdSalesChannel = schaIdSalesChannel;
    }

    public BigDecimal getUserIdUserUpdater() {
        return this.userIdUserUpdater;
    }

    public void setUserIdUserUpdater(BigDecimal userIdUserUpdater) {
        this.userIdUserUpdater = userIdUserUpdater;
    }

    public CnalfFunctionalPoolPK getId() {
        return this.id;
    }

    public void setId(CnalfFunctionalPoolPK id) {
        this.id = id;
    }

}
