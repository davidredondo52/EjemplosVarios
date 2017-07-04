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
 * The persistent class for the ProcrUtMovDocumentS database table.
 */
@Entity
@NamedQuery(name = "ProcrUtMovDocument.findAll", query = "SELECT p FROM ProcrUtMovDocument p")
@Table(name = "PROCR_UT_MOV_DOCUMENT", uniqueConstraints = { @UniqueConstraint(columnNames = { "UTAS_ID_DOMAIN",
        "PRCS_ID_FUNCTIONAL_PROCESS", "UTMA_IN_PROCESS_CLASS", "UTMA_TI_MOVEMENT", "ATTA_CO_DOCUMENT" }) })
public class ProcrUtMovDocument implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 100, name = "ATTA_CO_DOCUMENT", nullable = false)
    private String attaCoDocument;

    @Column(length = 100, name = "ATTA_NA_FILE", nullable = false)
    private String attaNaFile;

    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "MODO_ID_UT_MOV_DOCUMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal modoIdUtMovDocument;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumns({
            @JoinColumn(referencedColumnName = "PRCS_ID_FUNCTIONAL_PROCESS", nullable = false, name = "PRCS_ID_FUNCTIONAL_PROCESS"),
            @JoinColumn(referencedColumnName = "UTAS_ID_DOMAIN", nullable = false, name = "UTAS_ID_DOMAIN"),
            @JoinColumn(referencedColumnName = "UTMA_IN_PROCESS_CLASS", nullable = false, name = "UTMA_IN_PROCESS_CLASS"),
            @JoinColumn(referencedColumnName = "AUDI_TI_CREATION", nullable = false, name = "UTMA_TI_MOVEMENT") })
    @ManyToOne(fetch = FetchType.LAZY)
    private ProcaUserTaskMovement procaUserTaskMovement;

    public String getAttaCoDocument() {
        return this.attaCoDocument;
    }

    public void setAttaCoDocument(String attaCoDocument) {
        this.attaCoDocument = attaCoDocument;
    }

    public String getAttaNaFile() {
        return this.attaNaFile;
    }

    public void setAttaNaFile(String attaNaFile) {
        this.attaNaFile = attaNaFile;
    }

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

    public BigDecimal getModoIdUtMovDocument() {
        return this.modoIdUtMovDocument;
    }

    public void setModoIdUtMovDocument(BigDecimal modoIdUtMovDocument) {
        this.modoIdUtMovDocument = modoIdUtMovDocument;
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
