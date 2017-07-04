package com.telefonica.cana.srv.nuc.taskmailbox.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseSetups;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FindFullTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FindFullTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FindTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FindTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FindTaskMailBoxByResponsible_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FindTaskMailBoxByResponsible_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FindTaskMailboxOperators_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FindTaskMailboxOperators_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.FindTasksMailBoxesManager_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.FindTasksMailBoxesManager_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.GetFunctionalTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.GetFunctionalTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.GetManagerByTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.GetManagerByTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.GetOrganizationTaskMailboxByFunctionalPool_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.GetOrganizationTaskMailboxByFunctionalPool_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.GetTaskMailboxTreeByEnterpriseFunction_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.GetTaskMailboxTreeByEnterpriseFunction_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_OUT;
import com.telefonica.tran.cc.test.integration.AbstractServiceIT;
import com.telefonica.tran.comarq.cc.error.TE_Excepcion;
@Ignore
@DatabaseSetups({ @DatabaseSetup("classpath:data/taskmailbox.csv") })
public class TaskMailboxServiceIT extends AbstractServiceIT {

    @Autowired
    private TaskMailboxService taskMailboxService;

    @Before
    public void setUp() {
    }

    @Test(expected = TE_Excepcion.class)
    public void findFullTaskMailbox() throws TE_Excepcion {

        FindFullTaskMailbox_IN findfulltaskmailbox_in = new FindFullTaskMailbox_IN();

        FindFullTaskMailbox_OUT findfulltaskmailbox_out = taskMailboxService.findFullTaskMailbox(null, null, null);

        assertThat(findfulltaskmailbox_out).isNull();
    }

    @Test(expected = TE_Excepcion.class)
    public void findTaskMailbox() throws TE_Excepcion {

        FindTaskMailbox_IN findtaskmailbox_in = new FindTaskMailbox_IN();

        FindTaskMailbox_OUT findtaskmailbox_out = taskMailboxService.findTaskMailbox(null, null, null);

        assertThat(findtaskmailbox_out).isNull();
    }

    @Test(expected = TE_Excepcion.class)
    public void findTaskMailBoxByResponsible() throws TE_Excepcion {

        FindTaskMailBoxByResponsible_IN findtaskmailboxbyresponsible_in = new FindTaskMailBoxByResponsible_IN();

        FindTaskMailBoxByResponsible_OUT findtaskmailboxbyresponsible_out = taskMailboxService
                .findTaskMailBoxByResponsible(null, null, null);

        assertThat(findtaskmailboxbyresponsible_out).isNull();
    }

    @Test(expected = TE_Excepcion.class)
    public void findTaskMailboxOperators() throws TE_Excepcion {

        FindTaskMailboxOperators_IN findtaskmailboxoperators_in = new FindTaskMailboxOperators_IN();

        FindTaskMailboxOperators_OUT findtaskmailboxoperators_out = taskMailboxService.findTaskMailboxOperators(null,
                null, null);

        assertThat(findtaskmailboxoperators_out).isNull();
    }

    @Test(expected = TE_Excepcion.class)
    public void findTasksMailBoxesManager() throws TE_Excepcion {

        FindTasksMailBoxesManager_IN findtasksmailboxesmanager_in = new FindTasksMailBoxesManager_IN();

        FindTasksMailBoxesManager_OUT findtasksmailboxesmanager_out = taskMailboxService.findTasksMailBoxesManager(
                null, null, null);

        assertThat(findtasksmailboxesmanager_out).isNull();
    }

    @Test(expected = TE_Excepcion.class)
    public void getFunctionalTaskMailbox() throws TE_Excepcion {

        GetFunctionalTaskMailbox_IN getfunctionaltaskmailbox_in = new GetFunctionalTaskMailbox_IN();

        GetFunctionalTaskMailbox_OUT getfunctionaltaskmailbox_out = taskMailboxService.getFunctionalTaskMailbox(null,
                null, null);

        assertThat(getfunctionaltaskmailbox_out).isNull();
    }

    @Test(expected = TE_Excepcion.class)
    public void getManagerByTaskMailbox() throws TE_Excepcion {

        GetManagerByTaskMailbox_IN getmanagerbytaskmailbox_in = new GetManagerByTaskMailbox_IN();

        GetManagerByTaskMailbox_OUT getmanagerbytaskmailbox_out = taskMailboxService.getManagerByTaskMailbox(null,
                null, null);

        assertThat(getmanagerbytaskmailbox_out).isNull();
    }

    @Test(expected = TE_Excepcion.class)
    public void getOrganizationTaskMailboxByFunctionalPool() throws TE_Excepcion {

        GetOrganizationTaskMailboxByFunctionalPool_IN getorganizationtaskmailboxbyfunctionalpool_in = new GetOrganizationTaskMailboxByFunctionalPool_IN();

        GetOrganizationTaskMailboxByFunctionalPool_OUT getorganizationtaskmailboxbyfunctionalpool_out = taskMailboxService
                .getOrganizationTaskMailboxByFunctionalPool(null, null, null);

        assertThat(getorganizationtaskmailboxbyfunctionalpool_out).isNull();
    }

    @Test(expected = TE_Excepcion.class)
    public void getTaskMailboxTreeByEnterpriseFunction() throws TE_Excepcion {

        GetTaskMailboxTreeByEnterpriseFunction_IN gettaskmailboxtreebyenterprisefunction_in = new GetTaskMailboxTreeByEnterpriseFunction_IN();

        GetTaskMailboxTreeByEnterpriseFunction_OUT gettaskmailboxtreebyenterprisefunction_out = taskMailboxService
                .getTaskMailboxTreeByEnterpriseFunction(null, null, null);

        assertThat(gettaskmailboxtreebyenterprisefunction_out).isNull();
    }

    @Test(expected = TE_Excepcion.class)
    public void manageTaskMailbox() throws TE_Excepcion {

        ManageTaskMailbox_IN managetaskmailbox_in = new ManageTaskMailbox_IN();

        ManageTaskMailbox_OUT managetaskmailbox_out = taskMailboxService.manageTaskMailbox(null, null, null);

        assertThat(managetaskmailbox_out).isNull();
    }

    @Test(expected = TE_Excepcion.class)
    public void reassignTasksMailbox() throws TE_Excepcion {

        ReassignTasksMailbox_IN reassigntasksmailbox_in = new ReassignTasksMailbox_IN();

        ReassignTasksMailbox_OUT reassigntasksmailbox_out = taskMailboxService.reassignTasksMailbox(null, null, null);

        assertThat(reassigntasksmailbox_out).isNull();
    }

}