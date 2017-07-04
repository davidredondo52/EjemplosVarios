package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.469+0200")
@StaticMetamodel(CnaldCallLabel.class)
public class CnaldCallLabel_ {
	public static volatile SingularAttribute<CnaldCallLabel, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnaldCallLabel, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnaldCallLabel, Date> calaDaEndValidity;
	public static volatile SingularAttribute<CnaldCallLabel, Date> calaDaStartValidity;
	public static volatile SingularAttribute<CnaldCallLabel, Long> calaIdCallLabel;
	public static volatile SingularAttribute<CnaldCallLabel, Long> calaInCallLabelType;
	public static volatile SingularAttribute<CnaldCallLabel, String> calaNaCallLabel;
	public static volatile SingularAttribute<CnaldCallLabel, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnaldCallLabel, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnaldCallLabel, CnalpCustomerInquirySpec> cnalpCustomerInquirySpec;
}
