package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.770+0200")
@StaticMetamodel(CnalpTemplate.class)
public class CnalpTemplate_ {
	public static volatile SingularAttribute<CnalpTemplate, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalpTemplate, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalpTemplate, BigDecimal> comeIdContactMediumOrigin;
	public static volatile SingularAttribute<CnalpTemplate, String> leteNaTemplate;
	public static volatile SingularAttribute<CnalpTemplate, String> lsteNaSubject;
	public static volatile SingularAttribute<CnalpTemplate, Long> stptInConcatenationType;
	public static volatile SingularAttribute<CnalpTemplate, Date> tpteDaEndValidity;
	public static volatile SingularAttribute<CnalpTemplate, Date> tpteDaStartValidity;
	public static volatile SingularAttribute<CnalpTemplate, BigDecimal> tpteIdTemplate;
	public static volatile SingularAttribute<CnalpTemplate, Long> tpteInRecipient;
	public static volatile SingularAttribute<CnalpTemplate, Boolean> tpteInTemplateType;
	public static volatile SingularAttribute<CnalpTemplate, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalpTemplate, BigDecimal> userIdUpdaterParty;
	public static volatile ListAttribute<CnalpTemplate, CnalaLabelSubtemplate> cnalaLabelSubtemplates1;
	public static volatile ListAttribute<CnalpTemplate, CnalaLabelSubtemplate> cnalaLabelSubtemplates2;
	public static volatile ListAttribute<CnalpTemplate, CnalaTemplateLabel> cnalaTemplateLabels1;
	public static volatile ListAttribute<CnalpTemplate, CnalaTemplateLabel> cnalaTemplateLabels2;
	public static volatile SingularAttribute<CnalpTemplate, CnaldDocumentFormat> cnaldDocumentFormat;
	public static volatile SingularAttribute<CnalpTemplate, CnaldTemplateType> cnaldTemplateType;
	public static volatile ListAttribute<CnalpTemplate, CnalrLanguageTemplate> cnalrLanguageTemplates;
	public static volatile ListAttribute<CnalpTemplate, CnalrTemplateChannelType> cnalrTemplateChannelTypes;
	public static volatile ListAttribute<CnalpTemplate, CnalrTemplateL> cnalrTemplateLs;
	public static volatile ListAttribute<CnalpTemplate, CnalrTemplateMarketSegment> cnalrTemplateMarketSegments;
	public static volatile ListAttribute<CnalpTemplate, CnalrTemplateModel> cnalrTemplateModels;
	public static volatile ListAttribute<CnalpTemplate, ScderDemandTypeTemplate> scderDemandTypeTemplates;
}
