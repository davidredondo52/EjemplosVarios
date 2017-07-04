package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.511+0200")
@StaticMetamodel(CnaldChannelType.class)
public class CnaldChannelType_ {
	public static volatile SingularAttribute<CnaldChannelType, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnaldChannelType, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnaldChannelType, Date> chatDaEndValidity;
	public static volatile SingularAttribute<CnaldChannelType, Date> chatDaStartValidity;
	public static volatile SingularAttribute<CnaldChannelType, Long> chatIdChannelType;
	public static volatile SingularAttribute<CnaldChannelType, String> lchtNaChannelType;
	public static volatile SingularAttribute<CnaldChannelType, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnaldChannelType, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CnaldChannelType, CnalrChannelTypeL> cnalrChannelTypeLs;
	public static volatile ListAttribute<CnaldChannelType, CnalrFuncPoolSpChannelTy> cnalrFuncPoolSpChannelTies;
	public static volatile ListAttribute<CnaldChannelType, CnalrInquSpecChannelType> cnalrInquSpecChannelTypes;
	public static volatile ListAttribute<CnaldChannelType, CnalrTemplateChannelType> cnalrTemplateChannelTypes;
	public static volatile ListAttribute<CnaldChannelType, ScderDemandChannelType> scderDemandChannelTypes;
}
