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
 * The persistent class for the PrdefUserTaskSpecS database table.
 */
@Entity
@NamedQuery(name = "PrdefUserTaskSpec.findAll", query = "SELECT p FROM PrdefUserTaskSpec p")
@Table(name = "PRDEF_USER_TASK_SPEC")
public class PrdefUserTaskSpec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "BSES_DA_END_VALIDITY")
    private Timestamp bsesDaEndValidity;

    @Column(name = "BSES_DA_START_VALIDITY", nullable = false)
    private Timestamp bsesDaStartValidity;

    @Column(length = 500, name = "BSES_DS_BUSINESS_SERVICE", nullable = false)
    private String bsesDsBusinessService;

    @Column(length = 100, name = "BSES_NA_BUSINESS_SERVICE", nullable = false)
    private String bsesNaBusinessService;

    @Column(name = "GENA_ID_APPLICATION", nullable = false, precision = 3)
    private Long genaIdApplication;

    @Column(name = "PROS_ID_PROCESS_SPECIFICATION", nullable = false, precision = 4)
    private Long prosIdProcessSpecification;

    @Column(name = "USER_ID_USER_UPDATER", precision = 38)
    private BigDecimal userIdUserUpdater;

    @Column(length = 1, name = "UTSF_IN_STATEMENT", nullable = false)
    private String utsfInStatement;

    @Column(name = "UTSP_IN_MANAGE_BETWEEN_AREAS", nullable = false, precision = 1)
    private Long utspInManageBetweenAreas;

    @Column(name = "UTSP_IN_SEND_UP", nullable = false, precision = 1)
    private Long utspInSendUp;

    @Column(length = 100, name = "UTSP_NA_TECHNICAL_UT", nullable = false)
    private String utspNaTechnicalUt;

    @EmbeddedId
    private PrdefUserTaskSpecPK id;

    public Timestamp getBsesDaEndValidity() {
        if (this.bsesDaEndValidity != null)
            return (Timestamp) this.bsesDaEndValidity.clone();
        else
            return null;
    }

    public void setBsesDaEndValidity(Timestamp bsesDaEndValidity) {
        if (bsesDaEndValidity != null)
            this.bsesDaEndValidity = (Timestamp) bsesDaEndValidity.clone();
        else
            this.bsesDaEndValidity = bsesDaEndValidity;
    }

    public Timestamp getBsesDaStartValidity() {
        if (this.bsesDaStartValidity != null)
            return (Timestamp) this.bsesDaStartValidity.clone();
        else
            return null;
    }

    public void setBsesDaStartValidity(Timestamp bsesDaStartValidity) {
        if (bsesDaStartValidity != null)
            this.bsesDaStartValidity = (Timestamp) bsesDaStartValidity.clone();
        else
            this.bsesDaStartValidity = bsesDaStartValidity;
    }

    public String getBsesDsBusinessService() {
        return this.bsesDsBusinessService;
    }

    public void setBsesDsBusinessService(String bsesDsBusinessService) {
        this.bsesDsBusinessService = bsesDsBusinessService;
    }

    public String getBsesNaBusinessService() {
        return this.bsesNaBusinessService;
    }

    public void setBsesNaBusinessService(String bsesNaBusinessService) {
        this.bsesNaBusinessService = bsesNaBusinessService;
    }

    public Long getGenaIdApplication() {
        return this.genaIdApplication;
    }

    public void setGenaIdApplication(Long genaIdApplication) {
        this.genaIdApplication = genaIdApplication;
    }

    public Long getProsIdProcessSpecification() {
        return this.prosIdProcessSpecification;
    }

    public void setProsIdProcessSpecification(Long prosIdProcessSpecification) {
        this.prosIdProcessSpecification = prosIdProcessSpecification;
    }

    public BigDecimal getUserIdUserUpdater() {
        return this.userIdUserUpdater;
    }

    public void setUserIdUserUpdater(BigDecimal userIdUserUpdater) {
        this.userIdUserUpdater = userIdUserUpdater;
    }

    public String getUtsfInStatement() {
        return this.utsfInStatement;
    }

    public void setUtsfInStatement(String utsfInStatement) {
        this.utsfInStatement = utsfInStatement;
    }

    public Long getUtspInManageBetweenAreas() {
        return this.utspInManageBetweenAreas;
    }

    public void setUtspInManageBetweenAreas(Long utspInManageBetweenAreas) {
        this.utspInManageBetweenAreas = utspInManageBetweenAreas;
    }

    public Long getUtspInSendUp() {
        return this.utspInSendUp;
    }

    public void setUtspInSendUp(Long utspInSendUp) {
        this.utspInSendUp = utspInSendUp;
    }

    public String getUtspNaTechnicalUt() {
        return this.utspNaTechnicalUt;
    }

    public void setUtspNaTechnicalUt(String utspNaTechnicalUt) {
        this.utspNaTechnicalUt = utspNaTechnicalUt;
    }

    public PrdefUserTaskSpecPK getId() {
        return this.id;
    }

    public void setId(PrdefUserTaskSpecPK id) {
        this.id = id;
    }

}
