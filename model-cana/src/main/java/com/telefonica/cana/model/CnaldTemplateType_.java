package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.597+0200")
@StaticMetamodel(CnaldTemplateType.class)
public class CnaldTemplateType_ {
	public static volatile SingularAttribute<CnaldTemplateType, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnaldTemplateType, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnaldTemplateType, Date> tpttDaEndValidity;
	public static volatile SingularAttribute<CnaldTemplateType, Date> tpttDaStartValidity;
	public static volatile SingularAttribute<CnaldTemplateType, Long> tpttIdTemplateType;
	public static volatile SingularAttribute<CnaldTemplateType, Long> tpttInRecipient;
	public static volatile SingularAttribute<CnaldTemplateType, String> ttylNaTemplateType;
	public static volatile SingularAttribute<CnaldTemplateType, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnaldTemplateType, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CnaldTemplateType, CnalpTemplate> cnalpTemplates;
	public static volatile ListAttribute<CnaldTemplateType, CnalrTemplateTypeL> cnalrTemplateTypeLs;
}
