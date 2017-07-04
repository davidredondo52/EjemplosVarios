package com.telefonica.cana.dao.taskmailbox.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.telefonica.cana.dao.taskmailbox.repository.extension.CnalpFuncPoolAssignmentRepositoryExtension;
import com.telefonica.cana.model.CnalpFuncPoolAssignment;

/**
 * The Repository interface for the entities
 * 
 */
@Repository(value = "com.telefonica.cana.dao.taskmailbox.repository.CnalpFuncPoolAssignmentRepository")
public interface CnalpFuncPoolAssignmentRepository extends JpaRepository<CnalpFuncPoolAssignment, BigDecimal>,
        JpaSpecificationExecutor<CnalpFuncPoolAssignment>, CnalpFuncPoolAssignmentRepositoryExtension {

}
