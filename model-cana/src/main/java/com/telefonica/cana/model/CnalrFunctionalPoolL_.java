package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.973+0200")
@StaticMetamodel(CnalrFunctionalPoolL.class)
public class CnalrFunctionalPoolL_ {
	public static volatile SingularAttribute<CnalrFunctionalPoolL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrFunctionalPoolL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalrFunctionalPoolL, Long> langCoLanguage;
	public static volatile SingularAttribute<CnalrFunctionalPoolL, String> lfpoDsFunctionalPool;
	public static volatile SingularAttribute<CnalrFunctionalPoolL, BigDecimal> lfpoIdLangFunctionalPool;
	public static volatile SingularAttribute<CnalrFunctionalPoolL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrFunctionalPoolL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalrFunctionalPoolL, CnalpFunctionalPool> cnalpFunctionalPool;
}
