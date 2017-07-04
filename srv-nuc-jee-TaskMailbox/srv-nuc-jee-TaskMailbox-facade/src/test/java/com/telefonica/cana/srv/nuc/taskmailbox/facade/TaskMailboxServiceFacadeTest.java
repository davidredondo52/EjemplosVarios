package com.telefonica.cana.srv.nuc.taskmailbox.facade;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import javax.xml.ws.Holder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.telefonica.cana.srv.nuc.taskmailbox.facade.impl.TaskMailboxServiceFacadeImpl;
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
import com.telefonica.cana.srv.nuc.taskmailbox.service.TaskMailboxService;
import com.telefonica.tran.comarq.cc.cabecera.TE_Cabecera;
import com.telefonica.tran.comarq.cc.error.TE_Excepcion;
import com.telefonica.tran.comarq.cc.metadatos.TE_Metadatos;

@RunWith(MockitoJUnitRunner.class)
public class TaskMailboxServiceFacadeTest {

    @InjectMocks
    private TaskMailboxServiceFacadeImpl taskMailboxServiceFacade;

    @Mock
    private TaskMailboxService taskMailboxService;

    @Test
    public void findFullTaskMailbox() throws TE_Excepcion {

        when(taskMailboxService.findFullTaskMailbox(null, null, null)).thenReturn(null);

        FindFullTaskMailbox_OUT response = taskMailboxServiceFacade.findFullTaskMailbox(new FindFullTaskMailbox_IN(),
                new Holder<TE_Cabecera>(null), new Holder<TE_Metadatos>(null));

        assertThat(response).isNull();

        FindFullTaskMailbox_OUT response2 = taskMailboxServiceFacade.findFullTaskMailbox(new FindFullTaskMailbox_IN(),
                new Holder<TE_Cabecera>(null), null);

        assertThat(response2).isNull();
    }

    @Test
    public void findTaskMailbox() throws TE_Excepcion {

        when(taskMailboxService.findTaskMailbox(null, null, null)).thenReturn(null);

        FindTaskMailbox_OUT response = taskMailboxServiceFacade.findTaskMailbox(new FindTaskMailbox_IN(),
                new Holder<TE_Cabecera>(null), new Holder<TE_Metadatos>(null));

        assertThat(response).isNull();

        FindTaskMailbox_OUT response2 = taskMailboxServiceFacade.findTaskMailbox(new FindTaskMailbox_IN(),
                new Holder<TE_Cabecera>(null), null);

        assertThat(response2).isNull();
    }

    @Test
    public void findTaskMailBoxByResponsible() throws TE_Excepcion {

        when(taskMailboxService.findTaskMailBoxByResponsible(null, null, null)).thenReturn(null);

        FindTaskMailBoxByResponsible_OUT response = taskMailboxServiceFacade.findTaskMailBoxByResponsible(
                new FindTaskMailBoxByResponsible_IN(), new Holder<TE_Cabecera>(null), new Holder<TE_Metadatos>(null));

        assertThat(response).isNull();

        FindTaskMailBoxByResponsible_OUT response2 = taskMailboxServiceFacade.findTaskMailBoxByResponsible(
                new FindTaskMailBoxByResponsible_IN(), new Holder<TE_Cabecera>(null), null);

        assertThat(response2).isNull();
    }

    @Test
    public void findTaskMailboxOperators() throws TE_Excepcion {

        when(taskMailboxService.findTaskMailboxOperators(null, null, null)).thenReturn(null);

        FindTaskMailboxOperators_OUT response = taskMailboxServiceFacade.findTaskMailboxOperators(
                new FindTaskMailboxOperators_IN(), new Holder<TE_Cabecera>(null), new Holder<TE_Metadatos>(null));

        assertThat(response).isNull();

        FindTaskMailboxOperators_OUT response2 = taskMailboxServiceFacade.findTaskMailboxOperators(
                new FindTaskMailboxOperators_IN(), new Holder<TE_Cabecera>(null), null);

        assertThat(response2).isNull();
    }

    @Test
    public void findTasksMailBoxesManager() throws TE_Excepcion {

        when(taskMailboxService.findTasksMailBoxesManager(null, null, null)).thenReturn(null);

        FindTasksMailBoxesManager_OUT response = taskMailboxServiceFacade.findTasksMailBoxesManager(
                new FindTasksMailBoxesManager_IN(), new Holder<TE_Cabecera>(null), new Holder<TE_Metadatos>(null));

        assertThat(response).isNull();

        FindTasksMailBoxesManager_OUT response2 = taskMailboxServiceFacade.findTasksMailBoxesManager(
                new FindTasksMailBoxesManager_IN(), new Holder<TE_Cabecera>(null), null);

        assertThat(response2).isNull();
    }

