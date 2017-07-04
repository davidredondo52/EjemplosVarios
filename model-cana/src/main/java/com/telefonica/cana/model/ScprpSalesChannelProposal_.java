package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.824+0200")
@StaticMetamodel(ScprpSalesChannelProposal.class)
public class ScprpSalesChannelProposal_ {
	public static volatile SingularAttribute<ScprpSalesChannelProposal, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, String> buinCoChannelProposal;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, String> buinDsChannelProposal;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, BigDecimal> buinIdSalesChannelProposal;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, Timestamp> buinTiEndInterac;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, Timestamp> buinTiStartInterac;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, Date> scprDaDesired;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, Date> scprDaEstimated;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, String> scprDsNoViabilityCause;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, String> scprDsOperationalImpact;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, Boolean> scprInViability;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, Long> scptIdChannelProposalType;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<ScprpSalesChannelProposal, CecaaChanAdeqStateMov> cecaaChanAdeqStateMovs;
    public static volatile ListAttribute<ScprpSalesChannelProposal, CecarChanAdequacyAttachment> cecarChanAdequacyAttachments;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, ScdepSalesChannelDemand> scdepSalesChannelDemand;
	public static volatile ListAttribute<ScprpSalesChannelProposal, ScpraChannelProposalRole> scpraChannelProposalRoles;
	public static volatile SingularAttribute<ScprpSalesChannelProposal, ScprdChannelProposalSpec> scprdChannelProposalSpec;
}
