package com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Distribution tasks tool for back office areas. A mailbox is assigned to a manager center (organization role) and/or a functional pool.
 *  
 * #ESPAÑOL#   BUZON TAREAS
 * Herramienta de distribución de tareas para las áreas back office. Un buzón se asigna a una UF o a una sede dentro de una UF. Es decir, son sólo buzones de grupo, no buzones personales.
 * En el alta de la UF se asigna buzón (si aplica), que se liga bien directamente a la UF o bien, si se selecciona asignarlo a sede, se despliegan las sedes asociadas a dicha UF y de entre las mismas se selecciona una.
 * Una UF tiene un único buzón (o ninguno) asignado a la propia UF, pero cada una de las sedes de la UF, pueden tener su propio buzón para esa UF -lo que hace que la misma UF figure en varios buzones-.
 * Una sede tiene un único buzón (o ninguno) asignado através de una UF, pero la misma sede puede estar en varias UF y en cada una de ellas puede tener asignado un buzon diferente.
 * El buzón puede soportar reparto manual o automático de las tareas (user task) asignadas. En ambos casos, el modo de reparto también se informa en el buzón y puede ser reparto a otros buzones de grupo o reparto a gestores asignados al buzón de grupo. En ambos casos, el criterio para seleccionar un buzón para el reparto de tareas, viene indicado en DistributionCriteria y está condicionado por el estado del buzón (no se reparte a buzones que estén en estado bloqueado).
 * 
 * <p>Clase Java para TaskMailbox_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TaskMailbox_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="Application" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailboxOperators-v3}Application_DTO_OUT" minOccurs="0"/&gt;
 *         &lt;element name="DistributionMode" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailboxOperators-v3}AutomaticDistributionMode" minOccurs="0"/&gt;
 *         &lt;element name="GroupDistributionCriteria" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailboxOperators-v3}GroupDistributionCriteria" minOccurs="0"/&gt;
 *         &lt;element name="MailboxAccess" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailboxOperators-v3}MailboxAccess_DTO_OUT"/&gt;
 *         &lt;element name="ManualDistributionMode" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailboxOperators-v3}ManualDistributionMode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaskMailbox_DTO_OUT", propOrder = { "id", "application", "distributionMode",
        "groupDistributionCriteria", "mailboxAccess", "manualDistributionMode" })
public class TaskMailbox_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true)
    @NotNull
    protected BigDecimal id;
    @XmlElement(name = "Application")
    @Valid
    protected Application_DTO_OUT application;
    @XmlElement(name = "DistributionMode")
    @Pattern(regexp = "1|2|3")
    protected String distributionMode;
    @XmlElement(name = "GroupDistributionCriteria")
    @Pattern(regexp = "1|2|3")
    protected String groupDistributionCriteria;
    @XmlElement(name = "MailboxAccess", required = true)
    @NotNull
    @Valid
    protected MailboxAccess_DTO_OUT mailboxAccess;
    @XmlElement(name = "ManualDistributionMode")
    @Pattern(regexp = "1|2|3|4")
    protected String manualDistributionMode;

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
     * Obtiene el valor de la propiedad application.
     * 
     * @return
     *     possible object is
     *     {@link Application_DTO_OUT }
     *     
     */
    public Application_DTO_OUT getApplication() {
        return application;
    }

    /**
     * Define el valor de la propiedad application.
     * 
     * @param value
     *     allowed object is
     *     {@link Application_DTO_OUT }
     *     
     */
    public void setApplication(Application_DTO_OUT value) {
        this.application = value;
    }

    /**
     * Obtiene el valor de la propiedad distributionMode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistributionMode() {
        return distributionMode;
    }

    /**
     * Define el valor de la propiedad distributionMode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistributionMode(String value) {
        this.distributionMode = value;
    }

    /**
     * Obtiene el valor de la propiedad groupDistributionCriteria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupDistributionCriteria() {
        return groupDistributionCriteria;
    }

    /**
     * Define el valor de la propiedad groupDistributionCriteria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupDistributionCriteria(String value) {
        this.groupDistributionCriteria = value;
    }

    /**
     * Obtiene el valor de la propiedad mailboxAccess.
     * 
     * @return
     *     possible object is
     *     {@link MailboxAccess_DTO_OUT }
     *     
     */
    public MailboxAccess_DTO_OUT getMailboxAccess() {
        return mailboxAccess;
    }

    /**
     * Define el valor de la propiedad mailboxAccess.
     * 
     * @param value
     *     allowed object is
     *     {@link MailboxAccess_DTO_OUT }
     *     
     */
    public void setMailboxAccess(MailboxAccess_DTO_OUT value) {
        this.mailboxAccess = value;
    }

    /**
     * Obtiene el valor de la propiedad manualDistributionMode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManualDistributionMode() {
        return manualDistributionMode;
    }

    /**
     * Define el valor de la propiedad manualDistributionMode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManualDistributionMode(String value) {
        this.manualDistributionMode = value;
    }

}
