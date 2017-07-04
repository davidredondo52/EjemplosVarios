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
import com.telefonica.cana.model.CnalpFuncPoolAssignment;
import com.telefonica.cana.model.CnalpFuncPoolAssignment_;
import com.telefonica.cana.model.CnalpFunctionalPool;
import com.telefonica.cana.model.CnalpFunctionalPool_;

public class FuncPoolAssignmentSpecifications {
    private static final String CLASSNAME = FuncPoolAssignmentSpecifications.class.getName();
    private static final Logger LOGGER = LoggerFactory.getLogger(FuncPoolAssignmentSpecifications.class);
    /*
     * Por cada buzón informado, tiene que venir informado su FunctionalPool
     */

    public static Specification<CnalpFuncPoolAssignment> byFunctionalPool(List<BigDecimal> idFunctionalPool,
            List<BigDecimal> idTaskMailbox) {
        return new Specification<CnalpFuncPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalpFuncPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Inicio del método byFunctionalPool", CLASSNAME);

                Join<CnalpFuncPoolAssignment, CnalpFunctionalPool> joinFunctionalPool = root
                        .join(CnalpFuncPoolAssignment_.cnalpFunctionalPool);

                LOGGER.debug("[{}] - Fin del método byFunctionalPool", CLASSNAME);
                return cb.equal(joinFunctionalPool.get(CnalpFunctionalPool_.wpooIdFunctionalPool), idFunctionalPool);
            }
        };
    }

    public static Specification<CnalpFuncPoolAssignment> byRangeDate(Date toDate, Date fromDate) {
        return new Specification<CnalpFuncPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalpFuncPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
                
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
                                   cb.greaterThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), calendarFromDate.getTime()),
                                   cb.and(
                                           cb.lessThan(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), calendarFromDate.getTime()),
                                           cb.greaterThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity), calendarFromDate.getTime())
                                           ),
                                   cb.and(
                                           cb.lessThan(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), calendarFromDate.getTime()),
                                           cb.isNull(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity))
                                           )
                                   )
                           ,
                           cb.or(
                                   cb.lessThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity), calendarToDate.getTime()),
                                   cb.and(
                                           cb.greaterThan(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity), calendarToDate.getTime()),
                                           cb.lessThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), calendarToDate.getTime())
                                           ),
                                   cb.and(
                                           cb.lessThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), calendarToDate.getTime()),
                                           cb.isNull(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity))
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
                            cb.greaterThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), calendarFromDate.getTime()),
                            cb.and(
                                    cb.lessThan(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), calendarFromDate.getTime()),
                                    cb.greaterThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity), calendarFromDate.getTime())
                                    ),
                            cb.and(
                                    cb.lessThan(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), calendarFromDate.getTime()),
                                    cb.isNull(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity))
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
                            cb.lessThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity), calendarToDate.getTime()),
                            cb.and(
                                    cb.greaterThan(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity), calendarToDate.getTime()),
                                    cb.lessThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), calendarToDate.getTime())
                                    ),
                            cb.and(
                                    cb.lessThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), calendarToDate.getTime()),
                                    cb.isNull(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity))
                                    )
                            );
                    
                  /*  p = cb.or(
                            cb.and(cb.lessThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity),
                                    calendarToDate.getTime()))    
                            ,
                            cb.and(cb.lessThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity),
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
                            cb.lessThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), calendarFechaActualDesde.getTime()),
                            cb.or(cb.isNull(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity)),
                                    cb.greaterThanOrEqualTo(
                                            root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity), calendarFechaActualFin.getTime())));
                }
                return p;
            }
        };
    }

    /*
     * Por cada buzón informado, tiene que venir informado su FunctionalPool y
     * su Organization Role
     */

    public static Specification<CnalpFuncPoolAssignment> byFunctionalPoolAndOrgaRole(List<BigDecimal> idTaskMailbox,
            List<BigDecimal> idFunctionalPool, List<BigDecimal> idOrgaRole) {
        return new Specification<CnalpFuncPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalpFuncPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Inicio del método byFunctionalPoolAndOrgaRole", CLASSNAME);
                query.distinct(Boolean.TRUE);

                Join<CnalpFuncPoolAssignment, CnalpFunctionalPool> joinFunctionalPool = root
                        .join(CnalpFuncPoolAssignment_.cnalpFunctionalPool);

                Join<CnalpFunctionalPool, CnalaTaskMailbox> joinCnalaTaskMailbox = joinFunctionalPool
                        .join(CnalpFunctionalPool_.cnalaTaskMailboxs);

                Predicate predicateWhere = cb.and(
                        cb.equal(joinFunctionalPool.get(CnalpFunctionalPool_.wpooIdFunctionalPool), idFunctionalPool),
                        cb.and(cb.equal(joinCnalaTaskMailbox.get(CnalaTaskMailbox_.mboxIdMailbox), idTaskMailbox)));
                LOGGER.debug("[{}] - Fin del método byFunctionalPoolAndOrgaRole", CLASSNAME);
                return predicateWhere;
            }
        };
    }

    /*
     * Busca los gestores vigentes para una unidad funcional dada
     * (idFunctionalPool)
     */
    public static Specification<CnalpFuncPoolAssignment> byFunctionalPoolVig(BigDecimal idFunctionalPool, Date fecha) {
        return new Specification<CnalpFuncPoolAssignment>() {
            @Override
            public Predicate toPredicate(Root<CnalpFuncPoolAssignment> root, CriteriaQuery<?> query,
                    CriteriaBuilder cb) {
                LOGGER.debug("[{}] - Inicio del método byFunctionalPoolVig", CLASSNAME);

                List<Predicate> predicateWhere = new ArrayList<Predicate>();

                Join<CnalpFuncPoolAssignment, CnalpFunctionalPool> joinFunctionalPool = root
                        .join(CnalpFuncPoolAssignment_.cnalpFunctionalPool);

                predicateWhere.add(
                        cb.equal(joinFunctionalPool.get(CnalpFunctionalPool_.wpooIdFunctionalPool), idFunctionalPool));
                predicateWhere.add(cb.and(
                        cb.lessThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiStartValidity), fecha),
                        cb.or(cb.greaterThanOrEqualTo(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity), fecha),
                                cb.isNull(root.get(CnalpFuncPoolAssignment_.fpasTiEndValidity)))));

                LOGGER.debug("[{}] - Fin del método byFunctionalPoolVig", CLASSNAME);
                return cb.and(predicateWhere.toArray(new Predicate[] {}));
            }
        };
    }
}
