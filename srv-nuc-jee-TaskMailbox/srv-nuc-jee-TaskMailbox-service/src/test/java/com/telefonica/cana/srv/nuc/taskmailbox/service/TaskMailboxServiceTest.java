package com.telefonica.cana.srv.nuc.taskmailbox.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.ContextConfiguration;

import com.telefonica.cana.dao.functionalpoolassignment.repository.GewfrMailboxAccessRepository;
import com.telefonica.cana.dao.saleschannelproposal.repository.ScprpSalesChannelProposalRepository;
import com.telefonica.cana.dao.taskmailbox.dto.OrganizationPoolAssignmentDTO;
import com.telefonica.cana.dao.taskmailbox.repository.CnalaEnteFunctionTreeNodeRepository;
import com.telefonica.cana.dao.taskmailbox.repository.CnalaTaskMailboxRepository;
import com.telefonica.cana.dao.taskmailbox.repository.CnalpFuncPoolAssignmentRepository;
import com.telefonica.cana.dao.taskmailbox.repository.CnalpFunctionalPoolRepository;
import com.telefonica.cana.dao.taskmailbox.repository.CnalrOrgaPoolAssignmentRepository;
import com.telefonica.cana.dao.taskmailbox.repository.CnalrTaskMailboxRepository;
import com.telefonica.cana.model.CecaaChanAdeqStateMov;
import com.telefonica.cana.model.CecadChannelAdequacyState;
import com.telefonica.cana.model.CecarChanAdeqStateRel;
import com.telefonica.cana.model.CnalaEnteFunctionTreeNode;
import com.telefonica.cana.model.CnalaTaskMailbox;
import com.telefonica.cana.model.CnaldEnterpriseFunction;
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
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.Application_DTO_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FindFullTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FindFullTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.DistributionCriteria_DTO_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FindTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FindTaskMailbox_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.Rule_DTO_IN;
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
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.GetOrganizationTaskMailboxByFunctionalPool_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.GetOrganizationTaskMailboxByFunctionalPool_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.EnterpriseFunctionTreeNode_DTO_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.GetTaskMailboxTreeByEnterpriseFunction_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.GetTaskMailboxTreeByEnterpriseFunction_OUT;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN;
import com.telefonica.cana.srv.nuc.taskmailbox.service.impl.TaskMailboxServiceImpl;
import com.telefonica.cana.srv.util.enumerados.enums.ET_ChannelAdecuacyState;
import com.telefonica.coco.lib.language.LanguageService;
import com.telefonica.coco.lib.uddi.ServiceRegistry;
import com.telefonica.gere.srv.exp.rulequery.msg.getrules.GetRules_OUT;
import com.telefonica.gere.srv.exp.rulequery.msg.getrules.Rule_DTO_OUT;
import com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_OUT;
import com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.Party_DTO_OUT;
import com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.GetFunctionalRole_OUT;
import com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.GetOrganizationRoleByFuncRole_IN;
import com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.GetOrganizationRoleByFuncRole_OUT;
import com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_OUT;
import com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationName_DTO_OUT;
import com.telefonica.gstr.srv.exp.application.msg.listapplication.ListApplication_OUT;
import com.telefonica.tran.api.workspace.exception.ServicioTareaException;
import com.telefonica.tran.api.workspace.impl.TE_API_Worklist;
import com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT;
import com.telefonica.tran.api.workspace.msg.reassigntask.ReassignTask_OUT;
import com.telefonica.tran.comarq.cc.cabecera.TE_Cabecera;
import com.telefonica.tran.comarq.cc.cabecera.TE_GestionCabecera;
import com.telefonica.tran.comarq.cc.error.TE_Excepcion;
import com.telefonica.tran.comarq.cc.idioma.TE_Idioma;
import com.telefonica.tran.comarq.cc.metadatos.TE_Busqueda;
import com.telefonica.tran.comarq.cc.metadatos.TE_Metadatos;
import com.telefonica.tran.comarq.cc.metadatos.TE_Ordenacion;
import com.telefonica.tran.comarq.cc.metadatos.TE_Paginacion;
import com.telefonica.tran.comarq.cc.metadatos.TE_PaginacionIN;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/srv-nuc-jee-TaskMailbox-test-context.xml")
public class TaskMailboxServiceTest {

    @InjectMocks
    private TaskMailboxServiceImpl taskMailboxService;

    @InjectMocks
    private TaskMailboxServiceImpl taskMailboxServiceMock = org.mockito.Mockito.mock(TaskMailboxServiceImpl.class);
    
    @Mock
    private CnalaTaskMailboxRepository taskMailboxRepository;

    @Mock
    private CnalpFuncPoolAssignmentRepository cnalpFuncPoolAssignmentRepository;
    
    @Mock
    private com.telefonica.cana.dao.functionalpoolassignment.repository.CnalpFuncPoolAssignmentRepository cnalpFuncPoolAssignmentRepositoryFPA;

    @Mock
    private ScprpSalesChannelProposalRepository scprpSalesChannelProposalRepository;

    @Mock
    private CnalrOrgaPoolAssignmentRepository cnalrOrgaPoolAssignmentRepository;

    @Mock
    private CnalaTaskMailboxRepository cnalaTaskMailboxRepository;

    @Mock
    private Environment env;
    @Mock 
    LanguageService languageService;

    @Mock
    private com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT oop =
            org.mockito.Mockito.mock(com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT.class);
    
    @Mock
    private ServiceRegistry serviceRegistry;

    @Mock
    private CnalaEnteFunctionTreeNodeRepository cnalaEnteFunctionTreeNodeRepository;

    @Mock
    private CnalpFunctionalPoolRepository cnalpFunctionalPoolRepository;
    
    @Mock
    private CnalrTaskMailboxRepository cnalrTaskMailboxRepository;
    
    @Mock
    private GewfrMailboxAccessRepository gewfrMailboxAccessRepository;
    
    @Mock
    private TE_Idioma teIdioma;

    private TE_Cabecera cabecera;
    private TE_Metadatos metadatos;
    
    private TE_API_Worklist worklist;
    private TE_API_Worklist worklistAdmin;

    @org.junit.Before
    public final void setUp() throws TE_Excepcion, ParseException {

        try {
            metadatos = new TE_Metadatos();
            cabecera = TE_GestionCabecera.crearNuevaCabecera("TaskMailboxService", "TaskMailbox");

            TE_Ordenacion teOrdenacion = new TE_Ordenacion();
            teOrdenacion.setCriterioOrdenacions(new String[] { "AD_findFullTaskMailbox_configuracion1_DSC" });

            TE_Paginacion te_paginacion = new TE_Paginacion();

            TE_PaginacionIN paginacionIN = new TE_PaginacionIN();
            paginacionIN.setNumeroPagina(0L);
            paginacionIN.setTamanoVentana(100L);
            te_paginacion.setTE_PaginacionIN(paginacionIN);

            metadatos.setTE_Paginacion(te_paginacion);
            metadatos.setTE_Ordenacion(teOrdenacion);

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            cabecera.setFechaPeticion(df.parse("2013-01-01T10:00:00"));
            cabecera.setIdUsuario("0000000000000000000000000000000000001");
            cabecera.setIdOrigen("ORIGEN");
            cabecera.setLenguaje("001");
 
            org.mockito.Mockito
                    .when(taskMailboxServiceMock.findFullTaskMailbox(Mockito.any(FindFullTaskMailbox_IN.class),
                            Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class)))
                    .thenCallRealMethod();

            org.mockito.Mockito.when(taskMailboxServiceMock.findTaskMailBoxByResponsible(
                    Mockito.any(FindTaskMailBoxByResponsible_IN.class), Mockito.any(TE_Cabecera.class),
                    Mockito.any(TE_Metadatos.class))).thenCallRealMethod();

            org.mockito.Mockito.when(
                    taskMailboxServiceMock.findTasksMailBoxesManager(Mockito.any(FindTasksMailBoxesManager_IN.class),
                            Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class)))
                    .thenCallRealMethod();

