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
 * The persistent class for the CnaldCustomerInquiryTypeS database table.
 */
@Entity
@NamedQuery(name = "CnaldCustomerInquiryType.findAll", query = "SELECT c FROM CnaldCustomerInquiryType c")
@Table(name = "CNALD_CUSTOMER_INQUIRY_TYPE")
public class CnaldCustomerInquiryType implements Serializable {
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

    @Column(name = "CIMT_ID_CUST_INQUIRY_TYPE", nullable = false, precision = 3, unique = true)
    @GeneratedValue(generator = "CNALD_CUSTOMER_INQUIRY_TYPE_CIMTIDCUSTINQUIRYTYPE_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALD_CUSTOMER_INQUIRY_TYPE_CIMTIDCUSTINQUIRYTYPE_GENERATOR", sequenceName = "CNAL_CUST_INQUIRY_TYPE_SEQ")
    private Long cimtIdCustInquiryType;

    @Column(length = 500, name = "LCIT_DS_CUST_INQUIRY_TYPE")
    private String lcitDsCustInquiryType;

    @Column(length = 100, name = "LCIT_NA_CUST_INQUIRY_TYPE", nullable = false)
    private String lcitNaCustInquiryType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnaldCustomerInquiryType")
    private List<CnalaCustInquTypeTreeNode> cnalaCustInquTypeTreeNodes;
    @OneToMany(mappedBy = "cnaldCustomerInquiryType", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CnalrCustomerInquiryTypeL> cnalrCustomerInquiryTypeLs;

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

    public Long getCimtIdCustInquiryType() {
        return this.cimtIdCustInquiryType;
    }

    public void setCimtIdCustInquiryType(Long cimtIdCustInquiryType) {
        this.cimtIdCustInquiryType = cimtIdCustInquiryType;
    }

    public String getLcitDsCustInquiryType() {
        return this.lcitDsCustInquiryType;
    }

    public void setLcitDsCustInquiryType(String lcitDsCustInquiryType) {
        this.lcitDsCustInquiryType = lcitDsCustInquiryType;
    }

    public String getLcitNaCustInquiryType() {
        return this.lcitNaCustInquiryType;
    }

    public void setLcitNaCustInquiryType(String lcitNaCustInquiryType) {
        this.lcitNaCustInquiryType = lcitNaCustInquiryType;
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

    public List<CnalaCustInquTypeTreeNode> getCnalaCustInquTypeTreeNodes() {
        return this.cnalaCustInquTypeTreeNodes;
    }

    public void setCnalaCustInquTypeTreeNodes(List<CnalaCustInquTypeTreeNode> cnalaCustInquTypeTreeNodes) {
        this.cnalaCustInquTypeTreeNodes = cnalaCustInquTypeTreeNodes;
    }

    public void addCnalaCustInquTypeTreeNodes(CnalaCustInquTypeTreeNode cnalaCustInquTypeTreeNode) {
        if (this.cnalaCustInquTypeTreeNodes == null)
            this.cnalaCustInquTypeTreeNodes = new ArrayList<CnalaCustInquTypeTreeNode>();
        this.cnalaCustInquTypeTreeNodes.add(cnalaCustInquTypeTreeNode);
    }

    public void removeCnalaCustInquTypeTreeNodes(CnalaCustInquTypeTreeNode cnalaCustInquTypeTreeNodeToRemove) {
        if (cnalaCustInquTypeTreeNodeToRemove != null)
            this.cnalaCustInquTypeTreeNodes.remove(cnalaCustInquTypeTreeNodeToRemove);
    }

    public List<CnalrCustomerInquiryTypeL> getCnalrCustomerInquiryTypeLs() {
        return this.cnalrCustomerInquiryTypeLs;
    }

    public void setCnalrCustomerInquiryTypeLs(List<CnalrCustomerInquiryTypeL> cnalrCustomerInquiryTypeLs) {
        this.cnalrCustomerInquiryTypeLs = cnalrCustomerInquiryTypeLs;
    }

    public void addCnalrCustomerInquiryTypeLs(CnalrCustomerInquiryTypeL cnalrCustomerInquiryTypeL) {
        if (this.cnalrCustomerInquiryTypeLs == null)
            this.cnalrCustomerInquiryTypeLs = new ArrayList<CnalrCustomerInquiryTypeL>();
        this.cnalrCustomerInquiryTypeLs.add(cnalrCustomerInquiryTypeL);
    }

    public void removeCnalrCustomerInquiryTypeLs(CnalrCustomerInquiryTypeL cnalrCustomerInquiryTypeLToRemove) {
        if (cnalrCustomerInquiryTypeLToRemove != null)
            this.cnalrCustomerInquiryTypeLs.remove(cnalrCustomerInquiryTypeLToRemove);
    }

}
