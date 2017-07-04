package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.715+0200")
@StaticMetamodel(ScderDemandTypeTemplate.class)
public class ScderDemandTypeTemplate_ {
	public static volatile SingularAttribute<ScderDemandTypeTemplate, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<ScderDemandTypeTemplate, BigDecimal> dtteIdDemandTypeTemplate;
	public static volatile SingularAttribute<ScderDemandTypeTemplate, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<ScderDemandTypeTemplate, CnalpTemplate> cnalpTemplate;
	public static volatile SingularAttribute<ScderDemandTypeTemplate, ScdedChannelDemandType> scdedChannelDemandType;
}
