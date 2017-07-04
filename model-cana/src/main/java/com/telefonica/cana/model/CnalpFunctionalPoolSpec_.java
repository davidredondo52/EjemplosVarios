package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.736+0200")
@StaticMetamodel(CnalpFunctionalPoolSpec.class)
public class CnalpFunctionalPoolSpec_ {
	public static volatile SingularAttribute<CnalpFunctionalPoolSpec, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalpFunctionalPoolSpec, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalpFunctionalPoolSpec, Date> fupsDaEndValidity;
	public static volatile SingularAttribute<CnalpFunctionalPoolSpec, Date> fupsDaStartValidity;
	public static volatile SingularAttribute<CnalpFunctionalPoolSpec, Long> fupsIdFunctionalPoolSpec;
	public static volatile SingularAttribute<CnalpFunctionalPoolSpec, String> lfpsDsFunctionalPoolSpec;
	public static volatile SingularAttribute<CnalpFunctionalPoolSpec, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalpFunctionalPoolSpec, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CnalpFunctionalPoolSpec, CnalpFunctionalPool> cnalpFunctionalPools;
	public static volatile ListAttribute<CnalpFunctionalPoolSpec, CnalrFuncPoolSpChannelTy> cnalrFuncPoolSpChannelTies;
	public static volatile ListAttribute<CnalpFunctionalPoolSpec, CnalrFuncPoolSpEnteFunct> cnalrFuncPoolSpEnteFuncts;
	public static volatile ListAttribute<CnalpFunctionalPoolSpec, CnalrFuncPoolSpInquSpec> cnalrFuncPoolSpInquSpecs;
	public static volatile ListAttribute<CnalpFunctionalPoolSpec, CnalrFunctionalPoolSpecL> cnalrFunctionalPoolSpecLs;
}
