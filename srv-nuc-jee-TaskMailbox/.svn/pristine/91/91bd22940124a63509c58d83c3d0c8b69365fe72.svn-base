package com.telefonica.cana.srv.nuc.taskmailbox.facade;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;

import javax.naming.NamingException;
import javax.xml.ws.Holder;

import org.junit.Before;
import org.junit.Test;

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
import com.telefonica.tran.cc.test.integration.AbstractFacadeIT;
import com.telefonica.tran.comarq.cc.cabecera.TE_Cabecera;
import com.telefonica.tran.comarq.cc.error.TE_Excepcion;
import com.telefonica.tran.comarq.cc.metadatos.TE_Metadatos;

public class TaskMailboxServiceFacadeIT extends AbstractFacadeIT {

    private static final String WSDL = "http://127.0.0.1:4204/srv-nuc-jee-TaskMailbox-facade/TaskMailboxServiceFacadeImpl?wsdl";
    private static final String NAMESPACE = "http://telefonica.com/cana/srv-nuc-TaskMailbox-v3";
    private static final String SERVICE_NAME = "srv-nuc-TaskMailbox-v3";

    public TaskMailboxServiceFacadeIT() {
        super(WSDL, NAMESPACE, SERVICE_NAME);
    }

    private TaskMailboxServiceFacade taskMailboxServiceFacade;

    private TE_Metadatos metadata = new TE_Metadatos();
    private TE_Cabecera header = new TE_Cabecera();

    @Before
    public void setUp() throws NamingException, MalformedURLException {
        taskMailboxServiceFacade = lockUpWsFacade(TaskMailboxServiceFacade.class);
    }

    @Test(expected = TE_Excepcion.class)
    public void findFullTaskMailbox() throws TE_Excepcion {

        FindFullTaskMailbox_IN findfulltaskmailbox_in = new FindFullTaskMailbox_IN();

        FindFullTaskMailbox_OUT response = taskMailboxServiceFacade.findFullTaskMailbox(findfulltaskmailbox_in,
                new Holder<TE_Cabecera>(header), new Holder<TE_Metadatos>(metadata));
        assertThat(response).isNotNull();

    }

    @Test(expected = TE_Excepcion.class)
    public void findTaskMailbox() throws TE_Excepcion {

        FindTaskMailbox_IN findtaskmailbox_in = new FindTaskMailbox_IN();

        FindTaskMailbox_OUT response = taskMailboxServiceFacade.findTaskMailbox(findtaskmailbox_in,
                new Holder<TE_Cabecera>(header), new Holder<TE_Metadatos>(metadata));
        assertThat(response).isNotNull();

    }

    @Test(expected = TE_Excepcion.class)
    public void findTaskMailBoxByResponsible() throws TE_Excepcion {

        FindTaskMailBoxByResponsible_IN findtaskmailboxbyresponsible_in = new FindTaskMailBoxByResponsible_IN();

        FindTaskMailBoxByResponsible_OUT response = taskMailboxServiceFacade.findTaskMailBoxByResponsible(
                findtaskmailboxbyresponsible_in, new Holder<TE_Cabecera>(header), new Holder<TE_Metadatos>(metadata));
        assertThat(response).isNotNull();

    }

    @Test(expected = TE_Excepcion.class)
    public void findTaskMailboxOperators() throws TE_Excepcion {

        FindTaskMailboxOperators_IN findtaskmailboxoperators_in = new FindTaskMailboxOperators_IN();

        FindTaskMailboxOperators_OUT response = taskMailboxServiceFacade.findTaskMailboxOperators(
                findtaskmailboxoperators_in, new Holder<TE_Cabecera>(header), new Holder<TE_Metadatos>(metadata));
        assertThat(response).isNotNull();

    }

