package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.788+0200")
@StaticMetamodel(CnalrCisDefaultExecProcess.class)
public class CnalrCisDefaultExecProcess_ {
	public static volatile SingularAttribute<CnalrCisDefaultExecProcess, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrCisDefaultExecProcess, BigDecimal> dexpIdCisDefExecProcess;
	public static volatile SingularAttribute<CnalrCisDefaultExecProcess, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrCisDefaultExecProcess, CnalpCustomerInquirySpec> cnalpCustomerInquirySpec;
	public static volatile SingularAttribute<CnalrCisDefaultExecProcess, CnalpProcessDefinition> cnalpProcessDefinition;
}
