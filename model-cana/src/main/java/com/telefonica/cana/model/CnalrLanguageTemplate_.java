package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.043+0200")
@StaticMetamodel(CnalrLanguageTemplate.class)
public class CnalrLanguageTemplate_ {
	public static volatile SingularAttribute<CnalrLanguageTemplate, String> attaCoDocument;
	public static volatile SingularAttribute<CnalrLanguageTemplate, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrLanguageTemplate, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalrLanguageTemplate, Long> langCoLanguage;
	public static volatile SingularAttribute<CnalrLanguageTemplate, String> lsteNaSubject;
	public static volatile SingularAttribute<CnalrLanguageTemplate, BigDecimal> ltemIdLanguageTemplate;
	public static volatile SingularAttribute<CnalrLanguageTemplate, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrLanguageTemplate, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalrLanguageTemplate, CnalpTemplate> cnalpTemplate;
}
