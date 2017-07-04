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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the CnalaTemplateLabelS database table.
 */
@Entity
@NamedQuery(name = "CnalaTemplateLabel.findAll", query = "SELECT c FROM CnalaTemplateLabel c")
@Table(name = "CNALA_TEMPLATE_LABEL", uniqueConstraints = { @UniqueConstraint(columnNames = { "TPTE_ID_TEMPLATE",
        "TPTE_ID_SUBTEMPLATE" }) })
public class CnalaTemplateLabel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(name = "TLAB_ID_TEMPLATE_LABEL", nullable = false, precision = 5, unique = true)
    @GeneratedValue(generator = "CNALA_TEMPLATE_LABEL_TLABIDTEMPLATELABEL_GENERATOR")
    @Id
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "CNALA_TEMPLATE_LABEL_TLABIDTEMPLATELABEL_GENERATOR", sequenceName = "CNAL_TEMPLATE_LABEL_SEQ")
    private Long tlabIdTemplateLabel;

    @Column(length = 100, name = "TLAB_NA_TEMPLATE_LABEL", nullable = false)
    private String tlabNaTemplateLabel;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "cnalaTemplateLabel")
    private List<CnalaLabelSubtemplate> cnalaLabelSubtemplates;
    @JoinColumn(name = "TPTE_ID_TEMPLATE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpTemplate cnalpTemplate1;
    @JoinColumn(name = "TPTE_ID_SUBTEMPLATE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private CnalpTemplate cnalpTemplate2;

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

    public Long getTlabIdTemplateLabel() {
        return this.tlabIdTemplateLabel;
    }

    public void setTlabIdTemplateLabel(Long tlabIdTemplateLabel) {
        this.tlabIdTemplateLabel = tlabIdTemplateLabel;
    }

    public String getTlabNaTemplateLabel() {
        return this.tlabNaTemplateLabel;
    }

    public void setTlabNaTemplateLabel(String tlabNaTemplateLabel) {
        this.tlabNaTemplateLabel = tlabNaTemplateLabel;
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

    public List<CnalaLabelSubtemplate> getCnalaLabelSubtemplates() {
        return this.cnalaLabelSubtemplates;
    }

    public void setCnalaLabelSubtemplates(List<CnalaLabelSubtemplate> cnalaLabelSubtemplates) {
        this.cnalaLabelSubtemplates = cnalaLabelSubtemplates;
    }

    public void addCnalaLabelSubtemplates(CnalaLabelSubtemplate cnalaLabelSubtemplate) {
        if (this.cnalaLabelSubtemplates == null)
            this.cnalaLabelSubtemplates = new ArrayList<CnalaLabelSubtemplate>();
        this.cnalaLabelSubtemplates.add(cnalaLabelSubtemplate);
    }

    public void removeCnalaLabelSubtemplates(CnalaLabelSubtemplate cnalaLabelSubtemplateToRemove) {
        if (cnalaLabelSubtemplateToRemove != null)
            this.cnalaLabelSubtemplates.remove(cnalaLabelSubtemplateToRemove);
    }

    public CnalpTemplate getCnalpTemplate1() {
        return this.cnalpTemplate1;
    }

    public void setCnalpTemplate1(CnalpTemplate cnalpTemplate1) {
        this.cnalpTemplate1 = cnalpTemplate1;
    }

    public CnalpTemplate getCnalpTemplate2() {
        return this.cnalpTemplate2;
    }

    public void setCnalpTemplate2(CnalpTemplate cnalpTemplate2) {
        this.cnalpTemplate2 = cnalpTemplate2;
    }

}
