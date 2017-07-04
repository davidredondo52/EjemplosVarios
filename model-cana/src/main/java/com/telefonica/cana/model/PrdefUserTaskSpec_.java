package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.626+0200")
@StaticMetamodel(PrdefUserTaskSpec.class)
public class PrdefUserTaskSpec_ {
	public static volatile SingularAttribute<PrdefUserTaskSpec, Timestamp> bsesDaEndValidity;
	public static volatile SingularAttribute<PrdefUserTaskSpec, Timestamp> bsesDaStartValidity;
	public static volatile SingularAttribute<PrdefUserTaskSpec, String> bsesDsBusinessService;
	public static volatile SingularAttribute<PrdefUserTaskSpec, String> bsesNaBusinessService;
	public static volatile SingularAttribute<PrdefUserTaskSpec, Long> genaIdApplication;
	public static volatile SingularAttribute<PrdefUserTaskSpec, Long> prosIdProcessSpecification;
	public static volatile SingularAttribute<PrdefUserTaskSpec, BigDecimal> userIdUserUpdater;
	public static volatile SingularAttribute<PrdefUserTaskSpec, String> utsfInStatement;
	public static volatile SingularAttribute<PrdefUserTaskSpec, Long> utspInManageBetweenAreas;
	public static volatile SingularAttribute<PrdefUserTaskSpec, Long> utspInSendUp;
	public static volatile SingularAttribute<PrdefUserTaskSpec, String> utspNaTechnicalUt;
	public static volatile SingularAttribute<PrdefUserTaskSpec, PrdefUserTaskSpecPK> id;
}
