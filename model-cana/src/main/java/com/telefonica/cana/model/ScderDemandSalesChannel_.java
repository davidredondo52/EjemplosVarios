package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.710+0200")
@StaticMetamodel(ScderDemandSalesChannel.class)
public class ScderDemandSalesChannel_ {
	public static volatile SingularAttribute<ScderDemandSalesChannel, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<ScderDemandSalesChannel, BigDecimal> cdscIdDemandSalesChannel;
	public static volatile SingularAttribute<ScderDemandSalesChannel, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<ScderDemandSalesChannel, CnaldSalesChannel> cnaldSalesChannel;
	public static volatile SingularAttribute<ScderDemandSalesChannel, ScdepSalesChannelDemand> scdepSalesChannelDemand;
}
