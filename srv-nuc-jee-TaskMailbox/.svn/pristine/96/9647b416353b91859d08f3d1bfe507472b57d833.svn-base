package com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Set of work units applied to a provider (party type company) or office center (party type organizational area) of the manager's structure.
 *  
 * #ESPAÑOL#   AMBITO FUNCIONAL ORGANIZATIVO
 * Conjunto de unidades funcionales disponibles por proveedor (tipo de sujeto = empresa con tipo de rol organizativo en Gestores) o sede (tipo de sujeto = área organizativa, también con tipo de rol organizativo en Gestores), donde tanto proveedor como sede son nodos organizativos de la estructura de Gestores. Dicho conjunto es la suma de unidades funcionales a las que están asignados los individuos gestor con algún tipo de rol funcional específico, que componen la sede o empresa proveedora.
 * Implica responsabilidad del OrganizationRole sobre la UF.
 * El período de validez es el de la UF, si se quiere variar la asignación organizativa a la UF, se cierra la validez de la UF y se genera una nueva. Además se puede asignar a nivel de organización unos catálogos comerciales diferentes a los asignados a la UF.
 * 
 * <p>Clase Java para OrganizationPoolAssignment_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="OrganizationPoolAssignment_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="FunctionalPool" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getOrganizationTaskMailboxByFunctionalPool-v3}FunctionalPool_DTO_OUT"/&gt;
 *         &lt;element name="OrganizationRole" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getOrganizationTaskMailboxByFunctionalPool-v3}OrganizationRole_DTO_OUT"/&gt;
 *         &lt;element name="TaskMailbox" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getOrganizationTaskMailboxByFunctionalPool-v3}TaskMailbox_DTO_OUT" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationPoolAssignment_DTO_OUT", propOrder = { "id", "functionalPool", "organizationRole",
        "taskMailbox" })
public class OrganizationPoolAssignment_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true)
    @NotNull
    protected BigDecimal id;
    @XmlElement(name = "FunctionalPool", required = true)
    @NotNull
    @Valid
    protected FunctionalPool_DTO_OUT functionalPool;
    @XmlElement(name = "OrganizationRole", required = true)
    @NotNull
    @Valid
    protected OrganizationRole_DTO_OUT organizationRole;
    @XmlElement(name = "TaskMailbox")
    @Valid
    protected TaskMailbox_DTO_OUT taskMailbox;

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

    /**
     * Obtiene el valor de la propiedad functionalPool.
     * 
     * @return
     *     possible object is
     *     {@link FunctionalPool_DTO_OUT }
     *     
     */
    public FunctionalPool_DTO_OUT getFunctionalPool() {
        return functionalPool;
    }

    /**
     * Define el valor de la propiedad functionalPool.
     * 
     * @param value
     *     allowed object is
     *     {@link FunctionalPool_DTO_OUT }
     *     
     */
    public void setFunctionalPool(FunctionalPool_DTO_OUT value) {
        this.functionalPool = value;
    }

    /**
     * Obtiene el valor de la propiedad organizationRole.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationRole_DTO_OUT }
     *     
     */
    public OrganizationRole_DTO_OUT getOrganizationRole() {
        return organizationRole;
    }

    /**
     * Define el valor de la propiedad organizationRole.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationRole_DTO_OUT }
     *     
     */
    public void setOrganizationRole(OrganizationRole_DTO_OUT value) {
        this.organizationRole = value;
    }

    /**
     * Obtiene el valor de la propiedad taskMailbox.
     * 
     * @return
     *     possible object is
     *     {@link TaskMailbox_DTO_OUT }
     *     
     */
    public TaskMailbox_DTO_OUT getTaskMailbox() {
        return taskMailbox;
    }

    /**
     * Define el valor de la propiedad taskMailbox.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskMailbox_DTO_OUT }
     *     
     */
    public void setTaskMailbox(TaskMailbox_DTO_OUT value) {
        this.taskMailbox = value;
    }

}
