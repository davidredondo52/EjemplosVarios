package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
 * The persistent class for the CnalrFuncPoolSpChannelTyS database table.
 */
@Entity
@NamedQuery(name = "CnalrFuncPoolSpChannelTy.findAll", query = "SELECT c FROM CnalrFuncPoolSpChannelTy c")
@Table(name = "CNALR_FUNC_POOL_SP_CHANNEL_TY", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "CHAT_ID_CHANNEL_TYPE", "FUPS_ID_FUNCTIONAL_POOL_SPEC" }) })
public class CnalrFuncPoolSpChannelTy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "PSCT_ID_FUNC_POOL_SP_CHAN_TY", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal psctIdFuncPoolSpChanTy;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @JoinColumn(name = "CHAT_ID_CHANNEL_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnaldChannelType cnaldChannelType;
    @OneToMany(mappedBy = "cnalrFuncPoolSpChannelTy")
    private List<CnalpFunctionalPool> cnalpFunctionalPools;
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

    public BigDecimal getPsctIdFuncPoolSpChanTy() {
        return this.psctIdFuncPoolSpChanTy;
    }

    public void setPsctIdFuncPoolSpChanTy(BigDecimal psctIdFuncPoolSpChanTy) {
        this.psctIdFuncPoolSpChanTy = psctIdFuncPoolSpChanTy;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }

    public CnaldChannelType getCnaldChannelType() {
        return this.cnaldChannelType;
    }

    public void setCnaldChannelType(CnaldChannelType cnaldChannelType) {
        this.cnaldChannelType = cnaldChannelType;
    }

    public List<CnalpFunctionalPool> getCnalpFunctionalPools() {
        return this.cnalpFunctionalPools;
    }

    public void setCnalpFunctionalPools(List<CnalpFunctionalPool> cnalpFunctionalPools) {
        this.cnalpFunctionalPools = cnalpFunctionalPools;
    }

    public void addCnalpFunctionalPools(CnalpFunctionalPool cnalpFunctionalPool) {
        if (this.cnalpFunctionalPools == null)
            this.cnalpFunctionalPools = new ArrayList<CnalpFunctionalPool>();
        this.cnalpFunctionalPools.add(cnalpFunctionalPool);
    }

    public void removeCnalpFunctionalPools(CnalpFunctionalPool cnalpFunctionalPoolToRemove) {
        if (cnalpFunctionalPoolToRemove != null)
            this.cnalpFunctionalPools.remove(cnalpFunctionalPoolToRemove);
    }

    public CnalpFunctionalPoolSpec getCnalpFunctionalPoolSpec() {
        return this.cnalpFunctionalPoolSpec;
    }

    public void setCnalpFunctionalPoolSpec(CnalpFunctionalPoolSpec cnalpFunctionalPoolSpec) {
        this.cnalpFunctionalPoolSpec = cnalpFunctionalPoolSpec;
    }

}
