package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.090+0200")
@StaticMetamodel(CnalrTaskMailboxL.class)
public class CnalrTaskMailboxL_ {
	public static volatile SingularAttribute<CnalrTaskMailboxL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrTaskMailboxL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalrTaskMailboxL, Long> langCoLanguage;
	public static volatile SingularAttribute<CnalrTaskMailboxL, BigDecimal> lboxIdLangTaskMailbox;
	public static volatile SingularAttribute<CnalrTaskMailboxL, String> lboxNaMailbox;
	public static volatile SingularAttribute<CnalrTaskMailboxL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrTaskMailboxL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalrTaskMailboxL, CnalaTaskMailbox> cnalaTaskMailbox;
}
