package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.339+0200")
@StaticMetamodel(CecadChanAdeqStateReason.class)
public class CecadChanAdeqStateReason_ {
	public static volatile SingularAttribute<CecadChanAdeqStateReason, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CecadChanAdeqStateReason, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CecadChanAdeqStateReason, Date> bcsrDaEndValidity;
	public static volatile SingularAttribute<CecadChanAdeqStateReason, Date> bcsrDaStartValidity;
	public static volatile SingularAttribute<CecadChanAdeqStateReason, String> bcsrDsChanAdeqStateReason;
	public static volatile SingularAttribute<CecadChanAdeqStateReason, Long> bcsrIdChanAdeqStateReason;
	public static volatile SingularAttribute<CecadChanAdeqStateReason, String> bcsrNaChanAdeqStateReason;
	public static volatile SingularAttribute<CecadChanAdeqStateReason, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CecadChanAdeqStateReason, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CecadChanAdeqStateReason, CecaaChanAdeqStateMov> cecaaChanAdeqStateMovs;
}
