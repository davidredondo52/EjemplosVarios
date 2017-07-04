package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.577+0200")
@StaticMetamodel(GewfrValidActionTask.class)
public class GewfrValidActionTask_ {
	public static volatile SingularAttribute<GewfrValidActionTask, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<GewfrValidActionTask, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<GewfrValidActionTask, BigDecimal> vataIdValidActionTask;
	public static volatile SingularAttribute<GewfrValidActionTask, GewfdTaskAction> gewfdTaskAction;
	public static volatile SingularAttribute<GewfrValidActionTask, GewfdWorkflowTask> gewfdWorkflowTask;
}
