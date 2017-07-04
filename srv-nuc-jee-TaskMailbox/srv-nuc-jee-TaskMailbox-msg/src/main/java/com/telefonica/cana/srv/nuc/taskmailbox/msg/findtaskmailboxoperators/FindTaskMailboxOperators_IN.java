package com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators;

import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Clase Java para FindTaskMailboxOperators_IN complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FindTaskMailboxOperators_IN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FunctionalPool" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailboxOperators-v3}FunctionalPool_DTO_IN"/&gt;
 *         &lt;element name="OrganizationRole" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailboxOperators-v3}OrganizationRole_DTO_IN" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindTaskMailboxOperators_IN", propOrder = { "functionalPool", "organizationRole" })
@XmlRootElement(name = "FindTaskMailboxOperators_IN")
public class FindTaskMailboxOperators_IN implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "FunctionalPool", required = true)
    @NotNull
    @Valid
    protected FunctionalPool_DTO_IN functionalPool;
    @XmlElement(name = "OrganizationRole")
    @Valid
    protected OrganizationRole_DTO_IN organizationRole;

    /**
     * Obtiene el valor de la propiedad functionalPool.
     * 
     * @return
     *     possible object is
     *     {@link FunctionalPool_DTO_IN }
     *     
     */
    public FunctionalPool_DTO_IN getFunctionalPool() {
        return functionalPool;
    }

    /**
     * Define el valor de la propiedad functionalPool.
     * 
     * @param value
     *     allowed object is
     *     {@link FunctionalPool_DTO_IN }
     *     
     */
    public void setFunctionalPool(FunctionalPool_DTO_IN value) {
        this.functionalPool = value;
    }

    /**
     * Obtiene el valor de la propiedad organizationRole.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationRole_DTO_IN }
     *     
     */
    public OrganizationRole_DTO_IN getOrganizationRole() {
        return organizationRole;
    }

    /**
     * Define el valor de la propiedad organizationRole.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationRole_DTO_IN }
     *     
     */
    public void setOrganizationRole(OrganizationRole_DTO_IN value) {
        this.organizationRole = value;
    }

}
