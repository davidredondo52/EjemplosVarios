package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.886+0200")
@StaticMetamodel(CnalrFuncPoolProdCatalog.class)
public class CnalrFuncPoolProdCatalog_ {
	public static volatile SingularAttribute<CnalrFuncPoolProdCatalog, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrFuncPoolProdCatalog, BigDecimal> fppcIdFuncPoolProdCatalog;
	public static volatile SingularAttribute<CnalrFuncPoolProdCatalog, Long> prcaIdProductCatalog;
	public static volatile SingularAttribute<CnalrFuncPoolProdCatalog, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrFuncPoolProdCatalog, CnalpFunctionalPool> cnalpFunctionalPool;
}
