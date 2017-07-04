package com.telefonica.cana.srv.nuc.taskmailbox.facade;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Holder;

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

@WebService(name = "srv-nuc-TaskMailbox_ServiceFacade", targetNamespace = "http://telefonica.com/cana/srv-nuc-TaskMailbox-v3")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({ com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.ObjectFactory.class,
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.ObjectFactory.class,
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.ObjectFactory.class,
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.ObjectFactory.class,
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.ObjectFactory.class,
        com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.ObjectFactory.class,
        com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.ObjectFactory.class,
        com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.ObjectFactory.class,
        com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.ObjectFactory.class,
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ObjectFactory.class,
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ObjectFactory.class,
        com.telefonica.tran.comarq.cc.cabecera.ObjectFactory.class,
        com.telefonica.tran.comarq.cc.error.fault.ObjectFactory.class,
        com.telefonica.tran.comarq.cc.metadatos.ObjectFactory.class })
public interface TaskMailboxServiceFacade {

    /**
     * 
     * @param request
     * @param teHeader
     * @param teMetadata
     * @return
     *     returns com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FindFullTaskMailbox_OUT
     * @throws TE_Excepcion
     */
    @WebMethod(action = "findFullTaskMailbox")
    @WebResult(name = "FindFullTaskMailbox_OUT", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/findFullTaskMailbox-v3", partName = "response")
    FindFullTaskMailbox_OUT findFullTaskMailbox(
            @WebParam(name = "FindFullTaskMailbox_IN", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/findFullTaskMailbox-v3", partName = "request") FindFullTaskMailbox_IN request,
            @WebParam(name = "TE_Cabecera", targetNamespace = "http://telefonica.com/tran/comarq/cc/cabecera", header = true, mode = WebParam.Mode.INOUT, partName = "te_header") Holder<TE_Cabecera> teHeader,
            @WebParam(name = "TE_Metadatos", targetNamespace = "http://telefonica.com/tran/comarq/cc/metadatos-2.0", header = true, mode = WebParam.Mode.INOUT, partName = "te_metadata") Holder<TE_Metadatos> teMetadata)
            throws TE_Excepcion;

    /**
     * 
     * @param request
     * @param teHeader
     * @param teMetadata
     * @return
     *     returns com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FindTaskMailbox_OUT
     * @throws TE_Excepcion
     */
    @WebMethod(action = "findTaskMailbox")
    @WebResult(name = "FindTaskMailbox_OUT", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailbox-v3", partName = "response")
    FindTaskMailbox_OUT findTaskMailbox(
            @WebParam(name = "FindTaskMailbox_IN", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailbox-v3", partName = "request") FindTaskMailbox_IN request,
            @WebParam(name = "TE_Cabecera", targetNamespace = "http://telefonica.com/tran/comarq/cc/cabecera", header = true, mode = WebParam.Mode.INOUT, partName = "te_header") Holder<TE_Cabecera> teHeader,
            @WebParam(name = "TE_Metadatos", targetNamespace = "http://telefonica.com/tran/comarq/cc/metadatos-2.0", header = true, mode = WebParam.Mode.INOUT, partName = "te_metadata") Holder<TE_Metadatos> teMetadata)
            throws TE_Excepcion;

    /**
     * 
     * @param request
     * @param teHeader
     * @param teMetadata
     * @return
     *     returns com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FindTaskMailBoxByResponsible_OUT
     * @throws TE_Excepcion
     */
    @WebMethod(action = "findTaskMailBoxByResponsible")
    @WebResult(name = "FindTaskMailBoxByResponsible_OUT", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailBoxByResponsible-v3", partName = "response")
    FindTaskMailBoxByResponsible_OUT findTaskMailBoxByResponsible(
            @WebParam(name = "FindTaskMailBoxByResponsible_IN", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailBoxByResponsible-v3", partName = "request") FindTaskMailBoxByResponsible_IN request,
            @WebParam(name = "TE_Cabecera", targetNamespace = "http://telefonica.com/tran/comarq/cc/cabecera", header = true, mode = WebParam.Mode.INOUT, partName = "te_header") Holder<TE_Cabecera> teHeader,
            @WebParam(name = "TE_Metadatos", targetNamespace = "http://telefonica.com/tran/comarq/cc/metadatos-2.0", header = true, mode = WebParam.Mode.INOUT, partName = "te_metadata") Holder<TE_Metadatos> teMetadata)
            throws TE_Excepcion;

    /**
     * 
     * @param request
     * @param teHeader
     * @param teMetadata
     * @return
     *     returns com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FindTaskMailboxOperators_OUT
     * @throws TE_Excepcion
     */
    @WebMethod(action = "findTaskMailboxOperators")
    @WebResult(name = "FindTaskMailboxOperators_OUT", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailboxOperators-v3", partName = "response")
    FindTaskMailboxOperators_OUT findTaskMailboxOperators(
            @WebParam(name = "FindTaskMailboxOperators_IN", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailboxOperators-v3", partName = "request") FindTaskMailboxOperators_IN request,
            @WebParam(name = "TE_Cabecera", targetNamespace = "http://telefonica.com/tran/comarq/cc/cabecera", header = true, mode = WebParam.Mode.INOUT, partName = "te_header") Holder<TE_Cabecera> teHeader,
            @WebParam(name = "TE_Metadatos", targetNamespace = "http://telefonica.com/tran/comarq/cc/metadatos-2.0", header = true, mode = WebParam.Mode.INOUT, partName = "te_metadata") Holder<TE_Metadatos> teMetadata)
            throws TE_Excepcion;

    /**
     * 
     * @param request
     * @param teHeader
     * @param teMetadata
     * @return
     *     returns com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.FindTasksMailBoxesManager_OUT
     * @throws TE_Excepcion
     */
    @WebMethod(action = "findTasksMailBoxesManager")
    @WebResult(name = "FindTasksMailBoxesManager_OUT", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/findTasksMailBoxesManager-v3", partName = "response")
    FindTasksMailBoxesManager_OUT findTasksMailBoxesManager(
            @WebParam(name = "FindTasksMailBoxesManager_IN", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/findTasksMailBoxesManager-v3", partName = "request") FindTasksMailBoxesManager_IN request,
            @WebParam(name = "TE_Cabecera", targetNamespace = "http://telefonica.com/tran/comarq/cc/cabecera", header = true, mode = WebParam.Mode.INOUT, partName = "te_header") Holder<TE_Cabecera> teHeader,
            @WebParam(name = "TE_Metadatos", targetNamespace = "http://telefonica.com/tran/comarq/cc/metadatos-2.0", header = true, mode = WebParam.Mode.INOUT, partName = "te_metadata") Holder<TE_Metadatos> teMetadata)
            throws TE_Excepcion;

    /**
     * 
     * @param request
     * @param teHeader
     * @param teMetadata
     * @return
     *     returns com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.GetFunctionalTaskMailbox_OUT
     * @throws TE_Excepcion
     */
    @WebMethod(action = "getFunctionalTaskMailbox")
    @WebResult(name = "GetFunctionalTaskMailbox_OUT", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/getFunctionalTaskMailbox-v3", partName = "response")
    GetFunctionalTaskMailbox_OUT getFunctionalTaskMailbox(
            @WebParam(name = "GetFunctionalTaskMailbox_IN", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/getFunctionalTaskMailbox-v3", partName = "request") GetFunctionalTaskMailbox_IN request,
            @WebParam(name = "TE_Cabecera", targetNamespace = "http://telefonica.com/tran/comarq/cc/cabecera", header = true, mode = WebParam.Mode.INOUT, partName = "te_header") Holder<TE_Cabecera> teHeader,
            @WebParam(name = "TE_Metadatos", targetNamespace = "http://telefonica.com/tran/comarq/cc/metadatos-2.0", header = true, mode = WebParam.Mode.INOUT, partName = "te_metadata") Holder<TE_Metadatos> teMetadata)
            throws TE_Excepcion;

    /**
     * 
     * @param request
     * @param teHeader
     * @param teMetadata
     * @return
     *     returns com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.GetManagerByTaskMailbox_OUT
     * @throws TE_Excepcion
     */
    @WebMethod(action = "getManagerByTaskMailbox")
    @WebResult(name = "GetManagerByTaskMailbox_OUT", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/getManagerByTaskMailbox-v3", partName = "response")
    GetManagerByTaskMailbox_OUT getManagerByTaskMailbox(
            @WebParam(name = "GetManagerByTaskMailbox_IN", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/getManagerByTaskMailbox-v3", partName = "request") GetManagerByTaskMailbox_IN request,
            @WebParam(name = "TE_Cabecera", targetNamespace = "http://telefonica.com/tran/comarq/cc/cabecera", header = true, mode = WebParam.Mode.INOUT, partName = "te_header") Holder<TE_Cabecera> teHeader,
            @WebParam(name = "TE_Metadatos", targetNamespace = "http://telefonica.com/tran/comarq/cc/metadatos-2.0", header = true, mode = WebParam.Mode.INOUT, partName = "te_metadata") Holder<TE_Metadatos> teMetadata)
            throws TE_Excepcion;

    /**
     * 
     * @param request
     * @param teHeader
     * @param teMetadata
     * @return
     *     returns com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.GetOrganizationTaskMailboxByFunctionalPool_OUT
     * @throws TE_Excepcion
     */
    @WebMethod(action = "getOrganizationTaskMailboxByFunctionalPool")
    @WebResult(name = "GetOrganizationTaskMailboxByFunctionalPool_OUT", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/getOrganizationTaskMailboxByFunctionalPool-v3", partName = "response")
    GetOrganizationTaskMailboxByFunctionalPool_OUT getOrganizationTaskMailboxByFunctionalPool(
            @WebParam(name = "GetOrganizationTaskMailboxByFunctionalPool_IN", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/getOrganizationTaskMailboxByFunctionalPool-v3", partName = "request") GetOrganizationTaskMailboxByFunctionalPool_IN request,
            @WebParam(name = "TE_Cabecera", targetNamespace = "http://telefonica.com/tran/comarq/cc/cabecera", header = true, mode = WebParam.Mode.INOUT, partName = "te_header") Holder<TE_Cabecera> teHeader,
            @WebParam(name = "TE_Metadatos", targetNamespace = "http://telefonica.com/tran/comarq/cc/metadatos-2.0", header = true, mode = WebParam.Mode.INOUT, partName = "te_metadata") Holder<TE_Metadatos> teMetadata)
            throws TE_Excepcion;

    /**
     * 
     * @param request
     * @param teHeader
     * @param teMetadata
     * @return
     *     returns com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.GetTaskMailboxTreeByEnterpriseFunction_OUT
     * @throws TE_Excepcion
     */
    @WebMethod(action = "getTaskMailboxTreeByEnterpriseFunction")
    @WebResult(name = "GetTaskMailboxTreeByEnterpriseFunction_OUT", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/getTaskMailboxTreeByEnterpriseFunction-v3", partName = "response")
    GetTaskMailboxTreeByEnterpriseFunction_OUT getTaskMailboxTreeByEnterpriseFunction(
            @WebParam(name = "GetTaskMailboxTreeByEnterpriseFunction_IN", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/getTaskMailboxTreeByEnterpriseFunction-v3", partName = "request") GetTaskMailboxTreeByEnterpriseFunction_IN request,
            @WebParam(name = "TE_Cabecera", targetNamespace = "http://telefonica.com/tran/comarq/cc/cabecera", header = true, mode = WebParam.Mode.INOUT, partName = "te_header") Holder<TE_Cabecera> teHeader,
            @WebParam(name = "TE_Metadatos", targetNamespace = "http://telefonica.com/tran/comarq/cc/metadatos-2.0", header = true, mode = WebParam.Mode.INOUT, partName = "te_metadata") Holder<TE_Metadatos> teMetadata)
            throws TE_Excepcion;

    /**
     * 
     * @param request
     * @param teHeader
     * @param teMetadata
     * @return
     *     returns com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_OUT
     * @throws TE_Excepcion
     */
    @WebMethod(action = "manageTaskMailbox")
    @WebResult(name = "ManageTaskMailbox_OUT", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/manageTaskMailbox-v3", partName = "response")
    ManageTaskMailbox_OUT manageTaskMailbox(
            @WebParam(name = "ManageTaskMailbox_IN", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/manageTaskMailbox-v3", partName = "request") ManageTaskMailbox_IN request,
            @WebParam(name = "TE_Cabecera", targetNamespace = "http://telefonica.com/tran/comarq/cc/cabecera", header = true, mode = WebParam.Mode.INOUT, partName = "te_header") Holder<TE_Cabecera> teHeader,
            @WebParam(name = "TE_Metadatos", targetNamespace = "http://telefonica.com/tran/comarq/cc/metadatos-2.0", header = true, mode = WebParam.Mode.INOUT, partName = "te_metadata") Holder<TE_Metadatos> teMetadata)
            throws TE_Excepcion;

    /**
     * 
     * @param request
     * @param teHeader
     * @param teMetadata
     * @return
     *     returns com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_OUT
     * @throws TE_Excepcion
     */
    @WebMethod(action = "reassignTasksMailbox")
    @WebResult(name = "ReassignTasksMailbox_OUT", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/reassignTasksMailbox-v3", partName = "response")
    ReassignTasksMailbox_OUT reassignTasksMailbox(
            @WebParam(name = "ReassignTasksMailbox_IN", targetNamespace = "http://telefonica.com/cana/srv/TaskMailbox/msg/reassignTasksMailbox-v3", partName = "request") ReassignTasksMailbox_IN request,
            @WebParam(name = "TE_Cabecera", targetNamespace = "http://telefonica.com/tran/comarq/cc/cabecera", header = true, mode = WebParam.Mode.INOUT, partName = "te_header") Holder<TE_Cabecera> teHeader,
            @WebParam(name = "TE_Metadatos", targetNamespace = "http://telefonica.com/tran/comarq/cc/metadatos-2.0", header = true, mode = WebParam.Mode.INOUT, partName = "te_metadata") Holder<TE_Metadatos> teMetadata)
            throws TE_Excepcion;

}
