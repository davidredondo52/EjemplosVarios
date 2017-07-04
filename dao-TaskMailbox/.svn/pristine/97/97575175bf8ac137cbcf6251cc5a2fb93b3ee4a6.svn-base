package com.telefonica.cana.dao.taskmailbox.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.telefonica.cana.model.CnalaTaskMailbox;

@Transactional
@ContextConfiguration(locations = { "classpath:META-INF/spring/dao-test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CnalaTaskMailboxRepositoryTest {

    @Autowired
    private CnalaTaskMailboxRepository cnalataskmailboxrepository;

    @Test
    public void findManagerByTaskMailbox_IdsCodesTest() {
        List idss = new ArrayList<BigDecimal>();
        BigDecimal ids = new BigDecimal("0");
        idss.add(ids);

        List codess = new ArrayList<String>();
        String codes = "A";
        codess.add(codes);

        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository.findManagerByTaskMailbox(idss

        , codess);
        assertThat(cnalataskmailboxs).isEmpty();
    }

    @Test
    public void findTaskMailboxByFunctionalArea_IdsTest() {
        List idss = new ArrayList<Integer>();
        Integer ids = new Integer("0");
        idss.add(ids);

        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository.findTaskMailboxByFunctionalArea(idss);
        assertThat(cnalataskmailboxs).isEmpty();
    }

    @Test
    public void findTasksMailboxesManager_IdOrganizationRolePageSortTest() {

        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository.findTasksMailboxesManager(
                new BigDecimal(0)

                , new PageRequest(1, 1));
        assertThat(cnalataskmailboxs).isEmpty();
    }

    @Test
    public void testFindTaskMailbox() {
        Specification<CnalaTaskMailbox> byId = TaskMailboxSpecifications.byId(new BigDecimal(0)

        , "A");
        Specification<CnalaTaskMailbox> byNameLike = TaskMailboxSpecifications.byNameLike("A");
        Specification<CnalaTaskMailbox> byIdOrganizationRole = TaskMailboxSpecifications
                .byIdOrganizationRole(new BigDecimal(0));
        Specification<CnalaTaskMailbox> byIdFunctionalPool = TaskMailboxSpecifications
                .byIdFunctionalPool(new BigDecimal(0));
        Specification<CnalaTaskMailbox> byIdDistributionCriteria = TaskMailboxSpecifications
                .byIdDistributionCriteria(new Integer(0));
        Specification<CnalaTaskMailbox> byIdRule = TaskMailboxSpecifications.byIdRule(new BigDecimal(0));
        Specification<CnalaTaskMailbox> byCode = TaskMailboxSpecifications.byCode("A");
        Specification<CnalaTaskMailbox> byRangeDate = TaskMailboxSpecifications.byRangeDate(new Date(0)

        , new Date(0));
        
        List <BigDecimal> listaIdsOrga = new ArrayList<BigDecimal>();
        Specification<CnalaTaskMailbox> byTaskMailboxAndOrgRole = TaskMailboxSpecifications.byTaskMailboxAndOrgRole(listaIdsOrga);
        
        Specification<CnalaTaskMailbox> byShowAllLanguages = TaskMailboxSpecifications
                .byShowAllLanguages(new Boolean(true));
        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository.findAll(Specifications.where(byId)

                .and(byNameLike)

                .and(byIdOrganizationRole)

                .and(byIdFunctionalPool)

                .and(byIdDistributionCriteria)

                .and(byIdRule)

                .and(byCode)

                .and(byRangeDate)

                .and(byShowAllLanguages), new Sort(Sort.Direction.ASC, "MboxIdMailbox"));
        assertThat(cnalataskmailboxs).isEmpty();

    }

    @Test
    public void testFindFullTaskMailbox() {
        Specification<CnalaTaskMailbox> byId = TaskMailboxSpecifications.byId(new BigDecimal(0)

        , "A");
        Specification<CnalaTaskMailbox> byCode = TaskMailboxSpecifications.byCode("A");
        Specification<CnalaTaskMailbox> byNameLike = TaskMailboxSpecifications.byNameLike("A");
        Specification<CnalaTaskMailbox> byRangeDate = TaskMailboxSpecifications.byRangeDate(new Date(0)

        , new Date(0));
        Specification<CnalaTaskMailbox> byIdFunctionalPool = TaskMailboxSpecifications
                .byIdFunctionalPool(new BigDecimal(0));
        Specification<CnalaTaskMailbox> byIdOrganizationRole = TaskMailboxSpecifications
                .byIdOrganizationRole(new BigDecimal(0));
        Specification<CnalaTaskMailbox> byShowAllLanguages = TaskMailboxSpecifications
                .byShowAllLanguages(new Boolean(true));
        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository.findAll(Specifications.where(byId)

                .and(byCode)

                .and(byNameLike)

                .and(byRangeDate)

                .and(byIdFunctionalPool)

                .and(byIdOrganizationRole)

                .and(byShowAllLanguages), new PageRequest(1, 20, new Sort(Sort.Direction.ASC, "MboxIdMailbox")));
        assertThat(cnalataskmailboxs).isEmpty();

    }

    @Test
    public void testFindTaskMailboxByEnterpriseFunction() {
        Specification<CnalaTaskMailbox> byId = TaskMailboxSpecifications.byId(new BigDecimal(0)

        , "A");
        Specification<CnalaTaskMailbox> byNameLike = TaskMailboxSpecifications.byNameLike("A");
        Specification<CnalaTaskMailbox> byIdFunctionalPool = TaskMailboxSpecifications
                .byIdFunctionalPool(new BigDecimal(0));
        Specification<CnalaTaskMailbox> byIdEnterpriseFunction = TaskMailboxSpecifications
                .byIdEnterpriseFunction(new Integer(0));
        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository.findAll(Specifications.where(byId)

                .and(byNameLike)

                .and(byIdFunctionalPool)

                .and(byIdEnterpriseFunction));
        assertThat(cnalataskmailboxs).isEmpty();

    }

    @Test
    public void testFindTaskMailboxOperators() {
        Specification<CnalaTaskMailbox> byIdFunctionalPool = TaskMailboxSpecifications
                .byIdFunctionalPool(new BigDecimal(0));
        Specification<CnalaTaskMailbox> byIdOrganizationRole = TaskMailboxSpecifications
                .byIdOrganizationRole(new BigDecimal(0));
        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository
                .findAll(Specifications.where(byIdFunctionalPool)

                        .and(byIdOrganizationRole),
                        new PageRequest(1, 20, new Sort(Sort.Direction.ASC, "MboxIdMailbox")));
        assertThat(cnalataskmailboxs).isEmpty();

    }
    
    //
    
    @Test
    public void testFindbyNameLikeMultilanguage() {
        Specification<CnalaTaskMailbox> byIdFunctionalPool = TaskMailboxSpecifications
                .byIdFunctionalPool(new BigDecimal(0));
        Specification<CnalaTaskMailbox> byIdOrganizationRole = TaskMailboxSpecifications
                .byIdOrganizationRole(new BigDecimal(0));
        Specification<CnalaTaskMailbox> byTaskMailboxAndOrgRole = TaskMailboxSpecifications
                .byTaskMailboxAndOrgRole(Arrays.asList(new BigDecimal[]{BigDecimal.ZERO}));
        
        Specification<CnalaTaskMailbox> byNameLikeMultilanguage = TaskMailboxSpecifications
                .byNameLikeMultilanguage("Name", BigDecimal.ONE);
        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository
                .findAll(Specifications.where(byIdFunctionalPool)
                        .and(byIdOrganizationRole).and(byNameLikeMultilanguage).and(byTaskMailboxAndOrgRole),
                        new PageRequest(1, 20, new Sort(Sort.Direction.ASC, "MboxIdMailbox")));
        assertThat(cnalataskmailboxs).isEmpty();

    }
    
    @Test
    public void testFindByRangeDate1() {
        Specification<CnalaTaskMailbox> byRangeDate = TaskMailboxSpecifications
                .byRangeDate(null, new java.sql.Date(new java.util.Date().getTime()));
        Specification<CnalaTaskMailbox> byNameLike = TaskMailboxSpecifications.byNameLike("A");
        Specification<CnalaTaskMailbox> byCode = TaskMailboxSpecifications.byCode("A");
        
        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository
                .findAll(Specifications.where(byRangeDate)
                        .and(byNameLike)
                        .and(byCode),                        
                        new PageRequest(1, 20, new Sort(Sort.Direction.ASC, "MboxIdMailbox")));
        assertThat(cnalataskmailboxs).isEmpty();

    }
    
    @Test
    public void testFindByRangeDate2() {
        Specification<CnalaTaskMailbox> byRangeDate = TaskMailboxSpecifications
                .byRangeDate(new java.sql.Date(new java.util.Date().getTime()), 
                        new java.sql.Date(new java.util.Date().getTime()));
        Specification<CnalaTaskMailbox> byNameLike = TaskMailboxSpecifications.byNameLike("A");
        Specification<CnalaTaskMailbox> byCode = TaskMailboxSpecifications.byCode("A");
        
        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository
                .findAll(Specifications.where(byRangeDate)
                        .and(byNameLike)
                        .and(byCode),
                        new PageRequest(1, 20, new Sort(Sort.Direction.ASC, "MboxIdMailbox")));
        assertThat(cnalataskmailboxs).isEmpty();

    }
    
    @Test
    public void testFindByRangeDate3() {
        Specification<CnalaTaskMailbox> byRangeDate = TaskMailboxSpecifications
                .byRangeDate(null, null);
        Specification<CnalaTaskMailbox> byNameLike = TaskMailboxSpecifications.byNameLike("A");
        Specification<CnalaTaskMailbox> byCode = TaskMailboxSpecifications.byCode("A");
        
        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository
                .findAll(Specifications.where(byRangeDate)
                        .and(byNameLike)
                        .and(byCode),
                        new PageRequest(1, 20, new Sort(Sort.Direction.ASC, "MboxIdMailbox")));
        assertThat(cnalataskmailboxs).isEmpty();

    }
    
    @Test
    public void testfindTaskMailbox() {
        Specification<CnalaTaskMailbox> byRangeDate = TaskMailboxSpecifications
                .byId(BigDecimal.ONE, "1");

        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository
                .findTaskMailbox(byRangeDate, 
                        new Sort(new Sort.Order("mboxIdMailbox")));
        assertThat(cnalataskmailboxs).isEmpty();

    }
    
    @Test
    public void testfindFullTaskMailbox() {
        Specification<CnalaTaskMailbox> byRangeDate = TaskMailboxSpecifications
                .byId(BigDecimal.ONE, "1");

        Pageable p = new PageRequest(1, 20);
        
        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository
                .findFullTaskMailbox(byRangeDate,
                                p,
                                new Sort.Order("mboxIdMailbox"));
        assertThat(cnalataskmailboxs).isEmpty();

    }
    
    @Test
    public void testfindTaskMailboxByEnterpriseFunction() {
        Specification<CnalaTaskMailbox> byRangeDate = TaskMailboxSpecifications
                .byId(BigDecimal.ONE, "1");
        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository
                .findTaskMailboxByEnterpriseFunction(byRangeDate);
        assertThat(cnalataskmailboxs).isEmpty();

    }
    
    @Test
    public void testfindTaskMailboxOperators() {
        Specification<CnalaTaskMailbox> byRangeDate = TaskMailboxSpecifications
                .byId(BigDecimal.ONE, "1");

        Pageable p = new PageRequest(1, 20);
        
        Iterable<CnalaTaskMailbox> cnalataskmailboxs = cnalataskmailboxrepository
                .findTaskMailboxOperators(byRangeDate,
                                p,
                                new Sort.Order("mboxIdMailbox"));
        assertThat(cnalataskmailboxs).isEmpty();

    }
}
