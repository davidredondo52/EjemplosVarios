package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.030+0200")
@StaticMetamodel(CnalrInquSpecRoleSpec.class)
public class CnalrInquSpecRoleSpec_ {
	public static volatile SingularAttribute<CnalrInquSpecRoleSpec, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrInquSpecRoleSpec, BigDecimal> isrsIdInquSpPartyRoleSp;
	public static volatile SingularAttribute<CnalrInquSpecRoleSpec, Long> rotyIdPartyRoleSpec;
	public static volatile SingularAttribute<CnalrInquSpecRoleSpec, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrInquSpecRoleSpec, CnalpCustomerInquirySpec> cnalpCustomerInquirySpec;
}
