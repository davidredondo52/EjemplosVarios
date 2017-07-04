package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.680+0200")
@StaticMetamodel(ScdedCustomerItemType.class)
public class ScdedCustomerItemType_ {
	public static volatile SingularAttribute<ScdedCustomerItemType, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<ScdedCustomerItemType, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<ScdedCustomerItemType, Date> cityDaEndValidity;
	public static volatile SingularAttribute<ScdedCustomerItemType, Date> cityDaStartValidity;
	public static volatile SingularAttribute<ScdedCustomerItemType, Long> cityIdCustomerItemType;
	public static volatile SingularAttribute<ScdedCustomerItemType, String> cityNaCustomerItemType;
	public static volatile SingularAttribute<ScdedCustomerItemType, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<ScdedCustomerItemType, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<ScdedCustomerItemType, ScderCustomerImpact> scderCustomerImpacts;
}
