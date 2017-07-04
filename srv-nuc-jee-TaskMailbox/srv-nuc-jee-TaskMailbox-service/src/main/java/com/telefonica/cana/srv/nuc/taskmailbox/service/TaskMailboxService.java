package com.telefonica.cana.srv.nuc.taskmailbox.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
import com.telefonica.tran.comarq.cc.cabecera.TE_Cabecera;
import com.telefonica.tran.comarq.cc.error.TE_Excepcion;
import com.telefonica.tran.comarq.cc.metadatos.TE_Metadatos;

/**
 * The Service interface for the entities
 */
public interface TaskMailboxService {

    FindFullTaskMailbox_OUT findFullTaskMailbox(@NotNull @Valid FindFullTaskMailbox_IN findfulltaskmailbox_in,
            TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion;

    FindTaskMailbox_OUT findTaskMailbox(@NotNull @Valid FindTaskMailbox_IN findtaskmailbox_in, TE_Cabecera te_Cabecera,
            TE_Metadatos te_Metadatos) throws TE_Excepcion;

    FindTaskMailBoxByResponsible_OUT findTaskMailBoxByResponsible(
            @NotNull @Valid FindTaskMailBoxByResponsible_IN findtaskmailboxbyresponsible_in, TE_Cabecera te_Cabecera,
            TE_Metadatos te_Metadatos) throws TE_Excepcion;

    FindTaskMailboxOperators_OUT findTaskMailboxOperators(
            @NotNull @Valid FindTaskMailboxOperators_IN findtaskmailboxoperators_in, TE_Cabecera te_Cabecera,
            TE_Metadatos te_Metadatos) throws TE_Excepcion;

    FindTasksMailBoxesManager_OUT findTasksMailBoxesManager(
            @NotNull @Valid FindTasksMailBoxesManager_IN findtasksmailboxesmanager_in, TE_Cabecera te_Cabecera,
            TE_Metadatos te_Metadatos) throws TE_Excepcion;

    GetFunctionalTaskMailbox_OUT getFunctionalTaskMailbox(
            @NotNull @Valid GetFunctionalTaskMailbox_IN getfunctionaltaskmailbox_in, TE_Cabecera te_Cabecera,
            TE_Metadatos te_Metadatos) throws TE_Excepcion;

    GetManagerByTaskMailbox_OUT getManagerByTaskMailbox(
            @NotNull @Valid GetManagerByTaskMailbox_IN getmanagerbytaskmailbox_in, TE_Cabecera te_Cabecera,
            TE_Metadatos te_Metadatos) throws TE_Excepcion;

    GetOrganizationTaskMailboxByFunctionalPool_OUT getOrganizationTaskMailboxByFunctionalPool(
            @NotNull @Valid GetOrganizationTaskMailboxByFunctionalPool_IN getorganizationtaskmailboxbyfunctionalpool_in,
            TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion;

    GetTaskMailboxTreeByEnterpriseFunction_OUT getTaskMailboxTreeByEnterpriseFunction(
            @NotNull @Valid GetTaskMailboxTreeByEnterpriseFunction_IN gettaskmailboxtreebyenterprisefunction_in,
            TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion;

    ManageTaskMailbox_OUT manageTaskMailbox(@NotNull @Valid ManageTaskMailbox_IN managetaskmailbox_in,
            TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion;

    ReassignTasksMailbox_OUT reassignTasksMailbox(@NotNull @Valid ReassignTasksMailbox_IN reassigntasksmailbox_in,
            TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion;

}