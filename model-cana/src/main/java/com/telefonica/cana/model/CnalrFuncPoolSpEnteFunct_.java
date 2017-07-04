package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.948+0200")
@StaticMetamodel(CnalrFuncPoolSpEnteFunct.class)
public class CnalrFuncPoolSpEnteFunct_ {
	public static volatile SingularAttribute<CnalrFuncPoolSpEnteFunct, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrFuncPoolSpEnteFunct, BigDecimal> pscfIdFuncPoolSpEnteFunc;
	public static volatile SingularAttribute<CnalrFuncPoolSpEnteFunct, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrFuncPoolSpEnteFunct, CnaldEnterpriseFunction> cnaldEnterpriseFunction;
	public static volatile SingularAttribute<CnalrFuncPoolSpEnteFunct, CnalpFunctionalPoolSpec> cnalpFunctionalPoolSpec;
}
