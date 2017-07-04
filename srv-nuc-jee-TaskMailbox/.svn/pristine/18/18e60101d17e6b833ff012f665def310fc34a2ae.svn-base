package com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox;

import java.io.Serializable;
import java.util.Date;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.telefonica.tran.comarq.cc.adaptadores.XSDAdaptadorDate;

/**
 * <p>Clase Java para FindFullTaskMailbox_IN complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FindFullTaskMailbox_IN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Application" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findFullTaskMailbox-v3}Application_DTO_IN" minOccurs="0"/&gt;
 *         &lt;element name="FromDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="FunctionalPool" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findFullTaskMailbox-v3}FunctionalPool_DTO_IN" minOccurs="0"/&gt;
 *         &lt;element name="OrganizationRole" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findFullTaskMailbox-v3}OrganizationRole_DTO_IN" minOccurs="0"/&gt;
 *         &lt;element name="ShowAllLanguages" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="TaskMailbox" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findFullTaskMailbox-v3}TaskMailbox_DTO_IN" minOccurs="0"/&gt;
 *         &lt;element name="ToDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindFullTaskMailbox_IN", propOrder = { "application", "fromDate", "functionalPool",
        "organizationRole", "showAllLanguages", "taskMailbox", "toDate" })
@XmlRootElement(name = "FindFullTaskMailbox_IN")
public class FindFullTaskMailbox_IN implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Application")
    @Valid
    protected Application_DTO_IN application;
    @XmlElement(name = "FromDate", type = String.class)
    @XmlJavaTypeAdapter(XSDAdaptadorDate.class)
    @XmlSchemaType(name = "date")
    protected Date fromDate;
    @XmlElement(name = "FunctionalPool")
    @Valid
    protected FunctionalPool_DTO_IN functionalPool;
    @XmlElement(name = "OrganizationRole")
    @Valid
    protected OrganizationRole_DTO_IN organizationRole;
    @XmlElement(name = "ShowAllLanguages")
    protected Boolean showAllLanguages;
    @XmlElement(name = "TaskMailbox")
    @Valid
    protected TaskMailbox_DTO_IN taskMailbox;
    @XmlElement(name = "ToDate", type = String.class)
    @XmlJavaTypeAdapter(XSDAdaptadorDate.class)
    @XmlSchemaType(name = "date")
    protected Date toDate;

    /**
     * Obtiene el valor de la propiedad application.
     * 
     * @return
     *     possible object is
     *     {@link Application_DTO_IN }
     *     
     */
    public Application_DTO_IN getApplication() {
        return application;
    }

    /**
     * Define el valor de la propiedad application.
     * 
     * @param value
     *     allowed object is
     *     {@link Application_DTO_IN }
     *     
     */
    public void setApplication(Application_DTO_IN value) {
        this.application = value;
    }

    /**
     * Obtiene el valor de la propiedad fromDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getFromDate() {
        return fromDate;
    }

    /**
     * Define el valor de la propiedad fromDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromDate(Date value) {
        this.fromDate = value;
    }

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

    /**
     * Obtiene el valor de la propiedad showAllLanguages.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowAllLanguages() {
        return showAllLanguages;
    }

    /**
     * Define el valor de la propiedad showAllLanguages.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowAllLanguages(Boolean value) {
        this.showAllLanguages = value;
    }

    /**
     * Obtiene el valor de la propiedad taskMailbox.
     * 
     * @return
     *     possible object is
     *     {@link TaskMailbox_DTO_IN }
     *     
     */
    public TaskMailbox_DTO_IN getTaskMailbox() {
        return taskMailbox;
    }

    /**
     * Define el valor de la propiedad taskMailbox.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskMailbox_DTO_IN }
     *     
     */
    public void setTaskMailbox(TaskMailbox_DTO_IN value) {
        this.taskMailbox = value;
    }

    /**
     * Obtiene el valor de la propiedad toDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getToDate() {
        return toDate;
    }

    /**
     * Define el valor de la propiedad toDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToDate(Date value) {
        this.toDate = value;
    }

}
