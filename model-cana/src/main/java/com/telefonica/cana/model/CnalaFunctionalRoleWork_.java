package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.447+0200")
@StaticMetamodel(CnalaFunctionalRoleWork.class)
public class CnalaFunctionalRoleWork_ {
	public static volatile SingularAttribute<CnalaFunctionalRoleWork, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalaFunctionalRoleWork, BigDecimal> frwoIdFunctionalRoleWork;
	public static volatile SingularAttribute<CnalaFunctionalRoleWork, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalaFunctionalRoleWork, CnalpFuncPoolAssignment> cnalpFuncPoolAssignment;
}
