package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.562+0200")
@StaticMetamodel(CnaldDocumentType.class)
public class CnaldDocumentType_ {
	public static volatile SingularAttribute<CnaldDocumentType, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnaldDocumentType, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnaldDocumentType, Date> dotyDaEndValidity;
	public static volatile SingularAttribute<CnaldDocumentType, Date> dotyDaStartValidity;
	public static volatile SingularAttribute<CnaldDocumentType, Long> dotyIdDocumentType;
	public static volatile SingularAttribute<CnaldDocumentType, String> ldtyNaDocumentType;
	public static volatile SingularAttribute<CnaldDocumentType, Long> profIdProductOffering;
	public static volatile SingularAttribute<CnaldDocumentType, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnaldDocumentType, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CnaldDocumentType, CnalpDocumentModel> cnalpDocumentModels;
	public static volatile ListAttribute<CnaldDocumentType, CnalrDocumentTypeL> cnalrDocumentTypeLs;
}
