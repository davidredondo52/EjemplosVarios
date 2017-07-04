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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the CnalaDistributionLogS database table.
 */
@Entity
@NamedQuery(name = "CnalaDistributionLog.findAll", query = "SELECT c FROM CnalaDistributionLog c")
@Table(name = "CNALA_DISTRIBUTION_LOG", uniqueConstraints = { @UniqueConstraint(columnNames = { "MBOX_ID_MAILBOX",
        "AUDI_TI_CREATION" }) })
public class CnalaDistributionLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "DISL_ID_DISTRIBUTION_LOG", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal dislIdDistributionLog;

    @Column(name = "DISL_QU_ALLOCATED_TASK", nullable = false, precision = 5)
    private Long dislQuAllocatedTask;

    @Column(name = "DISL_QU_NO_DISTRIBUTED_TASK", nullable = false, precision = 5)
    private Long dislQuNoDistributedTask;

    @Column(name = "DISL_QU_PENDING_TASK", nullable = false, precision = 5)
    private Long dislQuPendingTask;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @OneToMany(mappedBy = "cnalaDistributionLog")
    private List<CnalaDistributionLogItem> cnalaDistributionLogItems;
    @JoinColumn(name = "MBOX_ID_MAILBOX", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaTaskMailbox cnalaTaskMailbox;

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

    public BigDecimal getDislIdDistributionLog() {
        return this.dislIdDistributionLog;
    }

    public void setDislIdDistributionLog(BigDecimal dislIdDistributionLog) {
        this.dislIdDistributionLog = dislIdDistributionLog;
    }

    public Long getDislQuAllocatedTask() {
        return this.dislQuAllocatedTask;
    }

    public void setDislQuAllocatedTask(Long dislQuAllocatedTask) {
        this.dislQuAllocatedTask = dislQuAllocatedTask;
    }

    public Long getDislQuNoDistributedTask() {
        return this.dislQuNoDistributedTask;
    }

    public void setDislQuNoDistributedTask(Long dislQuNoDistributedTask) {
        this.dislQuNoDistributedTask = dislQuNoDistributedTask;
    }

    public Long getDislQuPendingTask() {
        return this.dislQuPendingTask;
    }

    public void setDislQuPendingTask(Long dislQuPendingTask) {
        this.dislQuPendingTask = dislQuPendingTask;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public List<CnalaDistributionLogItem> getCnalaDistributionLogItems() {
        return this.cnalaDistributionLogItems;
    }

    public void setCnalaDistributionLogItems(List<CnalaDistributionLogItem> cnalaDistributionLogItems) {
        this.cnalaDistributionLogItems = cnalaDistributionLogItems;
    }

    public void addCnalaDistributionLogItems(CnalaDistributionLogItem cnalaDistributionLogItem) {
        if (this.cnalaDistributionLogItems == null)
            this.cnalaDistributionLogItems = new ArrayList<CnalaDistributionLogItem>();
        this.cnalaDistributionLogItems.add(cnalaDistributionLogItem);
    }

    public void removeCnalaDistributionLogItems(CnalaDistributionLogItem cnalaDistributionLogItemToRemove) {
        if (cnalaDistributionLogItemToRemove != null)
            this.cnalaDistributionLogItems.remove(cnalaDistributionLogItemToRemove);
    }

    public CnalaTaskMailbox getCnalaTaskMailbox() {
        return this.cnalaTaskMailbox;
    }

    public void setCnalaTaskMailbox(CnalaTaskMailbox cnalaTaskMailbox) {
        this.cnalaTaskMailbox = cnalaTaskMailbox;
    }

}
