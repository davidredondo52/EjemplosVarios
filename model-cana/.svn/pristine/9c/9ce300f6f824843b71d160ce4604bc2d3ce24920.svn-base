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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the ProcaUserTaskMovementS database table.
 */
@Entity
@NamedQuery(name = "ProcaUserTaskMovement.findAll", query = "SELECT p FROM ProcaUserTaskMovement p")
@Table(name = "PROCA_USER_TASK_MOVEMENT", uniqueConstraints = { @UniqueConstraint(columnNames = { "UTAS_ID_DOMAIN",
        "PRCS_ID_FUNCTIONAL_PROCESS", "UTMA_IN_PROCESS_CLASS", "AUDI_TI_CREATION" }) })
public class ProcaUserTaskMovement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "PARO_ID_ORG_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdOrgRole;

    @Column(name = "PARO_ID_SCALED_ORG_ROLE", precision = 38)
    private BigDecimal paroIdScaledOrgRole;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "UTMO_ID_USER_TASK_MOVEMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal utmoIdUserTaskMovement;

    @JoinColumn(name = "MBOX_ID_MAILBOX", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaTaskMailbox cnalaTaskMailbox1;
    @JoinColumn(name = "MBOX_ID_ORIGIN_MAILBOX", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalaTaskMailbox cnalaTaskMailbox2;
    @OneToMany(mappedBy = "procaUserTaskMovement", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ProcaUtMovementNote> procaUtMovementNotes;
    @JoinColumns({
            @JoinColumn(referencedColumnName = "PRCS_ID_FUNCTIONAL_PROCESS", nullable = false, name = "PRCS_ID_FUNCTIONAL_PROCESS"),
            @JoinColumn(referencedColumnName = "UTAS_ID_DOMAIN", nullable = false, name = "UTAS_ID_DOMAIN"),
            @JoinColumn(referencedColumnName = "UTMA_IN_PROCESS_CLASS", nullable = false, name = "UTMA_IN_PROCESS_CLASS") })
    @ManyToOne(fetch = FetchType.LAZY)
    private ProcpUserTaskManagement procpUserTaskManagement;
    @OneToMany(mappedBy = "procaUserTaskMovement", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<ProcrUtMovDocument> procrUtMovDocuments;

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

    public BigDecimal getParoIdOrgRole() {
        return this.paroIdOrgRole;
    }

    public void setParoIdOrgRole(BigDecimal paroIdOrgRole) {
        this.paroIdOrgRole = paroIdOrgRole;
    }

    public BigDecimal getParoIdScaledOrgRole() {
        return this.paroIdScaledOrgRole;
    }

    public void setParoIdScaledOrgRole(BigDecimal paroIdScaledOrgRole) {
        this.paroIdScaledOrgRole = paroIdScaledOrgRole;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public BigDecimal getUtmoIdUserTaskMovement() {
        return this.utmoIdUserTaskMovement;
    }

    public void setUtmoIdUserTaskMovement(BigDecimal utmoIdUserTaskMovement) {
        this.utmoIdUserTaskMovement = utmoIdUserTaskMovement;
    }

    public CnalaTaskMailbox getCnalaTaskMailbox1() {
        return this.cnalaTaskMailbox1;
    }

    public void setCnalaTaskMailbox1(CnalaTaskMailbox cnalaTaskMailbox1) {
        this.cnalaTaskMailbox1 = cnalaTaskMailbox1;
    }

    public CnalaTaskMailbox getCnalaTaskMailbox2() {
        return this.cnalaTaskMailbox2;
    }

    public void setCnalaTaskMailbox2(CnalaTaskMailbox cnalaTaskMailbox2) {
        this.cnalaTaskMailbox2 = cnalaTaskMailbox2;
    }

    public List<ProcaUtMovementNote> getProcaUtMovementNotes() {
        return this.procaUtMovementNotes;
    }

    public void setProcaUtMovementNotes(List<ProcaUtMovementNote> procaUtMovementNotes) {
        this.procaUtMovementNotes = procaUtMovementNotes;
    }

    public void addProcaUtMovementNotes(ProcaUtMovementNote procaUtMovementNote) {
        if (this.procaUtMovementNotes == null)
            this.procaUtMovementNotes = new ArrayList<ProcaUtMovementNote>();
        this.procaUtMovementNotes.add(procaUtMovementNote);
    }

    public void removeProcaUtMovementNotes(ProcaUtMovementNote procaUtMovementNoteToRemove) {
        if (procaUtMovementNoteToRemove != null)
            this.procaUtMovementNotes.remove(procaUtMovementNoteToRemove);
    }

    public ProcpUserTaskManagement getProcpUserTaskManagement() {
        return this.procpUserTaskManagement;
    }

    public void setProcpUserTaskManagement(ProcpUserTaskManagement procpUserTaskManagement) {
        this.procpUserTaskManagement = procpUserTaskManagement;
    }

    public List<ProcrUtMovDocument> getProcrUtMovDocuments() {
        return this.procrUtMovDocuments;
    }

    public void setProcrUtMovDocuments(List<ProcrUtMovDocument> procrUtMovDocuments) {
        this.procrUtMovDocuments = procrUtMovDocuments;
    }

    public void addProcrUtMovDocuments(ProcrUtMovDocument procrUtMovDocument) {
        if (this.procrUtMovDocuments == null)
            this.procrUtMovDocuments = new ArrayList<ProcrUtMovDocument>();
        this.procrUtMovDocuments.add(procrUtMovDocument);
    }

    public void removeProcrUtMovDocuments(ProcrUtMovDocument procrUtMovDocumentToRemove) {
        if (procrUtMovDocumentToRemove != null)
            this.procrUtMovDocuments.remove(procrUtMovDocumentToRemove);
    }

}
