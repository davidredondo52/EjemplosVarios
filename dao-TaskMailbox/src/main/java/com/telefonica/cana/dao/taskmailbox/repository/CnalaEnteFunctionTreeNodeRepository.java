package com.telefonica.cana.dao.taskmailbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.telefonica.cana.model.CnalaEnteFunctionTreeNode;

/**
 * The Repository interface for the entities
 * 
 */
@Repository(value = "com.telefonica.cana.dao.taskmailbox.repository.CnalaEnteFunctionTreeNodeRepository")
public interface CnalaEnteFunctionTreeNodeRepository extends JpaRepository<CnalaEnteFunctionTreeNode, Long>,
        JpaSpecificationExecutor<CnalaEnteFunctionTreeNode> {

}
