package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.862+0200")
@StaticMetamodel(ScprrPlanificationWorkflow.class)
public class ScprrPlanificationWorkflow_ {
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, BigDecimal> planIdPlanificationWorkflow;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, Boolean> planInProposalReady;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, Long> planInViability;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, String> planObViabilityComment;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, BigDecimal> planQuCost;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, BigDecimal> planQuDuration;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, Timestamp> planTiEnd;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, Timestamp> planTiProposalReady;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, Timestamp> planTiStart;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, Timestamp> planTiViability;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, CnalaTaskMailbox> cnalaTaskMailbox;
	public static volatile SingularAttribute<ScprrPlanificationWorkflow, ScpraChannelProposalRole> scpraChannelProposalRole;
	public static volatile ListAttribute<ScprrPlanificationWorkflow, ScprrWorkAttachment> scprrWorkAttachments;
}
