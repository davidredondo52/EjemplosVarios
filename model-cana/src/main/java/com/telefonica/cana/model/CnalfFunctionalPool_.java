package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.611+0200")
@StaticMetamodel(CnalfFunctionalPool.class)
public class CnalfFunctionalPool_ {
	public static volatile SingularAttribute<CnalfFunctionalPool, Long> copaIdCommunicationPattern;
	public static volatile SingularAttribute<CnalfFunctionalPool, Long> eftnIdEnteFuncTreeNode;
	public static volatile SingularAttribute<CnalfFunctionalPool, String> fupfInStatement;
	public static volatile SingularAttribute<CnalfFunctionalPool, Long> fupoInMailboxState;
	public static volatile SingularAttribute<CnalfFunctionalPool, Long> fupoInPoolType;
	public static volatile SingularAttribute<CnalfFunctionalPool, Long> fupoInWorkMode;
	public static volatile SingularAttribute<CnalfFunctionalPool, String> fupoNaFunctionalPool;
	public static volatile SingularAttribute<CnalfFunctionalPool, Long> fupoNuSupport;
	public static volatile SingularAttribute<CnalfFunctionalPool, Timestamp> fupoTiEndValidity;
	public static volatile SingularAttribute<CnalfFunctionalPool, Timestamp> fupoTiStartValidity;
	public static volatile SingularAttribute<CnalfFunctionalPool, Long> fupsIdFuntionalPoolSpec;
	public static volatile SingularAttribute<CnalfFunctionalPool, String> lfpoDsFunctionalPool;
	public static volatile SingularAttribute<CnalfFunctionalPool, BigDecimal> psctIdFuncPoolSpChanTy;
	public static volatile SingularAttribute<CnalfFunctionalPool, Long> schaIdSalesChannel;
	public static volatile SingularAttribute<CnalfFunctionalPool, BigDecimal> userIdUserUpdater;
	public static volatile SingularAttribute<CnalfFunctionalPool, CnalfFunctionalPoolPK> id;
}
