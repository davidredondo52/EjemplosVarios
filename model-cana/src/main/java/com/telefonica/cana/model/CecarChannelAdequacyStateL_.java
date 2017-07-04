package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.381+0200")
@StaticMetamodel(CecarChannelAdequacyStateL.class)
public class CecarChannelAdequacyStateL_ {
	public static volatile SingularAttribute<CecarChannelAdequacyStateL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CecarChannelAdequacyStateL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CecarChannelAdequacyStateL, Long> langCoLanguage;
	public static volatile SingularAttribute<CecarChannelAdequacyStateL, String> lbisDsChannelAdequacyState;
	public static volatile SingularAttribute<CecarChannelAdequacyStateL, BigDecimal> lbisIdLangChanAdeqState;
	public static volatile SingularAttribute<CecarChannelAdequacyStateL, String> lbisNaChannelAdequacyState;
	public static volatile SingularAttribute<CecarChannelAdequacyStateL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CecarChannelAdequacyStateL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CecarChannelAdequacyStateL, CecadChannelAdequacyState> cecadChannelAdequacyState;
}
