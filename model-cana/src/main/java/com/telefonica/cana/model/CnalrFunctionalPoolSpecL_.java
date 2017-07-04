package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.979+0200")
@StaticMetamodel(CnalrFunctionalPoolSpecL.class)
public class CnalrFunctionalPoolSpecL_ {
	public static volatile SingularAttribute<CnalrFunctionalPoolSpecL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrFunctionalPoolSpecL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalrFunctionalPoolSpecL, Long> langCoLanguage;
	public static volatile SingularAttribute<CnalrFunctionalPoolSpecL, String> lfpsDsFunctionalPoolSpec;
	public static volatile SingularAttribute<CnalrFunctionalPoolSpecL, BigDecimal> lfpsIdLangFuncPoolSpec;
	public static volatile SingularAttribute<CnalrFunctionalPoolSpecL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrFunctionalPoolSpecL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalrFunctionalPoolSpecL, CnalpFunctionalPoolSpec> cnalpFunctionalPoolSpec;
}
