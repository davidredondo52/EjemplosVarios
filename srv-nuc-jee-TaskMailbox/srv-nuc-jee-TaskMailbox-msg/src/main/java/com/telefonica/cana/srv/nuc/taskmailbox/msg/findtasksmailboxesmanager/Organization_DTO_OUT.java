package com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A group of people identified by shared interests or purpose. Examples include business, department, enterprise.Because of the complex nature of many businesses, both organizations and organization units are represented by the same business entity in this model. An Organization is a type of Party
 * 
 * <p>Clase Java para Organization_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Organization_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="OrganizationName" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTasksMailBoxesManager-v3}OrganizationName_DTO_OUT"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Organization_DTO_OUT", propOrder = { "id", "organizationName" })
public class Organization_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true)
    @NotNull
    protected BigDecimal id;
    @XmlElement(name = "OrganizationName", required = true)
    @NotNull
    @Valid
    protected OrganizationName_DTO_OUT organizationName;

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
     * Obtiene el valor de la propiedad organizationName.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationName_DTO_OUT }
     *     
     */
    public OrganizationName_DTO_OUT getOrganizationName() {
        return organizationName;
    }

    /**
     * Define el valor de la propiedad organizationName.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationName_DTO_OUT }
     *     
     */
    public void setOrganizationName(OrganizationName_DTO_OUT value) {
        this.organizationName = value;
    }

}
