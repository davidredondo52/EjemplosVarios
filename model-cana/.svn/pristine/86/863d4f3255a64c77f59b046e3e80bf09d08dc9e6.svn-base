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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the ProcaUtMovementNoteS database table.
 */
@Entity
@NamedQuery(name = "ProcaUtMovementNote.findAll", query = "SELECT p FROM ProcaUtMovementNote p")
@Table(name = "PROCA_UT_MOVEMENT_NOTE", uniqueConstraints = { @UniqueConstraint(columnNames = { "UTAS_ID_DOMAIN",
        "PRCS_ID_FUNCTIONAL_PROCESS", "UTMA_IN_PROCESS_CLASS", "AUDI_TI_CREATION" }) })
public class ProcaUtMovementNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "MONO_ID_UT_MOVEMENT_NOTE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal monoIdUtMovementNote;

    @Column(length = 500, name = "MONO_OB_NOTE", nullable = false)
    private String monoObNote;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumns({
            @JoinColumn(referencedColumnName = "PRCS_ID_FUNCTIONAL_PROCESS", nullable = false, name = "PRCS_ID_FUNCTIONAL_PROCESS"),
            @JoinColumn(referencedColumnName = "UTAS_ID_DOMAIN", nullable = false, name = "UTAS_ID_DOMAIN"),
            @JoinColumn(referencedColumnName = "UTMA_IN_PROCESS_CLASS", nullable = false, name = "UTMA_IN_PROCESS_CLASS"),
            @JoinColumn(referencedColumnName = "AUDI_TI_CREATION", nullable = false, name = "UTMA_TI_MOVEMENT") })
    @ManyToOne(fetch = FetchType.LAZY)
    private ProcaUserTaskMovement procaUserTaskMovement;

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

    public BigDecimal getMonoIdUtMovementNote() {
        return this.monoIdUtMovementNote;
    }

    public void setMonoIdUtMovementNote(BigDecimal monoIdUtMovementNote) {
        this.monoIdUtMovementNote = monoIdUtMovementNote;
    }

    public String getMonoObNote() {
        return this.monoObNote;
    }

    public void setMonoObNote(String monoObNote) {
        this.monoObNote = monoObNote;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public ProcaUserTaskMovement getProcaUserTaskMovement() {
        return this.procaUserTaskMovement;
    }

    public void setProcaUserTaskMovement(ProcaUserTaskMovement procaUserTaskMovement) {
        this.procaUserTaskMovement = procaUserTaskMovement;
    }

}
