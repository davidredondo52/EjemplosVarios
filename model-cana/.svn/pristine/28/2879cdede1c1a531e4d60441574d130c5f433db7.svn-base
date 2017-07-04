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
 * The persistent class for the CnalrInquSpecRoleSpecS database table.
 */
@Entity
@NamedQuery(name = "CnalrInquSpecRoleSpec.findAll", query = "SELECT c FROM CnalrInquSpecRoleSpec c")
@Table(name = "CNALR_INQU_SPEC_ROLE_SPEC", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "ROTY_ID_PARTY_ROLE_SPEC", "BISP_ID_CUST_INQUIRY_SPEC" }) })
public class CnalrInquSpecRoleSpec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "ISRS_ID_INQU_SP_PARTY_ROLE_SP", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal isrsIdInquSpPartyRoleSp;

    @Column(name = "ROTY_ID_PARTY_ROLE_SPEC", nullable = false, precision = 3)
    private Long rotyIdPartyRoleSpec;

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

    public BigDecimal getIsrsIdInquSpPartyRoleSp() {
        return this.isrsIdInquSpPartyRoleSp;
    }

    public void setIsrsIdInquSpPartyRoleSp(BigDecimal isrsIdInquSpPartyRoleSp) {
        this.isrsIdInquSpPartyRoleSp = isrsIdInquSpPartyRoleSp;
    }

    public Long getRotyIdPartyRoleSpec() {
        return this.rotyIdPartyRoleSpec;
    }

    public void setRotyIdPartyRoleSpec(Long rotyIdPartyRoleSpec) {
        this.rotyIdPartyRoleSpec = rotyIdPartyRoleSpec;
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
