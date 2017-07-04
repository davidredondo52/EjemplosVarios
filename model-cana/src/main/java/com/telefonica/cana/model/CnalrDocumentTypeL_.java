package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.831+0200")
@StaticMetamodel(CnalrDocumentTypeL.class)
public class CnalrDocumentTypeL_ {
	public static volatile SingularAttribute<CnalrDocumentTypeL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrDocumentTypeL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalrDocumentTypeL, Long> langCoLanguage;
	public static volatile SingularAttribute<CnalrDocumentTypeL, BigDecimal> ldtyIdLangDocumentType;
	public static volatile SingularAttribute<CnalrDocumentTypeL, String> ldtyNaDocumentType;
	public static volatile SingularAttribute<CnalrDocumentTypeL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrDocumentTypeL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalrDocumentTypeL, CnaldDocumentType> cnaldDocumentType;
}
