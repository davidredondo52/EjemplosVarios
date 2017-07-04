package com.telefonica.cana.srv.nuc.taskmailbox.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.PersistenceException;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.telefonica.cana.dao.functionalpoolassignment.repository.FuncionalPoolAssigmentSpecification;
import com.telefonica.cana.dao.functionalpoolassignment.repository.GewfrMailboxAccessRepository;
import com.telefonica.cana.dao.saleschannelproposal.repository.ScprpSalesChannelProposalRepository;
import com.telefonica.cana.dao.taskmailbox.dto.OrganizationPoolAssignmentDTO;
import com.telefonica.cana.dao.taskmailbox.repository.CnalaEnteFunctionTreeNodeRepository;
import com.telefonica.cana.dao.taskmailbox.repository.CnalaTaskMailboxRepository;
import com.telefonica.cana.dao.taskmailbox.repository.CnalpFuncPoolAssignmentRepository;
import com.telefonica.cana.dao.taskmailbox.repository.CnalpFunctionalPoolRepository;
import com.telefonica.cana.dao.taskmailbox.repository.CnalrOrgaPoolAssignmentRepository;
import com.telefonica.cana.dao.taskmailbox.repository.CnalrTaskMailboxRepository;
import com.telefonica.cana.dao.taskmailbox.repository.FuncPoolAssignmentSpecifications;
import com.telefonica.cana.dao.taskmailbox.repository.TaskMailboxSpecifications;
import com.telefonica.cana.model.CnalaEnteFunctionTreeNode;
import com.telefonica.cana.model.CnalaTaskMailbox;
import com.telefonica.cana.model.CnalpFuncPoolAssignment;
import com.telefonica.cana.model.CnalpFunctionalPool;
import com.telefonica.cana.model.CnalrFunctionalPoolL;
import com.telefonica.cana.model.CnalrOrgaPoolAssignment;
import com.telefonica.cana.model.CnalrTaskMailboxL;
import com.telefonica.cana.model.GewfdDistributionCriteria;
import com.telefonica.cana.model.GewfrDistributionCriteriaL;
import com.telefonica.cana.model.GewfrMailboxAccess;
import com.telefonica.cana.model.ScpraChannelProposalRole;
import com.telefonica.cana.model.ScprpSalesChannelProposal;
import com.telefonica.cana.model.ScprrPlanificationWorkflow;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FindFullTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FindFullTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FindTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FindTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.MultiLanguageList.MultiLanguage;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.Rule_DTO_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TimePeriod;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FindTaskMailBoxByResponsible_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FindTaskMailBoxByResponsible_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FindTaskMailboxOperators_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FindTaskMailboxOperators_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.FindTasksMailBoxesManager_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.FindTasksMailBoxesManager_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.GetFunctionalTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.GetFunctionalTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.SalesChannelProposal_DTO_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.FunctionalRole_DTO_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.GetManagerByTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.GetManagerByTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.GetOrganizationTaskMailboxByFunctionalPool_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.GetOrganizationTaskMailboxByFunctionalPool_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.GetTaskMailboxTreeByEnterpriseFunction_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.GetTaskMailboxTreeByEnterpriseFunction_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.service.TaskMailboxService;
import com.telefonica.cana.srv.nuc.taskmailbox.service.ext.CriteriosOrdenacion;
import com.telefonica.cana.srv.util.commonutilities.service.impl.CommonUtilitiesServiceImpl;
import com.telefonica.cana.srv.util.enumerados.enums.ET_ChannelAdecuacyState;
import com.telefonica.cana.srv.util.enumerados.enums.ET_OperationType;
import com.telefonica.coco.lib.language.LanguageService;
import com.telefonica.coco.lib.uddi.EndpointNotFoundException;
import com.telefonica.coco.lib.uddi.ServiceRegistry;
import com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_IN;
import com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_OUT;
import com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT;
import com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.GetFunctionalRole_IN;
import com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.GetFunctionalRole_OUT;
import com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.GetOrganizationRoleByFuncRole_IN;
import com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.GetOrganizationRoleByFuncRole_OUT;
import com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_OUT;
import com.telefonica.tran.api.workspace.exception.ServicioTareaException;
import com.telefonica.tran.api.workspace.impl.TE_API_Worklist;
import com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_OUT;
import com.telefonica.tran.api.workspace.msg.gettaskdetail.GetTaskDetail_OUT;
import com.telefonica.tran.comarq.cc.cabecera.TE_Cabecera;
import com.telefonica.tran.comarq.cc.error.TE_Excepcion;
import com.telefonica.tran.comarq.cc.error.fault.ErrorType;
import com.telefonica.tran.comarq.cc.metadatos.TE_Busqueda;
import com.telefonica.tran.comarq.cc.metadatos.TE_Metadatos;
import com.telefonica.tran.comarq.cc.metadatos.TE_Ordenacion;
import com.telefonica.tran.comarq.cc.metadatos.TE_Paginacion;
import com.telefonica.tran.comarq.cc.metadatos.TE_PaginacionIN;
import com.telefonica.tran.comarq.cc.paginacion.annotation.PageMetadataRequired;

import weblogic.wsee.security.unt.ClientUNTCredentialProvider;
import weblogic.xml.crypto.wss.WSSecurityContext;
import weblogic.xml.crypto.wss.provider.CredentialProvider;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { TE_Excepcion.class })
@Service
public class TaskMailboxServiceImpl implements TaskMailboxService {

    @Autowired
    private CnalaTaskMailboxRepository taskMailboxRepository;

    @Autowired
    private CnalpFuncPoolAssignmentRepository cnalpFuncPoolAssignmentRepository;

    @Autowired
    private com.telefonica.cana.dao.functionalpoolassignment.repository.CnalpFuncPoolAssignmentRepository cnalpFuncPoolAssignmentRepositoryFPA;

    @Autowired
    private ScprpSalesChannelProposalRepository scprpSalesChannelProposalRepository;

    @Autowired
    private CnalrOrgaPoolAssignmentRepository cnalrOrgaPoolAssignmentRepository;

    @Autowired
    private CnalaTaskMailboxRepository cnalaTaskMailboxRepository;

    @Autowired
    private Environment env;

    @Autowired
    private ServiceRegistry serviceRegistry;

    @Autowired
    private CnalaEnteFunctionTreeNodeRepository cnalaEnteFunctionTreeNodeRepository;

    @Autowired
    private CnalpFunctionalPoolRepository cnalpFunctionalPoolRepository;
    
    @Autowired
    private CnalrTaskMailboxRepository cnalrTaskMailboxRepository;
    
    @Autowired
    private GewfrMailboxAccessRepository gewfrMailboxAccessRepository;
    @Autowired 
    LanguageService languageService;

