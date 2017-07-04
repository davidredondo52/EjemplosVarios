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
 * The persistent class for the CnalrCisStateS database table.
 */
@Entity
@NamedQuery(name = "CnalrCisState.findAll", query = "SELECT c FROM CnalrCisState c")
@Table(name = "CNALR_CIS_STATE", uniqueConstraints = { @UniqueConstraint(columnNames = { "BINT_ID_BUSI_INTERAC_TYPE",
        "BIST_ID_BUSI_INTERAC_STATE", "BISP_ID_CUSTOMER_INQUIRY_SPEC" }) })
public class CnalrCisState implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "BINT_ID_BUSI_INTERAC_TYPE", nullable = false, precision = 3)
    private Long bintIdBusiInteracType;

    @Column(name = "BIST_ID_BUSI_INTERAC_STATE", nullable = false, precision = 3)
    private Long bistIdBusiInteracState;

    @Column(name = "SRES_ID_CIS_STATE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal sresIdCisState;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "BISP_ID_CUSTOMER_INQUIRY_SPEC", nullable = false)
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

    public Long getBintIdBusiInteracType() {
        return this.bintIdBusiInteracType;
    }

    public void setBintIdBusiInteracType(Long bintIdBusiInteracType) {
        this.bintIdBusiInteracType = bintIdBusiInteracType;
    }

    public Long getBistIdBusiInteracState() {
        return this.bistIdBusiInteracState;
    }

    public void setBistIdBusiInteracState(Long bistIdBusiInteracState) {
        this.bistIdBusiInteracState = bistIdBusiInteracState;
    }

    public BigDecimal getSresIdCisState() {
        return this.sresIdCisState;
    }

    public void setSresIdCisState(BigDecimal sresIdCisState) {
        this.sresIdCisState = sresIdCisState;
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
