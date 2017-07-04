package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.584+0200")
@StaticMetamodel(CnaldSalesChannel.class)
public class CnaldSalesChannel_ {
	public static volatile SingularAttribute<CnaldSalesChannel, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnaldSalesChannel, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnaldSalesChannel, String> lsacNaSalesChannel;
	public static volatile SingularAttribute<CnaldSalesChannel, Date> schaDaEndValidity;
	public static volatile SingularAttribute<CnaldSalesChannel, Date> schaDaStartValidity;
	public static volatile SingularAttribute<CnaldSalesChannel, Long> schaIdSalesChannel;
	public static volatile SingularAttribute<CnaldSalesChannel, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnaldSalesChannel, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CnaldSalesChannel, CnalpFunctionalPool> cnalpFunctionalPools;
	public static volatile ListAttribute<CnaldSalesChannel, CnalrSalesChannelL> cnalrSalesChannelLs;
	public static volatile ListAttribute<CnaldSalesChannel, ScderDemandSalesChannel> scderDemandSalesChannels;
}
