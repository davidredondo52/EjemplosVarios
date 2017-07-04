package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.881+0200")
@StaticMetamodel(CnalrFuncPoolMarketSegment.class)
public class CnalrFuncPoolMarketSegment_ {
	public static volatile SingularAttribute<CnalrFuncPoolMarketSegment, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrFuncPoolMarketSegment, BigDecimal> fpseIdFuncPoolSegment;
	public static volatile SingularAttribute<CnalrFuncPoolMarketSegment, Long> mscaIdMarkSegmCate;
	public static volatile SingularAttribute<CnalrFuncPoolMarketSegment, Long> segmIdMarketSegment;
	public static volatile SingularAttribute<CnalrFuncPoolMarketSegment, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrFuncPoolMarketSegment, CnalpFunctionalPool> cnalpFunctionalPool;
}
