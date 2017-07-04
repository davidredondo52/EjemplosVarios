package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the CnalpCustInquirySpecItemS database table.
 */
@Entity
@NamedQuery(name = "CnalpCustInquirySpecItem.findAll", query = "SELECT c FROM CnalpCustInquirySpecItem c")
@Table(name = "CNALP_CUST_INQUIRY_SPEC_ITEM")
public class CnalpCustInquirySpecItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "BISI_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bisiDaEndValidity;

    @Column(columnDefinition = "DATE", name = "BISI_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date bisiDaStartValidity;

    @Column(name = "BISI_ID_CUST_INQUIRY_SPEC_ITEM", nullable = false, precision = 8, unique = true)
    @GeneratedValue(generator = "CNALP_CUST_INQUIRY_SPEC_ITEM_BISIIDCUSTINQUIRYSPECITEM_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALP_CUST_INQUIRY_SPEC_ITEM_BISIIDCUSTINQUIRYSPECITEM_GENERATOR", sequenceName = "CNAL_CUST_INQUIRY_SP_ITEM_SEQ")
    private Long bisiIdCustInquirySpecItem;

    @Column(name = "CISI_IN_ALL_STATE_VALUES")
    @Convert("BigDecimalBooleanConverter")
    private Boolean cisiInAllStateValues;

    @Column(name = "CISI_IN_ALL_VALUES", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean cisiInAllValues;

    @Column(name = "CISI_IN_CIS_ITEM_TYPE", nullable = false, precision = 1)
    private Long cisiInCisItemType;

    @Column(name = "PROF_ID_PRODUCT_OFFERING", precision = 5)
    private Long profIdProductOffering;

    @Column(name = "PRSP_ID_PRODUCT_SPEC", precision = 5)
    private Long prspIdProductSpec;

    @Column(name = "PRST_ID_PROD_SPEC_STATUS", precision = 2)
    private Long prstIdProdSpecStatus;

    @Column(name = "SESP_ID_SERVICE_SPEC", precision = 7)
    private Long sespIdServiceSpec;

    @Column(name = "SSTA_ID_SERV_SPEC_STATUS", precision = 2)
    private Long sstaIdServSpecStatus;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

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

    public Date getBisiDaEndValidity() {
        if (this.bisiDaEndValidity != null)
            return (Date) this.bisiDaEndValidity.clone();
        else
            return null;
    }

    public void setBisiDaEndValidity(Date bisiDaEndValidity) {
        if (bisiDaEndValidity != null)
            this.bisiDaEndValidity = (Date) bisiDaEndValidity.clone();
        else
            this.bisiDaEndValidity = bisiDaEndValidity;
    }

    public Date getBisiDaStartValidity() {
        if (this.bisiDaStartValidity != null)
            return (Date) this.bisiDaStartValidity.clone();
        else
            return null;
    }

    public void setBisiDaStartValidity(Date bisiDaStartValidity) {
        if (bisiDaStartValidity != null)
            this.bisiDaStartValidity = (Date) bisiDaStartValidity.clone();
        else
            this.bisiDaStartValidity = bisiDaStartValidity;
    }

    public Long getBisiIdCustInquirySpecItem() {
        return this.bisiIdCustInquirySpecItem;
    }

    public void setBisiIdCustInquirySpecItem(Long bisiIdCustInquirySpecItem) {
        this.bisiIdCustInquirySpecItem = bisiIdCustInquirySpecItem;
    }

    public Boolean getCisiInAllStateValues() {
        return this.cisiInAllStateValues;
    }

    public void setCisiInAllStateValues(Boolean cisiInAllStateValues) {
        this.cisiInAllStateValues = cisiInAllStateValues;
    }

    public Boolean getCisiInAllValues() {
        return this.cisiInAllValues;
    }

    public void setCisiInAllValues(Boolean cisiInAllValues) {
        this.cisiInAllValues = cisiInAllValues;
    }

    public Long getCisiInCisItemType() {
        return this.cisiInCisItemType;
    }

    public void setCisiInCisItemType(Long cisiInCisItemType) {
        this.cisiInCisItemType = cisiInCisItemType;
    }

    public Long getProfIdProductOffering() {
        return this.profIdProductOffering;
    }

    public void setProfIdProductOffering(Long profIdProductOffering) {
        this.profIdProductOffering = profIdProductOffering;
    }

    public Long getPrspIdProductSpec() {
        return this.prspIdProductSpec;
    }

    public void setPrspIdProductSpec(Long prspIdProductSpec) {
        this.prspIdProductSpec = prspIdProductSpec;
    }

    public Long getPrstIdProdSpecStatus() {
        return this.prstIdProdSpecStatus;
    }

    public void setPrstIdProdSpecStatus(Long prstIdProdSpecStatus) {
        this.prstIdProdSpecStatus = prstIdProdSpecStatus;
    }

    public Long getSespIdServiceSpec() {
        return this.sespIdServiceSpec;
    }

    public void setSespIdServiceSpec(Long sespIdServiceSpec) {
        this.sespIdServiceSpec = sespIdServiceSpec;
    }

    public Long getSstaIdServSpecStatus() {
        return this.sstaIdServSpecStatus;
    }

    public void setSstaIdServSpecStatus(Long sstaIdServSpecStatus) {
        this.sstaIdServSpecStatus = sstaIdServSpecStatus;
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
