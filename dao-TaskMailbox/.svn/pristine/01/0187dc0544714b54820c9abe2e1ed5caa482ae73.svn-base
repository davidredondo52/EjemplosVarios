package com.telefonica.cana.dao.taskmailbox.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import com.telefonica.cana.model.CnalaTaskMailbox;
import com.telefonica.cana.model.CnalaTaskMailbox_;
import com.telefonica.cana.model.CnalpFunctionalPool;
import com.telefonica.cana.model.CnalpFunctionalPool_;
import com.telefonica.cana.model.CnalrOrgaPoolAssignment;
import com.telefonica.cana.model.CnalrOrgaPoolAssignment_;
import com.telefonica.cana.model.CnalrTaskMailboxL;
import com.telefonica.cana.model.CnalrTaskMailboxL_;
import com.telefonica.cana.model.GewfdDistributionCriteria;
import com.telefonica.cana.model.GewfdDistributionCriteria_;

public class TaskMailboxSpecifications {

    private static final String CLASSNAME = TaskMailboxSpecifications.class.getName();
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskMailboxSpecifications.class);

    /*
     * Especificación para criterios de rango de fechas (la fecha debe ser mayor
     * o igual que fromDate y menor o igual que toDate)
     */

    public static Specification<CnalaTaskMailbox> byRangeDate(Date toDate, Date fromDate) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                
                Calendar calendarFromDate = Calendar.getInstance();
                query.distinct(Boolean.TRUE);
                if (fromDate != null) {
                    calendarFromDate.setTime(fromDate);
                    calendarFromDate.set(Calendar.HOUR_OF_DAY, 0);
                    calendarFromDate.set(Calendar.MINUTE, 0);
                    calendarFromDate.set(Calendar.SECOND, 0);
                    calendarFromDate.set(Calendar.MILLISECOND, 0);
                }
                
                Calendar calendarToDate = Calendar.getInstance();

                if (toDate != null){
                    calendarToDate.setTime(toDate);
                    calendarToDate.set(Calendar.HOUR_OF_DAY, 23);
                    calendarToDate.set(Calendar.MINUTE, 59);
                    calendarToDate.set(Calendar.SECOND, 59);
                    calendarToDate.set(Calendar.MILLISECOND, 999);
                }

                Predicate p;
                
                if (fromDate != null && toDate != null) {
                    /*
                     C.- Si se rellenan ambos campos (Desde y Hasta) 
                        Devolver las entidades que cumplan A y B (hay que calcular ambos criterios 
                        y devolver las entidades intersección de ambos)

                     */
                   p = cb.and(
                           cb.or(
                                   cb.greaterThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiStartValidity), calendarFromDate.getTime()),
                                   cb.and(
                                           cb.lessThan(root.get(CnalaTaskMailbox_.mboxTiStartValidity), calendarFromDate.getTime()),
                                           cb.greaterThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiEndValidity), calendarFromDate.getTime())
                                           ),
                                   cb.and(
                                           cb.lessThan(root.get(CnalaTaskMailbox_.mboxTiStartValidity), calendarFromDate.getTime()),
                                           cb.isNull(root.get(CnalaTaskMailbox_.mboxTiEndValidity))
                                           )
                                   )
                           ,
                           cb.or(
                                   cb.lessThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiEndValidity), calendarToDate.getTime()),
                                   cb.and(
                                           cb.greaterThan(root.get(CnalaTaskMailbox_.mboxTiEndValidity), calendarToDate.getTime()),
                                           cb.lessThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiStartValidity), calendarToDate.getTime())
                                           ),
                                   cb.and(
                                           cb.lessThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiStartValidity), calendarToDate.getTime()),
                                           cb.isNull(root.get(CnalaTaskMailbox_.mboxTiEndValidity))
                                           )
                                   )
                           );
                           
                } else if (fromDate != null) {
                    /*
                    A.- Si se rellena solo el campo Desde
                    Devolver las entidades que cumplan alguna de estas tres condiciones chequeadas 
                    en este orden:
                    > fecha de Inicio de vigencia MAYOR O IGUAL que el valor introducido en Desde
                    > fecha de Fin de vigencia MAYOR O IGUAL que el valor introducido en Desde
                    > fecha de Fin de vigencia NULL
                    
                                         
                     */
                    p = cb.or(
                            cb.greaterThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiStartValidity), calendarFromDate.getTime()),
                            cb.and(
                                    cb.lessThan(root.get(CnalaTaskMailbox_.mboxTiStartValidity), calendarFromDate.getTime()),
                                    cb.greaterThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiEndValidity), calendarFromDate.getTime())
                                    ),
                            cb.and(
                                    cb.lessThan(root.get(CnalaTaskMailbox_.mboxTiStartValidity), calendarFromDate.getTime()),
                                    cb.isNull(root.get(CnalaTaskMailbox_.mboxTiEndValidity))
                                    )
                            );

                
                } else if (toDate != null) {
                    /*
                     B.- Si se rellena solo el campo Hasta
                    Devolver las entidades que cumplan alguna de estas dos condiciones chequeadas 
                    en este orden:
                    > fecha de Fin de vigencia MENOR O IGUAL que el valor introducido en Hasta
                    > fecha de Inicio de vigencia MENOR O IGUAL que el valor introducido en Hasta

                     */
                  
                    p = cb.or(
                            cb.lessThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiEndValidity), calendarToDate.getTime()),
                            cb.and(
                                    cb.greaterThan(root.get(CnalaTaskMailbox_.mboxTiEndValidity), calendarToDate.getTime()),
                                    cb.lessThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiStartValidity), calendarToDate.getTime())
                                    ),
                            cb.and(
                                    cb.lessThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiStartValidity), calendarToDate.getTime()),
                                    cb.isNull(root.get(CnalaTaskMailbox_.mboxTiEndValidity))
                                    )
                            );
                    
                  /*  p = cb.or(
                            cb.and(cb.lessThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiEndValidity),
                                    calendarToDate.getTime()))    
                            ,
                            cb.and(cb.lessThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiStartValidity),
                                    calendarToDate.getTime()))
                            );
                */
                } else { // solo vigentes
                    /*
                    D.- Si se dejan en blanco ambos campos (Desde y Hasta) 
                    Devolver las entidades que estén vigentes en el momento de la búsqueda.
                     */
                    Calendar calendarFechaActualDesde = Calendar.getInstance();
                    calendarFechaActualDesde.setTime(new java.util.Date());
                    calendarFechaActualDesde.set(Calendar.HOUR_OF_DAY, 23);
                    calendarFechaActualDesde.set(Calendar.MINUTE, 59);
                    calendarFechaActualDesde.set(Calendar.SECOND, 59);
                    calendarFechaActualDesde.set(Calendar.MILLISECOND, 999);
                    
                    Calendar calendarFechaActualFin = Calendar.getInstance();
                    calendarFechaActualFin.setTime(new java.util.Date());
                    calendarFechaActualFin.set(Calendar.HOUR_OF_DAY, 0);
                    calendarFechaActualFin.set(Calendar.MINUTE, 0);
                    calendarFechaActualFin.set(Calendar.SECOND, 0);
                    calendarFechaActualFin.set(Calendar.MILLISECOND, 0);
                    
                    p = cb.and(
                            cb.lessThanOrEqualTo(root.get(CnalaTaskMailbox_.mboxTiStartValidity), calendarFechaActualDesde.getTime()),
                            cb.or(cb.isNull(root.get(CnalaTaskMailbox_.mboxTiEndValidity)),
                                    cb.greaterThanOrEqualTo(
                                            root.get(CnalaTaskMailbox_.mboxTiEndValidity), calendarFechaActualFin.getTime())));
                }
                return p;
            }
        };
    }
    /*
     * Especificación con los parámetros de búsqueda del id y code
     */

    public static Specification<CnalaTaskMailbox> byId(BigDecimal id, String code) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Inicio del método byId", CLASSNAME);
                List<Predicate> predicateWhere = new ArrayList<Predicate>();
                predicateWhere.add(cb.equal(root.get(CnalaTaskMailbox_.mboxIdMailbox), id));
                if (!org.apache.commons.lang.StringUtils.isBlank(code)) {
                    predicateWhere.add(cb.equal(root.get(CnalaTaskMailbox_.mboxCoFuncMailbox), code));
                }
                LOGGER.debug("[{}] - Fin del método byId", CLASSNAME);
                return cb.and(predicateWhere.toArray(new Predicate[] {}));
            }
        };
    }
    /*
     * Especificación para el parámetro del id de functionalPool. Necesario
     * hacer un join Fetch de la entidad TaskMailbox con la entidad
     * FunctionalPool
     */

    public static Specification<CnalaTaskMailbox> byIdFunctionalPool(BigDecimal id) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Inicio del método byIdFunctionalPool", CLASSNAME);
                Join<CnalaTaskMailbox, CnalpFunctionalPool> joinFunctionalPool = root
                        .join(CnalaTaskMailbox_.cnalpFunctionalPool);
                LOGGER.debug("[{}] - Fin del método byIdFunctionalPool", CLASSNAME);
                return cb.equal(joinFunctionalPool.get(CnalpFunctionalPool_.wpooIdFunctionalPool), id);
            }
        };
    }
    
    /*
     * Especificación para el parámetro de lista de ids de functionalPool. Necesario
     * hacer un join Fetch de la entidad TaskMailbox con la entidad
     * FunctionalPool
     */

    public static Specification<CnalaTaskMailbox> byListIdFunctionalPools(List <BigDecimal> lstIds) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Inicio del método byIdFunctionalPool", CLASSNAME);
                Join<CnalaTaskMailbox, CnalpFunctionalPool> joinFunctionalPool = root
                        .join(CnalaTaskMailbox_.cnalpFunctionalPool);
                LOGGER.debug("[{}] - Fin del método byIdFunctionalPool", CLASSNAME);
                return cb.and(joinFunctionalPool.get(CnalpFunctionalPool_.wpooIdFunctionalPool).in(lstIds));
         
            }
        };
    }
    /*
     * Especificación para el parámetro del id de organizationRole. Necesario
     * hacer un Join Fetch de la entidad TaskMailbox con la entidad
     * OrganizationPoolAssignment y Join de la entidad
     * OrganizationPoolAssignment con la entidad FunctionalPool
     */

    public static Specification<CnalaTaskMailbox> byIdOrganizationRole(BigDecimal id) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Inicio del método byIdOrganizationRole", CLASSNAME);
                Join<CnalaTaskMailbox, CnalrOrgaPoolAssignment> joinOrgaPoolAssignment = root
                        .join(CnalaTaskMailbox_.cnalrOrgaPoolAssignment2);
                LOGGER.debug("[{}] - Fin del método byIdOrganizationRole", CLASSNAME);
                return cb.equal(joinOrgaPoolAssignment.get(CnalrOrgaPoolAssignment_.paroIdOrganizationRole), id);
            }
        };
    }
    /*
     * Especificación para el parámetro del id de distributionCriteria.
     * Necesario hacer un Join fetch con la entidad DistributionCriteria.
     */

    public static Specification<CnalaTaskMailbox> byIdDistributionCriteria(Integer id) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Inicio del método byIdDistributionCriteria", CLASSNAME);
                Join<CnalaTaskMailbox, GewfdDistributionCriteria> joinDistributionCriteria = root
                        .join(CnalaTaskMailbox_.gewfdDistributionCriteria);
                LOGGER.debug("[{}] - Fin del método byIdDistributionCriteria", CLASSNAME);
                return cb.equal(joinDistributionCriteria.get(GewfdDistributionCriteria_.discIdDistributionCriteria),
                        id);
            }
        };
    }
    /*
     * Especificación para el parámetro del id de rule
     */

    public static Specification<CnalaTaskMailbox> byIdRule(BigDecimal id) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Método byIdRule", CLASSNAME);
                return cb.equal(root.get(CnalaTaskMailbox_.ruleIdRule), id);
            }
        };
    }
    /*
     * Especificación para el parámetro name de TaskMailBox (campo no sensible
     * mayúsculas y tildes)
     */

    public static Specification<CnalaTaskMailbox> byNameLike(String name) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Método byNameLike", CLASSNAME);
                return cb.like(cb.upper(root.get(CnalaTaskMailbox_.lboxNaMailbox)), "%" + name.toUpperCase() + "%");
            }
        };
    }
    /*
     * Especificación para el parámetro code del buzón
     */

    public static Specification<CnalaTaskMailbox> byCode(String code) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Método byCode", CLASSNAME);
                return cb.equal(root.get(CnalaTaskMailbox_.mboxCoFuncMailbox), code);
            }
        };
    }
    /*
     * Especificación para el parámetro id de la función empresarial. Necesario
     * hacer un Join con la entidad EnterpriseFunctionTreeNode y Join con la
     * entidad EnterpriseFunction.
     */

    public static Specification<CnalaTaskMailbox> byIdEnterpriseFunction(Integer id) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // REVISAR:Requiere regeneración del modelo
                return null;
            }
        };
    }
    /*
     * Especificación para indicar si la consulta es multilenguaje o no. Se
     * realiza Join fetch con la tabla de multidioma para obtener todos los
     * idiomas.
     */

    public static Specification<CnalaTaskMailbox> byShowAllLanguages(Boolean showAllLanguages) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        };
    }

    public static Specification<CnalaTaskMailbox> byNameLikeMultilanguage(String name, BigDecimal coLanguage) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Join<CnalaTaskMailbox, CnalrTaskMailboxL> joinMultiLenguaje = root
                        .join(CnalaTaskMailbox_.cnalrTaskMailboxLs);
                LOGGER.debug("[{}] - Inicio del método byNameLikeMultilanguage", CLASSNAME);
                List<Predicate> predicateWhere = new ArrayList<Predicate>();

                predicateWhere.add(cb.equal(joinMultiLenguaje.get(CnalrTaskMailboxL_.langCoLanguage), coLanguage));

                predicateWhere.add(cb.like(cb.upper(joinMultiLenguaje.get(CnalrTaskMailboxL_.lboxNaMailbox)),
                        "%" + name.toUpperCase() + "%"));

                LOGGER.debug("[{}] - Fin del método byNameLikeMultilanguage", CLASSNAME);
                return cb.and(predicateWhere.toArray(new Predicate[] {}));
            }
        };
    }

    public static Specification<CnalaTaskMailbox> byTaskMailboxAndOrgRole(List<BigDecimal> paroIdOrganizationRoleList) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Inicio del método byTaskMailboxAndOrgRole", CLASSNAME);

                Join<CnalaTaskMailbox, CnalrOrgaPoolAssignment> joinOrgaPoolAssignment = root
                        .join(CnalaTaskMailbox_.cnalrOrgaPoolAssignment2);

                LOGGER.debug("[{}] - Fin del método byNameLikeMultilanguage", CLASSNAME);

                return cb.and(joinOrgaPoolAssignment.get(CnalrOrgaPoolAssignment_.paroIdOrganizationRole)
                        .in(paroIdOrganizationRoleList));
            }
        };
    }

    /*
     * Se utilizará para filtrar los resultados comparanco con el campo GENA_ID_APPLICATION de la entidad cnalaTaskMailbox
     */

    public static Specification<CnalaTaskMailbox> byApplication(Long idApplication) {
        return new Specification<CnalaTaskMailbox>() {
            @Override
            public Predicate toPredicate(Root<CnalaTaskMailbox> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	LOGGER.debug("[{}] - Método byApplication", CLASSNAME);
                return cb.equal(root.get(CnalaTaskMailbox_.genaIdApplication), idApplication);
            }
        };
    }
}
