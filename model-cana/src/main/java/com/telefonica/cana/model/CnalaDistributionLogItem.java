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
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CnalaDistributionLogItemS database table.
 */
@Entity
@NamedQuery(name = "CnalaDistributionLogItem.findAll", query = "SELECT c FROM CnalaDistributionLogItem c")
@Table(name = "CNALA_DISTRIBUTION_LOG_ITEM")
public class CnalaDistributionLogItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "DILI_ID_DISTRIBUTION_LOG_ITEM", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal diliIdDistributionLogItem;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "UTAS_DO_USER_TASK")
    @Lob
    private String utasDoUserTask;

    @Column(length = 100, name = "UTAS_NO_TASK_TITLE")
    private String utasNoTaskTitle;

    @JoinColumns({
            @JoinColumn(referencedColumnName = "AUDI_TI_CREATION", nullable = false, name = "DISL_TI_EXECUTION_PROCESS"),
            @JoinColumn(referencedColumnName = "MBOX_ID_MAILBOX", nullable = false, name = "MBOX_ID_MAILBOX") })
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaDistributionLog cnalaDistributionLog;
    @JoinColumn(name = "NODM_ID_NO_DISTRIBUTED_MOTIVE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldNoDistributedMotive cnaldNoDistributedMotive;

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

    public BigDecimal getDiliIdDistributionLogItem() {
        return this.diliIdDistributionLogItem;
    }

    public void setDiliIdDistributionLogItem(BigDecimal diliIdDistributionLogItem) {
        this.diliIdDistributionLogItem = diliIdDistributionLogItem;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public String getUtasDoUserTask() {
        return this.utasDoUserTask;
    }

    public void setUtasDoUserTask(String utasDoUserTask) {
        this.utasDoUserTask = utasDoUserTask;
    }

    public String getUtasNoTaskTitle() {
        return this.utasNoTaskTitle;
    }

    public void setUtasNoTaskTitle(String utasNoTaskTitle) {
        this.utasNoTaskTitle = utasNoTaskTitle;
    }

    public CnalaDistributionLog getCnalaDistributionLog() {
        return this.cnalaDistributionLog;
    }

    public void setCnalaDistributionLog(CnalaDistributionLog cnalaDistributionLog) {
        this.cnalaDistributionLog = cnalaDistributionLog;
    }

    public CnaldNoDistributedMotive getCnaldNoDistributedMotive() {
        return this.cnaldNoDistributedMotive;
    }

    public void setCnaldNoDistributedMotive(CnaldNoDistributedMotive cnaldNoDistributedMotive) {
        this.cnaldNoDistributedMotive = cnaldNoDistributedMotive;
    }

}
