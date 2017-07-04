package com.telefonica.cana.dao.taskmailbox.repository.extension.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.telefonica.cana.dao.taskmailbox.repository.CnalaTaskMailboxRepository;
import com.telefonica.cana.dao.taskmailbox.repository.extension.CnalaTaskMailboxRepositoryExtension;
import com.telefonica.cana.model.CnalaTaskMailbox;

/**
 * The DAO implementation for the entities.
 * 
 * 
 */
public class CnalaTaskMailboxRepositoryImpl implements CnalaTaskMailboxRepositoryExtension {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private CnalaTaskMailboxRepository repository;

    /**
     * Call super implementation
     */
    public CnalaTaskMailboxRepositoryImpl() {
        super();
    }

    /**
     * Método que recupera todos los taskMailbox en base a unos criterios
     * pasados por párametro
     * 
     * @return List<CnalaTaskMailbox>
     * 
     */
    public List<CnalaTaskMailbox> findTaskMailbox(Specification<CnalaTaskMailbox> spec, Sort sort) {
        return repository.findAll(spec, sort);
    }

    /**
     * Método que recupera todos los taskMailbox en base a unos criterios
     * pasados por párametro, junto con sus relaciones
     * 
     * @return Page<CnalaTaskMailbox>
     * 
     */
    public Page<CnalaTaskMailbox> findFullTaskMailbox(Specification<CnalaTaskMailbox> spec, Pageable page,
            Sort.Order sort) {
        PageRequest pageRequest = new PageRequest(page.getPageNumber(), page.getPageSize(), sort.getDirection(),
                sort.getProperty());
        return repository.findAll(spec, pageRequest);
    }

    /**
     * Método que obtiene un listado de buzones en base a la función empresarial
     * 
     * @return List<CnalaTaskMailbox>
     * 
     */
    public List<CnalaTaskMailbox> findTaskMailboxByEnterpriseFunction(Specification<CnalaTaskMailbox> spec) {
        return repository.findAll(spec);
    }

    /**
     * Método que devuelve los buzones en base a la unidad funcional y el
     * organizationRole
     * 
     * @return Slice<CnalaTaskMailbox>
     * 
     */
    public Slice<CnalaTaskMailbox> findTaskMailboxOperators(Specification<CnalaTaskMailbox> spec, Pageable page,
            Sort.Order sort) {
        PageRequest pageRequest = new PageRequest(page.getPageNumber(), page.getPageSize(), sort.getDirection(),
                sort.getProperty());
        return repository.findAll(spec, pageRequest);
    }

    /**
     * 	Método que devuelve los buzones tras join con la entidad GEWFR_MAILBOX_ACCESS
     
     * @return Slice<CnalaTaskMailbox>	
     
     */
    public Slice<CnalaTaskMailbox> findTaskMailboxAccess(Specification<CnalaTaskMailbox> spec, Pageable page,
            Sort.Order sort) {
        PageRequest pageRequest = new PageRequest(page.getPageNumber(), page.getPageSize(), sort.getDirection(),
                sort.getProperty());
        return repository.findAll(spec, pageRequest);
    }
}
