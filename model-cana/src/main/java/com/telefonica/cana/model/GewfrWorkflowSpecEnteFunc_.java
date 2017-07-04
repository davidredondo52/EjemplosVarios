package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.587+0200")
@StaticMetamodel(GewfrWorkflowSpecEnteFunc.class)
public class GewfrWorkflowSpecEnteFunc_ {
	public static volatile SingularAttribute<GewfrWorkflowSpecEnteFunc, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<GewfrWorkflowSpecEnteFunc, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<GewfrWorkflowSpecEnteFunc, BigDecimal> wsefIdWfSpecEnteFunc;
	public static volatile SingularAttribute<GewfrWorkflowSpecEnteFunc, CnalaEnteFunctionTreeNode> cnalaEnteFunctionTreeNode;
	public static volatile SingularAttribute<GewfrWorkflowSpecEnteFunc, GewfpWorkflowSpec> gewfpWorkflowSpec;
}
