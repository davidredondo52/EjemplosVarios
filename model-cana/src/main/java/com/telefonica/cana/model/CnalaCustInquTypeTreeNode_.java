package com.telefonica.cana.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-09-16T17:42:29.388+0200")
@StaticMetamodel(CnalaCustInquTypeTreeNode.class)
public class CnalaCustInquTypeTreeNode_ {
	public static volatile SingularAttribute<CnalaCustInquTypeTreeNode, Timestamp> audiTiCreation;
	public static volatile SingularAttribute<CnalaCustInquTypeTreeNode, Timestamp> audiTiUpdate;
	public static volatile SingularAttribute<CnalaCustInquTypeTreeNode, Long> citnIdInquTypeTreeNode;
	public static volatile SingularAttribute<CnalaCustInquTypeTreeNode, BigDecimal> userIdCreatorParty;
	public static volatile SingularAttribute<CnalaCustInquTypeTreeNode, BigDecimal> userIdUpdaterParty;
	public static volatile SingularAttribute<CnalaCustInquTypeTreeNode, CnalaCustInquTypeTreeNode> cnalaCustInquTypeTreeNode;
	public static volatile ListAttribute<CnalaCustInquTypeTreeNode, CnalaCustInquTypeTreeNode> cnalaCustInquTypeTreeNodes;
	public static volatile SingularAttribute<CnalaCustInquTypeTreeNode, CnaldCustomerInquiryType> cnaldCustomerInquiryType;
	public static volatile ListAttribute<CnalaCustInquTypeTreeNode, CnalpCustomerInquirySpec> cnalpCustomerInquirySpecs;
	public static volatile SingularAttribute<CnalaCustInquTypeTreeNode, Long> citnIdInquTypeTreeNodeFather;
}
