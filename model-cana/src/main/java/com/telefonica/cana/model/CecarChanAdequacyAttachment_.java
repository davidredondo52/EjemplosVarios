package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.372+0200")
@StaticMetamodel(CecarChanAdequacyAttachment.class)
public class CecarChanAdequacyAttachment_ {
	public static volatile SingularAttribute<CecarChanAdequacyAttachment, String> attaCoDocument;
	public static volatile SingularAttribute<CecarChanAdequacyAttachment, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CecarChanAdequacyAttachment, Long> bintIdChannelAdequacyType;
	public static volatile SingularAttribute<CecarChanAdequacyAttachment, BigDecimal> cecarIdChanAdeqAttachment;
	public static volatile SingularAttribute<CecarChanAdequacyAttachment, BigDecimal> userIdCreatorParty;
    public static volatile SingularAttribute<CecarChanAdequacyAttachment, ScdepSalesChannelDemand> scdepSalesChannelDemand;
	public static volatile SingularAttribute<CecarChanAdequacyAttachment, ScprpSalesChannelProposal> scprpSalesChannelProposal;
}
