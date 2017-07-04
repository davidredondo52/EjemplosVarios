package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.237+0200")
@StaticMetamodel(GewfrResolutorMailbox.class)
public class GewfrResolutorMailbox_ {
	public static volatile SingularAttribute<GewfrResolutorMailbox, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<GewfrResolutorMailbox, BigDecimal> remaIdResolutorMailbox;
	public static volatile SingularAttribute<GewfrResolutorMailbox, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<GewfrResolutorMailbox, CnalaTaskMailbox> cnalaTaskMailbox;
	public static volatile SingularAttribute<GewfrResolutorMailbox, GewfaWorkflowSpecStep> gewfaWorkflowSpecStep;
	public static volatile ListAttribute<GewfrResolutorMailbox, GewfaWorkflowStep> gewfaWorkflowSteps;
}
