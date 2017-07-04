package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.246+0200")
@StaticMetamodel(GewfrTaskActionL.class)
public class GewfrTaskActionL_ {
	public static volatile SingularAttribute<GewfrTaskActionL, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<GewfrTaskActionL, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<GewfrTaskActionL, Long> langCoLanguage;
	public static volatile SingularAttribute<GewfrTaskActionL, String> taalNaTaskAction;
	public static volatile SingularAttribute<GewfrTaskActionL, BigDecimal> taclIdTaskActionLang;
	public static volatile SingularAttribute<GewfrTaskActionL, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<GewfrTaskActionL, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<GewfrTaskActionL, GewfdTaskAction> gewfdTaskAction;
}