    @Test
    public void getFunctionalTaskMailbox() throws TE_Excepcion {

        when(taskMailboxService.getFunctionalTaskMailbox(null, null, null)).thenReturn(null);

        GetFunctionalTaskMailbox_OUT response = taskMailboxServiceFacade.getFunctionalTaskMailbox(
                new GetFunctionalTaskMailbox_IN(), new Holder<TE_Cabecera>(null), new Holder<TE_Metadatos>(null));

        assertThat(response).isNull();

        GetFunctionalTaskMailbox_OUT response2 = taskMailboxServiceFacade.getFunctionalTaskMailbox(
                new GetFunctionalTaskMailbox_IN(), new Holder<TE_Cabecera>(null), null);

        assertThat(response2).isNull();
    }

    @Test
    public void getManagerByTaskMailbox() throws TE_Excepcion {

        when(taskMailboxService.getManagerByTaskMailbox(null, null, null)).thenReturn(null);

        GetManagerByTaskMailbox_OUT response = taskMailboxServiceFacade.getManagerByTaskMailbox(
                new GetManagerByTaskMailbox_IN(), new Holder<TE_Cabecera>(null), new Holder<TE_Metadatos>(null));

        assertThat(response).isNull();

        GetManagerByTaskMailbox_OUT response2 = taskMailboxServiceFacade.getManagerByTaskMailbox(
                new GetManagerByTaskMailbox_IN(), new Holder<TE_Cabecera>(null), null);

        assertThat(response2).isNull();
    }

    @Test
    public void getOrganizationTaskMailboxByFunctionalPool() throws TE_Excepcion {

        when(taskMailboxService.getOrganizationTaskMailboxByFunctionalPool(null, null, null)).thenReturn(null);

        GetOrganizationTaskMailboxByFunctionalPool_OUT response = taskMailboxServiceFacade
                .getOrganizationTaskMailboxByFunctionalPool(new GetOrganizationTaskMailboxByFunctionalPool_IN(),
                        new Holder<TE_Cabecera>(null), new Holder<TE_Metadatos>(null));

        assertThat(response).isNull();

        GetOrganizationTaskMailboxByFunctionalPool_OUT response2 = taskMailboxServiceFacade
                .getOrganizationTaskMailboxByFunctionalPool(new GetOrganizationTaskMailboxByFunctionalPool_IN(),
                        new Holder<TE_Cabecera>(null), null);

        assertThat(response2).isNull();
    }

    @Test
    public void getTaskMailboxTreeByEnterpriseFunction() throws TE_Excepcion {

        when(taskMailboxService.getTaskMailboxTreeByEnterpriseFunction(null, null, null)).thenReturn(null);

        GetTaskMailboxTreeByEnterpriseFunction_OUT response = taskMailboxServiceFacade
                .getTaskMailboxTreeByEnterpriseFunction(new GetTaskMailboxTreeByEnterpriseFunction_IN(),
                        new Holder<TE_Cabecera>(null), new Holder<TE_Metadatos>(null));

        assertThat(response).isNull();

        GetTaskMailboxTreeByEnterpriseFunction_OUT response2 = taskMailboxServiceFacade
                .getTaskMailboxTreeByEnterpriseFunction(new GetTaskMailboxTreeByEnterpriseFunction_IN(),
                        new Holder<TE_Cabecera>(null), null);

        assertThat(response2).isNull();
    }

    @Test
    public void manageTaskMailbox() throws TE_Excepcion {

        when(taskMailboxService.manageTaskMailbox(null, null, null)).thenReturn(null);

        ManageTaskMailbox_OUT response = taskMailboxServiceFacade.manageTaskMailbox(new ManageTaskMailbox_IN(),
                new Holder<TE_Cabecera>(null), new Holder<TE_Metadatos>(null));

        assertThat(response).isNull();

        ManageTaskMailbox_OUT response2 = taskMailboxServiceFacade.manageTaskMailbox(new ManageTaskMailbox_IN(),
                new Holder<TE_Cabecera>(null), null);

        assertThat(response2).isNull();
    }

    @Test
    public void reassignTasksMailbox() throws TE_Excepcion {

        when(taskMailboxService.reassignTasksMailbox(null, null, null)).thenReturn(null);

        ReassignTasksMailbox_OUT response = taskMailboxServiceFacade.reassignTasksMailbox(
                new ReassignTasksMailbox_IN(), new Holder<TE_Cabecera>(null), new Holder<TE_Metadatos>(null));

        assertThat(response).isNull();

        ReassignTasksMailbox_OUT response2 = taskMailboxServiceFacade.reassignTasksMailbox(
                new ReassignTasksMailbox_IN(), new Holder<TE_Cabecera>(null), null);

        assertThat(response2).isNull();
    }

}