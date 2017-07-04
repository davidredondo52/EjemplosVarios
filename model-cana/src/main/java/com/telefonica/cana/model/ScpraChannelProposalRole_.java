package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.768+0200")
@StaticMetamodel(ScpraChannelProposalRole.class)
public class ScpraChannelProposalRole_ {
	public static volatile SingularAttribute<ScpraChannelProposalRole, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<ScpraChannelProposalRole, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<ScpraChannelProposalRole, BigDecimal> biroIdChannelProposalRole;
	public static volatile SingularAttribute<ScpraChannelProposalRole, Date> prolDaPrelaunchCommitted;
	public static volatile SingularAttribute<ScpraChannelProposalRole, Long> prolInReadyCheck;
	public static volatile SingularAttribute<ScpraChannelProposalRole, Long> prolInViability;
	public static volatile SingularAttribute<ScpraChannelProposalRole, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<ScpraChannelProposalRole, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<ScpraChannelProposalRole, ScprdFunctionalArea> scprdFunctionalArea;
	public static volatile SingularAttribute<ScpraChannelProposalRole, ScprpSalesChannelProposal> scprpSalesChannelProposal;
	public static volatile ListAttribute<ScpraChannelProposalRole, ScprrPlanificationWorkflow> scprrPlanificationWorkflows;
}
