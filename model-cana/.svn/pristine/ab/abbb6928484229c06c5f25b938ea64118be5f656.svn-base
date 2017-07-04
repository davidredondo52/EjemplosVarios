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
 * The persistent class for the CnalrEnteFunctionToolTypeS database table.
 */
@Entity
@NamedQuery(name = "CnalrEnteFunctionToolType.findAll", query = "SELECT c FROM CnalrEnteFunctionToolType c")
@Table(name = "CNALR_ENTE_FUNCTION_TOOL_TYPE", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "ENFU_ID_ENTERPRISE_FUNCTION", "TOTY_ID_TOOL_TYPE" }) })
public class CnalrEnteFunctionToolType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "EFTT_ID_ENTE_FUNCT_TOOL_TYPE", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal efttIdEnteFunctToolType;

    @Column(name = "TOTY_ID_TOOL_TYPE", nullable = false, precision = 3)
    private Long totyIdToolType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "ENFU_ID_ENTERPRISE_FUNCTION", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldEnterpriseFunction cnaldEnterpriseFunction;

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

    public BigDecimal getEfttIdEnteFunctToolType() {
        return this.efttIdEnteFunctToolType;
    }

    public void setEfttIdEnteFunctToolType(BigDecimal efttIdEnteFunctToolType) {
        this.efttIdEnteFunctToolType = efttIdEnteFunctToolType;
    }

    public Long getTotyIdToolType() {
        return this.totyIdToolType;
    }

    public void setTotyIdToolType(Long totyIdToolType) {
        this.totyIdToolType = totyIdToolType;
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

}
