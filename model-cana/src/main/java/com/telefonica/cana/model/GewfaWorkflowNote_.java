package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.124+0200")
@StaticMetamodel(GewfaWorkflowNote.class)
public class GewfaWorkflowNote_ {
	public static volatile SingularAttribute<GewfaWorkflowNote, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<GewfaWorkflowNote, BigDecimal> paroIdOrgRole;
	public static volatile SingularAttribute<GewfaWorkflowNote, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<GewfaWorkflowNote, BigDecimal> wfnoIdWorkflowNote;
	public static volatile SingularAttribute<GewfaWorkflowNote, String> wfnoObNote;
	public static volatile SingularAttribute<GewfaWorkflowNote, GewfpWorkflow> gewfpWorkflow;
}
