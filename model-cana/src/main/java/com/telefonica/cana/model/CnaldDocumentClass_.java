package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.544+0200")
@StaticMetamodel(CnaldDocumentClass.class)
public class CnaldDocumentClass_ {
	public static volatile SingularAttribute<CnaldDocumentClass, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnaldDocumentClass, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnaldDocumentClass, Date> doclDaEndValidity;
	public static volatile SingularAttribute<CnaldDocumentClass, Date> doclDaStartValidity;
	public static volatile SingularAttribute<CnaldDocumentClass, Long> doclIdDocumentClass;
	public static volatile SingularAttribute<CnaldDocumentClass, String> ldclNaDocumentClass;
	public static volatile SingularAttribute<CnaldDocumentClass, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnaldDocumentClass, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CnaldDocumentClass, CnalpDocumentModel> cnalpDocumentModels;
	public static volatile ListAttribute<CnaldDocumentClass, CnalrDocumentClassL> cnalrDocumentClassLs;
}
