package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.119+0200")
@StaticMetamodel(CnalrTemplateTypeL.class)
public class CnalrTemplateTypeL_ {
	public static volatile SingularAttribute<CnalrTemplateTypeL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrTemplateTypeL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalrTemplateTypeL, Long> langCoLanguage;
	public static volatile SingularAttribute<CnalrTemplateTypeL, BigDecimal> ttylIdTemplateTypeLang;
	public static volatile SingularAttribute<CnalrTemplateTypeL, String> ttylNaTemplateType;
	public static volatile SingularAttribute<CnalrTemplateTypeL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrTemplateTypeL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalrTemplateTypeL, CnaldTemplateType> cnaldTemplateType;
}
