package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.230+0200")
@StaticMetamodel(GewfrMailboxAccess.class)
public class GewfrMailboxAccess_ {
	public static volatile SingularAttribute<GewfrMailboxAccess, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<GewfrMailboxAccess, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<GewfrMailboxAccess, BigDecimal> maacIdMailboxAccess;
	public static volatile SingularAttribute<GewfrMailboxAccess, Boolean> maacInMailboxAccess;
	public static volatile SingularAttribute<GewfrMailboxAccess, Boolean> maacInMailboxResponsible;
	public static volatile SingularAttribute<GewfrMailboxAccess, BigDecimal> paroIdFunctionalRole;
	public static volatile SingularAttribute<GewfrMailboxAccess, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<GewfrMailboxAccess, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<GewfrMailboxAccess, CnalaTaskMailbox> cnalaTaskMailbox;
}
