package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.364+0200")
@StaticMetamodel(CecarChanAdeqStateRel.class)
public class CecarChanAdeqStateRel_ {
	public static volatile SingularAttribute<CecarChanAdeqStateRel, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CecarChanAdeqStateRel, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CecarChanAdeqStateRel, Date> bisrDaEndValidity;
	public static volatile SingularAttribute<CecarChanAdeqStateRel, Date> bisrDaStartValidity;
	public static volatile SingularAttribute<CecarChanAdeqStateRel, BigDecimal> bisrIdChanAdeqStateRel;
	public static volatile SingularAttribute<CecarChanAdeqStateRel, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CecarChanAdeqStateRel, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CecarChanAdeqStateRel, CecaaChanAdeqStateMov> cecaaChanAdeqStateMovs;
	public static volatile SingularAttribute<CecarChanAdeqStateRel, CecadChannelAdequacyState> cecadChannelAdequacyState;
}
