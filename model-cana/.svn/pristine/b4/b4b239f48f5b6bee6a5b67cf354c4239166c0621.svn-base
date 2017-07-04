package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ScdedCustomerItemTypeS database table.
 */
@Entity
@NamedQuery(name = "ScdedCustomerItemType.findAll", query = "SELECT s FROM ScdedCustomerItemType s")
@Table(name = "SCDED_CUSTOMER_ITEM_TYPE")
public class ScdedCustomerItemType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "CITY_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date cityDaEndValidity;

    @Column(columnDefinition = "DATE", name = "CITY_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date cityDaStartValidity;

    @Column(name = "CITY_ID_CUSTOMER_ITEM_TYPE", nullable = false, precision = 2, unique = true)
    @Id
    private Long cityIdCustomerItemType;

    @Column(length = 100, name = "CITY_NA_CUSTOMER_ITEM_TYPE", nullable = false)
    private String cityNaCustomerItemType;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "scdedCustomerItemType")
    private List<ScderCustomerImpact> scderCustomerImpacts;

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

    public Date getCityDaEndValidity() {
        if (this.cityDaEndValidity != null)
            return (Date) this.cityDaEndValidity.clone();
        else
            return null;
    }

    public void setCityDaEndValidity(Date cityDaEndValidity) {
        if (cityDaEndValidity != null)
            this.cityDaEndValidity = (Date) cityDaEndValidity.clone();
        else
            this.cityDaEndValidity = cityDaEndValidity;
    }

    public Date getCityDaStartValidity() {
        if (this.cityDaStartValidity != null)
            return (Date) this.cityDaStartValidity.clone();
        else
            return null;
    }

    public void setCityDaStartValidity(Date cityDaStartValidity) {
        if (cityDaStartValidity != null)
            this.cityDaStartValidity = (Date) cityDaStartValidity.clone();
        else
            this.cityDaStartValidity = cityDaStartValidity;
    }

    public Long getCityIdCustomerItemType() {
        return this.cityIdCustomerItemType;
    }

    public void setCityIdCustomerItemType(Long cityIdCustomerItemType) {
        this.cityIdCustomerItemType = cityIdCustomerItemType;
    }

    public String getCityNaCustomerItemType() {
        return this.cityNaCustomerItemType;
    }

    public void setCityNaCustomerItemType(String cityNaCustomerItemType) {
        this.cityNaCustomerItemType = cityNaCustomerItemType;
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

    public List<ScderCustomerImpact> getScderCustomerImpacts() {
        return this.scderCustomerImpacts;
    }

    public void setScderCustomerImpacts(List<ScderCustomerImpact> scderCustomerImpacts) {
        this.scderCustomerImpacts = scderCustomerImpacts;
    }

    public void addScderCustomerImpacts(ScderCustomerImpact scderCustomerImpact) {
        if (this.scderCustomerImpacts == null)
            this.scderCustomerImpacts = new ArrayList<ScderCustomerImpact>();
        this.scderCustomerImpacts.add(scderCustomerImpact);
    }

    public void removeScderCustomerImpacts(ScderCustomerImpact scderCustomerImpactToRemove) {
        if (scderCustomerImpactToRemove != null)
            this.scderCustomerImpacts.remove(scderCustomerImpactToRemove);
    }

}
