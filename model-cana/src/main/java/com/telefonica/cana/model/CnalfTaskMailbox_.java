package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.621+0200")
@StaticMetamodel(CnalfTaskMailbox.class)
public class CnalfTaskMailbox_ {
	public static volatile SingularAttribute<CnalfTaskMailbox, Long> discIdDistributionCriteria;
	public static volatile SingularAttribute<CnalfTaskMailbox, Long> fareIdFunctionalArea;
	public static volatile SingularAttribute<CnalfTaskMailbox, Long> genaIdApplication;
	public static volatile SingularAttribute<CnalfTaskMailbox, String> lboxNaMailbox;
	public static volatile SingularAttribute<CnalfTaskMailbox, String> mbofInStatement;
	public static volatile SingularAttribute<CnalfTaskMailbox, String> mboxCoFuncMailbox;
	public static volatile SingularAttribute<CnalfTaskMailbox, Long> mboxInBrotherReallocation;
	public static volatile SingularAttribute<CnalfTaskMailbox, Long> mboxInDistributionMode;
	public static volatile SingularAttribute<CnalfTaskMailbox, Long> mboxInGroupDistribCriteria;
	public static volatile SingularAttribute<CnalfTaskMailbox, Long> mboxInManualDistribMode;
	public static volatile SingularAttribute<CnalfTaskMailbox, Long> mboxInState;
	public static volatile SingularAttribute<CnalfTaskMailbox, Long> mboxQuMaximumAmount;
	public static volatile SingularAttribute<CnalfTaskMailbox, Long> mboxQuVolume;
	public static volatile SingularAttribute<CnalfTaskMailbox, Timestamp> mboxTiEndValidity;
	public static volatile SingularAttribute<CnalfTaskMailbox, Timestamp> mboxTiStartValidity;
	public static volatile SingularAttribute<CnalfTaskMailbox, BigDecimal> opasIdOrgaPoolAssignment;
	public static volatile SingularAttribute<CnalfTaskMailbox, BigDecimal> paroIdOrganizationRole;
	public static volatile SingularAttribute<CnalfTaskMailbox, BigDecimal> ruleIdRule;
	public static volatile SingularAttribute<CnalfTaskMailbox, BigDecimal> userIdUserUpdater;
	public static volatile SingularAttribute<CnalfTaskMailbox, BigDecimal> wpooIdFunctionalPool;
	public static volatile SingularAttribute<CnalfTaskMailbox, CnalfTaskMailboxPK> id;
}
