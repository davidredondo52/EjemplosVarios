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
 * The persistent class for the CnalrCisDefaultExecProcessS database table.
 */
@Entity
@NamedQuery(name = "CnalrCisDefaultExecProcess.findAll", query = "SELECT c FROM CnalrCisDefaultExecProcess c")
@Table(name = "CNALR_CIS_DEFAULT_EXEC_PROCESS", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BISP_ID_CUSTOMER_INQUIRY_SPEC", "PRDE_ID_PROCESS_DEFINITION" }) })
public class CnalrCisDefaultExecProcess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "DEXP_ID_CIS_DEF_EXEC_PROCESS", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal dexpIdCisDefExecProcess;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "BISP_ID_CUSTOMER_INQUIRY_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpCustomerInquirySpec cnalpCustomerInquirySpec;
    @JoinColumn(name = "PRDE_ID_PROCESS_DEFINITION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpProcessDefinition cnalpProcessDefinition;

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

    public BigDecimal getDexpIdCisDefExecProcess() {
        return this.dexpIdCisDefExecProcess;
    }

    public void setDexpIdCisDefExecProcess(BigDecimal dexpIdCisDefExecProcess) {
        this.dexpIdCisDefExecProcess = dexpIdCisDefExecProcess;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnalpCustomerInquirySpec getCnalpCustomerInquirySpec() {
        return this.cnalpCustomerInquirySpec;
    }

    public void setCnalpCustomerInquirySpec(CnalpCustomerInquirySpec cnalpCustomerInquirySpec) {
        this.cnalpCustomerInquirySpec = cnalpCustomerInquirySpec;
    }

    public CnalpProcessDefinition getCnalpProcessDefinition() {
        return this.cnalpProcessDefinition;
    }

    public void setCnalpProcessDefinition(CnalpProcessDefinition cnalpProcessDefinition) {
        this.cnalpProcessDefinition = cnalpProcessDefinition;
    }

}
