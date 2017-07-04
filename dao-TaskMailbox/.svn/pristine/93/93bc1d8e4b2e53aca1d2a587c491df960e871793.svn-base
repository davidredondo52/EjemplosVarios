package com.telefonica.cana.dao.taskmailbox.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telefonica.cana.dao.taskmailbox.dto.OrganizationPoolAssignmentDTO;
import com.telefonica.cana.model.CnalrOrgaPoolAssignment;

/**
 * The Repository interface for the entities
 * Repositorio que representa la entidad OrganizationPoolAssignment
 */
@Repository(value = "com.telefonica.cana.dao.taskmailbox.repository.CnalrOrgaPoolAssignmentRepository")
public interface CnalrOrgaPoolAssignmentRepository extends JpaRepository<CnalrOrgaPoolAssignment, BigDecimal>,
        JpaSpecificationExecutor<CnalrOrgaPoolAssignment> {

    /**
     * Método que devuelve un listado de OrganizationPoolAssignment en base a un
     * listado de unidades funcionales.
     * 
     * @return List<OrganizationPoolAssignmentDTO>
     * 
     * @param List<BigDecimal>ids
     */
    @Query("SELECT new com.telefonica.cana.dao.taskmailbox.dto.OrganizationPoolAssignmentDTO(o.opasIdOrgaPoolAssignment,"
            + "o.paroIdOrganizationRole, o.cnalpFunctionalPool.wpooIdFunctionalPool, t.mboxIdMailbox, t.mboxCoFuncMailbox) "
            + "FROM CnalrOrgaPoolAssignment o LEFT JOIN CnalaTaskMailbox t "
            + "WHERE o.cnalpFunctionalPool.wpooIdFunctionalPool IN :ids "
            + "AND t.cnalpFunctionalPool.wpooIdFunctionalPool = o.cnalpFunctionalPool.wpooIdFunctionalPool "
            + "AND o.opasIdOrgaPoolAssignment = t.cnalrOrgaPoolAssignment2.opasIdOrgaPoolAssignment")
    public List<OrganizationPoolAssignmentDTO> findOrgTaskMailboxByFunctionalPool(
            @Param("ids") List<BigDecimal> ids);
}