    private static final String CLASSNAME = "TaskMailbox";
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskMailboxServiceImpl.class);

    private static final String ERROR_FALTAN_CAMPOS_OBLIGATORIOS = "CANA-E-000131";
    private static final String ERROR_FALTAN_CAMPOS_OBLIGATORIOS_MSG = "Faltan datos obligatorios: ";
    private static final String ERROR_NO_INFO_BUZONES = "CANA-E-000303";
    private static final String ERROR_NO_INFO_BUZONES_MSG = "No hay información en ninguno de los buzones de entrada";
    private static final String WSS_USERNAME = "cana_srv-nuc-jee-TaskMailbox";
    private static final String WSS_PASSWORD = "";


    @PageMetadataRequired(maxPageSize = 150)
    public FindFullTaskMailbox_OUT findFullTaskMailbox(
            FindFullTaskMailbox_IN findfulltaskmailbox_in, TE_Cabecera te_Cabecera,
            TE_Metadatos te_Metadatos) throws TE_Excepcion {
    	
        FindFullTaskMailbox_OUT dtoOut = new FindFullTaskMailbox_OUT();
        try {
            // Creamos una lista de DTO_OUT que se van a devolver
            List<com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_OUT> listaTaskMailbox = new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_OUT>();
            // obtener idioma por defecto
            Long idiomaPorDefecto = Long.valueOf(languageService.getIdiomaPorDefecto());
            // Obtener idioma usuario
            Long idiomaUsuario = null;
            idiomaUsuario = Long.valueOf(te_Cabecera.getLenguaje());
            // Para saber si hay que buscar en tabla multiidioma o no
            boolean esIdiomaPorDefecto = false;
            if (idiomaPorDefecto.equals(idiomaUsuario)) {
                esIdiomaPorDefecto = true;
            }
            Map<Long, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_OUT> applicationsMap = 
            		new HashMap<Long, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_OUT>();
            Map<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_OUT> rulesMap = 
            		new HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_OUT>();
            // AD_findTaskMailbox
            List<CnalaTaskMailbox> listaCnalaTaskMailbox = this
                    .buscarTaskMailboxParaFindFullTaskMailBox(findfulltaskmailbox_in,
                            esIdiomaPorDefecto, idiomaUsuario, te_Metadatos, te_Cabecera);
            // LOOP: Por cada TaskMailbox encontrado
            if (listaCnalaTaskMailbox != null 
                    && !listaCnalaTaskMailbox.isEmpty()) {
                
                // recuperamos los datos de los ajenos
                HashMap <BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN> mapDTO_IN = 
                        new HashMap <BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN>();
                
                HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT> mapOrgRole_OUT =
                        new HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT>();             
                
                for (CnalaTaskMailbox cnalaTaskMailbox : listaCnalaTaskMailbox) {
                    if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment1() != null
                            && cnalaTaskMailbox.getCnalrOrgaPoolAssignment1().getParoIdOrganizationRole() != null) {
                        
                        com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                                new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN();
                        organizationRole_DTO_IN.setId(cnalaTaskMailbox.getCnalrOrgaPoolAssignment1().getParoIdOrganizationRole());
                       
                        mapDTO_IN.put(cnalaTaskMailbox.getCnalrOrgaPoolAssignment1().getParoIdOrganizationRole(), organizationRole_DTO_IN);
                        
                    } else if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment2() != null
                            && cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getParoIdOrganizationRole() != null) {
                       
                        com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                                new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN();
                        organizationRole_DTO_IN.setId(cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getParoIdOrganizationRole());
                        
                        mapDTO_IN.put(cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getParoIdOrganizationRole(), organizationRole_DTO_IN);
                    }
                }        
                
                if (!mapDTO_IN.isEmpty()) {
                    mapOrgRole_OUT = 
                            (HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT>) 
                            this.invocarOP_findOrganizationRole(
                                    mapDTO_IN,
                                    "findfulltaskmailbox",
                                    te_Cabecera,
                                    te_Metadatos);
                }
                
                
                for (CnalaTaskMailbox cnalaTaskMailbox : listaCnalaTaskMailbox) {
                    com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_OUT taskMailboxOut = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_OUT();
                    // Code
                    taskMailboxOut.setCode(cnalaTaskMailbox.getMboxCoFuncMailbox());
                    // FunctionalPool
                    com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_OUT functionalPool = null;
                    // OrganizationPoolAssignment
                    com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationPoolAssignment_DTO_OUT orgPoolAssignment = null;
                    // OrganizationRole

                    // Id
                    taskMailboxOut.setId(cnalaTaskMailbox.getMboxIdMailbox());
                    // Name
                    com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList nameMultiLenguajeName = creaMultiLanguageList(
                            findfulltaskmailbox_in, idiomaPorDefecto, idiomaUsuario,
                            esIdiomaPorDefecto, cnalaTaskMailbox);
                    taskMailboxOut.setName(nameMultiLenguajeName);
                    // ValidFor
                    com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TimePeriod timePeriod = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TimePeriod();
                    if (cnalaTaskMailbox.getMboxTiStartValidity() != null) {
                        timePeriod.setStartDateTime(
                                new Date(cnalaTaskMailbox.getMboxTiStartValidity().getTime()));
                    }
                    if (cnalaTaskMailbox.getMboxTiEndValidity() != null) {
                        timePeriod.setEndDateTime(
                                new Date(cnalaTaskMailbox.getMboxTiEndValidity().getTime()));
                    }
                    taskMailboxOut.setValidFor(timePeriod);
                    // BrotherReallocation
                    if (cnalaTaskMailbox.getMboxInBrotherReallocation() != null) {
                        taskMailboxOut.setBrotherReallocation(
                                cnalaTaskMailbox.getMboxInBrotherReallocation());
                    }
                    // MaxQuantity
                    taskMailboxOut.setMaxQuantity(cnalaTaskMailbox.getMboxQuMaximumAmount());
                    // State
                    if (cnalaTaskMailbox.getMboxInState() != null) {
                        taskMailboxOut.setState(cnalaTaskMailbox.getMboxInState().toString());
                    } else {
                        taskMailboxOut.setState("2");
                    }
                    // Volume
                    taskMailboxOut.setVolume(cnalaTaskMailbox.getMboxQuVolume());

                    // OrganizationPoolAssignment_DTO_OUT_1 - cnalaTaskMailbox
                    // se relaciona con CnalrOrgaPoolAssignment por
                    // OpasIdOrgaPoolAssignment
                    if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment1() != null && cnalaTaskMailbox
                            .getCnalrOrgaPoolAssignment1().getOpasIdOrgaPoolAssignment() != null) {
                        // OrganizationPoolAssignment_DTO_OUT obligatorio
                        orgPoolAssignment = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationPoolAssignment_DTO_OUT();
                        // orgPoolAssignment.id
                        orgPoolAssignment.setId(cnalaTaskMailbox.getCnalrOrgaPoolAssignment1()
                                .getOpasIdOrgaPoolAssignment());

                        // orgPoolAssignment.organizationRole
                        if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment1() != null
                                && cnalaTaskMailbox.getCnalrOrgaPoolAssignment1().getParoIdOrganizationRole() != null
                                && mapOrgRole_OUT.get(cnalaTaskMailbox.getCnalrOrgaPoolAssignment1().getParoIdOrganizationRole()) != null) {
                            
                            orgPoolAssignment.setOrganizationRole(mapOrgRole_OUT.get(cnalaTaskMailbox.getCnalrOrgaPoolAssignment1().getParoIdOrganizationRole()));
                        }

                        if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment1()
                                .getCnalpFunctionalPool() != null) {

                            CnalpFunctionalPool cnalpFunctionalPool = cnalaTaskMailbox
                                    .getCnalrOrgaPoolAssignment1().getCnalpFunctionalPool();

                            functionalPool = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_OUT();
                            functionalPool.setId(cnalpFunctionalPool.getWpooIdFunctionalPool());
                            functionalPool.setName(cnalpFunctionalPool.getLfpoDsFunctionalPool());

                            if (!esIdiomaPorDefecto) {
                                if (cnalpFunctionalPool.getCnalrFunctionalPoolLs() != null
                                        && !cnalpFunctionalPool.getCnalrFunctionalPoolLs()
                                                .isEmpty()) {
                                    for (CnalrFunctionalPoolL multilenguaje : cnalpFunctionalPool
                                            .getCnalrFunctionalPoolLs()) {
                                        if (idiomaUsuario.longValue() == multilenguaje
                                                .getLangCoLanguage().longValue()) {
                                            functionalPool.setName(
                                                    multilenguaje.getLfpoDsFunctionalPool());
                                            break;
                                        }
                                    }
                                }
                            }
                            orgPoolAssignment.setFunctionalPool(functionalPool);
                        }

                        taskMailboxOut.setOrganizationPoolAssignment(orgPoolAssignment);
                        // OrganizationPoolAssignment_DTO_OUT_2 -
                        // cnalaTaskMailbox se relaciona con
                        // CnalrOrgaPoolAssignment por
                        // ParoIdOrganizationRole/WpooIdFunctionalPool
                    } else if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment2() != null) {

                        // OrganizationPoolAssignment_DTO_OUT
                        orgPoolAssignment = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationPoolAssignment_DTO_OUT();
                        // orgPoolAssignment.id
                        orgPoolAssignment.setId(cnalaTaskMailbox.getCnalrOrgaPoolAssignment2()
                                .getOpasIdOrgaPoolAssignment());

                        // FunctionalPool
                        functionalPool = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_OUT();
                        // OrganizationRole_DTO_OUT
                        // llamada al ajeno ad_findOrganizationRole
                        if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment2() != null
                                && cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getParoIdOrganizationRole() != null
                                && mapOrgRole_OUT.get(cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getParoIdOrganizationRole()) != null) {

                            orgPoolAssignment.setOrganizationRole(mapOrgRole_OUT.get(cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getParoIdOrganizationRole()));

                        }

                        if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getCnalpFunctionalPool() != null) {

                            CnalpFunctionalPool cnalpFunctionalPool = cnalaTaskMailbox
                                    .getCnalrOrgaPoolAssignment2().getCnalpFunctionalPool();

                            functionalPool = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_OUT();
                            functionalPool.setId(cnalpFunctionalPool.getWpooIdFunctionalPool());
                            functionalPool.setName(cnalpFunctionalPool.getLfpoDsFunctionalPool());

                            if (!esIdiomaPorDefecto) {
                                if (cnalpFunctionalPool.getCnalrFunctionalPoolLs() != null
                                        && !cnalpFunctionalPool.getCnalrFunctionalPoolLs()
                                                .isEmpty()) {
                                    for (CnalrFunctionalPoolL multilenguaje : cnalpFunctionalPool
                                            .getCnalrFunctionalPoolLs()) {
                                        if (idiomaUsuario.longValue() == multilenguaje
                                                .getLangCoLanguage().longValue()) {
                                            functionalPool.setName(
                                                    multilenguaje.getLfpoDsFunctionalPool());
                                            break;
                                        }
                                    }
                                }
                            }
                            orgPoolAssignment.setFunctionalPool(functionalPool);
                        }

                        taskMailboxOut.setOrganizationPoolAssignment(orgPoolAssignment);

                    } else if (cnalaTaskMailbox.getCnalpFunctionalPool() != null) {
                        CnalpFunctionalPool cnalpFunctionalPool = cnalaTaskMailbox
                                .getCnalpFunctionalPool();
                        functionalPool = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_OUT();
                        functionalPool.setId(cnalpFunctionalPool.getWpooIdFunctionalPool());
                        functionalPool.setName(cnalpFunctionalPool.getFupoNaFunctionalPool());
                        if (!esIdiomaPorDefecto) {
                            if (cnalpFunctionalPool.getCnalrFunctionalPoolLs() != null
                                    && !cnalpFunctionalPool.getCnalrFunctionalPoolLs().isEmpty()) {
                                for (CnalrFunctionalPoolL multilenguaje : cnalpFunctionalPool
                                        .getCnalrFunctionalPoolLs()) {
                                    if (idiomaUsuario.longValue() == multilenguaje
                                            .getLangCoLanguage().longValue()) {
                                        functionalPool
                                                .setName(multilenguaje.getLfpoDsFunctionalPool());
                                        break;
                                    }
                                }
                            }
                        }
                        taskMailboxOut.setFunctionalPool(functionalPool);
                    }
                    
                    // SLB5 - Nuevos campos --> Se van a hacer cambios en la estructura de DTO_OUTs
                    taskMailboxOut.setDistributionMode((cnalaTaskMailbox.getMboxInDistributionMode() != null) ? cnalaTaskMailbox.getMboxInDistributionMode().toString() : null);
                    taskMailboxOut.setGroupDistributionCriteria((cnalaTaskMailbox.getMboxInGroupDistribCriteria() != null) ? cnalaTaskMailbox.getMboxInGroupDistribCriteria().toString() : null);
                    taskMailboxOut.setManualDistributionMode((cnalaTaskMailbox.getMboxInManualDistribMode() != null) ? cnalaTaskMailbox.getMboxInManualDistribMode().toString() : null);
                    
                    if (cnalaTaskMailbox.getGenaIdApplication() != null) {
                        applicationsMap.put(cnalaTaskMailbox.getGenaIdApplication(), taskMailboxOut);
                    }
                    
                    if (cnalaTaskMailbox.getRuleIdRule() != null) {
                        rulesMap.put(cnalaTaskMailbox.getRuleIdRule(), taskMailboxOut);
                    }
                    
                    
                    // DistributionCriteria
                    if (cnalaTaskMailbox.getGewfdDistributionCriteria() != null 
                    		&& cnalaTaskMailbox.getGewfdDistributionCriteria().getDiscIdDistributionCriteria() != null
                    		&& cnalaTaskMailbox.getGewfdDistributionCriteria().getDiclNaDistributionCriteria() != null) {
	                    com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.DistributionCriteria_DTO_OUT distributionCriteria_DTO_OUT =
	                    		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.DistributionCriteria_DTO_OUT();
	                    distributionCriteria_DTO_OUT.setId(cnalaTaskMailbox.getGewfdDistributionCriteria().getDiscIdDistributionCriteria());
	                    String name = cnalaTaskMailbox.getGewfdDistributionCriteria().getDiclNaDistributionCriteria();
	                    if (!idiomaPorDefecto.equals(idiomaUsuario)) {
	                        if (cnalaTaskMailbox.getGewfdDistributionCriteria().getGewfrDistributionCriteriaLs() != null
	                                && !cnalaTaskMailbox.getGewfdDistributionCriteria().getGewfrDistributionCriteriaLs().isEmpty()) {
	                            Iterator<GewfrDistributionCriteriaL> it = cnalaTaskMailbox.getGewfdDistributionCriteria().getGewfrDistributionCriteriaLs()
	                                    .iterator();
	                            while (it.hasNext()) {
	                            	GewfrDistributionCriteriaL gewfrDistributionCriteriaL = it.next();
	                                if (gewfrDistributionCriteriaL.getLangCoLanguage()
	                                        .equals(Long.valueOf(idiomaUsuario))) {
	                                    name = gewfrDistributionCriteriaL.getDiclNaDistributionCriteria();
	                                    break;
	                                }
	                            }
	                        }
	                    }
	                    distributionCriteria_DTO_OUT.setName(name);
	                    taskMailboxOut.setDistributionCriteria(distributionCriteria_DTO_OUT);
                    }
                    
                    listaTaskMailbox.add(taskMailboxOut);
                }

            }
            
            // Application
            if (applicationsMap.keySet().size() > 0) {
                com.telefonica.gstr.srv.exp.application.msg.listapplication.ListApplication_OUT listApplication_OUT = 
                        this.invocarOP_listApplication(applicationsMap.keySet(), te_Cabecera, te_Metadatos); 
                if (listApplication_OUT.getGenericApplications() != null && listApplication_OUT.getGenericApplicationsLength() > 0) {
                    for (com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT genericApplication_DTO_OUT 
                            : listApplication_OUT.getGenericApplications()) {
                        if (applicationsMap.containsKey(genericApplication_DTO_OUT.getId())) {
                            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.Application_DTO_OUT application_DTO_OUT =
                                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.Application_DTO_OUT();
                            application_DTO_OUT.setId(genericApplication_DTO_OUT.getId());
                            application_DTO_OUT.setCode4(
                                    ((com.telefonica.gstr.srv.exp.application.msg.listapplication.Application_DTO_OUT) genericApplication_DTO_OUT).getCode4());
                            application_DTO_OUT.setName(genericApplication_DTO_OUT.getName()); 
                            applicationsMap.get(genericApplication_DTO_OUT.getId()).setApplication(application_DTO_OUT);
                        }
                    }
                }
            }
            
            
            // Rule
            if (rulesMap.keySet().size() > 0) {
                com.telefonica.gere.srv.exp.rulequery.msg.getrules.GetRules_OUT getRules_OUT =
                        this.invocarOP_getRules(rulesMap.keySet(), te_Cabecera, te_Metadatos);
                if (getRules_OUT.getRules() != null && getRules_OUT.getRulesLength() > 0) {
                    for (com.telefonica.gere.srv.exp.rulequery.msg.getrules.Rule_DTO_OUT expRule_DTO_OUT : getRules_OUT.getRules()) {
                        if (rulesMap.containsKey(expRule_DTO_OUT.getId())) {
                            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.Rule_DTO_OUT rule_DTO_OUT =
                                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.Rule_DTO_OUT();
                            rule_DTO_OUT.setId(expRule_DTO_OUT.getId());
                            rule_DTO_OUT.setName(expRule_DTO_OUT.getName());
                            rulesMap.get(expRule_DTO_OUT.getId()).setRule(rule_DTO_OUT);
                        }
                    }
                }
            }
           
            
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_OUT[] arrayTaskMailbox = {};
            dtoOut.setTaskMailboxes(listaTaskMailbox.toArray(arrayTaskMailbox));
            
        } catch (TE_Excepcion e) {
            throw e;
        }
        return dtoOut;
    }
    
    public com.telefonica.gstr.srv.exp.application.msg.listapplication.ListApplication_OUT invocarOP_listApplication(
            Set<Long> applicationIds, TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos)
                    throws TE_Excepcion {

    	// Se invoca a la operación OP_listApplication con el Application.id leido y validDate = fecha del sistema.
    	// En caso de error se devuelve el 133 indicando Application y COMUNES
    	
    	com.telefonica.gstr.srv.exp.application.msg.listapplication.ListApplication_IN listApplication_IN =
    			new com.telefonica.gstr.srv.exp.application.msg.listapplication.ListApplication_IN();
    	
    	List <com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_IN> genericApplication_DTO_INs =
    			new ArrayList <com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_IN>();
    	for (Long applicationId : applicationIds) {
	    	com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_IN genericApplication_DTO_IN =
	    			new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_IN();
	    	genericApplication_DTO_IN.setId(applicationId);
	    	
	    	genericApplication_DTO_INs.add(genericApplication_DTO_IN);
    	}
    	
    	listApplication_IN.setGenericApplications(genericApplication_DTO_INs.toArray(
    			new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_IN[genericApplication_DTO_INs.size()]));
    	
    	listApplication_IN.setValidDate(new Date());
        
        // se añade seguridad
        LOGGER.debug("Inicio llamada a método invocarOP_listApplication");

        com.telefonica.gstr.srv.exp.application.msg.listapplication.ListApplication_OUT out = null;
        try {
            Holder<TE_Cabecera> holder_cab = new Holder<TE_Cabecera>(te_Cabecera);
            Holder<TE_Metadatos> holder_met = new Holder<TE_Metadatos>(
                    CommonUtilitiesServiceImpl.crearMetadatos("", 1l, 100l));

            String endpoint = serviceRegistry.getEndpoint("uddi:gstr.srv-exp-Application-v3");
            
            com.telefonica.gstr.srv.exp.application.facade.ApplicationExpServicePortType port =
                    new com.telefonica.gstr.srv.exp.application.facade.ApplicationExpServiceClient().getSrvExpApplicationPort();
           
            BindingProvider bindingProvider = (BindingProvider) port;
            bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
            bindingProvider.getRequestContext().put("com.sun.xml.ws.connect.timeout",
                               env.getRequiredProperty("system.ws.connect.timeout", Integer.class));
                 bindingProvider.getRequestContext().put("com.sun.xml.ws.request.timeout",
                               env.getRequiredProperty("system.ws.request.timeout", Integer.class));
            
            List<CredentialProvider> credList = new ArrayList<CredentialProvider>();
            credList.add(new ClientUNTCredentialProvider(WSS_USERNAME.getBytes(), "".getBytes()));
            bindingProvider.getRequestContext().put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credList);

            out = port.listApplication(listApplication_IN, holder_cab, holder_met);

        } catch (EndpointNotFoundException | TE_Excepcion e) {
            this.lanzarExcepcion("CANA_E_000133", "Application", "COMUNES");
        }
        LOGGER.debug("Fin llamada a método invocarOP_listApplication");
        return out;
    }
    
    public com.telefonica.gere.srv.exp.rulequery.msg.getrules.GetRules_OUT invocarOP_getRules(
            Set<BigDecimal> ruleIds, TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos)
                    throws TE_Excepcion {

    	// Se invoca a la operación OP_getRules  con el Rule.id leido y validDate = fecha del sistema 
    	// En caso de error se devuelve el 133 indicando Rule y COMUNES

    	com.telefonica.gere.srv.exp.rulequery.msg.getrules.GetRules_IN getRules_IN =
    			new com.telefonica.gere.srv.exp.rulequery.msg.getrules.GetRules_IN();
    	
    	List <com.telefonica.gere.srv.exp.rulequery.msg.getrules.Rule_DTO_IN> rule_DTO_INs =
    			new ArrayList <com.telefonica.gere.srv.exp.rulequery.msg.getrules.Rule_DTO_IN>();
    			
    	for (BigDecimal ruleId : ruleIds) {
	    	com.telefonica.gere.srv.exp.rulequery.msg.getrules.Rule_DTO_IN rule_DTO_IN =
	    			new com.telefonica.gere.srv.exp.rulequery.msg.getrules.Rule_DTO_IN();
	    	rule_DTO_IN.setId(ruleId);
	    	
	    	rule_DTO_INs.add(rule_DTO_IN);
    	}
    	
    	getRules_IN.setRules(rule_DTO_INs.toArray(
    			new com.telefonica.gere.srv.exp.rulequery.msg.getrules.Rule_DTO_IN[rule_DTO_INs.size()]));
    	
    	// CAMBIO No se debe pasar por la fecha 
    	//getRules_IN.setValidDate(new Date());
        
        // se añade seguridad
        LOGGER.debug("Inicio llamada a método invocarOP_getRules");

        com.telefonica.gere.srv.exp.rulequery.msg.getrules.GetRules_OUT out = null;
        try {
            Holder<TE_Cabecera> holder_cab = new Holder<TE_Cabecera>(te_Cabecera);
            Holder<TE_Metadatos> holder_met = new Holder<TE_Metadatos>(
                    CommonUtilitiesServiceImpl.crearMetadatos("", 1l, 100l));

            String endpoint = serviceRegistry.getEndpoint("uddi:gere.srv-exp-RuleQuery-v3");
            
            com.telefonica.gere.srv.exp.rulequery.facade.RuleQueryExpServicePortType port =
                    new com.telefonica.gere.srv.exp.rulequery.facade.RuleQueryExpServiceClient().getSrvExpRuleQueryPort();
           
            BindingProvider bindingProvider = (BindingProvider) port;
            bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
            bindingProvider.getRequestContext().put("com.sun.xml.ws.connect.timeout",
                               env.getRequiredProperty("system.ws.connect.timeout", Integer.class));
                 bindingProvider.getRequestContext().put("com.sun.xml.ws.request.timeout",
                               env.getRequiredProperty("system.ws.request.timeout", Integer.class));
            
            List<CredentialProvider> credList = new ArrayList<CredentialProvider>();
            credList.add(new ClientUNTCredentialProvider(WSS_USERNAME.getBytes(),"".getBytes()));
            bindingProvider.getRequestContext().put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credList);

            out = port.getRules(getRules_IN, holder_cab, holder_met);

        } catch (EndpointNotFoundException | TE_Excepcion e) {
            this.lanzarExcepcion("CANA_E_000133", "Rule", "COMUNES");
        }
        LOGGER.debug("Fin llamada a método invocarOP_getRules");
        return out;
    }

    /**
     * Tratamiento multiidioma de la respuesta de la consulta
     * 
     * @param findfulltaskmailbox_in
     * @param idiomaPorDefecto
     * @param idiomaUsuario
     * @param esIdiomaPorDefecto
     * @param cnalaTaskMailbox
     * @return
     * @throws TE_Excepcion
     */
    private com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList creaMultiLanguageList(
            FindFullTaskMailbox_IN findfulltaskmailbox_in, Long idiomaPorDefecto,
            Long idiomaUsuario, boolean esIdiomaPorDefecto, CnalaTaskMailbox cnalaTaskMailbox)
                    throws TE_Excepcion {
        LOGGER.debug("[{}] - Inicio del método creaMultiLanguageList", CLASSNAME);
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList nameMultiLenguajeName = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList();
        if (Boolean.TRUE.equals(findfulltaskmailbox_in.isShowAllLanguages())) {
            // Si es multilanguage, debemos devolver todos los idiomas
            List<com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage> listaMultilenguaje = new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage>();
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage multilenguaje = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage();
            multilenguaje.setLanguageCode(idiomaPorDefecto);
            multilenguaje.setValue(cnalaTaskMailbox.getLboxNaMailbox());
            listaMultilenguaje.add(multilenguaje);
            if (cnalaTaskMailbox.getCnalrTaskMailboxLs() != null
                    && !cnalaTaskMailbox.getCnalrTaskMailboxLs().isEmpty()) {
                for (CnalrTaskMailboxL cnalaTaskMailboxL : cnalaTaskMailbox
                        .getCnalrTaskMailboxLs()) {
                    multilenguaje = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage();
                    multilenguaje
                            .setLanguageCode(cnalaTaskMailboxL.getLangCoLanguage().longValue());
                    multilenguaje.setValue(cnalaTaskMailboxL.getLboxNaMailbox());
                    listaMultilenguaje.add(multilenguaje);
                }
                Iterator<com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage> iterador = listaMultilenguaje
                        .iterator();
                while (iterador.hasNext()) {
                    multilenguaje = iterador.next();
                    if (multilenguaje.getLanguageCode().equals(idiomaUsuario)) {
                        com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage multilenguajeClon = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage();
                        multilenguajeClon.setLanguageCode(multilenguaje.getLanguageCode());
                        multilenguajeClon.setValue(multilenguaje.getValue());
                        iterador.remove();
                        listaMultilenguaje.add(0, multilenguajeClon);
                        break;
                    }
                }
            }
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage[] multiLenguajesName = {};
            nameMultiLenguajeName.setMultiLanguages(listaMultilenguaje.toArray(multiLenguajesName));
        } else {
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage[] multiLenguajesName = 
            		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage[1];
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage multiLenguajeName = 
            		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage();
            
            // Lo seteamos por si es el idioma por defecto, o por si no se
            // encuentra el idioma en la tabla multiidioma
            multiLenguajeName.setLanguageCode(idiomaPorDefecto);
            multiLenguajeName.setValue(cnalaTaskMailbox.getLboxNaMailbox());
            if (Boolean.FALSE.equals(esIdiomaPorDefecto)) {
                for (CnalrTaskMailboxL cnalaTaskMailboxL : cnalaTaskMailbox
                        .getCnalrTaskMailboxLs()) {
                    if (cnalaTaskMailboxL.getLangCoLanguage()
                            .equals(BigDecimal.valueOf((Long) idiomaUsuario))) {
                        multiLenguajeName.setLanguageCode((Long) idiomaUsuario);
                        multiLenguajeName.setValue(cnalaTaskMailboxL.getLboxNaMailbox());
                        break;
                    }
                }
            }
            multiLenguajesName[0] = multiLenguajeName;
            nameMultiLenguajeName.setMultiLanguages(multiLenguajesName);
        }
        LOGGER.debug("[{}] - Fin del método creaMultiLanguageList", CLASSNAME);
        return nameMultiLenguajeName;
    }

    /**
     * Búsqueda con filtros en CnalaTaskMailbox
     * 
     * @param findfulltaskmailbox_in
     * @param esIdiomaPorDefecto
     * @param idiomaUsuario
     * @param te_Metadatos
     * @param te_Cabecera
     * @return
     * @throws TE_Excepcion
     */
    private List<CnalaTaskMailbox> buscarTaskMailboxParaFindFullTaskMailBox(
            FindFullTaskMailbox_IN findfulltaskmailbox_in, boolean esIdiomaPorDefecto,
            Long idiomaUsuario, TE_Metadatos te_Metadatos, TE_Cabecera te_Cabecera)
                    throws TE_Excepcion {
        LOGGER.debug("[{}] - Inicio del método buscarTaskMailboxParaFindFullTaskMailBox",
                CLASSNAME);
        
        try {
            // Validar la ordenacion
            new com.telefonica.tran.comarq.cc.paginacion.validator.OrderMetadataValidator()
                    .validate(te_Metadatos, false, new CriteriosOrdenacion()
                            .getCriteriosOrdenacions("findFullTaskMailbox"));
        } catch (TE_Excepcion e) {
            String[] s = { "AD_findFullTaskMailbox_configuracion3_DSC" };
            TE_Ordenacion te_Ordenacion = new TE_Ordenacion();
            te_Ordenacion.setCriterioOrdenacions(s);
            te_Metadatos.setTE_Ordenacion(te_Ordenacion);
        }
        
        new com.telefonica.tran.comarq.cc.paginacion.validator.PageMetadataValidator()
                .validate(te_Metadatos, false, 150L);

        // PREPARAMOS SPECIFICATION
        Specification<CnalaTaskMailbox> byRangeDate = null;
        Specification<CnalaTaskMailbox> byId = null;
        Specification<CnalaTaskMailbox> byNameLike = null;
        Specification<CnalaTaskMailbox> byCode = null;
        Specification<CnalaTaskMailbox> byIdOrganizationRole = null;
        Specification<CnalaTaskMailbox> byIdFunctionalPool = null;
        Specification<CnalaTaskMailbox> byNameLikeMultilanguage = null;
        Specification<CnalaTaskMailbox> byApplication = null;
        
        // tratamiento de fechas
        java.sql.Date fromDate = null;
        java.sql.Date toDate = null;
        
        if (findfulltaskmailbox_in.getFromDate() != null) {
            fromDate =  new java.sql.Date(findfulltaskmailbox_in.getFromDate().getTime());
        }
        
        if (findfulltaskmailbox_in.getToDate() != null) {
            toDate =  new java.sql.Date(findfulltaskmailbox_in.getToDate().getTime());
        }
        
        byRangeDate = TaskMailboxSpecifications.byRangeDate(toDate, fromDate);
        // Datos TaskMailbox
        if (findfulltaskmailbox_in.getTaskMailbox() != null) {
            // TaskMailbox.id
            if (findfulltaskmailbox_in.getTaskMailbox().getId() != null) {
                byId = TaskMailboxSpecifications
                        .byId(findfulltaskmailbox_in.getTaskMailbox().getId(), null);
            }
            // TaskMailbox.name
            if (!org.apache.commons.lang.StringUtils
                    .isBlank(findfulltaskmailbox_in.getTaskMailbox().getName())
                    && esIdiomaPorDefecto) {
                byNameLike = TaskMailboxSpecifications
                        .byNameLike(findfulltaskmailbox_in.getTaskMailbox().getName());
            }
            if (!org.apache.commons.lang.StringUtils
                    .isBlank(findfulltaskmailbox_in.getTaskMailbox().getName())
                    && !esIdiomaPorDefecto) {
                byNameLikeMultilanguage = TaskMailboxSpecifications.byNameLikeMultilanguage(
                        findfulltaskmailbox_in.getTaskMailbox().getName(),
                        BigDecimal.valueOf(idiomaUsuario));
            }
            // TaskMailbox.code
            if (!org.apache.commons.lang.StringUtils
                    .isBlank(findfulltaskmailbox_in.getTaskMailbox().getCode())) {
                byCode = TaskMailboxSpecifications
                        .byCode(findfulltaskmailbox_in.getTaskMailbox().getCode());
            }
        }
        // Datos OrganizationRole
        if (findfulltaskmailbox_in.getOrganizationRole() != null) {
            byIdOrganizationRole = TaskMailboxSpecifications
                    .byIdOrganizationRole(findfulltaskmailbox_in.getOrganizationRole().getId());
        }
        // Datos FunctionalPool
        if (findfulltaskmailbox_in.getFunctionalPool() != null) {
            byIdFunctionalPool = TaskMailboxSpecifications
                    .byIdFunctionalPool(findfulltaskmailbox_in.getFunctionalPool().getId());
        }
        // SLB5 - Datos Application
        if (findfulltaskmailbox_in.getApplication() != null) {
        	byApplication = TaskMailboxSpecifications
        			.byApplication(findfulltaskmailbox_in.getApplication().getId());
        }
        // Preparamos la paginación
        Long paginacion = 0L;
        try {
            if (te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina() != 0) {
               paginacion = te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina()-1;
            }
       } catch (NullPointerException e) {
               paginacion = 0L;
       }                              
        PageRequest page = new PageRequest(
                Integer.valueOf(paginacion.toString()),
                Integer.valueOf(te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getTamanoVentana().toString()));

        LOGGER.debug("[{}] - Se realiza la consulta de los buzones según los filtros");

        Page<CnalaTaskMailbox> taskMailboxPage = taskMailboxRepository.findFullTaskMailbox(
                Specifications.where(byRangeDate).and(byNameLikeMultilanguage).and(byCode).and(byId)
                        .and(byNameLike).and(byIdFunctionalPool).and(byIdOrganizationRole).and(byApplication),
                page,
                new CriteriosOrdenacion().getOrdenacion(
                        te_Metadatos.getTE_Ordenacion().getCriterioOrdenacions(0),
                        "findFullTaskMailbox"));

        // Preparo los metadatos de salida.
        CommonUtilitiesServiceImpl.metadatosPagBasica(te_Metadatos, taskMailboxPage.getTotalElements(), taskMailboxPage.hasNext());

        LOGGER.debug("[{}] - Se ha recuperado el siguiente numero de buzones: ",
                taskMailboxPage.getSize());
        LOGGER.debug("[{}] - Fin del método buscarTaskMailboxParaFindFullTaskMailBox", CLASSNAME);
        return taskMailboxPage.getContent();
    }



    @PageMetadataRequired(maxPageSize = 200)
    public FindTaskMailbox_OUT findTaskMailbox(FindTaskMailbox_IN findtaskmailbox_in,
            TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion {

        boolean errorParametro = false;
        if (findtaskmailbox_in == null) {
            errorParametro = true;
        }

        if (!errorParametro && findtaskmailbox_in.getOrganizationRole() != null
                && findtaskmailbox_in.getOrganizationRole().getId() == null) {
            errorParametro = true;
        }
        if (!errorParametro && findtaskmailbox_in.getFunctionalPool() != null
                && findtaskmailbox_in.getFunctionalPool().getId() == null) {
            errorParametro = true;
        }

        if (errorParametro) {
            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                    this.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                            new String[] { "TaskMailbox" }), null, ErrorType.F);
        }

        Long idiomaPorDefecto;

        try {
            idiomaPorDefecto = Long.valueOf(languageService.getIdiomaPorDefecto());
        } catch (NumberFormatException e) {
            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                    this.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                            new String[] { "TaskMailbox" }), e, ErrorType.T);
        }

        Long idiomaUsuario = null;
        try {
            idiomaUsuario = Long.valueOf(te_Cabecera.getLenguaje());
        } catch (NumberFormatException e) {
            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                    this.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                            new String[] { "TaskMailbox" }), e, ErrorType.T);
        }

        Specifications<CnalaTaskMailbox> lista = Specifications.where(null);

        if (findtaskmailbox_in.getTaskMailbox() != null && findtaskmailbox_in.getTaskMailbox().getId() != null) {
            lista = lista.and(TaskMailboxSpecifications
                    .byId(findtaskmailbox_in.getTaskMailbox().getId(), ""));
        }
        
        if (findtaskmailbox_in.getTaskMailbox() != null && findtaskmailbox_in.getTaskMailbox().getCode() != null) {
            lista = lista.and(TaskMailboxSpecifications
                    .byCode(findtaskmailbox_in.getTaskMailbox().getCode()));
        }
        
        
        if (findtaskmailbox_in.getOrganizationRole() != null) {
            lista = lista.and(TaskMailboxSpecifications
                    .byIdOrganizationRole(findtaskmailbox_in.getOrganizationRole().getId()));
        }
        if (findtaskmailbox_in.getFunctionalPool() != null) {
            lista = lista.and(TaskMailboxSpecifications
                    .byIdFunctionalPool(findtaskmailbox_in.getFunctionalPool().getId()));
        }
        java.sql.Date fromDate = null;
        java.sql.Date toDate = null;
        
        if (findtaskmailbox_in.getFromDate() != null) {
            fromDate =  new java.sql.Date(findtaskmailbox_in.getFromDate().getTime());
        }
        
        if (findtaskmailbox_in.getToDate() != null) {
            toDate =  new java.sql.Date(findtaskmailbox_in.getToDate().getTime());
        }
        lista = lista.and(TaskMailboxSpecifications.byRangeDate(toDate, fromDate));
        
        if (findtaskmailbox_in.getDistributionCriteria() != null && findtaskmailbox_in.getDistributionCriteria().getId() != null) {
            lista = lista.and(TaskMailboxSpecifications
                    .byIdDistributionCriteria(findtaskmailbox_in.getDistributionCriteria().getId().intValue()));
        }
        
        if (findtaskmailbox_in.getRule() != null && findtaskmailbox_in.getRule().getId() != null) {
            lista = lista.and(TaskMailboxSpecifications
                    .byIdRule(findtaskmailbox_in.getRule().getId()));
        }
        

        // Para saber si hay que buscar en tabla multiidioma o no
        boolean esIdiomaPorDefecto = false;
        if (idiomaPorDefecto.equals(idiomaUsuario)) {
            esIdiomaPorDefecto = true;
        }

        new com.telefonica.tran.comarq.cc.paginacion.validator.PageMetadataValidator().validate(te_Metadatos, false, 200L);
        
        try {
        	
        	new com.telefonica.tran.comarq.cc.paginacion.validator.OrderMetadataValidator().validate(
                    te_Metadatos, false, new CriteriosOrdenacion().getCriteriosOrdenacions("findTaskMailbox"));
        	
        } catch (TE_Excepcion e) {
            String[] s = { "AD_findTaskMailbox_configuracion1_DSC" };
            TE_Ordenacion te_Ordenacion = new TE_Ordenacion();
            te_Ordenacion.setCriterioOrdenacions(s);
            te_Metadatos.setTE_Ordenacion(te_Ordenacion);
        }
        
        // Validación de paginacion
        new com.telefonica.tran.comarq.cc.paginacion.validator.PageMetadataValidator().validate(te_Metadatos, false, Long.valueOf(150));
        Long paginacion = 0L;
        try {
            if (te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina() != 0) {
               paginacion = te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina()-1;
            }
        } catch (NullPointerException e) {
            paginacion = 0L;
        }       
        PageRequest pagerequest = new PageRequest(
                Integer.valueOf(paginacion.toString()),
                Integer.valueOf(te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getTamanoVentana().toString()),
                new Sort(new CriteriosOrdenacion().getOrdenacion(te_Metadatos.getTE_Ordenacion().getCriterioOrdenacions(0), "findTaskMailbox")));

        Page<CnalaTaskMailbox> listaCnalaTaskMailbox = taskMailboxRepository.findAll(lista, pagerequest);
        
        CommonUtilitiesServiceImpl.metadatosPagBasica(te_Metadatos, listaCnalaTaskMailbox.getTotalElements(), listaCnalaTaskMailbox.hasNext());
        
        List <com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_OUT> listaTaskMailbox = 
        		new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_OUT>();

        if (listaCnalaTaskMailbox != null
                && listaCnalaTaskMailbox.getContent() != null
                && !listaCnalaTaskMailbox.getContent().isEmpty()) {

            for (CnalaTaskMailbox cnalaTaskMailbox : listaCnalaTaskMailbox) {

                com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_OUT taskMailbox = 
                		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_OUT();

                // • TaskMailbox.id
                taskMailbox.setId(cnalaTaskMailbox.getMboxIdMailbox());

                // • TaskMailbox.name (multi idioma)
                com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.MultiLanguageList nameMultiLenguajeName = 
                		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.MultiLanguageList();

                if (Boolean.TRUE.equals(findtaskmailbox_in.isShowAllLanguages())) {

                    // Si es multilanguage, debemos devolver todos los idiomas
                    List<MultiLanguage> listaMultilenguaje = new ArrayList<MultiLanguage>();
                    MultiLanguage multilenguaje = new MultiLanguage();
                    multilenguaje.setLanguageCode(idiomaPorDefecto);
                    multilenguaje.setValue(cnalaTaskMailbox.getLboxNaMailbox());
                    listaMultilenguaje.add(multilenguaje);

                    if (cnalaTaskMailbox.getCnalrTaskMailboxLs() != null
                            && !cnalaTaskMailbox.getCnalrTaskMailboxLs().isEmpty()) {
                        for (CnalrTaskMailboxL ctm : cnalaTaskMailbox.getCnalrTaskMailboxLs()) {
                            multilenguaje = new MultiLanguage();
                            multilenguaje.setLanguageCode(ctm.getLangCoLanguage().longValue());
                            multilenguaje.setValue(ctm.getLboxNaMailbox());
                            listaMultilenguaje.add(multilenguaje);
                        }
                        Iterator<MultiLanguage> iterator = listaMultilenguaje.iterator();
                        while (iterator.hasNext()) {
                            multilenguaje = iterator.next();
                            if (multilenguaje.getLanguageCode().equals(idiomaUsuario)) {
                                MultiLanguage multilenguajeClon = new MultiLanguage();
                                multilenguajeClon.setLanguageCode(multilenguaje.getLanguageCode());
                                multilenguajeClon.setValue(multilenguaje.getValue());
                                iterator.remove();
                                listaMultilenguaje.add(0, multilenguajeClon);
                                break;
                            }
                        }
                    }

                    MultiLanguage[] multiLenguajesName = {};
                    nameMultiLenguajeName
                            .setMultiLanguages(listaMultilenguaje.toArray(multiLenguajesName));

                } else {
                    MultiLanguage[] multiLenguajesName = new MultiLanguage[1];
                    MultiLanguage multiLenguajeName = new MultiLanguage();

                    // Lo seteamos por si es el idioma por defecto, o por si no
                    // se encuentra el idioma en la tabla multiidioma
                    multiLenguajeName.setLanguageCode(idiomaPorDefecto);
                    multiLenguajeName.setValue(cnalaTaskMailbox.getLboxNaMailbox());

                    if (Boolean.FALSE.equals(esIdiomaPorDefecto)) {
                        for (CnalrTaskMailboxL ctm : cnalaTaskMailbox.getCnalrTaskMailboxLs()) {
                            if (idiomaUsuario.longValue() == ctm.getLangCoLanguage().longValue()) {
                                multiLenguajeName.setLanguageCode(idiomaUsuario);
                                multiLenguajeName.setValue(ctm.getLboxNaMailbox());
                                break;
                            }
                        }
                    }

                    multiLenguajesName[0] = multiLenguajeName;
                    nameMultiLenguajeName.setMultiLanguages(multiLenguajesName);
                }

                taskMailbox.setName(nameMultiLenguajeName);

                // • TaskMailbox.code
                taskMailbox.setCode(cnalaTaskMailbox.getMboxCoFuncMailbox());

                // MaxQuantity
                taskMailbox.setMaxQuantity(cnalaTaskMailbox.getMboxQuMaximumAmount());
                // State
                if (cnalaTaskMailbox.getMboxInState() != null) {
                    taskMailbox.setState(cnalaTaskMailbox.getMboxInState().toString());
                } else { 
                    taskMailbox.setState("2");
                }
                // Volume
                taskMailbox.setVolume(cnalaTaskMailbox.getMboxQuVolume());

                // • TaskMailbox.validFor
                TimePeriod timePeriod = new TimePeriod();
                timePeriod.setStartDateTime(cnalaTaskMailbox.getMboxTiStartValidity());
                timePeriod.setEndDateTime(cnalaTaskMailbox.getMboxTiEndValidity());
                taskMailbox.setValidFor(timePeriod);
                

                if (cnalaTaskMailbox.getGewfdDistributionCriteria() != null){
                	com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.DistributionCriteria_DTO_OUT distributionCriteria_DTO_OUT = 
    						new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.DistributionCriteria_DTO_OUT();
    				distributionCriteria_DTO_OUT.setId(cnalaTaskMailbox.getGewfdDistributionCriteria().getDiscIdDistributionCriteria());
    				distributionCriteria_DTO_OUT.setName(cnalaTaskMailbox.getGewfdDistributionCriteria().getDiclNaDistributionCriteria());
    				com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TimePeriod tp = 
    						new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TimePeriod();
    				tp.setEndDateTime(cnalaTaskMailbox.getGewfdDistributionCriteria().getDiscDaEndValidity());
    				tp.setStartDateTime(cnalaTaskMailbox.getGewfdDistributionCriteria().getDiscDaStartValidity());
    				distributionCriteria_DTO_OUT.setValidFor(tp);
    				
    				taskMailbox.setDistributionCriteria(distributionCriteria_DTO_OUT);
                }
                
                if (cnalaTaskMailbox.getRuleIdRule() != null){
    				
                	Rule_DTO_OUT rule_DTO_OUT = new Rule_DTO_OUT();
                	rule_DTO_OUT.setId(cnalaTaskMailbox.getRuleIdRule());
    				taskMailbox.setRule(rule_DTO_OUT);
                }
                
                if (cnalaTaskMailbox.getCnalpFunctionalPool() != null) {
                    com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_OUT functionalPool_DTO_OUT = 
                            new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_OUT();
                    // id
                    functionalPool_DTO_OUT.setId(cnalaTaskMailbox.getCnalpFunctionalPool().getWpooIdFunctionalPool());
                    // name
                    if (esIdiomaPorDefecto) {
                        functionalPool_DTO_OUT.setName(cnalaTaskMailbox.getCnalpFunctionalPool().getFupoNaFunctionalPool());
                    } else {
                        // si no es el idioma por defecto busco la traducción en la tabla de idiomas
                        if (cnalaTaskMailbox.getCnalpFunctionalPool().getCnalrFunctionalPoolLs() != null 
                                && !cnalaTaskMailbox.getCnalpFunctionalPool().getCnalrFunctionalPoolLs().isEmpty()) {
                            String name = null;
                            for (CnalrFunctionalPoolL cnalrFunctionalPoolL : cnalaTaskMailbox.getCnalpFunctionalPool().getCnalrFunctionalPoolLs()) {
                                if (cnalrFunctionalPoolL.getLangCoLanguage().compareTo(idiomaUsuario) == 0) {
                                    name = cnalrFunctionalPoolL.getLfpoDsFunctionalPool();
                                }
                            }
                            functionalPool_DTO_OUT.setName(name);
                        }
                    }
                    
                    taskMailbox.setFunctionalPool(functionalPool_DTO_OUT);
                }
                
                if (findtaskmailbox_in.getOrganizationRole() != null
                        && findtaskmailbox_in.getOrganizationRole().getId() != null) {
                    com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_OUT organizationRole_DTO_OUT = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_OUT();
                    BigDecimal idOrgranizationRole = null;
                    idOrgranizationRole = findtaskmailbox_in.getOrganizationRole().getId();
                    organizationRole_DTO_OUT.setId(idOrgranizationRole);
                    taskMailbox.setOrganizationRole(organizationRole_DTO_OUT);
                }

                taskMailbox.setBrotherReallocation(cnalaTaskMailbox.getMboxInBrotherReallocation());

                listaTaskMailbox.add(taskMailbox);
            }
        }

        FindTaskMailbox_OUT dtoOut = new FindTaskMailbox_OUT();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_OUT[] arrayTaskMailbox = {};
        dtoOut.setTaskMailboxes(listaTaskMailbox.toArray(arrayTaskMailbox));

        return dtoOut;
    }

    /**
     * El AD_findTaskMailBoxByResponsible contara el número de gestores que hay
     * en cada buzón de grupo y devolverá la lista gestores que hay en el grupo.
     * El buzón puede ser de Functional Pool o de una Organization Role dentro
     * de un Functional Pool. Según lo que sea, se cuenta de manera distinta.
     * 
     * @author MRSOPOJO
     * @param AD_FindTaskMailBoxByResponsible_IN
     * @param TE_Metadatos
     * @param TE_Cabecera
     * @return AD_FindTaskMailBoxByResponsible_OUT
     * @throws TE_Excepcion
     */
    @PageMetadataRequired(maxPageSize = 150)
    public FindTaskMailBoxByResponsible_OUT findTaskMailBoxByResponsible(
            FindTaskMailBoxByResponsible_IN findtaskmailboxbyresponsible_in,
            TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion {
    	
        LOGGER.debug("[{}] - Inicio del método FindTaskMailBoxByResponsible", CLASSNAME);
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FindTaskMailBoxByResponsible_OUT aD_FindTaskMailBoxByResponsible_OUT = 
        		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FindTaskMailBoxByResponsible_OUT();

        List<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT> listGroupingTaskMailboxOUT = 
                new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT>();

        // Comienzo. Por cada objeto de la lista de Entrada
        for (com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible
                .TaskMailbox_DTO_IN taskMailbox_DTO_IN : findtaskmailboxbyresponsible_in.getTaskMailboxes()) {
            
            Specifications<CnalpFuncPoolAssignment> spec = this.montarCriteriosTMBR(taskMailbox_DTO_IN);

            // paginacion
         // Validación de paginacion
            new com.telefonica.tran.comarq.cc.paginacion.validator.PageMetadataValidator().validate(te_Metadatos, false, Long.valueOf(150));
            Long paginacion = 0L;
            try {
                if (te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina() != 0) {
                    paginacion = te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina()-1;
                }
            } catch (NullPointerException e) {
                   paginacion = 0L;
            }                              
            PageRequest pagerequest = new PageRequest(
                    Integer.valueOf(paginacion.toString()),
                    Integer.valueOf(te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getTamanoVentana().toString()));
            /*
             * Al no venir criterio de ordenacion, se hace ordenacion por
             * defecto: id del FuncPoolAssignment
             */
            
            Page <CnalpFuncPoolAssignment> pageCnalpFuncPoolAssignment = 
                    (Page<CnalpFuncPoolAssignment>) cnalpFuncPoolAssignmentRepository
                    .findTaskMailBoxByResponsible(
                            spec, 
                            (Pageable) pagerequest,
                            new Sort.Order(Direction.ASC, "fpasIdFuncPoolAssignment"));

            CommonUtilitiesServiceImpl.metadatosPagBasica(
                    te_Metadatos, 
                    pageCnalpFuncPoolAssignment.getTotalElements(), 
                    pageCnalpFuncPoolAssignment.hasNext());
            
            List<CnalpFuncPoolAssignment> listaCnalp = this.distincRepetidos1(pageCnalpFuncPoolAssignment.getContent());

            if (listaCnalp.isEmpty()) {
                throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                        this.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                                new String[] { "TaskMailbox" }), null, ErrorType.F);

            } else {

                com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT groupingTaskMailboxOUT = 
                		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT();

                Map<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT> listOrganizationRoleOUT = 
                		new HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT>();

                /*
                 * si viene informado el organizationRole y es igual al id del
                 * organization role de la cnapFuncPoolAssignment se monta la
                 * salida
                 */
                if (taskMailbox_DTO_IN.getOrganizationRole() != null
                        && taskMailbox_DTO_IN.getOrganizationRole().getId() != null) {

                    LOGGER.debug("[{}] - Viene informado el organization role ", CLASSNAME);

                    for (CnalpFuncPoolAssignment cnalpFuncPoolAssignment : listaCnalp) {

                        if (cnalpFuncPoolAssignment.getParoIdFunctionalRole().equals(taskMailbox_DTO_IN.getOrganizationRole().getId())) {

                            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT organizationRoleOUT = 
                            		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT();
                            
                            FindOrgRoleLowLevel_OUT findOrgRoleLowLevel_OUT = 
                                    this.invocarOP_findOrgRoleLowLevel(
                                            cnalpFuncPoolAssignment.getParoIdFunctionalRole(),
                                            te_Cabecera,
                                            te_Metadatos);
                            
                            if (findOrgRoleLowLevel_OUT != null 
                            		&& findOrgRoleLowLevel_OUT.getOrganizationRole() != null
                            		&& findOrgRoleLowLevel_OUT.getOrganizationRole().getId() != null) {
                            	 organizationRoleOUT.setId(findOrgRoleLowLevel_OUT.getOrganizationRole().getId());
                            	 
                            	 listOrganizationRoleOUT.put(
                            	         findOrgRoleLowLevel_OUT.getOrganizationRole().getId(),
                            	         organizationRoleOUT);
                            }
                        }
                    }
                    
                    com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_OUT taskMailboxOUT = 
                            new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_OUT();
                    
                    taskMailboxOUT.setNumberOperators(Long.valueOf(listOrganizationRoleOUT.size()));
                    taskMailboxOUT.setId(taskMailbox_DTO_IN.getId());
                    
                    if (listOrganizationRoleOUT.size() == 0) {
                        throw new TE_Excepcion(
                                CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132", null),
                                CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                                        new String[] { "findOrgRoleLowLevel - Gest" }), null, ErrorType.F);
                    }

                    groupingTaskMailboxOUT.setOrganizationRoles(listOrganizationRoleOUT.values().toArray(
                                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT[listOrganizationRoleOUT.size()]));
                    
                    groupingTaskMailboxOUT.setTaskMailbox(taskMailboxOUT);
                    
                    listGroupingTaskMailboxOUT.add(groupingTaskMailboxOUT);
                    
                } else {
                    LOGGER.debug("[{}] - No viene informado el organization role ", CLASSNAME);
                    
                    // hacemos una sola llamada al externo
                    
                    List <com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_IN> listFunctionalRole_DTO_IN =
                            new ArrayList <com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_IN>();
                            
                    for (CnalpFuncPoolAssignment cnalpFuncPoolAssignment : listaCnalp) {
                        
                        if (cnalpFuncPoolAssignment.getParoIdFunctionalRole() != null) {
                            com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_IN functionalRole_DTO_IN =
                                    new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_IN(); 
                                    
                            functionalRole_DTO_IN.setId(cnalpFuncPoolAssignment.getParoIdFunctionalRole());
                            
                            listFunctionalRole_DTO_IN.add(functionalRole_DTO_IN);
                        }
                    }
                    
                    if (!listFunctionalRole_DTO_IN.isEmpty()) {
                        try {

                            GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = 
                                    this.llamadaGetOrganizationRoleByFuncRole_OUT_LIST(
                                            listFunctionalRole_DTO_IN,
                                            te_Cabecera);

                            if (getOrganizationRoleByFuncRole_OUT == null
                                    || getOrganizationRoleByFuncRole_OUT.getFunctionalRoles() == null
                                    || getOrganizationRoleByFuncRole_OUT.getFunctionalRolesLength() == 0){

                                throw new TE_Excepcion(
                                        CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132", null),
                                        CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                                                new String[] { "GetOrganizationRoleByFuncRole - GEST" }), null, ErrorType.F);
                            }

                            for (com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole
                                    .FunctionalRole_DTO_OUT functionalRole_DTO_OUT : getOrganizationRoleByFuncRole_OUT.getFunctionalRoles()) {

                                /*
                                 * se obtiene en la salida el organizationRole(lista)
                                 */

                                com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT organizationRoleOUT = 
                                        new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT();

                                organizationRoleOUT.setId(functionalRole_DTO_OUT.getOrganizationRole().getId());

                                listOrganizationRoleOUT.put(
                                        functionalRole_DTO_OUT.getOrganizationRole().getId(),
                                        organizationRoleOUT);

                            }

                        } catch (TE_Excepcion e) {
                            LOGGER.debug("Ha fallado el servicio de GESTORES ");
                        }
                    }                   

                    com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_OUT taskMailboxOUT = 
                    		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_OUT();
                    //taskMailboxOUT.setNumberOperators((long) listaCnalp.size());
                    taskMailboxOUT.setNumberOperators(Long.valueOf(listOrganizationRoleOUT.size()));
                    
                    taskMailboxOUT.setId(taskMailbox_DTO_IN.getId());

                    groupingTaskMailboxOUT.setOrganizationRoles(listOrganizationRoleOUT.values().toArray(
                            new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT[listOrganizationRoleOUT
                                    .size()]));
                    groupingTaskMailboxOUT.setTaskMailbox(taskMailboxOUT);
                    listGroupingTaskMailboxOUT.add(groupingTaskMailboxOUT);
                }
                /*
                 * se comparan las dos listas: la obtenida de gestores de la
                 * organizationRole la obtenida de gestores de la FunctionalPool
                 */
            }
        }

        aD_FindTaskMailBoxByResponsible_OUT
                .setGroupingTaskMailboxes(listGroupingTaskMailboxOUT.toArray(
                        new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT[listGroupingTaskMailboxOUT
                                .size()]));
        
        LOGGER.debug("[{}] - Fin del método FindTaskMailBoxByResponsible", CLASSNAME);
        return aD_FindTaskMailBoxByResponsible_OUT;
    }

    /**
     * MRSOPOJO Metodo para montar los criterios de busqueda
     * 
     * @param taskMailboxes
     * @return
     */
    private Specifications<CnalpFuncPoolAssignment> montarCriteriosTMBR(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN taskMailboxes) {
    	
        LOGGER.debug("[{}] - Inicio del método montarCriteriosTMBS", CLASSNAME);
        
        Specifications<CnalpFuncPoolAssignment> spec = Specifications.where(null);
        /*
         * se obtiene la lista de gestores vigentes a partir de la fecha de hoy
         */
        
        spec = spec.and(FuncPoolAssignmentSpecifications
                .byRangeDate(
                        null,
                        null));
        
        List<BigDecimal> idFunctionalPool = new ArrayList<BigDecimal>();
        
        idFunctionalPool.add(taskMailboxes.getFunctionalPool().getId());
        
        List<BigDecimal> idTaskMailbox = new ArrayList<BigDecimal>();
        
        idTaskMailbox.add(taskMailboxes.getId());
        
        if (taskMailboxes.getOrganizationRole() == null) {
        	
            spec = spec.and(FuncPoolAssignmentSpecifications.byFunctionalPool(idFunctionalPool,
                    idTaskMailbox));
            
        } else {
        	
            List<BigDecimal> idOrgaRole = new ArrayList<BigDecimal>();
            
            idOrgaRole.add(taskMailboxes.getOrganizationRole().getId());
            
            spec = spec.and(FuncPoolAssignmentSpecifications
                    .byFunctionalPoolAndOrgaRole(idTaskMailbox, idFunctionalPool, idOrgaRole));
        }
        
        LOGGER.debug("[{}] - Fin del método montarCriteriosTMBS", CLASSNAME);
        
        return spec;
    }

    @PageMetadataRequired(maxPageSize = 150)
    public FindTaskMailboxOperators_OUT findTaskMailboxOperators(
            FindTaskMailboxOperators_IN findtaskmailboxoperators_in, TE_Cabecera te_Cabecera,
            TE_Metadatos te_Metadatos) throws TE_Excepcion {
        
        FindTaskMailboxOperators_OUT findTaskMailboxOperatorsOUT = 
                new FindTaskMailboxOperators_OUT();
        
        /*
         List<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT> listaOrganizationRoleDTOOUT = 
                new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT>(); 
         
         */
        
        HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT> listaOrganizationRoleDTOOUT = 
        		new HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT>();

        if (te_Metadatos.getTE_Ordenacion() == null) {
            te_Metadatos.setTE_Ordenacion(new TE_Ordenacion());
        }
        if (te_Metadatos.getTE_Busqueda() == null) {
            te_Metadatos.setTE_Busqueda(new TE_Busqueda());
        }
        if (te_Metadatos.getTE_Paginacion() == null) {
            te_Metadatos.setTE_Paginacion(new TE_Paginacion());
        }

        // Ordenacion
        try {
            new com.telefonica.tran.comarq.cc.paginacion.validator.OrderMetadataValidator()
                    .validate(te_Metadatos, false, new CriteriosOrdenacion()
                            .getCriteriosOrdenacions("findTaskMailboxOperators"));
        } catch (TE_Excepcion e) {
        	String[] s = { "AD_findTaskMailboxOperators_configuracion7_DSC" };
            TE_Ordenacion te_Ordenacion = new TE_Ordenacion();
            te_Ordenacion.setCriterioOrdenacions(s);
            te_Metadatos.setTE_Ordenacion(te_Ordenacion);
        }

        try {
            LOGGER.debug("[{}] - Inicio del  método findTaskMailboxOperators", CLASSNAME);

            BigDecimal idFunctionalPool = null;
            BigDecimal idOrganizationRole = null;

            if (findtaskmailboxoperators_in == null
                    || findtaskmailboxoperators_in.getFunctionalPool() == null
                    || findtaskmailboxoperators_in.getFunctionalPool().getId() == null) {
                //Mirar las trazas
                LOGGER.error(
                        "[{}] - Error faltan parámetros de entrada obligatorios: FunctionalPoolId");
                throw new TE_Excepcion(
                        this.getMessagebyIdioma(null, "CANA_E_000131", null),
                        this.getMessagebyIdioma(null, "CANA_E_000131_MSG", new String[] { "FunctionalPool>>Id" }), null, ErrorType.F);

            }
            idFunctionalPool = findtaskmailboxoperators_in.getFunctionalPool().getId();

            if (findtaskmailboxoperators_in.getOrganizationRole() != null
                    && findtaskmailboxoperators_in.getOrganizationRole().getId() != null) {
                idOrganizationRole = findtaskmailboxoperators_in.getOrganizationRole().getId();
            }

            if (idOrganizationRole == null) {

                LOGGER.debug(
                        "[{}] - No viene informado el organization role, sino la unidad funcional ",
                        CLASSNAME);
                LOGGER.debug("[{}] - Llamada a AD_findFullFunctionalPoolAssignment", CLASSNAME);

                // Inicio AD_FindFullFunctionalPoolAssignment

                // validamos los criterios de ordenacion
                TE_Metadatos metadatosfindfullfunctionalpoolassignment = new TE_Metadatos();
                metadatosfindfullfunctionalpoolassignment.setTE_Paginacion(new TE_Paginacion());
                metadatosfindfullfunctionalpoolassignment.getTE_Paginacion()
                        .setTE_PaginacionIN(new TE_PaginacionIN());
                metadatosfindfullfunctionalpoolassignment.getTE_Paginacion().getTE_PaginacionIN()
                        .setNumeroPagina(0L);
                metadatosfindfullfunctionalpoolassignment.getTE_Paginacion().getTE_PaginacionIN()
                        .setTamanoVentana(150L);

                metadatosfindfullfunctionalpoolassignment.setTE_Ordenacion(new TE_Ordenacion());
                String[] x = { "AD_findFullFunctionalPoolAssignment_configuracion1_DSC" };
                metadatosfindfullfunctionalpoolassignment.getTE_Ordenacion()
                        .setCriterioOrdenacions(x);

                new com.telefonica.tran.comarq.cc.paginacion.validator.OrderMetadataValidator()
                        .validate(metadatosfindfullfunctionalpoolassignment, false,
                                new CriteriosOrdenacion().getCriteriosOrdenacions(
                                        "findFullFunctionalPoolAssignment"));


                // tratamiento de los datos deginación
                Long paginacion = 0L;
                try {
                    if (te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina() != 0) {
                       paginacion = te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina()-1;
                    }
               } catch (NullPointerException e) {
                       paginacion = 0L;
               }                              
                PageRequest pagerequest = new PageRequest(
                        Integer.valueOf(paginacion.toString()),
                        Integer.valueOf(te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getTamanoVentana().toString()));
     
                    // Llamada al DAO del servicio
                    // AD_FindFullFunctionalPoolAssignment
                Page<CnalpFuncPoolAssignment> lsCnalpFuncPoolAssignments = (Page<CnalpFuncPoolAssignment>) cnalpFuncPoolAssignmentRepositoryFPA
                        .findFullFunctionalPoolAssignment(
                                this.aniadirParametrosChangeSearchTypeFalse(idFunctionalPool), pagerequest,
                                new CriteriosOrdenacion().getOrdenacion(metadatosfindfullfunctionalpoolassignment.getTE_Ordenacion().getCriterioOrdenacions(0), "findFullFunctionalPoolAssignment"));
                    
                if (lsCnalpFuncPoolAssignments != null
                        && lsCnalpFuncPoolAssignments.hasContent()) {

                    List<CnalpFuncPoolAssignment> fpaList = new ArrayList<CnalpFuncPoolAssignment>();
                    fpaList.addAll(lsCnalpFuncPoolAssignments.getContent());

                    CommonUtilitiesServiceImpl.metadatosPagBasica(te_Metadatos, lsCnalpFuncPoolAssignments.getTotalElements(), lsCnalpFuncPoolAssignments.hasNext());
                    
                    HashMap<BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.OrganizationRole_DTO_OUT> mapOrgRole_OUT =
                            new HashMap<BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.OrganizationRole_DTO_OUT>();
                            
                    // findOrganizationRole
                     
                    HashMap <BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN> mapDTO_IN = 
                            new HashMap <BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN>();
                            
                    HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT> mapOrganizationRole_DTO_OUT =
                            new HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT>();        
                            
                    for (CnalpFuncPoolAssignment cnalpFuncPoolAssignment : fpaList) {
                        
                        if (cnalpFuncPoolAssignment.getParoIdFunctionalRole() != null) {
                            
                            GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = 
                                    this.llamadaGetOrganizationRoleByFuncRole_OUT_ID(
                                            cnalpFuncPoolAssignment.getParoIdFunctionalRole(),
                                            te_Cabecera);
                            
                            if (getOrganizationRoleByFuncRole_OUT == null
                                    || getOrganizationRoleByFuncRole_OUT.getFunctionalRoles() == null
                                    || getOrganizationRoleByFuncRole_OUT.getFunctionalRolesLength() == 0
                                    || getOrganizationRoleByFuncRole_OUT.getFunctionalRoles(0) == null
                                    || getOrganizationRoleByFuncRole_OUT.getFunctionalRoles(0).getId() == null
                                    || getOrganizationRoleByFuncRole_OUT.getFunctionalRoles(0).getOrganizationRole() == null
                                    || getOrganizationRoleByFuncRole_OUT.getFunctionalRoles(0).getOrganizationRole().getId() == null) {

                                throw new TE_Excepcion(
                                        CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132", null),
                                        CommonUtilitiesServiceImpl.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                                                new String[] { "GetOrganizationRoleByFuncRole - GEST" }), null, ErrorType.F);
                            }
                            
                            
                            com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                                    new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN();
                            organizationRole_DTO_IN.setId(getOrganizationRoleByFuncRole_OUT.getFunctionalRoles(0).getOrganizationRole().getId());
                            mapDTO_IN.put(getOrganizationRoleByFuncRole_OUT.getFunctionalRoles(0).getOrganizationRole().getId(), organizationRole_DTO_IN);
                            
                            mapOrgRole_OUT.put(cnalpFuncPoolAssignment.getParoIdFunctionalRole(), getOrganizationRoleByFuncRole_OUT.getFunctionalRoles(0).getOrganizationRole());
                        }
                        
                    }
                    
                    
                    if (!mapDTO_IN.isEmpty()) {
                        mapOrganizationRole_DTO_OUT = 
                                (HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT>) 
                                this.invocarOP_findOrganizationRole(
                                        mapDTO_IN,
                                        "findtaskmailboxoperators",
                                        te_Cabecera,
                                        te_Metadatos);
                    }

                    // para cada FuncRole recupero su OrganizationRoles
                    
                    for (CnalpFuncPoolAssignment cnalpFuncPoolAssignment : fpaList) {


                        BigDecimal orgaRoleId = mapOrgRole_OUT.get(cnalpFuncPoolAssignment.getParoIdFunctionalRole()).getId();
                        // si ya existe en al lista, no lo seteamos
                        if (listaOrganizationRoleDTOOUT.get(orgaRoleId) != null) {
                            continue;
                        } 
                        // FunctionalPoolAssignment.FunctionalPool.OrganizationRole

                        // informamos los datos de salida 
                        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT organizationRole_DTO_OUT =
                                mapOrganizationRole_DTO_OUT.get(mapOrgRole_OUT.get(cnalpFuncPoolAssignment.getParoIdFunctionalRole()).getId());

                        // recupero el buzon de la unidad funcional
                        if (cnalpFuncPoolAssignment.getCnalpFunctionalPool().getCnalaTaskMailboxs() != null
                                && !cnalpFuncPoolAssignment.getCnalpFunctionalPool().getCnalaTaskMailboxs().isEmpty()) {


                            for (CnalaTaskMailbox mbox : cnalpFuncPoolAssignment.getCnalpFunctionalPool().getCnalaTaskMailboxs()) {

                                if (mbox.getCnalrOrgaPoolAssignment1() == null) {

                                    // buscamos os acceso asignados a los functionalRole 
                                    List <GewfrMailboxAccess> lstAccesos = 
                                            gewfrMailboxAccessRepository.findAccessByFuncRole(
                                                    cnalpFuncPoolAssignment.getParoIdFunctionalRole());

                                    // de la lista me quedo con el que el buzon coincida con el de FuncPool
                                    if (lstAccesos != null && !lstAccesos.isEmpty()) {

                                        for (GewfrMailboxAccess gewfrMailboxAccess : lstAccesos) {

                                            if (gewfrMailboxAccess.getCnalaTaskMailbox() != null
                                                    && gewfrMailboxAccess.getCnalaTaskMailbox().getMboxIdMailbox().compareTo(mbox.getMboxIdMailbox()) == 0) {

                                                com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.TaskMailbox_DTO_OUT taskMailbox_DTO_OUT = 
                                                        new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.TaskMailbox_DTO_OUT();

                                                // FunctionalPoolAssignment.FunctionalPool.TaskMailBoxOPA.id
                                                taskMailbox_DTO_OUT.setId(mbox.getMboxIdMailbox());

                                                com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.MailboxAccess_DTO_OUT mailboxAccess_DTO_OUT = 
                                                        new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.MailboxAccess_DTO_OUT();
                                                mailboxAccess_DTO_OUT
                                                .setMailboxAccess(gewfrMailboxAccess.getMaacInMailboxAccess());
                                                mailboxAccess_DTO_OUT
                                                .setMailboxResponsible(gewfrMailboxAccess.getMaacInMailboxResponsible());
                                                taskMailbox_DTO_OUT
                                                .setMailboxAccess(mailboxAccess_DTO_OUT);

                                                // SLB5 - Nuevos campos
                                                com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.Application_DTO_OUT application_DTO_OUT =
                                                        new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.Application_DTO_OUT();
                                                application_DTO_OUT.setId(mbox.getGenaIdApplication());
                                                taskMailbox_DTO_OUT.setApplication(application_DTO_OUT);
                                                taskMailbox_DTO_OUT.setDistributionMode((mbox.getMboxInDistributionMode() != null) ? mbox.getMboxInDistributionMode().toString() : null);
                                                taskMailbox_DTO_OUT.setGroupDistributionCriteria((mbox.getMboxInGroupDistribCriteria() != null) ? mbox.getMboxInGroupDistribCriteria().toString() : null);
                                                taskMailbox_DTO_OUT.setManualDistributionMode((mbox.getMboxInManualDistribMode() != null) ? mbox.getMboxInManualDistribMode().toString() : null);

                                                organizationRole_DTO_OUT.setTaskMailbox(taskMailbox_DTO_OUT);

                                                listaOrganizationRoleDTOOUT.put(organizationRole_DTO_OUT.getId(), organizationRole_DTO_OUT);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                // Fin AD_FindFullFunctionalPoolAssignment

            } else {

                LOGGER.debug("[{}] - Viene informado el organization role ", CLASSNAME);
                LOGGER.debug("[{}] - Llamada a AD_FindOrgRoleLowLevel()", CLASSNAME);

                // Inicio AD_FindOrgRoleLowLevel

                com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT out = this
                        .invocarOP_findOrgRoleLowLevel(idOrganizationRole, te_Cabecera, te_Metadatos);

                if (out != null && out.getOrganizationRole() != null) {

                    List<com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT> listFunRol = 
                    		Arrays.asList(out.getOrganizationRole().getFunctionalRoles());

                    // Fin AD_FindOrgRoleLowLevel

                    java.util.Date fecha = new Date();
                    LOGGER.debug("Consultamos los gestores vigentes asignados a la unidad funcional "
                                    + "en la CnalpFuncPoolAssignment");

                    List<CnalpFuncPoolAssignment> listaFuncPoolAssignment = 
                    		this.consultaCnalpFuncPoolAssignment(te_Metadatos, idFunctionalPool, fecha);

                    /*
                     * validación de que hayamos obtenido una lista de gestores
                     * del AD_FindOrgRoleLowLevel para comparar
                     */
                    if (listFunRol != null && !listFunRol.isEmpty()) {
                    	
                        if (listaFuncPoolAssignment != null && !listaFuncPoolAssignment.isEmpty()) {

                            List<BigDecimal> idParoIdRoleListMatch = new ArrayList<BigDecimal>();

                            for (com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT funRoleGest : listFunRol) {
                            	
                                for (CnalpFuncPoolAssignment funPoolAs : listaFuncPoolAssignment) {

                                    LOGGER.debug(
                                            "Comparamos las dos listas por el FunctionalRole y nos quedamos con " + "los que coincidan");

                                    if (funPoolAs.getParoIdFunctionalRole().equals(funRoleGest.getId())) {
                                        // Creamos una lista de id para ir a
                                        // consultar los
                                        // buzones con todos ellos
                                        idParoIdRoleListMatch.add(idOrganizationRole);
                                        /*
                                         * De la lista de gestores
                                         * obtenida hay que eliminar los que no
                                         * coincidan y de los que coincidan
                                         * llevar los datos a la salida
                                         */
                                    }
                                }
                            }
                            // Preparamos la paginación
                            PageRequest pageCnalaTaskMailbox = new PageRequest(
                            		Integer.valueOf(te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina().toString()),
                                    Integer.valueOf(te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getTamanoVentana().toString()));

                            LOGGER.debug("[{}] - Se realiza la consulta de los buzones según los filtros");

                            Specifications<CnalaTaskMailbox> specCnalaTaskMailbox = Specifications.where(null);

                            specCnalaTaskMailbox = specCnalaTaskMailbox
                                    .and(TaskMailboxSpecifications
                                            .byTaskMailboxAndOrgRole(idParoIdRoleListMatch));
                            

                            Page<CnalaTaskMailbox> taskMailboxPage = (Page<CnalaTaskMailbox>) taskMailboxRepository
                                    .findTaskMailboxOperators(specCnalaTaskMailbox, pageCnalaTaskMailbox,  new CriteriosOrdenacion().getOrdenacion(
                                                    te_Metadatos.getTE_Ordenacion().getCriterioOrdenacions(0), "findTaskMailboxOperators"));

                            // preparo los metadatos asociados a la consulta
                            LOGGER.debug("Se informa el valor de teMetadatos.HayMas");
                            CommonUtilitiesServiceImpl.metadatosPagBasica(te_Metadatos, taskMailboxPage.getTotalElements(), taskMailboxPage.hasNext());

                            if (taskMailboxPage.getContent() != null
                                    && !taskMailboxPage.getContent().isEmpty()) {

                                LOGGER.debug("Se han encontrado [{}] registros en CnalaTaskMailbox", taskMailboxPage.getSize());

                                /*
                                 * REVISAR: Hay que unificar la lista de
                                 * gestores y de buzones por
                                 * paroIdOrganizationRole y preparar una salida
                                 * conjunta. Incluir doble bucle for para por
                                 * cada gestor recorrerse y localizar su buzón.
                                 * SOLO TENDRÁ UNO POR UNIDAD
                                 * FUNCIONAL.Asegurarse que coincide el buzón
                                 * con la funcionalPool de entrada
                                 */

                                // Recorremos la lista de buzones e informamos
                                // el
                                // DTO_OUT con dicha información
                                for (CnalaTaskMailbox cnalaTaskMailbox : taskMailboxPage) {
                                    /*
                                     * REVISAR: La validación inferior puede
                                     * incluirse de paso en la comparación por
                                     * paroIdOrganizationRole gestores y buzones
                                     * y eliminarla de aquí para hacer todas las
                                     * comparaciones juntas
                                     */

                                    if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getCnalpFunctionalPool().getWpooIdFunctionalPool().compareTo(idFunctionalPool) == 0) {
                                        listaOrganizationRoleDTOOUT.put(out.getOrganizationRole().getId(), this.montarOrganizationRole_DTO_OUT(cnalaTaskMailbox, out));
                                        //listaOrganizationRoleDTOOUT.add(this.montarOrganizationRole_DTO_OUT(cnalaTaskMailbox, out));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            findTaskMailboxOperatorsOUT.setOrganizationRoles(listaOrganizationRoleDTOOUT.values().toArray(
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT[listaOrganizationRoleDTOOUT
                            .size()]));

            LOGGER.debug("[{}] - Final del  método adFindTaskMailboxOperators", CLASSNAME);

        } catch (TE_Excepcion e) {
            throw e;
        }

        return findTaskMailboxOperatorsOUT;
    }

    /**
     * Aniadimos los filtros necesarois para la busqueda cuando SearchType es
     * false
     * 
     * @param findfullfunctionalpoolassignment_in
     * @param listSpecifications
     * @return
     */
    private Specifications<CnalpFuncPoolAssignment> aniadirParametrosChangeSearchTypeFalse(
            BigDecimal idFunctionalPool) {

        LOGGER.debug("Inicio metodo aniadirParametrosChangeSearchTypeFalse");
        Specifications<CnalpFuncPoolAssignment> listSpecifications = Specifications.where(null);

        LOGGER.debug("Se añade filtrado por > fromDate: [{}] y toDate: [{}]", new Date(),
                new Date());
        listSpecifications = listSpecifications.and(FuncionalPoolAssigmentSpecification.byRangeDate(
                null,null));

        LOGGER.debug("Se añade filtrado por FunctionalPool");
        listSpecifications = listSpecifications
                .and(FuncionalPoolAssigmentSpecification.byFunctionalPool(idFunctionalPool));

        LOGGER.debug("Fin metodo aniadirParametrosChangeSearchTypeFalse");
        return listSpecifications;
    }

    

    /**
     * MRSOPOJO Servicio que invoca a la operacion de gestores
     * FindOrganizationRole
     * 
     * @param cnalrOrgaPoolAssignment
     * @param te_Cabecera
     * @return
     * @throws TE_Excepcion
     */
    public Object invocarOP_findOrganizationRole(
            HashMap <BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN> mapDTO_IN,
            String operacionOrigen,
            TE_Cabecera te_Cabecera, 
            TE_Metadatos te_Metadatos)
                    throws TE_Excepcion {

        // • Se invoca a FindOrganizationRole informando
        // Paro_id_organization_role
        // Si no devuelve nada o da un error, se devuelve error CANA-E-000133,
        // indicando la clase OrganizationRole y sistema GESTORES
        LOGGER.debug("Inicio llamada a método invocarOP_findOrganizationRole");
        try {
            Holder<TE_Cabecera> holder_cab = new Holder<TE_Cabecera>(te_Cabecera);
            te_Metadatos.setTE_Busqueda(new TE_Busqueda());
            te_Metadatos.getTE_Ordenacion().setCriterioOrdenacions(0,
                    "AD_finOrganizationRole_configuration1_DSC");
            Holder<TE_Metadatos> holder_met = new Holder<TE_Metadatos>(CommonUtilitiesServiceImpl.crearMetadatos("", 1l, 100l));

            com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_IN findOrganizationRole = new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_IN();

            findOrganizationRole.setOrganizationRoles(mapDTO_IN.values().toArray(new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN[]{}));

            String endpoint = serviceRegistry.getEndpoint("uddi:gest.srv-exp-EngRoleExt-v3");

            com.telefonica.gest.srv.exp.engroleext.facade.EngRoleExtExpServicePortType port = new com.telefonica.gest.srv.exp.engroleext.facade.EngRoleExtExpServiceClient()
                    .getSrvExpEngRoleExtPort();

            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
            bp.getRequestContext().put("com.sun.xml.ws.connect.timeout",
                    env.getRequiredProperty("system.ws.connect.timeout", Integer.class));
            bp.getRequestContext().put("com.sun.xml.ws.request.timeout",
                    env.getRequiredProperty("system.ws.request.timeout", Integer.class));


            FindOrganizationRole_OUT out = port.findOrganizationRole(findOrganizationRole, holder_cab, holder_met);
            
            return this.mapearSalidaFindOrgRole(out, operacionOrigen);
           

        } catch (EndpointNotFoundException | TE_Excepcion e) {
            this.lanzarExcepcion("CANA_E_000133", "OrganizationRole", "GESTORES");
        }
        LOGGER.debug("Fin llamada a método invocarOP_findOrganizationRole");
        return null;
    }

    public Object mapearSalidaFindOrgRole(FindOrganizationRole_OUT out, String operacionOrigen) {
        
        if (out != null 
                && out.getOrganizationRoles() != null
                && out.getOrganizationRolesLength() > 0) {
            
            //dependiendo de la operacion retornamos un mapa u otro
            
            // OP_findtasksmailboxesmanager
             HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT> mapOrgRole_OUT_FTMBM =
                     new HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT>();
                     
             // OP_findtasksmailboxesmanager
             HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT> mapOrgRole_OUT_FFTMB =
                      new HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT>();
             
            // OP_findtasksmailboxesOperators
             HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT> mapOrgRole_OUT_FTMBO =
                               new HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT>();
                         
             for (com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT orRole_DTO_OUT : out.getOrganizationRoles()) {
                 
                 if ("findtasksmailboxesmanager".equals(operacionOrigen)) {
                     
                     com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT organizationRole_DTO_OUT = 
                             new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT();
                    
                     com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.Organization_DTO_OUT organization_DTO_OUT = 
                             new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.Organization_DTO_OUT();
                     
                     com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationName_DTO_OUT organizationName_DTO_OUT = 
                             new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationName_DTO_OUT();
                     
                     organizationName_DTO_OUT.setTradingName(this.recuperarNameOrgRole(orRole_DTO_OUT.getParty()));
                     
                     organization_DTO_OUT.setId(orRole_DTO_OUT.getParty().getId());
                     organization_DTO_OUT.setOrganizationName(organizationName_DTO_OUT);

                     organizationRole_DTO_OUT.setId(orRole_DTO_OUT.getId());
                     
                     organizationRole_DTO_OUT.setOrganization(organization_DTO_OUT);
                     
                     mapOrgRole_OUT_FTMBM.put(orRole_DTO_OUT.getId(), organizationRole_DTO_OUT);
                     
                     /*if (orRole_DTO_OUT.getValidFor() != null
                             && orRole_DTO_OUT.getValidFor().getStartDateTime() != null) {
                         
                         Date fechaActual = new Date();
                         if (orRole_DTO_OUT.getValidFor().getStartDateTime().before(fechaActual)) {
                             if (orRole_DTO_OUT.getValidFor().getEndDateTime() == null ||
                                     orRole_DTO_OUT.getValidFor().getEndDateTime().after(fechaActual)) {
                                 
                                 taskMailBox_DTO_OUT.setOrganizationRole(organizationRole);
                             }
                         }
                     }   */
                 } else if ("findfulltaskmailbox".equals(operacionOrigen)) {
                     
                     com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT organizationRole_DTO_OUT = 
                             new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT();
                    
                     com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationName_DTO_OUT organizationName_DTO_OUT = 
                             new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationName_DTO_OUT();
                     
                     organizationName_DTO_OUT.setTradingName(this.recuperarNameOrgRole(orRole_DTO_OUT.getParty()));
                     
                     organizationRole_DTO_OUT.setId(orRole_DTO_OUT.getId());
                     organizationRole_DTO_OUT.setOrganizationName(organizationName_DTO_OUT);

                     mapOrgRole_OUT_FFTMB.put(orRole_DTO_OUT.getId(), organizationRole_DTO_OUT);
                     
                 } else if ("findtaskmailboxoperators".equals(operacionOrigen)) {
                     
                     com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT organizationRole_DTO_OUT = 
                             new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT();

                     com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.IndividualName_DTO_OUT individualName_DTO_OUT =
                             new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.IndividualName_DTO_OUT();
                     
                     individualName_DTO_OUT.setFormattedName(this.recuperarNameOrgRole(orRole_DTO_OUT.getParty()));
      
                     organizationRole_DTO_OUT.setId(orRole_DTO_OUT.getId());
                     organizationRole_DTO_OUT.setCode(orRole_DTO_OUT.getCode());
                     organizationRole_DTO_OUT.setIndividualName(individualName_DTO_OUT);
                     
                     // se setea despues en la Op
                     //organizationRole_DTO_OUT.setTaskMailbox(value);
                     mapOrgRole_OUT_FTMBO.put(orRole_DTO_OUT.getId(), organizationRole_DTO_OUT);
                 }
                 
             } // fin for

             if ("findtasksmailboxesmanager".equals(operacionOrigen)) {
                 return mapOrgRole_OUT_FTMBM;
             } else if ("findfulltaskmailbox".equals(operacionOrigen)) {
                 return mapOrgRole_OUT_FFTMB;
             } else if ("findtaskmailboxoperators".equals(operacionOrigen)) {
                 return mapOrgRole_OUT_FTMBO;
             }
        }
        
        return null;
    }

    private String recuperarNameOrgRole(com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.Party_DTO_OUT party) {
        
        if (!StringUtils.isBlank(party.getMachineNameModelName())) {
            return party.getMachineNameModelName();
        } else if (!StringUtils.isBlank(party.getOrganizationNameTradingName())) {
            return party.getOrganizationNameTradingName();
        } else if (!StringUtils.isBlank(party.getIndividualNameFormattedName())) {
            return party.getIndividualNameFormattedName();
        }
        return null;
    }

    /**
     * MRSOPOJO Servicio que invoca a la operacion de gestores
     * AD_FindOrgRoleLowLevel
     * 
     * @param cnalrOrgaPoolAssignment
     * @param te_Cabecera
     * @return
     * @throws TE_Excepcion
     */
    public com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT invocarOP_findOrgRoleLowLevel(
            BigDecimal idOrgRole, TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos)
                    throws TE_Excepcion {

        // • Se invoca a FindOrgRoleLowLevel informando
        // Paro_id_organization_role
        // Si no devuelve nada o da un error, se devuelve error CANA-E-000133,
        // indicando la clase OrganizationRole y sistema GESTORES
    	
        LOGGER.debug("Inicio llamada a método invocarOP_findOrgRoleLowLevel");

        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT out = null;
        
        try {
            Holder<TE_Cabecera> holder_cab = new Holder<TE_Cabecera>(te_Cabecera);
            Holder<TE_Metadatos> holder_met = new Holder<TE_Metadatos>(CommonUtilitiesServiceImpl.crearMetadatos("", 1l, 100l));

            // Obtenemos el endPoint del Service
            String endpoint = serviceRegistry.getEndpoint("uddi:gest.srv-exp-EngRoleExt-v3");

            // Añadimos los parámetros de entrada
            com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_IN in = 
            		new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_IN();

            in.setValidity("V");
            in.setLevel(0L);

            List<com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.EngagedRoleSpec_DTO_IN> listEngRole = 
            		new ArrayList<com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.EngagedRoleSpec_DTO_IN>();
            listEngRole.add(
                    new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.EngagedRoleSpec_DTO_IN());
            listEngRole.get(0).setId(106L);
            in.setEngagedRoleSpecs(listEngRole.toArray(
                    new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.EngagedRoleSpec_DTO_IN[listEngRole
                            .size()]));

            in.setOrganizationRole(
                    new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.OrganizationRole_DTO_IN());
            in.getOrganizationRole().setId(idOrgRole);

            com.telefonica.gest.srv.exp.engroleext.facade.EngRoleExtExpServicePortType port =
            		new com.telefonica.gest.srv.exp.engroleext.facade.EngRoleExtExpServiceClient().getSrvExpEngRoleExtPort();

            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
			bp.getRequestContext().put("com.sun.xml.ws.connect.timeout",
					env.getRequiredProperty("system.ws.connect.timeout", Integer.class));
			bp.getRequestContext().put("com.sun.xml.ws.request.timeout",
					env.getRequiredProperty("system.ws.request.timeout", Integer.class));


            // Llamada al servicio
            out = port.findOrgRoleLowLevel(in, holder_cab, holder_met);

        } catch (EndpointNotFoundException | TE_Excepcion e) {
            this.lanzarExcepcion("CANA_E_000133", "OrganizationRole", "GESTORES");
        }
        LOGGER.debug("Fin llamada a método invocarOP_findOrganizationRole");
        return out;
    }

    /**
     * Método encargado de lanzar una excepción con un código y un parámetro
     * pasado.
     * 
     * @param codigoExcepcion
     *            código de la excepción.
     * @param parametro
     *            parámetro.
     * @throws TE_Excepcion
     */
    private void lanzarExcepcion(String codigoExcepcion, String... parametros) throws TE_Excepcion {

        LOGGER.debug("Inicio del método lanzarExcepcion");
        LOGGER.debug("Se lanzará la excepción con código: " + codigoExcepcion);

        if (parametros != null && parametros.length > 0) {
            LOGGER.debug("Se lanzará la excepción con los parametros: " + parametros);
            throw new TE_Excepcion(this.getMessagebyIdioma(null, codigoExcepcion, null),
                    this.getMessagebyIdioma(null, codigoExcepcion + "_MSG", parametros), null, ErrorType.F);
        } else {
            throw new TE_Excepcion(this.getMessagebyIdioma(null, codigoExcepcion, null),
                    this.getMessagebyIdioma(null, codigoExcepcion + "_MSG", null), null, ErrorType.F);
        }
    }

    /**
     * Metodo que monta el OrganizationRole_DTO_OUT que se añade a la lista de
     * salida de la capacidad
     * 
     * @param cnalaTaskMailbox
     * @param out 
     * @param idiomaDefecto
     * @param lenguaje
     * @return
     * @throws TE_Excepcion 
     */
    private com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT montarOrganizationRole_DTO_OUT(
            CnalaTaskMailbox cnalaTaskMailbox, FindOrgRoleLowLevel_OUT out) throws TE_Excepcion {

        LOGGER.debug("[{}] - Inicio del  método montarOrganizationRole_DTO_OUT", CLASSNAME);


        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT organizationRoleDtoOut = 
        new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT();

        // organizationRoleDtoOut.code
        organizationRoleDtoOut.setCode(out.getOrganizationRole().getCode());
        // organizationRoleDtoOut.id
        organizationRoleDtoOut.setId(out.getOrganizationRole().getId());
        // organizationRoleDtoOut.individualNameDtoOut

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.IndividualName_DTO_OUT individualNameDtoOut = 
        		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.IndividualName_DTO_OUT();
        individualNameDtoOut.setFormattedName("formattedName");

        organizationRoleDtoOut.setIndividualName(individualNameDtoOut);
        // organizationRoleDtoOut.taskMailboxDtoOut
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.TaskMailbox_DTO_OUT taskMailboxDtoOut = 
        		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.TaskMailbox_DTO_OUT();
        taskMailboxDtoOut.setId(cnalaTaskMailbox.getMboxIdMailbox());

        // organizationRoleDtoOut.mailboxAccessDtoOut. Solo vendrá 1 y es
        // obligatorio
        if (cnalaTaskMailbox.getGewfrMailboxAccesses() != null
                && !cnalaTaskMailbox.getGewfrMailboxAccesses().isEmpty()) {

            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.MailboxAccess_DTO_OUT mailboxAccessDtoOut = 
            		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.MailboxAccess_DTO_OUT();

            mailboxAccessDtoOut.setMailboxAccess(
                    cnalaTaskMailbox.getGewfrMailboxAccesses().get(0).getMaacInMailboxAccess());
            mailboxAccessDtoOut.setMailboxResponsible(cnalaTaskMailbox.getGewfrMailboxAccesses()
                    .get(0).getMaacInMailboxResponsible());
            taskMailboxDtoOut.setMailboxAccess(mailboxAccessDtoOut);
        }
        
        // SLB5 - Nuevos campos
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.Application_DTO_OUT application_DTO_OUT =
        		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.Application_DTO_OUT();
        application_DTO_OUT.setId(cnalaTaskMailbox.getGenaIdApplication());
        taskMailboxDtoOut.setApplication(application_DTO_OUT);
        taskMailboxDtoOut.setDistributionMode((cnalaTaskMailbox.getMboxInDistributionMode() != null) ? cnalaTaskMailbox.getMboxInDistributionMode().toString() : null);
        taskMailboxDtoOut.setGroupDistributionCriteria((cnalaTaskMailbox.getMboxInGroupDistribCriteria() != null) ? cnalaTaskMailbox.getMboxInGroupDistribCriteria().toString() : null);
        taskMailboxDtoOut.setManualDistributionMode((cnalaTaskMailbox.getMboxInManualDistribMode() != null) ? cnalaTaskMailbox.getMboxInManualDistribMode().toString() : null);

        organizationRoleDtoOut.setTaskMailbox(taskMailboxDtoOut);

        LOGGER.debug("[{}] - Fin del  método montarOrganizationRole_DTO_OUT", CLASSNAME);
        return organizationRoleDtoOut;
    }

    /**
     * Método que consulta los gestores vigentes asignados a la unidad funcional
     * 
     * @param te_Metadatos
     * @param idFunctionalPool
     * @param fecha
     * @return
     */
    private List<CnalpFuncPoolAssignment> consultaCnalpFuncPoolAssignment(TE_Metadatos te_Metadatos,
            BigDecimal idFunctionalPool, java.util.Date fecha) {

        LOGGER.debug("Inicio del método consultaCnalpFuncPoolAssignment", CLASSNAME);

        LOGGER.debug("Se añade filtrado por functionalPoolId: [{}], y fecha: [{}]",
                idFunctionalPool, fecha);

        List<CnalpFuncPoolAssignment> listaFuncPoolAssignment = new ArrayList<CnalpFuncPoolAssignment>();

        // lista de specificacions asociadas a los campos de filtrado
        Specifications<CnalpFuncPoolAssignment> specCnalpFuncPoolAssignment = Specifications
                .where(null);

        specCnalpFuncPoolAssignment = specCnalpFuncPoolAssignment
                .and(FuncPoolAssignmentSpecifications.byFunctionalPoolVig(idFunctionalPool,
                        new java.sql.Date(fecha.getTime())));

        Integer tamanoVentFuncPoolAssignment = 500;

        // tratamiento de los datos de ordenación llamada
        PageRequest pageFuncPoolAssignment = new PageRequest(Integer.valueOf(
                te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina().toString()),
                tamanoVentFuncPoolAssignment);

        int numPage = 0;
        for (int i = 0; i <= numPage; i++) {

            Page<CnalpFuncPoolAssignment> pageCnalpFuncPoolAssignment = null;

            if (i > 0) {
                pageFuncPoolAssignment = (PageRequest) pageFuncPoolAssignment.next();
            }

            pageCnalpFuncPoolAssignment = (Page<CnalpFuncPoolAssignment>) cnalpFuncPoolAssignmentRepository
                    .findTaskMailboxOperators(specCnalpFuncPoolAssignment,
                            (Pageable) pageFuncPoolAssignment,
                            new Sort.Order(Direction.ASC, "fpasIdFuncPoolAssignment"));

            numPage = pageCnalpFuncPoolAssignment.getTotalPages();
            listaFuncPoolAssignment
                    .addAll(IteratorUtils.toList(pageCnalpFuncPoolAssignment.iterator()));

        }

        LOGGER.debug("Fin del método consultaCnalpFuncPoolAssignment", CLASSNAME);
        LOGGER.debug("Se han encontrado [{}] registros", listaFuncPoolAssignment.size());

        return listaFuncPoolAssignment;
    }

    /**
     * @author MRTEGOFJ
     * @param findtasksmailboxesmanager_in
     * @param te_Cabecera
     * @param te_Metadatos
     * @return
     */
    @PageMetadataRequired(maxPageSize = 200)
    public FindTasksMailBoxesManager_OUT findTasksMailBoxesManager(
            FindTasksMailBoxesManager_IN findtasksmailboxesmanager_in, TE_Cabecera te_Cabecera,
            TE_Metadatos te_Metadatos) throws TE_Excepcion {
    	
        LOGGER.debug("Comienzo del metodo findTasksMailBoxesManager");

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.FindTasksMailBoxesManager_OUT findTasksMailBoxesManager_OUT = 
        		new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.FindTasksMailBoxesManager_OUT();

        try {
            // Ordenacion
            new com.telefonica.tran.comarq.cc.paginacion.validator.OrderMetadataValidator()
                    .validate(te_Metadatos, false,
                            new com.telefonica.cana.srv.nuc.taskmailbox.service.ext.CriteriosOrdenacion()
                                    .getCriteriosOrdenacions("findTasksMailBoxesManager"));

        } catch (TE_Excepcion e) {
            TE_Ordenacion value = new TE_Ordenacion();
            String[] s = { "AD_findTasksMailBoxesManager_configuracion1_ASC" };
            value.setCriterioOrdenacions(s);
            te_Metadatos.setTE_Ordenacion(value);
        }

        try {
            // Paginacion
            new com.telefonica.tran.comarq.cc.paginacion.validator.PageMetadataValidator()
                    .validate(te_Metadatos, false, 200L);

            Long paginacion = 0L;
            try {
                if (te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina() != 0) {
                   paginacion = te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getNumeroPagina()-1;
                }
            } catch (NullPointerException e) {
                paginacion = 0L;
            }                


            PageRequest pagerequest = new PageRequest(
                    Integer.valueOf(paginacion.toString()),
                    Integer.valueOf(te_Metadatos.getTE_Paginacion().getTE_PaginacionIN().getTamanoVentana().toString()),
                    new Sort(new CriteriosOrdenacion().getOrdenacion(
                            te_Metadatos.getTE_Ordenacion().getCriterioOrdenacions(0),
                            "findTasksMailBoxesManager"))
                    );

            GetFunctionalRole_OUT getFunctionalRole_OUT = new GetFunctionalRole_OUT();
            
            try {
            	getFunctionalRole_OUT =
            			this.llamadaGetFunctionalRole(
            			        findtasksmailboxesmanager_in.getOrganizationRole().getId(), 
            			        te_Cabecera, 
            			        te_Metadatos);
            			
			} catch (TE_Excepcion e) {
				throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000133", null),
	                    this.getMessagebyIdioma(null, "CANA_E_000133_MSG",
	                            new String[] { "FunctionalRole", "GESTORES" }), null, ErrorType.F);
			}
            
            if (getFunctionalRole_OUT != null 
            		&& getFunctionalRole_OUT.getFunctionalRoles() != null
            		&& getFunctionalRole_OUT.getFunctionalRolesLength() > 0) {
            	
            	// Consulta
                // recuperamos los ID

                HashMap <BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT> mapParoIdFunctionalRole =
                        new HashMap <BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT>();
                
                for (com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole
                        .FunctionalRole_DTO_OUT fun_Role: getFunctionalRole_OUT.getFunctionalRoles()) {

                    mapParoIdFunctionalRole.put(fun_Role.getId(), fun_Role);

                }

                Page <CnalaTaskMailbox> sliceCnalaTaskMailBox = 
                        (Page<CnalaTaskMailbox>) taskMailboxRepository
                        .findTasksMailboxesManagerbyListIdFuncRole(Arrays.asList(mapParoIdFunctionalRole.keySet().toArray(new BigDecimal[]{})), pagerequest);

                CommonUtilitiesServiceImpl.metadatosPagBasica(te_Metadatos, sliceCnalaTaskMailBox.getTotalElements(), sliceCnalaTaskMailBox.hasNext());
                
                if (sliceCnalaTaskMailBox != null 
                        && sliceCnalaTaskMailBox.getContent() != null 
                        && !sliceCnalaTaskMailBox.getContent().isEmpty()) {
                    
                    HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.TaskMailbox_DTO_OUT> listTaskMailBox = 
                            this.montarSalidaFindTaskMailBoxManager(
                                    sliceCnalaTaskMailBox.getContent(),
                                    mapParoIdFunctionalRole, 
                                    te_Cabecera, 
                                    te_Metadatos);
                    
                    findTasksMailBoxesManager_OUT.setTaskMailboxes(listTaskMailBox.values().toArray(
                            new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.TaskMailbox_DTO_OUT[listTaskMailBox
                                    .size()]));
                }

            } else {
            	throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000133", null),
	                    this.getMessagebyIdioma(null, "CANA_E_000133_MSG",
	                            new String[] { "FunctionalRole", "GESTORES" }), null, ErrorType.F);
            }

            
        } catch (TE_Excepcion e) {
            throw e;
        }

        return findTasksMailBoxesManager_OUT;

    }
    
	public FindOrganizationRole_OUT llamadaFindOrganizationRole_objetoSalida(
			FindOrganizationRole_IN findOrganizationRole_IN, Holder<TE_Cabecera> holderCabecera,
			Holder<TE_Metadatos> holderMetadatos) throws TE_Excepcion {
		
		String endpoint = serviceRegistry.getEndpoint("uddi:gest.srv-exp-EngRoleExt-v3");
		
		com.telefonica.gest.srv.exp.engroleext.facade.EngRoleExtExpServicePortType port = 
				new com.telefonica.gest.srv.exp.engroleext.facade.EngRoleExtExpServiceClient().getSrvExpEngRoleExtPort();
		BindingProvider bindingProvider = (BindingProvider) port;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
		bindingProvider.getRequestContext().put("com.sun.xml.ws.connect.timeout",
				env.getRequiredProperty("system.ws.connect.timeout", Integer.class));
		bindingProvider.getRequestContext().put("com.sun.xml.ws.request.timeout",
				env.getRequiredProperty("system.ws.request.timeout", Integer.class));

		
		return port.findOrganizationRole(findOrganizationRole_IN, holderCabecera, holderMetadatos);
	}
    
	private GetFunctionalRole_OUT llamadaGetFunctionalRole(
			BigDecimal id, TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion {

		LOGGER.debug("inicio del método llamadaGetFunctionalRole");
        
		GetFunctionalRole_IN getFunctionalRole_IN = new GetFunctionalRole_IN();
		
		com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.OrganizationRole_DTO_IN organizationRole_DTO_IN =
				new com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.OrganizationRole_DTO_IN();
		organizationRole_DTO_IN.setId(id);
		getFunctionalRole_IN.setOrganizationRole(organizationRole_DTO_IN);
		getFunctionalRole_IN.setValidity("V");
		
		Holder<TE_Cabecera> holderCabecera = new Holder<TE_Cabecera>(te_Cabecera);
		
		holderCabecera.value.setFechaPeticion(new Date());
		
		te_Metadatos = CommonUtilitiesServiceImpl.crearMetadatos(
                te_Metadatos.getTE_Ordenacion().getCriterioOrdenacions()[0], 1L, 1000L);

		Holder<TE_Metadatos> holderMetadatos = new Holder<TE_Metadatos>(te_Metadatos);

		LOGGER.debug("Llamada a llamadaGetFunctionalRole");
		
		GetFunctionalRole_OUT getFunctionalRole_OUT = 
				this.llamadaGetFunctionalRole_objetoSalida(
				        getFunctionalRole_IN, 
				        holderCabecera,
				        holderMetadatos);
		
		return getFunctionalRole_OUT;
	}
	
	
	public GetFunctionalRole_OUT llamadaGetFunctionalRole_objetoSalida(
			GetFunctionalRole_IN getFunctionalRole_IN, Holder<TE_Cabecera> holderCabecera,
			Holder<TE_Metadatos> holderMetadatos) throws TE_Excepcion {
		
		String endpoint = serviceRegistry.getEndpoint("uddi:gest.srv-exp-EngRoleExt-v3");
		
		com.telefonica.gest.srv.exp.engroleext.facade.EngRoleExtExpServicePortType port = 
				new com.telefonica.gest.srv.exp.engroleext.facade.EngRoleExtExpServiceClient().getSrvExpEngRoleExtPort();
		BindingProvider bindingProvider = (BindingProvider) port;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
		bindingProvider.getRequestContext().put("com.sun.xml.ws.connect.timeout",
				env.getRequiredProperty("system.ws.connect.timeout", Integer.class));
		bindingProvider.getRequestContext().put("com.sun.xml.ws.request.timeout",
				env.getRequiredProperty("system.ws.request.timeout", Integer.class));

		
		return port.getFunctionalRole(getFunctionalRole_IN, holderCabecera, holderMetadatos);
	}


    /**
     * Metodo para eliminar repetidos
     * 
     * @param listadoWS
     * @return
     */
    private List<CnalpFuncPoolAssignment> distincRepetidos1(
            List<CnalpFuncPoolAssignment> listadoWS) {

        HashMap <BigDecimal, CnalpFuncPoolAssignment> lstWSfAux = new  HashMap <BigDecimal, CnalpFuncPoolAssignment>();
        List <CnalpFuncPoolAssignment> aux  = new ArrayList<CnalpFuncPoolAssignment>(); 
        for (CnalpFuncPoolAssignment cnalpFuncPoolAssignment : listadoWS) {
           if (lstWSfAux.get(cnalpFuncPoolAssignment.getFpasIdFuncPoolAssignment()) == null) {
               lstWSfAux.put(cnalpFuncPoolAssignment.getFpasIdFuncPoolAssignment(), cnalpFuncPoolAssignment);
               aux.add(cnalpFuncPoolAssignment);
           }
        }
        return aux;
    }

    /**
     * @author MRTEGOFJ
     * @param SliceCnalaTaskMailBox
     * @param te_Cabecera
     * @return
     * @throws TE_Excepcion 
     */
    private  HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.TaskMailbox_DTO_OUT> montarSalidaFindTaskMailBoxManager(
            List<CnalaTaskMailbox> listCnalaTaskMailBox, 
            HashMap <BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT> mapParoIdFunctionalRole,
            TE_Cabecera te_Cabecera, 
            TE_Metadatos te_Metadatos) throws TE_Excepcion {

        HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.TaskMailbox_DTO_OUT> listTaskMailBox =
                new HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.TaskMailbox_DTO_OUT>();

                
        //recuperamos los ajenos primero invocarOP_findOrganizationRole
        HashMap <BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN> mapOrgRole_IN = 
                new HashMap <BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN>();
        
        HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT> mapOrgRole_OUT =
                new HashMap <BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT>();             
        
        for (CnalaTaskMailbox cnalaTaskMailBox : listCnalaTaskMailBox) {
            if (cnalaTaskMailBox.getCnalrOrgaPoolAssignment1() != null
                    && cnalaTaskMailBox.getCnalrOrgaPoolAssignment1().getParoIdOrganizationRole() != null) {
                
                com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                        new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN();
                organizationRole_DTO_IN.setId(cnalaTaskMailBox.getCnalrOrgaPoolAssignment1().getParoIdOrganizationRole());
                mapOrgRole_IN.put(cnalaTaskMailBox.getCnalrOrgaPoolAssignment1().getParoIdOrganizationRole(), organizationRole_DTO_IN);
            }
        }        
        
        if (!mapOrgRole_IN.isEmpty()) {
            mapOrgRole_OUT = 
                    (HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT>) 
                    this.invocarOP_findOrganizationRole(
                            mapOrgRole_IN,
                            "findtasksmailboxesmanager",
                            te_Cabecera,
                            te_Metadatos);
        }
          
        for (CnalaTaskMailbox cnalaTaskMailBox : listCnalaTaskMailBox) {
            
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.TaskMailbox_DTO_OUT taskMailBox_DTO_OUT = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.TaskMailbox_DTO_OUT();
            // taskMailBox
            taskMailBox_DTO_OUT.setId(cnalaTaskMailBox.getMboxIdMailbox());

            String name = this.comprobarIdiomaNameTaskMailBox(te_Cabecera, cnalaTaskMailBox);
            taskMailBox_DTO_OUT.setName(name);

            taskMailBox_DTO_OUT.setCode(cnalaTaskMailBox.getMboxCoFuncMailbox());
            // functionalPool
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.FunctionalPool_DTO_OUT functionalPool_DTO_OUT = 
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.FunctionalPool_DTO_OUT();

            functionalPool_DTO_OUT
                    .setId(cnalaTaskMailBox.getCnalpFunctionalPool().getWpooIdFunctionalPool());
            String description = this.comprobarIdiomaDsFuncPool(te_Cabecera, cnalaTaskMailBox);
            functionalPool_DTO_OUT.setDescription(description);
            taskMailBox_DTO_OUT.setFunctionalPool(functionalPool_DTO_OUT);
            // mailBoxAcces
                    
            // CAMBIO tras el cambio de IÑIGo, tengo que quedarme con el acceso mas favorable
            BigDecimal id = null;
            Boolean acceso = null;
            Boolean responsable = null;
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.MailboxAccess_DTO_OUT mailBoxAccess_DTO_OUT = 
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.MailboxAccess_DTO_OUT();    
              
            for (GewfrMailboxAccess gewfrMailBoxAcces : cnalaTaskMailBox.getGewfrMailboxAccesses()) {
                
                // MMROGAJM si el paro_orgRole del acceso no esta en el map de functionalRole obtenido getFunctionalRole, lo ignoramos:
                if (mapParoIdFunctionalRole.get(gewfrMailBoxAcces.getParoIdFunctionalRole()) != null) {
                 // si es la primera vuelta informamos los valores
                    if (id == null) {
                        id = gewfrMailBoxAcces.getMaacIdMailboxAccess();
                        acceso = gewfrMailBoxAcces.getMaacInMailboxAccess();
                        responsable = gewfrMailBoxAcces.getMaacInMailboxResponsible();
                    } else {
                        // se inician las comprobaciones
                        
                        // si ya exite, me quedo con los datos del acceso mas favorable.
                        // accesso
                        
                        // si el que tratanamos tiene true true no tiene sentido hacer nada
                        if (!acceso && !responsable) {
                            
                            // en el momento que el acceso que trato tenga acceso o sea repsonsable, ya tiene prioridad sobre le antiguo
                            if (gewfrMailBoxAcces.getMaacInMailboxAccess() || gewfrMailBoxAcces.getMaacInMailboxResponsible()) {
                                id = gewfrMailBoxAcces.getMaacIdMailboxAccess();
                                acceso = gewfrMailBoxAcces.getMaacInMailboxAccess();
                                responsable = gewfrMailBoxAcces.getMaacInMailboxResponsible();
                            } 
                        } else {
                            
                            if (acceso && !responsable) {
                                if (gewfrMailBoxAcces.getMaacInMailboxAccess() && gewfrMailBoxAcces.getMaacInMailboxResponsible()) {
                                    id = gewfrMailBoxAcces.getMaacIdMailboxAccess();
                                    acceso = gewfrMailBoxAcces.getMaacInMailboxAccess();
                                    responsable = gewfrMailBoxAcces.getMaacInMailboxResponsible();    
                                }
                            }
                            
                            if (!acceso && responsable) {
                                if (gewfrMailBoxAcces.getMaacInMailboxAccess()) {
                                    id = gewfrMailBoxAcces.getMaacIdMailboxAccess();
                                    acceso = gewfrMailBoxAcces.getMaacInMailboxAccess();
                                    responsable = gewfrMailBoxAcces.getMaacInMailboxResponsible();    
                                }
                            }
                        }
                    }
                }
            }
            mailBoxAccess_DTO_OUT.setId(id);
            mailBoxAccess_DTO_OUT.setMailboxAccess(acceso);
            mailBoxAccess_DTO_OUT.setMailboxResponsible(responsable);
            
            taskMailBox_DTO_OUT.setMailboxAccess(mailBoxAccess_DTO_OUT);

            if (cnalaTaskMailBox.getCnalrOrgaPoolAssignment1() != null
                    && cnalaTaskMailBox.getCnalrOrgaPoolAssignment1() .getParoIdOrganizationRole() != null
                    && mapOrgRole_OUT.get(cnalaTaskMailBox.getCnalrOrgaPoolAssignment1() .getParoIdOrganizationRole()) != null) {

                taskMailBox_DTO_OUT.setOrganizationRole(mapOrgRole_OUT.get(cnalaTaskMailBox.getCnalrOrgaPoolAssignment1() .getParoIdOrganizationRole()));
            }
            
            listTaskMailBox.put(cnalaTaskMailBox.getMboxIdMailbox(), taskMailBox_DTO_OUT);
   
        }

        return listTaskMailBox;
    }

    private String comprobarIdiomaNameTaskMailBox(TE_Cabecera te_Cabecera,
            CnalaTaskMailbox cnalaTaskMailBox) {
        String idiomaDefecto = languageService.getIdiomaPorDefecto();
        String name = new String();
        if (!te_Cabecera.getLenguaje().equals(idiomaDefecto)) {
            if (!cnalaTaskMailBox.getCnalrTaskMailboxLs().isEmpty()) {
                java.util.Iterator<com.telefonica.cana.model.CnalrTaskMailboxL> iter = cnalaTaskMailBox
                        .getCnalrTaskMailboxLs().listIterator();
                while (iter.hasNext()) {
                    CnalrTaskMailboxL cnalrTaskMailboxL = iter.next();
                    if (te_Cabecera.getLenguaje()
                            .equals(cnalrTaskMailboxL.getLangCoLanguage().toString())) {
                        name = cnalrTaskMailboxL.getLboxNaMailbox();

                        return name;
                    } else {
                        name = cnalaTaskMailBox.getLboxNaMailbox();
                    }
                }
            } else {
                name = cnalaTaskMailBox.getLboxNaMailbox();

            }

        } else {
            name = cnalaTaskMailBox.getLboxNaMailbox();

        }

        return name;
    }

    private String comprobarIdiomaDsFuncPool(TE_Cabecera te_Cabecera,
            CnalaTaskMailbox cnalaTaskMailBox) {
        String idiomaDefecto = languageService.getIdiomaPorDefecto();
        String description = new String();
        if (!te_Cabecera.getLenguaje().equals(idiomaDefecto)) {
            if (!cnalaTaskMailBox.getCnalpFunctionalPool().getCnalrFunctionalPoolLs().isEmpty()) {
                java.util.Iterator<com.telefonica.cana.model.CnalrFunctionalPoolL> iter = cnalaTaskMailBox
                        .getCnalpFunctionalPool().getCnalrFunctionalPoolLs().listIterator();
                while (iter.hasNext()) {
                    CnalrFunctionalPoolL cnalrFunctionalPoolL = iter.next();
                    if (te_Cabecera.getLenguaje()
                            .equals(cnalrFunctionalPoolL.getLangCoLanguage().toString())) {
                        description = cnalrFunctionalPoolL.getLfpoDsFunctionalPool();

                        return description;
                    } else {
                        description = cnalaTaskMailBox.getCnalpFunctionalPool()
                                .getLfpoDsFunctionalPool();
                    }
                }
            } else {
                description = cnalaTaskMailBox.getCnalpFunctionalPool().getLfpoDsFunctionalPool();

            }

        } else {
            description = cnalaTaskMailBox.getCnalpFunctionalPool().getLfpoDsFunctionalPool();

        }

        return description;
    }
    
    

    /**
     * La operación OP_getFunctionalTaskMailbox recupera el listado de buzones
     * asociados a las áreas funcionales de la propuesta de negocio.
     * 
     * @author MRROGAJM
     * @param getfunctionaltaskmailbox_in
     *            GetFunctionalTaskMailbox_IN DTO entrada
     * @param te_Cabecera
     *            TE_Cabecera Contenedor datos sesión
     * @param te_Metadatos
     *            te_Metadatos Contenedor datos paginación y ordenación
     * @return GetFunctionalTaskMailbox_OUT
     */
    public GetFunctionalTaskMailbox_OUT getFunctionalTaskMailbox(
            GetFunctionalTaskMailbox_IN getfunctionaltaskmailbox_in, TE_Cabecera te_Cabecera,
            TE_Metadatos te_Metadatos) throws TE_Excepcion {

        GetFunctionalTaskMailbox_OUT getFunctionalTaskMailbox_OUT = new GetFunctionalTaskMailbox_OUT();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.SalesChannelProposal_DTO_OUT salesChannelProposal_DTO_OUT = new com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.SalesChannelProposal_DTO_OUT();
        /*
         * Para ello esta operación lo primero que debe realizar es una consulta
         * a base de datos a través del método findFunctionalTaskMailbox del
         * DAO_SalesChannelProposal para traerse toda la información que va a
         * ser necesaria para construir la salida de la operación. Esta
         * información contiene la propuesta de negocio (SalesChannelProposal),
         * el estado de esta propuesta (CecaaChanAdeqStateMov), las áreas
         * funcionales afectas en la propuesta (FunctionalArea) junto con su
         * viabilidad (PlanificationWorkflow) y los buzones asociados a las
         * áreas funcionales (TaskMailbox).
         */

        // recuperar salesChannelProposal
        ScprpSalesChannelProposal salesChannelProposal = scprpSalesChannelProposalRepository
                .findFunctionalTaskMailbox(
                        getfunctionaltaskmailbox_in.getSalesChannelProposal().getId());

        if (salesChannelProposal == null) {
            LOGGER.debug("[{}] - No se encontró ScprpSalesChannelProposal en la BBDD", CLASSNAME);
            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                    this.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                            new String[] { ScprpSalesChannelProposal.class.getName() }), null, ErrorType.F);
        }

        salesChannelProposal_DTO_OUT.setId(salesChannelProposal.getBuinIdSalesChannelProposal());
        // Se recupera el estado de la solicitud.

        // Estado igual a “Diseño de solución”.
        /*if (ET_ChannelAdecuacyState.DESARROLLO_SOLUCION.getIdStatus()
                .compareTo(salesChannelProposal.getCecaaChanAdeqStateMovs().get(0)
                        .getCecarChanAdeqStateRel().getCecadChannelAdequacyState()
                        .getBistIdChannelAdequacyState()) == 0
                || ET_ChannelAdecuacyState.EN_AN_VILIABILIDAD.getIdStatus()
                        .compareTo(salesChannelProposal.getCecaaChanAdeqStateMovs().get(0)
                                .getCecarChanAdeqStateRel().getCecadChannelAdequacyState()
                                .getBistIdChannelAdequacyState()) == 0) {
            LOGGER.debug("[{}] - Estado es Desarrollo Solucion ó Analisis viabilidad ", CLASSNAME);
            this.recuperarBuzones(salesChannelProposal_DTO_OUT, salesChannelProposal);
        }*/

        this.recuperarBuzones(salesChannelProposal_DTO_OUT, salesChannelProposal);
        
        getFunctionalTaskMailbox_OUT.setSalesChannelProposal(salesChannelProposal_DTO_OUT);
        return getFunctionalTaskMailbox_OUT;

    }

    /**
     * Método encargado de recuperar los buzones de una Propuesta de negocio
     * 
     * @author MRROGAJM
     * @param salesChannelProposal_DTO_OUT
     * @param salesChannelProposal
     * @throws TE_Excepcion
     */
    private void recuperarBuzones(SalesChannelProposal_DTO_OUT salesChannelProposal_DTO_OUT,
            ScprpSalesChannelProposal salesChannelProposal) throws TE_Excepcion {

        List<com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT> listaPlaWorFlow = new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT>();

        for (ScpraChannelProposalRole scpraChannelProposalRole : salesChannelProposal
                .getScpraChannelProposalRoles()) {
        	
            LOGGER.debug("[{}] - Se encuentra ScpraChannelProposalRole asociado "
                    + "a ScprpSalesChannelProposal", CLASSNAME);
            for (ScprrPlanificationWorkflow scprrPlanificationWorkflow : scpraChannelProposalRole
                    .getScprrPlanificationWorkflows()) {

                LOGGER.debug("[{}] - Se encuentra ScprrPlanificationWorkflow asociado "
                        + "a ScpraChannelProposalRole", CLASSNAME);

                com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT planificationWorkflow_DTO_OUT = new com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT();
                // id
                planificationWorkflow_DTO_OUT
                        .setId(scprrPlanificationWorkflow.getPlanIdPlanificationWorkflow());
                // proposalReady
                planificationWorkflow_DTO_OUT
                        .setProposalReady(scprrPlanificationWorkflow.getPlanInProposalReady());
                // viability
                // Modificacion 03/10 viability = ScprrPlanificationWorkflow.planInViability
                if (scprrPlanificationWorkflow.getPlanInViability() != null)
                    planificationWorkflow_DTO_OUT
                        .setViability(scprrPlanificationWorkflow.getPlanInViability().toString());

                // buzones
	                com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.TaskMailbox_DTO_OUT taskMailbox_DTO_OUT = 
	                		new com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.TaskMailbox_DTO_OUT();
	
	                // taskMailbox.id
	                taskMailbox_DTO_OUT
	                        .setId(scprrPlanificationWorkflow.getCnalaTaskMailbox().getMboxIdMailbox());
	
	                // taskMailbox.code
	                taskMailbox_DTO_OUT.setCode(
	                        scprrPlanificationWorkflow.getCnalaTaskMailbox().getMboxCoFuncMailbox());
	
	                // dependiendo dle estado y la viabilidad y se añade o no el
	                // taskmailBox
	//                if (ET_ChannelAdecuacyState.DESARROLLO_SOLUCION.getIdStatus()
	//                        .compareTo(salesChannelProposal.getCecaaChanAdeqStateMovs().get(0)
	//                                .getCecarChanAdeqStateRel().getCecadChannelAdequacyState()
	//                                .getBistIdChannelAdequacyState()) == 0) {
	//                    // si estado en solucion, se añaden todos los buzones
	//                    planificationWorkflow_DTO_OUT.setTaskMailbox(taskMailbox_DTO_OUT);
	//                }
	
	                // si estado en analisis viabilidad, se añaden todos los buzones
	                /*
	                 * , si el check de viabilidad del área funcional es 1 (1
	                 * viable, 0 inviable. Campo planInViability), añadiremos el
	                 * buzón asociado
	                 */
	                // Modificacion 03/10 viable == 1 o viable es nulo
	//                if (ET_ChannelAdecuacyState.EN_AN_VILIABILIDAD.getIdStatus()
	//                        .compareTo(salesChannelProposal.getCecaaChanAdeqStateMovs().get(0)
	//                                .getCecarChanAdeqStateRel().getCecadChannelAdequacyState()
	//                                .getBistIdChannelAdequacyState()) == 0
	//                        && (scprrPlanificationWorkflow.getPlanInViability() == null || (scprrPlanificationWorkflow.getPlanInViability() != null && scprrPlanificationWorkflow.getPlanInViability().equals(1L)))) {
	//                    planificationWorkflow_DTO_OUT.setTaskMailbox(taskMailbox_DTO_OUT);
	//                }
	                planificationWorkflow_DTO_OUT.setTaskMailbox(taskMailbox_DTO_OUT);
                
	                if (ET_ChannelAdecuacyState.EN_AN_VILIABILIDAD.getIdStatus().compareTo(
	                		salesChannelProposal.getCecaaChanAdeqStateMovs().get(salesChannelProposal.getCecaaChanAdeqStateMovs().size()-1).getCecarChanAdeqStateRel().getCecadChannelAdequacyState().getBistIdChannelAdequacyState())
	                		== 0) {
		                if (scprrPlanificationWorkflow.getPlanInViability() == null || !scprrPlanificationWorkflow.getPlanInViability().toString().equals("1"))
//		                		|| (scprrPlanificationWorkflow.getPlanInViability() != null && scprrPlanificationWorkflow.getPlanInViability().toString().equals("4"))
//		                		|| (scprrPlanificationWorkflow.getPlanInViability() != null && scprrPlanificationWorkflow.getPlanInViability().toString().equals("2"))
//		                		|| (scprrPlanificationWorkflow.getPlanInViability() != null && scprrPlanificationWorkflow.getPlanInViability().toString().equals("0")))
		                	//cuando sea null o distinto de 1 (=si) hay que mandarlo
		                {
		                	listaPlaWorFlow.add(planificationWorkflow_DTO_OUT);
		                }
	                } else {
	                	if (scprrPlanificationWorkflow.getPlanInViability() != null && scprrPlanificationWorkflow.getPlanInViability().toString().equals("1")) {
		                	listaPlaWorFlow.add(planificationWorkflow_DTO_OUT);
	                	}
	                }
	                
	                
            }
            salesChannelProposal_DTO_OUT.setPlanificationWorkflows(listaPlaWorFlow.toArray(
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT[listaPlaWorFlow
                            .size()]));
        }
    }

    public GetManagerByTaskMailbox_OUT getManagerByTaskMailbox(
            GetManagerByTaskMailbox_IN getmanagerbytaskmailbox_in, TE_Cabecera te_Cabecera,
            TE_Metadatos te_Metadatos) throws TE_Excepcion {

        boolean errorNoInformado = false;
        // Tenemos que validar que viene informado una lista de ids o una lista
        // de codes
        errorNoInformado = getmanagerbytaskmailbox_in == null
                || getmanagerbytaskmailbox_in.getTaskMailboxes() == null
                || getmanagerbytaskmailbox_in.getTaskMailboxes().length == 0;
        List<String> codes = new ArrayList<String>();
        List<BigDecimal> ids = new ArrayList<BigDecimal>();
        if (!errorNoInformado) {
            for (TaskMailbox_DTO_IN d : getmanagerbytaskmailbox_in.getTaskMailboxes()) {
                if (d.getId() != null) {
                    ids.add(d.getId());
                }
                if (StringUtils.isNotEmpty(d.getCode())) {
                    codes.add(d.getCode());
                }
            }
            // Vendrán ids o codes, pero no los dos. Hay que validar que venga
            // informado al menos un valor
            errorNoInformado = (codes.size() == 0 && ids.size() == 0)
                    || (codes.size() != 0 && ids.size() != 0);
        }

        if (errorNoInformado) {
            throw new TE_Excepcion(ERROR_FALTAN_CAMPOS_OBLIGATORIOS,
                    ERROR_FALTAN_CAMPOS_OBLIGATORIOS_MSG + "TaskMailbox_DTO_IN", null, ErrorType.F);
        }

        // Es necesario meter algo en los ids y los codes en el que vaya vacio
        if (codes.size() == 0) {
            codes.add("-CODIGO FICTICIO-");
        }
        if (ids.size() == 0) {
            ids.add(new BigDecimal("-99999999999999"));
        }

        // Si no se recupera información de ninguno de los buzones solicitados,
        // tenemos que devolver la excepción
        List<CnalaTaskMailbox> mboxes = taskMailboxRepository.findManagerByTaskMailbox(ids, codes);
        if (mboxes == null || mboxes.size() == 0) {
            throw new TE_Excepcion(ERROR_NO_INFO_BUZONES, ERROR_NO_INFO_BUZONES_MSG, null, ErrorType.F);
        }

        // TaskMailBox_DTO_OUT.id CNALA_TASK_MAILBOX.MBOX_ID_MAILBOX
        // TaskMailBox_DTO_OUT.code CNALA_TASK_MAILBOX.MBOX_CO_FUNC_MAILBOX
        // TaskMailBox_DTO_OUT.MailboxAccess_DTO_OUT.mailboxResponsible
        // GEWFR_MAILBOX_ACCESS.MAAC_IN_MAILBOX_RESPONSIBLE
        // TaskMailBox_DTO_OUT.MailboxAccess_DTO_OUT.id
        // GEWFR_MAILBOX_ACCESS.MAAC_ID_MAILBOX_ACCESS
        // TaskMailBox_DTO_OUT.MailboxAccess_DTO_OUT.mailboxAccess
        // GEWFR_MAILBOX_ACCESS.MAAC_IN_MAILBOX_ACCESS
        // TaskMailBox_DTO_OUT.FunctionalRole_DTO_OUT.id
        // GEWFR_MAILBOX_ACCESS.PARO_ID_FUNCTIONAL_ROLE
        GetManagerByTaskMailbox_OUT out = new GetManagerByTaskMailbox_OUT();
        List<TaskMailbox_DTO_OUT> taskMailboxOutList = new ArrayList<TaskMailbox_DTO_OUT>();
        for (CnalaTaskMailbox mbox : mboxes) {
            TaskMailbox_DTO_OUT taskMailboxOut = new TaskMailbox_DTO_OUT();
            taskMailboxOut.setId(mbox.getMboxIdMailbox());
            taskMailboxOut.setCode(mbox.getMboxCoFuncMailbox());
            List<GewfrMailboxAccess> mboxAccess = mbox.getGewfrMailboxAccesses();
            if (mboxAccess != null) {
                List<com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT> mailboxAccessOutList = new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT>();
                for (GewfrMailboxAccess mboxAcc : mboxAccess) {
                    com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT mailboxAccessOut = new com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT();
                    mailboxAccessOut.setId(mboxAcc.getMaacIdMailboxAccess());
                    mailboxAccessOut.setMailboxAccess(mboxAcc.getMaacInMailboxAccess());
                    mailboxAccessOut.setMailboxResponsible(mboxAcc.getMaacInMailboxResponsible());
                    mailboxAccessOut.setFunctionalRole(new FunctionalRole_DTO_OUT());
                    mailboxAccessOut.getFunctionalRole().setId(mboxAcc.getParoIdFunctionalRole());
                    mailboxAccessOutList.add(mailboxAccessOut);
                }
                taskMailboxOut.setMailboxAccesses(mailboxAccessOutList.toArray(
                        new com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT[0]));
            }
            taskMailboxOutList.add(taskMailboxOut);
        }
        out.setTaskMailboxes(taskMailboxOutList.toArray(new TaskMailbox_DTO_OUT[0]));
        return out;
    }

    public GetOrganizationTaskMailboxByFunctionalPool_OUT getOrganizationTaskMailboxByFunctionalPool(
            GetOrganizationTaskMailboxByFunctionalPool_IN getorganizationtaskmailboxbyfunctionalpool_in,
            TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion {
        boolean errorNoInformado = false;
        // Tenemos que validar que viene informado una lista de ids o una lista
        // de codes
        errorNoInformado = getorganizationtaskmailboxbyfunctionalpool_in == null
                || getorganizationtaskmailboxbyfunctionalpool_in.getFunctionalPools() == null
                || getorganizationtaskmailboxbyfunctionalpool_in.getFunctionalPools().length == 0;

        List<BigDecimal> ids = new ArrayList<BigDecimal>();
        if (!errorNoInformado) {
            for (FunctionalPool_DTO_IN d : getorganizationtaskmailboxbyfunctionalpool_in
                    .getFunctionalPools()) {
                if (d.getId() != null)
                    ids.add(d.getId());
            }
            // Vendrán ids. Hay que validar que venga informado al menos un
            // valor
            errorNoInformado = ids.size() == 0;
        }

        if (errorNoInformado) {
            throw new TE_Excepcion(ERROR_FALTAN_CAMPOS_OBLIGATORIOS,
                    ERROR_FALTAN_CAMPOS_OBLIGATORIOS_MSG + "FunctionalPool_DTO_IN", null, ErrorType.F);
        }

        List<OrganizationPoolAssignmentDTO> orgPoolAssignments = cnalrOrgaPoolAssignmentRepository
                .findOrgTaskMailboxByFunctionalPool(ids);
        
        // Si no se encuentran resultados, se devuelve el OUT vacio
//        if (orgPoolAssignments == null || orgPoolAssignments.size() == 0) {
//            throw new TE_Excepcion(ERROR_NO_INFO_FPOOL, ERROR_NO_INFO_FPOOL_MSG, null, ErrorType.F);
//        }

        GetOrganizationTaskMailboxByFunctionalPool_OUT out = new GetOrganizationTaskMailboxByFunctionalPool_OUT();

        List<OrganizationPoolAssignment_DTO_OUT> orgPoolAssigOutList = new ArrayList<OrganizationPoolAssignment_DTO_OUT>();
        for (OrganizationPoolAssignmentDTO orgPoolAssig : orgPoolAssignments) {
            OrganizationPoolAssignment_DTO_OUT orgPoolAssigOut = new OrganizationPoolAssignment_DTO_OUT();
            orgPoolAssigOut.setId(orgPoolAssig.getId());
            orgPoolAssigOut.setFunctionalPool(new FunctionalPool_DTO_OUT());
            orgPoolAssigOut.getFunctionalPool().setId(orgPoolAssig.getIdFunctionalPool());
            orgPoolAssigOut.setOrganizationRole(
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationRole_DTO_OUT());
            orgPoolAssigOut.getOrganizationRole().setId(orgPoolAssig.getIdOrganizationRole());
            orgPoolAssigOut.setTaskMailbox(
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.TaskMailbox_DTO_OUT());
            orgPoolAssigOut.getTaskMailbox().setCode(orgPoolAssig.getCodeTaskMailbox());
            orgPoolAssigOut.getTaskMailbox().setId(orgPoolAssig.getIdTaskMailbox());
            orgPoolAssigOutList.add(orgPoolAssigOut);
        }
        out.setOrganizationPoolAssignments(
                orgPoolAssigOutList.toArray(new OrganizationPoolAssignment_DTO_OUT[0]));
        return out;
    }

    /**
     * OP_getTaskMailboxTreeByEnterpriseFunction.
     * 
     * @param gettaskmailboxtreebyenterprisefunction_in
     *            datos de entrada
     * @param te_Cabecera
     *            cabecera
     * @param te_Metadatos
     *            metadatos
     * @return datos de salida
     * @throws TE_Excepcion
     *             en caso de error
     */
    public GetTaskMailboxTreeByEnterpriseFunction_OUT getTaskMailboxTreeByEnterpriseFunction(
            GetTaskMailboxTreeByEnterpriseFunction_IN gettaskmailboxtreebyenterprisefunction_in,
            TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion {
        
        
        // Obligatorio EnterFunctionNode o MailBox
        
        if (gettaskmailboxtreebyenterprisefunction_in.getEnterpriseFunctionTreeNode() == null 
                && gettaskmailboxtreebyenterprisefunction_in.getTaskMailbox() == null) {
            throw new TE_Excepcion(
                    this.getMessagebyIdioma(null, "CANA_E_000131", null),
                    this.getMessagebyIdioma(null, "CANA_E_000131",
                            new String[] { TaskMailbox_DTO_IN.class.getName() }), null, ErrorType.F);
        }

        // A.   El funcionamiento será diferente en función de los datos de entrada que vengan informados:
        
        /*
         o  EnterpriseFunctionTreeNode.id: Se recupera una lista de EnterpriseFunctionTreeNode que dependen 
         jerárquicamente del que se ha introducido (incluimos en la lista el EnterpriseFunctionTreeNode.id de entrada).
          Esto se hace recorriendo la tabla CNALA_ENTE_FUNCTION_TREE_NODE por medio del campo EFTN_ID_FUNC_TREE_NODE_FATHER.
         */
        
        HashMap<BigDecimal, CnalpFunctionalPool> listIDFunPool= new HashMap<BigDecimal, CnalpFunctionalPool>();
        HashMap<BigDecimal, CnalrOrgaPoolAssignment> listIDOrgaPool= new HashMap<BigDecimal, CnalrOrgaPoolAssignment>();
        
        if (gettaskmailboxtreebyenterprisefunction_in.getEnterpriseFunctionTreeNode() != null) {
            // busco en BBDD el nodo informado
            CnalaEnteFunctionTreeNode treeNode = cnalaEnteFunctionTreeNodeRepository
                    .findOne(gettaskmailboxtreebyenterprisefunction_in
                            .getEnterpriseFunctionTreeNode().getId());
            // si viene a null. no buscamos
            if (treeNode == null) {
                throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                        this.getMessagebyIdioma(null, "CANA_E_000132",
                                new String[] { TaskMailbox_DTO_IN.class.getName() }), null, ErrorType.F);
            }

            this.recuperarDatosEFTN(
                    treeNode, 
                    listIDFunPool,
                    listIDOrgaPool,
                    gettaskmailboxtreebyenterprisefunction_in.getFunctionalPool());           
        }
        
        if (gettaskmailboxtreebyenterprisefunction_in.getTaskMailbox() != null) {
           
            CnalaTaskMailbox mailBox = cnalaTaskMailboxRepository
                    .findOne(gettaskmailboxtreebyenterprisefunction_in.getTaskMailbox().getId());
            
            if (mailBox == null) {
                throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                        this.getMessagebyIdioma(null, "CANA_E_000132",
                                new String[] { TaskMailbox_DTO_IN.class.getName() }), null, ErrorType.F);
            }
            
            
            if (mailBox.getCnalpFunctionalPool() != null 
                    && mailBox.getCnalpFunctionalPool().getCnalaEnteFunctionTreeNode() != null) {
               
                this.recuperarDatosEFTN(
                        mailBox.getCnalpFunctionalPool().getCnalaEnteFunctionTreeNode(),
                        listIDFunPool,
                        listIDOrgaPool,
                        gettaskmailboxtreebyenterprisefunction_in.getFunctionalPool());
                
                // tengo que añadir los hermanos
                if (mailBox.getMboxInBrotherReallocation()) {
                    
                    // si tiene padre, busco los hermanos subiendo al padre y luego busnaco los hermanos
                    if (mailBox.getCnalpFunctionalPool().getCnalaEnteFunctionTreeNode().getCnalaEnteFunctionTreeNode() != null) {
                        
                        CnalaEnteFunctionTreeNode cnalaEnteFunctionTreeNodePadre = 
                                mailBox.getCnalpFunctionalPool().getCnalaEnteFunctionTreeNode().getCnalaEnteFunctionTreeNode();
                       
                        List<CnalaEnteFunctionTreeNode> cnalaEnteFunctionTreeNodeHijos = 
                                cnalaEnteFunctionTreeNodePadre.getCnalaEnteFunctionTreeNodes();
                        
                        for (CnalaEnteFunctionTreeNode cnalaEnteFunctionTreeNodeHermano : cnalaEnteFunctionTreeNodeHijos) {
                            // discrimino el que estamos tratando
                            if (cnalaEnteFunctionTreeNodeHermano.getEftnIdEnteFuncTreeNode().compareTo(
                                    mailBox.getCnalpFunctionalPool().getCnalaEnteFunctionTreeNode().getEftnIdEnteFuncTreeNode()) != 0) {
                                
                                if (cnalaEnteFunctionTreeNodeHermano.getCnalpFunctionalPools() != null && !cnalaEnteFunctionTreeNodeHermano.getCnalpFunctionalPools().isEmpty()) {
                                    for (CnalpFunctionalPool cnalpFunctionalPool :cnalaEnteFunctionTreeNodeHermano.getCnalpFunctionalPools()) {
                                        listIDFunPool.put(cnalpFunctionalPool.getWpooIdFunctionalPool(), cnalpFunctionalPool);

                                        if (cnalpFunctionalPool.getCnalrOrgaPoolAssignments() != null 
                                                && !cnalpFunctionalPool.getCnalrOrgaPoolAssignments().isEmpty()) {
                                            for (CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment : cnalpFunctionalPool.getCnalrOrgaPoolAssignments()) {
                                                listIDOrgaPool.put(cnalrOrgaPoolAssignment.getParoIdOrganizationRole(), cnalrOrgaPoolAssignment);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } 
            }           
        }

        // C. Invoco a OP_getOrganizationRoleData para obtener los tradingName - se llama al montar la salida
//        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_IN in =
//                new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_IN();
//        List<com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_IN> listOrganizationRole =
//                new ArrayList<com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_IN>();
//        for (BigDecimal id : listIDOrgaPool.keySet()) {
//            com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_IN organizationRole =
//                    new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_IN();
//            organizationRole.setId(id);
//            listOrganizationRole.add(organizationRole);
//        }
//        in.setOrganizationRoles(listOrganizationRole.toArray(
//                new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_IN[0]));

        
        Specifications<CnalaTaskMailbox> listaSpecs = Specifications.where(null);
        /*if (!listIDOrgaPool.isEmpty()) {
            listaSpecs = listaSpecs.and(TaskMailboxSpecifications.byTaskMailboxAndOrgRole(new ArrayList<BigDecimal>(listIDOrgaPool.keySet())));
        }*/
        
        if (!listIDFunPool.isEmpty()) {
            listaSpecs = listaSpecs.and(TaskMailboxSpecifications.byListIdFunctionalPools(new ArrayList<BigDecimal>(listIDFunPool.keySet())));
        }
        
        
        List<CnalaTaskMailbox> listCnalaTaskMailbox = cnalaTaskMailboxRepository
                .findTaskMailboxByEnterpriseFunction(listaSpecs);
        
        // Recupero los datos (es el 69).
        String sidOverflow = env.getProperty("cana.overflow.idOverflow");
        if (StringUtils.isEmpty(sidOverflow) || !StringUtils.isNumeric(sidOverflow)) {
            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000000", null),
                    this.getMessagebyIdioma(null, "CANA_E_000000", null), null, ErrorType.F);
        }
        Long idOverflow = Long.parseLong(sidOverflow);
        // llamada 1 vez al externo getOrgRoleData
        List <BigDecimal> listIdsOrgRole = new ArrayList <BigDecimal>();
        
        for (CnalaTaskMailbox cnalaTaskMailbox : listCnalaTaskMailbox) {
            
            if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment2() != null && cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getParoIdOrganizationRole() != null) {
            	listIdsOrgRole.add(cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getParoIdOrganizationRole());
            }
        }
        
        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_OUT getOrganizationRoleData_OUT =
				new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_OUT();
        
        if (!listIdsOrgRole.isEmpty()) {
        	
        	Set <BigDecimal> listIdsAux = new HashSet <BigDecimal>(listIdsOrgRole);
        	listIdsOrgRole = new ArrayList <BigDecimal>(listIdsAux);
        	
    		try {
    			getOrganizationRoleData_OUT = this.invocar_getOrganizationRoleData(listIdsOrgRole, te_Cabecera);
    		} catch (TE_Excepcion e) {
    			throw e;
    		}
        }

        List<com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.TaskMailbox_DTO_OUT> lista =
                new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.TaskMailbox_DTO_OUT>();
        for (CnalaTaskMailbox cnalaTaskMailbox : listCnalaTaskMailbox) {
            
            this.montarSalidaGettaskmailboxtreebyenterprisefunction(lista, cnalaTaskMailbox, idOverflow, te_Metadatos, te_Cabecera, getOrganizationRoleData_OUT);
            
           
        }

        GetTaskMailboxTreeByEnterpriseFunction_OUT out = new GetTaskMailboxTreeByEnterpriseFunction_OUT();
        out.setTaskMailboxes(lista.toArray(
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.TaskMailbox_DTO_OUT[0]));
        return out;
    }

    private void montarSalidaGettaskmailboxtreebyenterprisefunction(
            List<com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.TaskMailbox_DTO_OUT> lista,
            CnalaTaskMailbox cnalaTaskMailbox, Long idOverflow, TE_Metadatos te_Metadatos, TE_Cabecera te_Cabecera, GetOrganizationRoleData_OUT getOrganizationRoleData_OUT) 
            		throws TE_Excepcion {

            com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.TaskMailbox_DTO_OUT taskMailboxOUT =
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.TaskMailbox_DTO_OUT();
            taskMailboxOUT.setCode(cnalaTaskMailbox.getMboxCoFuncMailbox());
            taskMailboxOUT.setId(cnalaTaskMailbox.getMboxIdMailbox());
            taskMailboxOUT.setBrotherReallocation(cnalaTaskMailbox.getMboxInBrotherReallocation());
            
        	taskMailboxOUT.setFunctionalPool(new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.FunctionalPool_DTO_OUT());
        	taskMailboxOUT.getFunctionalPool().setId(cnalaTaskMailbox.getCnalpFunctionalPool().getWpooIdFunctionalPool());
            taskMailboxOUT.getFunctionalPool().setMailboxStatus(ObjectUtils.toString(cnalaTaskMailbox.getCnalpFunctionalPool().getFupoInMailboxState()));
            taskMailboxOUT.getFunctionalPool().setName(cnalaTaskMailbox.getCnalpFunctionalPool().getFupoNaFunctionalPool());
            taskMailboxOUT.getFunctionalPool().setPoolType(ObjectUtils.toString(cnalaTaskMailbox.getCnalpFunctionalPool().getFupoInPoolType()));
            taskMailboxOUT.getFunctionalPool().setWorkMode(ObjectUtils.toString(cnalaTaskMailbox.getCnalpFunctionalPool().getFupoInWorkMode())); 
            taskMailboxOUT.getFunctionalPool().setEnterpriseFunctionTreeNode(this.getTaskMailboxTreeByEnterpriseFunction_trataEnterpriseFunctionTreeNode(
                            cnalaTaskMailbox.getCnalpFunctionalPool().getCnalaEnteFunctionTreeNode(), idOverflow));
            
            if (cnalaTaskMailbox.getMboxQuMaximumAmount() != null) {
                taskMailboxOUT.setMaxQuantity(cnalaTaskMailbox.getMboxQuMaximumAmount());
            } else {
            	taskMailboxOUT.setMaxQuantity(0L);
            }
            taskMailboxOUT.setName(cnalaTaskMailbox.getLboxNaMailbox());
            
            //-------------
//            for (CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment : cnalaTaskMailbox
//                    .getCnalpFunctionalPool().getCnalrOrgaPoolAssignments()) {
//                taskMailboxOUT.setOrganizationRole(
//                        new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.OrganizationRole_DTO_OUT());
//                taskMailboxOUT.getOrganizationRole()
//                        .setId(cnalrOrgaPoolAssignment.getParoIdOrganizationRole());
//                taskMailboxOUT.getOrganizationRole().setOrganizationName(
//                        new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.OrganizationName_DTO_OUT());
//                if (getOrganizationRoleData_OUT != null 
//                        && getOrganizationRoleData_OUT.getOrganizationRoles() != null 
//                        && getOrganizationRoleData_OUT.getOrganizationRolesLength() >= 0) {
//                    for (com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT organizationRole : 
//                        getOrganizationRoleData_OUT.getOrganizationRoles()) {
//                        
//                        // para le id que coincida, seteo el nombre
//                        if (organizationRole.getId().compareTo(cnalrOrgaPoolAssignment.getParoIdOrganizationRole()) == 0) {
//                            com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT oop =
//                                    (com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT) organizationRole
//                                    .getParty();
//                            taskMailboxOUT.getOrganizationRole().getOrganizationName()
//                            .setTradingName(StringUtils.defaultString(oop.getOrganizationName().getTradingName()));
//                        }
//                    }
//                }
//            }
            
            
            //----------------

            if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment2() != null
            		&& cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getParoIdOrganizationRole() != null) {
            	
            	if (getOrganizationRoleData_OUT != null 
                		&& getOrganizationRoleData_OUT.getOrganizationRoles() != null 
                		&& getOrganizationRoleData_OUT.getOrganizationRolesLength() > 0) {
            	
            		for (com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT orgRoleExt : 
                        getOrganizationRoleData_OUT.getOrganizationRoles()) {
                		
                		if (cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getParoIdOrganizationRole().equals(orgRoleExt.getId())) {
                			
                			com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.OrganizationRole_DTO_OUT organizationRole_DTO_OUT = 
                					new	com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.OrganizationRole_DTO_OUT();
                			
                			organizationRole_DTO_OUT.setId(cnalaTaskMailbox.getCnalrOrgaPoolAssignment2().getParoIdOrganizationRole());
                			
                			if (orgRoleExt.getParty() != null) {
    							
    							com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT oop =
    	                                (com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT) orgRoleExt.getParty();
    							
    							if (oop.getOrganizationName() != null && !StringUtils.isBlank(oop.getOrganizationName().getTradingName())) {
    								
    								com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.OrganizationName_DTO_OUT organizationName_DTO_OUT =
        									new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.OrganizationName_DTO_OUT();
    								
    								organizationName_DTO_OUT.setTradingName(StringUtils.defaultString(oop.getOrganizationName().getTradingName()));
    		                    	
    								organizationRole_DTO_OUT.setOrganizationName(organizationName_DTO_OUT);
    		                        	
    								taskMailboxOUT.setOrganizationRole(organizationRole_DTO_OUT);
    							}
    						}
                			
                			break;
            			}
            		}
            	
            	} else {
            		throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000133", null),
    	                    this.getMessagebyIdioma(null, "CANA_E_000133_MSG",
    	                            new String[] { "GetOrganizationRoleData", "GESTORES" }), null, ErrorType.F);
            	}
        	}
            	

            taskMailboxOUT.setState(ObjectUtils.toString(cnalaTaskMailbox.getMboxInState()));
            taskMailboxOUT.setValidFor(new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.TimePeriod());
            taskMailboxOUT.getValidFor().setStartDateTime(cnalaTaskMailbox.getMboxTiStartValidity());
            taskMailboxOUT.getValidFor().setEndDateTime(cnalaTaskMailbox.getMboxTiEndValidity());
            
            if (cnalaTaskMailbox.getMboxQuVolume() != null) {
            	taskMailboxOUT.setVolume(cnalaTaskMailbox.getMboxQuVolume());
            } else {
            	taskMailboxOUT.setVolume(0L);
            }
            
        	lista.add(taskMailboxOUT);
      
        
    }

    private void recuperarDatosEFTN(CnalaEnteFunctionTreeNode treeNode,
            HashMap<BigDecimal, CnalpFunctionalPool> listIDFunPool,
            HashMap<BigDecimal, CnalrOrgaPoolAssignment> listIDOrgaPool, 
            com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.FunctionalPool_DTO_IN functionalPool) {
        // si viene informado el funcPool solo queremos el treeNode que tenga funcionaPool que coincidan con el DTO_IN
        if (functionalPool != null && functionalPool.getId() != null) {
            
            if (treeNode.getCnalpFunctionalPools() != null && !treeNode.getCnalpFunctionalPools().isEmpty()) {
                for (CnalpFunctionalPool cnalpFunctionalPool :treeNode.getCnalpFunctionalPools()) {
                    
                    if (cnalpFunctionalPool.getWpooIdFunctionalPool().compareTo(functionalPool.getId()) == 0) {
                        
                       
                        listIDFunPool.put(cnalpFunctionalPool.getWpooIdFunctionalPool(), cnalpFunctionalPool);
                        
                        if (cnalpFunctionalPool.getCnalrOrgaPoolAssignments() != null 
                                && !cnalpFunctionalPool.getCnalrOrgaPoolAssignments().isEmpty()) {
                            for (CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment : cnalpFunctionalPool.getCnalrOrgaPoolAssignments()) {
                                listIDOrgaPool.put(cnalrOrgaPoolAssignment.getParoIdOrganizationRole(), cnalrOrgaPoolAssignment);
                            }
                        }
                        
                        break;
                    }
                }
            }
        } else {
            
            if (treeNode.getCnalpFunctionalPools() != null && !treeNode.getCnalpFunctionalPools().isEmpty()) {
                for (CnalpFunctionalPool cnalpFunctionalPool :treeNode.getCnalpFunctionalPools()) {
                        listIDFunPool.put(cnalpFunctionalPool.getWpooIdFunctionalPool(), cnalpFunctionalPool);
                        
                        if (cnalpFunctionalPool.getCnalrOrgaPoolAssignments() != null 
                                && !cnalpFunctionalPool.getCnalrOrgaPoolAssignments().isEmpty()) {
                            for (CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment : cnalpFunctionalPool.getCnalrOrgaPoolAssignments()) {
                                listIDOrgaPool.put(cnalrOrgaPoolAssignment.getParoIdOrganizationRole(), cnalrOrgaPoolAssignment);
                            }
                        }
                }
            }
        }
        
        if (treeNode.getCnalaEnteFunctionTreeNodes() != null && !treeNode.getCnalaEnteFunctionTreeNodes().isEmpty()) {
            for (CnalaEnteFunctionTreeNode treeNodeHijo : treeNode.getCnalaEnteFunctionTreeNodes()) {
                this.recuperarDatosEFTN(
                        treeNodeHijo,
                        listIDFunPool,
                        listIDOrgaPool,
                        functionalPool);
            }
        }
    }

    /**
     * Prepara los datos de salida de las EnterpriseFunctionTreeNode
     * recursivamente.
     * 
     * @param ceftn
     *            nodo que se trata
     * @param idOverflow
     *            indicador de oveerflow
     * @return EnterpriseFunctionTreeNode_DTO_OUT
     */
    private com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.EnterpriseFunctionTreeNode_DTO_OUT
    getTaskMailboxTreeByEnterpriseFunction_trataEnterpriseFunctionTreeNode(CnalaEnteFunctionTreeNode ceftn, Long idOverflow) {
    	
        com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.EnterpriseFunctionTreeNode_DTO_OUT out =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.EnterpriseFunctionTreeNode_DTO_OUT();
        
        out.setId(ceftn.getEftnIdEnteFuncTreeNode());
        
        out.setEnterpriseFunction(new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.EnterpriseFunction_DTO_OUT());
        out.getEnterpriseFunction().setId(ceftn.getCnaldEnterpriseFunction().getEnfuIdEnterpriseFunction());
        out.getEnterpriseFunction().setName(ceftn.getCnaldEnterpriseFunction().getLefuNaEnterpriseFunction());
        out.getEnterpriseFunction().setOverflow(ceftn.getCnaldEnterpriseFunction().getEnfuIdEnterpriseFunction().equals(idOverflow));

        if (ceftn.getCnalaEnteFunctionTreeNodes() != null
                && !ceftn.getCnalaEnteFunctionTreeNodes().isEmpty()) {
        	
            List<com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.EnterpriseFunctionTreeNode_DTO_OUT> lout =
                    new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.EnterpriseFunctionTreeNode_DTO_OUT>();
                    
            for (CnalaEnteFunctionTreeNode ceftnh : ceftn.getCnalaEnteFunctionTreeNodes()) {
                lout.add(getTaskMailboxTreeByEnterpriseFunction_trataEnterpriseFunctionTreeNode(
                        ceftnh, idOverflow));
                
            }
            out.setEnterpriseFunctionTreeNodeSons(lout.toArray(
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.EnterpriseFunctionTreeNode_DTO_OUT[0]));
        }

        return out;
    }

   

    /** Invocación al getORganizationRoleData de gest
     * MRSOPOJO
     * @param in
     * @param te_Cabecera
     * @return
     * @throws TE_Excepcion
     */
    public com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_OUT invocar_getOrganizationRoleData(
            List<BigDecimal> listIdsOrgRole, TE_Cabecera te_Cabecera) throws TE_Excepcion {

        // Se invoca a getOrganizationRoleData informando
        // pasándole la lista de ids de organizationRole obtenida.
        // Si no devuelve nada o da un error, se devuelve error CANA-E-000133,
        // indicando que el servicio de Gestores no ha devuelto datos
        // consultando con el OrganizationRole indicado
    	
    	com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_IN getOrganizationRoleData_IN =
    			new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_IN();
    	
    	List <com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_IN> listOrganizationRole_DTO_IN =
    			new ArrayList <com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_IN>();
    	for (BigDecimal id : listIdsOrgRole) {
    	com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_IN organizationRole_DTO_IN =
    			new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_IN();
    	organizationRole_DTO_IN.setId(id);
    	
    	listOrganizationRole_DTO_IN.add(organizationRole_DTO_IN);
    	}
    	
    	getOrganizationRoleData_IN.setOrganizationRoles(listOrganizationRole_DTO_IN.toArray(
    			new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_IN[listOrganizationRole_DTO_IN.size()]));
        
        // se añade seguridad
        LOGGER.debug("Inicio llamada a método invocar_getOrganizationRoleData");

        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_OUT out = null;
        try {
            Holder<TE_Cabecera> holder_cab = new Holder<TE_Cabecera>(te_Cabecera);
            Holder<TE_Metadatos> holder_met = new Holder<TE_Metadatos>(
                    CommonUtilitiesServiceImpl.crearMetadatos("", 1l, 100l));

            String endpoint = serviceRegistry.getEndpoint("uddi:gest.srv-exp-EngSecurity-v3");
            
            com.telefonica.gest.srv.exp.engsecurity.facade.EngSecurityExpServicePortType port =
                    new com.telefonica.gest.srv.exp.engsecurity.facade.EngSecurityExpServiceClient().getSrvExpEngSecurityPort();
           
            BindingProvider bp = (BindingProvider) port;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
			bp.getRequestContext().put("com.sun.xml.ws.connect.timeout",
					env.getRequiredProperty("system.ws.connect.timeout", Integer.class));
			bp.getRequestContext().put("com.sun.xml.ws.request.timeout",
					env.getRequiredProperty("system.ws.request.timeout", Integer.class));

            
            List<CredentialProvider> credList = new ArrayList<CredentialProvider>();
            credList.add(new ClientUNTCredentialProvider(WSS_USERNAME.getBytes(),WSS_PASSWORD.getBytes()));
            bp.getRequestContext().put(WSSecurityContext.CREDENTIAL_PROVIDER_LIST, credList);

            
            out = port.getOrganizationRoleData(getOrganizationRoleData_IN, holder_cab, holder_met);

        } catch (EndpointNotFoundException | TE_Excepcion e) {
            this.lanzarExcepcion("CANA_E_000133", "OrganizationRole", "GESTORES");
        }
        LOGGER.debug("Fin llamada a método invocar_getOrganizationRoleData");
        return out;

    }

    /**
     * Recorre el arbol de EnterpriseFunctionTreeNode hasta los hijos si se
     * indica para recuperar los ids de los organizationRol.
     * 
     * Con la lista de EnterpriseFunctionTreeNode accedemos a
     * CNALP_FUNCTIONAL_POOL para recuperar los FunctionalPool.id que tengan
     * asociados cada EFTN y a CNALR_ORGA_POOL_ASSIGNMENT para recuperar el
     * OrganizationRole que tiene asociado cada FunctionalPool
     * 
     * @param organizationRoles
     *            organizationRol recuperados
     * @param ceftn
     *            nodo del arbol
     * @param recorrerHastaHijos
     *            indica si se debe segui hasta los hijos
     */
//    private void getTaskMailboxTreeByEnterpriseFunction_recorrerHastaHijos(
//            Map<BigDecimal, String> organizationRoles, CnalaEnteFunctionTreeNode ceftn,
//            boolean recorrerHastaHijos) {
//        for (CnalpFunctionalPool cnalpFunctionalPool : ceftn.getCnalpFunctionalPools()) {
//            for (CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment : cnalpFunctionalPool.getCnalrOrgaPoolAssignments()) {
//                organizationRoles.put(cnalrOrgaPoolAssignment.getParoIdOrganizationRole(), "");
//            }
//        }
//        if (recorrerHastaHijos && ceftn.getCnalaEnteFunctionTreeNodes() != null
//                && !ceftn.getCnalaEnteFunctionTreeNodes().isEmpty()) {
//            for (CnalaEnteFunctionTreeNode ceftnhijo : ceftn.getCnalaEnteFunctionTreeNodes()) {
//                getTaskMailboxTreeByEnterpriseFunction_recorrerHastaHijos(organizationRoles, ceftnhijo,
//                        recorrerHastaHijos);
//            }
//        }
//    }

    public com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_OUT manageTaskMailbox(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_IN managetaskmailbox_in,
            TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion {
        LOGGER.debug("Entrada del  método adManageTaskMailbox");

        ManageTaskMailbox_OUT aD_ManageTaskMailbox_OUT = new ManageTaskMailbox_OUT();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_OUT taskMailbox_OUT = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_OUT();

        if (managetaskmailbox_in == null || managetaskmailbox_in.getOperationType() == null
                || managetaskmailbox_in.getTaskMailbox() == null) {
            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                    this.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                            new String[] { "TaskMailbox" }), null, ErrorType.F);
        }

        // iniciamos la operación comprobando si hay que insertar o modificar
        try {
            if (ET_OperationType.INSERT.getId()
                    .equals(Integer.valueOf(managetaskmailbox_in.getOperationType().toString()))) {
                // insertar
                LOGGER.debug(
                        "Llamada al metodo privado crearTaskMailbox  del  método adManageTaskMailbox");
                taskMailbox_OUT = this.crearTaskMailbox(managetaskmailbox_in.getTaskMailbox(),
                        te_Cabecera, managetaskmailbox_in.getOperationType());
                aD_ManageTaskMailbox_OUT.setTaskMailbox(taskMailbox_OUT);

            } else if (ET_OperationType.UPDATE.getId()
                    .equals(Integer.valueOf(managetaskmailbox_in.getOperationType().toString()))) {
                // modificar
                LOGGER.debug(
                        " Llamada al metodo privado modificarTaskMailbox  del  método adManageTaskMailbox");
                taskMailbox_OUT = this.modificarTaskMailbox(managetaskmailbox_in.getTaskMailbox(),
                        te_Cabecera, managetaskmailbox_in.getOperationType());
            } else {
                // si no fuera alguno de los dos posibles valores que esperamos
                throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000126", null),
                        this.getMessagebyIdioma(null, "CANA_E_000126_MSG", null), null, ErrorType.F);
            }

        } catch (TE_Excepcion te) {
            // captura las excepciones de los metodos privados
            throw te;
        }
        
        LOGGER.debug("Fin del  método adManageTaskMailbox");
        return aD_ManageTaskMailbox_OUT;
    }

    // --------------------metodos privados
    // manageTaskMailBox-------------------------------
    private com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_OUT crearTaskMailbox(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailbox_DTO_IN,
            TE_Cabecera te_Cabecera, Long operationType) throws TE_Excepcion {

        // insertar
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_OUT taskMailbox_OUT = 
        		new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_OUT();

        // se comprueba que vengan los datos necesarios para hacer la insercion
        // en BBDD
        if (!compruebaDatosCompletosTaskMailbox(taskMailbox_DTO_IN, te_Cabecera)) { 
            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000131", null),
                    this.getMessagebyIdioma(null, "CANA_E_000131_MSG",
                            new String[] { "TaskMailbox" }), null, ErrorType.F);

        } else {
            // si vienen los datos necesarios
            CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
            // pasamos los datos de nuestro objeto de entrada a la entidad
            // mapeada contra la tabla de BBDD
            cnalaTaskMailbox = this.montarCnalaTaskMailboxCrearManage(taskMailbox_DTO_IN, te_Cabecera);

            try {
            	 if (this.validarRequisitosInsert(taskMailbox_DTO_IN, te_Cabecera, cnalaTaskMailbox)) {
                     taskMailboxRepository.saveAndFlush(cnalaTaskMailbox);
                     // seteamos el parámetro que nos piden de salida del método
                     // principal
                     taskMailbox_OUT.setId(cnalaTaskMailbox.getMboxIdMailbox());
                 } else {
                     throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000128", null),
                             this.getMessagebyIdioma(null, "CANA_E_000128_MSG",
                                     new String[] { "No se cumplen los requisitos" }), null, ErrorType.F);
                 }
			} catch (DataAccessException | PersistenceException e) {
				LOGGER.error("ERROR crearTaskMailbox", e);
				throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000128", null),
                        this.getMessagebyIdioma(null, "CANA_E_000128_MSG",
                                new String[] { "TaskMailbox" }), e, ErrorType.T);
			}
           
        }

        return taskMailbox_OUT;
    }

    private com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_OUT modificarTaskMailbox(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailbox,
            TE_Cabecera te_Cabecera, Long operationType) throws TE_Excepcion {

        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_OUT taskMailbox_OUT = 
        		new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_OUT();

        CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();

        // se comprueba que existe ese id en BBDD
        if (taskMailbox.getId() != null) {
            cnalaTaskMailbox = taskMailboxRepository.findOne(taskMailbox.getId());
            if(cnalaTaskMailbox == null || cnalaTaskMailbox.getMboxIdMailbox() == null) {
            	throw new TE_Excepcion(this.getMessagebyIdioma(null, "INCL_E_000131", null),
                        this.getMessagebyIdioma(null, "INCL_E_000131_MSG",
                                new String[] { taskMailbox.getId().toString() }), null, ErrorType.F);
            }
        } else {
            LOGGER.debug("[{}] - Error: taskMailbox.getId() == null");
            throw new TE_Excepcion(this.getMessagebyIdioma(null, "INCL_E_000102", null),
                    this.getMessagebyIdioma(null, "INCL_E_000102_MSG",
                            new String[] { "TaskMailbox" }), null, ErrorType.F);
        }

        // si existe, se comprueban que vengan los datos necesarios para la
        // modificacion
        if (!this.compruebaDatosCompletosTaskMailbox(taskMailbox, te_Cabecera)) {
            // si no vienen los datos necesarios lanzamos excepcion
            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000131", null),
                    this.getMessagebyIdioma(null, "CANA_E_000131_MSG",
                            new String[] { "TaskMailbox" }), null, ErrorType.F);

        } else {
            List<CnalrTaskMailboxL> listCnalrTaskMailboxL = new ArrayList<CnalrTaskMailboxL>();
            List<Object> mapa = new ArrayList<Object>();
            // si vienen los datos necesarios pasamos los datos de nuestro
            // objeto de entrada a la entidad mapeada contra la tabla de
            // BBDD

            mapa = this.montarCnalaTaskMailboxModificarManage(taskMailbox, te_Cabecera,
                    cnalaTaskMailbox);

            if (!mapa.isEmpty()) {
                cnalaTaskMailbox = (CnalaTaskMailbox) mapa.get(0);
            }
            if (mapa.get(1) != null) {
                listCnalrTaskMailboxL = (List<CnalrTaskMailboxL>) mapa.get(1);
                cnalaTaskMailbox.setCnalrTaskMailboxLs(listCnalrTaskMailboxL);
            }

            try {
                // hacemos la modificacion
                taskMailboxRepository.saveAndFlush(cnalaTaskMailbox);
			} catch (DataAccessException | PersistenceException e) {
				throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000127", null),
                        this.getMessagebyIdioma(null, "CANA_E_000127_MSG",
                                new String[] { "TaskMailbox" }), e, ErrorType.T);
			}
            
        }

        return taskMailbox_OUT;
    }

    private List<Object> montarCnalaTaskMailboxModificarManage(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailboxIN,
            TE_Cabecera te_Cabecera, CnalaTaskMailbox cnalaTaskMailbox) throws TE_Excepcion {

        List<CnalrTaskMailboxL> listCnalrTaskMailboxL = new ArrayList<CnalrTaskMailboxL>();
        List<Object> mapa = new ArrayList<Object>();

        cnalaTaskMailbox.setMboxQuVolume(taskMailboxIN.getVolume());
        cnalaTaskMailbox.setMboxQuMaximumAmount(taskMailboxIN.getMaxQuantity());
        cnalaTaskMailbox.setMboxInBrotherReallocation(taskMailboxIN.isBrotherReallocation());
        
        if(taskMailboxIN.getState() != null) {
            cnalaTaskMailbox.setMboxInState(Long.valueOf(taskMailboxIN.getState()));
        }
        if (taskMailboxIN.getDistributionCriteria() != null
                && taskMailboxIN.getDistributionCriteria().getId() != null) {
            cnalaTaskMailbox.setGewfdDistributionCriteria(new GewfdDistributionCriteria());
            cnalaTaskMailbox.getGewfdDistributionCriteria()
                    .setDiscIdDistributionCriteria(taskMailboxIN.getDistributionCriteria().getId());
        } else {
            cnalaTaskMailbox.setGewfdDistributionCriteria(null);
        }
        /*
         * CAMBIO Correo Ivan Pelaez Lopez Cambio en la operación de núcleo OP_manageTaskMailbox 13/03/2017
         else {
            GewfdDistributionCriteria gewfdDistributionCriteria = new GewfdDistributionCriteria();
            gewfdDistributionCriteria.setDiscIdDistributionCriteria(4l);
            cnalaTaskMailbox.setGewfdDistributionCriteria(gewfdDistributionCriteria);
        }
         */

        if (taskMailboxIN.getRule() != null && taskMailboxIN.getRule().getId() != null) {
            cnalaTaskMailbox.setRuleIdRule(taskMailboxIN.getRule().getId());
        } else if (taskMailboxIN.getRule() == null) {
        	 cnalaTaskMailbox.setRuleIdRule(null);
        }

        cnalaTaskMailbox.setAudiTiUpdate(new Timestamp(System.currentTimeMillis()));
        try {
            cnalaTaskMailbox.setUserIdUpdaterParty(new BigDecimal(te_Cabecera.getIdUsuario()));
        } catch (NullPointerException e) {
            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                    this.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                            new String[] { "TaskMailbox" }), null, ErrorType.F);
        }

        Calendar calendarStartValidity = Calendar.getInstance();
        Calendar calendarEndValidity = Calendar.getInstance();
                
        calendarStartValidity.setTime(taskMailboxIN.getValidFor().getStartDateTime());
        calendarStartValidity.set(Calendar.HOUR_OF_DAY, 0);
        calendarStartValidity.set(Calendar.MINUTE, 0);
        calendarStartValidity.set(Calendar.SECOND, 0);
        calendarStartValidity.set(Calendar.MILLISECOND, 0);
                
        if (taskMailboxIN.getValidFor().getEndDateTime() != null) {
            calendarEndValidity.setTime(taskMailboxIN.getValidFor().getEndDateTime());
            calendarEndValidity.set(Calendar.HOUR_OF_DAY, 23);
            calendarEndValidity.set(Calendar.MINUTE, 59);
            calendarEndValidity.set(Calendar.SECOND, 59); 
            calendarEndValidity.set(Calendar.MILLISECOND, 999);
        }

        cnalaTaskMailbox.setMboxTiStartValidity(
                new Timestamp(calendarStartValidity.getTimeInMillis()));

        if (taskMailboxIN.getValidFor().getEndDateTime() != null) {
            cnalaTaskMailbox.setMboxTiEndValidity(
                    new Timestamp(calendarEndValidity.getTimeInMillis()));
        }else{
            cnalaTaskMailbox.setMboxTiEndValidity(null);
        }
        
        // SLB5 - Nuevos campos
        if (taskMailboxIN.getApplication() != null && taskMailboxIN.getApplication().getId() != null) {
        	cnalaTaskMailbox.setGenaIdApplication(taskMailboxIN.getApplication().getId());
        }else{
        	cnalaTaskMailbox.setGenaIdApplication(null);
        }
        cnalaTaskMailbox.setMboxInDistributionMode((taskMailboxIN.getDistributionMode() != null) ? Long.valueOf(taskMailboxIN.getDistributionMode()) : null);
        cnalaTaskMailbox.setMboxInGroupDistribCriteria((taskMailboxIN.getGroupDistributionCriteria() != null) ? Long.valueOf(taskMailboxIN.getGroupDistributionCriteria()) : null);
        cnalaTaskMailbox.setMboxInManualDistribMode((taskMailboxIN.getManualDistributionMode() != null) ? Long.valueOf(taskMailboxIN.getManualDistributionMode()) : null);

        if (taskMailboxIN.getName().getMultiLanguages() != null
                && taskMailboxIN.getName().getMultiLanguagesLength() > 0
                && taskMailboxIN.getName().getMultiLanguages(0).getLanguageCode() != null) {

            CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();

            for (int j = 0; j < taskMailboxIN.getName().getMultiLanguagesLength(); j++) {
                String idioma = languageService.getIdiomaPorDefecto();
                if (taskMailboxIN.getName().getMultiLanguages(j).getLanguageCode()
                        .equals(Long.valueOf(idioma))) {
                    cnalaTaskMailbox.setLboxNaMailbox(
                            taskMailboxIN.getName().getMultiLanguages(j).getValue());

                } else {

                    // en caso contrario, actualizamos los lenguajes en
                    // CNALR_TASK_MAILBOX_L
                    // buscamos en la tabla de lenguajes el elemento, si existe
                    // lo actualizamos, en caso contrario lo
                    // insertamos
                    cnalrTaskMailboxL = cnalrTaskMailboxRepository.findByIdTaskMailboxAndLanguage(taskMailboxIN.getId(), taskMailboxIN.getName().getMultiLanguages(j).getLanguageCode());
                    
                    if (cnalrTaskMailboxL != null) {
                        cnalrTaskMailboxL.setLboxNaMailbox(
                        taskMailboxIN.getName().getMultiLanguages(j).getValue());
                        cnalrTaskMailboxL.setAudiTiUpdate(new Timestamp(System.currentTimeMillis()));
                        try {
                            cnalrTaskMailboxL
                                    .setUserIdUpdaterParty(new BigDecimal(te_Cabecera.getIdUsuario()));
                            
                        } catch (NullPointerException e) {
                            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                                    this.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                                            new String[] { "TaskMailbox" }), e, ErrorType.T);
                        }
                    } else {
                        cnalrTaskMailboxL = new CnalrTaskMailboxL();
                        cnalrTaskMailboxL.setLboxNaMailbox(
                                taskMailboxIN.getName().getMultiLanguages(j).getValue());
                        cnalrTaskMailboxL.setAudiTiCreation(new Timestamp(System.currentTimeMillis()));
                        try {
                            cnalrTaskMailboxL.setUserIdCreatorParty(new BigDecimal(te_Cabecera.getIdUsuario()));
                            cnalrTaskMailboxL.setLangCoLanguage(
                                    taskMailboxIN.getName().getMultiLanguages(j).getLanguageCode());
                        } catch (NullPointerException e) {
                            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                                    this.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                                            new String[] { "TaskMailbox" }), e, ErrorType.T);
                        }
                        
                        cnalrTaskMailboxL.setCnalaTaskMailbox(cnalaTaskMailbox);
                    }
                    
                    listCnalrTaskMailboxL.add(cnalrTaskMailboxL);

                }
            }

            cnalaTaskMailbox.setMboxCoFuncMailbox(taskMailboxIN.getCode());

            if (taskMailboxIN.getFunctionalPool() != null
                    && taskMailboxIN.getFunctionalPool().getId() != null) {
                CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
                cnalpFunctionalPool
                        .setWpooIdFunctionalPool(taskMailboxIN.getFunctionalPool().getId());
                cnalaTaskMailbox.setCnalpFunctionalPool(cnalpFunctionalPool);
            }

            if (taskMailboxIN.getOrganizationPoolAssignment() != null
                    && taskMailboxIN.getOrganizationPoolAssignment().getId() != null) {
                CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment = cnalrOrgaPoolAssignmentRepository
                        .findOne(taskMailboxIN.getOrganizationPoolAssignment().getId());

                if (cnalrOrgaPoolAssignment == null) {
                    throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000127", null),
                            this.getMessagebyIdioma(null, "CANA_E_000127_MSG",
                                    new String[] { "cnalROrgaPoolAssignment.id: " +  taskMailboxIN.getOrganizationPoolAssignment().getId().toString() }), null, ErrorType.F);
                }
                
                cnalaTaskMailbox.setCnalrOrgaPoolAssignment1(cnalrOrgaPoolAssignment);
                cnalaTaskMailbox.setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment);

            }
        }

        mapa.add(0, cnalaTaskMailbox);
        if (!listCnalrTaskMailboxL.isEmpty()) {
            mapa.add(1, listCnalrTaskMailboxL);
        } else {
            mapa.add(1, null);
        }

        return mapa;
    }

