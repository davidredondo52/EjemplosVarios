package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CnaldCallLabelS database table.
 */
@Entity
@NamedQuery(name = "CnaldCallLabel.findAll", query = "SELECT c FROM CnaldCallLabel c")
@Table(name = "CNALD_CALL_LABEL")
public class CnaldCallLabel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "CALA_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date calaDaEndValidity;

    @Column(columnDefinition = "DATE", name = "CALA_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date calaDaStartValidity;

    @Column(name = "CALA_ID_CALL_LABEL", nullable = false, precision = 6, unique = true)
    @GeneratedValue(generator = "CNALD_CALL_LABEL_CALAIDCALLLABEL_GENERATOR", strategy = GenerationType.SEQUENCE)
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALD_CALL_LABEL_CALAIDCALLLABEL_GENERATOR", sequenceName = "CNAL_CALL_LABEL_SEQ")
    private Long calaIdCallLabel;

    @Column(name = "CALA_IN_CALL_LABEL_TYPE", nullable = false, precision = 1)
    private Long calaInCallLabelType;

    @Column(length = 100, name = "CALA_NA_CALL_LABEL", nullable = false)
    private String calaNaCallLabel;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "BISP_ID_CUST_INQUIRY_SPEC")
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

    public Timestamp getAudiTiUpdate() {
        if (this.audiTiUpdate != null)
            return (Timestamp) this.audiTiUpdate.clone();
        else
            return null;
    }

    public void setAudiTiUpdate(Timestamp audiTiUpdate) {
        if (audiTiUpdate != null)
            this.audiTiUpdate = (Timestamp) audiTiUpdate.clone();
        else
            this.audiTiUpdate = audiTiUpdate;
    }

    public Date getCalaDaEndValidity() {
        if (this.calaDaEndValidity != null)
            return (Date) this.calaDaEndValidity.clone();
        else
            return null;
    }

    public void setCalaDaEndValidity(Date calaDaEndValidity) {
        if (calaDaEndValidity != null)
            this.calaDaEndValidity = (Date) calaDaEndValidity.clone();
        else
            this.calaDaEndValidity = calaDaEndValidity;
    }

    public Date getCalaDaStartValidity() {
        if (this.calaDaStartValidity != null)
            return (Date) this.calaDaStartValidity.clone();
        else
            return null;
    }

    public void setCalaDaStartValidity(Date calaDaStartValidity) {
        if (calaDaStartValidity != null)
            this.calaDaStartValidity = (Date) calaDaStartValidity.clone();
        else
            this.calaDaStartValidity = calaDaStartValidity;
    }

    public Long getCalaIdCallLabel() {
        return this.calaIdCallLabel;
    }

    public void setCalaIdCallLabel(Long calaIdCallLabel) {
        this.calaIdCallLabel = calaIdCallLabel;
    }

    public Long getCalaInCallLabelType() {
        return this.calaInCallLabelType;
    }

    public void setCalaInCallLabelType(Long calaInCallLabelType) {
        this.calaInCallLabelType = calaInCallLabelType;
    }

    public String getCalaNaCallLabel() {
        return this.calaNaCallLabel;
    }

    public void setCalaNaCallLabel(String calaNaCallLabel) {
        this.calaNaCallLabel = calaNaCallLabel;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public BigDecimal getUserIdUpdaterParty() {
        return this.userIdUpdaterParty;
    }

    public void setUserIdUpdaterParty(BigDecimal userIdUpdaterParty) {
        this.userIdUpdaterParty = userIdUpdaterParty;
    }

    public CnalpCustomerInquirySpec getCnalpCustomerInquirySpec() {
        return this.cnalpCustomerInquirySpec;
    }

    public void setCnalpCustomerInquirySpec(CnalpCustomerInquirySpec cnalpCustomerInquirySpec) {
        this.cnalpCustomerInquirySpec = cnalpCustomerInquirySpec;
    }

}
