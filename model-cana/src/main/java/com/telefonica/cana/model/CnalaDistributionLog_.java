package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.432+0200")
@StaticMetamodel(CnalaDistributionLog.class)
public class CnalaDistributionLog_ {
	public static volatile SingularAttribute<CnalaDistributionLog, BigDecimal> dislIdDistributionLog;
	public static volatile SingularAttribute<CnalaDistributionLog, Long> dislQuAllocatedTask;
	public static volatile SingularAttribute<CnalaDistributionLog, Long> dislQuNoDistributedTask;
	public static volatile SingularAttribute<CnalaDistributionLog, Long> dislQuPendingTask;
	public static volatile SingularAttribute<CnalaDistributionLog, BigDecimal> userIdCreatorParty;
	public static volatile ListAttribute<CnalaDistributionLog, CnalaDistributionLogItem> cnalaDistributionLogItems;
	public static volatile SingularAttribute<CnalaDistributionLog, CnalaTaskMailbox> cnalaTaskMailbox;
	public static volatile SingularAttribute<CnalaDistributionLog, Timestamp> audiTiCreation;
}
