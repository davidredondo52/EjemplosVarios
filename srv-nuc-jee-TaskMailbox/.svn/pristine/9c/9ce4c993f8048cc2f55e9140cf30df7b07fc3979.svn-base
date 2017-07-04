package com.telefonica.cana.srv.nuc.taskmailbox.service.ext;

import java.util.HashMap;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class CriteriosOrdenacion {

    private HashMap<String, HashMap<String, Sort.Order>> listaOrdenacionPorFuncionalidad = new HashMap<String, HashMap<String, Sort.Order>>();

    public CriteriosOrdenacion() {

        HashMap<String, Sort.Order> listaOrdenacionfindFullTaskMailbox = new HashMap<String, Sort.Order>();
        listaOrdenacionfindFullTaskMailbox.put("AD_findFullTaskMailbox_configuracion1_DSC",
                new Sort.Order(Direction.ASC, "mboxIdMailbox").ignoreCase());
        listaOrdenacionfindFullTaskMailbox.put("AD_findFullTaskMailbox_configuracion2_DSC",
                new Sort.Order(Direction.DESC, "mboxIdMailbox").ignoreCase());
        listaOrdenacionfindFullTaskMailbox.put("AD_findFullTaskMailbox_configuracion3_DSC",
                new Sort.Order(Direction.ASC, "lboxNaMailbox").ignoreCase());
        listaOrdenacionfindFullTaskMailbox.put("AD_findFullTaskMailbox_configuracion4_DSC",
                new Sort.Order(Direction.DESC, "lboxNaMailbox").ignoreCase());
        listaOrdenacionfindFullTaskMailbox.put("AD_findFullTaskMailbox_configuracion5_DSC",
                new Sort.Order(Direction.ASC, "mboxTiStartValidity").ignoreCase());
        listaOrdenacionfindFullTaskMailbox.put("AD_findFullTaskMailbox_configuracion6_DSC",
                new Sort.Order(Direction.DESC, "mboxTiStartValidity").ignoreCase());
        listaOrdenacionfindFullTaskMailbox.put("AD_findFullTaskMailbox_configuracion7_DSC",
                new Sort.Order(Direction.ASC, "mboxTiEndValidity").ignoreCase());
        listaOrdenacionfindFullTaskMailbox.put("AD_findFullTaskMailbox_configuracion8_DSC",
                new Sort.Order(Direction.DESC, "mboxTiEndValidity").ignoreCase());
        listaOrdenacionfindFullTaskMailbox.put("AD_findFullTaskMailbox_configuracion9_DSC",
                new Sort.Order(Direction.ASC, "cnalpFunctionalPool.fupoNaFunctionalPool").ignoreCase());
        listaOrdenacionfindFullTaskMailbox.put("AD_findFullTaskMailbox_configuracion10_DSC",
                new Sort.Order(Direction.DESC, "cnalpFunctionalPool.fupoNaFunctionalPool").ignoreCase());
        // REVISAR: Pendiente criterio de ordenación. Se requiere regeneración
        // del modelo
        listaOrdenacionPorFuncionalidad.put("findFullTaskMailbox", listaOrdenacionfindFullTaskMailbox);

        HashMap<String, Sort.Order> listaOrdenacionfindTasksMailBoxesManager = new HashMap<String, Sort.Order>();
        listaOrdenacionfindTasksMailBoxesManager.put("AD_findTasksMailBoxesManager_configuracion1_ASC",
                new Sort.Order(Direction.ASC, "lboxNaMailbox").ignoreCase());
        listaOrdenacionfindTasksMailBoxesManager.put("AD_findTasksMailBoxesManager_configuracion2_DSC",
                new Sort.Order(Direction.DESC, "lboxNaMailbox").ignoreCase());
        listaOrdenacionPorFuncionalidad.put("findTasksMailBoxesManager", listaOrdenacionfindTasksMailBoxesManager);

        // AD_findTaskMailboxOperators
        HashMap<String, Sort.Order> listaOrdenacionfindTaskMailboxOperators = new HashMap<String, Sort.Order>();
        listaOrdenacionfindTaskMailboxOperators.put("AD_findTaskMailboxOperators_configuracion1_DSC",
                new Sort.Order(Direction.ASC, "formattedName").ignoreCase());
        listaOrdenacionfindTaskMailboxOperators.put("AD_findTaskMailboxOperators_configuracion2_DSC",
                new Sort.Order(Direction.DESC, "formattedName").ignoreCase());
        listaOrdenacionfindTaskMailboxOperators.put("AD_findTaskMailboxOperators_configuracion3_DSC",
                new Sort.Order(Direction.ASC, "gewfrMailboxAccesses.maacInMailboxResponsible").ignoreCase());
        listaOrdenacionfindTaskMailboxOperators.put("AD_findTaskMailboxOperators_configuracion4_DSC",
                new Sort.Order(Direction.DESC, "gewfrMailboxAccesses.maacInMailboxResponsible").ignoreCase());
        listaOrdenacionfindTaskMailboxOperators.put("AD_findTaskMailboxOperators_configuracion5_DSC",
                new Sort.Order(Direction.ASC, "paroIdOrganizationRole").ignoreCase());
        listaOrdenacionfindTaskMailboxOperators.put("AD_findTaskMailboxOperators_configuracion6_DSC",
                new Sort.Order(Direction.DESC, "paroIdOrganizationRole").ignoreCase());
        listaOrdenacionfindTaskMailboxOperators.put("AD_findTaskMailboxOperators_configuracion7_DSC",
                new Sort.Order(Direction.ASC, "mboxIdMailbox").ignoreCase());
        listaOrdenacionfindTaskMailboxOperators.put("AD_findTaskMailboxOperators_configuracion8_DSC",
                new Sort.Order(Direction.DESC, "mboxIdMailbox").ignoreCase());

        listaOrdenacionPorFuncionalidad.put("findTaskMailboxOperators", listaOrdenacionfindTaskMailboxOperators);

        
        //findTaskMailbox
        HashMap<String, Sort.Order> listaOrdenacionfindTaskMailbox = new HashMap<String, Sort.Order>();
        listaOrdenacionfindTaskMailbox.put("AD_findTaskMailbox_configuracion1_DSC",
                new Sort.Order(Direction.ASC, "mboxIdMailbox").ignoreCase());
        listaOrdenacionfindTaskMailbox.put("AD_findTaskMailbox_configuracion2_DSC",
                new Sort.Order(Direction.DESC, "mboxIdMailbox").ignoreCase());
        listaOrdenacionfindTaskMailbox.put("AD_findTaskMailbox_configuracion3_DSC",
                new Sort.Order(Direction.ASC, "mboxCoFuncMailbox").ignoreCase());
        listaOrdenacionfindTaskMailbox.put("AD_findTaskMailbox_configuracion4_DSC",
                new Sort.Order(Direction.DESC, "mboxCoFuncMailbox").ignoreCase());
        listaOrdenacionfindTaskMailbox.put("AD_findTaskMailbox_configuracion5_DSC",
                new Sort.Order(Direction.ASC, "lboxNaMailbox").ignoreCase());
        listaOrdenacionfindTaskMailbox.put("AD_findTaskMailbox_configuracion6_DSC",
                new Sort.Order(Direction.DESC, "lboxNaMailbox").ignoreCase());        
        listaOrdenacionfindTaskMailbox.put("AD_findTaskMailbox_configuracion7_DSC",
                new Sort.Order(Direction.ASC, "mboxTiStartValidity").ignoreCase());
        listaOrdenacionfindTaskMailbox.put("AD_findTaskMailbox_configuracion8_DSC",
                new Sort.Order(Direction.DESC, "mboxTiStartValidity").ignoreCase());
        listaOrdenacionfindTaskMailbox.put("AD_findTaskMailbox_configuracion9_DSC",
                new Sort.Order(Direction.ASC, "mboxTiEndValidity").ignoreCase());
        listaOrdenacionfindTaskMailbox.put("AD_findTaskMailbox_configuracion10_DSC",
                new Sort.Order(Direction.DESC, "mboxTiEndValidity").ignoreCase());
        //REVISAR: Pendiente criterio de ordenación. Se requiere regeneración del modelo 
        listaOrdenacionPorFuncionalidad.put("findTaskMailbox", listaOrdenacionfindTaskMailbox);
        
     // datos ordenacion operacion findFullFunctionalPoolAssigment
        HashMap<String, Sort.Order> listaOrdenacionfindFullFunctionalPoolAssigment = new HashMap<String, Sort.Order>();
        listaOrdenacionfindFullFunctionalPoolAssigment.put("AD_findFullFunctionalPoolAssignment_configuracion1_DSC",  
                new Sort.Order(Direction.ASC, "cnalpFunctionalPool.wpooIdFunctionalPool").ignoreCase());
        listaOrdenacionfindFullFunctionalPoolAssigment.put("AD_findFullFunctionalPoolAssignment_configuracion2_DSC", 
                new Sort.Order(Direction.DESC, "cnalpFunctionalPool.wpooIdFunctionalPool").ignoreCase());
        listaOrdenacionfindFullFunctionalPoolAssigment.put("AD_findFullFunctionalPoolAssignment_configuracion3_DSC", 
                new Sort.Order(Direction.ASC, "cnalpFunctionalPool.fupoNaFunctionalPool").ignoreCase());
        listaOrdenacionfindFullFunctionalPoolAssigment.put("AD_findFullFunctionalPoolAssignment_configuracion4_DSC", 
                new Sort.Order(Direction.DESC, "cnalpFunctionalPool.fupoNaFunctionalPool").ignoreCase());
        listaOrdenacionfindFullFunctionalPoolAssigment.put("AD_findFullFunctionalPoolAssignment_configuracion5_DSC",
                new Sort.Order(Direction.ASC, "cnalpFunctionalPool.lfpoDsFunctionalPool").ignoreCase());
        listaOrdenacionfindFullFunctionalPoolAssigment.put("AD_findFullFunctionalPoolAssignment_configuracion6_DSC",
                new Sort.Order(Direction.DESC, "cnalpFunctionalPool.lfpoDsFunctionalPool").ignoreCase());
            
        listaOrdenacionPorFuncionalidad.put("findFullFunctionalPoolAssignment", listaOrdenacionfindFullFunctionalPoolAssigment);
    }

    /**
     * @author MRAVNOBE Retorna todos los criterios de ordenación asociados a
     *         una funcionalidad
     * @return String[]
     */
    public String[] getCriteriosOrdenacions(String nombreMetodo) {
        return listaOrdenacionPorFuncionalidad.get(nombreMetodo).keySet()
                .toArray(new String[listaOrdenacionPorFuncionalidad.get(nombreMetodo).size()]);
    }

    /**
     * @author MRAVNOBE Retorna el orden asociado a un criterio de ordenación
     * @param criterioOrdenacion
     * @return
     */
    public Sort.Order getOrdenacion(String criterioOrdenacion, String nombreMetodo) {
        return listaOrdenacionPorFuncionalidad.get(nombreMetodo).get(criterioOrdenacion);
    }
}
