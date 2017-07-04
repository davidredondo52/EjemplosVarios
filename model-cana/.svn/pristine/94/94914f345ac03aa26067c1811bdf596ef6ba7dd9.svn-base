package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ScdepSalesChannelDemandS database table.
 */
@Entity
@NamedQuery(name = "ScdepSalesChannelDemand.findAll", query = "SELECT s FROM ScdepSalesChannelDemand s")
@Table(name = "SCDEP_SALES_CHANNEL_DEMAND")
public class ScdepSalesChannelDemand implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "AUDI_TI_CREATION", nullable = false)
    private Timestamp audiTiCreation;

    @Column(name = "AUDI_TI_UPDATE")
    private Timestamp audiTiUpdate;

    @Column(length = 14, name = "BUIN_CO_CHANNEL_DEMAND")
    private String buinCoChannelDemand;

    @Column(length = 500, name = "BUIN_DS_CHANNEL_DEMAND", nullable = false)
    private String buinDsChannelDemand;

    @Column(name = "BUIN_ID_SALES_CHANNEL_DEMAND", nullable = false, precision = 38, unique = true)
    @GeneratedValue(generator = "telco-uuid")
    @Id
    private BigDecimal buinIdSalesChannelDemand;

    @Column(name = "BUIN_TI_END_INTERAC")
    private Timestamp buinTiEndInterac;

    @Column(name = "BUIN_TI_START_INTERAC", nullable = false)
    private Timestamp buinTiStartInterac;

    @Column(name = "PARO_ID_LAW_ENTE_ORG_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdLawEnteOrgRole;

    @Column(name = "PARO_ID_PETITIONER_ORG_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdPetitionerOrgRole;

    @Column(columnDefinition = "DATE", name = "SCDE_DA_DESIRED", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date scdeDaDesired;

    @Column(length = 500, name = "SCDE_DS_OBJETIVE", nullable = false)
    private String scdeDsObjetive;

    @Column(length = 500, name = "SCDE_DS_TOOLS_IMPACT")
    private String scdeDsToolsImpact;

    @Column(name = "SCDE_IN_PRIORITY", nullable = false, precision = 1)
    private Long scdeInPriority;

    @Column(length = 100, name = "SCDE_NA_CHANNEL_DEMAND", nullable = false)
    private String scdeNaChannelDemand;

    @Column(name = "SCDE_QU_DURATION_EVENT", nullable = false, precision = 3)
    private Long scdeQuDurationEvent;

    @Column(name = "SCDE_QU_TARGET_PUBLIC", nullable = false, precision = 8)
    private Long scdeQuTargetPublic;

    @Column(name = "USER_ID_CREATOR_PARTY", nullable = false, precision = 38)
    private BigDecimal userIdCreatorParty;

    @Column(name = "USER_ID_UPDATER_PARTY", precision = 38)
    private BigDecimal userIdUpdaterParty;

    @OneToMany(mappedBy = "scdepSalesChannelDemand", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<CecaaChanAdeqStateMov> cecaaChanAdeqStateMovs;
    @OneToMany(mappedBy = "scdepSalesChannelDemand")
    private List<CecarChanAdequacyAttachment> cecarChanAdequacyAttachments;
    @JoinColumn(name = "SCDT_ID_CHANNEL_DEMAND_TYPE", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ScdedChannelDemandType scdedChannelDemandType;
    @OneToMany(mappedBy = "scdepSalesChannelDemand")
    private List<ScderCustomerImpact> scderCustomerImpacts;
    @OneToMany(mappedBy = "scdepSalesChannelDemand")
    private List<ScderDemandChannelType> scderDemandChannelTypes;
    @OneToMany(mappedBy = "scdepSalesChannelDemand")
    private List<ScderDemandMarketSegment> scderDemandMarketSegments;
    @OneToMany(mappedBy = "scdepSalesChannelDemand")
    private List<ScderDemandSalesChannel> scderDemandSalesChannels;
    @OneToMany(mappedBy = "scdepSalesChannelDemand")
    private List<ScprpSalesChannelProposal> scprpSalesChannelProposals;

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

    public String getBuinCoChannelDemand() {
        return this.buinCoChannelDemand;
    }

    public void setBuinCoChannelDemand(String buinCoChannelDemand) {
        this.buinCoChannelDemand = buinCoChannelDemand;
    }

    public String getBuinDsChannelDemand() {
        return this.buinDsChannelDemand;
    }

    public void setBuinDsChannelDemand(String buinDsChannelDemand) {
        this.buinDsChannelDemand = buinDsChannelDemand;
    }

    public BigDecimal getBuinIdSalesChannelDemand() {
        return this.buinIdSalesChannelDemand;
    }

    public void setBuinIdSalesChannelDemand(BigDecimal buinIdSalesChannelDemand) {
        this.buinIdSalesChannelDemand = buinIdSalesChannelDemand;
    }

    public Timestamp getBuinTiEndInterac() {
        if (this.buinTiEndInterac != null)
            return (Timestamp) this.buinTiEndInterac.clone();
        else
            return null;
    }

    public void setBuinTiEndInterac(Timestamp buinTiEndInterac) {
        if (buinTiEndInterac != null)
            this.buinTiEndInterac = (Timestamp) buinTiEndInterac.clone();
        else
            this.buinTiEndInterac = buinTiEndInterac;
    }

    public Timestamp getBuinTiStartInterac() {
        if (this.buinTiStartInterac != null)
            return (Timestamp) this.buinTiStartInterac.clone();
        else
            return null;
    }

    public void setBuinTiStartInterac(Timestamp buinTiStartInterac) {
        if (buinTiStartInterac != null)
            this.buinTiStartInterac = (Timestamp) buinTiStartInterac.clone();
        else
            this.buinTiStartInterac = buinTiStartInterac;
    }

    public BigDecimal getParoIdLawEnteOrgRole() {
        return this.paroIdLawEnteOrgRole;
    }

    public void setParoIdLawEnteOrgRole(BigDecimal paroIdLawEnteOrgRole) {
        this.paroIdLawEnteOrgRole = paroIdLawEnteOrgRole;
    }

    public BigDecimal getParoIdPetitionerOrgRole() {
        return this.paroIdPetitionerOrgRole;
    }

    public void setParoIdPetitionerOrgRole(BigDecimal paroIdPetitionerOrgRole) {
        this.paroIdPetitionerOrgRole = paroIdPetitionerOrgRole;
    }

    public Date getScdeDaDesired() {
        if (this.scdeDaDesired != null)
            return (Date) this.scdeDaDesired.clone();
        else
            return null;
    }

    public void setScdeDaDesired(Date scdeDaDesired) {
        if (scdeDaDesired != null)
            this.scdeDaDesired = (Date) scdeDaDesired.clone();
        else
            this.scdeDaDesired = scdeDaDesired;
    }

    public String getScdeDsObjetive() {
        return this.scdeDsObjetive;
    }

    public void setScdeDsObjetive(String scdeDsObjetive) {
        this.scdeDsObjetive = scdeDsObjetive;
    }

    public String getScdeDsToolsImpact() {
        return this.scdeDsToolsImpact;
    }

    public void setScdeDsToolsImpact(String scdeDsToolsImpact) {
        this.scdeDsToolsImpact = scdeDsToolsImpact;
    }

    public Long getScdeInPriority() {
        return this.scdeInPriority;
    }

    public void setScdeInPriority(Long scdeInPriority) {
        this.scdeInPriority = scdeInPriority;
    }

    public String getScdeNaChannelDemand() {
        return this.scdeNaChannelDemand;
    }

    public void setScdeNaChannelDemand(String scdeNaChannelDemand) {
        this.scdeNaChannelDemand = scdeNaChannelDemand;
    }

    public Long getScdeQuDurationEvent() {
        return this.scdeQuDurationEvent;
    }

    public void setScdeQuDurationEvent(Long scdeQuDurationEvent) {
        this.scdeQuDurationEvent = scdeQuDurationEvent;
    }

    public Long getScdeQuTargetPublic() {
        return this.scdeQuTargetPublic;
    }

    public void setScdeQuTargetPublic(Long scdeQuTargetPublic) {
        this.scdeQuTargetPublic = scdeQuTargetPublic;
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
    public List<CecaaChanAdeqStateMov> getCecaaChanAdeqStateMovs() {
        return this.cecaaChanAdeqStateMovs;
    }
    public void setCecaaChanAdeqStateMovs(List<CecaaChanAdeqStateMov> cecaaChanAdeqStateMovs) {
        this.cecaaChanAdeqStateMovs = cecaaChanAdeqStateMovs;
    }
    public void addCecaaChanAdeqStateMovs(CecaaChanAdeqStateMov cecaaChanAdeqStateMov) {
        if (this.cecaaChanAdeqStateMovs == null)
            this.cecaaChanAdeqStateMovs = new ArrayList<CecaaChanAdeqStateMov>();
        this.cecaaChanAdeqStateMovs.add(cecaaChanAdeqStateMov);
    }
    public void removeCecaaChanAdeqStateMovs(CecaaChanAdeqStateMov cecaaChanAdeqStateMovToRemove) {
        if (cecaaChanAdeqStateMovToRemove != null)
            this.cecaaChanAdeqStateMovs.remove(cecaaChanAdeqStateMovToRemove);
    }
    public List<CecarChanAdequacyAttachment> getCecarChanAdequacyAttachments() {
        return this.cecarChanAdequacyAttachments;
    }
    public void setCecarChanAdequacyAttachments(List<CecarChanAdequacyAttachment> cecarChanAdequacyAttachments) {
        this.cecarChanAdequacyAttachments = cecarChanAdequacyAttachments;
    }
    public void addCecarChanAdequacyAttachments(CecarChanAdequacyAttachment cecarChanAdequacyAttachment) {
        if (this.cecarChanAdequacyAttachments == null)
            this.cecarChanAdequacyAttachments = new ArrayList<CecarChanAdequacyAttachment>();
        this.cecarChanAdequacyAttachments.add(cecarChanAdequacyAttachment);
    }
    public void removeCecarChanAdequacyAttachments(CecarChanAdequacyAttachment cecarChanAdequacyAttachmentToRemove) {
        if (cecarChanAdequacyAttachmentToRemove != null)
            this.cecarChanAdequacyAttachments.remove(cecarChanAdequacyAttachmentToRemove);
    }

    public ScdedChannelDemandType getScdedChannelDemandType() {
        return this.scdedChannelDemandType;
    }

    public void setScdedChannelDemandType(ScdedChannelDemandType scdedChannelDemandType) {
        this.scdedChannelDemandType = scdedChannelDemandType;
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

    public List<ScderDemandChannelType> getScderDemandChannelTypes() {
        return this.scderDemandChannelTypes;
    }

    public void setScderDemandChannelTypes(List<ScderDemandChannelType> scderDemandChannelTypes) {
        this.scderDemandChannelTypes = scderDemandChannelTypes;
    }

    public void addScderDemandChannelTypes(ScderDemandChannelType scderDemandChannelType) {
        if (this.scderDemandChannelTypes == null)
            this.scderDemandChannelTypes = new ArrayList<ScderDemandChannelType>();
        this.scderDemandChannelTypes.add(scderDemandChannelType);
    }

    public void removeScderDemandChannelTypes(ScderDemandChannelType scderDemandChannelTypeToRemove) {
        if (scderDemandChannelTypeToRemove != null)
            this.scderDemandChannelTypes.remove(scderDemandChannelTypeToRemove);
    }

    public List<ScderDemandMarketSegment> getScderDemandMarketSegments() {
        return this.scderDemandMarketSegments;
    }

    public void setScderDemandMarketSegments(List<ScderDemandMarketSegment> scderDemandMarketSegments) {
        this.scderDemandMarketSegments = scderDemandMarketSegments;
    }

    public void addScderDemandMarketSegments(ScderDemandMarketSegment scderDemandMarketSegment) {
        if (this.scderDemandMarketSegments == null)
            this.scderDemandMarketSegments = new ArrayList<ScderDemandMarketSegment>();
        this.scderDemandMarketSegments.add(scderDemandMarketSegment);
    }

    public void removeScderDemandMarketSegments(ScderDemandMarketSegment scderDemandMarketSegmentToRemove) {
        if (scderDemandMarketSegmentToRemove != null)
            this.scderDemandMarketSegments.remove(scderDemandMarketSegmentToRemove);
    }

    public List<ScderDemandSalesChannel> getScderDemandSalesChannels() {
        return this.scderDemandSalesChannels;
    }

    public void setScderDemandSalesChannels(List<ScderDemandSalesChannel> scderDemandSalesChannels) {
        this.scderDemandSalesChannels = scderDemandSalesChannels;
    }

    public void addScderDemandSalesChannels(ScderDemandSalesChannel scderDemandSalesChannel) {
        if (this.scderDemandSalesChannels == null)
            this.scderDemandSalesChannels = new ArrayList<ScderDemandSalesChannel>();
        this.scderDemandSalesChannels.add(scderDemandSalesChannel);
    }

    public void removeScderDemandSalesChannels(ScderDemandSalesChannel scderDemandSalesChannelToRemove) {
        if (scderDemandSalesChannelToRemove != null)
            this.scderDemandSalesChannels.remove(scderDemandSalesChannelToRemove);
    }

    public List<ScprpSalesChannelProposal> getScprpSalesChannelProposals() {
        return this.scprpSalesChannelProposals;
    }

    public void setScprpSalesChannelProposals(List<ScprpSalesChannelProposal> scprpSalesChannelProposals) {
        this.scprpSalesChannelProposals = scprpSalesChannelProposals;
    }

    public void addScprpSalesChannelProposals(ScprpSalesChannelProposal scprpSalesChannelProposal) {
        if (this.scprpSalesChannelProposals == null)
            this.scprpSalesChannelProposals = new ArrayList<ScprpSalesChannelProposal>();
        this.scprpSalesChannelProposals.add(scprpSalesChannelProposal);
    }

    public void removeScprpSalesChannelProposals(ScprpSalesChannelProposal scprpSalesChannelProposalToRemove) {
        if (scprpSalesChannelProposalToRemove != null)
            this.scprpSalesChannelProposals.remove(scprpSalesChannelProposalToRemove);
    }

}
