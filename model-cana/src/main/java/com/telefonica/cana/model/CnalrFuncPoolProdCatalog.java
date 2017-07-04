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
 * The persistent class for the CnalrFuncPoolProdCatalogS database table.
 */
@Entity
@NamedQuery(name = "CnalrFuncPoolProdCatalog.findAll", query = "SELECT c FROM CnalrFuncPoolProdCatalog c")
@Table(name = "CNALR_FUNC_POOL_PROD_CATALOG", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "WPOO_ID_FUNCTIONAL_POOL", "PRCA_ID_PRODUCT_CATALOG" }) })
public class CnalrFuncPoolProdCatalog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "FPPC_ID_FUNC_POOL_PROD_CATALOG", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal fppcIdFuncPoolProdCatalog;

    @Column(name = "PRCA_ID_PRODUCT_CATALOG", nullable = false, precision = 4)
    private Long prcaIdProductCatalog;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "WPOO_ID_FUNCTIONAL_POOL", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpFunctionalPool cnalpFunctionalPool;

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

    public BigDecimal getFppcIdFuncPoolProdCatalog() {
        return this.fppcIdFuncPoolProdCatalog;
    }

    public void setFppcIdFuncPoolProdCatalog(BigDecimal fppcIdFuncPoolProdCatalog) {
        this.fppcIdFuncPoolProdCatalog = fppcIdFuncPoolProdCatalog;
    }

    public Long getPrcaIdProductCatalog() {
        return this.prcaIdProductCatalog;
    }

    public void setPrcaIdProductCatalog(Long prcaIdProductCatalog) {
        this.prcaIdProductCatalog = prcaIdProductCatalog;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnalpFunctionalPool getCnalpFunctionalPool() {
        return this.cnalpFunctionalPool;
    }

    public void setCnalpFunctionalPool(CnalpFunctionalPool cnalpFunctionalPool) {
        this.cnalpFunctionalPool = cnalpFunctionalPool;
    }

}
