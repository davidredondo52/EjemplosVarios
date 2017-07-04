package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.616+0200")
@StaticMetamodel(PrdedUserTaskSpec.class)
public class PrdedUserTaskSpec_ {
	public static volatile SingularAttribute<PrdedUserTaskSpec, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<PrdedUserTaskSpec, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<PrdedUserTaskSpec, Timestamp> bsesDaEndValidity;
	public static volatile SingularAttribute<PrdedUserTaskSpec, Timestamp> bsesDaStartValidity;
	public static volatile SingularAttribute<PrdedUserTaskSpec, String> bsesDsBusinessService;
	public static volatile SingularAttribute<PrdedUserTaskSpec, Long> bsesIdUserTaskSpec;
	public static volatile SingularAttribute<PrdedUserTaskSpec, String> bsesNaBusinessService;
	public static volatile SingularAttribute<PrdedUserTaskSpec, Long> genaIdApplication;
	public static volatile SingularAttribute<PrdedUserTaskSpec, Long> prosIdProcessSpecification;
	public static volatile SingularAttribute<PrdedUserTaskSpec, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<PrdedUserTaskSpec, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<PrdedUserTaskSpec, Long> utspInManageBetweenAreas;
	public static volatile SingularAttribute<PrdedUserTaskSpec, Boolean> utspInSendUp;
	public static volatile SingularAttribute<PrdedUserTaskSpec, String> utspNaTechnicalUt;
	public static volatile SingularAttribute<PrdedUserTaskSpec, PrdeaUtSpecAlarm> prdeaUtSpecAlarm;
	public static volatile ListAttribute<PrdedUserTaskSpec, PrderUserTaskSpecMailbox> prderUserTaskSpecMailboxs;
	public static volatile ListAttribute<PrdedUserTaskSpec, ProcpUserTaskManagement> procpUserTaskManagements;
}
