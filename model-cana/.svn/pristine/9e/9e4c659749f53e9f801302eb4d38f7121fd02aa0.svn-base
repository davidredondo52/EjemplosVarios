package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the CnaldCustomerInquirySubtypeS database table.
 */
@Entity
@NamedQuery(name = "CnaldCustomerInquirySubtype.findAll", query = "SELECT c FROM CnaldCustomerInquirySubtype c")
@Table(name = "CNALD_CUSTOMER_INQUIRY_SUBTYPE")
public class CnaldCustomerInquirySubtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "CIMT_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date cimtDaEndValidity;

    @Column(columnDefinition = "DATE", name = "CIMT_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date cimtDaStartValidity;

    @Column(name = "CIMT_ID_CUST_INQUIRY_SUBTYPE", nullable = false, precision = 3, unique = true)
    @GeneratedValue(generator = "CNALD_CUSTOMER_INQUIRY_SUBTYPE_CIMTIDCUSTINQUIRYSUBTYPE_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALD_CUSTOMER_INQUIRY_SUBTYPE_CIMTIDCUSTINQUIRYSUBTYPE_GENERATOR", sequenceName = "CNAL_CUST_INQUIRY_SUBTYPE_SEQ")
    private Long cimtIdCustInquirySubtype;

    @Column(length = 500, name = "LIST_DS_CUST_INQUIRY_SUBTYPE")
    private String listDsCustInquirySubtype;

    @Column(length = 100, name = "LIST_NA_CUST_INQUIRY_SUBTYPE", nullable = false)
    private String listNaCustInquirySubtype;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnaldCustomerInquirySubtype")
    private List<CnalpCustomerInquirySpec> cnalpCustomerInquirySpecs;
    @OneToMany(mappedBy = "cnaldCustomerInquirySubtype", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrCustInquirySubtypeL> cnalrCustInquirySubtypeLs;

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

    public Date getCimtDaEndValidity() {
        if (this.cimtDaEndValidity != null)
            return (Date) this.cimtDaEndValidity.clone();
        else
            return null;
    }

    public void setCimtDaEndValidity(Date cimtDaEndValidity) {
        if (cimtDaEndValidity != null)
            this.cimtDaEndValidity = (Date) cimtDaEndValidity.clone();
        else
            this.cimtDaEndValidity = cimtDaEndValidity;
    }

    public Date getCimtDaStartValidity() {
        if (this.cimtDaStartValidity != null)
            return (Date) this.cimtDaStartValidity.clone();
        else
            return null;
    }

    public void setCimtDaStartValidity(Date cimtDaStartValidity) {
        if (cimtDaStartValidity != null)
            this.cimtDaStartValidity = (Date) cimtDaStartValidity.clone();
        else
            this.cimtDaStartValidity = cimtDaStartValidity;
    }

    public Long getCimtIdCustInquirySubtype() {
        return this.cimtIdCustInquirySubtype;
    }

    public void setCimtIdCustInquirySubtype(Long cimtIdCustInquirySubtype) {
        this.cimtIdCustInquirySubtype = cimtIdCustInquirySubtype;
    }

    public String getListDsCustInquirySubtype() {
        return this.listDsCustInquirySubtype;
    }

    public void setListDsCustInquirySubtype(String listDsCustInquirySubtype) {
        this.listDsCustInquirySubtype = listDsCustInquirySubtype;
    }

    public String getListNaCustInquirySubtype() {
        return this.listNaCustInquirySubtype;
    }

    public void setListNaCustInquirySubtype(String listNaCustInquirySubtype) {
        this.listNaCustInquirySubtype = listNaCustInquirySubtype;
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

    public List<CnalpCustomerInquirySpec> getCnalpCustomerInquirySpecs() {
        return this.cnalpCustomerInquirySpecs;
    }

    public void setCnalpCustomerInquirySpecs(List<CnalpCustomerInquirySpec> cnalpCustomerInquirySpecs) {
        this.cnalpCustomerInquirySpecs = cnalpCustomerInquirySpecs;
    }

    public void addCnalpCustomerInquirySpecs(CnalpCustomerInquirySpec cnalpCustomerInquirySpec) {
        if (this.cnalpCustomerInquirySpecs == null)
            this.cnalpCustomerInquirySpecs = new ArrayList<CnalpCustomerInquirySpec>();
        this.cnalpCustomerInquirySpecs.add(cnalpCustomerInquirySpec);
    }

    public void removeCnalpCustomerInquirySpecs(CnalpCustomerInquirySpec cnalpCustomerInquirySpecToRemove) {
        if (cnalpCustomerInquirySpecToRemove != null)
            this.cnalpCustomerInquirySpecs.remove(cnalpCustomerInquirySpecToRemove);
    }

    public List<CnalrCustInquirySubtypeL> getCnalrCustInquirySubtypeLs() {
        return this.cnalrCustInquirySubtypeLs;
    }

    public void setCnalrCustInquirySubtypeLs(List<CnalrCustInquirySubtypeL> cnalrCustInquirySubtypeLs) {
        this.cnalrCustInquirySubtypeLs = cnalrCustInquirySubtypeLs;
    }

    public void addCnalrCustInquirySubtypeLs(CnalrCustInquirySubtypeL cnalrCustInquirySubtypeL) {
        if (this.cnalrCustInquirySubtypeLs == null)
            this.cnalrCustInquirySubtypeLs = new ArrayList<CnalrCustInquirySubtypeL>();
        this.cnalrCustInquirySubtypeLs.add(cnalrCustInquirySubtypeL);
    }

    public void removeCnalrCustInquirySubtypeLs(CnalrCustInquirySubtypeL cnalrCustInquirySubtypeLToRemove) {
        if (cnalrCustInquirySubtypeLToRemove != null)
            this.cnalrCustInquirySubtypeLs.remove(cnalrCustInquirySubtypeLToRemove);
    }

}
