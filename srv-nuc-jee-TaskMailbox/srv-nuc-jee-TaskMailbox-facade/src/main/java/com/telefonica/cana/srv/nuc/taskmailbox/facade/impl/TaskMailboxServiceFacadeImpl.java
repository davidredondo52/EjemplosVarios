package com.telefonica.cana.srv.nuc.taskmailbox.facade.impl;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.jws.WebService;
import javax.xml.ws.Holder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import com.telefonica.cana.srv.nuc.taskmailbox.facade.TaskMailboxServiceFacade;
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
import com.telefonica.tran.comarq.ccp.lib.cabecera.interceptors.HeaderPersistInterceptor;
@Startup
@WebService(targetNamespace = "http://telefonica.com/cana/srv-nuc-TaskMailbox-v3", name = "srv-nuc-TaskMailbox-v3", endpointInterface = "com.telefonica.cana.srv.nuc.taskmailbox.facade.TaskMailboxServiceFacade", portName = "srv-nuc-TaskMailbox_Port", serviceName = "srv-nuc-TaskMailbox-v3")
@Singleton(mappedName = "ejb/cana/srv-nuc-TaskMailbox-v3")
@Interceptors({ SpringBeanAutowiringInterceptor.class, HeaderPersistInterceptor.class })
@TransactionManagement(value = TransactionManagementType.BEAN)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class TaskMailboxServiceFacadeImpl implements TaskMailboxServiceFacade {

    @Autowired
    private TaskMailboxService taskMailboxService;

    @Override
    public FindFullTaskMailbox_OUT findFullTaskMailbox(FindFullTaskMailbox_IN request, Holder<TE_Cabecera> teHeader,
            Holder<TE_Metadatos> teMetadata) throws TE_Excepcion {

        TE_Metadatos metadata = teMetadata != null ? teMetadata.value : null;
        return taskMailboxService.findFullTaskMailbox(request, teHeader.value, metadata);
    }

    @Override
    public FindTaskMailbox_OUT findTaskMailbox(FindTaskMailbox_IN request, Holder<TE_Cabecera> teHeader,
            Holder<TE_Metadatos> teMetadata) throws TE_Excepcion {

        TE_Metadatos metadata = teMetadata != null ? teMetadata.value : null;
        return taskMailboxService.findTaskMailbox(request, teHeader.value, metadata);
    }

    @Override
    public FindTaskMailBoxByResponsible_OUT findTaskMailBoxByResponsible(FindTaskMailBoxByResponsible_IN request,
            Holder<TE_Cabecera> teHeader, Holder<TE_Metadatos> teMetadata) throws TE_Excepcion {

        TE_Metadatos metadata = teMetadata != null ? teMetadata.value : null;
        return taskMailboxService.findTaskMailBoxByResponsible(request, teHeader.value, metadata);
    }

    @Override
    public FindTaskMailboxOperators_OUT findTaskMailboxOperators(FindTaskMailboxOperators_IN request,
            Holder<TE_Cabecera> teHeader, Holder<TE_Metadatos> teMetadata) throws TE_Excepcion {

        TE_Metadatos metadata = teMetadata != null ? teMetadata.value : null;
        return taskMailboxService.findTaskMailboxOperators(request, teHeader.value, metadata);
    }

    @Override
    public FindTasksMailBoxesManager_OUT findTasksMailBoxesManager(FindTasksMailBoxesManager_IN request,
            Holder<TE_Cabecera> teHeader, Holder<TE_Metadatos> teMetadata) throws TE_Excepcion {

        TE_Metadatos metadata = teMetadata != null ? teMetadata.value : null;
        return taskMailboxService.findTasksMailBoxesManager(request, teHeader.value, metadata);
    }

    @Override
    public GetFunctionalTaskMailbox_OUT getFunctionalTaskMailbox(GetFunctionalTaskMailbox_IN request,
            Holder<TE_Cabecera> teHeader, Holder<TE_Metadatos> teMetadata) throws TE_Excepcion {

        TE_Metadatos metadata = teMetadata != null ? teMetadata.value : null;
        return taskMailboxService.getFunctionalTaskMailbox(request, teHeader.value, metadata);
    }

    @Override
    public GetManagerByTaskMailbox_OUT getManagerByTaskMailbox(GetManagerByTaskMailbox_IN request,
            Holder<TE_Cabecera> teHeader, Holder<TE_Metadatos> teMetadata) throws TE_Excepcion {

        TE_Metadatos metadata = teMetadata != null ? teMetadata.value : null;
        return taskMailboxService.getManagerByTaskMailbox(request, teHeader.value, metadata);
    }

    @Override
    public GetOrganizationTaskMailboxByFunctionalPool_OUT getOrganizationTaskMailboxByFunctionalPool(
            GetOrganizationTaskMailboxByFunctionalPool_IN request, Holder<TE_Cabecera> teHeader,
            Holder<TE_Metadatos> teMetadata) throws TE_Excepcion {

        TE_Metadatos metadata = teMetadata != null ? teMetadata.value : null;
        return taskMailboxService.getOrganizationTaskMailboxByFunctionalPool(request, teHeader.value, metadata);
    }

    @Override
    public GetTaskMailboxTreeByEnterpriseFunction_OUT getTaskMailboxTreeByEnterpriseFunction(
            GetTaskMailboxTreeByEnterpriseFunction_IN request, Holder<TE_Cabecera> teHeader,
            Holder<TE_Metadatos> teMetadata) throws TE_Excepcion {

        TE_Metadatos metadata = teMetadata != null ? teMetadata.value : null;
        return taskMailboxService.getTaskMailboxTreeByEnterpriseFunction(request, teHeader.value, metadata);
    }

    @Override
    public ManageTaskMailbox_OUT manageTaskMailbox(ManageTaskMailbox_IN request, Holder<TE_Cabecera> teHeader,
            Holder<TE_Metadatos> teMetadata) throws TE_Excepcion {

        TE_Metadatos metadata = teMetadata != null ? teMetadata.value : null;
        return taskMailboxService.manageTaskMailbox(request, teHeader.value, metadata);
    }

    @Override
    public ReassignTasksMailbox_OUT reassignTasksMailbox(ReassignTasksMailbox_IN request, Holder<TE_Cabecera> teHeader,
            Holder<TE_Metadatos> teMetadata) throws TE_Excepcion {

        TE_Metadatos metadata = teMetadata != null ? teMetadata.value : null;
        return taskMailboxService.reassignTasksMailbox(request, teHeader.value, metadata);
    }

}