package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.804+0200")
@StaticMetamodel(CnalrCustInquirySubtypeL.class)
public class CnalrCustInquirySubtypeL_ {
	public static volatile SingularAttribute<CnalrCustInquirySubtypeL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrCustInquirySubtypeL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalrCustInquirySubtypeL, Long> langCoLanguage;
	public static volatile SingularAttribute<CnalrCustInquirySubtypeL, BigDecimal> lbitIdLangCustInquSubtype;
	public static volatile SingularAttribute<CnalrCustInquirySubtypeL, String> listDsCustInquirySubtype;
	public static volatile SingularAttribute<CnalrCustInquirySubtypeL, String> listNaCustInquirySubtype;
	public static volatile SingularAttribute<CnalrCustInquirySubtypeL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrCustInquirySubtypeL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalrCustInquirySubtypeL, CnaldCustomerInquirySubtype> cnaldCustomerInquirySubtype;
}
