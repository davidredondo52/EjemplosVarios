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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the CnalrOrgaPoolProductS database table.
 */
@Entity
@NamedQuery(name = "CnalrOrgaPoolProduct.findAll", query = "SELECT c FROM CnalrOrgaPoolProduct c")
@Table(name = "CNALR_ORGA_POOL_PRODUCT", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "WPOO_ID_FUNCTIONAL_POOL", "PARO_ID_ORGANIZATION_ROLE", "CTLG_ID_CATALOG" }) })
public class CnalrOrgaPoolProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "CTLG_ID_CATALOG", nullable = false, precision = 4)
    private Long ctlgIdCatalog;

    @Column(name = "ORPP_ID_ORGROLE_POOL_PRODUCT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal orppIdOrgrolePoolProduct;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumns({
            @JoinColumn(referencedColumnName = "PARO_ID_ORGANIZATION_ROLE", nullable = false, name = "PARO_ID_ORGANIZATION_ROLE"),
            @JoinColumn(referencedColumnName = "WPOO_ID_FUNCTIONAL_POOL", nullable = false, name = "WPOO_ID_FUNCTIONAL_POOL") })
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment;

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

    public Long getCtlgIdCatalog() {
        return this.ctlgIdCatalog;
    }

    public void setCtlgIdCatalog(Long ctlgIdCatalog) {
        this.ctlgIdCatalog = ctlgIdCatalog;
    }

    public BigDecimal getOrppIdOrgrolePoolProduct() {
        return this.orppIdOrgrolePoolProduct;
    }

    public void setOrppIdOrgrolePoolProduct(BigDecimal orppIdOrgrolePoolProduct) {
        this.orppIdOrgrolePoolProduct = orppIdOrgrolePoolProduct;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnalrOrgaPoolAssignment getCnalrOrgaPoolAssignment() {
        return this.cnalrOrgaPoolAssignment;
    }

    public void setCnalrOrgaPoolAssignment(CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment) {
        this.cnalrOrgaPoolAssignment = cnalrOrgaPoolAssignment;
    }

}
