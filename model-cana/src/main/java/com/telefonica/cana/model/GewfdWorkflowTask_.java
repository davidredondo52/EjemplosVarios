package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.195+0200")
@StaticMetamodel(GewfdWorkflowTask.class)
public class GewfdWorkflowTask_ {
	public static volatile SingularAttribute<GewfdWorkflowTask, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<GewfdWorkflowTask, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<GewfdWorkflowTask, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<GewfdWorkflowTask, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<GewfdWorkflowTask, String> wtalDsWorkflowTask;
	public static volatile SingularAttribute<GewfdWorkflowTask, String> wtalNaWorkflowTask;
	public static volatile SingularAttribute<GewfdWorkflowTask, Date> wtasDaEndValidity;
	public static volatile SingularAttribute<GewfdWorkflowTask, Date> wtasDaStartValidity;
	public static volatile SingularAttribute<GewfdWorkflowTask, Long> wtasIdWorkflowTask;
	public static volatile ListAttribute<GewfdWorkflowTask, GewfaWorkflowSpecStep> gewfaWorkflowSpecSteps;
	public static volatile ListAttribute<GewfdWorkflowTask, GewfrValidActionTask> gewfrValidActionTasks;
	public static volatile ListAttribute<GewfdWorkflowTask, GewfrWorkflowTaskL> gewfrWorkflowTaskLs;
}
