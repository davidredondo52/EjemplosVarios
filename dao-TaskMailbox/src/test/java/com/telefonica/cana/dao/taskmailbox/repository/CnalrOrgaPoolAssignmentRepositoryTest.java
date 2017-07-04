package com.telefonica.cana.dao.taskmailbox.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.telefonica.cana.dao.taskmailbox.dto.OrganizationPoolAssignmentDTO;
import com.telefonica.cana.model.CnalrOrgaPoolAssignment;

@Transactional
@ContextConfiguration(locations = { "classpath:META-INF/spring/dao-test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CnalrOrgaPoolAssignmentRepositoryTest {

    @Autowired
    private CnalrOrgaPoolAssignmentRepository cnalrorgapoolassignmentrepository;

    @Test
    public void findOrgTaskMailboxByFunctionalPool_IdsTest() {
        List idss = new ArrayList<BigDecimal>();
        BigDecimal ids = new BigDecimal("0");
        idss.add(ids);

        Iterable<OrganizationPoolAssignmentDTO> organizationpoolassignmentdtos = cnalrorgapoolassignmentrepository
                .findOrgTaskMailboxByFunctionalPool(idss);
        assertThat(organizationpoolassignmentdtos).isEmpty();
    }
    
    @Test
    public void findAllSpecificatio(){
		List<Long> lista2 = new ArrayList<Long>();
		lista2.add(new Long(1));
		lista2.add(new Long(2));	
		
    	Specifications<CnalrOrgaPoolAssignment> lista = 
    	    Specifications.where(OrganizationPoolAssignmentSpecification.byOrganizationName("Canales"))
    	        .and(OrganizationPoolAssignmentSpecification.byOrganizationRole(BigDecimal.ZERO))
    	        .and(OrganizationPoolAssignmentSpecification.byOrganizationDescription("Canales", false, new BigDecimal(0)))
    	        .and(OrganizationPoolAssignmentSpecification.byOrganizationDescription("Canales", true, new BigDecimal(1)))
                .and(OrganizationPoolAssignmentSpecification.byEnteFunctionTreeNode(new Long(0)))
                .and(OrganizationPoolAssignmentSpecification.byEnteFunctionTreeNodeListIds(lista2))
                .and(OrganizationPoolAssignmentSpecification.byFunctionalPool(new BigDecimal(0)))
                .and(OrganizationPoolAssignmentSpecification.byTaskMailbox(new BigDecimal(0)))
                .and(OrganizationPoolAssignmentSpecification.byOrganizationPoolAssignment(BigDecimal.ZERO))
                .and(OrganizationPoolAssignmentSpecification.byOrganizationPoolAssignment(new BigDecimal(0)))
                .and(OrganizationPoolAssignmentSpecification.byProductCatalog(new BigDecimal(0)));

        List<CnalrOrgaPoolAssignment> listaCnalr = cnalrorgapoolassignmentrepository.findAll(lista);
        
     //   assertThat(listaCnalr).isEmpty();
    }

}
