package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.641+0200")
@StaticMetamodel(PrderSelectedField.class)
public class PrderSelectedField_ {
	public static volatile SingularAttribute<PrderSelectedField, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<PrderSelectedField, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<PrderSelectedField, BigDecimal> paroIdOrgRole;
	public static volatile SingularAttribute<PrderSelectedField, BigDecimal> sefiIdSelectedField;
	public static volatile SingularAttribute<PrderSelectedField, String> sefiNaLabel;
	public static volatile SingularAttribute<PrderSelectedField, BigDecimal> sefiNuLength;
	public static volatile SingularAttribute<PrderSelectedField, Long> sefiNuOrder;
	public static volatile SingularAttribute<PrderSelectedField, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<PrderSelectedField, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<PrderSelectedField, PrdedWorkspaceField> prdedWorkspaceField;
}
