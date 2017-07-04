package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.776+0200")
@StaticMetamodel(ScprdChannelProposalSpec.class)
public class ScprdChannelProposalSpec_ {
	public static volatile SingularAttribute<ScprdChannelProposalSpec, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<ScprdChannelProposalSpec, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<ScprdChannelProposalSpec, String> bislDsChannelProposalSpec;
	public static volatile SingularAttribute<ScprdChannelProposalSpec, String> bislNaChannelProposalSpec;
	public static volatile SingularAttribute<ScprdChannelProposalSpec, Date> bispDaEndValidity;
	public static volatile SingularAttribute<ScprdChannelProposalSpec, Date> bispDaStartValidity;
	public static volatile SingularAttribute<ScprdChannelProposalSpec, Long> bispIdChannelProposalSpec;
	public static volatile SingularAttribute<ScprdChannelProposalSpec, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<ScprdChannelProposalSpec, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<ScprdChannelProposalSpec, ScprpSalesChannelProposal> scprpSalesChannelProposals;
	public static volatile ListAttribute<ScprdChannelProposalSpec, ScprrChannelProposalSpecL> scprrChannelProposalSpecLs;
	public static volatile ListAttribute<ScprdChannelProposalSpec, ScprrDefaultFuncArea> scprrDefaultFuncAreas;
}
