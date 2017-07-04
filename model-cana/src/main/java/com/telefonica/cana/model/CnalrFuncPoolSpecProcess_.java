package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.943+0200")
@StaticMetamodel(CnalrFuncPoolSpecProcess.class)
public class CnalrFuncPoolSpecProcess_ {
	public static volatile SingularAttribute<CnalrFuncPoolSpecProcess, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrFuncPoolSpecProcess, BigDecimal> fpspIdFuncPoolSpecProcess;
	public static volatile SingularAttribute<CnalrFuncPoolSpecProcess, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrFuncPoolSpecProcess, CnalpProcessDefinition> cnalpProcessDefinition;
	public static volatile SingularAttribute<CnalrFuncPoolSpecProcess, CnalrFuncPoolSpInquSpec> cnalrFuncPoolSpInquSpec;
}
