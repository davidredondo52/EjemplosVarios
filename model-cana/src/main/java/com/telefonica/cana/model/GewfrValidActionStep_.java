package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.253+0200")
@StaticMetamodel(GewfrValidActionStep.class)
public class GewfrValidActionStep_ {
	public static volatile SingularAttribute<GewfrValidActionStep, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<GewfrValidActionStep, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<GewfrValidActionStep, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<GewfrValidActionStep, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<GewfrValidActionStep, Long> vastIdValidActionStep;
	public static volatile SingularAttribute<GewfrValidActionStep, Long> vastInActionRole;
	public static volatile SingularAttribute<GewfrValidActionStep, GewfaWorkflowSpecStep> gewfaWorkflowSpecStep1;
	public static volatile SingularAttribute<GewfrValidActionStep, GewfaWorkflowSpecStep> gewfaWorkflowSpecStep2;
	public static volatile SingularAttribute<GewfrValidActionStep, GewfdTaskAction> gewfdTaskAction;
}
