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
 * The persistent class for the CnaldDocumentFormatS database table.
 */
@Entity
@NamedQuery(name = "CnaldDocumentFormat.findAll", query = "SELECT c FROM CnaldDocumentFormat c")
@Table(name = "CNALD_DOCUMENT_FORMAT")
public class CnaldDocumentFormat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(columnDefinition = "DATE", name = "DOFO_DA_END_VALIDITY")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dofoDaEndValidity;

    @Column(columnDefinition = "DATE", name = "DOFO_DA_START_VALIDITY", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dofoDaStartValidity;

    @Column(name = "DOFO_ID_DOCUMENT_FORMAT", nullable = false, precision = 2, unique = true)
    @Id
    private Long dofoIdDocumentFormat;

    @Column(length = 50, name = "DOFO_NA_DOCUMENT_FORMAT", nullable = false)
    private String dofoNaDocumentFormat;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnaldDocumentFormat")
    private List<CnalpTemplate> cnalpTemplates;

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

    public Date getDofoDaEndValidity() {
        if (this.dofoDaEndValidity != null)
            return (Date) this.dofoDaEndValidity.clone();
        else
            return null;
    }

    public void setDofoDaEndValidity(Date dofoDaEndValidity) {
        if (dofoDaEndValidity != null)
            this.dofoDaEndValidity = (Date) dofoDaEndValidity.clone();
        else
            this.dofoDaEndValidity = dofoDaEndValidity;
    }

    public Date getDofoDaStartValidity() {
        if (this.dofoDaStartValidity != null)
            return (Date) this.dofoDaStartValidity.clone();
        else
            return null;
    }

    public void setDofoDaStartValidity(Date dofoDaStartValidity) {
        if (dofoDaStartValidity != null)
            this.dofoDaStartValidity = (Date) dofoDaStartValidity.clone();
        else
            this.dofoDaStartValidity = dofoDaStartValidity;
    }

    public Long getDofoIdDocumentFormat() {
        return this.dofoIdDocumentFormat;
    }

    public void setDofoIdDocumentFormat(Long dofoIdDocumentFormat) {
        this.dofoIdDocumentFormat = dofoIdDocumentFormat;
    }

    public String getDofoNaDocumentFormat() {
        return this.dofoNaDocumentFormat;
    }

    public void setDofoNaDocumentFormat(String dofoNaDocumentFormat) {
        this.dofoNaDocumentFormat = dofoNaDocumentFormat;
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

    public List<CnalpTemplate> getCnalpTemplates() {
        return this.cnalpTemplates;
    }

    public void setCnalpTemplates(List<CnalpTemplate> cnalpTemplates) {
        this.cnalpTemplates = cnalpTemplates;
    }

    public void addCnalpTemplates(CnalpTemplate cnalpTemplate) {
        if (this.cnalpTemplates == null)
            this.cnalpTemplates = new ArrayList<CnalpTemplate>();
        this.cnalpTemplates.add(cnalpTemplate);
    }

    public void removeCnalpTemplates(CnalpTemplate cnalpTemplateToRemove) {
        if (cnalpTemplateToRemove != null)
            this.cnalpTemplates.remove(cnalpTemplateToRemove);
    }

}
