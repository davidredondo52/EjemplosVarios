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
 * The persistent class for the CnalrInquSpecRoleStateS database table.
 */
@Entity
@NamedQuery(name = "CnalrInquSpecRoleState.findAll", query = "SELECT c FROM CnalrInquSpecRoleState c")
@Table(name = "CNALR_INQU_SPEC_ROLE_STATE", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "PRST_ID_PARTY_ROLE_STATE", "BISP_ID_CUSTOMER_INQUIRY_SPEC" }) })
public class CnalrInquSpecRoleState implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "ISRS_ID_INQU_SPEC_ROLE_STATE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal isrsIdInquSpecRoleState;

    @Column(name = "PRST_ID_PARTY_ROLE_STATE", nullable = false, precision = 3)
    private Long prstIdPartyRoleState;

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

    public BigDecimal getIsrsIdInquSpecRoleState() {
        return this.isrsIdInquSpecRoleState;
    }

    public void setIsrsIdInquSpecRoleState(BigDecimal isrsIdInquSpecRoleState) {
        this.isrsIdInquSpecRoleState = isrsIdInquSpecRoleState;
    }

    public Long getPrstIdPartyRoleState() {
        return this.prstIdPartyRoleState;
    }

    public void setPrstIdPartyRoleState(Long prstIdPartyRoleState) {
        this.prstIdPartyRoleState = prstIdPartyRoleState;
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
