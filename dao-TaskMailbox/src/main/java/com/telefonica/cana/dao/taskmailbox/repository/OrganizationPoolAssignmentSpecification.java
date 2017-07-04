package com.telefonica.cana.dao.taskmailbox.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.telefonica.cana.model.CnalaEnteFunctionTreeNode;
import com.telefonica.cana.model.CnalaEnteFunctionTreeNode_;
import com.telefonica.cana.model.CnalpFunctionalPool;
import com.telefonica.cana.model.CnalpFunctionalPool_;
import com.telefonica.cana.model.CnalrFunctionalPoolL;
import com.telefonica.cana.model.CnalrFunctionalPoolL_;
import com.telefonica.cana.model.CnalrOrgaPoolAssignment;
import com.telefonica.cana.model.CnalrOrgaPoolAssignment_;

public class OrganizationPoolAssignmentSpecification {

    /*
     * Consulta en CnalrOrgaPoolAssignment por el criterio del id del
     * organization role
     */

    public static Specification<CnalrOrgaPoolAssignment> byOrganizationRole(BigDecimal id) {
        return new Specification<CnalrOrgaPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalrOrgaPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
                return cb.equal(root.get(CnalrOrgaPoolAssignment_.paroIdOrganizationRole), id);
            }
        };
    }

    /*
     * Consulta en CnalrOrgaPoolAssignment por el criterio del id del
     * organization name
     */

    public static Specification<CnalrOrgaPoolAssignment> byOrganizationName(String tradingName) {
        return new Specification<CnalrOrgaPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalrOrgaPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
            	Join<CnalrOrgaPoolAssignment, CnalpFunctionalPool> join = root.join(CnalrOrgaPoolAssignment_.cnalpFunctionalPool);
                return cb.equal(join.get(CnalpFunctionalPool_.fupoNaFunctionalPool), tradingName);
            }
        };
    }

    /*
     * Consulta en CnalrOrgaPoolAssignment por el criterio del id del
     * organization description, multilanguage
     */

    public static Specification<CnalrOrgaPoolAssignment> byOrganizationDescription(String description, Boolean isDifferentLanguage, BigDecimal idiomaUsuario) {
        return new Specification<CnalrOrgaPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalrOrgaPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
            	List<Predicate> listPredicate = new ArrayList<Predicate>();
            	Join<CnalrOrgaPoolAssignment, CnalpFunctionalPool> join1 = root.join(CnalrOrgaPoolAssignment_.cnalpFunctionalPool);
            	Join<CnalpFunctionalPool, CnalrFunctionalPoolL> join2 = join1.join(CnalpFunctionalPool_.cnalrFunctionalPoolLs);;
            	if(!isDifferentLanguage){
            		listPredicate.add(cb.equal(join1.get(CnalpFunctionalPool_.lfpoDsFunctionalPool), description));
            	} else{
            		listPredicate.add(cb.equal(join2.get(CnalrFunctionalPoolL_.langCoLanguage), idiomaUsuario));
            		listPredicate.add(cb.equal(join2.get(CnalrFunctionalPoolL_.lfpoDsFunctionalPool), description));
            	}
                return cb.and(listPredicate.toArray(new Predicate[] {}));
            }
        };
    }

    /*
     * Consulta en CnalrOrgaPoolAssignment por el criterio del id del
     * Enterprise treeNode
     */

    public static Specification<CnalrOrgaPoolAssignment> byEnteFunctionTreeNode(Long id) {
        return new Specification<CnalrOrgaPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalrOrgaPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
            	CnalaEnteFunctionTreeNode cnalaEnteFunctionTreeNode = new CnalaEnteFunctionTreeNode();
                cnalaEnteFunctionTreeNode.setEftnIdEnteFuncTreeNode(id);
                return cb.equal(root.get(CnalrOrgaPoolAssignment_.cnalpFunctionalPool).get(CnalpFunctionalPool_.cnalaEnteFunctionTreeNode), cnalaEnteFunctionTreeNode);
            }
        };
    }

    /*
     * Consulta en CnalrOrgaPoolAssignment por el criterio del id(lista de ids) del
     * Enterprise treeNode
     */

    public static Specification<CnalrOrgaPoolAssignment> byEnteFunctionTreeNodeListIds(List<Long> ids) {
        return new Specification<CnalrOrgaPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalrOrgaPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
                return cb.and(root.get(CnalrOrgaPoolAssignment_.cnalpFunctionalPool).
                		get(CnalpFunctionalPool_.cnalaEnteFunctionTreeNode).get(CnalaEnteFunctionTreeNode_.eftnIdEnteFuncTreeNode).in(ids));
            }
        };
    }

    /*
     * Consulta en CnalrOrgaPoolAssignment por el criterio del id del functional
     * pool
     */

    public static Specification<CnalrOrgaPoolAssignment> byFunctionalPool(BigDecimal id) {
        return new Specification<CnalrOrgaPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalrOrgaPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
            	CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
            	cnalpFunctionalPool.setWpooIdFunctionalPool(id);
                return cb.equal(root.get(CnalrOrgaPoolAssignment_.cnalpFunctionalPool), cnalpFunctionalPool);
            }
        };
    }

    /*
     * Consulta en CnalrOrgaPoolAssignment por el criterio del id del
     * organization pool assignment
     */

    public static Specification<CnalrOrgaPoolAssignment> byOrganizationPoolAssignment(BigDecimal id) {
        return new Specification<CnalrOrgaPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalrOrgaPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
                return cb.equal(root.get(CnalrOrgaPoolAssignment_.opasIdOrgaPoolAssignment), id);
            }
        };
    }

    /*
     * Consulta en CnalrOrgaPoolAssignment por el criterio del id del
     * taskmailbox
     */

    public static Specification<CnalrOrgaPoolAssignment> byTaskMailbox(BigDecimal id) {
        return new Specification<CnalrOrgaPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalrOrgaPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
                return null;
            }
        };
    }

    /*
     * Consulta en CnalrOrgaPoolAssignment por el criterio del id del
     * ProductCatalog
     */

    public static Specification<CnalrOrgaPoolAssignment> byProductCatalog(BigDecimal id) {
        return new Specification<CnalrOrgaPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalrOrgaPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
                return null;
            }
        };
    }
}
