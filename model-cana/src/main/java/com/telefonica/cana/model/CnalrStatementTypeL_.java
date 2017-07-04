package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.084+0200")
@StaticMetamodel(CnalrStatementTypeL.class)
public class CnalrStatementTypeL_ {
	public static volatile SingularAttribute<CnalrStatementTypeL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrStatementTypeL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalrStatementTypeL, Long> langCoLanguage;
	public static volatile SingularAttribute<CnalrStatementTypeL, BigDecimal> lstyIdLangStatementType;
	public static volatile SingularAttribute<CnalrStatementTypeL, String> lstyNaStatementType;
	public static volatile SingularAttribute<CnalrStatementTypeL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrStatementTypeL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalrStatementTypeL, CnaldStatementType> cnaldStatementType;
}
