package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.528+0200")
@StaticMetamodel(CnaldCustomerInquirySubtype.class)
public class CnaldCustomerInquirySubtype_ {
	public static volatile SingularAttribute<CnaldCustomerInquirySubtype, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnaldCustomerInquirySubtype, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnaldCustomerInquirySubtype, Date> cimtDaEndValidity;
	public static volatile SingularAttribute<CnaldCustomerInquirySubtype, Date> cimtDaStartValidity;
	public static volatile SingularAttribute<CnaldCustomerInquirySubtype, Long> cimtIdCustInquirySubtype;
	public static volatile SingularAttribute<CnaldCustomerInquirySubtype, String> listDsCustInquirySubtype;
	public static volatile SingularAttribute<CnaldCustomerInquirySubtype, String> listNaCustInquirySubtype;
	public static volatile SingularAttribute<CnaldCustomerInquirySubtype, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnaldCustomerInquirySubtype, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CnaldCustomerInquirySubtype, CnalpCustomerInquirySpec> cnalpCustomerInquirySpecs;
	public static volatile ListAttribute<CnaldCustomerInquirySubtype, CnalrCustInquirySubtypeL> cnalrCustInquirySubtypeLs;
}
