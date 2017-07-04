package com.telefonica.cana.dao.taskmailbox.repository.extension;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.telefonica.cana.model.CnalpFuncPoolAssignment;

/**
 * The DAO interface for the entities
 * 
 * 
 */
public interface CnalpFuncPoolAssignmentRepositoryExtension {

    /**
     * Método que recupera los gestores asociados y vigentes
     * 
     * @return Slice<CnalpFuncPoolAssignment>
     * 
     */
    public Slice<CnalpFuncPoolAssignment> findTaskMailBoxByResponsible(Specification<CnalpFuncPoolAssignment> spec,
            Pageable page, Sort.Order sort);

    /**
     * 	Método que devuelve los buzones en base a la unidad funcional y el organizationRole
     
     * @return Slice<CnalpFuncPoolAssignment>	
     
     */
    public Slice<CnalpFuncPoolAssignment> findTaskMailboxOperators(Specification<CnalpFuncPoolAssignment> spec,
            Pageable page, Sort.Order sort);
}
