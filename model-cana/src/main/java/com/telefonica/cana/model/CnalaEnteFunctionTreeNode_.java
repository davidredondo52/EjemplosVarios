package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.442+0200")
@StaticMetamodel(CnalaEnteFunctionTreeNode.class)
public class CnalaEnteFunctionTreeNode_ {
	public static volatile SingularAttribute<CnalaEnteFunctionTreeNode, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalaEnteFunctionTreeNode, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalaEnteFunctionTreeNode, Long> eftnIdEnteFuncTreeNode;
	public static volatile SingularAttribute<CnalaEnteFunctionTreeNode, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalaEnteFunctionTreeNode, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalaEnteFunctionTreeNode, CnalaEnteFunctionTreeNode> cnalaEnteFunctionTreeNode;
	public static volatile ListAttribute<CnalaEnteFunctionTreeNode, CnalaEnteFunctionTreeNode> cnalaEnteFunctionTreeNodes;
	public static volatile SingularAttribute<CnalaEnteFunctionTreeNode, CnaldEnterpriseFunction> cnaldEnterpriseFunction;
	public static volatile ListAttribute<CnalaEnteFunctionTreeNode, CnalpFunctionalPool> cnalpFunctionalPools;
	public static volatile ListAttribute<CnalaEnteFunctionTreeNode, GewfrWorkflowSpecEnteFunc> gewfrWorkflowSpecEnteFuncs;
}
