package com.telefonica.cana.dao.taskmailbox.repository.extension;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.telefonica.cana.model.CnalaTaskMailbox;

/**
 * The DAO interface for the entities
 * 
 * 
 */
public interface CnalaTaskMailboxRepositoryExtension {

    /**
     * Método que recupera todos los taskMailbox en base a unos criterios
     * pasados por párametro
     * 
     * @return List<CnalaTaskMailbox>
     * 
     */
    public List<CnalaTaskMailbox> findTaskMailbox(Specification<CnalaTaskMailbox> spec, Sort sort);

    /**
     * Método que recupera todos los taskMailbox en base a unos criterios
     * pasados por párametro, junto con sus relaciones
     * 
     * @return Page<CnalaTaskMailbox>
     * 
     */
    public Page<CnalaTaskMailbox> findFullTaskMailbox(Specification<CnalaTaskMailbox> spec, Pageable page,
            Sort.Order sort);

    /**
     * Método que obtiene un listado de buzones en base a la función empresarial
     * 
     * @return List<CnalaTaskMailbox>
     * 
     */
    public List<CnalaTaskMailbox> findTaskMailboxByEnterpriseFunction(Specification<CnalaTaskMailbox> spec);

    /**
     * Método que devuelve los buzones en base a la unidad funcional y el
     * organizationRole
     * 
     * @return Slice<CnalaTaskMailbox>
     * 
     */
    public Slice<CnalaTaskMailbox> findTaskMailboxOperators(Specification<CnalaTaskMailbox> spec, Pageable page,
            Sort.Order sort);

    /**
     * 	Método que devuelve los buzones tras join con la entidad GEWFR_MAILBOX_ACCESS
     
     * @return Slice<CnalaTaskMailbox>	
     
     */
    public Slice<CnalaTaskMailbox> findTaskMailboxAccess(Specification<CnalaTaskMailbox> spec, Pageable page,
            Sort.Order sort);
}
