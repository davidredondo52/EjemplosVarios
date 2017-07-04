package com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Role of an organization within an organization. Lets see how companies are structured (subsidiaries, departments, divisions, managers ...), the relation of employees with the companies (Example: employee of ATENTO) and the relationship between employees (key, manager, director) .
 * All roles must have at least a parent (unless it´s a header). This organization role in turn may have 0 or more functional roles in terms of the tasks they perform.
 * Examples of organizational roles: company, shop, department, Direction, management, employee, Call Center
 * In addition to the required information that all organizational roles have, for some, it will also fill out additional information (Stores and Call Center).
 * The same individual / organization may have two or more organizational roles. Example: Juan Telefonica employee. Juan director of development direction.
 * Managers who are companies also exist in SupplierPartner and / contracts with these companies belong to the domain of Supplier / Partner.
 *  
 * #ESPAÑOL#  GESTOR (Nodo de la estructura de Gestores)
 * Rol organizativo es el papel que juega un gestor dentro de una organización. Permite ver como se estructuran las empresas (filiales, departamentos, direcciones, gerencias... ), la relación de las mismas con sus empleados (Ejemplo: empleado de ATENTO) y la relación que hay entre sus empleados (jefe, gerente, director).
 * Todo gestor tiene que tener como mínimo un Rol organizativo y un padre (salvo que sea cabecera). Este gestor a su vez podra tener 0, 1 o varios roles funcionales en función de las tareas que realice.
 * Ejemplos de roles organizativos:
 * - Empresa
 * - Tienda
 * - Departamento
 * - Dirección
 * - Gerencia
 * - Empleado
 * - Call Center
 * Además de la información común a todos los roles organizativos, para algunos, habrá que rellenar además una información adicional (por ejemplo, para Tiendas y Call Center).
 * Un mismo individuo/organización puede tener dos o más roles organizativos. Ejemplo: Juan empleado de Telefonica. Juan director de la dirección de desarrollo.
 * Los gestores que sean empresas, además existirán en SupplierPartner y el/los contratos firmados con dichas empresas pertenecen al dominio de Supplier/Partner.
 * 
 * <p>Clase Java para OrganizationRole_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OrganizationRole_DTO_OUT"&gt;
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
@XmlType(name = "OrganizationRole_DTO_OUT", propOrder = { "id" })
public class OrganizationRole_DTO_OUT implements Serializable {

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
