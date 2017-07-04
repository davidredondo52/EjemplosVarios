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
 * The persistent class for the CnalrFuncPoolSpEnteFunctS database table.
 */
@Entity
@NamedQuery(name = "CnalrFuncPoolSpEnteFunct.findAll", query = "SELECT c FROM CnalrFuncPoolSpEnteFunct c")
@Table(name = "CNALR_FUNC_POOL_SP_ENTE_FUNCT", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "CUFU_ID_ENTERPRISE_FUNCTION", "FUPS_ID_FUNCTIONAL_POOL_SPEC" }) })
public class CnalrFuncPoolSpEnteFunct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "PSCF_ID_FUNC_POOL_SP_ENTE_FUNC", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal pscfIdFuncPoolSpEnteFunc;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "CUFU_ID_ENTERPRISE_FUNCTION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldEnterpriseFunction cnaldEnterpriseFunction;
    @JoinColumn(name = "FUPS_ID_FUNCTIONAL_POOL_SPEC", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpFunctionalPoolSpec cnalpFunctionalPoolSpec;

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

    public BigDecimal getPscfIdFuncPoolSpEnteFunc() {
        return this.pscfIdFuncPoolSpEnteFunc;
    }

    public void setPscfIdFuncPoolSpEnteFunc(BigDecimal pscfIdFuncPoolSpEnteFunc) {
        this.pscfIdFuncPoolSpEnteFunc = pscfIdFuncPoolSpEnteFunc;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnaldEnterpriseFunction getCnaldEnterpriseFunction() {
        return this.cnaldEnterpriseFunction;
    }

    public void setCnaldEnterpriseFunction(CnaldEnterpriseFunction cnaldEnterpriseFunction) {
        this.cnaldEnterpriseFunction = cnaldEnterpriseFunction;
    }

    public CnalpFunctionalPoolSpec getCnalpFunctionalPoolSpec() {
        return this.cnalpFunctionalPoolSpec;
    }

    public void setCnalpFunctionalPoolSpec(CnalpFunctionalPoolSpec cnalpFunctionalPoolSpec) {
        this.cnalpFunctionalPoolSpec = cnalpFunctionalPoolSpec;
    }

}
