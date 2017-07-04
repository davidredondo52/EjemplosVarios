package com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Functional roles played by the organization roles within the organization to which it belongs. Implies performing an activity. These Roles are grouped by FuncionalRoleType class, which indicates the business function (customer, employee, labor ...) manager. For the type of functional role of customers, the possibilities are: Agent: organization role withe functional role Agent that performs the tasks of service and sales. (registration of activity is assigned to Agents) Manager: roles with ability to manage organization roles (self management) that depend on it in the functional structure. Follow-up activity: role who can perform monitoring of the activity Authorizer: role having ability to authorize transactions by other engaged roles (discounts, problem solving, self-management, ....) Commission manager: role displaying commission tracking of a group defined by rules For the type of functional role Workforce, the options are: Signatory: role maintains a contractual relationship with Telefonica and is legally responsible Commission Ext: role for which calculation of remuneration (. Incentives, sales commissions, etc.) is generated and payment of settlements is made to a bank account Commission Int: role for which calculation of remuneration (. Incentives, sales commissions, etc.) is generated and the payment is made by payroll Technical: role that performs tasks of workforce. Dispatcher: role that performs the allocation of tasks to the technical. Functional Role: information that characterizes the role is in addition to general information about the functional role and is organized into blocks of information. Validations in the hierarchy: that roles can be father of another organization role. There are mandatory validations (no hierarchy allowed) and informational (alert but allows the hierarchy) Authorizations: Consent that a role has to play in the process. The permit grants the ability to subject, depending on the role, to perform other actions. All types of assigned role must be consistent with the type of organizational role. #ESPAÑOL# GESTOR x TIPO ROL Roles que desempeña el gestor dentro de la organización a la que pertenece. Lleva implicito la realización de una actividad. Estos Roles están agrupados por la clase FuncionalRoleType, la cual indica la función empresarial en la que se encuadra el rol del gestor (cliente, empleado, fuerza de trabajo...). Para el tipo de Rol funcional de Clientes, las posibilidades son: Agente: gestor que realiza las tareas de atención y venta. (A estos gestores son a los que queda imputada la actividad en los tramitadores) Administrador: gestor con capacidad para administrar a los gestores (autogestión) que dependen de él en la estructura funcional Seguimiento actividad: gestor que puede llevar a cabo el seguimiento de la actividad realizada Autorizador: gestor que tiene capacidad de autorizar operaciones realizadas por otros gestores (descuentos, resolución de problemas, autogestión, ….) Responsable comisiones: gestor que visualiza el seguimiento de comisiones de un grupo definido por reglas Para el tipo de Rol funcional Fuerza de Trabajo, las opciones son: Firmante: gestor que mantiene la relación contractual con Telefónica y es responsable jurídico Comisionista Ext: gestor para el que se genera cálculo de retribuciones (incentivos , comisiones, etc.) y se realiza el pago de liquidaciones a una cuenta bancaria Comisionista Int: gestor para el que se genera cálculo de retribuciones (incentivos , comisiones, etc.) y se realiza el pago de mediante nómina Técnico: gestor que realiza las tareas de FdT Despachador: gestor que realiza el reparto de tareas de los técnicos Atributos propios del Rol funcional: Información propia que caracteriza al rol, es adicional a los datos generales del Rol funcional y se organiza en bloques de información Autorizaciones: Consentimiento que tiene un rol para actuar en un proceso. El permiso otorga al sujeto capacidad para, en función del rol, realizar una acciones u otras. Todos los tipos de rol asignados deben de ser coherentes con el tipo de rol organizativo del gestor.
 * 
 * <p>Clase Java para FunctionalRole_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FunctionalRole_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FunctionalRole_DTO_OUT", propOrder = { "id" })
public class FunctionalRole_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true)
    @NotNull
    protected BigDecimal id;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setId(BigDecimal value) {
        this.id = value;
    }

}
