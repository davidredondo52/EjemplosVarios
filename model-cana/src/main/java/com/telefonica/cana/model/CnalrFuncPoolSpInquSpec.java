package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the CnalrFuncPoolSpInquSpecS database table.
 */
@Entity
@NamedQuery(name = "CnalrFuncPoolSpInquSpec.findAll", query = "SELECT c FROM CnalrFuncPoolSpInquSpec c")
@Table(name = "CNALR_FUNC_POOL_SP_INQU_SPEC", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BISP_ID_CUST_INQUIRY_SPEC", "FUPS_ID_FUNCTIONAL_POOL_SPEC" }) })
public class CnalrFuncPoolSpInquSpec implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "PSIS_ID_FUNC_POOL_SPEC_INQU_SP", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal psisIdFuncPoolSpecInquSp;

    @Column(name = "PSIS_NU_FREQUENT", precision = 3)
    private Long psisNuFrequent;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @JoinColumn(name = "BISP_ID_CUST_INQUIRY_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpCustomerInquirySpec cnalpCustomerInquirySpec;
    @JoinColumn(name = "FUPS_ID_FUNCTIONAL_POOL_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpFunctionalPoolSpec cnalpFunctionalPoolSpec;
    @OneToMany(mappedBy = "cnalrFuncPoolSpInquSpec", cascade = { CascadeType.ALL })
    private List<CnalrFuncPoolSpecProcess> cnalrFuncPoolSpecProcesses;

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

    public BigDecimal getPsisIdFuncPoolSpecInquSp() {
        return this.psisIdFuncPoolSpecInquSp;
    }

    public void setPsisIdFuncPoolSpecInquSp(BigDecimal psisIdFuncPoolSpecInquSp) {
        this.psisIdFuncPoolSpecInquSp = psisIdFuncPoolSpecInquSp;
    }

    public Long getPsisNuFrequent() {
        return this.psisNuFrequent;
    }

    public void setPsisNuFrequent(Long psisNuFrequent) {
        this.psisNuFrequent = psisNuFrequent;
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

    public CnalpFunctionalPoolSpec getCnalpFunctionalPoolSpec() {
        return this.cnalpFunctionalPoolSpec;
    }

    public void setCnalpFunctionalPoolSpec(CnalpFunctionalPoolSpec cnalpFunctionalPoolSpec) {
        this.cnalpFunctionalPoolSpec = cnalpFunctionalPoolSpec;
    }

    public List<CnalrFuncPoolSpecProcess> getCnalrFuncPoolSpecProcesses() {
        return this.cnalrFuncPoolSpecProcesses;
    }

    public void setCnalrFuncPoolSpecProcesses(List<CnalrFuncPoolSpecProcess> cnalrFuncPoolSpecProcesses) {
        this.cnalrFuncPoolSpecProcesses = cnalrFuncPoolSpecProcesses;
    }

    public void addCnalrFuncPoolSpecProcesses(CnalrFuncPoolSpecProcess cnalrFuncPoolSpecProcess) {
        if (this.cnalrFuncPoolSpecProcesses == null)
            this.cnalrFuncPoolSpecProcesses = new ArrayList<CnalrFuncPoolSpecProcess>();
        this.cnalrFuncPoolSpecProcesses.add(cnalrFuncPoolSpecProcess);
    }

    public void removeCnalrFuncPoolSpecProcesses(CnalrFuncPoolSpecProcess cnalrFuncPoolSpecProcessToRemove) {
        if (cnalrFuncPoolSpecProcessToRemove != null)
            this.cnalrFuncPoolSpecProcesses.remove(cnalrFuncPoolSpecProcessToRemove);
    }

}
