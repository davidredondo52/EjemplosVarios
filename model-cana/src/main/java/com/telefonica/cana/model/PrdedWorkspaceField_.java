package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.621+0200")
@StaticMetamodel(PrdedWorkspaceField.class)
public class PrdedWorkspaceField_ {
	public static volatile SingularAttribute<PrdedWorkspaceField, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<PrdedWorkspaceField, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<PrdedWorkspaceField, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<PrdedWorkspaceField, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<PrdedWorkspaceField, Long> wofiIdWorkspaceField;
	public static volatile SingularAttribute<PrdedWorkspaceField, Long> wofiInFormatField;
	public static volatile SingularAttribute<PrdedWorkspaceField, Boolean> wofiInUpdatableLabel;
	public static volatile SingularAttribute<PrdedWorkspaceField, Long> wofiInVisibility;
	public static volatile SingularAttribute<PrdedWorkspaceField, String> wofiNaWorkspaceField;
	public static volatile SingularAttribute<PrdedWorkspaceField, Long> wofiNuDefaultOrder;
	public static volatile SingularAttribute<PrdedWorkspaceField, BigDecimal> wofiNuLengthField;
	public static volatile SingularAttribute<PrdedWorkspaceField, Timestamp> wofiTiEndValidity;
	public static volatile SingularAttribute<PrdedWorkspaceField, Timestamp> wofiTiStartValidity;
	public static volatile ListAttribute<PrdedWorkspaceField, PrdeaUtSpecAlarm> prdeaUtSpecAlarms;
	public static volatile ListAttribute<PrdedWorkspaceField, PrderSelectedField> prderSelectedFields;
}
