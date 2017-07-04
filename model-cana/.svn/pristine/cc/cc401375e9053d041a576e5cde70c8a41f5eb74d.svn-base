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
 * The persistent class for the CnalrInquSpecEnteFunctionS database table.
 */
@Entity
@NamedQuery(name = "CnalrInquSpecEnteFunction.findAll", query = "SELECT c FROM CnalrInquSpecEnteFunction c")
@Table(name = "CNALR_INQU_SPEC_ENTE_FUNCTION", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "ENFU_ID_ENTERPRISE_FUNCTION", "BISP_ID_CUST_INQUIRY_SPEC" }) })
public class CnalrInquSpecEnteFunction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "ISCF_ID_INQU_SP_ENTE_FUNCTION", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal iscfIdInquSpEnteFunction;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "ENFU_ID_ENTERPRISE_FUNCTION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldEnterpriseFunction cnaldEnterpriseFunction;
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

    public BigDecimal getIscfIdInquSpEnteFunction() {
        return this.iscfIdInquSpEnteFunction;
    }

    public void setIscfIdInquSpEnteFunction(BigDecimal iscfIdInquSpEnteFunction) {
        this.iscfIdInquSpEnteFunction = iscfIdInquSpEnteFunction;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnaldEnterpriseFunction getCnaldEnterpriseFunction() {
        return this.cnaldEnterpriseFunction;
    }

    public void setCnaldEnterpriseFunction(CnaldEnterpriseFunction cnaldEnterpriseFunction) {
        this.cnaldEnterpriseFunction = cnaldEnterpriseFunction;
    }

    public CnalpCustomerInquirySpec getCnalpCustomerInquirySpec() {
        return this.cnalpCustomerInquirySpec;
    }

    public void setCnalpCustomerInquirySpec(CnalpCustomerInquirySpec cnalpCustomerInquirySpec) {
        this.cnalpCustomerInquirySpec = cnalpCustomerInquirySpec;
    }

}
