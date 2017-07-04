package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the ProcpUserTaskManagementS database table.
 */
@Entity
@NamedQuery(name = "ProcpUserTaskManagement.findAll", query = "SELECT p FROM ProcpUserTaskManagement p")
@Table(name = "PROCP_USER_TASK_MANAGEMENT", uniqueConstraints = { @UniqueConstraint(columnNames = { "UTAS_ID_DOMAIN",
        "PRCS_ID_FUNCTIONAL_PROCESS", "UTMA_IN_PROCESS_CLASS" }) })
public class ProcpUserTaskManagement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(length = 36, name = "PRCS_ID_FUNCTIONAL_PROCESS")
    private String prcsIdFunctionalProcess;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(length = 3, name = "UTAS_ID_DOMAIN")
    private String utasIdDomain;

    @Column(name = "UTMA_ID_USERTASK_MANAGEMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal utmaIdUsertaskManagement;

    @Column(name = "UTMA_IN_PROCESS_CLASS", precision = 1)
    private Long utmaInProcessClass;

    @JoinColumn(name = "BSES_ID_USER_TASK_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private PrdedUserTaskSpec prdedUserTaskSpec;
    @OneToMany(mappedBy = "procpUserTaskManagement", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ProcaUserTaskMovement> procaUserTaskMovements;

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

    public String getPrcsIdFunctionalProcess() {
        return this.prcsIdFunctionalProcess;
    }

    public void setPrcsIdFunctionalProcess(String prcsIdFunctionalProcess) {
        this.prcsIdFunctionalProcess = prcsIdFunctionalProcess;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public String getUtasIdDomain() {
        return this.utasIdDomain;
    }

    public void setUtasIdDomain(String utasIdDomain) {
        this.utasIdDomain = utasIdDomain;
    }

    public BigDecimal getUtmaIdUsertaskManagement() {
        return this.utmaIdUsertaskManagement;
    }

    public void setUtmaIdUsertaskManagement(BigDecimal utmaIdUsertaskManagement) {
        this.utmaIdUsertaskManagement = utmaIdUsertaskManagement;
    }

    public Long getUtmaInProcessClass() {
        return this.utmaInProcessClass;
    }

    public void setUtmaInProcessClass(Long utmaInProcessClass) {
        this.utmaInProcessClass = utmaInProcessClass;
    }

    public PrdedUserTaskSpec getPrdedUserTaskSpec() {
        return this.prdedUserTaskSpec;
    }

    public void setPrdedUserTaskSpec(PrdedUserTaskSpec prdedUserTaskSpec) {
        this.prdedUserTaskSpec = prdedUserTaskSpec;
    }

    public List<ProcaUserTaskMovement> getProcaUserTaskMovements() {
        return this.procaUserTaskMovements;
    }

    public void setProcaUserTaskMovements(List<ProcaUserTaskMovement> procaUserTaskMovements) {
        this.procaUserTaskMovements = procaUserTaskMovements;
    }

    public void addProcaUserTaskMovements(ProcaUserTaskMovement procaUserTaskMovement) {
        if (this.procaUserTaskMovements == null)
            this.procaUserTaskMovements = new ArrayList<ProcaUserTaskMovement>();
        this.procaUserTaskMovements.add(procaUserTaskMovement);
    }

    public void removeProcaUserTaskMovements(ProcaUserTaskMovement procaUserTaskMovementToRemove) {
        if (procaUserTaskMovementToRemove != null)
            this.procaUserTaskMovements.remove(procaUserTaskMovementToRemove);
    }

}
