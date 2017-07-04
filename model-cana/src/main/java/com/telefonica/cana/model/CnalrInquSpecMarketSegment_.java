package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.004+0200")
@StaticMetamodel(CnalrInquSpecMarketSegment.class)
public class CnalrInquSpecMarketSegment_ {
	public static volatile SingularAttribute<CnalrInquSpecMarketSegment, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalrInquSpecMarketSegment, BigDecimal> isseIdInquSpMarketSegment;
	public static volatile SingularAttribute<CnalrInquSpecMarketSegment, Long> mscaIdMarkSegmCate;
	public static volatile SingularAttribute<CnalrInquSpecMarketSegment, Long> segmIdMarketSegment;
	public static volatile SingularAttribute<CnalrInquSpecMarketSegment, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalrInquSpecMarketSegment, CnalpCustomerInquirySpec> cnalpCustomerInquirySpec;
}
