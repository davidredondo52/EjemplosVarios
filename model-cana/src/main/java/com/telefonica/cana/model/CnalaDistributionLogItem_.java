package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.437+0200")
@StaticMetamodel(CnalaDistributionLogItem.class)
public class CnalaDistributionLogItem_ {
	public static volatile SingularAttribute<CnalaDistributionLogItem, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalaDistributionLogItem, BigDecimal> diliIdDistributionLogItem;
	public static volatile SingularAttribute<CnalaDistributionLogItem, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalaDistributionLogItem, String> utasDoUserTask;
	public static volatile SingularAttribute<CnalaDistributionLogItem, String> utasNoTaskTitle;
	public static volatile SingularAttribute<CnalaDistributionLogItem, CnalaDistributionLog> cnalaDistributionLog;
	public static volatile SingularAttribute<CnalaDistributionLogItem, CnaldNoDistributedMotive> cnaldNoDistributedMotive;
}
