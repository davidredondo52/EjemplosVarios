package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.903+0200")
@StaticMetamodel(CnalrFuncPoolSpChannelTy.class)
public class CnalrFuncPoolSpChannelTy_ {
	public static volatile SingularAttribute<CnalrFuncPoolSpChannelTy, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrFuncPoolSpChannelTy, BigDecimal> psctIdFuncPoolSpChanTy;
	public static volatile SingularAttribute<CnalrFuncPoolSpChannelTy, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrFuncPoolSpChannelTy, CnaldChannelType> cnaldChannelType;
	public static volatile ListAttribute<CnalrFuncPoolSpChannelTy, CnalpFunctionalPool> cnalpFunctionalPools;
	public static volatile SingularAttribute<CnalrFuncPoolSpChannelTy, CnalpFunctionalPoolSpec> cnalpFunctionalPoolSpec;
}
