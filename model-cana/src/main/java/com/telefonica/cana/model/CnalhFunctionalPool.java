package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CnalhFunctionalPoolS database table.
 */
@Entity
@NamedQuery(name = "CnalhFunctionalPool.findAll", query = "SELECT c FROM CnalhFunctionalPool c")
@Table(name = "CNALH_FUNCTIONAL_POOL")
public class CnalhFunctionalPool implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE", nullable = false)
    private Timestamp audiTiUpdate;

    @Column(name = "COPA_ID_COMMUNICATION_PATTERN", precision = 3)
    private Long copaIdCommunicationPattern;

    @Column(name = "EFTN_ID_ENTE_FUNC_TREE_NODE", nullable = false, precision = 5)
    private Long eftnIdEnteFuncTreeNode;

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

    @Column(name = "FUPO_TI_END_VALIDITY", nullable = false)
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

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdUpdaterParty;

    @Column(name = "WPOO_ID_FUNCTIONAL_POOL", nullable = false, precision = 38, unique = true)
    @Id
    private BigDecimal wpooIdFunctionalPool;

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

}
