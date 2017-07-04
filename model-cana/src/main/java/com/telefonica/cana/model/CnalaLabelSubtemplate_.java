package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.453+0200")
@StaticMetamodel(CnalaLabelSubtemplate.class)
public class CnalaLabelSubtemplate_ {
	public static volatile SingularAttribute<CnalaLabelSubtemplate, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalaLabelSubtemplate, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalaLabelSubtemplate, BigDecimal> lsbtIdLabelSubtemplate;
	public static volatile SingularAttribute<CnalaLabelSubtemplate, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalaLabelSubtemplate, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalaLabelSubtemplate, CnalaTemplateLabel> cnalaTemplateLabel;
	public static volatile SingularAttribute<CnalaLabelSubtemplate, CnalpTemplate> cnalpTemplate1;
	public static volatile SingularAttribute<CnalaLabelSubtemplate, CnalpTemplate> cnalpTemplate2;
}
