package com.telefonica.cana.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.283+0200")
@StaticMetamodel(CecacLoggedManager.class)
public class CecacLoggedManager_ {
	public static volatile SingularAttribute<CecacLoggedManager, Long> chatIdChannelType;
	public static volatile SingularAttribute<CecacLoggedManager, Long> enfuIdEnterpriseFunctionN1;
	public static volatile SingularAttribute<CecacLoggedManager, Long> enfuIdEnterpriseFunctionN2;
	public static volatile SingularAttribute<CecacLoggedManager, Long> enfuIdEnterpriseFunctionN3;
	public static volatile SingularAttribute<CecacLoggedManager, Long> fpasInDefaultPool;
	public static volatile SingularAttribute<CecacLoggedManager, String> fupoNaFunctionalPool;
	public static volatile SingularAttribute<CecacLoggedManager, String> lchtNaChannelType;
	public static volatile SingularAttribute<CecacLoggedManager, String> lefuNaEnterpriseFunctionN1;
	public static volatile SingularAttribute<CecacLoggedManager, String> lefuNaEnterpriseFunctionN2;
	public static volatile SingularAttribute<CecacLoggedManager, String> lefuNaEnterpriseFunctionN3;
	public static volatile SingularAttribute<CecacLoggedManager, Boolean> lomaInLogged;
	public static volatile SingularAttribute<CecacLoggedManager, String> panaNaFatherParty;
	public static volatile SingularAttribute<CecacLoggedManager, String> panaNaProvider;
	public static volatile SingularAttribute<CecacLoggedManager, BigDecimal> paroIdFunctionalRole;
	public static volatile SingularAttribute<CecacLoggedManager, BigDecimal> partIdFatherParty;
	public static volatile SingularAttribute<CecacLoggedManager, BigDecimal> partIdProviderParty;
	public static volatile SingularAttribute<CecacLoggedManager, String> prtyNaFunctionalRoleSpec;
	public static volatile SingularAttribute<CecacLoggedManager, Long> rotyIdFatherRoleSpec;
	public static volatile SingularAttribute<CecacLoggedManager, Long> rotyIdFunctionalRoleSpec;
	public static volatile SingularAttribute<CecacLoggedManager, Long> segmIdMarketSegment;
	public static volatile SingularAttribute<CecacLoggedManager, Long> segmIdMarketTerritory;
	public static volatile SingularAttribute<CecacLoggedManager, String> segmNaMarketSegment;
	public static volatile SingularAttribute<CecacLoggedManager, String> segmNaMarketTerritory;
	public static volatile SingularAttribute<CecacLoggedManager, BigDecimal> wpooIdFunctionalPool;
	public static volatile SingularAttribute<CecacLoggedManager, CecacLoggedManagerPK> id;
}
