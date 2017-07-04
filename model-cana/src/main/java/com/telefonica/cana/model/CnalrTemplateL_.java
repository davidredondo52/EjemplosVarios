package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.101+0200")
@StaticMetamodel(CnalrTemplateL.class)
public class CnalrTemplateL_ {
	public static volatile SingularAttribute<CnalrTemplateL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrTemplateL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalrTemplateL, Long> langCoLanguage;
	public static volatile SingularAttribute<CnalrTemplateL, BigDecimal> leteIdTemplateLang;
	public static volatile SingularAttribute<CnalrTemplateL, String> leteNaTemplate;
	public static volatile SingularAttribute<CnalrTemplateL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrTemplateL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalrTemplateL, CnalpTemplate> cnalpTemplate;
}
