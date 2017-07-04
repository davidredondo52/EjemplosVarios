package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the PrdedWorkspaceFieldS database table.
 */
@Entity
@NamedQuery(name = "PrdedWorkspaceField.findAll", query = "SELECT p FROM PrdedWorkspaceField p")
@Table(name = "PRDED_WORKSPACE_FIELD")
public class PrdedWorkspaceField implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @Column(name = "WOFI_ID_WORKSPACE_FIELD", nullable = false, precision = 4, unique = true)
    @Id
    private Long wofiIdWorkspaceField;

    @Column(name = "WOFI_IN_FORMAT_FIELD", nullable = false, precision = 1)
    private Long wofiInFormatField;

    @Column(name = "WOFI_IN_UPDATABLE_LABEL", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean wofiInUpdatableLabel;

    @Column(name = "WOFI_IN_VISIBILITY", nullable = false, precision = 1)
    private Long wofiInVisibility;

    @Column(length = 50, name = "WOFI_NA_WORKSPACE_FIELD", nullable = false)
    private String wofiNaWorkspaceField;

    @Column(name = "WOFI_NU_DEFAULT_ORDER", nullable = false, precision = 4)
    private Long wofiNuDefaultOrder;

    @Column(name = "WOFI_NU_LENGTH_FIELD", nullable = false, precision = 5, scale = 2)
    private BigDecimal wofiNuLengthField;

    @Column(name = "WOFI_TI_END_VALIDITY")
    private Timestamp wofiTiEndValidity;

    @Column(name = "WOFI_TI_START_VALIDITY", nullable = false)
    private Timestamp wofiTiStartValidity;

    @OneToMany(mappedBy = "prdedWorkspaceField")
    private List<PrdeaUtSpecAlarm> prdeaUtSpecAlarms;
    @OneToMany(mappedBy = "prdedWorkspaceField", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<PrderSelectedField> prderSelectedFields;

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

    public Long getWofiIdWorkspaceField() {
        return this.wofiIdWorkspaceField;
    }

    public void setWofiIdWorkspaceField(Long wofiIdWorkspaceField) {
        this.wofiIdWorkspaceField = wofiIdWorkspaceField;
    }

    public Long getWofiInFormatField() {
        return this.wofiInFormatField;
    }

    public void setWofiInFormatField(Long wofiInFormatField) {
        this.wofiInFormatField = wofiInFormatField;
    }

    public Boolean getWofiInUpdatableLabel() {
        return this.wofiInUpdatableLabel;
    }

    public void setWofiInUpdatableLabel(Boolean wofiInUpdatableLabel) {
        this.wofiInUpdatableLabel = wofiInUpdatableLabel;
    }

    public Long getWofiInVisibility() {
        return this.wofiInVisibility;
    }

    public void setWofiInVisibility(Long wofiInVisibility) {
        this.wofiInVisibility = wofiInVisibility;
    }

    public String getWofiNaWorkspaceField() {
        return this.wofiNaWorkspaceField;
    }

    public void setWofiNaWorkspaceField(String wofiNaWorkspaceField) {
        this.wofiNaWorkspaceField = wofiNaWorkspaceField;
    }

    public Long getWofiNuDefaultOrder() {
        return this.wofiNuDefaultOrder;
    }

    public void setWofiNuDefaultOrder(Long wofiNuDefaultOrder) {
        this.wofiNuDefaultOrder = wofiNuDefaultOrder;
    }

    public BigDecimal getWofiNuLengthField() {
        return this.wofiNuLengthField;
    }

    public void setWofiNuLengthField(BigDecimal wofiNuLengthField) {
        this.wofiNuLengthField = wofiNuLengthField;
    }

    public Timestamp getWofiTiEndValidity() {
        if (this.wofiTiEndValidity != null)
            return (Timestamp) this.wofiTiEndValidity.clone();
        else
            return null;
    }

    public void setWofiTiEndValidity(Timestamp wofiTiEndValidity) {
        if (wofiTiEndValidity != null)
            this.wofiTiEndValidity = (Timestamp) wofiTiEndValidity.clone();
        else
            this.wofiTiEndValidity = wofiTiEndValidity;
    }

    public Timestamp getWofiTiStartValidity() {
        if (this.wofiTiStartValidity != null)
            return (Timestamp) this.wofiTiStartValidity.clone();
        else
            return null;
    }

    public void setWofiTiStartValidity(Timestamp wofiTiStartValidity) {
        if (wofiTiStartValidity != null)
            this.wofiTiStartValidity = (Timestamp) wofiTiStartValidity.clone();
        else
            this.wofiTiStartValidity = wofiTiStartValidity;
    }

    public List<PrdeaUtSpecAlarm> getPrdeaUtSpecAlarms() {
        return this.prdeaUtSpecAlarms;
    }

    public void setPrdeaUtSpecAlarms(List<PrdeaUtSpecAlarm> prdeaUtSpecAlarms) {
        this.prdeaUtSpecAlarms = prdeaUtSpecAlarms;
    }

    public void addPrdeaUtSpecAlarms(PrdeaUtSpecAlarm prdeaUtSpecAlarm) {
        if (this.prdeaUtSpecAlarms == null)
            this.prdeaUtSpecAlarms = new ArrayList<PrdeaUtSpecAlarm>();
        this.prdeaUtSpecAlarms.add(prdeaUtSpecAlarm);
    }

    public void removePrdeaUtSpecAlarms(PrdeaUtSpecAlarm prdeaUtSpecAlarmToRemove) {
        if (prdeaUtSpecAlarmToRemove != null)
            this.prdeaUtSpecAlarms.remove(prdeaUtSpecAlarmToRemove);
    }

    public List<PrderSelectedField> getPrderSelectedFields() {
        return this.prderSelectedFields;
    }

    public void setPrderSelectedFields(List<PrderSelectedField> prderSelectedFields) {
        this.prderSelectedFields = prderSelectedFields;
    }

    public void addPrderSelectedFields(PrderSelectedField prderSelectedField) {
        if (this.prderSelectedFields == null)
            this.prderSelectedFields = new ArrayList<PrderSelectedField>();
        this.prderSelectedFields.add(prderSelectedField);
    }

    public void removePrderSelectedFields(PrderSelectedField prderSelectedFieldToRemove) {
        if (prderSelectedFieldToRemove != null)
            this.prderSelectedFields.remove(prderSelectedFieldToRemove);
    }

}
