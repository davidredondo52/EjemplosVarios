package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.152+0200")
@StaticMetamodel(GewfaWorkflowSpecStep.class)
public class GewfaWorkflowSpecStep_ {
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, Long> umeaIdUnitMeasure;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, BigDecimal> wsspIdWorkflowSpecStep;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, Boolean> wsspInForceDocument;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, Long> wsspNuWorkflowSpecStep;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, BigDecimal> wsspQuExecutionMediumTime;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, Timestamp> wsspTiEndValidity;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, Timestamp> wsspTiStartValidity;
	public static volatile ListAttribute<GewfaWorkflowSpecStep, GewfaWorkflowStep> gewfaWorkflowSteps;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, GewfdWorkflowTask> gewfdWorkflowTask;
	public static volatile SingularAttribute<GewfaWorkflowSpecStep, GewfpWorkflowSpec> gewfpWorkflowSpec;
	public static volatile ListAttribute<GewfaWorkflowSpecStep, GewfrResolutorMailbox> gewfrResolutorMailboxs;
	public static volatile ListAttribute<GewfaWorkflowSpecStep, GewfrValidActionStep> gewfrValidActionSteps1;
	public static volatile ListAttribute<GewfaWorkflowSpecStep, GewfrValidActionStep> gewfrValidActionSteps2;
}
