package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.552+0200")
@StaticMetamodel(CnaldDocumentFormat.class)
public class CnaldDocumentFormat_ {
	public static volatile SingularAttribute<CnaldDocumentFormat, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnaldDocumentFormat, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnaldDocumentFormat, Date> dofoDaEndValidity;
	public static volatile SingularAttribute<CnaldDocumentFormat, Date> dofoDaStartValidity;
	public static volatile SingularAttribute<CnaldDocumentFormat, Long> dofoIdDocumentFormat;
	public static volatile SingularAttribute<CnaldDocumentFormat, String> dofoNaDocumentFormat;
	public static volatile SingularAttribute<CnaldDocumentFormat, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnaldDocumentFormat, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CnaldDocumentFormat, CnalpTemplate> cnalpTemplates;
}
