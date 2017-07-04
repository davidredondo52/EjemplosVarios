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
 * The persistent class for the CnalrOrgaPoolAssignmentS database table.
 */
@Entity
@NamedQuery(name = "CnalrOrgaPoolAssignment.findAll", query = "SELECT c FROM CnalrOrgaPoolAssignment c")
@Table(name = "CNALR_ORGA_POOL_ASSIGNMENT", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "WPOO_ID_FUNCTIONAL_POOL", "PARO_ID_ORGANIZATION_ROLE" }) })
public class CnalrOrgaPoolAssignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "OPAS_ID_ORGA_POOL_ASSIGNMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal opasIdOrgaPoolAssignment;

    @Column(name = "PARO_ID_ORGANIZATION_ROLE", precision = 38)
    private BigDecimal paroIdOrganizationRole;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @OneToMany(mappedBy = "cnalrOrgaPoolAssignment1")
    private List<CnalaTaskMailbox> cnalaTaskMailboxs1;
    @OneToMany(mappedBy = "cnalrOrgaPoolAssignment2")
    private List<CnalaTaskMailbox> cnalaTaskMailboxs2;
    @JoinColumn(name = "WPOO_ID_FUNCTIONAL_POOL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpFunctionalPool cnalpFunctionalPool;
    @OneToMany(mappedBy = "cnalrOrgaPoolAssignment", cascade = { CascadeType.ALL })
    private List<CnalrOrgaPoolProduct> cnalrOrgaPoolProducts;

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

    public BigDecimal getOpasIdOrgaPoolAssignment() {
        return this.opasIdOrgaPoolAssignment;
    }

    public void setOpasIdOrgaPoolAssignment(BigDecimal opasIdOrgaPoolAssignment) {
        this.opasIdOrgaPoolAssignment = opasIdOrgaPoolAssignment;
    }

    public BigDecimal getParoIdOrganizationRole() {
        return this.paroIdOrganizationRole;
    }

    public void setParoIdOrganizationRole(BigDecimal paroIdOrganizationRole) {
        this.paroIdOrganizationRole = paroIdOrganizationRole;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public List<CnalaTaskMailbox> getCnalaTaskMailboxs1() {
        return this.cnalaTaskMailboxs1;
    }

    public void setCnalaTaskMailboxs1(List<CnalaTaskMailbox> cnalaTaskMailboxs1) {
        this.cnalaTaskMailboxs1 = cnalaTaskMailboxs1;
    }

    public void addCnalaTaskMailboxs1(CnalaTaskMailbox cnalaTaskMailbox) {
        if (this.cnalaTaskMailboxs1 == null)
            this.cnalaTaskMailboxs1 = new ArrayList<CnalaTaskMailbox>();
        this.cnalaTaskMailboxs1.add(cnalaTaskMailbox);
    }

    public void removeCnalaTaskMailboxs1(CnalaTaskMailbox cnalaTaskMailboxToRemove) {
        if (cnalaTaskMailboxToRemove != null)
            this.cnalaTaskMailboxs1.remove(cnalaTaskMailboxToRemove);
    }

    public List<CnalaTaskMailbox> getCnalaTaskMailboxs2() {
        return this.cnalaTaskMailboxs2;
    }

    public void setCnalaTaskMailboxs2(List<CnalaTaskMailbox> cnalaTaskMailboxs2) {
        this.cnalaTaskMailboxs2 = cnalaTaskMailboxs2;
    }

    public void addCnalaTaskMailboxs2(CnalaTaskMailbox cnalaTaskMailbox) {
        if (this.cnalaTaskMailboxs2 == null)
            this.cnalaTaskMailboxs2 = new ArrayList<CnalaTaskMailbox>();
        this.cnalaTaskMailboxs2.add(cnalaTaskMailbox);
    }

    public void removeCnalaTaskMailboxs2(CnalaTaskMailbox cnalaTaskMailboxToRemove) {
        if (cnalaTaskMailboxToRemove != null)
            this.cnalaTaskMailboxs2.remove(cnalaTaskMailboxToRemove);
    }

    public CnalpFunctionalPool getCnalpFunctionalPool() {
        return this.cnalpFunctionalPool;
    }

    public void setCnalpFunctionalPool(CnalpFunctionalPool cnalpFunctionalPool) {
        this.cnalpFunctionalPool = cnalpFunctionalPool;
    }

    public List<CnalrOrgaPoolProduct> getCnalrOrgaPoolProducts() {
        return this.cnalrOrgaPoolProducts;
    }

    public void setCnalrOrgaPoolProducts(List<CnalrOrgaPoolProduct> cnalrOrgaPoolProducts) {
        this.cnalrOrgaPoolProducts = cnalrOrgaPoolProducts;
    }

    public void addCnalrOrgaPoolProducts(CnalrOrgaPoolProduct cnalrOrgaPoolProduct) {
        if (this.cnalrOrgaPoolProducts == null)
            this.cnalrOrgaPoolProducts = new ArrayList<CnalrOrgaPoolProduct>();
        this.cnalrOrgaPoolProducts.add(cnalrOrgaPoolProduct);
    }

    public void removeCnalrOrgaPoolProducts(CnalrOrgaPoolProduct cnalrOrgaPoolProductToRemove) {
        if (cnalrOrgaPoolProductToRemove != null)
            this.cnalrOrgaPoolProducts.remove(cnalrOrgaPoolProductToRemove);
    }

}
