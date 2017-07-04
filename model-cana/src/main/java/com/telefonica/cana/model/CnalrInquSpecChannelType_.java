package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.988+0200")
@StaticMetamodel(CnalrInquSpecChannelType.class)
public class CnalrInquSpecChannelType_ {
	public static volatile SingularAttribute<CnalrInquSpecChannelType, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrInquSpecChannelType, BigDecimal> isctIdInquSpChannelType;
	public static volatile SingularAttribute<CnalrInquSpecChannelType, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrInquSpecChannelType, CnaldChannelType> cnaldChannelType;
	public static volatile SingularAttribute<CnalrInquSpecChannelType, CnalpCustomerInquirySpec> cnalpCustomerInquirySpec;
}
