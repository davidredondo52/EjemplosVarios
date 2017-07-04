package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.536+0200")
@StaticMetamodel(CnaldCustomerInquiryType.class)
public class CnaldCustomerInquiryType_ {
	public static volatile SingularAttribute<CnaldCustomerInquiryType, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnaldCustomerInquiryType, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnaldCustomerInquiryType, Date> cimtDaEndValidity;
	public static volatile SingularAttribute<CnaldCustomerInquiryType, Date> cimtDaStartValidity;
	public static volatile SingularAttribute<CnaldCustomerInquiryType, Long> cimtIdCustInquiryType;
	public static volatile SingularAttribute<CnaldCustomerInquiryType, String> lcitDsCustInquiryType;
	public static volatile SingularAttribute<CnaldCustomerInquiryType, String> lcitNaCustInquiryType;
	public static volatile SingularAttribute<CnaldCustomerInquiryType, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnaldCustomerInquiryType, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CnaldCustomerInquiryType, CnalaCustInquTypeTreeNode> cnalaCustInquTypeTreeNodes;
	public static volatile ListAttribute<CnaldCustomerInquiryType, CnalrCustomerInquiryTypeL> cnalrCustomerInquiryTypeLs;
}
