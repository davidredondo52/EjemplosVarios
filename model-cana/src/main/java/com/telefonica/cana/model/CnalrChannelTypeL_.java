package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.783+0200")
@StaticMetamodel(CnalrChannelTypeL.class)
public class CnalrChannelTypeL_ {
	public static volatile SingularAttribute<CnalrChannelTypeL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrChannelTypeL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalrChannelTypeL, Long> langCoLanguage;
	public static volatile SingularAttribute<CnalrChannelTypeL, BigDecimal> lchtIdLangChannelType;
	public static volatile SingularAttribute<CnalrChannelTypeL, String> lchtNaChannelType;
	public static volatile SingularAttribute<CnalrChannelTypeL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrChannelTypeL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalrChannelTypeL, CnaldChannelType> cnaldChannelType;
}
