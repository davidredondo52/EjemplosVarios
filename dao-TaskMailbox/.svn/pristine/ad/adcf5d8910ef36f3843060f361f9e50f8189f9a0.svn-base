package com.telefonica.cana.dao.taskmailbox.repository.extension.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.telefonica.cana.dao.taskmailbox.repository.FuncPoolAssignmentSpecifications;
import com.telefonica.cana.dao.taskmailbox.repository.extension.CnalpFuncPoolAssignmentRepositoryExtension;
import com.telefonica.cana.model.CnalpFuncPoolAssignment;

/** 
 * Implementaon de las pruebas de la entidad
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/dao-test-context.xml" })
public class CnalpFuncPoolAssignmentRepositoryExtensionTest {
    @Autowired
    private CnalpFuncPoolAssignmentRepositoryExtension cnalpFuncPoolAssignmentRepositoryImpl;

    @PersistenceContext
    private EntityManager em;

    /**
     * Prueba para el metodo de especificacion
     */
    @Test
    @Transactional
    public void findTaskMailBoxByResponsible_PageSortTest() {
        List<BigDecimal> byfunctionalpool_IdFunctionalPools = new ArrayList<BigDecimal>();
        byfunctionalpool_IdFunctionalPools.add(new BigDecimal(1));

        List<BigDecimal> byfunctionalpool_IdTaskMailboxs = new ArrayList<BigDecimal>();
        byfunctionalpool_IdTaskMailboxs.add(new BigDecimal(1));

        Specification<CnalpFuncPoolAssignment> byFunctionalPool = FuncPoolAssignmentSpecifications
                .byFunctionalPool(byfunctionalpool_IdFunctionalPools,
                        byfunctionalpool_IdTaskMailboxs);

        List<BigDecimal> byfunctionalpoolandorgarole_IdTaskMailboxs = new ArrayList<BigDecimal>();
        byfunctionalpoolandorgarole_IdTaskMailboxs.add(new BigDecimal(1));

        List<BigDecimal> byfunctionalpoolandorgarole_IdFunctionalPools = new ArrayList<BigDecimal>();
        byfunctionalpoolandorgarole_IdFunctionalPools.add(new BigDecimal(1));
        
        Specification<CnalpFuncPoolAssignment> byFunctionalPoolVig = FuncPoolAssignmentSpecifications
                .byFunctionalPoolVig(BigDecimal.ZERO, new Date(0L));

        List<BigDecimal> byfunctionalpoolandorgarole_IdOrgaRoles = new ArrayList<BigDecimal>();
        byfunctionalpoolandorgarole_IdOrgaRoles.add(new BigDecimal(1));
        Specification<CnalpFuncPoolAssignment> byFunctionalPoolAndOrgaRole = FuncPoolAssignmentSpecifications
                .byFunctionalPoolAndOrgaRole(byfunctionalpoolandorgarole_IdTaskMailboxs,
                        byfunctionalpoolandorgarole_IdFunctionalPools,
                        byfunctionalpoolandorgarole_IdOrgaRoles);

        Date toDate = new java.sql.Date(1);
        Date fromDate = new java.sql.Date(1);
        Specification<CnalpFuncPoolAssignment> byRangeDate = FuncPoolAssignmentSpecifications
                .byRangeDate(toDate, fromDate);

        Slice<CnalpFuncPoolAssignment> result = cnalpFuncPoolAssignmentRepositoryImpl
                .findTaskMailBoxByResponsible(Specifications.where(byFunctionalPool)
                        .and(byFunctionalPoolVig)
                        .and(byFunctionalPoolAndOrgaRole).and(byRangeDate), new PageRequest(10, 10),
                        new Sort.Order(Sort.Direction.ASC, "audiTiCreation"));

        assertThat(result).isEmpty();

    }
    
    /**
     * toDate null
     */
    @Test
    @Transactional
    public void findTaskMailBoxByResponsible2_PageSortTest() {
        List<BigDecimal> byfunctionalpool_IdFunctionalPools = new ArrayList<BigDecimal>();
        byfunctionalpool_IdFunctionalPools.add(new BigDecimal(1));

        List<BigDecimal> byfunctionalpool_IdTaskMailboxs = new ArrayList<BigDecimal>();
        byfunctionalpool_IdTaskMailboxs.add(new BigDecimal(1));

        Specification<CnalpFuncPoolAssignment> byFunctionalPool = FuncPoolAssignmentSpecifications
                .byFunctionalPool(byfunctionalpool_IdFunctionalPools,
                        byfunctionalpool_IdTaskMailboxs);

        List<BigDecimal> byfunctionalpoolandorgarole_IdTaskMailboxs = new ArrayList<BigDecimal>();
        byfunctionalpoolandorgarole_IdTaskMailboxs.add(new BigDecimal(1));

        List<BigDecimal> byfunctionalpoolandorgarole_IdFunctionalPools = new ArrayList<BigDecimal>();
        byfunctionalpoolandorgarole_IdFunctionalPools.add(new BigDecimal(1));

        List<BigDecimal> byfunctionalpoolandorgarole_IdOrgaRoles = new ArrayList<BigDecimal>();
        byfunctionalpoolandorgarole_IdOrgaRoles.add(new BigDecimal(1));
        Specification<CnalpFuncPoolAssignment> byFunctionalPoolAndOrgaRole = FuncPoolAssignmentSpecifications
                .byFunctionalPoolAndOrgaRole(byfunctionalpoolandorgarole_IdTaskMailboxs,
                        byfunctionalpoolandorgarole_IdFunctionalPools,
                        byfunctionalpoolandorgarole_IdOrgaRoles);

        Date toDate = null;
        Date fromDate = new java.sql.Date(1);
        Specification<CnalpFuncPoolAssignment> byRangeDate = FuncPoolAssignmentSpecifications
                .byRangeDate(toDate, fromDate);

        Slice<CnalpFuncPoolAssignment> result = cnalpFuncPoolAssignmentRepositoryImpl
                .findTaskMailBoxByResponsible(Specifications.where(byFunctionalPool)

                        .or(byFunctionalPoolAndOrgaRole).or(byRangeDate), new PageRequest(10, 10),
                        new Sort.Order(Sort.Direction.ASC, "audiTiCreation"));

        assertThat(result).isNotEmpty();

    }
    
    /**
     * toDate y fromDate null
     */
    @Test
    @Transactional
    public void findTaskMailBoxByResponsible3_PageSortTest() {
        List<BigDecimal> byfunctionalpool_IdFunctionalPools = new ArrayList<BigDecimal>();
        byfunctionalpool_IdFunctionalPools.add(new BigDecimal(1));

        List<BigDecimal> byfunctionalpool_IdTaskMailboxs = new ArrayList<BigDecimal>();
        byfunctionalpool_IdTaskMailboxs.add(new BigDecimal(1));

        Specification<CnalpFuncPoolAssignment> byFunctionalPool = FuncPoolAssignmentSpecifications
                .byFunctionalPool(byfunctionalpool_IdFunctionalPools,
                        byfunctionalpool_IdTaskMailboxs);

        List<BigDecimal> byfunctionalpoolandorgarole_IdTaskMailboxs = new ArrayList<BigDecimal>();
        byfunctionalpoolandorgarole_IdTaskMailboxs.add(new BigDecimal(1));

        List<BigDecimal> byfunctionalpoolandorgarole_IdFunctionalPools = new ArrayList<BigDecimal>();
        byfunctionalpoolandorgarole_IdFunctionalPools.add(new BigDecimal(1));

        List<BigDecimal> byfunctionalpoolandorgarole_IdOrgaRoles = new ArrayList<BigDecimal>();
        byfunctionalpoolandorgarole_IdOrgaRoles.add(new BigDecimal(1));
        Specification<CnalpFuncPoolAssignment> byFunctionalPoolAndOrgaRole = FuncPoolAssignmentSpecifications
                .byFunctionalPoolAndOrgaRole(byfunctionalpoolandorgarole_IdTaskMailboxs,
                        byfunctionalpoolandorgarole_IdFunctionalPools,
                        byfunctionalpoolandorgarole_IdOrgaRoles);

        Specification<CnalpFuncPoolAssignment> byRangeDate = FuncPoolAssignmentSpecifications
                .byRangeDate(null, null);

        Slice<CnalpFuncPoolAssignment> result = cnalpFuncPoolAssignmentRepositoryImpl
                .findTaskMailBoxByResponsible(Specifications.where(byFunctionalPool)

                        .or(byFunctionalPoolAndOrgaRole).or(byRangeDate), new PageRequest(10, 10),
                        new Sort.Order(Sort.Direction.ASC, "audiTiCreation"));

        //assertThat(result).isEmpty();

    }
    
    @Test
    @Transactional
    public void findTaskMailboxOperators() {
        Specification<CnalpFuncPoolAssignment> byFunctionalPool = FuncPoolAssignmentSpecifications
                .byFunctionalPool(Arrays.asList(new BigDecimal[]{BigDecimal.ZERO}), Arrays.asList(new BigDecimal[]{BigDecimal.ZERO}));
        cnalpFuncPoolAssignmentRepositoryImpl.findTaskMailboxOperators(byFunctionalPool, new PageRequest(10, 10),
                        new Sort.Order(Sort.Direction.ASC, "audiTiCreation"));
    }
}