    @Test(expected = TE_Excepcion.class)
    public void findTasksMailBoxesManager() throws TE_Excepcion {

        FindTasksMailBoxesManager_IN findtasksmailboxesmanager_in = new FindTasksMailBoxesManager_IN();

        FindTasksMailBoxesManager_OUT response = taskMailboxServiceFacade.findTasksMailBoxesManager(
                findtasksmailboxesmanager_in, new Holder<TE_Cabecera>(header), new Holder<TE_Metadatos>(metadata));
        assertThat(response).isNotNull();

    }

    @Test(expected = TE_Excepcion.class)
    public void getFunctionalTaskMailbox() throws TE_Excepcion {

        GetFunctionalTaskMailbox_IN getfunctionaltaskmailbox_in = new GetFunctionalTaskMailbox_IN();

        GetFunctionalTaskMailbox_OUT response = taskMailboxServiceFacade.getFunctionalTaskMailbox(
                getfunctionaltaskmailbox_in, new Holder<TE_Cabecera>(header), new Holder<TE_Metadatos>(metadata));
        assertThat(response).isNotNull();

    }

    @Test(expected = TE_Excepcion.class)
    public void getManagerByTaskMailbox() throws TE_Excepcion {

        GetManagerByTaskMailbox_IN getmanagerbytaskmailbox_in = new GetManagerByTaskMailbox_IN();

        GetManagerByTaskMailbox_OUT response = taskMailboxServiceFacade.getManagerByTaskMailbox(
                getmanagerbytaskmailbox_in, new Holder<TE_Cabecera>(header), new Holder<TE_Metadatos>(metadata));
        assertThat(response).isNotNull();

    }

    @Test(expected = TE_Excepcion.class)
    public void getOrganizationTaskMailboxByFunctionalPool() throws TE_Excepcion {

        GetOrganizationTaskMailboxByFunctionalPool_IN getorganizationtaskmailboxbyfunctionalpool_in = new GetOrganizationTaskMailboxByFunctionalPool_IN();

        GetOrganizationTaskMailboxByFunctionalPool_OUT response = taskMailboxServiceFacade
                .getOrganizationTaskMailboxByFunctionalPool(getorganizationtaskmailboxbyfunctionalpool_in,
                        new Holder<TE_Cabecera>(header), new Holder<TE_Metadatos>(metadata));
        assertThat(response).isNotNull();

    }

    @Test(expected = TE_Excepcion.class)
    public void getTaskMailboxTreeByEnterpriseFunction() throws TE_Excepcion {

        GetTaskMailboxTreeByEnterpriseFunction_IN gettaskmailboxtreebyenterprisefunction_in = new GetTaskMailboxTreeByEnterpriseFunction_IN();

        GetTaskMailboxTreeByEnterpriseFunction_OUT response = taskMailboxServiceFacade
                .getTaskMailboxTreeByEnterpriseFunction(gettaskmailboxtreebyenterprisefunction_in,
                        new Holder<TE_Cabecera>(header), new Holder<TE_Metadatos>(metadata));
        assertThat(response).isNotNull();

    }

    @Test(expected = TE_Excepcion.class)
    public void manageTaskMailbox() throws TE_Excepcion {

        ManageTaskMailbox_IN managetaskmailbox_in = new ManageTaskMailbox_IN();

        ManageTaskMailbox_OUT response = taskMailboxServiceFacade.manageTaskMailbox(managetaskmailbox_in,
                new Holder<TE_Cabecera>(header), new Holder<TE_Metadatos>(metadata));
        assertThat(response).isNotNull();

    }

    @Test(expected = TE_Excepcion.class)
    public void reassignTasksMailbox() throws TE_Excepcion {

        ReassignTasksMailbox_IN reassigntasksmailbox_in = new ReassignTasksMailbox_IN();

        ReassignTasksMailbox_OUT response = taskMailboxServiceFacade.reassignTasksMailbox(reassigntasksmailbox_in,
                new Holder<TE_Cabecera>(header), new Holder<TE_Metadatos>(metadata));
        assertThat(response).isNotNull();

    }

}