            org.mockito.Mockito.when(
                    taskMailboxServiceMock.getFunctionalTaskMailbox(Mockito.any(GetFunctionalTaskMailbox_IN.class),
                            Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class)))
                    .thenCallRealMethod();

            org.mockito.Mockito.when(
                    taskMailboxServiceMock.findTaskMailboxOperators(Mockito.any(FindTaskMailboxOperators_IN.class),
                            Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class)))
                    .thenCallRealMethod();

            org.mockito.Mockito.when(taskMailboxServiceMock.findTaskMailbox(Mockito.any(FindTaskMailbox_IN.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenCallRealMethod();
            
            org.mockito.Mockito.when(taskMailboxServiceMock.manageTaskMailbox(Mockito.any(ManageTaskMailbox_IN.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenCallRealMethod();

            org.mockito.Mockito.when(languageService.getIdiomaPorDefecto()).thenReturn("1");

            org.mockito.Mockito.when(
                    taskMailboxServiceMock.getMessagebyIdioma(Mockito.anyString(), Mockito.anyString(), Mockito.any()))
                    .thenReturn("Error");
            
            org.mockito.Mockito.when(taskMailboxServiceMock.initWorklist(
            		Mockito.any(BigDecimal.class), 
            		Mockito.any(TE_Cabecera.class)))
            .thenCallRealMethod();
            //.thenReturn(new TE_API_Worklist("106", cabecera));
            
            org.mockito.Mockito.when(env.getRequiredProperty(Mockito.any(),Mockito.any())).thenReturn("1");

        } catch (TE_Excepcion e) {
            e.printStackTrace();
        }
    }

    @Test
    public void adFindFullTaskMailboxCorrectoSinResultados() throws TE_Excepcion {
        try {

            List<CnalaTaskMailbox> lista = new ArrayList<CnalaTaskMailbox>();

            Page<CnalaTaskMailbox> page = new PageImpl<CnalaTaskMailbox>(lista);

            Mockito.when(taskMailboxRepository.findFullTaskMailbox(Mockito.any(Specification.class),
                    Mockito.any(Pageable.class), Mockito.any(Sort.Order.class))).thenReturn(page);

            ListApplication_OUT listApplication_OUT = new ListApplication_OUT();
            listApplication_OUT.setGenericApplications(new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT[1]);
            listApplication_OUT.setGenericApplications(0, new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT());
            listApplication_OUT.getGenericApplications(0).setId(1L);
            listApplication_OUT.getGenericApplications(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_listApplication(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(listApplication_OUT);
            
            GetRules_OUT getRules_OUT = new GetRules_OUT();
            getRules_OUT.setRules(new Rule_DTO_OUT[1]);
            getRules_OUT.setRules(0, new Rule_DTO_OUT());
            getRules_OUT.getRules(0).setId(BigDecimal.ONE);
            getRules_OUT.getRules(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_getRules(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(getRules_OUT);
            
            FindFullTaskMailbox_IN findfulltaskmailbox_in = new FindFullTaskMailbox_IN();
            FindFullTaskMailbox_OUT ad_findfulltaskmailbox_out = taskMailboxServiceMock
                    .findFullTaskMailbox(findfulltaskmailbox_in, cabecera, metadatos);

            Assert.assertEquals(0, ad_findfulltaskmailbox_out.getTaskMailboxesLength());

        } catch (TE_Excepcion e) {
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void findTaskMailbox() throws TE_Excepcion {
        FindTaskMailbox_IN findTaskMailbox_In = new FindTaskMailbox_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN taskMailbox_In = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN organizationRoleIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN functionalPoolIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN();
        TE_Busqueda teBusqueda = new TE_Busqueda();
        TE_Ordenacion teOrdenacion = new TE_Ordenacion();
        TE_Paginacion tePaginacion = new TE_Paginacion();
        TE_PaginacionIN tePaginacionIn = new TE_PaginacionIN();
        List<CnalaTaskMailbox> lista = new ArrayList<CnalaTaskMailbox>();
        CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
        List<CnalrTaskMailboxL> listaCnalrTaskMailboxLs = new ArrayList<CnalrTaskMailboxL>();
        CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();
        taskMailbox_In.setCode("code");
        taskMailbox_In.setId(BigDecimal.ONE);
        organizationRoleIn.setId(BigDecimal.ONE);
        functionalPoolIn.setId(BigDecimal.ONE);

        tePaginacionIn.setNumeroPagina((long) 1);
        tePaginacionIn.setTamanoVentana((long) 50);
        tePaginacion.setTE_PaginacionIN(tePaginacionIn);

        metadatos.setTE_Busqueda(teBusqueda);
        metadatos.setTE_Ordenacion(teOrdenacion);
        metadatos.setTE_Paginacion(tePaginacion);

        cnalrTaskMailboxL.setLangCoLanguage((long) 1);
        cnalrTaskMailboxL.setLboxNaMailbox("string");

        listaCnalrTaskMailboxLs.add(cnalrTaskMailboxL);
        cnalaTaskMailbox.setCnalrTaskMailboxLs(listaCnalrTaskMailboxLs);
        
        GewfdDistributionCriteria gewfdDistributionCriteria = new GewfdDistributionCriteria();
        gewfdDistributionCriteria.setDiscIdDistributionCriteria(1L);
        gewfdDistributionCriteria.setDiclNaDistributionCriteria("name");
        gewfdDistributionCriteria.setDiscDaStartValidity(new Date());
        gewfdDistributionCriteria.setDiscDaEndValidity(new Date());
        cnalaTaskMailbox.setGewfdDistributionCriteria(gewfdDistributionCriteria);
        
        
        cnalaTaskMailbox.setRuleIdRule(BigDecimal.ONE);
        
        cnalaTaskMailbox.setCnalpFunctionalPool(new CnalpFunctionalPool());
        cnalaTaskMailbox.getCnalpFunctionalPool().setWpooIdFunctionalPool(BigDecimal.ONE);
        cnalaTaskMailbox.getCnalpFunctionalPool().setFupoNaFunctionalPool("Name");

        lista.add(cnalaTaskMailbox);
        findTaskMailbox_In.setFromDate(new Date());
        findTaskMailbox_In.setTaskMailbox(taskMailbox_In);
        findTaskMailbox_In.setOrganizationRole(organizationRoleIn);
        findTaskMailbox_In.setFunctionalPool(functionalPoolIn);
        findTaskMailbox_In.setShowAllLanguages(true);
        DistributionCriteria_DTO_IN distributionCriteria = new DistributionCriteria_DTO_IN();
        distributionCriteria.setId(1l);
		findTaskMailbox_In.setDistributionCriteria(distributionCriteria );
		Rule_DTO_IN rule = new Rule_DTO_IN();
		rule.setId(BigDecimal.ONE);
		findTaskMailbox_In.setRule(rule );
		
		Page <CnalaTaskMailbox> pageList = new PageImpl<CnalaTaskMailbox>(lista);
        Mockito.when(taskMailboxRepository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(pageList);

        metadatos.getTE_Ordenacion().setCriterioOrdenacions(new String[]{"AD_findTaskMailbox_configuracion1_DSC"});
        FindTaskMailbox_OUT findTaskMailbox_Out = taskMailboxServiceMock.findTaskMailbox(findTaskMailbox_In, cabecera,
                metadatos);
        assertThat(findTaskMailbox_Out).isNotNull();
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void findTaskMailboxMI() throws TE_Excepcion {
        FindTaskMailbox_IN findTaskMailbox_In = new FindTaskMailbox_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN taskMailbox_In = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN organizationRoleIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN functionalPoolIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN();
        TE_Busqueda teBusqueda = new TE_Busqueda();
        TE_Ordenacion teOrdenacion = new TE_Ordenacion();
        TE_Paginacion tePaginacion = new TE_Paginacion();
        TE_PaginacionIN tePaginacionIn = new TE_PaginacionIN();
        List<CnalaTaskMailbox> lista = new ArrayList<CnalaTaskMailbox>();
        CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
        List<CnalrTaskMailboxL> listaCnalrTaskMailboxLs = new ArrayList<CnalrTaskMailboxL>();
        CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();
        taskMailbox_In.setCode("code");
        taskMailbox_In.setId(BigDecimal.ONE);
        organizationRoleIn.setId(BigDecimal.ONE);
        functionalPoolIn.setId(BigDecimal.ONE);

        tePaginacionIn.setNumeroPagina((long) 1);
        tePaginacionIn.setTamanoVentana((long) 50);
        tePaginacion.setTE_PaginacionIN(tePaginacionIn);

        metadatos.setTE_Busqueda(teBusqueda);
        metadatos.setTE_Ordenacion(teOrdenacion);
        metadatos.setTE_Paginacion(tePaginacion);

        cnalrTaskMailboxL.setLangCoLanguage((long) 1);
        cnalrTaskMailboxL.setLboxNaMailbox("string");

        listaCnalrTaskMailboxLs.add(cnalrTaskMailboxL);
        cnalaTaskMailbox.setCnalrTaskMailboxLs(listaCnalrTaskMailboxLs);
        
        GewfdDistributionCriteria gewfdDistributionCriteria = new GewfdDistributionCriteria();
        gewfdDistributionCriteria.setDiscIdDistributionCriteria(1L);
        gewfdDistributionCriteria.setDiclNaDistributionCriteria("name");
        gewfdDistributionCriteria.setDiscDaStartValidity(new Date());
        gewfdDistributionCriteria.setDiscDaEndValidity(new Date());
        cnalaTaskMailbox.setGewfdDistributionCriteria(gewfdDistributionCriteria);
        
        
        cnalaTaskMailbox.setRuleIdRule(BigDecimal.ONE);
        
        cnalaTaskMailbox.setCnalpFunctionalPool(new CnalpFunctionalPool());
        cnalaTaskMailbox.getCnalpFunctionalPool().setWpooIdFunctionalPool(BigDecimal.ONE);
        cnalaTaskMailbox.getCnalpFunctionalPool().setFupoNaFunctionalPool("Name");
        cnalaTaskMailbox.getCnalpFunctionalPool().setCnalrFunctionalPoolLs(new ArrayList<CnalrFunctionalPoolL>());
        cnalaTaskMailbox.getCnalpFunctionalPool().getCnalrFunctionalPoolLs().add(new CnalrFunctionalPoolL());
        cnalaTaskMailbox.getCnalpFunctionalPool().getCnalrFunctionalPoolLs().get(0).setLangCoLanguage(2L);
        cnalaTaskMailbox.getCnalpFunctionalPool().getCnalrFunctionalPoolLs().get(0).setLfpoDsFunctionalPool("name");
        
        lista.add(cnalaTaskMailbox);
        findTaskMailbox_In.setFromDate(new Date());
        findTaskMailbox_In.setTaskMailbox(taskMailbox_In);
        findTaskMailbox_In.setOrganizationRole(organizationRoleIn);
        findTaskMailbox_In.setFunctionalPool(functionalPoolIn);
        findTaskMailbox_In.setShowAllLanguages(true);
        DistributionCriteria_DTO_IN distributionCriteria = new DistributionCriteria_DTO_IN();
        distributionCriteria.setId(1l);
        findTaskMailbox_In.setDistributionCriteria(distributionCriteria );
        Rule_DTO_IN rule = new Rule_DTO_IN();
        rule.setId(BigDecimal.ONE);
        findTaskMailbox_In.setRule(rule );
        Page <CnalaTaskMailbox> pageList = new PageImpl<CnalaTaskMailbox>(lista);
        Mockito.when(taskMailboxRepository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(pageList);

        cabecera.setLenguaje("2");
        metadatos.getTE_Ordenacion().setCriterioOrdenacions(new String[]{"AD_findTaskMailbox_configuracion1_DSC"});
        FindTaskMailbox_OUT findTaskMailbox_Out = taskMailboxServiceMock.findTaskMailbox(findTaskMailbox_In, cabecera,
                metadatos);
        assertThat(findTaskMailbox_Out).isNotNull();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void findTaskMailboxNotAllLanguages() throws TE_Excepcion {
        FindTaskMailbox_IN findTaskMailbox_In = new FindTaskMailbox_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN taskMailbox_In = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN organizationRoleIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN functionalPoolIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN();
        TE_Busqueda teBusqueda = new TE_Busqueda();
        TE_Ordenacion teOrdenacion = new TE_Ordenacion();
        TE_Paginacion tePaginacion = new TE_Paginacion();
        TE_PaginacionIN tePaginacionIn = new TE_PaginacionIN();
        List<CnalaTaskMailbox> lista = new ArrayList<CnalaTaskMailbox>();
        CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
        List<CnalrTaskMailboxL> listaCnalrTaskMailboxLs = new ArrayList<CnalrTaskMailboxL>();
        CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();

        taskMailbox_In.setId(BigDecimal.ONE);
        organizationRoleIn.setId(BigDecimal.ONE);
        functionalPoolIn.setId(BigDecimal.ONE);

        tePaginacionIn.setNumeroPagina((long) 1);
        tePaginacionIn.setTamanoVentana((long) 50);
        tePaginacion.setTE_PaginacionIN(tePaginacionIn);

        metadatos.setTE_Busqueda(teBusqueda);
        metadatos.setTE_Ordenacion(teOrdenacion);
        metadatos.setTE_Paginacion(tePaginacion);

        cnalrTaskMailboxL.setLangCoLanguage((long) 1);
        cnalrTaskMailboxL.setLboxNaMailbox("string");

        listaCnalrTaskMailboxLs.add(cnalrTaskMailboxL);
        cnalaTaskMailbox.setCnalrTaskMailboxLs(listaCnalrTaskMailboxLs);

        lista.add(cnalaTaskMailbox);

        findTaskMailbox_In.setTaskMailbox(taskMailbox_In);
        findTaskMailbox_In.setOrganizationRole(organizationRoleIn);
        findTaskMailbox_In.setFunctionalPool(functionalPoolIn);
        findTaskMailbox_In.setShowAllLanguages(false);

        Page <CnalaTaskMailbox> pageList = new PageImpl<CnalaTaskMailbox>(lista);
        Mockito.when(taskMailboxRepository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(pageList);

        metadatos.getTE_Ordenacion().setCriterioOrdenacions(new String[]{"AD_findTaskMailbox_configuracion1_DSC"});
        
        FindTaskMailbox_OUT findTaskMailbox_Out = taskMailboxServiceMock.findTaskMailbox(findTaskMailbox_In, cabecera,
                metadatos);
        assertThat(findTaskMailbox_Out).isNotNull();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void findTaskMailboxNotAllLanguagesIdiomaDefectoFalse() throws TE_Excepcion {
        FindTaskMailbox_IN findTaskMailbox_In = new FindTaskMailbox_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN taskMailbox_In = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN organizationRoleIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN functionalPoolIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN();
        TE_Busqueda teBusqueda = new TE_Busqueda();
        TE_Ordenacion teOrdenacion = new TE_Ordenacion();
        TE_Paginacion tePaginacion = new TE_Paginacion();
        TE_PaginacionIN tePaginacionIn = new TE_PaginacionIN();
        List<CnalaTaskMailbox> lista = new ArrayList<CnalaTaskMailbox>();
        CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
        List<CnalrTaskMailboxL> listaCnalrTaskMailboxLs = new ArrayList<CnalrTaskMailboxL>();
        CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();

        taskMailbox_In.setId(BigDecimal.ONE);
        organizationRoleIn.setId(BigDecimal.ONE);
        functionalPoolIn.setId(BigDecimal.ONE);

        tePaginacionIn.setNumeroPagina((long) 1);
        tePaginacionIn.setTamanoVentana((long) 50);
        tePaginacion.setTE_PaginacionIN(tePaginacionIn);

        metadatos.setTE_Busqueda(teBusqueda);
        metadatos.setTE_Ordenacion(teOrdenacion);
        metadatos.setTE_Paginacion(tePaginacion);

        cabecera.setLenguaje("2");

        cnalrTaskMailboxL.setLangCoLanguage((long) 2);
        cnalrTaskMailboxL.setLboxNaMailbox("string");

        listaCnalrTaskMailboxLs.add(cnalrTaskMailboxL);
        cnalaTaskMailbox.setCnalrTaskMailboxLs(listaCnalrTaskMailboxLs);

        lista.add(cnalaTaskMailbox);

        findTaskMailbox_In.setTaskMailbox(taskMailbox_In);
        findTaskMailbox_In.setOrganizationRole(organizationRoleIn);
        findTaskMailbox_In.setFunctionalPool(functionalPoolIn);
        findTaskMailbox_In.setShowAllLanguages(false);

        Page <CnalaTaskMailbox> pageList = new PageImpl<CnalaTaskMailbox>(lista);
        Mockito.when(taskMailboxRepository.findAll(Mockito.any(Specification.class), Mockito.any(PageRequest.class))).thenReturn(pageList);

        metadatos.getTE_Ordenacion().setCriterioOrdenacions(new String[]{"AD_findTaskMailbox_configuracion1_DSC"});
        
        FindTaskMailbox_OUT findTaskMailbox_Out = taskMailboxServiceMock.findTaskMailbox(findTaskMailbox_In, cabecera,
                metadatos);
        assertThat(findTaskMailbox_Out).isNotNull();
    }

    @Test(expected = TE_Excepcion.class)
    public void findTaskMailboxExcepcionErrorParametros() throws TE_Excepcion {
        // FindTaskMailbox_IN inicializado a null para que recorra esa rama
        taskMailboxServiceMock.findTaskMailbox(null, cabecera, metadatos);
    }

    @Test(expected = TE_Excepcion.class)
    public void findTaskMailboxErrorIdioma() throws TE_Excepcion {
        FindTaskMailbox_IN findTaskMailbox_In = new FindTaskMailbox_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN taskMailbox_In = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN organizationRoleIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN functionalPoolIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN();

        taskMailbox_In.setId(BigDecimal.ONE);
        organizationRoleIn.setId(BigDecimal.ONE);
        functionalPoolIn.setId(BigDecimal.ONE);

        findTaskMailbox_In.setTaskMailbox(taskMailbox_In);
        findTaskMailbox_In.setOrganizationRole(organizationRoleIn);
        findTaskMailbox_In.setFunctionalPool(functionalPoolIn);
        findTaskMailbox_In.setShowAllLanguages(false);

        Mockito.when(languageService.getIdiomaPorDefecto()).thenReturn(null);

        taskMailboxServiceMock.findTaskMailbox(findTaskMailbox_In, cabecera, metadatos);
    }
    
    @Test(expected = TE_Excepcion.class)
    public void findTaskMailboxErrorIdioma2() throws TE_Excepcion {
        FindTaskMailbox_IN findTaskMailbox_In = new FindTaskMailbox_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN taskMailbox_In = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.TaskMailbox_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN organizationRoleIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.OrganizationRole_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN functionalPoolIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox.FunctionalPool_DTO_IN();

        taskMailbox_In.setId(BigDecimal.ONE);
        organizationRoleIn.setId(BigDecimal.ONE);
        functionalPoolIn.setId(BigDecimal.ONE);

        findTaskMailbox_In.setTaskMailbox(taskMailbox_In);
        findTaskMailbox_In.setOrganizationRole(organizationRoleIn);
        findTaskMailbox_In.setFunctionalPool(functionalPoolIn);
        findTaskMailbox_In.setShowAllLanguages(false);
        
        cabecera.setLenguaje("Cadena que no se puede convertir a long para que lance excepción");

        taskMailboxServiceMock.findTaskMailbox(findTaskMailbox_In, cabecera, metadatos);
    }

    @Test   
    public void adFindFullTaskMailboxCorrecto() throws TE_Excepcion {
        

        HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT> mapOrgRole_OUT =
                new HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT>();

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT orgRole = 
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT();

        mapOrgRole_OUT.put(BigDecimal.ONE,orgRole);

        org.mockito.Mockito
        .when(taskMailboxServiceMock.invocarOP_findOrganizationRole(
                Mockito.anyObject(),
                Mockito.anyObject(),
                Mockito.anyObject(),
                Mockito.anyObject())).thenReturn(mapOrgRole_OUT);
        
        try {
            
            List<CnalaTaskMailbox> lista = new ArrayList<CnalaTaskMailbox>();

            CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
            cnalaTaskMailbox.setMboxIdMailbox(BigDecimal.valueOf(1));
            cnalaTaskMailbox.setAudiTiCreation(new Timestamp(new Date().getTime()));
            cnalaTaskMailbox.setAudiTiUpdate(new Timestamp(new Date().getTime()));
            CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
            cnalpFunctionalPool.setWpooIdFunctionalPool(new BigDecimal(1));

            CnalrFunctionalPoolL cnalrFunctionalPoolL = new CnalrFunctionalPoolL();
            List<CnalrFunctionalPoolL> lsitCnalrFunctionalPoolL = new ArrayList<CnalrFunctionalPoolL>();
            cnalrFunctionalPoolL.setLangCoLanguage(2l);
            cnalrFunctionalPoolL.setLfpoDsFunctionalPool("ds");
            lsitCnalrFunctionalPoolL.add(cnalrFunctionalPoolL);
            cnalpFunctionalPool.setCnalrFunctionalPoolLs(lsitCnalrFunctionalPoolL);
            cnalaTaskMailbox.setCnalpFunctionalPool(cnalpFunctionalPool);
            // cnalrOrgaPoolAssignment1
            CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment1 = new CnalrOrgaPoolAssignment();
            cnalrOrgaPoolAssignment1.setOpasIdOrgaPoolAssignment(new BigDecimal(1));
            cnalrOrgaPoolAssignment1.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment1(cnalrOrgaPoolAssignment1);
            cnalrOrgaPoolAssignment1.setParoIdOrganizationRole(BigDecimal.ONE);
            // cnalrOrgaPoolAssignment2
            CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2 = new CnalrOrgaPoolAssignment();
            cnalrOrgaPoolAssignment2.setParoIdOrganizationRole(new BigDecimal(1));
            cnalrOrgaPoolAssignment2.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalrOrgaPoolAssignment2.setParoIdOrganizationRole(BigDecimal.ONE);
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment2);
            cnalaTaskMailbox.setLboxNaMailbox("na");
            cnalaTaskMailbox.setMboxCoFuncMailbox("co");
            cnalaTaskMailbox.setMboxTiEndValidity(new Timestamp(new Date().getTime()));
            cnalaTaskMailbox.setMboxTiStartValidity(new Timestamp(new Date().getTime()));
            cnalaTaskMailbox.setMboxInBrotherReallocation(Boolean.TRUE);
            cnalaTaskMailbox.setMboxQuMaximumAmount(101L);
            cnalaTaskMailbox.setMboxInState(1L);
            cnalaTaskMailbox.setMboxQuVolume(101L);
            cnalaTaskMailbox.setUserIdCreatorParty(new BigDecimal(1));
            cnalaTaskMailbox.setUserIdUpdaterParty(new BigDecimal(1));
            lista.add(cnalaTaskMailbox);
            List<CnalrTaskMailboxL> cnalrTaskMailboxLs = new ArrayList<CnalrTaskMailboxL>();
            CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();
            cnalrTaskMailboxL.setLangCoLanguage(2l);
            cnalrTaskMailboxL.setLboxNaMailbox("lboxNaMailbox");
            cnalrTaskMailboxLs.add(cnalrTaskMailboxL);
            cnalaTaskMailbox.setCnalrTaskMailboxLs(cnalrTaskMailboxLs);
            cnalaTaskMailbox.setMboxInDistributionMode(1L);
            cnalaTaskMailbox.setMboxInGroupDistribCriteria(1L);
            cnalaTaskMailbox.setMboxInManualDistribMode(1L);
            GewfdDistributionCriteria gewfdDistributionCriteria = new GewfdDistributionCriteria();
			gewfdDistributionCriteria.setDiscIdDistributionCriteria(1l);
			gewfdDistributionCriteria.setDiclNaDistributionCriteria("prueba");
			List<GewfrDistributionCriteriaL> listGewfrDistributionCriteriaLs = new ArrayList<GewfrDistributionCriteriaL>();
			GewfrDistributionCriteriaL gewfdDistributionCriteriaL = new GewfrDistributionCriteriaL();
			gewfdDistributionCriteriaL.setLangCoLanguage(1l);
			gewfdDistributionCriteriaL.setDiclNaDistributionCriteria("prueba name");
			listGewfrDistributionCriteriaLs.add(gewfdDistributionCriteriaL );
			gewfdDistributionCriteria.setGewfrDistributionCriteriaLs(listGewfrDistributionCriteriaLs );
			cnalaTaskMailbox.setGewfdDistributionCriteria(gewfdDistributionCriteria );

            Page<CnalaTaskMailbox> page = new PageImpl<CnalaTaskMailbox>(lista);

            Mockito.when(taskMailboxRepository.findFullTaskMailbox(Mockito.any(Specification.class),
                    Mockito.any(Pageable.class), Mockito.any(Sort.Order.class))).thenReturn(page);
            
            ListApplication_OUT listApplication_OUT = new ListApplication_OUT();
            listApplication_OUT.setGenericApplications(new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT[1]);
            listApplication_OUT.setGenericApplications(0, new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT());
            listApplication_OUT.getGenericApplications(0).setId(1L);
            listApplication_OUT.getGenericApplications(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_listApplication(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(listApplication_OUT);
            
            GetRules_OUT getRules_OUT = new GetRules_OUT();
            getRules_OUT.setRules(new Rule_DTO_OUT[1]);
            getRules_OUT.setRules(0, new Rule_DTO_OUT());
            getRules_OUT.getRules(0).setId(BigDecimal.ONE);
            getRules_OUT.getRules(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_getRules(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(getRules_OUT);

            FindFullTaskMailbox_IN findfulltaskmailbox_in = new FindFullTaskMailbox_IN();
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_IN functionalPool_DTO_IN = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_IN();

            functionalPool_DTO_IN.setId(new BigDecimal(1));
            findfulltaskmailbox_in.setFunctionalPool(functionalPool_DTO_IN);
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_IN organizationRole_DTO_IN = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_IN();
            organizationRole_DTO_IN.setId(new BigDecimal(1));
            findfulltaskmailbox_in.setOrganizationRole(organizationRole_DTO_IN);
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_IN taskMailbox = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_IN();
            taskMailbox.setCode("code");
            taskMailbox.setName("name");
            taskMailbox.setId(new BigDecimal(1));
            findfulltaskmailbox_in.setTaskMailbox(taskMailbox);
            findfulltaskmailbox_in.setToDate(new Date());
            findfulltaskmailbox_in.setFromDate(new Date());
            findfulltaskmailbox_in.setShowAllLanguages(true);
            cabecera.setLenguaje("2");
            FindFullTaskMailbox_OUT ad_findfulltaskmailbox_out = taskMailboxServiceMock
                    .findFullTaskMailbox(findfulltaskmailbox_in, cabecera, metadatos);

            Assert.assertEquals(1, ad_findfulltaskmailbox_out.getTaskMailboxesLength());

        } catch (TE_Excepcion e) {
            throw e;
        }
    }

    @Test
    public void adFindFullTaskMailboxCorrectoFechasNull() throws TE_Excepcion {
        
      
        
        try {
            
            List<CnalaTaskMailbox> lista = new ArrayList<CnalaTaskMailbox>();

            CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
            cnalaTaskMailbox.setMboxIdMailbox(BigDecimal.valueOf(1));
            cnalaTaskMailbox.setAudiTiCreation(new Timestamp(new Date().getTime()));
            cnalaTaskMailbox.setAudiTiUpdate(new Timestamp(new Date().getTime()));
            CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
            cnalpFunctionalPool.setWpooIdFunctionalPool(new BigDecimal(1));

            CnalrFunctionalPoolL cnalrFunctionalPoolL = new CnalrFunctionalPoolL();
            List<CnalrFunctionalPoolL> lsitCnalrFunctionalPoolL = new ArrayList<CnalrFunctionalPoolL>();
            cnalrFunctionalPoolL.setLangCoLanguage(2l);
            cnalrFunctionalPoolL.setLfpoDsFunctionalPool("ds");
            lsitCnalrFunctionalPoolL.add(cnalrFunctionalPoolL);
            cnalpFunctionalPool.setCnalrFunctionalPoolLs(lsitCnalrFunctionalPoolL);
            cnalaTaskMailbox.setCnalpFunctionalPool(cnalpFunctionalPool);
            // cnalrOrgaPoolAssignment2
            CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2 = new CnalrOrgaPoolAssignment();
            cnalrOrgaPoolAssignment2.setParoIdOrganizationRole(new BigDecimal(1));
            cnalrOrgaPoolAssignment2.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment2);
            cnalaTaskMailbox.setLboxNaMailbox("na");
            cnalaTaskMailbox.setMboxCoFuncMailbox("co");
            cnalaTaskMailbox.setMboxTiEndValidity(new Timestamp(new Date().getTime()));
            cnalaTaskMailbox.setMboxTiStartValidity(new Timestamp(new Date().getTime()));
            cnalaTaskMailbox.setMboxInBrotherReallocation(Boolean.TRUE);
            cnalaTaskMailbox.setMboxQuMaximumAmount(101L);
            cnalaTaskMailbox.setMboxInState(1L);
            cnalaTaskMailbox.setMboxQuVolume(101L);
            cnalaTaskMailbox.setUserIdCreatorParty(new BigDecimal(1));
            cnalaTaskMailbox.setUserIdUpdaterParty(new BigDecimal(1));
            lista.add(cnalaTaskMailbox);
            List<CnalrTaskMailboxL> cnalrTaskMailboxLs = new ArrayList<CnalrTaskMailboxL>();
            CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();
            cnalrTaskMailboxL.setLangCoLanguage(2l);
            cnalrTaskMailboxL.setLboxNaMailbox("lboxNaMailbox");
            cnalrTaskMailboxLs.add(cnalrTaskMailboxL);
            cnalaTaskMailbox.setCnalrTaskMailboxLs(cnalrTaskMailboxLs);

            Page<CnalaTaskMailbox> page = new PageImpl<CnalaTaskMailbox>(lista);

            Mockito.when(taskMailboxRepository.findFullTaskMailbox(Mockito.any(Specification.class),
                    Mockito.any(Pageable.class), Mockito.any(Sort.Order.class))).thenReturn(page);

            ListApplication_OUT listApplication_OUT = new ListApplication_OUT();
            listApplication_OUT.setGenericApplications(new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT[1]);
            listApplication_OUT.setGenericApplications(0, new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT());
            listApplication_OUT.getGenericApplications(0).setId(1L);
            listApplication_OUT.getGenericApplications(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_listApplication(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(listApplication_OUT);
            
            GetRules_OUT getRules_OUT = new GetRules_OUT();
            getRules_OUT.setRules(new Rule_DTO_OUT[1]);
            getRules_OUT.setRules(0, new Rule_DTO_OUT());
            getRules_OUT.getRules(0).setId(BigDecimal.ONE);
            getRules_OUT.getRules(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_getRules(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(getRules_OUT);
            
            FindFullTaskMailbox_IN findfulltaskmailbox_in = new FindFullTaskMailbox_IN();
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_IN functionalPool_DTO_IN = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_IN();

            functionalPool_DTO_IN.setId(new BigDecimal(1));
            findfulltaskmailbox_in.setFunctionalPool(functionalPool_DTO_IN);
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_IN organizationRole_DTO_IN = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_IN();
            organizationRole_DTO_IN.setId(new BigDecimal(1));
            findfulltaskmailbox_in.setOrganizationRole(organizationRole_DTO_IN);
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_IN taskMailbox = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_IN();
            taskMailbox.setCode("code");
            taskMailbox.setName("name");
            taskMailbox.setId(new BigDecimal(1));
            findfulltaskmailbox_in.setTaskMailbox(taskMailbox);
            findfulltaskmailbox_in.setToDate(null);
            findfulltaskmailbox_in.setFromDate(null);
            findfulltaskmailbox_in.setShowAllLanguages(true);
            cabecera.setLenguaje("2");          
            
            
            HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT> mapOrgRole_OUT =
                    new HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT>();

            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT orgRole = 
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT();

            mapOrgRole_OUT.put(BigDecimal.ONE,orgRole);

            org.mockito.Mockito
            .when(taskMailboxServiceMock.invocarOP_findOrganizationRole(
                    Mockito.anyObject(),
                    Mockito.anyObject(),
                    Mockito.anyObject(),
                    Mockito.anyObject())).thenReturn(mapOrgRole_OUT);
            
            
            
            FindFullTaskMailbox_OUT ad_findfulltaskmailbox_out = taskMailboxServiceMock
                    .findFullTaskMailbox(findfulltaskmailbox_in, cabecera, metadatos);

            Assert.assertEquals(1, ad_findfulltaskmailbox_out.getTaskMailboxesLength());

        } catch (TE_Excepcion e) {
            throw e;
        }
    }

    @Test
    public void adFindFullTaskMailboxCorrectoFechasFinNull() throws TE_Excepcion {
        try {

            List<CnalaTaskMailbox> lista = new ArrayList<CnalaTaskMailbox>();

            CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
            cnalaTaskMailbox.setMboxIdMailbox(BigDecimal.valueOf(1));
            cnalaTaskMailbox.setAudiTiCreation(new Timestamp(new Date().getTime()));
            cnalaTaskMailbox.setAudiTiUpdate(new Timestamp(new Date().getTime()));
            CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
            cnalpFunctionalPool.setWpooIdFunctionalPool(new BigDecimal(1));

            CnalrFunctionalPoolL cnalrFunctionalPoolL = new CnalrFunctionalPoolL();
            List<CnalrFunctionalPoolL> lsitCnalrFunctionalPoolL = new ArrayList<CnalrFunctionalPoolL>();
            cnalrFunctionalPoolL.setLangCoLanguage(2l);
            cnalrFunctionalPoolL.setLfpoDsFunctionalPool("ds");
            lsitCnalrFunctionalPoolL.add(cnalrFunctionalPoolL);
            cnalpFunctionalPool.setCnalrFunctionalPoolLs(lsitCnalrFunctionalPoolL);
            cnalaTaskMailbox.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalaTaskMailbox.setLboxNaMailbox("na");
            cnalaTaskMailbox.setMboxCoFuncMailbox("co");
            cnalaTaskMailbox.setMboxTiEndValidity(new Timestamp(new Date().getTime()));
            cnalaTaskMailbox.setMboxTiStartValidity(new Timestamp(new Date().getTime()));
            cnalaTaskMailbox.setMboxInBrotherReallocation(Boolean.TRUE);
            cnalaTaskMailbox.setMboxQuMaximumAmount(101L);
            cnalaTaskMailbox.setMboxInState(1L);
            cnalaTaskMailbox.setMboxQuVolume(101L);
            cnalaTaskMailbox.setUserIdCreatorParty(new BigDecimal(1));
            cnalaTaskMailbox.setUserIdUpdaterParty(new BigDecimal(1));
            lista.add(cnalaTaskMailbox);
            List<CnalrTaskMailboxL> cnalrTaskMailboxLs = new ArrayList<CnalrTaskMailboxL>();
            CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();
            cnalrTaskMailboxL.setLangCoLanguage(2l);
            cnalrTaskMailboxL.setLboxNaMailbox("lboxNaMailbox");
            cnalrTaskMailboxLs.add(cnalrTaskMailboxL);
            cnalaTaskMailbox.setCnalrTaskMailboxLs(cnalrTaskMailboxLs);
            

            Page<CnalaTaskMailbox> page = new PageImpl<CnalaTaskMailbox>(lista);

            Mockito.when(taskMailboxRepository.findFullTaskMailbox(Mockito.any(Specification.class),
                    Mockito.any(Pageable.class), Mockito.any(Sort.Order.class))).thenReturn(page);

            ListApplication_OUT listApplication_OUT = new ListApplication_OUT();
            listApplication_OUT.setGenericApplications(new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT[1]);
            listApplication_OUT.setGenericApplications(0, new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT());
            listApplication_OUT.getGenericApplications(0).setId(1L);
            listApplication_OUT.getGenericApplications(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_listApplication(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(listApplication_OUT);
            
            GetRules_OUT getRules_OUT = new GetRules_OUT();
            getRules_OUT.setRules(new Rule_DTO_OUT[1]);
            getRules_OUT.setRules(0, new Rule_DTO_OUT());
            getRules_OUT.getRules(0).setId(BigDecimal.ONE);
            getRules_OUT.getRules(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_getRules(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(getRules_OUT);
            
            FindFullTaskMailbox_IN findfulltaskmailbox_in = new FindFullTaskMailbox_IN();
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_IN functionalPool_DTO_IN = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_IN();

            functionalPool_DTO_IN.setId(new BigDecimal(1));
            findfulltaskmailbox_in.setFunctionalPool(functionalPool_DTO_IN);
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_IN organizationRole_DTO_IN = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_IN();
            organizationRole_DTO_IN.setId(new BigDecimal(1));
            findfulltaskmailbox_in.setOrganizationRole(organizationRole_DTO_IN);
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_IN taskMailbox = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_IN();
            taskMailbox.setCode("code");
            taskMailbox.setName("name");
            taskMailbox.setId(new BigDecimal(1));
            findfulltaskmailbox_in.setTaskMailbox(taskMailbox);
            findfulltaskmailbox_in.setToDate(null);
            findfulltaskmailbox_in.setFromDate(new Date());
            findfulltaskmailbox_in.setShowAllLanguages(true);
            Application_DTO_IN aplication = new Application_DTO_IN();
            aplication.setId(1l);
			findfulltaskmailbox_in.setApplication(aplication );
            cabecera.setLenguaje("2");
            metadatos.getTE_Paginacion().getTE_PaginacionIN().setNumeroPagina(2l);
            FindFullTaskMailbox_OUT ad_findfulltaskmailbox_out = taskMailboxServiceMock
                    .findFullTaskMailbox(findfulltaskmailbox_in, cabecera, metadatos);

            Assert.assertEquals(1, ad_findfulltaskmailbox_out.getTaskMailboxesLength());

        } catch (TE_Excepcion e) {
            throw e;
        }
    }

    @Test   
    public void adFindFullTaskMailboxCorrectoCompletoMultilenguajeNull() throws TE_Excepcion {
        try {

            List<CnalaTaskMailbox> lista = new ArrayList<CnalaTaskMailbox>();
            CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
            cnalaTaskMailbox.setMboxCoFuncMailbox("mboxCoFuncMailbox");
            CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
            cnalpFunctionalPool.setWpooIdFunctionalPool(BigDecimal.valueOf(1));
            cnalpFunctionalPool.setFupoNaFunctionalPool("fupoNaFunctionalPool");
            List<CnalrFunctionalPoolL> cnalrFunctionalPoolLs = new ArrayList<CnalrFunctionalPoolL>();
            CnalrFunctionalPoolL cnalrFunctionalPoolL = new CnalrFunctionalPoolL();
            cnalrFunctionalPoolL.setLangCoLanguage(2l);
            cnalrFunctionalPoolL.setLfpoDsFunctionalPool("lfpoDsFunctionalPool");
            cnalrFunctionalPoolLs.add(cnalrFunctionalPoolL);
            cnalpFunctionalPool.setCnalrFunctionalPoolLs(cnalrFunctionalPoolLs);
            cnalaTaskMailbox.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalaTaskMailbox.setMboxIdMailbox(BigDecimal.valueOf(1));
            cnalaTaskMailbox.setLboxNaMailbox("lboxNaMailbox");
            List<CnalrTaskMailboxL> cnalrTaskMailboxLs = new ArrayList<CnalrTaskMailboxL>();
            CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();
            cnalrTaskMailboxL.setLangCoLanguage(2l);
            cnalrTaskMailboxL.setLboxNaMailbox("lboxNaMailbox");
            cnalrTaskMailboxLs.add(cnalrTaskMailboxL);
            cnalaTaskMailbox.setCnalrTaskMailboxLs(cnalrTaskMailboxLs);
            // cnalrOrgaPoolAssignment1
            CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment1 = new CnalrOrgaPoolAssignment();
            cnalrOrgaPoolAssignment1.setOpasIdOrgaPoolAssignment(BigDecimal.valueOf(1));
            cnalrOrgaPoolAssignment1.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment1(cnalrOrgaPoolAssignment1);
            // cnalrOrgaPoolAssignment2
            CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2 = new CnalrOrgaPoolAssignment();
            cnalrOrgaPoolAssignment2.setParoIdOrganizationRole(new BigDecimal(1));
            cnalrOrgaPoolAssignment2.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment2);
            cnalaTaskMailbox.setMboxInBrotherReallocation(Boolean.TRUE);
            cnalaTaskMailbox.setMboxQuMaximumAmount(101L);
            cnalaTaskMailbox.setMboxInState(1L);
            cnalaTaskMailbox.setMboxQuVolume(101L);
            cnalaTaskMailbox.setMboxTiStartValidity(new Timestamp(new Date().getTime()));
            cnalaTaskMailbox.setMboxTiEndValidity(new Timestamp(new Date().getTime()));
            lista.add(cnalaTaskMailbox);

            Page<CnalaTaskMailbox> page = new PageImpl<CnalaTaskMailbox>(lista);
            Mockito.when(taskMailboxRepository.findFullTaskMailbox(Mockito.any(Specification.class),
                    Mockito.any(Pageable.class), Mockito.any(Sort.Order.class))).thenReturn(page);

            ListApplication_OUT listApplication_OUT = new ListApplication_OUT();
            listApplication_OUT.setGenericApplications(new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT[1]);
            listApplication_OUT.setGenericApplications(0, new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT());
            listApplication_OUT.getGenericApplications(0).setId(1L);
            listApplication_OUT.getGenericApplications(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_listApplication(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(listApplication_OUT);
            
            GetRules_OUT getRules_OUT = new GetRules_OUT();
            getRules_OUT.setRules(new Rule_DTO_OUT[1]);
            getRules_OUT.setRules(0, new Rule_DTO_OUT());
            getRules_OUT.getRules(0).setId(BigDecimal.ONE);
            getRules_OUT.getRules(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_getRules(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(getRules_OUT);
            
            cabecera.setLenguaje("2");
            
            HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT> mapOrgRole_OUT =
                    new HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT>();

            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT orgRole = 
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_OUT();

            mapOrgRole_OUT.put(BigDecimal.ONE,orgRole);

            org.mockito.Mockito
            .when(taskMailboxServiceMock.invocarOP_findOrganizationRole(
                    Mockito.anyObject(),
                    Mockito.anyObject(),
                    Mockito.anyObject(),
                    Mockito.anyObject())).thenReturn(mapOrgRole_OUT);
            
            
            
            FindFullTaskMailbox_IN findfulltaskmailbox_in = new FindFullTaskMailbox_IN();
            FindFullTaskMailbox_OUT ad_findfulltaskmailbox_out = taskMailboxServiceMock
                    .findFullTaskMailbox(findfulltaskmailbox_in, cabecera, metadatos);

            Assert.assertEquals(1, ad_findfulltaskmailbox_out.getTaskMailboxesLength());

        } catch (TE_Excepcion e) {
            throw e;
        }
    }

    @Test
    public void adFindFullTaskMailboxCorrectoCompletoMultilenguajeTrue() {
        try {

            List<CnalaTaskMailbox> lista = new ArrayList<CnalaTaskMailbox>();
            CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
            cnalaTaskMailbox.setMboxCoFuncMailbox("mboxCoFuncMailbox");
            CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
            cnalpFunctionalPool.setWpooIdFunctionalPool(BigDecimal.valueOf(1));
            cnalpFunctionalPool.setFupoNaFunctionalPool("fupoNaFunctionalPool");
            List<CnalrFunctionalPoolL> cnalrFunctionalPoolLs = new ArrayList<CnalrFunctionalPoolL>();
            CnalrFunctionalPoolL cnalrFunctionalPoolL = new CnalrFunctionalPoolL();
            cnalrFunctionalPoolL.setLangCoLanguage(2l);
            cnalrFunctionalPoolL.setLfpoDsFunctionalPool("lfpoDsFunctionalPool");
            cnalrFunctionalPoolLs.add(cnalrFunctionalPoolL);
            cnalpFunctionalPool.setCnalrFunctionalPoolLs(cnalrFunctionalPoolLs);
            cnalaTaskMailbox.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalaTaskMailbox.setMboxIdMailbox(BigDecimal.valueOf(1));
            cnalaTaskMailbox.setLboxNaMailbox("lboxNaMailbox");
            List<CnalrTaskMailboxL> cnalrTaskMailboxLs = new ArrayList<CnalrTaskMailboxL>();
            CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();
            cnalrTaskMailboxL.setLangCoLanguage(2l);
            cnalrTaskMailboxL.setLboxNaMailbox("lboxNaMailbox");
            cnalrTaskMailboxLs.add(cnalrTaskMailboxL);
            cnalaTaskMailbox.setCnalrTaskMailboxLs(cnalrTaskMailboxLs);
            // cnalrOrgaPoolAssignment1
            CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment1 = new CnalrOrgaPoolAssignment();
            cnalrOrgaPoolAssignment1.setOpasIdOrgaPoolAssignment(BigDecimal.valueOf(1));
            cnalrOrgaPoolAssignment1.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment1(cnalrOrgaPoolAssignment1);
            // cnalrOrgaPoolAssignment2
            CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2 = new CnalrOrgaPoolAssignment();
            cnalrOrgaPoolAssignment2.setParoIdOrganizationRole(new BigDecimal(1));
            cnalrOrgaPoolAssignment2.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment2);
            cnalaTaskMailbox.setMboxInBrotherReallocation(Boolean.TRUE);
            cnalaTaskMailbox.setMboxQuMaximumAmount(101L);
            cnalaTaskMailbox.setMboxInState(1L);
            cnalaTaskMailbox.setMboxQuVolume(101L);
            cnalaTaskMailbox.setMboxTiStartValidity(new Timestamp(new Date().getTime()));
            cnalaTaskMailbox.setMboxTiEndValidity(new Timestamp(new Date().getTime()));
            lista.add(cnalaTaskMailbox);

            Page<CnalaTaskMailbox> page = new PageImpl<CnalaTaskMailbox>(lista);
            Mockito.when(taskMailboxRepository.findFullTaskMailbox(Mockito.any(Specification.class),
                    Mockito.any(Pageable.class), Mockito.any(Sort.Order.class))).thenReturn(page);

            ListApplication_OUT listApplication_OUT = new ListApplication_OUT();
            listApplication_OUT.setGenericApplications(new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT[1]);
            listApplication_OUT.setGenericApplications(0, new com.telefonica.gstr.srv.exp.application.msg.listapplication.GenericApplication_DTO_OUT());
            listApplication_OUT.getGenericApplications(0).setId(1L);
            listApplication_OUT.getGenericApplications(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_listApplication(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(listApplication_OUT);
            
            GetRules_OUT getRules_OUT = new GetRules_OUT();
            getRules_OUT.setRules(new Rule_DTO_OUT[1]);
            getRules_OUT.setRules(0, new Rule_DTO_OUT());
            getRules_OUT.getRules(0).setId(BigDecimal.ONE);
            getRules_OUT.getRules(0).setName("Name");
            Mockito.when(taskMailboxServiceMock.invocarOP_getRules(Mockito.any(Set.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenReturn(getRules_OUT);
            
            cabecera.setLenguaje("2");
            FindFullTaskMailbox_IN findfulltaskmailbox_in = new FindFullTaskMailbox_IN();
            findfulltaskmailbox_in.setShowAllLanguages(Boolean.TRUE);
            findfulltaskmailbox_in.setFromDate(new Date());
            findfulltaskmailbox_in.setToDate(new Date());
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_IN functionalPoolDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.FunctionalPool_DTO_IN();
            functionalPoolDTO.setId(BigDecimal.ONE);
            findfulltaskmailbox_in.setFunctionalPool(functionalPoolDTO);
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_IN organizationRoleDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.OrganizationRole_DTO_IN();
            organizationRoleDTO.setId(BigDecimal.ONE);
            findfulltaskmailbox_in.setOrganizationRole(organizationRoleDTO);
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_IN taskMailboxDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.TaskMailbox_DTO_IN();
            taskMailboxDTO.setCode("value");
            taskMailboxDTO.setId(new BigDecimal(Long.valueOf(1)));
            taskMailboxDTO.setName("name");
            findfulltaskmailbox_in.setTaskMailbox(taskMailboxDTO);
            FindFullTaskMailbox_OUT ad_findfulltaskmailbox_out = taskMailboxServiceMock
                    .findFullTaskMailbox(findfulltaskmailbox_in, cabecera, metadatos);

            Assert.assertEquals(1, ad_findfulltaskmailbox_out.getTaskMailboxesLength());

        } catch (TE_Excepcion e) {
            
        }
    }

    /*
     * con organization role informado
     */
    @Test
    public void adFindTaskMailboxResponsible() throws TE_Excepcion {
        List<CnalpFuncPoolAssignment> lista = new ArrayList<CnalpFuncPoolAssignment>();
        // cnalpFunctionalPool
        CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
        cnalpFunctionalPool.setWpooIdFunctionalPool(new BigDecimal(1));

        CnalpFuncPoolAssignment CnalpFuncPoolAssignment = new CnalpFuncPoolAssignment();
        CnalpFuncPoolAssignment.setCnalpFunctionalPool(cnalpFunctionalPool);
        CnalpFuncPoolAssignment.setParoIdFunctionalRole(new BigDecimal(1));
        lista.add(CnalpFuncPoolAssignment);

        Page<CnalpFuncPoolAssignment> page = new PageImpl<CnalpFuncPoolAssignment>(lista);

        Mockito.when(cnalpFuncPoolAssignmentRepository.findTaskMailBoxByResponsible(Mockito.any(Specification.class),
                Mockito.any(Pageable.class), Mockito.any(Sort.Order.class))).thenReturn(page);

        FindTaskMailBoxByResponsible_IN findTaskMailBoxByResponsible_IN = new FindTaskMailBoxByResponsible_IN();

        List<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN> listaTaskMailbox = new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN>();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN taskMailbox = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN();

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FunctionalPool_DTO_IN functionalPool = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FunctionalPool_DTO_IN();
        functionalPool.setId(new BigDecimal(1));
        taskMailbox.setFunctionalPool(functionalPool);
        taskMailbox.setId(new BigDecimal(1));
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_IN organizationRole = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_IN();
        organizationRole.setId(new BigDecimal(1));
        taskMailbox.setOrganizationRole(organizationRole);
        listaTaskMailbox.add(taskMailbox);

        findTaskMailBoxByResponsible_IN.setTaskMailboxes(listaTaskMailbox.toArray(
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[listaTaskMailbox
                        .size()]));
        
        GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = new GetOrganizationRoleByFuncRole_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[] arrayFuncRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[1];
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT funcRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT();
        funcRole.setId(BigDecimal.ONE);

        funcRole.setOrganizationRole(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.OrganizationRole_DTO_OUT());
        funcRole.getOrganizationRole().setCode("code");
        funcRole.getOrganizationRole().setId(BigDecimal.ONE);
        funcRole.getOrganizationRole().setParty(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.Party_DTO_OUT());
        funcRole.getOrganizationRole().getParty().setId(BigDecimal.ONE);
        arrayFuncRole[0] = funcRole;
        getOrganizationRoleByFuncRole_OUT.setFunctionalRoles(arrayFuncRole);
        when(taskMailboxServiceMock.llamadaGetOrganizationRoleByFuncRole_objetoSalida(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(getOrganizationRoleByFuncRole_OUT);
        

        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT findOrgRoleLowLevel_OUT = 
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.OrganizationRole_DTO_OUT organizationRole_DTO_OUT = 
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.OrganizationRole_DTO_OUT();
        List <com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT> listÇFunctionalRole_DTO_OUT =
                new ArrayList <com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT>();
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT functionalRole_DTO_OUT =
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRoleSpec_DTO_OUT functionalRoleSpec_DTO_OUT =
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRoleSpec_DTO_OUT();
        functionalRoleSpec_DTO_OUT.setIcon("ic");
        functionalRoleSpec_DTO_OUT.setId(1L);
        functionalRoleSpec_DTO_OUT.setName("name");
        functionalRole_DTO_OUT.setFunctionalRoleSpec(functionalRoleSpec_DTO_OUT);
        functionalRole_DTO_OUT.setId(BigDecimal.ONE);
        listÇFunctionalRole_DTO_OUT.add(functionalRole_DTO_OUT);
        organizationRole_DTO_OUT.setId(BigDecimal.ONE);
        organizationRole_DTO_OUT.setFunctionalRoles(listÇFunctionalRole_DTO_OUT.toArray(
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT[listÇFunctionalRole_DTO_OUT.size()]));
        findOrgRoleLowLevel_OUT.setOrganizationRole(organizationRole_DTO_OUT);
        when(taskMailboxServiceMock.invocarOP_findOrgRoleLowLevel(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(findOrgRoleLowLevel_OUT);
        
        FindTaskMailBoxByResponsible_OUT findMailBoxByResponsible_OUT = taskMailboxServiceMock
                .findTaskMailBoxByResponsible(findTaskMailBoxByResponsible_IN, cabecera, metadatos);

        Assert.assertNotNull(findMailBoxByResponsible_OUT);
    }
    
    @Test
    public void adFindTaskMailboxResponsibleOrgRoleNoInformado() throws TE_Excepcion {
        List<CnalpFuncPoolAssignment> lista = new ArrayList<CnalpFuncPoolAssignment>();
        // cnalpFunctionalPool
        CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
        cnalpFunctionalPool.setWpooIdFunctionalPool(new BigDecimal(1));

        CnalpFuncPoolAssignment CnalpFuncPoolAssignment = new CnalpFuncPoolAssignment();
        CnalpFuncPoolAssignment.setCnalpFunctionalPool(cnalpFunctionalPool);
        CnalpFuncPoolAssignment.setParoIdFunctionalRole(new BigDecimal(1));
        lista.add(CnalpFuncPoolAssignment);

        Page <CnalpFuncPoolAssignment> page = new PageImpl<CnalpFuncPoolAssignment>(lista);

        Mockito.when(cnalpFuncPoolAssignmentRepository.findTaskMailBoxByResponsible(Mockito.any(Specification.class),
                Mockito.any(Pageable.class), Mockito.any(Sort.Order.class))).thenReturn(page);

        FindTaskMailBoxByResponsible_IN findTaskMailBoxByResponsible_IN = new FindTaskMailBoxByResponsible_IN();

        List<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN> listaTaskMailbox = new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN>();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN taskMailbox = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN();

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FunctionalPool_DTO_IN functionalPool = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FunctionalPool_DTO_IN();
        functionalPool.setId(new BigDecimal(1));
        taskMailbox.setFunctionalPool(functionalPool);
        taskMailbox.setId(new BigDecimal(1));
        //com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_IN organizationRole = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_IN();
        //organizationRole.setId(new BigDecimal(1));
        //taskMailbox.setOrganizationRole(organizationRole);
        listaTaskMailbox.add(taskMailbox);

        findTaskMailBoxByResponsible_IN.setTaskMailboxes(listaTaskMailbox.toArray(
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[listaTaskMailbox
                        .size()]));
        
        
        GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = new GetOrganizationRoleByFuncRole_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[] arrayFuncRole =
        		new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[1];
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT funcRole =
        		new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT();
        funcRole.setId(BigDecimal.ONE);

        funcRole.setOrganizationRole(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.OrganizationRole_DTO_OUT());
        funcRole.getOrganizationRole().setCode("code");
        funcRole.getOrganizationRole().setId(BigDecimal.ONE);
        funcRole.getOrganizationRole().setParty(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.Party_DTO_OUT());
        funcRole.getOrganizationRole().getParty().setId(BigDecimal.ONE);
        arrayFuncRole[0] = funcRole;
        getOrganizationRoleByFuncRole_OUT.setFunctionalRoles(arrayFuncRole);
        when(taskMailboxServiceMock.llamadaGetOrganizationRoleByFuncRole_objetoSalida(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(getOrganizationRoleByFuncRole_OUT);

        FindTaskMailBoxByResponsible_OUT findMailBoxByResponsible_OUT = taskMailboxServiceMock
                .findTaskMailBoxByResponsible(findTaskMailBoxByResponsible_IN, cabecera, metadatos);

        Assert.assertNotNull(findMailBoxByResponsible_OUT);
    }
    
    /*
     * con organization role informado2
     */
    @Test
    public void adFindTaskMailboxResponsible2() throws TE_Excepcion {
        
//      org.mockito.Mockito
//      .when(taskMailboxServiceMock.invocarOP_findOrgRoleLowLevel(Mockito.any(BigDecimal.class),
//              Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class)))
//      .thenCallRealMethod();
        
        List<CnalpFuncPoolAssignment> lista = new ArrayList<CnalpFuncPoolAssignment>();
        // cnalpFunctionalPool
        CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
        cnalpFunctionalPool.setWpooIdFunctionalPool(new BigDecimal(1));

        CnalpFuncPoolAssignment CnalpFuncPoolAssignment = new CnalpFuncPoolAssignment();
        CnalpFuncPoolAssignment.setCnalpFunctionalPool(cnalpFunctionalPool);
        CnalpFuncPoolAssignment.setParoIdFunctionalRole(new BigDecimal(1));
        lista.add(CnalpFuncPoolAssignment);

        Page <CnalpFuncPoolAssignment> page = new PageImpl<CnalpFuncPoolAssignment>(lista);

        Mockito.when(cnalpFuncPoolAssignmentRepository.findTaskMailBoxByResponsible(Mockito.any(Specification.class),
                Mockito.any(Pageable.class), Mockito.any(Sort.Order.class))).thenReturn(page);

        FindTaskMailBoxByResponsible_IN findTaskMailBoxByResponsible_IN = new FindTaskMailBoxByResponsible_IN();

        List<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN> listaTaskMailbox = new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN>();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN taskMailbox = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN();

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FunctionalPool_DTO_IN functionalPool = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FunctionalPool_DTO_IN();
        functionalPool.setId(new BigDecimal(1));
        taskMailbox.setFunctionalPool(functionalPool);
        taskMailbox.setId(new BigDecimal(1));
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_IN organizationRole = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_IN();
        organizationRole.setId(new BigDecimal(1));
        taskMailbox.setOrganizationRole(organizationRole);
        listaTaskMailbox.add(taskMailbox);
        
        //---
        List<CnalpFuncPoolAssignment> list2 = new ArrayList<CnalpFuncPoolAssignment>();
        // cnalpFunctionalPool
        CnalpFunctionalPool cnalpFunctionalPool2 = new CnalpFunctionalPool();
        cnalpFunctionalPool2.setWpooIdFunctionalPool(new BigDecimal(1));

        CnalpFuncPoolAssignment CnalpFuncPoolAssignment2 = new CnalpFuncPoolAssignment();
        CnalpFuncPoolAssignment2.setCnalpFunctionalPool(cnalpFunctionalPool2);
        CnalpFuncPoolAssignment2.setParoIdFunctionalRole(new BigDecimal(1));
        lista.add(CnalpFuncPoolAssignment2);
        
        Page<CnalpFuncPoolAssignment> lsCnalpFuncPoolAssignments = new PageImpl<CnalpFuncPoolAssignment>(list2);
        
        Mockito.when(cnalpFuncPoolAssignmentRepositoryFPA.findFullFunctionalPoolAssignment(Mockito.any(Specification.class),
                Mockito.any(Pageable.class), Mockito.any(Sort.Order.class))).thenReturn(lsCnalpFuncPoolAssignments);
        
        //---
        
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT findOrgRoleLowLevel_OUT = 
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.OrganizationRole_DTO_OUT organizationRole_DTO_OUT = 
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.OrganizationRole_DTO_OUT();
        List <com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT> listÇFunctionalRole_DTO_OUT =
                new ArrayList <com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT>();
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT functionalRole_DTO_OUT =
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRoleSpec_DTO_OUT functionalRoleSpec_DTO_OUT =
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRoleSpec_DTO_OUT();
        functionalRoleSpec_DTO_OUT.setIcon("ic");
        functionalRoleSpec_DTO_OUT.setId(1L);
        functionalRoleSpec_DTO_OUT.setName("name");
        functionalRole_DTO_OUT.setFunctionalRoleSpec(functionalRoleSpec_DTO_OUT);
        functionalRole_DTO_OUT.setId(BigDecimal.ONE);
        listÇFunctionalRole_DTO_OUT.add(functionalRole_DTO_OUT);
        organizationRole_DTO_OUT.setId(BigDecimal.ONE);
        organizationRole_DTO_OUT.setFunctionalRoles(listÇFunctionalRole_DTO_OUT.toArray(
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT[listÇFunctionalRole_DTO_OUT.size()]));
        findOrgRoleLowLevel_OUT.setOrganizationRole(organizationRole_DTO_OUT);
        
        Mockito.when(taskMailboxServiceMock.invocarOP_findOrgRoleLowLevel(BigDecimal.ONE, cabecera, metadatos)).thenReturn(findOrgRoleLowLevel_OUT);
        
        //findOrgRoleLowLevel_OUT = taskMailboxServiceMock.invocarOP_findOrgRoleLowLevel(BigDecimal.ONE, cabecera, metadatos);
        
        
        //---

        
        
        GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = new GetOrganizationRoleByFuncRole_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[] arrayFuncRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[1];
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT funcRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT();
        funcRole.setId(BigDecimal.ONE);

        funcRole.setOrganizationRole(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.OrganizationRole_DTO_OUT());
        funcRole.getOrganizationRole().setCode("code");
        funcRole.getOrganizationRole().setId(BigDecimal.ONE);
        funcRole.getOrganizationRole().setParty(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.Party_DTO_OUT());
        funcRole.getOrganizationRole().getParty().setId(BigDecimal.ONE);
        arrayFuncRole[0] = funcRole;
        getOrganizationRoleByFuncRole_OUT.setFunctionalRoles(arrayFuncRole);
        when(taskMailboxServiceMock.llamadaGetOrganizationRoleByFuncRole_objetoSalida(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(getOrganizationRoleByFuncRole_OUT);

        
        findTaskMailBoxByResponsible_IN.setTaskMailboxes(listaTaskMailbox.toArray(
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[listaTaskMailbox
                        .size()]));

        FindTaskMailBoxByResponsible_OUT findMailBoxByResponsible_OUT = taskMailboxServiceMock
                .findTaskMailBoxByResponsible(findTaskMailBoxByResponsible_IN, cabecera, metadatos);

        Assert.assertNotNull(findMailBoxByResponsible_OUT);
    }

    
    
    @Test (expected = IllegalArgumentException.class)
    public void invocar_getOrganizationRoleData() throws TE_Excepcion {
        
        org.mockito.Mockito
        .when(taskMailboxServiceMock.invocar_getOrganizationRoleData(Mockito.anyObject(),
                Mockito.any(TE_Cabecera.class)))
        .thenCallRealMethod();
                
        
        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_OUT organizationRole_OUT = 
                new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_OUT();
        
        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_IN getOrganizationRole =
                new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.GetOrganizationRoleData_IN();
        List <BigDecimal> listIds = new ArrayList <BigDecimal>();
        listIds.add(BigDecimal.ONE);
        organizationRole_OUT = taskMailboxServiceMock
                .invocar_getOrganizationRoleData(listIds, cabecera);

    }
    
   @Test (expected = IllegalArgumentException.class)
    public void invocarOP_findOrganizationRole() throws TE_Excepcion {
        
        org.mockito.Mockito
        .when(taskMailboxServiceMock.invocarOP_findOrganizationRole(
                Mockito.anyObject(),
                Mockito.anyObject(),
                Mockito.anyObject(),
                Mockito.anyObject()))
        .thenCallRealMethod();
                
         
        com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_OUT findOrganizationRole_OUT = 
                new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_OUT();
        
        HashMap<BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN> orHashMap =
                new HashMap<BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN>();
                com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN or =
                        new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN();
                or.setId(BigDecimal.ONE);
        orHashMap.put(BigDecimal.ONE, or);
        findOrganizationRole_OUT = (FindOrganizationRole_OUT) taskMailboxServiceMock
                .invocarOP_findOrganizationRole(orHashMap,"findtasksmailboxesmanager", cabecera, metadatos);

    }
   
   @Test 
   public void test_mapearSalidaFindOrgRole() throws TE_Excepcion {

       FindOrganizationRole_OUT out = new FindOrganizationRole_OUT();
       com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT organizationRole_DTO_OUT =
               new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT();
       com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.Party_DTO_OUT party_DTO_OUT =
               new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.Party_DTO_OUT();
       party_DTO_OUT.setIndividualNameFormattedName("");
       organizationRole_DTO_OUT.setParty(party_DTO_OUT);
       
    
       out.setOrganizationRoles(new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT[]{organizationRole_DTO_OUT});
       taskMailboxService.mapearSalidaFindOrgRole(out, "findtasksmailboxesmanager");
       taskMailboxService.mapearSalidaFindOrgRole(out, "findfulltaskmailbox");
       taskMailboxService.mapearSalidaFindOrgRole(out, "findtaskmailboxoperators");
               
        
       com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_OUT findOrganizationRole_OUT = 
               new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_OUT();
       
       HashMap<BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN> orHashMap =
               new HashMap<BigDecimal, com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN>();
               com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN or =
                       new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_IN();
               or.setId(BigDecimal.ONE);
       orHashMap.put(BigDecimal.ONE, or);
       findOrganizationRole_OUT = (FindOrganizationRole_OUT) taskMailboxServiceMock
               .invocarOP_findOrganizationRole(orHashMap,"findtasksmailboxesmanager", cabecera, metadatos);

   }
   
   
    
    @Test (expected = IllegalArgumentException.class)
    public void invocarOP_findOrgRoleLowLevel() throws TE_Excepcion {
        
        org.mockito.Mockito
        .when(taskMailboxServiceMock.invocarOP_findOrgRoleLowLevel(Mockito.any(BigDecimal.class),
                Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class)))
        .thenCallRealMethod();
        
        
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT findOrgRoleLowLevel_OUT = 
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT();
        
        findOrgRoleLowLevel_OUT = taskMailboxServiceMock.invocarOP_findOrgRoleLowLevel(BigDecimal.ONE, cabecera, metadatos);

    }
    
    @Test (expected = IllegalArgumentException.class)
    public void invocarOP_listApplication() throws TE_Excepcion {
        
        org.mockito.Mockito
        .when(taskMailboxServiceMock.invocarOP_listApplication((Set<Long>) Mockito.any(Set.class),
                Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class)))
        .thenCallRealMethod();

        
        com.telefonica.gstr.srv.exp.application.msg.listapplication.ListApplication_OUT listApplication_OUT = 
                new com.telefonica.gstr.srv.exp.application.msg.listapplication.ListApplication_OUT();
        Set<Long> ids = new HashSet<Long>();
        ids.add(1L);
        
        listApplication_OUT = taskMailboxServiceMock.invocarOP_listApplication(ids, cabecera, metadatos);

    }
    
    @Test (expected = IllegalArgumentException.class)
    public void invocarOP_getRules() throws TE_Excepcion {
        
        org.mockito.Mockito
        .when(taskMailboxServiceMock.invocarOP_getRules((Set<BigDecimal>) Mockito.any(Set.class),
                Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class)))
        .thenCallRealMethod();
        
        
        com.telefonica.gere.srv.exp.rulequery.msg.getrules.GetRules_OUT getRules_OUT = 
                new com.telefonica.gere.srv.exp.rulequery.msg.getrules.GetRules_OUT();
        Set<BigDecimal> ids = new HashSet<BigDecimal>();
        ids.add(BigDecimal.ONE);
        
        getRules_OUT = taskMailboxServiceMock.invocarOP_getRules(ids, cabecera, metadatos);

    }

    /*
     * organization role sin informar
     */
    @Ignore
    @Test
    public void adFindTaskMailboxResponsible1() throws TE_Excepcion {
        List<CnalpFuncPoolAssignment> lista = new ArrayList<CnalpFuncPoolAssignment>();
        // cnalpFunctionalPool
        CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
        cnalpFunctionalPool.setWpooIdFunctionalPool(new BigDecimal(1));

        CnalpFuncPoolAssignment CnalpFuncPoolAssignment = new CnalpFuncPoolAssignment();
        CnalpFuncPoolAssignment.setCnalpFunctionalPool(cnalpFunctionalPool);
        lista.add(CnalpFuncPoolAssignment);

        Page<CnalpFuncPoolAssignment> page = new PageImpl<CnalpFuncPoolAssignment>(lista);

        Mockito.when(cnalpFuncPoolAssignmentRepository.findTaskMailBoxByResponsible(Mockito.any(Specification.class),
                Mockito.any(Pageable.class), Mockito.any(Sort.Order.class))).thenReturn(page);

        FindTaskMailBoxByResponsible_IN findTaskMailBoxByResponsible_IN = new FindTaskMailBoxByResponsible_IN();

        List<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN> listaTaskMailbox = new ArrayList<com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN>();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN taskMailbox = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN();

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FunctionalPool_DTO_IN functionalPool = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.FunctionalPool_DTO_IN();
        functionalPool.setId(new BigDecimal(1));
        taskMailbox.setFunctionalPool(functionalPool);
        taskMailbox.setId(new BigDecimal(1));
        listaTaskMailbox.add(taskMailbox);

        findTaskMailBoxByResponsible_IN.setTaskMailboxes(listaTaskMailbox.toArray(
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[listaTaskMailbox
                        .size()]));

        FindTaskMailBoxByResponsible_OUT findMailBoxByResponsible_OUT = taskMailboxServiceMock
                .findTaskMailBoxByResponsible(findTaskMailBoxByResponsible_IN, cabecera, metadatos);

        Assert.assertNotNull(findMailBoxByResponsible_OUT);
    }

    @Test
    public void adFindTasksMailBoxesManager() throws TE_Excepcion {
        try {
            TE_Ordenacion teOrdenacion = new TE_Ordenacion();
            teOrdenacion.setCriterioOrdenacions(new String[] { "AD_findTasksMailBoxesManager_configuracion1_DSC" });
            metadatos.setTE_Ordenacion(teOrdenacion);

            FindTasksMailBoxesManager_IN findTasksMailBoxesManager_IN = new FindTasksMailBoxesManager_IN();

            // Entrada
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_IN organizationRoleIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_IN();

            organizationRoleIn.setId(new BigDecimal(1));
            findTasksMailBoxesManager_IN.setOrganizationRole(organizationRoleIn);

            // Salida
            CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
            cnalaTaskMailbox.setMboxIdMailbox(new BigDecimal(101));
            cnalaTaskMailbox.setLboxNaMailbox("nameMailBox");
            cnalaTaskMailbox.setMboxCoFuncMailbox("77");

            CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();
            cnalrTaskMailboxL.setCnalaTaskMailbox(cnalaTaskMailbox);
            cnalrTaskMailboxL.setLboxNaMailbox("nameMultiLanguage");
            cnalrTaskMailboxL.setLangCoLanguage(1l);

            List<CnalrTaskMailboxL> listCnalrTaskMailboxL = new ArrayList<CnalrTaskMailboxL>();
            listCnalrTaskMailboxL.add(cnalrTaskMailboxL);

            GewfrMailboxAccess gewfrMailboxAccess = new GewfrMailboxAccess();
            gewfrMailboxAccess.setCnalaTaskMailbox(cnalaTaskMailbox);
            gewfrMailboxAccess.setMaacIdMailboxAccess(new BigDecimal(1));
            gewfrMailboxAccess.setParoIdFunctionalRole(BigDecimal.ONE);
            gewfrMailboxAccess.setMaacInMailboxAccess(true);
            gewfrMailboxAccess.setMaacInMailboxResponsible(true);
            List<GewfrMailboxAccess> listgewfrMailboxAccesses = new ArrayList<GewfrMailboxAccess>();
            listgewfrMailboxAccesses.add(gewfrMailboxAccess);

            CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
            cnalpFunctionalPool.setWpooIdFunctionalPool(new BigDecimal(77));
            cnalpFunctionalPool.setLfpoDsFunctionalPool("Descripcion");

            CnalrFunctionalPoolL cnalrFunctionalPoolL = new CnalrFunctionalPoolL();
            cnalrFunctionalPoolL.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalrFunctionalPoolL.setLfpoDsFunctionalPool("ES_DESC_VENTAS CANAL TELEFONICO");
            cnalrFunctionalPoolL.setLangCoLanguage(1l);
            List<CnalrFunctionalPoolL> ListcnalrFunctionalPoolLs = new ArrayList<CnalrFunctionalPoolL>();
            ListcnalrFunctionalPoolLs.add(cnalrFunctionalPoolL);

            cnalpFunctionalPool.setCnalrFunctionalPoolLs(ListcnalrFunctionalPoolLs);

            cnalaTaskMailbox.setCnalrTaskMailboxLs(listCnalrTaskMailboxL);
            cnalaTaskMailbox.setGewfrMailboxAccesses(listgewfrMailboxAccesses);
            cnalaTaskMailbox.setCnalpFunctionalPool(cnalpFunctionalPool);
            CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment = new CnalrOrgaPoolAssignment();
            cnalrOrgaPoolAssignment.setParoIdOrganizationRole(BigDecimal.ONE);
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment1(cnalrOrgaPoolAssignment);
            //----
            GetFunctionalRole_OUT getFunctionalRole_OUT = new GetFunctionalRole_OUT();
            
            
            List <com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT> listFunctionalRole_DTO_OUT =
                    new ArrayList <com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT>();
                    
            com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT functionalRole_DTO_OUT =
                    new com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT();
            
            functionalRole_DTO_OUT.setId(BigDecimal.ONE);
            
            com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.TimePeriod tp =
                    new com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.TimePeriod();
            tp.setEndDateTime(new Date());
            tp.setStartDateTime(new Date());
            functionalRole_DTO_OUT.setValidFor(tp);
            listFunctionalRole_DTO_OUT.add(functionalRole_DTO_OUT);
            getFunctionalRole_OUT.setFunctionalRoles(listFunctionalRole_DTO_OUT.toArray(
                    new com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT[listFunctionalRole_DTO_OUT.size()]));
            
            org.mockito.Mockito.when(taskMailboxServiceMock.llamadaGetFunctionalRole_objetoSalida(Mockito.any(),
                    Mockito.any(), Mockito.any())).thenReturn(getFunctionalRole_OUT);
            
            //---
            HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT> mapOrgRole_OUT =
                    new HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT>();

            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT orgRole = 
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT();

            mapOrgRole_OUT.put(BigDecimal.ONE,orgRole);

            org.mockito.Mockito
            .when(taskMailboxServiceMock.invocarOP_findOrganizationRole(
                    Mockito.anyObject(),
                    Mockito.anyObject(),
                    Mockito.anyObject(),
                    Mockito.anyObject())).thenReturn(mapOrgRole_OUT);
            
            //---

            /**
             * Mockeamos la llamada al DAO
             *
             */

            List<CnalaTaskMailbox> content = new ArrayList<CnalaTaskMailbox>();
            content.add(cnalaTaskMailbox);
            Page<CnalaTaskMailbox> cnalaTaskMailBoxSlice = new PageImpl<CnalaTaskMailbox>(content);
            org.mockito.Mockito.when(taskMailboxRepository.findTasksMailboxesManagerbyListIdFuncRole(Mockito.anyList(),
                    (Pageable) Mockito.anyObject())).thenReturn(cnalaTaskMailBoxSlice);

            FindTasksMailBoxesManager_OUT findTasksMailBoxesManager_OUT = taskMailboxServiceMock
                    .findTasksMailBoxesManager(findTasksMailBoxesManager_IN, cabecera, metadatos);

            assertTrue(findTasksMailBoxesManager_OUT != null);

        } catch (TE_Excepcion e) {
            assertFalse(e != null);
        }
    }

    @Test(expected = WebServiceException.class)
    public void llamadaFindOrganizationRole_objetoSalida()
            throws TE_Excepcion {

        Mockito.when(serviceRegistry.getEndpoint(Mockito.anyString())).thenReturn("endpoint");

        com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_IN findOrganizationRole_IN = 
                new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_IN();

        Holder<TE_Cabecera> holderCabecera = new Holder<TE_Cabecera>(cabecera);
        Holder<TE_Metadatos> holderMetadatos = new Holder<TE_Metadatos>(metadatos);

        Mockito.when(taskMailboxServiceMock.llamadaFindOrganizationRole_objetoSalida(Mockito.any(), Mockito.any(),
                Mockito.any())).thenCallRealMethod();

        com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.FindOrganizationRole_OUT findOrgRoleUpLevel_OUT = taskMailboxServiceMock
                .llamadaFindOrganizationRole_objetoSalida(findOrganizationRole_IN, holderCabecera, holderMetadatos);
    }
    
    @Test(expected = WebServiceException.class) 
    public void llamadaGetFunctionalRole_objetoSalida()
            throws TE_Excepcion {

        Mockito.when(serviceRegistry.getEndpoint(Mockito.anyString())).thenReturn("endpoint");

        com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.GetFunctionalRole_IN getFunctionalRole_IN = 
                new com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.GetFunctionalRole_IN();

        Holder<TE_Cabecera> holderCabecera = new Holder<TE_Cabecera>(cabecera);
        Holder<TE_Metadatos> holderMetadatos = new Holder<TE_Metadatos>(metadatos);

        Mockito.when(taskMailboxServiceMock.llamadaGetFunctionalRole_objetoSalida(Mockito.any(), Mockito.any(),
                Mockito.any())).thenCallRealMethod();

        com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.GetFunctionalRole_OUT getFunctionalRole_OUT = taskMailboxServiceMock
                .llamadaGetFunctionalRole_objetoSalida(getFunctionalRole_IN, holderCabecera, holderMetadatos);
    }
    
    /*
     * codigo de lenguage de taskMailbox y FuntionalPool diferente al de la
     * cabecera
     */
    @Test
    public void adFindTasksMailBoxesManager1() throws TE_Excepcion {
        try {
            TE_Ordenacion teOrdenacion = new TE_Ordenacion();
            teOrdenacion.setCriterioOrdenacions(new String[] { "AD_findTasksMailBoxesManager_configuracion1_DSC" });
            metadatos.setTE_Ordenacion(teOrdenacion);

            FindTasksMailBoxesManager_IN findTasksMailBoxesManager_IN = new FindTasksMailBoxesManager_IN();

            // Entrada
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_IN organizationRoleIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_IN();

            organizationRoleIn.setId(new BigDecimal(1));
            findTasksMailBoxesManager_IN.setOrganizationRole(organizationRoleIn);

            // Salida
            CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
            cnalaTaskMailbox.setMboxIdMailbox(new BigDecimal(101));
            cnalaTaskMailbox.setLboxNaMailbox("nameMailBox");
            cnalaTaskMailbox.setMboxCoFuncMailbox("77");

            CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();
            cnalrTaskMailboxL.setCnalaTaskMailbox(cnalaTaskMailbox);
            cnalrTaskMailboxL.setLboxNaMailbox("nameMultiLanguage");
            cnalrTaskMailboxL.setLangCoLanguage(001l);

            List<CnalrTaskMailboxL> listCnalrTaskMailboxL = new ArrayList<CnalrTaskMailboxL>();
            listCnalrTaskMailboxL.add(cnalrTaskMailboxL);

            GewfrMailboxAccess gewfrMailboxAccess = new GewfrMailboxAccess();
            gewfrMailboxAccess.setCnalaTaskMailbox(cnalaTaskMailbox);
            gewfrMailboxAccess.setMaacIdMailboxAccess(new BigDecimal(1));
            gewfrMailboxAccess.setMaacInMailboxAccess(true);
            gewfrMailboxAccess.setMaacInMailboxResponsible(true);
            gewfrMailboxAccess.setParoIdFunctionalRole(BigDecimal.ONE);
            List<GewfrMailboxAccess> listgewfrMailboxAccesses = new ArrayList<GewfrMailboxAccess>();
            listgewfrMailboxAccesses.add(gewfrMailboxAccess);

            CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
            cnalpFunctionalPool.setWpooIdFunctionalPool(new BigDecimal(77));
            cnalpFunctionalPool.setLfpoDsFunctionalPool("Descripcion");

            CnalrFunctionalPoolL cnalrFunctionalPoolL = new CnalrFunctionalPoolL();
            cnalrFunctionalPoolL.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalrFunctionalPoolL.setLfpoDsFunctionalPool("ES_DESC_VENTAS CANAL TELEFONICO");
            cnalrFunctionalPoolL.setLangCoLanguage(001l);
            List<CnalrFunctionalPoolL> ListcnalrFunctionalPoolLs = new ArrayList<CnalrFunctionalPoolL>();
            ListcnalrFunctionalPoolLs.add(cnalrFunctionalPoolL);

            cnalpFunctionalPool.setCnalrFunctionalPoolLs(ListcnalrFunctionalPoolLs);

            cnalaTaskMailbox.setCnalrTaskMailboxLs(listCnalrTaskMailboxL);
            cnalaTaskMailbox.setGewfrMailboxAccesses(listgewfrMailboxAccesses);
            cnalaTaskMailbox.setCnalpFunctionalPool(cnalpFunctionalPool);
            CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment = new CnalrOrgaPoolAssignment();
            cnalrOrgaPoolAssignment.setParoIdOrganizationRole(BigDecimal.ONE);
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment1(cnalrOrgaPoolAssignment);
            //----
            GetFunctionalRole_OUT getFunctionalRole_OUT = new GetFunctionalRole_OUT();
            
            
            List <com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT> listFunctionalRole_DTO_OUT =
                    new ArrayList <com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT>();
                    
            com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT functionalRole_DTO_OUT =
                    new com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT();
            
            functionalRole_DTO_OUT.setId(BigDecimal.ONE);
            
            com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.TimePeriod tp =
                    new com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.TimePeriod();
            tp.setEndDateTime(new Date());
            tp.setStartDateTime(new Date());
            functionalRole_DTO_OUT.setValidFor(tp);
            listFunctionalRole_DTO_OUT.add(functionalRole_DTO_OUT);
            getFunctionalRole_OUT.setFunctionalRoles(listFunctionalRole_DTO_OUT.toArray(
                    new com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT[listFunctionalRole_DTO_OUT.size()]));
            
            org.mockito.Mockito.when(taskMailboxServiceMock.llamadaGetFunctionalRole_objetoSalida(Mockito.any(),
                    Mockito.any(), Mockito.any())).thenReturn(getFunctionalRole_OUT);
            
            //---
            HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT> mapOrgRole_OUT =
                    new HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT>();

            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT orgRole = 
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT();

            mapOrgRole_OUT.put(BigDecimal.ONE,orgRole);

            org.mockito.Mockito
            .when(taskMailboxServiceMock.invocarOP_findOrganizationRole(
                    Mockito.anyObject(),
                    Mockito.anyObject(),
                    Mockito.anyObject(),
                    Mockito.anyObject())).thenReturn(mapOrgRole_OUT);

            /**
             * Mockeamos la llamada al DAO
             *
             */
            List<CnalaTaskMailbox> content = new ArrayList<CnalaTaskMailbox>();
            content.add(cnalaTaskMailbox);
            Page<CnalaTaskMailbox> cnalaTaskMailBoxSlice = new PageImpl<CnalaTaskMailbox>(content);
            org.mockito.Mockito.when(taskMailboxRepository.findTasksMailboxesManagerbyListIdFuncRole(Mockito.anyList(),
                    (Pageable) Mockito.anyObject())).thenReturn(cnalaTaskMailBoxSlice);

            FindTasksMailBoxesManager_OUT findTasksMailBoxesManager_OUT = taskMailboxServiceMock
                    .findTasksMailBoxesManager(findTasksMailBoxesManager_IN, cabecera, metadatos);

            assertTrue(findTasksMailBoxesManager_OUT != null);

        } catch (TE_Excepcion e) {
            assertFalse(e != null);
        }
    }

    /*
     * idioma por defecto diferente al de la cabecera
     */
    @Test
    public void adFindTasksMailBoxesManager2() throws TE_Excepcion {
        try {
            cabecera.setLenguaje("005");
            TE_Ordenacion teOrdenacion = new TE_Ordenacion();
            teOrdenacion.setCriterioOrdenacions(new String[] { "AD_findTasksMailBoxesManager_configuracion1_DSC" });
            metadatos.setTE_Ordenacion(teOrdenacion);

            FindTasksMailBoxesManager_IN findTasksMailBoxesManager_IN = new FindTasksMailBoxesManager_IN();

            // Entrada
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_IN organizationRoleIn = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_IN();

            organizationRoleIn.setId(new BigDecimal(1));
            findTasksMailBoxesManager_IN.setOrganizationRole(organizationRoleIn);

            // Salida
            CnalaTaskMailbox cnalaTaskMailbox = new CnalaTaskMailbox();
            cnalaTaskMailbox.setMboxIdMailbox(new BigDecimal(101));
            cnalaTaskMailbox.setLboxNaMailbox("nameMailBox");
            cnalaTaskMailbox.setMboxCoFuncMailbox("77");

            CnalrTaskMailboxL cnalrTaskMailboxL = new CnalrTaskMailboxL();
            cnalrTaskMailboxL.setCnalaTaskMailbox(cnalaTaskMailbox);
            cnalrTaskMailboxL.setLboxNaMailbox("nameMultiLanguage");
            cnalrTaskMailboxL.setLangCoLanguage(001l);

            List<CnalrTaskMailboxL> listCnalrTaskMailboxL = new ArrayList<CnalrTaskMailboxL>();
            listCnalrTaskMailboxL.add(cnalrTaskMailboxL);

            GewfrMailboxAccess gewfrMailboxAccess = new GewfrMailboxAccess();
            gewfrMailboxAccess.setCnalaTaskMailbox(cnalaTaskMailbox);
            gewfrMailboxAccess.setMaacIdMailboxAccess(new BigDecimal(1));
            gewfrMailboxAccess.setMaacInMailboxAccess(true);
            gewfrMailboxAccess.setMaacInMailboxResponsible(true);
            gewfrMailboxAccess.setParoIdFunctionalRole(BigDecimal.ONE);
            List<GewfrMailboxAccess> listgewfrMailboxAccesses = new ArrayList<GewfrMailboxAccess>();
            listgewfrMailboxAccesses.add(gewfrMailboxAccess);

            CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
            cnalpFunctionalPool.setWpooIdFunctionalPool(new BigDecimal(77));
            cnalpFunctionalPool.setLfpoDsFunctionalPool("Descripcion");

            CnalrFunctionalPoolL cnalrFunctionalPoolL = new CnalrFunctionalPoolL();
            cnalrFunctionalPoolL.setCnalpFunctionalPool(cnalpFunctionalPool);
            cnalrFunctionalPoolL.setLfpoDsFunctionalPool("ES_DESC_VENTAS CANAL TELEFONICO");
            cnalrFunctionalPoolL.setLangCoLanguage(001l);
            List<CnalrFunctionalPoolL> ListcnalrFunctionalPoolLs = new ArrayList<CnalrFunctionalPoolL>();
            ListcnalrFunctionalPoolLs.add(cnalrFunctionalPoolL);

            cnalpFunctionalPool.setCnalrFunctionalPoolLs(ListcnalrFunctionalPoolLs);

            cnalaTaskMailbox.setCnalrTaskMailboxLs(listCnalrTaskMailboxL);
            cnalaTaskMailbox.setGewfrMailboxAccesses(listgewfrMailboxAccesses);
            cnalaTaskMailbox.setCnalpFunctionalPool(cnalpFunctionalPool);
            CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment = new CnalrOrgaPoolAssignment();
            cnalrOrgaPoolAssignment.setParoIdOrganizationRole(BigDecimal.ONE);
            cnalaTaskMailbox.setCnalrOrgaPoolAssignment1(cnalrOrgaPoolAssignment);
            //----
            GetFunctionalRole_OUT getFunctionalRole_OUT = new GetFunctionalRole_OUT();
            
            
            List <com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT> listFunctionalRole_DTO_OUT =
                    new ArrayList <com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT>();
                    
            com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT functionalRole_DTO_OUT =
                    new com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT();
            
            functionalRole_DTO_OUT.setId(BigDecimal.ONE);
            
            com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.TimePeriod tp =
                    new com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.TimePeriod();
            tp.setEndDateTime(new Date());
            tp.setStartDateTime(new Date());
            functionalRole_DTO_OUT.setValidFor(tp);
            listFunctionalRole_DTO_OUT.add(functionalRole_DTO_OUT);
            getFunctionalRole_OUT.setFunctionalRoles(listFunctionalRole_DTO_OUT.toArray(
                    new com.telefonica.gest.srv.exp.engroleext.msg.getfunctionalrole.FunctionalRole_DTO_OUT[listFunctionalRole_DTO_OUT.size()]));
            
            org.mockito.Mockito.when(taskMailboxServiceMock.llamadaGetFunctionalRole_objetoSalida(Mockito.any(),
                    Mockito.any(), Mockito.any())).thenReturn(getFunctionalRole_OUT);
            
            //---
            HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT> mapOrgRole_OUT =
                    new HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT>();

            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT orgRole = 
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager.OrganizationRole_DTO_OUT();

            mapOrgRole_OUT.put(BigDecimal.ONE,orgRole);

            org.mockito.Mockito
            .when(taskMailboxServiceMock.invocarOP_findOrganizationRole(
                    Mockito.anyObject(),
                    Mockito.anyObject(),
                    Mockito.anyObject(),
                    Mockito.anyObject())).thenReturn(mapOrgRole_OUT);

            /**
             * Mockeamos la llamada al DAO
             *
             */
            List<CnalaTaskMailbox> content = new ArrayList<CnalaTaskMailbox>();
            content.add(cnalaTaskMailbox);
            Page<CnalaTaskMailbox> cnalaTaskMailBoxSlice = new PageImpl<CnalaTaskMailbox>(content);
            org.mockito.Mockito.when(taskMailboxRepository.findTasksMailboxesManagerbyListIdFuncRole(Mockito.anyList(),
                    (Pageable) Mockito.anyObject())).thenReturn(cnalaTaskMailBoxSlice);

            FindTasksMailBoxesManager_OUT findTasksMailBoxesManager_OUT = taskMailboxServiceMock
                    .findTasksMailBoxesManager(findTasksMailBoxesManager_IN, cabecera, metadatos);

            assertTrue(findTasksMailBoxesManager_OUT != null);

        } catch (TE_Excepcion e) {
            assertFalse(e != null);
        }
    }

    // estado en Desarrollo Solucion
    @Test
    public void adgetFunctionalTaskMailBoxCorrecto1() throws TE_Excepcion {
        GetFunctionalTaskMailbox_IN getfunctionaltaskmailbox_in = new GetFunctionalTaskMailbox_IN();
        getfunctionaltaskmailbox_in.setSalesChannelProposal(
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.SalesChannelProposal_DTO_IN());
        getfunctionaltaskmailbox_in.getSalesChannelProposal().setId(BigDecimal.ONE);

        ScprpSalesChannelProposal salesChannelProposal = new ScprpSalesChannelProposal();
        salesChannelProposal.setCecaaChanAdeqStateMovs(new ArrayList<CecaaChanAdeqStateMov>());
        salesChannelProposal.getCecaaChanAdeqStateMovs().add(new CecaaChanAdeqStateMov());
        salesChannelProposal.getCecaaChanAdeqStateMovs().get(0).setCecarChanAdeqStateRel(new CecarChanAdeqStateRel());
        salesChannelProposal.getCecaaChanAdeqStateMovs().get(0).getCecarChanAdeqStateRel()
                .setCecadChannelAdequacyState(new CecadChannelAdequacyState());
        salesChannelProposal.getCecaaChanAdeqStateMovs().get(0).getCecarChanAdeqStateRel()
                .getCecadChannelAdequacyState()
                .setBistIdChannelAdequacyState(ET_ChannelAdecuacyState.DESARROLLO_SOLUCION.getIdStatus());

        salesChannelProposal.setScpraChannelProposalRoles(new ArrayList<ScpraChannelProposalRole>());
        salesChannelProposal.getScpraChannelProposalRoles().add(new ScpraChannelProposalRole());
        salesChannelProposal.getScpraChannelProposalRoles().get(0)
                .setScprrPlanificationWorkflows(new ArrayList<ScprrPlanificationWorkflow>());
        salesChannelProposal.getScpraChannelProposalRoles().get(0).getScprrPlanificationWorkflows()
                .add(new ScprrPlanificationWorkflow());
        salesChannelProposal.getScpraChannelProposalRoles().get(0).getScprrPlanificationWorkflows().get(0)
                .setCnalaTaskMailbox(new CnalaTaskMailbox());
        salesChannelProposal.getScpraChannelProposalRoles().get(0).getScprrPlanificationWorkflows().get(0)
                .getCnalaTaskMailbox().setMboxIdMailbox(BigDecimal.ONE);
        org.mockito.Mockito.when(scprpSalesChannelProposalRepository.findFunctionalTaskMailbox(Mockito.anyObject()))
                .thenReturn(salesChannelProposal);
        GetFunctionalTaskMailbox_OUT getFunctionalTaskMailbox_OUT = taskMailboxServiceMock
                .getFunctionalTaskMailbox(getfunctionaltaskmailbox_in, cabecera, metadatos);

        assertNotNull(getFunctionalTaskMailbox_OUT);
        assertNotNull(getFunctionalTaskMailbox_OUT.getSalesChannelProposal());

    }

    // estado en Analisis
    @Test
    public void adgetFunctionalTaskMailBoxCorrecto2() throws TE_Excepcion {
        GetFunctionalTaskMailbox_IN getfunctionaltaskmailbox_in = new GetFunctionalTaskMailbox_IN();
        getfunctionaltaskmailbox_in.setSalesChannelProposal(
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.SalesChannelProposal_DTO_IN());
        getfunctionaltaskmailbox_in.getSalesChannelProposal().setId(BigDecimal.ONE);

        ScprpSalesChannelProposal salesChannelProposal = new ScprpSalesChannelProposal();
        salesChannelProposal.setCecaaChanAdeqStateMovs(new ArrayList<CecaaChanAdeqStateMov>());
        salesChannelProposal.getCecaaChanAdeqStateMovs().add(new CecaaChanAdeqStateMov());
        salesChannelProposal.getCecaaChanAdeqStateMovs().get(0).setCecarChanAdeqStateRel(new CecarChanAdeqStateRel());
        salesChannelProposal.getCecaaChanAdeqStateMovs().get(0).getCecarChanAdeqStateRel()
                .setCecadChannelAdequacyState(new CecadChannelAdequacyState());
        salesChannelProposal.getCecaaChanAdeqStateMovs().get(0).getCecarChanAdeqStateRel()
                .getCecadChannelAdequacyState()
                .setBistIdChannelAdequacyState(ET_ChannelAdecuacyState.EN_AN_VILIABILIDAD.getIdStatus());

        salesChannelProposal.setScpraChannelProposalRoles(new ArrayList<ScpraChannelProposalRole>());
        salesChannelProposal.getScpraChannelProposalRoles().add(new ScpraChannelProposalRole());
        salesChannelProposal.getScpraChannelProposalRoles().get(0)
                .setScprrPlanificationWorkflows(new ArrayList<ScprrPlanificationWorkflow>());
        salesChannelProposal.getScpraChannelProposalRoles().get(0).getScprrPlanificationWorkflows()
                .add(new ScprrPlanificationWorkflow());
        salesChannelProposal.getScpraChannelProposalRoles().get(0).getScprrPlanificationWorkflows().get(0)
                .setPlanInViability(1l);
        salesChannelProposal.getScpraChannelProposalRoles().get(0).getScprrPlanificationWorkflows().get(0)
                .setCnalaTaskMailbox(new CnalaTaskMailbox());
        salesChannelProposal.getScpraChannelProposalRoles().get(0).getScprrPlanificationWorkflows().get(0)
                .getCnalaTaskMailbox().setMboxIdMailbox(BigDecimal.ONE);
        org.mockito.Mockito.when(scprpSalesChannelProposalRepository.findFunctionalTaskMailbox(Mockito.anyObject()))
                .thenReturn(salesChannelProposal);
        GetFunctionalTaskMailbox_OUT getFunctionalTaskMailbox_OUT = taskMailboxServiceMock
                .getFunctionalTaskMailbox(getfunctionaltaskmailbox_in, cabecera, metadatos);

        assertNotNull(getFunctionalTaskMailbox_OUT);
        assertNotNull(getFunctionalTaskMailbox_OUT.getSalesChannelProposal());

    }

    // ------TEST Para FindTaskMailboxOperators
    
    @SuppressWarnings("unchecked")
    @Test
    public void adFindTaskMailboxOperatorsOK1() throws TE_Excepcion {

        
        List<GewfrMailboxAccess> lsAccesos = new ArrayList<GewfrMailboxAccess>();
        lsAccesos.add(new GewfrMailboxAccess());
        lsAccesos.get(0).setCnalaTaskMailbox(new CnalaTaskMailbox());
        lsAccesos.get(0).getCnalaTaskMailbox().setMboxIdMailbox(BigDecimal.ONE);
        when(gewfrMailboxAccessRepository.findAccessByFuncRole(Mockito.anyObject())).thenReturn(lsAccesos);
        
        GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = new GetOrganizationRoleByFuncRole_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[] arrayFuncRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[1];
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT funcRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT();
        funcRole.setId(BigDecimal.ONE);

        funcRole.setOrganizationRole(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.OrganizationRole_DTO_OUT());
        funcRole.getOrganizationRole().setCode("code");
        funcRole.getOrganizationRole().setId(BigDecimal.ONE);
        funcRole.getOrganizationRole().setParty(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.Party_DTO_OUT());
        funcRole.getOrganizationRole().getParty().setId(BigDecimal.ONE);
        arrayFuncRole[0] = funcRole;
        getOrganizationRoleByFuncRole_OUT.setFunctionalRoles(arrayFuncRole);
        when(taskMailboxServiceMock.llamadaGetOrganizationRoleByFuncRole_objetoSalida(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(getOrganizationRoleByFuncRole_OUT);

        
        // idOrganizationRole == null en la entrada
        
        Mockito.when(cnalpFuncPoolAssignmentRepositoryFPA.findFullFunctionalPoolAssignment(Mockito.any(Specification.class), Mockito.any(PageRequest.class), Mockito.any(Sort.Order.class))).thenReturn(null);

        TE_Ordenacion teOrdenacion = new TE_Ordenacion();
        teOrdenacion.setCriterioOrdenacions(new String[] { "AD_findTaskMailboxOperators_configuracion1_DSC" });
        metadatos.setTE_Ordenacion(teOrdenacion);
        FindTaskMailboxOperators_IN findtaskmailboxoperators_IN = new FindTaskMailboxOperators_IN();

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FunctionalPool_DTO_IN functionalPool_DTO_IN = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FunctionalPool_DTO_IN();
        functionalPool_DTO_IN.setId(new BigDecimal(1));

        findtaskmailboxoperators_IN.setFunctionalPool(functionalPool_DTO_IN);

        FindTaskMailboxOperators_OUT findTaskMailboxOperators_OUT = taskMailboxServiceMock
                .findTaskMailboxOperators(findtaskmailboxoperators_IN, cabecera, metadatos);

        assertNotNull(findTaskMailboxOperators_OUT);
    }

    // ------TEST Para FindTaskMailboxOperators
    @Test
    public void adFindTaskMailboxOperatorsOK2() throws TE_Excepcion {

        List<GewfrMailboxAccess> lsAccesos = new ArrayList<GewfrMailboxAccess>();
        lsAccesos.add(new GewfrMailboxAccess());
        lsAccesos.get(0).setCnalaTaskMailbox(new CnalaTaskMailbox());
        lsAccesos.get(0).getCnalaTaskMailbox().setMboxIdMailbox(BigDecimal.ONE);
        when(gewfrMailboxAccessRepository.findAccessByFuncRole(Mockito.anyObject())).thenReturn(lsAccesos);
        
        GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = new GetOrganizationRoleByFuncRole_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[] arrayFuncRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[1];
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT funcRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT();
        funcRole.setId(BigDecimal.ONE);

        funcRole.setOrganizationRole(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.OrganizationRole_DTO_OUT());
        funcRole.getOrganizationRole().setCode("code");
        funcRole.getOrganizationRole().setId(BigDecimal.ONE);
        funcRole.getOrganizationRole().setParty(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.Party_DTO_OUT());
        funcRole.getOrganizationRole().getParty().setId(BigDecimal.ONE);
        arrayFuncRole[0] = funcRole;
        getOrganizationRoleByFuncRole_OUT.setFunctionalRoles(arrayFuncRole);
        when(taskMailboxServiceMock.llamadaGetOrganizationRoleByFuncRole_objetoSalida(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(getOrganizationRoleByFuncRole_OUT);

        
        // mockeos
        List<CnalpFuncPoolAssignment> resultados = new ArrayList<CnalpFuncPoolAssignment>();
        resultados.add(new CnalpFuncPoolAssignment());
        resultados.get(0).setParoIdFunctionalRole(BigDecimal.ONE);

        Page<CnalpFuncPoolAssignment> pageCnalpFuncPoolAssignment = new PageImpl<CnalpFuncPoolAssignment>(resultados);

        org.mockito.Mockito.when(cnalpFuncPoolAssignmentRepository.findTaskMailboxOperators(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(pageCnalpFuncPoolAssignment);

        List<CnalaTaskMailbox> resultadosMbox = new ArrayList<CnalaTaskMailbox>();
        resultadosMbox.add(new CnalaTaskMailbox());
        CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2 = new CnalrOrgaPoolAssignment();
        CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
        cnalpFunctionalPool.setWpooIdFunctionalPool(BigDecimal.ONE);
        cnalrOrgaPoolAssignment2.setCnalpFunctionalPool(cnalpFunctionalPool);
        resultadosMbox.get(0).setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment2);
        resultadosMbox.get(0).setGewfrMailboxAccesses(new ArrayList<GewfrMailboxAccess>());
        resultadosMbox.get(0).getGewfrMailboxAccesses().add(new GewfrMailboxAccess());
        resultadosMbox.get(0).getGewfrMailboxAccesses().get(0).setMaacInMailboxAccess(Boolean.FALSE);
        resultadosMbox.get(0).getGewfrMailboxAccesses().get(0).setMaacInMailboxResponsible(Boolean.FALSE);

        Page<CnalaTaskMailbox> pageCnalaTaskMailbox = new PageImpl<CnalaTaskMailbox>(resultadosMbox);

        org.mockito.Mockito.when(taskMailboxRepository.findTaskMailboxOperators(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(pageCnalaTaskMailbox);

        // idOrganizationRole != null en la entrada

        TE_Ordenacion teOrdenacion = new TE_Ordenacion();
        teOrdenacion.setCriterioOrdenacions(new String[] { "AD_findTaskMailboxOperators_configuracion1_DSC" });
        metadatos.setTE_Ordenacion(teOrdenacion);

        FindTaskMailboxOperators_IN findtaskmailboxoperators_IN = new FindTaskMailboxOperators_IN();

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FunctionalPool_DTO_IN functionalPool_DTO_IN = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FunctionalPool_DTO_IN();
        functionalPool_DTO_IN.setId(BigDecimal.ONE);

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_IN organizationRole_DTO_IN = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_IN();
        organizationRole_DTO_IN.setId(BigDecimal.ONE);

        findtaskmailboxoperators_IN.setFunctionalPool(functionalPool_DTO_IN);
        findtaskmailboxoperators_IN.setOrganizationRole(organizationRole_DTO_IN);

        FindTaskMailboxOperators_OUT findTaskMailboxOperators_OUT = taskMailboxServiceMock
                .findTaskMailboxOperators(findtaskmailboxoperators_IN, cabecera, metadatos);

        assertNotNull(findTaskMailboxOperators_OUT);
        assertNotNull(findTaskMailboxOperators_OUT.getOrganizationRoles());
    }

    
    @Test
    public void adFindTaskMailboxOperatorsOK3() throws TE_Excepcion {
        List<GewfrMailboxAccess> lsAccesos = new ArrayList<GewfrMailboxAccess>();
        lsAccesos.add(new GewfrMailboxAccess());
        lsAccesos.get(0).setCnalaTaskMailbox(new CnalaTaskMailbox());
        lsAccesos.get(0).getCnalaTaskMailbox().setMboxIdMailbox(BigDecimal.ONE);
        lsAccesos.get(0).setMaacInMailboxAccess(Boolean.FALSE);
        lsAccesos.get(0).setMaacInMailboxResponsible(Boolean.FALSE);
        
        when(gewfrMailboxAccessRepository.findAccessByFuncRole(Mockito.anyObject())).thenReturn(lsAccesos);
        
        GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = new GetOrganizationRoleByFuncRole_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[] arrayFuncRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[1];
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT funcRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT();
        funcRole.setId(BigDecimal.ONE);

        funcRole.setOrganizationRole(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.OrganizationRole_DTO_OUT());
        funcRole.getOrganizationRole().setCode("code");
        funcRole.getOrganizationRole().setId(BigDecimal.ONE);
        funcRole.getOrganizationRole().setParty(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.Party_DTO_OUT());
        funcRole.getOrganizationRole().getParty().setId(BigDecimal.ONE);
        arrayFuncRole[0] = funcRole;
        getOrganizationRoleByFuncRole_OUT.setFunctionalRoles(arrayFuncRole);
        when(taskMailboxServiceMock.llamadaGetOrganizationRoleByFuncRole_objetoSalida(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(getOrganizationRoleByFuncRole_OUT);

        
        // mockeos
        List<CnalpFuncPoolAssignment> resultados = new ArrayList<CnalpFuncPoolAssignment>();
        resultados.add(new CnalpFuncPoolAssignment());
        resultados.get(0).setParoIdFunctionalRole(BigDecimal.ONE);

        Page<CnalpFuncPoolAssignment> pageCnalpFuncPoolAssignment = new PageImpl<CnalpFuncPoolAssignment>(resultados);

        org.mockito.Mockito.when(cnalpFuncPoolAssignmentRepository.findTaskMailboxOperators(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(pageCnalpFuncPoolAssignment);

        List<CnalaTaskMailbox> resultadosMbox = new ArrayList<CnalaTaskMailbox>();
        resultadosMbox.add(new CnalaTaskMailbox());
        resultadosMbox.get(0).setMboxIdMailbox(BigDecimal.ONE);
        CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2 = new CnalrOrgaPoolAssignment();
        CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
        cnalpFunctionalPool.setWpooIdFunctionalPool(BigDecimal.ONE);
        cnalrOrgaPoolAssignment2.setCnalpFunctionalPool(cnalpFunctionalPool);
        resultadosMbox.get(0).setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment2);
        resultadosMbox.get(0).setGewfrMailboxAccesses(new ArrayList<GewfrMailboxAccess>());
        resultadosMbox.get(0).getGewfrMailboxAccesses().add(new GewfrMailboxAccess());
        resultadosMbox.get(0).getGewfrMailboxAccesses().get(0).setMaacInMailboxAccess(Boolean.FALSE);
        resultadosMbox.get(0).getGewfrMailboxAccesses().get(0).setMaacInMailboxResponsible(Boolean.FALSE);

        Page<CnalaTaskMailbox> pageCnalaTaskMailbox = new PageImpl<CnalaTaskMailbox>(resultadosMbox);

        org.mockito.Mockito.when(taskMailboxRepository.findTaskMailboxOperators(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(pageCnalaTaskMailbox);

        // idOrganizationRole != null en la entrada

        TE_Ordenacion teOrdenacion = new TE_Ordenacion();
        teOrdenacion.setCriterioOrdenacions(new String[] { "AD_findTaskMailboxOperators_configuracion1_DSC" });
        metadatos.setTE_Ordenacion(teOrdenacion);

        FindTaskMailboxOperators_IN findtaskmailboxoperators_IN = new FindTaskMailboxOperators_IN();

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FunctionalPool_DTO_IN functionalPool_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FunctionalPool_DTO_IN();
        functionalPool_DTO_IN.setId(BigDecimal.ONE);

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_IN();
        organizationRole_DTO_IN.setId(BigDecimal.ONE);

        findtaskmailboxoperators_IN.setFunctionalPool(functionalPool_DTO_IN);
        findtaskmailboxoperators_IN.setOrganizationRole(null);
        
        //----------
        List<CnalpFuncPoolAssignment> resultados2 = new ArrayList<CnalpFuncPoolAssignment>();
        resultados2.add(new CnalpFuncPoolAssignment());
        resultados2.get(0).setParoIdFunctionalRole(BigDecimal.ONE);
        CnalpFunctionalPool cnalpFunctionalPool2 = new CnalpFunctionalPool();
        cnalpFunctionalPool2.setCnalpFuncPoolAssignments(resultados);
        CnalrOrgaPoolAssignment orgapoolass = new CnalrOrgaPoolAssignment();
        List <CnalrOrgaPoolAssignment> listCnalrOrgaPoolAssignment = new ArrayList <CnalrOrgaPoolAssignment>();
        orgapoolass.setOpasIdOrgaPoolAssignment(BigDecimal.ONE);
        orgapoolass.setCnalaTaskMailboxs1(resultadosMbox);
        listCnalrOrgaPoolAssignment.add(orgapoolass);
        cnalpFunctionalPool2.setCnalrOrgaPoolAssignments(listCnalrOrgaPoolAssignment);
        cnalpFunctionalPool2.setCnalaTaskMailboxs(resultadosMbox);
        resultados2.get(0).setCnalpFunctionalPool(cnalpFunctionalPool2);
        Page<CnalpFuncPoolAssignment> pageCnalpFuncPoolAssignment2 = new PageImpl<CnalpFuncPoolAssignment>(resultados2);
        
        org.mockito.Mockito.when(cnalpFuncPoolAssignmentRepositoryFPA.findFullFunctionalPoolAssignment(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(pageCnalpFuncPoolAssignment2);
        
        
        //----
        HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT> mapOrgRole_OUT =
                new HashMap<BigDecimal, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT>();

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT orgRole = 
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT();

        mapOrgRole_OUT.put(BigDecimal.ONE,orgRole);

        org.mockito.Mockito
        .when(taskMailboxServiceMock.invocarOP_findOrganizationRole(
                Mockito.anyObject(),
                Mockito.anyObject(),
                Mockito.anyObject(),
                Mockito.anyObject())).thenReturn(mapOrgRole_OUT);
        
        
        //------------

        
        FindTaskMailboxOperators_OUT findTaskMailboxOperators_OUT = taskMailboxServiceMock
                .findTaskMailboxOperators(findtaskmailboxoperators_IN, cabecera, metadatos);

        assertNotNull(findTaskMailboxOperators_OUT);
        assertNotNull(findTaskMailboxOperators_OUT.getOrganizationRoles());
    }
    
    @Test (expected = TE_Excepcion.class)
    public void adFindTaskMailboxOperatorsOK3lanzarExcepcion() throws TE_Excepcion {

        
        List<GewfrMailboxAccess> lsAccesos = new ArrayList<GewfrMailboxAccess>();
        lsAccesos.add(new GewfrMailboxAccess());
        lsAccesos.get(0).setCnalaTaskMailbox(new CnalaTaskMailbox());
        lsAccesos.get(0).getCnalaTaskMailbox().setMboxIdMailbox(BigDecimal.ONE);
        lsAccesos.get(0).setMaacInMailboxAccess(Boolean.FALSE);
        lsAccesos.get(0).setMaacInMailboxResponsible(Boolean.FALSE);
        
        when(gewfrMailboxAccessRepository.findAccessByFuncRole(Mockito.anyObject())).thenReturn(lsAccesos);
        
        
        GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = new GetOrganizationRoleByFuncRole_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[] arrayFuncRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[1];
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT funcRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT();
        funcRole.setId(BigDecimal.ONE);

        funcRole.setOrganizationRole(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.OrganizationRole_DTO_OUT());
        funcRole.getOrganizationRole().setCode("code");
        funcRole.getOrganizationRole().setId(BigDecimal.ONE);
        funcRole.getOrganizationRole().setParty(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.Party_DTO_OUT());
        funcRole.getOrganizationRole().getParty().setId(BigDecimal.ONE);
        arrayFuncRole[0] = funcRole;
        getOrganizationRoleByFuncRole_OUT.setFunctionalRoles(arrayFuncRole);
        when(taskMailboxServiceMock.llamadaGetOrganizationRoleByFuncRole_objetoSalida(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(getOrganizationRoleByFuncRole_OUT);

        
        // mockeos
        List<CnalpFuncPoolAssignment> resultados = new ArrayList<CnalpFuncPoolAssignment>();
        resultados.add(new CnalpFuncPoolAssignment());
        resultados.get(0).setParoIdFunctionalRole(BigDecimal.ONE);

        Page<CnalpFuncPoolAssignment> pageCnalpFuncPoolAssignment = new PageImpl<CnalpFuncPoolAssignment>(resultados);

        org.mockito.Mockito.when(cnalpFuncPoolAssignmentRepository.findTaskMailboxOperators(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(pageCnalpFuncPoolAssignment);

        List<CnalaTaskMailbox> resultadosMbox = new ArrayList<CnalaTaskMailbox>();
        resultadosMbox.add(new CnalaTaskMailbox());
        CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2 = new CnalrOrgaPoolAssignment();
        CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
        cnalpFunctionalPool.setWpooIdFunctionalPool(BigDecimal.ONE);
        cnalrOrgaPoolAssignment2.setCnalpFunctionalPool(cnalpFunctionalPool);
        resultadosMbox.get(0).setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment2);
        resultadosMbox.get(0).setGewfrMailboxAccesses(new ArrayList<GewfrMailboxAccess>());
        resultadosMbox.get(0).getGewfrMailboxAccesses().add(new GewfrMailboxAccess());
        resultadosMbox.get(0).getGewfrMailboxAccesses().get(0).setMaacInMailboxAccess(Boolean.FALSE);
        resultadosMbox.get(0).getGewfrMailboxAccesses().get(0).setMaacInMailboxResponsible(Boolean.FALSE);

        Page<CnalaTaskMailbox> pageCnalaTaskMailbox = new PageImpl<CnalaTaskMailbox>(resultadosMbox);

        org.mockito.Mockito.when(taskMailboxRepository.findTaskMailboxOperators(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(pageCnalaTaskMailbox);

        // idOrganizationRole != null en la entrada

        TE_Ordenacion teOrdenacion = new TE_Ordenacion();
        teOrdenacion.setCriterioOrdenacions(new String[] { "AD_findTaskMailboxOperators_configuracion1_DSC" });
        metadatos.setTE_Ordenacion(teOrdenacion);

        FindTaskMailboxOperators_IN findtaskmailboxoperators_IN = new FindTaskMailboxOperators_IN();

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FunctionalPool_DTO_IN functionalPool_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FunctionalPool_DTO_IN();
        functionalPool_DTO_IN.setId(BigDecimal.ONE);

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_IN();
        organizationRole_DTO_IN.setId(BigDecimal.ONE);

        findtaskmailboxoperators_IN.setFunctionalPool(functionalPool_DTO_IN);
        findtaskmailboxoperators_IN.setOrganizationRole(null);
        
        //----------
        List<CnalpFuncPoolAssignment> resultados2 = new ArrayList<CnalpFuncPoolAssignment>();
        resultados2.add(new CnalpFuncPoolAssignment());
        resultados2.get(0).setParoIdFunctionalRole(BigDecimal.ONE);
        CnalpFunctionalPool cnalpFunctionalPool2 = new CnalpFunctionalPool();
        cnalpFunctionalPool2.setCnalpFuncPoolAssignments(resultados);
        CnalrOrgaPoolAssignment orgapoolass = new CnalrOrgaPoolAssignment();
        List <CnalrOrgaPoolAssignment> listCnalrOrgaPoolAssignment = new ArrayList <CnalrOrgaPoolAssignment>();
        orgapoolass.setOpasIdOrgaPoolAssignment(BigDecimal.ONE);
        orgapoolass.setCnalaTaskMailboxs1(resultadosMbox);
        listCnalrOrgaPoolAssignment.add(orgapoolass);
        cnalpFunctionalPool2.setCnalrOrgaPoolAssignments(listCnalrOrgaPoolAssignment);
        cnalpFunctionalPool2.setCnalaTaskMailboxs(resultadosMbox);
        resultados2.get(0).setCnalpFunctionalPool(cnalpFunctionalPool2);
        Page<CnalpFuncPoolAssignment> pageCnalpFuncPoolAssignment2 = new PageImpl<CnalpFuncPoolAssignment>(resultados2);
        
        org.mockito.Mockito.when(cnalpFuncPoolAssignmentRepositoryFPA.findFullFunctionalPoolAssignment(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(pageCnalpFuncPoolAssignment2);
        
        
        //----
        
        com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT organizationRole_DTO_OUT = 
                new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT();
        List <com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT> listOrganizationRole_DTO_OUT =
                new ArrayList <com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT>();
        organizationRole_DTO_OUT.setId(BigDecimal.ONE);
        organizationRole_DTO_OUT.setCode("co");
        com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.Party_DTO_OUT party =
                new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.Party_DTO_OUT();
        party.setId(BigDecimal.ONE);
        party.setIndividualNameFormattedName("na");
        organizationRole_DTO_OUT.setParty(party);
        
        
        FindOrganizationRole_OUT findOrganizationRole_OUT = new FindOrganizationRole_OUT();
        findOrganizationRole_OUT.setOrganizationRoles(listOrganizationRole_DTO_OUT.toArray(
                new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT[listOrganizationRole_DTO_OUT.size()]));
        
        Mockito.when(taskMailboxServiceMock.invocarOP_findOrganizationRole(
                Mockito.anyObject(),
                Mockito.anyObject(),
                Mockito.anyObject(),
                Mockito.anyObject())).thenThrow(new TE_Excepcion("", ""));
        
        
        //------------

        
        FindTaskMailboxOperators_OUT findTaskMailboxOperators_OUT = taskMailboxServiceMock
                .findTaskMailboxOperators(findtaskmailboxoperators_IN, cabecera, metadatos);

        assertNotNull(findTaskMailboxOperators_OUT);
        assertNotNull(findTaskMailboxOperators_OUT.getOrganizationRoles());
    }
    
    
    
    @Test
    public void adFindTaskMailboxOperatorsOK4() throws TE_Excepcion {

        List<GewfrMailboxAccess> lsAccesos = new ArrayList<GewfrMailboxAccess>();
        lsAccesos.add(new GewfrMailboxAccess());
        lsAccesos.get(0).setCnalaTaskMailbox(new CnalaTaskMailbox());
        lsAccesos.get(0).getCnalaTaskMailbox().setMboxIdMailbox(BigDecimal.ONE);
        when(gewfrMailboxAccessRepository.findAccessByFuncRole(Mockito.anyObject())).thenReturn(lsAccesos);
        
        GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = new GetOrganizationRoleByFuncRole_OUT();
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[] arrayFuncRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT[1];
        com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT funcRole =
                new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.FunctionalRole_DTO_OUT();
        funcRole.setId(BigDecimal.ONE);

        funcRole.setOrganizationRole(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.OrganizationRole_DTO_OUT());
        funcRole.getOrganizationRole().setCode("code");
        funcRole.getOrganizationRole().setId(BigDecimal.ONE);
        funcRole.getOrganizationRole().setParty(new com.telefonica.gest.srv.exp.engroleext.msg.getorganizationrolebyfuncrole.Party_DTO_OUT());
        funcRole.getOrganizationRole().getParty().setId(BigDecimal.ONE);
        arrayFuncRole[0] = funcRole;
        getOrganizationRoleByFuncRole_OUT.setFunctionalRoles(arrayFuncRole);
        when(taskMailboxServiceMock.llamadaGetOrganizationRoleByFuncRole_objetoSalida(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(getOrganizationRoleByFuncRole_OUT);

        
        // mockeos
        List<CnalpFuncPoolAssignment> resultados = new ArrayList<CnalpFuncPoolAssignment>();
        resultados.add(new CnalpFuncPoolAssignment());
        resultados.get(0).setParoIdFunctionalRole(BigDecimal.ONE);

        Page<CnalpFuncPoolAssignment> pageCnalpFuncPoolAssignment = new PageImpl<CnalpFuncPoolAssignment>(resultados);

        org.mockito.Mockito.when(cnalpFuncPoolAssignmentRepository.findTaskMailboxOperators(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(pageCnalpFuncPoolAssignment);

        List<CnalaTaskMailbox> resultadosMbox = new ArrayList<CnalaTaskMailbox>();
        resultadosMbox.add(new CnalaTaskMailbox());
        CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2 = new CnalrOrgaPoolAssignment();
        CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
        cnalpFunctionalPool.setWpooIdFunctionalPool(BigDecimal.ONE);
        cnalrOrgaPoolAssignment2.setCnalpFunctionalPool(cnalpFunctionalPool);
        resultadosMbox.get(0).setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment2);
        resultadosMbox.get(0).setGewfrMailboxAccesses(new ArrayList<GewfrMailboxAccess>());
        resultadosMbox.get(0).getGewfrMailboxAccesses().add(new GewfrMailboxAccess());
        resultadosMbox.get(0).getGewfrMailboxAccesses().get(0).setMaacInMailboxAccess(Boolean.FALSE);
        resultadosMbox.get(0).getGewfrMailboxAccesses().get(0).setMaacInMailboxResponsible(Boolean.FALSE);

        Page<CnalaTaskMailbox> pageCnalaTaskMailbox = new PageImpl<CnalaTaskMailbox>(resultadosMbox);

        org.mockito.Mockito.when(taskMailboxRepository.findTaskMailboxOperators(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(pageCnalaTaskMailbox);

        // idOrganizationRole != null en la entrada

        TE_Ordenacion teOrdenacion = new TE_Ordenacion();
        teOrdenacion.setCriterioOrdenacions(new String[] { "AD_findTaskMailboxOperators_configuracion1_DSC" });
        metadatos.setTE_Ordenacion(teOrdenacion);

        FindTaskMailboxOperators_IN findtaskmailboxoperators_IN = new FindTaskMailboxOperators_IN();

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FunctionalPool_DTO_IN functionalPool_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.FunctionalPool_DTO_IN();
        functionalPool_DTO_IN.setId(BigDecimal.ONE);

        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_IN();
        organizationRole_DTO_IN.setId(BigDecimal.ONE);

        findtaskmailboxoperators_IN.setFunctionalPool(functionalPool_DTO_IN);
        findtaskmailboxoperators_IN.setOrganizationRole(organizationRole_DTO_IN);
        
        //----------
        List<CnalpFuncPoolAssignment> resultados2 = new ArrayList<CnalpFuncPoolAssignment>();
        resultados2.add(new CnalpFuncPoolAssignment());
        resultados2.get(0).setParoIdFunctionalRole(BigDecimal.ONE);
        CnalpFunctionalPool cnalpFunctionalPool2 = new CnalpFunctionalPool();
        cnalpFunctionalPool2.setCnalpFuncPoolAssignments(resultados);
        CnalrOrgaPoolAssignment orgapoolass = new CnalrOrgaPoolAssignment();
        List <CnalrOrgaPoolAssignment> listCnalrOrgaPoolAssignment = new ArrayList <CnalrOrgaPoolAssignment>();
        orgapoolass.setOpasIdOrgaPoolAssignment(BigDecimal.ONE);
        orgapoolass.setCnalaTaskMailboxs1(resultadosMbox);
        listCnalrOrgaPoolAssignment.add(orgapoolass);
        cnalpFunctionalPool2.setCnalrOrgaPoolAssignments(listCnalrOrgaPoolAssignment);
        cnalpFunctionalPool2.setCnalaTaskMailboxs(resultadosMbox);
        resultados2.get(0).setCnalpFunctionalPool(cnalpFunctionalPool2);
        Page<CnalpFuncPoolAssignment> pageCnalpFuncPoolAssignment2 = new PageImpl<CnalpFuncPoolAssignment>(resultados2);
        
        org.mockito.Mockito.when(cnalpFuncPoolAssignmentRepositoryFPA.findFullFunctionalPoolAssignment(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(pageCnalpFuncPoolAssignment2);
        
        
        //----
        
        com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT organizationRole_DTO_OUT = 
                new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT();
        List <com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT> listOrganizationRole_DTO_OUT =
                new ArrayList <com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT>();
        organizationRole_DTO_OUT.setId(BigDecimal.ONE);
        organizationRole_DTO_OUT.setCode("co");
        com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.Party_DTO_OUT party =
                new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.Party_DTO_OUT();
        party.setId(BigDecimal.ONE);
        party.setIndividualNameFormattedName("na");
        organizationRole_DTO_OUT.setParty(party);
        
        
        listOrganizationRole_DTO_OUT.add(organizationRole_DTO_OUT);
        FindOrganizationRole_OUT findOrganizationRole_OUT = new FindOrganizationRole_OUT();
        findOrganizationRole_OUT.setOrganizationRoles(listOrganizationRole_DTO_OUT.toArray(
                new com.telefonica.gest.srv.exp.engroleext.msg.findorganizationrole.OrganizationRole_DTO_OUT[listOrganizationRole_DTO_OUT.size()]));
        
        Mockito.when(taskMailboxServiceMock.invocarOP_findOrganizationRole(
                Mockito.anyObject(),
                Mockito.anyObject(),
                Mockito.anyObject(),
                Mockito.anyObject())).thenReturn(findOrganizationRole_OUT);
        
        
        //------------
        
        
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT out3 =
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FindOrgRoleLowLevel_OUT();
        
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.OrganizationRole_DTO_OUT organizationRole_DTO_OUT2 =
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.OrganizationRole_DTO_OUT();
        organizationRole_DTO_OUT2.setId(BigDecimal.ONE);
        organizationRole_DTO_OUT2.setCode("co");
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.Party_DTO_OUT party2 =
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.Individual_DTO_OUT();
        party2.setId(BigDecimal.ONE);
        organizationRole_DTO_OUT2.setParty(party2);
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT functionalRole_DTO_OUT =
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT();
        List <com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT> listFunctionalRole_DTO_OUT = 
                new ArrayList <com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT>();
        functionalRole_DTO_OUT.setId(BigDecimal.ONE);
        com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRoleSpec_DTO_OUT functionalRoleSpec_DTO_OUT =
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRoleSpec_DTO_OUT();
        functionalRoleSpec_DTO_OUT.setIcon("icon");
        functionalRoleSpec_DTO_OUT.setId(1L);
        functionalRoleSpec_DTO_OUT.setName("name");
        functionalRole_DTO_OUT.setFunctionalRoleSpec(functionalRoleSpec_DTO_OUT);
        listFunctionalRole_DTO_OUT.add(functionalRole_DTO_OUT);
        organizationRole_DTO_OUT2.setFunctionalRoles(listFunctionalRole_DTO_OUT.toArray(
                new com.telefonica.gest.srv.exp.engroleext.msg.findorgrolelowlevel.FunctionalRole_DTO_OUT[listFunctionalRole_DTO_OUT.size()]));
        out3.setOrganizationRole(organizationRole_DTO_OUT2);
        
        
        
        Mockito.when(taskMailboxServiceMock.invocarOP_findOrgRoleLowLevel(Mockito.anyObject(),
                Mockito.anyObject(), Mockito.anyObject())).thenReturn(out3);
        
        
        //------------

        
        FindTaskMailboxOperators_OUT findTaskMailboxOperators_OUT = taskMailboxServiceMock
                .findTaskMailboxOperators(findtaskmailboxoperators_IN, cabecera, metadatos);

        assertNotNull(findTaskMailboxOperators_OUT);
        assertNotNull(findTaskMailboxOperators_OUT.getOrganizationRoles());
    }
    
    @Test
    public void getManagerByTaskMailbox() throws TE_Excepcion {
        List<CnalaTaskMailbox> list = new ArrayList<CnalaTaskMailbox>();
        when(taskMailboxRepository.findManagerByTaskMailbox(Mockito.any(List.class), Mockito.any(List.class)))
                .thenReturn(list);

        GetManagerByTaskMailbox_IN in = new GetManagerByTaskMailbox_IN();
        List<TaskMailbox_DTO_IN> inl = new ArrayList<TaskMailbox_DTO_IN>();
        in.setTaskMailboxes(inl.toArray(new TaskMailbox_DTO_IN[0]));
        try {
            taskMailboxService.getManagerByTaskMailbox(in, null, null);
            assertTrue(false);
        } catch (TE_Excepcion e) {
            assertThat(e.getFaultInfo().getErrorId()).isEqualTo("CANA-E-000131");
        }

        TaskMailbox_DTO_IN in1 = new TaskMailbox_DTO_IN();
        in1.setId(BigDecimal.ONE);
        inl.add(in1);
        in1 = new TaskMailbox_DTO_IN();
        in1.setCode("--");
        inl.add(in1);
        in.setTaskMailboxes(inl.toArray(new TaskMailbox_DTO_IN[0]));
        try {
            taskMailboxService.getManagerByTaskMailbox(in, null, null);
            assertTrue(false);
        } catch (TE_Excepcion e) {
            assertThat(e.getFaultInfo().getErrorId()).isEqualTo("CANA-E-000131");
        }

        inl.remove(0);
        in.setTaskMailboxes(inl.toArray(new TaskMailbox_DTO_IN[0]));
        try {
            taskMailboxService.getManagerByTaskMailbox(in, null, null);
            assertTrue(false);
        } catch (TE_Excepcion e) {
            assertThat(e.getFaultInfo().getErrorId()).isEqualTo("CANA-E-000303");
        }

        CnalaTaskMailbox mbox = new CnalaTaskMailbox();
        mbox.setMboxIdMailbox(BigDecimal.TEN);
        mbox.setMboxCoFuncMailbox("--");
        mbox.setGewfrMailboxAccesses(new ArrayList<GewfrMailboxAccess>());
        mbox.getGewfrMailboxAccesses().add(new GewfrMailboxAccess());
        mbox.getGewfrMailboxAccesses().get(0).setMaacIdMailboxAccess(BigDecimal.ONE);
        mbox.getGewfrMailboxAccesses().get(0).setMaacInMailboxAccess(Boolean.FALSE);
        mbox.getGewfrMailboxAccesses().get(0).setMaacInMailboxResponsible(Boolean.TRUE);
        mbox.getGewfrMailboxAccesses().get(0).setParoIdFunctionalRole(BigDecimal.ZERO);
        list.add(mbox);

        GetManagerByTaskMailbox_OUT out = taskMailboxService.getManagerByTaskMailbox(in, null, null);
        assertThat(out).isNotNull();
        assertThat(out.getTaskMailboxes()).isNotNull();
        assertThat(out.getTaskMailboxes().length).isEqualTo(list.size());
        for (int i = 0; i < list.size(); i++) {
            TaskMailbox_DTO_OUT o1 = out.getTaskMailboxes()[i];
            CnalaTaskMailbox o2 = list.get(i);
            assertThat(o1.getId()).isEqualTo(o2.getMboxIdMailbox());
            assertThat(o1.getCode()).isEqualTo(o2.getMboxCoFuncMailbox());
            assertThat(o1.getMailboxAccesses()).isNotNull();
            assertThat(o1.getMailboxAccesses().length).isEqualTo(1);
            assertThat(o1.getMailboxAccesses()[0].getFunctionalRole()).isNotNull();
            assertThat(o1.getMailboxAccesses()[0].getFunctionalRole().getId())
                    .isEqualTo(o2.getGewfrMailboxAccesses().get(0).getParoIdFunctionalRole());
            assertThat(o1.getMailboxAccesses()[0].isMailboxAccess())
                    .isEqualTo(o2.getGewfrMailboxAccesses().get(0).getMaacInMailboxAccess());
            assertThat(o1.getMailboxAccesses()[0].isMailboxResponsible())
                    .isEqualTo(o2.getGewfrMailboxAccesses().get(0).getMaacInMailboxResponsible());
            assertThat(o1.getMailboxAccesses()[0].getId())
                    .isEqualTo(o2.getGewfrMailboxAccesses().get(0).getMaacIdMailboxAccess());
        }

    }

    @Test
    public void getOrganizationTaskMailboxByFunctionalPool() throws TE_Excepcion {
        List<OrganizationPoolAssignmentDTO> list = new ArrayList<OrganizationPoolAssignmentDTO>();
        when(cnalrOrgaPoolAssignmentRepository.findOrgTaskMailboxByFunctionalPool(Mockito.any(List.class)))
                .thenReturn(list);

        GetOrganizationTaskMailboxByFunctionalPool_IN in = new GetOrganizationTaskMailboxByFunctionalPool_IN();
        List<FunctionalPool_DTO_IN> inl = new ArrayList<FunctionalPool_DTO_IN>();
        in.setFunctionalPools(inl.toArray(new FunctionalPool_DTO_IN[0]));
        try {
            taskMailboxService.getOrganizationTaskMailboxByFunctionalPool(in, null, null);
            assertTrue(false);
        } catch (TE_Excepcion e) {
            assertThat(e.getFaultInfo().getErrorId()).isEqualTo("CANA-E-000131");
        }

        FunctionalPool_DTO_IN in1 = new FunctionalPool_DTO_IN();
        in1.setId(BigDecimal.ONE);
        inl.add(in1);
        in.setFunctionalPools(inl.toArray(new FunctionalPool_DTO_IN[0]));
        
        GetOrganizationTaskMailboxByFunctionalPool_OUT outVacio = null;
//        try {
        outVacio = taskMailboxService.getOrganizationTaskMailboxByFunctionalPool(in, null, null);
//            assertTrue(false);
//        } catch (TE_Excepcion e) {
//            assertThat(e.getFaultInfo().getErrorId()).isEqualTo("CANA-E-000302");
//        }
        assertThat(outVacio != null);
        
        OrganizationPoolAssignmentDTO opa = new OrganizationPoolAssignmentDTO();
        opa.setCodeTaskMailbox("--");
        opa.setId(BigDecimal.ZERO);
        opa.setIdFunctionalPool(BigDecimal.ONE);
        opa.setIdOrganizationRole(BigDecimal.TEN);
        opa.setIdTaskMailbox(BigDecimal.ZERO);
        list.add(opa);

        GetOrganizationTaskMailboxByFunctionalPool_OUT out = taskMailboxService
                .getOrganizationTaskMailboxByFunctionalPool(in, null, null);
        assertThat(out).isNotNull();
        assertThat(out.getOrganizationPoolAssignments()).isNotNull();
        assertThat(out.getOrganizationPoolAssignments().length).isEqualTo(list.size());
        for (int i = 0; i < list.size(); i++) {
            OrganizationPoolAssignment_DTO_OUT o1 = out.getOrganizationPoolAssignments()[i];
            OrganizationPoolAssignmentDTO o2 = list.get(i);
            assertThat(o1.getId()).isEqualTo(o2.getId());
            assertThat(o1.getFunctionalPool()).isNotNull();
            assertThat(o1.getFunctionalPool().getId()).isEqualTo(o2.getIdFunctionalPool());
            assertThat(o1.getOrganizationRole()).isNotNull();
            assertThat(o1.getOrganizationRole().getId()).isEqualTo(o2.getIdOrganizationRole());
            assertThat(o1.getTaskMailbox()).isNotNull();
            assertThat(o1.getTaskMailbox().getId()).isEqualTo(o2.getIdTaskMailbox());
            assertThat(o1.getTaskMailbox().getCode()).isEqualTo(o2.getCodeTaskMailbox());
        }

    }

    @Test
    public void getTaskMailboxTreeByEnterpriseFunction() throws TE_Excepcion {
        GetTaskMailboxTreeByEnterpriseFunction_IN in = new GetTaskMailboxTreeByEnterpriseFunction_IN();

        when(taskMailboxServiceMock.getMessagebyIdioma(Mockito.anyString(), Mockito.anyString(),
                Mockito.anyObject())).thenReturn("CANA_E_000131");
        Mockito.when(taskMailboxServiceMock.getTaskMailboxTreeByEnterpriseFunction(Mockito.any(),
                Mockito.any(), Mockito.any())).thenCallRealMethod();

        try {
            taskMailboxServiceMock.getTaskMailboxTreeByEnterpriseFunction(in, null, null);
            assertTrue(false);
        } catch (TE_Excepcion e) {
            assertThat(e.getFaultInfo().getErrorId()).isEqualTo("CANA_E_000131");
        }

        in.setEnterpriseFunctionTreeNode(new EnterpriseFunctionTreeNode_DTO_IN());
        try {
            taskMailboxServiceMock.getTaskMailboxTreeByEnterpriseFunction(in, null, null);
            assertTrue(false);
        } catch (TE_Excepcion e) {
            assertThat(e.getFaultInfo().getErrorId()).isEqualTo("CANA_E_000131");
        }

        in.getEnterpriseFunctionTreeNode().setId(1L);
        in.setFunctionalPool(
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.FunctionalPool_DTO_IN());
        in.getFunctionalPool().setId(BigDecimal.ONE);
          when(taskMailboxServiceMock.getMessagebyIdioma(Mockito.anyString(), Mockito.anyString(),
                    Mockito.anyObject())).thenReturn("CANA_E_000132");
        try {
            taskMailboxServiceMock.getTaskMailboxTreeByEnterpriseFunction(in, null, null);
            assertTrue(false);
        } catch (TE_Excepcion e) {
            assertThat(e.getFaultInfo().getErrorId()).isEqualTo("CANA_E_000132");
        }

        CnalaEnteFunctionTreeNode eftn = new CnalaEnteFunctionTreeNode();
        CnaldEnterpriseFunction ef = new CnaldEnterpriseFunction();
        ef.setEnfuIdEnterpriseFunction(1L);
        ef.setLefuNaEnterpriseFunction("EnterpriseFunction 1");
        eftn.setCnaldEnterpriseFunction(ef);

        CnalpFunctionalPool fp1 = new CnalpFunctionalPool();
        fp1.setWpooIdFunctionalPool(BigDecimal.ONE);
        fp1.setFupoInMailboxState(1L);
        fp1.setFupoNaFunctionalPool("FunctionalPool 1");
        fp1.setFupoInPoolType(2L);
        fp1.setFupoInWorkMode(3L);
        fp1.setCnalaEnteFunctionTreeNode(eftn);
        CnalrOrgaPoolAssignment opa1 = new CnalrOrgaPoolAssignment();
        opa1.setParoIdOrganizationRole(BigDecimal.ONE);
        fp1.setCnalrOrgaPoolAssignments(Arrays.asList(opa1));
        CnalpFunctionalPool fp2 = new CnalpFunctionalPool();
        fp2.setWpooIdFunctionalPool(BigDecimal.TEN);
        CnalrOrgaPoolAssignment opa2 = new CnalrOrgaPoolAssignment();
        opa2.setParoIdOrganizationRole(BigDecimal.TEN);
        fp2.setCnalrOrgaPoolAssignments(Arrays.asList(opa2));
        eftn.setCnalpFunctionalPools(Arrays.asList(fp1, fp2));
        eftn.setEftnIdEnteFuncTreeNode(1L);

        CnalaEnteFunctionTreeNode eftnh1 = new CnalaEnteFunctionTreeNode();
        CnaldEnterpriseFunction efh = new CnaldEnterpriseFunction();
        efh.setEnfuIdEnterpriseFunction(2L);
        efh.setLefuNaEnterpriseFunction("EnterpriseFunction 2");
        eftnh1.setCnaldEnterpriseFunction(efh);
        eftnh1.setCnalpFunctionalPools(Arrays.asList(fp1));
        eftn.setCnalaEnteFunctionTreeNodes(Arrays.asList(eftnh1));

        when(cnalaEnteFunctionTreeNodeRepository.findOne(Mockito.any(Long.class))).thenReturn(eftn);
//      try {
//          taskMailboxService.getTaskMailboxTreeByEnterpriseFunction(in, null, null);
//          assertTrue(false);
//      } catch (TE_Excepcion e) {
//          assertThat(e.getFaultInfo().getErrorId()).isEqualTo("CANA-E-000133");
//      }

        GetOrganizationRoleData_OUT oo = new GetOrganizationRoleData_OUT();
        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT oo1 = new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT();
        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT op1 = new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT();
        oo1.setId(BigDecimal.ONE);
        op1.setOrganizationName(new OrganizationName_DTO_OUT());
        op1.getOrganizationName().setTradingName("TradingName 1");
        oo1.setParty(op1);
        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT oo2 = new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT();
        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT op2 = new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT();
        oo2.setId(BigDecimal.TEN);
        op2.setOrganizationName(new OrganizationName_DTO_OUT());
        op2.getOrganizationName().setTradingName("TradingName 10");
        oo2.setParty(op2);
        oo.setOrganizationRoles(
                new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT[] {
                        oo1, oo2 });

        CnalaTaskMailbox dato = new CnalaTaskMailbox();
        dato.setMboxCoFuncMailbox("CODE 1");
        dato.setMboxIdMailbox(BigDecimal.ONE);
        dato.setMboxInBrotherReallocation(Boolean.FALSE);
        dato.setCnalpFunctionalPool(fp1);
        dato.setMboxQuMaximumAmount(4L);
        dato.setLboxNaMailbox("Mailbox 1");
        dato.setMboxInState(6L);
        dato.setMboxTiStartValidity(new Timestamp(0L));
        dato.setMboxQuVolume(5L);
        CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment = new CnalrOrgaPoolAssignment();
        cnalrOrgaPoolAssignment.setOpasIdOrgaPoolAssignment(BigDecimal.ONE);
        cnalrOrgaPoolAssignment.setParoIdOrganizationRole(BigDecimal.ONE);
        dato.setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment);
        dato.setCnalpFunctionalPool(fp1);
        when(cnalaTaskMailboxRepository.findTaskMailboxByEnterpriseFunction(Mockito.any()))
                .thenReturn(Arrays.asList(dato));

        when(env.getProperty("cana.overflow.idOverflow")).thenReturn("1");
        GetTaskMailboxTreeByEnterpriseFunction_OUT out = new GetTaskMailboxTreeByEnterpriseFunction_OUT();
//      getTaskMailboxTreeByEnterpriseFunction_test(out, false);

        in = new GetTaskMailboxTreeByEnterpriseFunction_IN();
        in.setTaskMailbox(
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.TaskMailbox_DTO_IN());
        in.getTaskMailbox().setId(BigDecimal.ONE);
        in.getTaskMailbox().setName("A");
        in.setFunctionalPool(new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.FunctionalPool_DTO_IN());
        in.getFunctionalPool().setId(BigDecimal.ONE);
        Mockito.when(taskMailboxServiceMock.invocar_getOrganizationRoleData(Mockito.anyObject(),
                Mockito.anyObject())).thenReturn(oo);


        when(cnalaTaskMailboxRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(dato);
        out = taskMailboxServiceMock.getTaskMailboxTreeByEnterpriseFunction(in, null, null);
        //getTaskMailboxTreeByEnterpriseFunction_test(out, true);

        dato.setMboxInBrotherReallocation(Boolean.FALSE);
        when(cnalaTaskMailboxRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(dato);
        out = taskMailboxServiceMock.getTaskMailboxTreeByEnterpriseFunction(in, null, null);
        assertThat(out).isNotNull();
        //getTaskMailboxTreeByEnterpriseFunction_test(out, true);
    }
    
    
    @Test
    public void getTaskMailboxTreeByEnterpriseFunction2() throws TE_Excepcion {
        GetTaskMailboxTreeByEnterpriseFunction_IN in = new GetTaskMailboxTreeByEnterpriseFunction_IN();

        Mockito.when(taskMailboxServiceMock.getTaskMailboxTreeByEnterpriseFunction(Mockito.any(),
                Mockito.any(), Mockito.any())).thenCallRealMethod();



        CnalaEnteFunctionTreeNode eftn = new CnalaEnteFunctionTreeNode();
        CnaldEnterpriseFunction ef = new CnaldEnterpriseFunction();
        ef.setEnfuIdEnterpriseFunction(1L);
        ef.setLefuNaEnterpriseFunction("EnterpriseFunction 1");
        eftn.setCnaldEnterpriseFunction(ef);
        eftn.setEftnIdEnteFuncTreeNode(1l);
        eftn.setCnalaEnteFunctionTreeNode(eftn);
        

        CnalpFunctionalPool fp1 = new CnalpFunctionalPool();
        fp1.setWpooIdFunctionalPool(BigDecimal.ONE);
        fp1.setFupoInMailboxState(1L);
        fp1.setFupoNaFunctionalPool("FunctionalPool 1");
        fp1.setFupoInPoolType(2L);
        fp1.setFupoInWorkMode(3L);
        fp1.setCnalaEnteFunctionTreeNode(eftn);
        CnalrOrgaPoolAssignment opa1 = new CnalrOrgaPoolAssignment();
        opa1.setParoIdOrganizationRole(BigDecimal.ONE);
        fp1.setCnalrOrgaPoolAssignments(Arrays.asList(opa1));
        CnalpFunctionalPool fp2 = new CnalpFunctionalPool();
        fp2.setWpooIdFunctionalPool(BigDecimal.TEN);
        CnalrOrgaPoolAssignment opa2 = new CnalrOrgaPoolAssignment();
        opa2.setParoIdOrganizationRole(BigDecimal.TEN);
        fp2.setCnalrOrgaPoolAssignments(Arrays.asList(opa2));
        eftn.setCnalpFunctionalPools(Arrays.asList(fp1, fp2));
        eftn.setEftnIdEnteFuncTreeNode(1L);

        CnalaEnteFunctionTreeNode eftnh1 = new CnalaEnteFunctionTreeNode();
        eftnh1.setEftnIdEnteFuncTreeNode(2L);
        CnaldEnterpriseFunction efh = new CnaldEnterpriseFunction();
        efh.setEnfuIdEnterpriseFunction(2L);
        efh.setLefuNaEnterpriseFunction("EnterpriseFunction 2");
        eftnh1.setCnaldEnterpriseFunction(efh);
        eftnh1.setCnalpFunctionalPools(Arrays.asList(fp1));
        eftn.setCnalaEnteFunctionTreeNodes(Arrays.asList(eftnh1));

        when(cnalaEnteFunctionTreeNodeRepository.findOne(Mockito.any(Long.class))).thenReturn(eftn);
//      try {
//          taskMailboxService.getTaskMailboxTreeByEnterpriseFunction(in, null, null);
//          assertTrue(false);
//      } catch (TE_Excepcion e) {
//          assertThat(e.getFaultInfo().getErrorId()).isEqualTo("CANA-E-000133");
//      }

        GetOrganizationRoleData_OUT oo = new GetOrganizationRoleData_OUT();
        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT oo1 = new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT();
        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT op1 = new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT();
        oo1.setId(BigDecimal.ONE);
        op1.setOrganizationName(new OrganizationName_DTO_OUT());
        op1.getOrganizationName().setTradingName("TradingName 1");
        oo1.setParty(op1);
        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT oo2 = new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT();
        com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT op2 = new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.Organization_DTO_OUT();
        oo2.setId(BigDecimal.TEN);
        op2.setOrganizationName(new OrganizationName_DTO_OUT());
        op2.getOrganizationName().setTradingName("TradingName 10");
        oo2.setParty(op2);
        oo.setOrganizationRoles(
                new com.telefonica.gest.srv.exp.engsecurity.msg.getorganizationroledata.OrganizationRole_DTO_OUT[] {
                        oo1, oo2 });

        CnalaTaskMailbox dato = new CnalaTaskMailbox();
        dato.setMboxCoFuncMailbox("CODE 1");
        dato.setMboxIdMailbox(BigDecimal.ONE);
        dato.setMboxInBrotherReallocation(Boolean.TRUE);
        dato.setCnalpFunctionalPool(fp1);
        dato.setMboxQuMaximumAmount(4L);
        dato.setLboxNaMailbox("Mailbox 1");
        dato.setMboxInState(6L);
        dato.setMboxTiStartValidity(new Timestamp(0L));
        dato.setMboxQuVolume(5L);
        CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment = new CnalrOrgaPoolAssignment();
        cnalrOrgaPoolAssignment.setOpasIdOrgaPoolAssignment(BigDecimal.ONE);
        cnalrOrgaPoolAssignment.setParoIdOrganizationRole(BigDecimal.ONE);
        dato.setCnalrOrgaPoolAssignment2(cnalrOrgaPoolAssignment);
        dato.setCnalpFunctionalPool(fp1);
        
        when(cnalaTaskMailboxRepository.findTaskMailboxByEnterpriseFunction(Mockito.any()))
                .thenReturn(Arrays.asList(dato));
        
        when(cnalaTaskMailboxRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(dato);

        when(env.getProperty("cana.overflow.idOverflow")).thenReturn("1");
        GetTaskMailboxTreeByEnterpriseFunction_OUT out = new GetTaskMailboxTreeByEnterpriseFunction_OUT();
//      getTaskMailboxTreeByEnterpriseFunction_test(out, false);

        in = new GetTaskMailboxTreeByEnterpriseFunction_IN();
        in.setTaskMailbox(
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.TaskMailbox_DTO_IN());
        in.getTaskMailbox().setId(BigDecimal.ONE);
        in.getTaskMailbox().setName("A");
        
        Mockito.when(taskMailboxServiceMock.invocar_getOrganizationRoleData(Mockito.anyObject(),
                Mockito.anyObject())).thenReturn(oo);


        out = taskMailboxServiceMock.getTaskMailboxTreeByEnterpriseFunction(in, cabecera, metadatos);

    }

    private void getTaskMailboxTreeByEnterpriseFunction_test(GetTaskMailboxTreeByEnterpriseFunction_OUT out,
            boolean reac) {
        assertThat(out).isNotNull();
        assertThat(out.getTaskMailboxesLength()).isEqualTo(1);
        assertThat(out.getTaskMailboxes(0).getCode()).isEqualTo("CODE 1");
        assertThat(out.getTaskMailboxes(0).getId()).isEqualTo(BigDecimal.ONE);
        assertThat(out.getTaskMailboxes(0).getFunctionalPool()).isNotNull();
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getId()).isEqualTo(BigDecimal.ONE);
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getEnterpriseFunctionTreeNode()).isNotNull();
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getEnterpriseFunctionTreeNode().getEnterpriseFunction())
                .isNotNull();
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getEnterpriseFunctionTreeNode().getEnterpriseFunction()
                .getId()).isEqualTo(1L);
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getEnterpriseFunctionTreeNode().getEnterpriseFunction()
                .getName()).isEqualTo("EnterpriseFunction 1");
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getEnterpriseFunctionTreeNode().getEnterpriseFunction()
                .isOverflow()).isEqualTo(true);
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getEnterpriseFunctionTreeNode()
                .getEnterpriseFunctionTreeNodeSonsLength()).isEqualTo(1);
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getEnterpriseFunctionTreeNode()
                .getEnterpriseFunctionTreeNodeSons(0)).isNotNull();
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getEnterpriseFunctionTreeNode()
                .getEnterpriseFunctionTreeNodeSons(0).getEnterpriseFunction()).isNotNull();
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getEnterpriseFunctionTreeNode()
                .getEnterpriseFunctionTreeNodeSons(0).getEnterpriseFunction().getId()).isEqualTo(2L);
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getEnterpriseFunctionTreeNode()
                .getEnterpriseFunctionTreeNodeSons(0).getEnterpriseFunction().getName())
                        .isEqualTo("EnterpriseFunction 2");
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getEnterpriseFunctionTreeNode()
                .getEnterpriseFunctionTreeNodeSons(0).getEnterpriseFunctionTreeNodeSonsLength()).isEqualTo(0);
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getMailboxStatus()).isEqualTo("1");
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getName()).isEqualTo("FunctionalPool 1");
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getPoolType()).isEqualTo("2");
        assertThat(out.getTaskMailboxes(0).getFunctionalPool().getWorkMode()).isEqualTo("3");
        assertThat(out.getTaskMailboxes(0).getMaxQuantity()).isEqualTo(4L);
        assertThat(out.getTaskMailboxes(0).getName()).isEqualTo("Mailbox 1");
        assertThat(out.getTaskMailboxes(0).getState()).isEqualTo("6");
        assertThat(out.getTaskMailboxes(0).getValidFor()).isNotNull();
        assertThat(out.getTaskMailboxes(0).getValidFor().getStartDateTime()).isNotNull();
        assertThat(out.getTaskMailboxes(0).getValidFor().getEndDateTime()).isNull();
        assertThat(out.getTaskMailboxes(0).getVolume()).isEqualTo(5L);
        assertThat(out.getTaskMailboxes(0).isBrotherReallocation()).isEqualTo(reac);
        assertThat(out.getTaskMailboxes(0).getOrganizationRole()).isNotNull();
        assertThat(out.getTaskMailboxes(0).getOrganizationRole().getId()).isEqualTo(BigDecimal.ONE);
        assertThat(out.getTaskMailboxes(0).getOrganizationRole().getOrganizationName()).isNotNull();
        
    }
    
    @Test 
    public void manageTaskMailboxInsert() throws TE_Excepcion {
        ManageTaskMailbox_IN managetaskmailbox_in = new ManageTaskMailbox_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailboxDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList multiLanguageList = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage multiLanguage [] = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage[1];
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TimePeriod timePeriod = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TimePeriod();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.FunctionalPool_DTO_IN functionalPoolDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.FunctionalPool_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.OrganizationPoolAssignment_DTO_IN organizationPoolAssignmentDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.OrganizationPoolAssignment_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.DistributionCriteria_DTO_IN distributionCriteriaDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.DistributionCriteria_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.Rule_DTO_IN ruleDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.Rule_DTO_IN();
        com.telefonica.cana.model.CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment = new com.telefonica.cana.model.CnalrOrgaPoolAssignment();
        
        List<com.telefonica.cana.model.CnalaTaskMailbox> listaCnalaTaskMailbox = new ArrayList<com.telefonica.cana.model.CnalaTaskMailbox>();
        
        List<com.telefonica.cana.model.CnalrOrgaPoolAssignment> listaCnalrOrgaPoolAssignment = new ArrayList<com.telefonica.cana.model.CnalrOrgaPoolAssignment>();
        listaCnalrOrgaPoolAssignment.add(cnalrOrgaPoolAssignment);
        
        List<com.telefonica.cana.model.CnalrOrgaPoolAssignment> listaCnalrOrgaPoolAssignment2 = new ArrayList<com.telefonica.cana.model.CnalrOrgaPoolAssignment>();
        
        ruleDTO.setId(BigDecimal.ONE);
        
        distributionCriteriaDTO.setId(1l);
        
        organizationPoolAssignmentDTO.setId(BigDecimal.ONE);
        
        functionalPoolDTO.setId(BigDecimal.ONE);
        
        timePeriod.setStartDateTime(new Date());
        timePeriod.setEndDateTime(new Date());
        
        multiLanguage[0] = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage();
        multiLanguage[0].setLanguageCode(1l);
        multiLanguage[0].setValue("1");
        multiLanguageList.setMultiLanguages(multiLanguage);
        
        taskMailboxDTO.setName(multiLanguageList);
        taskMailboxDTO.setCode("1");
        taskMailboxDTO.setValidFor(timePeriod);
        taskMailboxDTO.setFunctionalPool(functionalPoolDTO);
        taskMailboxDTO.setOrganizationPoolAssignment(organizationPoolAssignmentDTO);
        taskMailboxDTO.setDistributionCriteria(distributionCriteriaDTO);
        taskMailboxDTO.setRule(ruleDTO);
        
        managetaskmailbox_in.setOperationType(1l);
        managetaskmailbox_in.setTaskMailbox(taskMailboxDTO);
         
        CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2 = null;
        CnalpFunctionalPool cnalpFunctionalPool = new CnalpFunctionalPool();
        cnalpFunctionalPool.setWpooIdFunctionalPool(BigDecimal.ONE);
        when(cnalpFunctionalPoolRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(cnalpFunctionalPool);
        when(cnalrOrgaPoolAssignmentRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(cnalrOrgaPoolAssignment);
        when(taskMailboxRepository.findAll(Mockito.any(Specifications.class))).thenReturn(listaCnalaTaskMailbox);
        when(cnalrOrgaPoolAssignmentRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(cnalrOrgaPoolAssignment);
        when(cnalrOrgaPoolAssignmentRepository.findOne(Mockito.any(Specifications.class))).thenReturn(cnalrOrgaPoolAssignment2);
        when(cnalrOrgaPoolAssignmentRepository.findAll(Mockito.any(Specifications.class))).thenReturn(listaCnalrOrgaPoolAssignment).thenReturn(listaCnalrOrgaPoolAssignment).thenReturn(listaCnalrOrgaPoolAssignment2);
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_OUT manageTaskMailbox_OUT = taskMailboxServiceMock
                .manageTaskMailbox(managetaskmailbox_in, cabecera, metadatos);

        assertThat(manageTaskMailbox_OUT).isNotNull();
    }
    
    @Test (expected = TE_Excepcion.class)
    public void manageTaskMailboxValidacionErronea() throws TE_Excepcion {
        taskMailboxServiceMock.manageTaskMailbox(null, null, null);
    }

    @Test (expected = TE_Excepcion.class)
    public void manageTaskMailboxOperacionErronea() throws TE_Excepcion {
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailBoxDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN();

        ManageTaskMailbox_IN managetaskmailbox_in = new ManageTaskMailbox_IN();
        managetaskmailbox_in.setOperationType(3l);
        managetaskmailbox_in.setTaskMailbox(taskMailBoxDTO);
        
        taskMailboxServiceMock.manageTaskMailbox(managetaskmailbox_in, null, null);
    }
    
    @Test (expected = TE_Excepcion.class)
    public void manageTaskMailboxFaltanDatos() throws TE_Excepcion {
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailBoxDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN();

        ManageTaskMailbox_IN managetaskmailbox_in = new ManageTaskMailbox_IN();
        managetaskmailbox_in.setOperationType(1l);
        managetaskmailbox_in.setTaskMailbox(taskMailBoxDTO);
        
        taskMailboxServiceMock.manageTaskMailbox(managetaskmailbox_in, null, null);
    }
    
    @Test (expected = TE_Excepcion.class)
    public void manageTaskMailboxExceptionMontarCnala() throws TE_Excepcion {
        
        ManageTaskMailbox_IN managetaskmailbox_in = new ManageTaskMailbox_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailboxDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList multiLanguageList = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage multiLanguage [] = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage[1];
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TimePeriod timePeriod = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TimePeriod();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.FunctionalPool_DTO_IN functionalPoolDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.FunctionalPool_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.OrganizationPoolAssignment_DTO_IN organizationPoolAssignmentDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.OrganizationPoolAssignment_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.DistributionCriteria_DTO_IN distributionCriteriaDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.DistributionCriteria_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.Rule_DTO_IN ruleDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.Rule_DTO_IN();
        
        List<com.telefonica.cana.model.CnalaTaskMailbox> listaCnalaTaskMailbox = new ArrayList<com.telefonica.cana.model.CnalaTaskMailbox>();
        
        List<com.telefonica.cana.model.CnalrOrgaPoolAssignment> listaCnalrOrgaPoolAssignment = new ArrayList<com.telefonica.cana.model.CnalrOrgaPoolAssignment>();
        
        ruleDTO.setId(BigDecimal.ONE);
        
        distributionCriteriaDTO.setId(1l);
        
        organizationPoolAssignmentDTO.setId(BigDecimal.ONE);
        
        functionalPoolDTO.setId(BigDecimal.ONE);
        
        timePeriod.setStartDateTime(new Date());
        timePeriod.setEndDateTime(new Date());
        
        multiLanguage[0] = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage();
        multiLanguage[0].setLanguageCode(1l);
        multiLanguage[0].setValue("1");
        multiLanguageList.setMultiLanguages(multiLanguage);
        
        taskMailboxDTO.setName(multiLanguageList);
        taskMailboxDTO.setCode("1");
        taskMailboxDTO.setValidFor(timePeriod);
        taskMailboxDTO.setFunctionalPool(functionalPoolDTO);
        taskMailboxDTO.setOrganizationPoolAssignment(organizationPoolAssignmentDTO);
        taskMailboxDTO.setDistributionCriteria(distributionCriteriaDTO);
        taskMailboxDTO.setRule(ruleDTO);
        
        managetaskmailbox_in.setOperationType(1l);
        managetaskmailbox_in.setTaskMailbox(taskMailboxDTO);
        
        when(taskMailboxRepository.findAll(Mockito.any(Specifications.class))).thenReturn(listaCnalaTaskMailbox);
        when(cnalrOrgaPoolAssignmentRepository.findAll(Mockito.any(Specifications.class))).thenReturn(listaCnalrOrgaPoolAssignment);
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_OUT manageTaskMailbox_OUT = taskMailboxServiceMock
                .manageTaskMailbox(managetaskmailbox_in, cabecera, metadatos);
    }
    
    @Test (expected = TE_Excepcion.class)
    public void manageTaskMailboxExceptionValidarDatosInsert() throws TE_Excepcion {
        
        ManageTaskMailbox_IN managetaskmailbox_in = new ManageTaskMailbox_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailboxDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList multiLanguageList = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage multiLanguage [] = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage[1];
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TimePeriod timePeriod = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TimePeriod();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.FunctionalPool_DTO_IN functionalPoolDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.FunctionalPool_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.OrganizationPoolAssignment_DTO_IN organizationPoolAssignmentDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.OrganizationPoolAssignment_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.DistributionCriteria_DTO_IN distributionCriteriaDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.DistributionCriteria_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.Rule_DTO_IN ruleDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.Rule_DTO_IN();
        com.telefonica.cana.model.CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment = new com.telefonica.cana.model.CnalrOrgaPoolAssignment();
        
        List<com.telefonica.cana.model.CnalaTaskMailbox> listaCnalaTaskMailbox = new ArrayList<com.telefonica.cana.model.CnalaTaskMailbox>();
        
        List<com.telefonica.cana.model.CnalrOrgaPoolAssignment> listaCnalrOrgaPoolAssignment = new ArrayList<com.telefonica.cana.model.CnalrOrgaPoolAssignment>();
        listaCnalrOrgaPoolAssignment.add(cnalrOrgaPoolAssignment);
                
        ruleDTO.setId(BigDecimal.ONE);
        
        distributionCriteriaDTO.setId(1l);
        
        organizationPoolAssignmentDTO.setId(BigDecimal.ONE);
        
        functionalPoolDTO.setId(BigDecimal.ONE);
        
        timePeriod.setStartDateTime(new Date());
        timePeriod.setEndDateTime(new Date());
        
        multiLanguage[0] = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage();
        multiLanguage[0].setLanguageCode(2l);
        multiLanguage[0].setValue("2");
        multiLanguageList.setMultiLanguages(multiLanguage);
        
        taskMailboxDTO.setName(multiLanguageList);
        taskMailboxDTO.setCode("1");
        taskMailboxDTO.setValidFor(timePeriod);
        taskMailboxDTO.setFunctionalPool(functionalPoolDTO);
        taskMailboxDTO.setOrganizationPoolAssignment(organizationPoolAssignmentDTO);
        taskMailboxDTO.setDistributionCriteria(distributionCriteriaDTO);
        taskMailboxDTO.setRule(ruleDTO);
        
        managetaskmailbox_in.setOperationType(1l);
        managetaskmailbox_in.setTaskMailbox(taskMailboxDTO);
        
        when(taskMailboxRepository.findAll(Mockito.any(Specifications.class))).thenReturn(listaCnalaTaskMailbox);
        when(cnalrOrgaPoolAssignmentRepository.findAll(Mockito.any(Specifications.class))).thenReturn(listaCnalrOrgaPoolAssignment).thenReturn(listaCnalrOrgaPoolAssignment).thenReturn(listaCnalrOrgaPoolAssignment);
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_OUT manageTaskMailbox_OUT = taskMailboxServiceMock
                .manageTaskMailbox(managetaskmailbox_in, cabecera, metadatos);
    }
    
    @Test
    public void manageTaskMailboxUpdate() throws TE_Excepcion {
        ManageTaskMailbox_IN managetaskmailbox_in = new ManageTaskMailbox_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailboxDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList multiLanguageList = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage multiLanguage [] = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage[2];
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TimePeriod timePeriod = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TimePeriod();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.FunctionalPool_DTO_IN functionalPoolDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.FunctionalPool_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.OrganizationPoolAssignment_DTO_IN organizationPoolAssignmentDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.OrganizationPoolAssignment_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.DistributionCriteria_DTO_IN distributionCriteriaDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.DistributionCriteria_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.Rule_DTO_IN ruleDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.Rule_DTO_IN();
        com.telefonica.cana.model.CnalaTaskMailbox cnalaTaskMailbox = new com.telefonica.cana.model.CnalaTaskMailbox();
        com.telefonica.cana.model.CnalpFunctionalPool cnalpFunctionalPool = new com.telefonica.cana.model.CnalpFunctionalPool();
        
        List<com.telefonica.cana.model.CnalaTaskMailbox> listaCnalaTaskMailbox = new ArrayList<com.telefonica.cana.model.CnalaTaskMailbox>();
        
        List<com.telefonica.cana.model.CnalrOrgaPoolAssignment> listaCnalrOrgaPoolAssignment = new ArrayList<com.telefonica.cana.model.CnalrOrgaPoolAssignment>();
        
        ruleDTO.setId(BigDecimal.ONE);
        
        distributionCriteriaDTO.setId(1l);
        
        organizationPoolAssignmentDTO.setId(BigDecimal.ONE);
        
        functionalPoolDTO.setId(BigDecimal.ONE);
        
        timePeriod.setStartDateTime(new Date());
        timePeriod.setEndDateTime(new Date());
        
        multiLanguage[0] = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage();
        multiLanguage[0].setLanguageCode(1l);
        multiLanguage[0].setValue("1");
        multiLanguage[1] = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage();
        multiLanguage[1].setLanguageCode(2l);
        multiLanguage[1].setValue("2");
        multiLanguageList.setMultiLanguages(multiLanguage);
        
        taskMailboxDTO.setName(multiLanguageList);
        taskMailboxDTO.setCode("1");
        taskMailboxDTO.setValidFor(timePeriod);
        taskMailboxDTO.setFunctionalPool(functionalPoolDTO);
        taskMailboxDTO.setOrganizationPoolAssignment(organizationPoolAssignmentDTO);
        taskMailboxDTO.setDistributionCriteria(distributionCriteriaDTO);
        taskMailboxDTO.setRule(ruleDTO);
        taskMailboxDTO.setId(BigDecimal.ONE);
        
        managetaskmailbox_in.setOperationType(2l);
        managetaskmailbox_in.setTaskMailbox(taskMailboxDTO);
        
        CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment = new CnalrOrgaPoolAssignment();
        cnalrOrgaPoolAssignment.setOpasIdOrgaPoolAssignment(BigDecimal.ONE);
        CnalrOrgaPoolAssignment cnalrOrgaPoolAssignment2 = new CnalrOrgaPoolAssignment();
        cnalrOrgaPoolAssignment2.setOpasIdOrgaPoolAssignment(BigDecimal.ONE);
        
        
        cnalaTaskMailbox.setMboxIdMailbox(BigDecimal.ONE);
        when(taskMailboxRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(cnalaTaskMailbox);
        when(cnalpFunctionalPoolRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(cnalpFunctionalPool);
        
        CnalrTaskMailboxL cnalrTaskMailboxL = null;
        when(cnalrTaskMailboxRepository.findByIdTaskMailboxAndLanguage(Mockito.any(), Mockito.any())).thenReturn(cnalrTaskMailboxL);
        
        
        when(cnalrOrgaPoolAssignmentRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(cnalrOrgaPoolAssignment);
       
        when(taskMailboxRepository.findAll(Mockito.any(Specifications.class))).thenReturn(listaCnalaTaskMailbox);
        when(cnalrOrgaPoolAssignmentRepository.findAll(Mockito.any(Specifications.class))).thenReturn(listaCnalrOrgaPoolAssignment);
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_OUT manageTaskMailbox_OUT = taskMailboxServiceMock
                .manageTaskMailbox(managetaskmailbox_in, cabecera, metadatos);

        assertThat(manageTaskMailbox_OUT).isNotNull();
    }
    
    @Test (expected = TE_Excepcion.class)
    public void manageTaskMailboxTaskMailboxIDNull() throws TE_Excepcion {
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailBoxDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN();

        ManageTaskMailbox_IN managetaskmailbox_in = new ManageTaskMailbox_IN();
        managetaskmailbox_in.setOperationType(2l);
        managetaskmailbox_in.setTaskMailbox(taskMailBoxDTO);
        
        taskMailboxServiceMock.manageTaskMailbox(managetaskmailbox_in, cabecera, metadatos);
    }
    
    @Test (expected = TE_Excepcion.class)
    public void manageTaskMailboxCnalaTaskMailboxNull() throws TE_Excepcion {
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailBoxDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN();
        
        ManageTaskMailbox_IN managetaskmailbox_in = new ManageTaskMailbox_IN();
        managetaskmailbox_in.setOperationType(2l);
        taskMailBoxDTO.setId(BigDecimal.ONE);
        managetaskmailbox_in.setTaskMailbox(taskMailBoxDTO);
        
        when(taskMailboxRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(null);
        
        taskMailboxServiceMock.manageTaskMailbox(managetaskmailbox_in, cabecera, metadatos);
    }
    
    @Test (expected = TE_Excepcion.class)
    public void manageTaskMailboxExceptionValidarDatosUpdate() throws TE_Excepcion {
        ManageTaskMailbox_IN managetaskmailbox_in = new ManageTaskMailbox_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN taskMailboxDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TaskMailbox_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList multiLanguageList = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage multiLanguage [] = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage[1];
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TimePeriod timePeriod = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.TimePeriod();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.FunctionalPool_DTO_IN functionalPoolDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.FunctionalPool_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.OrganizationPoolAssignment_DTO_IN organizationPoolAssignmentDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.OrganizationPoolAssignment_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.DistributionCriteria_DTO_IN distributionCriteriaDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.DistributionCriteria_DTO_IN();
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.Rule_DTO_IN ruleDTO = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.Rule_DTO_IN();
        com.telefonica.cana.model.CnalaTaskMailbox cnalaTaskMailbox = new com.telefonica.cana.model.CnalaTaskMailbox();
        
        List<com.telefonica.cana.model.CnalaTaskMailbox> listaCnalaTaskMailbox = new ArrayList<com.telefonica.cana.model.CnalaTaskMailbox>();
        
        List<com.telefonica.cana.model.CnalrOrgaPoolAssignment> listaCnalrOrgaPoolAssignment = new ArrayList<com.telefonica.cana.model.CnalrOrgaPoolAssignment>();
        
        ruleDTO.setId(BigDecimal.ONE);
        
        distributionCriteriaDTO.setId(1l);
        
        organizationPoolAssignmentDTO.setId(BigDecimal.ONE);
        
        functionalPoolDTO.setId(BigDecimal.ONE);
        
        timePeriod.setStartDateTime(new Date());
        timePeriod.setEndDateTime(new Date());
        
        multiLanguage[0] = new com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.MultiLanguageList.MultiLanguage();
        multiLanguage[0].setLanguageCode(2l);
        multiLanguage[0].setValue("2");
        multiLanguageList.setMultiLanguages(multiLanguage);
        
        taskMailboxDTO.setName(multiLanguageList);
        taskMailboxDTO.setCode("1");
        taskMailboxDTO.setValidFor(timePeriod);
        taskMailboxDTO.setFunctionalPool(functionalPoolDTO);
        taskMailboxDTO.setOrganizationPoolAssignment(organizationPoolAssignmentDTO);
        taskMailboxDTO.setDistributionCriteria(distributionCriteriaDTO);
        taskMailboxDTO.setRule(ruleDTO);
        taskMailboxDTO.setId(BigDecimal.ONE);
        
        managetaskmailbox_in.setOperationType(2l);
        managetaskmailbox_in.setTaskMailbox(taskMailboxDTO);
        
        when(taskMailboxRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(cnalaTaskMailbox);
        when(cnalpFunctionalPoolRepository.findOne(Mockito.any(BigDecimal.class))).thenReturn(null);
        
        when(taskMailboxRepository.findAll(Mockito.any(Specifications.class))).thenReturn(listaCnalaTaskMailbox);
        when(cnalrOrgaPoolAssignmentRepository.findAll(Mockito.any(Specifications.class))).thenReturn(listaCnalrOrgaPoolAssignment);
        com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox.ManageTaskMailbox_OUT manageTaskMailbox_OUT = taskMailboxServiceMock
                .manageTaskMailbox(managetaskmailbox_in, cabecera, metadatos);
    }
    
    
    @Test
    public void reassignTasksMailbox() throws TE_Excepcion, com.telefonica.tran.api.workspace.exception.ServicioTareaException {
        
        try {
            
            org.mockito.Mockito.when(taskMailboxServiceMock.reassignTasksMailbox(Mockito.any(ReassignTasksMailbox_IN.class),
                    Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenCallRealMethod();
            
            com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN reassignTasksMailbox_IN =
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN();
            

            com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN();
            
            organizationRole_DTO_IN.setId(BigDecimal.ONE);
            
            com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN organizationRoleSpec_DTO_IN = 
                    new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN();
            
            organizationRoleSpec_DTO_IN.setId(106L);
            
            organizationRole_DTO_IN.setOrganizationRoleSpec(organizationRoleSpec_DTO_IN);
            reassignTasksMailbox_IN.setOrganizationRole(organizationRole_DTO_IN);
            
            
            //----- findTaskList
            
            com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_OUT findTaskList_OUT =
                    new com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_OUT();
            
            List <com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT> listUserTask_DTO_OUT =
                    new ArrayList <com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT>();
            com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT userTask_DTO_OUT =
                    new com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT();
            
            userTask_DTO_OUT.setCode("code");
            userTask_DTO_OUT.setDomain("domain");
            
            listUserTask_DTO_OUT.add(userTask_DTO_OUT);
            findTaskList_OUT.setUserTasks(listUserTask_DTO_OUT.toArray(
                    new com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT[listUserTask_DTO_OUT.size()]));
            
            when(taskMailboxServiceMock.llamadaFindTaskList(Mockito.any(TE_API_Worklist.class), Mockito.any(BigDecimal.class), Mockito.any(TE_Cabecera.class))).thenReturn(findTaskList_OUT);
            
            
            //----- getTaskDetail
            
            com.telefonica.tran.api.workspace.msg.gettaskdetail.GetTaskDetail_OUT getTaskDetail_OUT =
                    new com.telefonica.tran.api.workspace.msg.gettaskdetail.GetTaskDetail_OUT();
            
            
            com.telefonica.tran.api.workspace.msg.gettaskdetail.UserTask_DTO_OUT userTask_DTO_OUT2 =
                    new com.telefonica.tran.api.workspace.msg.gettaskdetail.UserTask_DTO_OUT();
            
            com.telefonica.tran.api.workspace.msg.gettaskdetail.TaskMailbox_DTO_OUT taskMailbox_DTO_OUT =
                    new com.telefonica.tran.api.workspace.msg.gettaskdetail.TaskMailbox_DTO_OUT();
            
            taskMailbox_DTO_OUT.setCode("codeOwner");
            
            userTask_DTO_OUT2.setTaskMailboxOwner(taskMailbox_DTO_OUT);
            
            getTaskDetail_OUT.setUserTask(userTask_DTO_OUT2);
            
            
            when(taskMailboxServiceMock.llamadaGetTaskDetail(
                    Mockito.any(TE_API_Worklist.class),
                    Mockito.any(com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT.class), 
                    Mockito.any(TE_Cabecera.class))).thenReturn(getTaskDetail_OUT);
            
            //----- reassignTask

            ReassignTask_OUT reassignTask_OUT = new ReassignTask_OUT();
            when(taskMailboxServiceMock.llamadaReassignTask(
                    Mockito.any(TE_API_Worklist.class),
                    Mockito.any(List.class),
                    Mockito.any(TE_Cabecera.class))).thenReturn(reassignTask_OUT);
            
            //----s
            Assert.assertNotNull(taskMailboxServiceMock.reassignTasksMailbox(reassignTasksMailbox_IN, cabecera, metadatos));
            
            
        } catch (TE_Excepcion e) {
            e.printStackTrace();
        }
    }
    @Test(expected =NullPointerException.class)
    public void llamadaGetTaskDetail1() throws TE_Excepcion {
        try {
            taskMailboxService.llamadaGetTaskDetail(null, new UserTask_DTO_OUT(), cabecera);
        } catch (TE_Excepcion e) {
            e.printStackTrace();
        }
    }
    @Test(expected =NullPointerException.class)
    public void llamadaFindTaskList1() throws TE_Excepcion, ServicioTareaException {
        try {
            taskMailboxService.llamadaFindTaskList(null, BigDecimal.ONE, cabecera);
        } catch (TE_Excepcion e) {
            e.printStackTrace();
        }
    }
    
    @Test (expected = TE_Excepcion.class)
    public void reassignTasksMailboxGetTaskDetailNull() throws TE_Excepcion, com.telefonica.tran.api.workspace.exception.ServicioTareaException {
        
            
        org.mockito.Mockito.when(taskMailboxServiceMock.reassignTasksMailbox(Mockito.any(ReassignTasksMailbox_IN.class),
                Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenCallRealMethod();
        
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN reassignTasksMailbox_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN();
        

        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN();
        
        organizationRole_DTO_IN.setId(BigDecimal.ONE);
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN organizationRoleSpec_DTO_IN = 
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN();
        
        organizationRoleSpec_DTO_IN.setId(106L);
        
        organizationRole_DTO_IN.setOrganizationRoleSpec(organizationRoleSpec_DTO_IN);
        reassignTasksMailbox_IN.setOrganizationRole(organizationRole_DTO_IN);
        
        
        //----- findTaskList
        
        com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_OUT findTaskList_OUT =
                new com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_OUT();
        
        List <com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT> listUserTask_DTO_OUT =
                new ArrayList <com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT>();
        com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT userTask_DTO_OUT =
                new com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT();
        
        userTask_DTO_OUT.setCode("code");
        userTask_DTO_OUT.setDomain("domain");
        
        listUserTask_DTO_OUT.add(userTask_DTO_OUT);
        findTaskList_OUT.setUserTasks(listUserTask_DTO_OUT.toArray(
                new com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT[listUserTask_DTO_OUT.size()]));
        
        when(taskMailboxServiceMock.llamadaFindTaskList(
        		Mockito.any(TE_API_Worklist.class),
                Mockito.any(BigDecimal.class),
                Mockito.any(TE_Cabecera.class))).thenReturn(findTaskList_OUT);
        
        
        //----- getTaskDetail
        
        com.telefonica.tran.api.workspace.msg.gettaskdetail.GetTaskDetail_OUT getTaskDetail_OUT = null;
        
        when(taskMailboxServiceMock.llamadaGetTaskDetail(
                Mockito.any(TE_API_Worklist.class),
                Mockito.any(com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT.class), 
                Mockito.any(TE_Cabecera.class))).thenReturn(getTaskDetail_OUT);
        
        
        taskMailboxServiceMock.reassignTasksMailbox(reassignTasksMailbox_IN, cabecera, metadatos);

    }
    
    @Test (expected = TE_Excepcion.class)
    public void reassignTasksMailboxFindTaskListError() throws TE_Excepcion,  com.telefonica.tran.api.workspace.exception.ServicioTareaException {
        
            
        org.mockito.Mockito.when(taskMailboxServiceMock.reassignTasksMailbox(Mockito.any(ReassignTasksMailbox_IN.class),
                Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenCallRealMethod();
        
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN reassignTasksMailbox_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN();
        

        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN();
        
        organizationRole_DTO_IN.setId(BigDecimal.ONE);
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN organizationRoleSpec_DTO_IN = 
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN();
        
        organizationRoleSpec_DTO_IN.setId(106L);
        
        organizationRole_DTO_IN.setOrganizationRoleSpec(organizationRoleSpec_DTO_IN);
        reassignTasksMailbox_IN.setOrganizationRole(organizationRole_DTO_IN);
        
        
        //----- findTaskList
        
        when(taskMailboxServiceMock.llamadaFindTaskList(
        		Mockito.any(TE_API_Worklist.class),
                Mockito.any(BigDecimal.class),
                Mockito.any(TE_Cabecera.class))).thenThrow(TE_Excepcion.class);
        
        taskMailboxServiceMock.reassignTasksMailbox(reassignTasksMailbox_IN, cabecera, metadatos);
            
    }
    
    
    @Test (expected = TE_Excepcion.class)
    public void reassignTasksMailboxGetTaskDetailError() throws TE_Excepcion, com.telefonica.tran.api.workspace.exception.ServicioTareaException {
        
        org.mockito.Mockito.when(taskMailboxServiceMock.reassignTasksMailbox(Mockito.any(ReassignTasksMailbox_IN.class),
                Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenCallRealMethod();
        
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN reassignTasksMailbox_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN();
        

        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN();
        
        organizationRole_DTO_IN.setId(BigDecimal.ONE);
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN organizationRoleSpec_DTO_IN = 
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN();
        
        organizationRoleSpec_DTO_IN.setId(106L);
        
        organizationRole_DTO_IN.setOrganizationRoleSpec(organizationRoleSpec_DTO_IN);
        reassignTasksMailbox_IN.setOrganizationRole(organizationRole_DTO_IN);
        
        
        //----- findTaskList
        
        com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_OUT findTaskList_OUT =
                new com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_OUT();
        
        List <com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT> listUserTask_DTO_OUT =
                new ArrayList <com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT>();
        com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT userTask_DTO_OUT =
                new com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT();
        
        userTask_DTO_OUT.setCode("code");
        userTask_DTO_OUT.setDomain("domain");
        
        listUserTask_DTO_OUT.add(userTask_DTO_OUT);
        findTaskList_OUT.setUserTasks(listUserTask_DTO_OUT.toArray(
                new com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT[listUserTask_DTO_OUT.size()]));
        
        when(taskMailboxServiceMock.llamadaFindTaskList(
        		Mockito.any(TE_API_Worklist.class),
                Mockito.any(BigDecimal.class),
                Mockito.any(TE_Cabecera.class))).thenReturn(findTaskList_OUT);
        
        
        //----- getTaskDetail
        
        
        when(taskMailboxServiceMock.llamadaGetTaskDetail(
                Mockito.any(TE_API_Worklist.class),
                Mockito.any(com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT.class), 
                Mockito.any(TE_Cabecera.class))).thenThrow(TE_Excepcion.class);
        
        
        taskMailboxServiceMock.reassignTasksMailbox(reassignTasksMailbox_IN, cabecera, metadatos);
            
    }
    
    
    @Test (expected = TE_Excepcion.class)
    public void reassignTasksMailboxReassignTaskError() throws TE_Excepcion, com.telefonica.tran.api.workspace.exception.ServicioTareaException {
        
        
        org.mockito.Mockito.when(taskMailboxServiceMock.reassignTasksMailbox(Mockito.any(ReassignTasksMailbox_IN.class),
                Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenCallRealMethod();
        
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN reassignTasksMailbox_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN();
        

        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN();
        
        organizationRole_DTO_IN.setId(BigDecimal.ONE);
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN organizationRoleSpec_DTO_IN = 
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN();
        
        organizationRoleSpec_DTO_IN.setId(106L);
        
        organizationRole_DTO_IN.setOrganizationRoleSpec(organizationRoleSpec_DTO_IN);
        reassignTasksMailbox_IN.setOrganizationRole(organizationRole_DTO_IN);
        
        
        //----- findTaskList
        
        com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_OUT findTaskList_OUT =
                new com.telefonica.tran.api.workspace.msg.findtasklist.FindTaskList_OUT();
        
        List <com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT> listUserTask_DTO_OUT =
                new ArrayList <com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT>();
        com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT userTask_DTO_OUT =
                new com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT();
        
        userTask_DTO_OUT.setCode("code");
        userTask_DTO_OUT.setDomain("domain");
        
        listUserTask_DTO_OUT.add(userTask_DTO_OUT);
        findTaskList_OUT.setUserTasks(listUserTask_DTO_OUT.toArray(
                new com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT[listUserTask_DTO_OUT.size()]));
        
        when(taskMailboxServiceMock.llamadaFindTaskList(Mockito.any(TE_API_Worklist.class), Mockito.any(BigDecimal.class), Mockito.any(TE_Cabecera.class))).thenReturn(findTaskList_OUT);
        
        
        //----- getTaskDetail
        
        com.telefonica.tran.api.workspace.msg.gettaskdetail.GetTaskDetail_OUT getTaskDetail_OUT =
                new com.telefonica.tran.api.workspace.msg.gettaskdetail.GetTaskDetail_OUT();
        
        
        com.telefonica.tran.api.workspace.msg.gettaskdetail.UserTask_DTO_OUT userTask_DTO_OUT2 =
                new com.telefonica.tran.api.workspace.msg.gettaskdetail.UserTask_DTO_OUT();
        
        com.telefonica.tran.api.workspace.msg.gettaskdetail.TaskMailbox_DTO_OUT taskMailbox_DTO_OUT =
                new com.telefonica.tran.api.workspace.msg.gettaskdetail.TaskMailbox_DTO_OUT();
        
        taskMailbox_DTO_OUT.setCode("codeOwner");
        
        userTask_DTO_OUT2.setTaskMailboxOwner(taskMailbox_DTO_OUT);
        
        getTaskDetail_OUT.setUserTask(userTask_DTO_OUT2);
        
        
        when(taskMailboxServiceMock.llamadaGetTaskDetail(
                Mockito.any(TE_API_Worklist.class),
                Mockito.any(com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT.class), 
                Mockito.any(TE_Cabecera.class))).thenReturn(getTaskDetail_OUT);
        
        
        //----- reassignTask
        
        com.telefonica.tran.api.workspace.msg.reassigntask.ReassignTask_OUT reassignTask_OUT =
                new com.telefonica.tran.api.workspace.msg.reassigntask.ReassignTask_OUT();
        
        
        when(taskMailboxServiceMock.llamadaReassignTask(
                Mockito.any(TE_API_Worklist.class),
                Mockito.any(List.class), Mockito.any(TE_Cabecera.class))).thenThrow(TE_Excepcion.class);
        
        
        //----
        
        taskMailboxServiceMock.reassignTasksMailbox(reassignTasksMailbox_IN, cabecera, metadatos);
            
    }
    
    @Test(expected = TE_Excepcion.class)
    public void reassignTasksMailboxErrorSpec() throws TE_Excepcion {
        
            
        org.mockito.Mockito.when(taskMailboxServiceMock.reassignTasksMailbox(Mockito.any(ReassignTasksMailbox_IN.class),
                Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenCallRealMethod();
        
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN reassignTasksMailbox_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN();
        

        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN();
        
        organizationRole_DTO_IN.setId(BigDecimal.ONE);
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN organizationRoleSpec_DTO_IN = 
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRoleSpec_DTO_IN();
        
        organizationRoleSpec_DTO_IN.setId(1L);
        
        organizationRole_DTO_IN.setOrganizationRoleSpec(organizationRoleSpec_DTO_IN);
        reassignTasksMailbox_IN.setOrganizationRole(organizationRole_DTO_IN);
        
        
        taskMailboxServiceMock.reassignTasksMailbox(reassignTasksMailbox_IN, cabecera, metadatos);
    }
    
    @Test(expected = TE_Excepcion.class)
    public void reassignTasksMailboxObligatoriosKO() throws TE_Excepcion {
        
            
        org.mockito.Mockito.when(taskMailboxServiceMock.reassignTasksMailbox(Mockito.any(ReassignTasksMailbox_IN.class),
                Mockito.any(TE_Cabecera.class), Mockito.any(TE_Metadatos.class))).thenCallRealMethod();
        
        
        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN reassignTasksMailbox_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.ReassignTasksMailbox_IN();
        

        com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                new com.telefonica.cana.srv.nuc.taskmailbox.msg.reassigntasksmailbox.OrganizationRole_DTO_IN();
        
        organizationRole_DTO_IN.setId(BigDecimal.ONE);
        
        
        reassignTasksMailbox_IN.setOrganizationRole(organizationRole_DTO_IN);
        
        
        taskMailboxServiceMock.reassignTasksMailbox(reassignTasksMailbox_IN, cabecera, metadatos);
    }
    
    
    @Test
    @Ignore
    public void llamadaFindTaskList() throws TE_Excepcion, com.telefonica.tran.api.workspace.exception.ServicioTareaException {
        try {

            org.mockito.Mockito.when(taskMailboxServiceMock.llamadaFindTaskList(
            		Mockito.any(TE_API_Worklist.class),
                    Mockito.any(BigDecimal.class),
                    Mockito.any(TE_Cabecera.class))).thenCallRealMethod();

            taskMailboxServiceMock.llamadaFindTaskList(worklist, BigDecimal.ONE, cabecera);
        } catch (TE_Excepcion e) {
            e.printStackTrace();
        }
    }
    
    @Test (expected = TE_Excepcion.class)
    @Ignore
    public void llamadaGetTaskDetail() throws TE_Excepcion, com.telefonica.tran.api.workspace.exception.ServicioTareaException {

        org.mockito.Mockito.when(taskMailboxServiceMock.llamadaGetTaskDetail(
                Mockito.any(TE_API_Worklist.class),
                Mockito.any(com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT.class),
                Mockito.any(TE_Cabecera.class))).thenCallRealMethod();

        com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT userTask_DTO_OUT =
                new com.telefonica.tran.api.workspace.msg.findtasklist.UserTask_DTO_OUT();

        userTask_DTO_OUT.setCode("code");
        
        taskMailboxServiceMock.llamadaGetTaskDetail(worklistAdmin, userTask_DTO_OUT, cabecera);
    }
    
    @Test (expected = NullPointerException.class)
    public void llamadaReassignTask() throws TE_Excepcion, com.telefonica.tran.api.workspace.exception.ServicioTareaException {
        try {
            org.mockito.Mockito.when(taskMailboxServiceMock.llamadaReassignTask(
                    Mockito.any(TE_API_Worklist.class),
                    Mockito.any(List.class),
                    Mockito.any(TE_Cabecera.class))).thenCallRealMethod();

            List <com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN> listUserTask_DTO_IN =
                    new ArrayList <com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN>();
            com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN userTask_DTO_IN =
                    new com.telefonica.tran.api.workspace.msg.reassigntask.UserTask_DTO_IN();

            userTask_DTO_IN.setCode("code");
            userTask_DTO_IN.setDomain("domain");
            com.telefonica.tran.api.workspace.msg.reassigntask.TaskMailbox_DTO_IN_1 taskMailbox_DTO_IN_1 =
                    new com.telefonica.tran.api.workspace.msg.reassigntask.TaskMailbox_DTO_IN_1();
            taskMailbox_DTO_IN_1.setCode("hadoooken");
            userTask_DTO_IN.setOwnerGroup(taskMailbox_DTO_IN_1);
            com.telefonica.tran.api.workspace.msg.reassigntask.OrganizationRole_DTO_IN organizationRole_DTO_IN =
                    new com.telefonica.tran.api.workspace.msg.reassigntask.OrganizationRole_DTO_IN();
            organizationRole_DTO_IN.setId(BigDecimal.ONE);
            userTask_DTO_IN.setOrganizationRole(organizationRole_DTO_IN);

            listUserTask_DTO_IN.add(userTask_DTO_IN);

            taskMailboxServiceMock.llamadaReassignTask(worklist, listUserTask_DTO_IN, cabecera);
        } catch (TE_Excepcion e) {
            e.printStackTrace();
        }
    }
    
    @Test(expected = WebServiceException.class)
    public void llamadaGetOrganizationRoleByFuncRole_objetoSalida()
            throws TE_Excepcion {

        Mockito.when(serviceRegistry.getEndpoint(Mockito.anyString())).thenReturn("endpoint");

        GetOrganizationRoleByFuncRole_IN getOrganizationRoleByFuncRole_IN = new GetOrganizationRoleByFuncRole_IN();

        Holder<TE_Cabecera> holderCabecera = new Holder<TE_Cabecera>(cabecera);
        Holder<TE_Metadatos> holderMetadatos = new Holder<TE_Metadatos>(metadatos);

        Mockito.when(taskMailboxServiceMock.llamadaGetOrganizationRoleByFuncRole_objetoSalida(Mockito.any(), Mockito.any(),
                Mockito.any())).thenCallRealMethod();

        GetOrganizationRoleByFuncRole_OUT getOrganizationRoleByFuncRole_OUT = taskMailboxServiceMock
                .llamadaGetOrganizationRoleByFuncRole_objetoSalida(getOrganizationRoleByFuncRole_IN, holderCabecera, holderMetadatos);
    }
    
}