package com.telefonica.cana.dao.taskmailbox.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telefonica.cana.model.CnalrTaskMailboxL;

/**
 * The Repository interface for the entities
 * 
 */

/**
 * Método que recupera las el idioma de la plantilla.
 * @return CnalrTaskMailboxL
 * @param idMailbox BigDecimal
 * @param coLanguage Long
 */
public interface CnalrTaskMailboxRepository extends JpaRepository<CnalrTaskMailboxL, BigDecimal>,
        JpaSpecificationExecutor<CnalrTaskMailboxL> {
    
    @Query("SELECT c FROM CnalrTaskMailboxL c WHERE c.langCoLanguage = :coLanguage and c.cnalaTaskMailbox.mboxIdMailbox = :idMailbox")
    public CnalrTaskMailboxL findByIdTaskMailboxAndLanguage(@Param("idMailbox") BigDecimal idMailbox,
            @Param("coLanguage") Long coLanguage);

}