//    private boolean validarRequisitosUpdate(
//            com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailbox,
//            TE_Cabecera te_Cabecera, CnalaTaskMailbox cnalaTaskMailbox) throws TE_Excepcion {
//
//        // Después se debe comprobar que el código del buzón recibido
//        // (TaskMailbox.code)
//        // no está dado de alta en otro buzón. Para ello se comprobará que en la
//        // tabla de buzones de tareas
//
//        // si viene informado le taskMailBox compruebo que Exirta
//        if (taskMailbox.getFunctionalPool() != null
//                && taskMailbox.getFunctionalPool().getId() != null) {
//            CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
//            // taskMailbox.getFunctionalPool().getId()
//            cnalpFunctionalPool = cnalpFunctionalPoolRepository
//                    .findOne(taskMailbox.getFunctionalPool().getId());
//
//            if (cnalpFunctionalPool == null) {
//                return false;
//            }
//        }
//
//        if (taskMailbox.getOrganizationPoolAssignment() != null
//                && taskMailbox.getOrganizationPoolAssignment().getId() != null) {
//
//            Specifications<CnalrOrgaPoolAssignment> lista = Specifications.where(null);
//            lista = lista.and(OrganizationPoolAssignmentSpecification.byOrganizationPoolAssignment(
//                    taskMailbox.getOrganizationPoolAssignment().getId()));
//            if (taskMailbox.getFunctionalPool() != null
//                    && taskMailbox.getFunctionalPool().getId() != null) {
//                lista = lista.and(OrganizationPoolAssignmentSpecification
//                        .byFunctionalPool(taskMailbox.getFunctionalPool().getId()));
//            }
//
//            // cnalrOrgaPoolAssignment =
//            // functionalPoolDao.findCnalrOrgaPoolAssignmentByRoleFunct(taskMailbox.getOrganizationPoolAssignment().getId(),taskMailbox.getFunctionalPool().getId()
//            // );
//            List<CnalrOrgaPoolAssignment> listaCnalr = cnalrOrgaPoolAssignmentRepository
//                    .findAll(lista);
//
//            if (!listaCnalr.isEmpty()) {
//                return false;
//            }
//
//        }
//
//        return true;
//    }

    private CnalaTaskMailbox montarCnalaTaskMailboxCrearManage(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailbox,
            TE_Cabecera te_Cabecera) throws TE_Excepcion {

        CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();

        List<CnalrTaskMailboxL> listCnalrTaskMailboxL = new ArrayList<CnalrTaskMailboxL>();
        CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();

        if (taskMailbox.getName().getMultiLanguages() != null
                && taskMailbox.getName().getMultiLanguagesLength() > 0
                && taskMailbox.getName().getMultiLanguages(0).getLanguageCode() != null) {

            for (int i = 0; i < taskMailbox.getName().getMultiLanguagesLength(); i++) {
                String idioma = languageService.getIdiomaPorDefecto();
                if (taskMailbox.getName().getMultiLanguages(i).getLanguageCode()
                        .equals(Long.valueOf(idioma))) {
                    cnalaTaskMailbox.setLboxNaMailbox(
                            taskMailbox.getName().getMultiLanguages(i).getValue());
                } else {
                    cnalrTaskMailboxL = new CnalrTaskMailboxL();
                    cnalrTaskMailboxL.setAudiTiCreation(new Timestamp(System.currentTimeMillis()));
                    try {
                        cnalrTaskMailboxL
                                .setUserIdCreatorParty(new BigDecimal(te_Cabecera.getIdUsuario()));
                        cnalrTaskMailboxL.setLangCoLanguage(
                                taskMailbox.getName().getMultiLanguages(i).getLanguageCode());
                    } catch (NullPointerException e) {
                        throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                                this.getMessagebyIdioma(null, "CANA_E_000132_MSG", new String[] {
                                        ScprpSalesChannelProposal.class.getName() }), e, ErrorType.T);
                    }

                    cnalrTaskMailboxL.setCnalaTaskMailbox(cnalaTaskMailbox);

                    cnalrTaskMailboxL.setLboxNaMailbox(
                            taskMailbox.getName().getMultiLanguages(i).getValue());

                    listCnalrTaskMailboxL.add(cnalrTaskMailboxL);
                }
            }
            cnalaTaskMailbox.setCnalrTaskMailboxLs(listCnalrTaskMailboxL);
        }

        cnalaTaskMailbox.setMboxCoFuncMailbox(taskMailbox.getCode());

        cnalaTaskMailbox.setMboxQuVolume(taskMailbox.getVolume());
        cnalaTaskMailbox.setMboxQuMaximumAmount(taskMailbox.getMaxQuantity());
        cnalaTaskMailbox.setMboxInBrotherReallocation(taskMailbox.isBrotherReallocation());
        
        if(taskMailbox.getState() != null) {
            cnalaTaskMailbox.setMboxInState(Long.valueOf(taskMailbox.getState()));
        }

        if (taskMailbox.getDistributionCriteria() != null
                && taskMailbox.getDistributionCriteria().getId() != null) {
            cnalaTaskMailbox.setGewfdDistributionCriteria(new GewfdDistributionCriteria());
            cnalaTaskMailbox.getGewfdDistributionCriteria()
                    .setDiscIdDistributionCriteria(taskMailbox.getDistributionCriteria().getId());
        } /*
            CAMBIO CORREO IVAN PELAEZ (Renviado Davila) 06/03/2017 17:11
        else {
            GewfdDistributionCriteria gewfdDistributionCriteria = new GewfdDistributionCriteria();
            gewfdDistributionCriteria.setDiscIdDistributionCriteria(4l);
            cnalaTaskMailbox.setGewfdDistributionCriteria(gewfdDistributionCriteria);
        }*/
        if (taskMailbox.getRule() != null && taskMailbox.getRule().getId() != null) {
            cnalaTaskMailbox.setRuleIdRule(taskMailbox.getRule().getId());
        }
        if (taskMailbox.getFunctionalPool() != null
                && taskMailbox.getFunctionalPool().getId() != null) {
            CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
            cnalpFunctionalPool = cnalpFunctionalPoolRepository.findOne(taskMailbox.getFunctionalPool().getId());
            if(cnalpFunctionalPool == null || cnalpFunctionalPool.getWpooIdFunctionalPool() == null) {
            	throw new TE_Excepcion(
            	        this.getMessagebyIdioma(null, "CANA_E_000127", null),
			            this.getMessagebyIdioma(null, "CANA_E_000127_MSG", new String[] { "FunctionalPool.id: " +  taskMailbox.getFunctionalPool().getId().toString()}), null, ErrorType.F);
            }
            cnalaTaskMailbox.setCnalpFunctionalPool(cnalpFunctionalPool);
        }

        if (taskMailbox.getOrganizationPoolAssignment() != null
                && taskMailbox.getOrganizationPoolAssignment().getId() != null) {

        	CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment = null;
				cnalrOrgaPoolAssignment = cnalrOrgaPoolAssignmentRepository.findOne(taskMailbox.getOrganizationPoolAssignment().getId());
			if (cnalrOrgaPoolAssignment == null) {
			    throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000127", null),
			            this.getMessagebyIdioma(null, "CANA_E_000127_MSG",
			                    new String[] { "cnalROrgaPoolAssignment.id: " +  taskMailbox.getOrganizationPoolAssignment().getId().toString() }), null, ErrorType.F);
			}
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment1(cnalrOrgaPoolAssignment);
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment);
            
        }
        
        Calendar calendarStartValidity = Calendar.getInstance();
        Calendar calendarEndValidity = Calendar.getInstance();
                
        calendarStartValidity.setTime(taskMailbox.getValidFor().getStartDateTime());
        calendarStartValidity.set(Calendar.HOUR_OF_DAY, 0);
        calendarStartValidity.set(Calendar.MINUTE, 0);
        calendarStartValidity.set(Calendar.SECOND, 0);
        calendarStartValidity.set(Calendar.MILLISECOND, 0);
        
        cnalaTaskMailbox.setMboxTiStartValidity(
                new Timestamp(calendarStartValidity.getTimeInMillis()));
                
        if (taskMailbox.getValidFor().getEndDateTime() != null) {
            calendarEndValidity.setTime(taskMailbox.getValidFor().getEndDateTime());
            calendarEndValidity.set(Calendar.HOUR_OF_DAY, 23);
            calendarEndValidity.set(Calendar.MINUTE, 59);
            calendarEndValidity.set(Calendar.SECOND, 59);  
            calendarEndValidity.set(Calendar.MILLISECOND, 999);
            cnalaTaskMailbox.setMboxTiEndValidity(
                    new Timestamp(calendarEndValidity.getTimeInMillis()));
        } else {
            cnalaTaskMailbox.setMboxTiEndValidity(null);
        }
        
        // SLB5 - Nuevos campos
        if (taskMailbox.getApplication() != null && taskMailbox.getApplication().getId() != null) {
        	cnalaTaskMailbox.setGenaIdApplication(taskMailbox.getApplication().getId());
        }
        cnalaTaskMailbox.setMboxInDistributionMode((taskMailbox.getDistributionMode() != null) ? Long.valueOf(taskMailbox.getDistributionMode()) : null);
        cnalaTaskMailbox.setMboxInGroupDistribCriteria((taskMailbox.getGroupDistributionCriteria() != null) ? Long.valueOf(taskMailbox.getGroupDistributionCriteria()) : null);
        cnalaTaskMailbox.setMboxInManualDistribMode((taskMailbox.getManualDistributionMode() != null) ? Long.valueOf(taskMailbox.getManualDistributionMode()) : null);
        
        cnalaTaskMailbox.setAudiTiCreation(new Timestamp(System.currentTimeMillis()));
        try {
            cnalaTaskMailbox.setUserIdCreatorParty(new BigDecimal(te_Cabecera.getIdUsuario()));
        } catch (NullPointerException e) {
            throw new TE_Excepcion(this.getMessagebyIdioma(null, "CANA_E_000132", null),
                    this.getMessagebyIdioma(null, "CANA_E_000132_MSG",
                            new String[] { ScprpSalesChannelProposal.class.getName() }), e, ErrorType.T);
        }

        return cnalaTaskMailbox;
    }

    private boolean compruebaDatosCompletosTaskMailbox(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailbox,
            TE_Cabecera te_Cabecera) {

        if (taskMailbox.getName() == null) {
            LOGGER.debug("[{}] - Falta parámetro obligatorio: customerInquiryType.getName()");
            return false;
        } else if (taskMailbox.getName().getMultiLanguages(0) == null) {
            LOGGER.debug("[{}] - Falta parámetro obligatorio: customerInquiryType.getName()");
            return false;
        } else if (taskMailbox.getName().getMultiLanguages(0).getValue() == null) {
            LOGGER.debug("[{}] - Falta parámetro obligatorio: customerInquiryType.getName()");
            return false;
        } else if ("".equals(taskMailbox.getName().getMultiLanguages(0).getValue())) {
            LOGGER.debug("[{}] - Falta parámetro obligatorio: customerInquiryType.getName()");
            return false;
        } else if (taskMailbox.getCode() == null || "".equals(taskMailbox.getCode())) {
            LOGGER.debug("[{}] - Falta parámetro obligatorio: taskMailbox.getCode()");
            return false;
        } else if (taskMailbox.getValidFor() == null) {
            LOGGER.debug("[{}] - Falta parámetro obligatorio: customerInquiryType.getValidFor()");
            return false;
        } else if (taskMailbox.getValidFor().getStartDateTime() == null) {
            LOGGER.debug(
                    "[{}] - Falta parámetro obligatorio: taskMailbox.getValidFor().getStartDateTime()");
            return false;
        } else if (taskMailbox.getFunctionalPool() != null) {
            if (taskMailbox.getFunctionalPool().getId() == null) {
                LOGGER.debug(
                        "[{}] - Falta parámetro obligatorio: taskMailbox.getFunctionalPool().getId() ");
                return false;
            }
        } else if (taskMailbox.getOrganizationPoolAssignment() != null) {
            if (taskMailbox.getOrganizationPoolAssignment().getId() == null) {
                LOGGER.debug(
                        "[{}] - Falta parámetro obligatorio: taskMailbox.getOrganizationPoolAssignment().getId() ");
                return false;
            }
        }
        return true;
    }

    private boolean validarRequisitosInsert(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailboxDTO,
            TE_Cabecera teCabecera, CnalaTaskMailbox cnala_TaskMailbox) throws TE_Excepcion {

        // Después se debe comprobar que el código del buzón recibido
        // (TaskMailbox.code)
        // no está dado de alta en otro buzón. Para ello se comprobará que en la
        // tabla de buzones de tareas
 
        Specifications<CnalaTaskMailbox> lista = Specifications.where(null);

        lista = lista
                .and(TaskMailboxSpecifications.byCode(cnala_TaskMailbox.getMboxCoFuncMailbox()));
        if (cnala_TaskMailbox.getCnalpFunctionalPool() != null) {
            lista = lista.and(TaskMailboxSpecifications.byIdFunctionalPool(
                    cnala_TaskMailbox.getCnalpFunctionalPool().getWpooIdFunctionalPool()));
        }
        if (cnala_TaskMailbox.getCnalrOrgaPoolAssignment1() != null) {
            lista = lista.and(TaskMailboxSpecifications.byIdOrganizationRole(
                    cnala_TaskMailbox.getCnalrOrgaPoolAssignment1().getParoIdOrganizationRole()));
        }
        if (cnala_TaskMailbox.getGewfdDistributionCriteria() != null) {
            lista = lista.and(TaskMailboxSpecifications.byIdDistributionCriteria(
                    (cnala_TaskMailbox.getGewfdDistributionCriteria()
                            .getDiscIdDistributionCriteria()).intValue()));
        }
        if (cnala_TaskMailbox.getRuleIdRule() != null) {
            lista = lista
                    .and(TaskMailboxSpecifications.byIdRule(cnala_TaskMailbox.getRuleIdRule()));
        }

        java.sql.Date fromDate = null;
        java.sql.Date toDate = null;
        
        if (cnala_TaskMailbox.getMboxTiStartValidity() != null) {
            fromDate =  new java.sql.Date(cnala_TaskMailbox.getMboxTiStartValidity().getTime());
        }
        
        if (cnala_TaskMailbox.getMboxTiEndValidity() != null) {
            toDate =  new java.sql.Date(cnala_TaskMailbox.getMboxTiEndValidity().getTime());
        }
        lista = lista.and(TaskMailboxSpecifications.byRangeDate(toDate, fromDate));
        List<CnalaTaskMailbox> listaCnala = taskMailboxRepository.findAll(lista);

        if (!listaCnala.isEmpty()) {
            return false;
        }


        return true;
    }
    // --------------------fin metodos privador manageTaskMailBox

	/**
	 * @author MRUNORES
	 */
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
	public ReassignTasksMailbox_OUT reassignTasksMailbox(ReassignTasksMailbox_IN reassigntasksmailbox_in,
			TE_Cabecera te_Cabecera, TE_Metadatos te_Metadatos) throws TE_Excepcion {

		
		LOGGER.debug("Inicio del metodo reassignTasksMailbox");
		
		boolean obligatoriosOK = false;
		
		obligatoriosOK = this.comprobarObligatoriosReassignTasksMailbox(reassigntasksmailbox_in);
		
		if (!obligatoriosOK) {
			LOGGER.debug("Faltan parámetros obligatorios");
			throw new TE_Excepcion(
             		this.getMessagebyIdioma(null, "CANA_E_000131", null),
             		this.getMessagebyIdioma(null, "CANA_E_000131_MSG",
                             new String[] { "reassignTasksMailbox" }), null, ErrorType.F);
		}
		
		if (!reassigntasksmailbox_in.getOrganizationRole().getOrganizationRoleSpec().getId().equals(Long.valueOf(106L))) {
			LOGGER.debug("el valor del organizationRoleSpec debe ser 106");
			throw new TE_Excepcion(
             		this.getMessagebyIdioma(null, "CANA_E_000144", null),
             		this.getMessagebyIdioma(null, "CANA_E_000144_MSG", null), null, ErrorType.F);
		}
		
		com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_OUT findTaskList_OUT = null;
		TE_API_Worklist worklist2 = null;
		
		try {
		    /*
		    Una vez validado, recuperamos las tareas del organizationRole que viene en la entrada y 
		    se recupera sin criterios de búsqueda y ordenación. Para ello, realizamos una llamada a 
		    la operación: OP_findTaskList() informando el ID del organizationRole recibido en la 
		    entrada de la operación. Se puede consultar el mapeo en el apartado 5.2.3.3.
			*/
			worklist2 = this.initWorklist(reassigntasksmailbox_in.getOrganizationRole().getId(), te_Cabecera);
			findTaskList_OUT = this.llamadaFindTaskList(worklist2, reassigntasksmailbox_in.getOrganizationRole().getId(), te_Cabecera);
		} catch (ServicioTareaException | TE_Excepcion e) {
			throw new TE_Excepcion(
             		this.getMessagebyIdioma(null, "CANA_E_000142", null),
             		this.getMessagebyIdioma(null, "CANA_E_000142_MSG",
                             new String[] { "Tran - FindTaskList()" }), e, ErrorType.T);
		}
		
		if (findTaskList_OUT != null) {
			
			if (findTaskList_OUT.getUserTasks() != null && findTaskList_OUT.getUserTasksLength() > 0) {
				
				TE_API_Worklist worklist = null;
				
				try {
	
			        String tokenC = worklist2.conexiones().get("BSS").getCtx().getToken();
			        String urlC = worklist2.conexiones().get("BSS").getUrlDominio();
			        worklist = this.initWorklist(urlC, tokenC, te_Cabecera);
				} catch (ServicioTareaException e) {
			        LOGGER.error("getTaskDetail - [{}] [{}] [{}] ", e.getErrorCode(), e.getMessage(), e.getCause());
			        throw new TE_Excepcion(e.getErrorCode(), e.getMessage(), e, ErrorType.T);
			    }
				
				List <com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN> listUserTask_DTO_IN =
						new ArrayList <com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN>();
				/*
			    Con el listado de tareas, por cada una de ellas, llamamos a la operación: OP_getTaskDetail() para recuperar el ownerGroup.
				*/
				for (com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT exploraUserTask_DTO_OUT : findTaskList_OUT.getUserTasks()) {
					
					try {
					    
						GetTaskDetail_OUT getTaskDetail_OUT = 
						        this.llamadaGetTaskDetail(
						                worklist,
						                exploraUserTask_DTO_OUT,
						                te_Cabecera);
						
						if (getTaskDetail_OUT != null 
						        && getTaskDetail_OUT.getUserTask() != null 
						        && getTaskDetail_OUT.getUserTask().getTaskMailboxOwner() != null) {
							/*
						    Si viene informado, hacemos la reasignación llamando a la operación: OP_reassignTask().
						     Se puede consultar el mapeo en el apartado 5.2.3.3.
							*/
						    com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN userTask_DTO_IN = 
									new com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN();
							
							userTask_DTO_IN = this.montarListaReassignTask(exploraUserTask_DTO_OUT, getTaskDetail_OUT.getUserTask().getTaskMailboxOwner(),
									reassigntasksmailbox_in.getOrganizationRole().getId());
							
							listUserTask_DTO_IN.add(userTask_DTO_IN);
							
							
						} else {
							throw new TE_Excepcion(
				             		this.getMessagebyIdioma(null, "CANA_E_000143", null),
				             		this.getMessagebyIdioma(null, "CANA_E_000143_MSG",
				                             new String[] { "Tran - GetTaskDetail()" }), null, ErrorType.F);
						}
						
						
					} catch (TE_Excepcion e) {
						throw new TE_Excepcion(
			             		this.getMessagebyIdioma(null, "CANA_E_000143", null),
			             		this.getMessagebyIdioma(null, "CANA_E_000143_MSG",
			                             new String[] { "Tran - GetTaskDetail()" }), null, ErrorType.F);
					}
				}
				
				try {
					this.llamadaReassignTask(worklist2, listUserTask_DTO_IN, te_Cabecera);
				} catch (ServicioTareaException | TE_Excepcion e) {
					throw new TE_Excepcion(
		             		this.getMessagebyIdioma(null, "CANA_E_000143", null),
		             		this.getMessagebyIdioma(null, "CANA_E_000143_MSG",
		                             new String[] { "Tran - ReassignTask()" }), e, ErrorType.T);
				}
				
			}
		}
		
		ReassignTasksMailbox_OUT reassignTasksMailbox_OUT = new ReassignTasksMailbox_OUT();
		LOGGER.debug("Fin del metodo reassignTasksMailbox");
		return reassignTasksMailbox_OUT;

	}

	private com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN montarListaReassignTask(
	        com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT exploraUserTask_DTO_OUT,
			com.telefonica.tran.api.workspace.msg.gettaskdetail.TaskMailbox_DTO_OUT taskMailboxOwner,
			BigDecimal idOrganizationRole) {
		
				
		com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN userTask_DTO_IN = 
				new com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN();
		
		userTask_DTO_IN.setCode(exploraUserTask_DTO_OUT.getCode());
		userTask_DTO_IN.setDomain(exploraUserTask_DTO_OUT.getDomain());
				
		com.telefonica.tran.api.workspace.msg.reassigntask.TaskMailbox_DTO_IN_1 taskMailbox_DTO_IN_1 =
				new com.telefonica.tran.api.workspace.msg.reassigntask.TaskMailbox_DTO_IN_1();
		
		taskMailbox_DTO_IN_1.setCode(taskMailboxOwner.getCode());
		
		userTask_DTO_IN.setOwnerGroup(taskMailbox_DTO_IN_1);
		com.telefonica.tran.api.workspace.msg.reassigntask.TaskMailbox_DTO_IN taskMailbox = new com.telefonica.tran.api.workspace.msg.reassigntask.TaskMailbox_DTO_IN();
		taskMailbox.setCode(taskMailboxOwner.getCode());
        userTask_DTO_IN.setTaskMailbox(taskMailbox);
		
		return userTask_DTO_IN;
		
	}
	
	
	public GetTaskDetail_OUT llamadaGetTaskDetail(
			TE_API_Worklist worklist, 
	        com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT exploraUserTask_DTO_OUT, TE_Cabecera te_Cabecera) throws TE_Excepcion  {

	    LOGGER.debug("inicio del método llamadaGetTaskDetail");

	    com.telefonica.tran.api.workspace.msg.gettaskdetail.GetTaskDetail_IN servicio_dto_in = 
	            new com.telefonica.tran.api.workspace.msg.gettaskdetail.GetTaskDetail_IN();
	    com.telefonica.tran.api.workspace.msg.gettaskdetail.UserTask_DTO_IN userTask =
	            new com.telefonica.tran.api.workspace.msg.gettaskdetail.UserTask_DTO_IN();
	    userTask.setCode(exploraUserTask_DTO_OUT.getCode());
	    servicio_dto_in.setUserTask(userTask );
	    servicio_dto_in.setBlock(Boolean.FALSE);

	    try {

	        com.telefonica.tran.api.workspace.msg.gettaskdetail.GetTaskDetail_OUT servicio_dto_out = worklist
	                .getTaskDetail(servicio_dto_in);

	        return servicio_dto_out;

	    } catch (ServicioTareaException e) {
	        LOGGER.error("getTaskDetail - [{}] [{}] [{}] ", e.getErrorCode(), e.getMessage(), e.getCause());
	        throw new TE_Excepcion(e.getErrorCode(), e.getMessage(), e, ErrorType.T);
	    }

	}
	
	
	/**
     * Genera la conexion con el BPM por gestor.
	 * @param idOrganizationRole 
     * 
     * @param idGestor
     *            id del Gestor
     * @param teCabecera
     *            datos de la cabecera
     * @return instancia de TE_API_Worklist
     * @throws ServicioTareaException
     *             error en la conexion a dominios
     */
    public TE_API_Worklist initWorklist(BigDecimal idOrganizationRole, TE_Cabecera teCabecera)throws TE_Excepcion {

        try {
            TE_API_Worklist oWorkList = new TE_API_Worklist(idOrganizationRole.toString(),teCabecera);
            Map<String, ServicioTareaException> erroresCnx = oWorkList.opErroresConexion();
            if (erroresCnx != null && erroresCnx.size() > 0) {
                LOGGER.error("initWorklist - [{}] [{}] [{}] ", erroresCnx, "Error de Conexion", "");
            }
            return oWorkList;
        } catch (ServicioTareaException e) {
            LOGGER.error("initWorklist - [{}] [{}] [{}] ", e.getErrorCode(), e.getMessage(), e.getCause());
            throw new TE_Excepcion(e.getErrorCode(), e.getMessage(), e, ErrorType.T);
        }
    }

    /*
    private TE_API_Worklist initWorklistAdmin(BigDecimal idOrganizationRole, TE_Cabecera teCabecera)throws TE_Excepcion {

        try {
            TE_API_Worklist oWorkList = new TE_API_Worklist(idOrganizationRole.toString(), Boolean.TRUE, teCabecera);
            Map<String, ServicioTareaException> erroresCnx = oWorkList.opErroresConexion();
            if (erroresCnx != null && erroresCnx.size() > 0) {
                LOGGER.error("initWorklist - [{}] [{}] [{}] ", erroresCnx, "Error de Conexion", "");
            }
            return oWorkList;
        } catch (ServicioTareaException e) {
            LOGGER.error("initWorklist - [{}] [{}] [{}] ", e.getErrorCode(), e.getMessage(), e.getCause());
            throw new TE_Excepcion(e.getErrorCode(), e.getMessage(), e, ErrorType.T);
        }
    }*/
    

	/**
     * Genera la conexion con el BPM por gestor.
     * 
     * @param idGestor
     *            id del Gestor
     * @param teCabecera
     *            datos de la cabecera
     * @return instancia de TE_API_Worklist
	 * @throws com.telefonica.tran.api.workspace.exception.ServicioTareaException 
     * @throws ServicioTareaException
     *             error en la conexion a dominios
     */
    private TE_API_Worklist initWorklist(String url, String contextId, TE_Cabecera teCabecera) throws TE_Excepcion {

        try {
            TE_API_Worklist oWorkList = new TE_API_Worklist(url, contextId, teCabecera);
            //TE_API_Worklist oWorkList = new TE_API_Worklist(this.getIdGestor(),teCabecera);
            Map<String, ServicioTareaException> erroresCnx = oWorkList.opErroresConexion();
            if (erroresCnx != null && erroresCnx.size() > 0) {
                LOGGER.error("initWorklist - [{}] [{}] [{}] ", erroresCnx, "Error de Conexion", "");
            }
            return oWorkList;
        } catch (ServicioTareaException e) {
            LOGGER.error("initWorklist - [{}] [{}] [{}] ", e.getErrorCode(), e.getMessage(), e.getCause());
            throw new TE_Excepcion(e.getErrorCode(), e.getMessage(), e, ErrorType.T);
        }
    }
    

	public FindTaskList_OUT llamadaFindTaskList(
			TE_API_Worklist worklist, BigDecimal idOrganizationRole, TE_Cabecera te_Cabecera)  throws TE_Excepcion, ServicioTareaException {

		LOGGER.debug("Inicio del método llamadaFindTaskList");

		com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_IN findTaskList_IN = 
				new com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_IN();
		
		com.telefonica.tran.api.workspace.msg.findtasklist.OrganizationRole_DTO_IN organizationRole_DTO_IN =
				new com.telefonica.tran.api.workspace.msg.findtasklist.OrganizationRole_DTO_IN();
		
		organizationRole_DTO_IN.setId(idOrganizationRole);
		
		findTaskList_IN.setOrganizationRole(organizationRole_DTO_IN);

		try {
		    FindTaskList_OUT servicio_dto_out = worklist.findTaskList(findTaskList_IN);

		    LOGGER.debug("Fin del método llamadaFindTaskList");
		    return servicio_dto_out;

		} catch (ServicioTareaException e) {
		    LOGGER.error("getTaskDetail - [{}] [{}] [{}] ", e.getErrorCode(), e.getMessage(), e.getCause());
		    throw new TE_Excepcion(e.getErrorCode(), e.getMessage(), e, ErrorType.T);
		}

	}
	

	public com.telefonica.tran.api.workspace.msg.reassigntask.ReassignTask_OUT llamadaReassignTask(
			TE_API_Worklist worklist,
			List <com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN> listUserTask_DTO_IN, 
			TE_Cabecera te_Cabecera) throws TE_Excepcion, ServicioTareaException {

		LOGGER.debug("inicio del método llamadaReassignTask");

		com.telefonica.tran.api.workspace.msg.reassigntask.ReassignTask_IN reassignTask_IN = 
				new com.telefonica.tran.api.workspace.msg.reassigntask.ReassignTask_IN();

		reassignTask_IN.setUserTasks(listUserTask_DTO_IN.toArray(
				new com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN[listUserTask_DTO_IN.size()]));

		//REVISAR
		  try {

	            com.telefonica.tran.api.workspace.msg.reassigntask.ReassignTask_OUT reassignTask_OUT = 
	                    worklist.reassignTask(reassignTask_IN);

	            return reassignTask_OUT;

	        } catch (ServicioTareaException e) {
	            LOGGER.error("getTaskDetail - [{}] [{}] [{}] ", e.getErrorCode(), e.getMessage(), e.getCause());
	            throw new TE_Excepcion(e.getErrorCode(), e.getMessage(), e, ErrorType.T);
	        }
	}
	
	
	/**
	 * 
	 * @param reassigntasksmailbox_in
	 * @return
	 */
	private boolean comprobarObligatoriosReassignTasksMailbox(ReassignTasksMailbox_IN reassigntasksmailbox_in) {
		
		boolean obligatoriosOK = true;
		
		if (reassigntasksmailbox_in == null) {
			obligatoriosOK = false;
		} else if (reassigntasksmailbox_in.getOrganizationRole() == null) {
			obligatoriosOK = false;
		} else if (reassigntasksmailbox_in.getOrganizationRole().getId() == null) {
			obligatoriosOK = false;
		} else if (reassigntasksmailbox_in.getOrganizationRole().getOrganizationRoleSpec() == null) {
			obligatoriosOK = false;
		} else if (reassigntasksmailbox_in.getOrganizationRole().getOrganizationRoleSpec().getId() == null){
			obligatoriosOK = false;
		}
		
		return obligatoriosOK;
	}


	public String getMessagebyIdioma(String idioma, String codigo, String[] arguments) {
		return CommonUtilitiesServiceImpl.getMessagebyIdioma(idioma, codigo, arguments);
	}
	
	
	
	private GetOrganizationRoleByFuncRole_OUT llamadaGetOrganizationRoleByFuncRole_OUT_ID(
	        BigDecimal id,
			TE_Cabecera te_Cabecera) throws TE_Excepcion {

		LOGGER.debug("inicio del método llamadaGetFunctionalRole");
        
		GetOrganizationRoleByFuncRole_IN getOrganizationRoleByFuncRole_IN = new GetOrganizationRoleByFuncRole_IN();

		List <com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_IN> listFunctionalRole_DTO_IN =
		        new ArrayList <com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_IN>();
		
	    com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_IN functionalRole_DTO_IN =
	            new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_IN();
	    
	    functionalRole_DTO_IN.setId(id);
	    
	    listFunctionalRole_DTO_IN.add(functionalRole_DTO_IN);
		        
		getOrganizationRoleByFuncRole_IN.setFunctionalRoles(listFunctionalRole_DTO_IN.toArray(
				new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_IN[listFunctionalRole_DTO_IN.size()]));
		
		Holder<TE_Cabecera> holderCabecera = new Holder<TE_Cabecera>(te_Cabecera);
		
		holderCabecera.value.setFechaPeticion(new Date());
		
		Holder<TE_Metadatos> holderMetadatos = 
        		new Holder<TE_Metadatos>(CommonUtilitiesServiceImpl.crearMetadatos("", 1l, 100l));

		LOGGER.debug("Llamada a llamadaGetFunctionalRole");
		
		GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = 
				llamadaGetOrganizationRoleByFuncRole_objetoSalida(getOrganizationRoleByFuncRole_IN, holderCabecera,
					holderMetadatos);
		
		return getOrganizationRoleByFuncRole_OUT;
	}
	
	
	private GetOrganizationRoleByFuncRole_OUT llamadaGetOrganizationRoleByFuncRole_OUT_LIST(
            List <com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_IN> listFunctionalRole_DTO_IN,
            TE_Cabecera te_Cabecera) throws TE_Excepcion {

        LOGGER.debug("inicio del método llamadaGetFunctionalRole");
        
        GetOrganizationRoleByFuncRole_IN getOrganizationRoleByFuncRole_IN = new GetOrganizationRoleByFuncRole_IN();

        getOrganizationRoleByFuncRole_IN.setFunctionalRoles(listFunctionalRole_DTO_IN.toArray(
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_IN[listFunctionalRole_DTO_IN.size()]));
        
        Holder<TE_Cabecera> holderCabecera = new Holder<TE_Cabecera>(te_Cabecera);
        
        holderCabecera.value.setFechaPeticion(new Date());
        
        Holder<TE_Metadatos> holderMetadatos = 
                new Holder<TE_Metadatos>(CommonUtilitiesServiceImpl.crearMetadatos("", 1l, 100l));

        LOGGER.debug("Llamada a llamadaGetFunctionalRole");
        
        GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = 
                this.llamadaGetOrganizationRoleByFuncRole_objetoSalida(
                        getOrganizationRoleByFuncRole_IN,
                        holderCabecera,
                        holderMetadatos);
        
        return getOrganizationRoleByFuncRole_OUT;
    }
	
	
	public GetOrganizationRoleByFuncRole_OUT llamadaGetOrganizationRoleByFuncRole_objetoSalida(
			GetOrganizationRoleByFuncRole_IN getOrganizationRoleByFuncRole_IN, Holder<TE_Cabecera> holderCabecera,
			Holder<TE_Metadatos> holderMetadatos) throws TE_Excepcion {
		
		String endpoint = serviceRegistry.getEndpoint("uddi:gest.srv-exp-EngRoleExt-v3");
	    
		com.telefonica.gest.srv.exp.engroleext.facade.EngRoleExtExpServicePortType port = 
				new com.telefonica.gest.srv.exp.engroleext.facade.EngRoleExtExpServiceClient().getSrvExpEngRoleExtPort();
		BindingProvider bindingProvider = (BindingProvider) port;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
		bindingProvider.getRequestContext().put("com.sun.xml.ws.connect.timeout",
				env.getRequiredProperty("system.ws.connect.timeout", Integer.class));
		bindingProvider.getRequestContext().put("com.sun.xml.ws.request.timeout",
				env.getRequiredProperty("system.ws.request.timeout", Integer.class));

		
		return port.getOrganizationRoleByFuncRole(getOrganizationRoleByFuncRole_IN, holderCabecera, holderMetadatos);
	}
     
}