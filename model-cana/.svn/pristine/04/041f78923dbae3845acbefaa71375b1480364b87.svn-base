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
 * The persistent class for the CnalrInquSpecProblemTypeS database table.
 */
@Entity
@NamedQuery(name = "CnalrInquSpecProblemType.findAll", query = "SELECT c FROM CnalrInquSpecProblemType c")
@Table(name = "CNALR_INQU_SPEC_PROBLEM_TYPE", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "CPRT_ID_CUSTOMER_PROBLEM_TYPE", "BISP_ID_CUST_INQUIRY_SPEC" }) })
public class CnalrInquSpecProblemType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "CPRT_ID_CUSTOMER_PROBLEM_TYPE", nullable = false, precision = 3)
    private Long cprtIdCustomerProblemType;

    @Column(name = "ISPT_ID_INQU_SP_PROBLEM_TYPE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal isptIdInquSpProblemType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "BISP_ID_CUST_INQUIRY_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpCustomerInquirySpec cnalpCustomerInquirySpec;

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

    public Long getCprtIdCustomerProblemType() {
        return this.cprtIdCustomerProblemType;
    }

    public void setCprtIdCustomerProblemType(Long cprtIdCustomerProblemType) {
        this.cprtIdCustomerProblemType = cprtIdCustomerProblemType;
    }

    public BigDecimal getIsptIdInquSpProblemType() {
        return this.isptIdInquSpProblemType;
    }

    public void setIsptIdInquSpProblemType(BigDecimal isptIdInquSpProblemType) {
        this.isptIdInquSpProblemType = isptIdInquSpProblemType;
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

}
