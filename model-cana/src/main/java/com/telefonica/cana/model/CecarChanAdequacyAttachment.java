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
 * The persistent class for the CecarChanAdequacyAttachmentS database table.
 */
@Entity
@NamedQuery(name = "CecarChanAdequacyAttachment.findAll", query = "SELECT c FROM CecarChanAdequacyAttachment c")
@Table(name = "CECAR_CHAN_ADEQUACY_ATTACHMENT", uniqueConstraints = { @UniqueConstraint(columnNames = {
        "BUIN_ID_SALES_CHANNEL_ADEQUACY", "BINT_ID_CHANNEL_ADEQUACY_TYPE", "ATTA_CO_DOCUMENT" }) })
public class CecarChanAdequacyAttachment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(length = 100, name = "ATTA_CO_DOCUMENT", nullable = false)
    private String attaCoDocument;

    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "BINT_ID_CHANNEL_ADEQUACY_TYPE", nullable = false, precision = 3)
    private Long bintIdChannelAdequacyType;


    @Column(name = "CECAR_ID_CHAN_ADEQ_ATTACHMENT", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal cecarIdChanAdeqAttachment;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;
    
    @JoinColumn(name = "BUIN_ID_SALES_CHANNEL_ADEQUACY")
    @ManyToOne(fetch = FetchType.LAZY)
    private ScdepSalesChannelDemand scdepSalesChannelDemand;
    // bi-directional many-to-one association to ScprpSalesChannelProposal
    @JoinColumn(insertable = false, name = "BUIN_ID_SALES_CHANNEL_ADEQUACY", updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScprpSalesChannelProposal scprpSalesChannelProposal;

    public String getAttaCoDocument() {
        return this.attaCoDocument;
    }

    public void setAttaCoDocument(String attaCoDocument) {
        this.attaCoDocument = attaCoDocument;
    }

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

    public Long getBintIdChannelAdequacyType() {
        return this.bintIdChannelAdequacyType;
    }

    public void setBintIdChannelAdequacyType(Long bintIdChannelAdequacyType) {
        this.bintIdChannelAdequacyType = bintIdChannelAdequacyType;
    }



    public BigDecimal getCecarIdChanAdeqAttachment() {
        return this.cecarIdChanAdeqAttachment;
    }

    public void setCecarIdChanAdeqAttachment(BigDecimal cecarIdChanAdeqAttachment) {
        this.cecarIdChanAdeqAttachment = cecarIdChanAdeqAttachment;
    }

    public BigDecimal getUserIdCreatorParty() {
        return this.userIdCreatorParty;
    }

    public void setUserIdCreatorParty(BigDecimal userIdCreatorParty) {
        this.userIdCreatorParty = userIdCreatorParty;
    }
    
    public ScdepSalesChannelDemand getScdepSalesChannelDemand() {
        return this.scdepSalesChannelDemand;
    }
    public void setScdepSalesChannelDemand(ScdepSalesChannelDemand scdepSalesChannelDemand) {
        this.scdepSalesChannelDemand = scdepSalesChannelDemand;
    }
    public ScprpSalesChannelProposal getScprpSalesChannelProposal() {
        return this.scprpSalesChannelProposal;
    }

    public void setScprpSalesChannelProposal(ScprpSalesChannelProposal scprpSalesChannelProposal) {
        this.scprpSalesChannelProposal = scprpSalesChannelProposal;
    }

}
