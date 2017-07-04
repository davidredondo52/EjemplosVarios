package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.651+0200")
@StaticMetamodel(CnalhFunctionalPool.class)
public class CnalhFunctionalPool_ {
	public static volatile SingularAttribute<CnalhFunctionalPool, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalhFunctionalPool, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalhFunctionalPool, Long> copaIdCommunicationPattern;
	public static volatile SingularAttribute<CnalhFunctionalPool, Long> eftnIdEnteFuncTreeNode;
	public static volatile SingularAttribute<CnalhFunctionalPool, Long> fupoInMailboxState;
	public static volatile SingularAttribute<CnalhFunctionalPool, Long> fupoInPoolType;
	public static volatile SingularAttribute<CnalhFunctionalPool, Long> fupoInWorkMode;
	public static volatile SingularAttribute<CnalhFunctionalPool, String> fupoNaFunctionalPool;
	public static volatile SingularAttribute<CnalhFunctionalPool, Long> fupoNuSupport;
	public static volatile SingularAttribute<CnalhFunctionalPool, Timestamp> fupoTiEndValidity;
	public static volatile SingularAttribute<CnalhFunctionalPool, Timestamp> fupoTiStartValidity;
	public static volatile SingularAttribute<CnalhFunctionalPool, Long> fupsIdFuntionalPoolSpec;
	public static volatile SingularAttribute<CnalhFunctionalPool, String> lfpoDsFunctionalPool;
	public static volatile SingularAttribute<CnalhFunctionalPool, BigDecimal> psctIdFuncPoolSpChanTy;
	public static volatile SingularAttribute<CnalhFunctionalPool, Long> schaIdSalesChannel;
	public static volatile SingularAttribute<CnalhFunctionalPool, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalhFunctionalPool, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalhFunctionalPool, BigDecimal> wpooIdFunctionalPool;
}
