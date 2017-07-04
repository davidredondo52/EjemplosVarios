package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:30.666+0200")
@StaticMetamodel(ProcrUtMovDocument.class)
public class ProcrUtMovDocument_ {
	public static volatile SingularAttribute<ProcrUtMovDocument, String> attaCoDocument;
	public static volatile SingularAttribute<ProcrUtMovDocument, String> attaNaFile;
	public static volatile SingularAttribute<ProcrUtMovDocument, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<ProcrUtMovDocument, BigDecimal> modoIdUtMovDocument;
	public static volatile SingularAttribute<ProcrUtMovDocument, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<ProcrUtMovDocument, ProcaUserTaskMovement> procaUserTaskMovement;
}
