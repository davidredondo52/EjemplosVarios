package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.107+0200")
@StaticMetamodel(CnalrTemplateMarketSegment.class)
public class CnalrTemplateMarketSegment_ {
	public static volatile SingularAttribute<CnalrTemplateMarketSegment, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrTemplateMarketSegment, Long> mscaIdMarkSegmCate;
	public static volatile SingularAttribute<CnalrTemplateMarketSegment, Long> segmIdMarketSegment;
	public static volatile SingularAttribute<CnalrTemplateMarketSegment, BigDecimal> teseIdTemplateSegment;
	public static volatile SingularAttribute<CnalrTemplateMarketSegment, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrTemplateMarketSegment, CnalpTemplate> cnalpTemplate;
}
