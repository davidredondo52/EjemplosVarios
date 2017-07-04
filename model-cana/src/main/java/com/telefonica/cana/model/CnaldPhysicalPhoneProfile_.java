package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.578+0200")
@StaticMetamodel(CnaldPhysicalPhoneProfile.class)
public class CnaldPhysicalPhoneProfile_ {
	public static volatile SingularAttribute<CnaldPhysicalPhoneProfile, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnaldPhysicalPhoneProfile, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnaldPhysicalPhoneProfile, BigDecimal> paroIdOrganizationRole;
	public static volatile SingularAttribute<CnaldPhysicalPhoneProfile, String> ppprCoPhysicalPhoneProfile;
	public static volatile SingularAttribute<CnaldPhysicalPhoneProfile, Date> ppprDaEndValidity;
	public static volatile SingularAttribute<CnaldPhysicalPhoneProfile, Date> ppprDaStartValidity;
	public static volatile SingularAttribute<CnaldPhysicalPhoneProfile, Long> ppprIdPhysicalPhoneProfile;
	public static volatile SingularAttribute<CnaldPhysicalPhoneProfile, String> ppprNaPhyPhoneProfile;
	public static volatile SingularAttribute<CnaldPhysicalPhoneProfile, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnaldPhysicalPhoneProfile, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnaldPhysicalPhoneProfile, CnaldCommunicationPattern> cnaldCommunicationPattern;
	public static volatile ListAttribute<CnaldPhysicalPhoneProfile, CnalrPhoneSkillPhyProfile> cnalrPhoneSkillPhyProfiles;
}
