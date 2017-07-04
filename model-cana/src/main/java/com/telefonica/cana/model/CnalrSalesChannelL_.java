package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.070+0200")
@StaticMetamodel(CnalrSalesChannelL.class)
public class CnalrSalesChannelL_ {
	public static volatile SingularAttribute<CnalrSalesChannelL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrSalesChannelL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalrSalesChannelL, Long> langCoLanguage;
	public static volatile SingularAttribute<CnalrSalesChannelL, BigDecimal> lsacIdLangSalesChannel;
	public static volatile SingularAttribute<CnalrSalesChannelL, String> lsacNaSalesChannel;
	public static volatile SingularAttribute<CnalrSalesChannelL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrSalesChannelL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalrSalesChannelL, CnaldSalesChannel> cnaldSalesChannel;
}
