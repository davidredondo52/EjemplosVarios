package com.telefonica.cana.dao.taskmailbox.repository.extension.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

import com.telefonica.cana.dao.taskmailbox.repository.CnalpFuncPoolAssignmentRepository;
import com.telefonica.cana.dao.taskmailbox.repository.extension.CnalpFuncPoolAssignmentRepositoryExtension;
import com.telefonica.cana.model.CnalpFuncPoolAssignment;

/**
 * The DAO implementation for the entities.
 * 
 * 
 */
public class CnalpFuncPoolAssignmentRepositoryImpl implements CnalpFuncPoolAssignmentRepositoryExtension {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private CnalpFuncPoolAssignmentRepository repository;

    /**
     * Call super implementation
     */
    public CnalpFuncPoolAssignmentRepositoryImpl() {
        super();
    }

    /**
     * Método que recupera los gestores asociados y vigentes
     * 
     * @return Slice<CnalpFuncPoolAssignment>
     * 
     */
    public Slice<CnalpFuncPoolAssignment> findTaskMailBoxByResponsible(Specification<CnalpFuncPoolAssignment> spec,
            Pageable page, Sort.Order sort) {
        PageRequest pageRequest = new PageRequest(page.getPageNumber(), page.getPageSize(), sort.getDirection(),
                sort.getProperty());
        return repository.findAll(spec, pageRequest);
    }

    /**
     * 	Método que devuelve los buzones en base a la unidad funcional y el organizationRole
     
     * @return Slice<CnalpFuncPoolAssignment>	
     
     */
    public Slice<CnalpFuncPoolAssignment> findTaskMailboxOperators(Specification<CnalpFuncPoolAssignment> spec,
            Pageable page, Sort.Order sort) {
        PageRequest pageRequest = new PageRequest(page.getPageNumber(), page.getPageSize(), sort.getDirection(),
                sort.getProperty());
        return repository.findAll(spec, pageRequest);
    }
}
