package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.631+0200")
@StaticMetamodel(CnalhFuncPoolAssignment.class)
public class CnalhFuncPoolAssignment_ {
	public static volatile SingularAttribute<CnalhFuncPoolAssignment, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalhFuncPoolAssignment, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalhFuncPoolAssignment, BigDecimal> fpasIdFuncPoolAssignment;
	public static volatile SingularAttribute<CnalhFuncPoolAssignment, Long> fpasInDefaultPool;
	public static volatile SingularAttribute<CnalhFuncPoolAssignment, Timestamp> fpasTiEndValidity;
	public static volatile SingularAttribute<CnalhFuncPoolAssignment, Timestamp> fpasTiStartValidity;
	public static volatile SingularAttribute<CnalhFuncPoolAssignment, BigDecimal> paroIdFunctionalRole;
	public static volatile SingularAttribute<CnalhFuncPoolAssignment, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalhFuncPoolAssignment, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalhFuncPoolAssignment, BigDecimal> wpooIdFunctionalPool;
}
