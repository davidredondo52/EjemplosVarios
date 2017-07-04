package com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="MailboxAccess" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getManagerByTaskMailbox-v3}MailboxAccess_DTO_OUT" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaskMailbox_DTO_OUT", propOrder = { "id", "code", "mailboxAccesses" })
public class TaskMailbox_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true)
    @NotNull
    protected BigDecimal id;
    @XmlElement(name = "Code", required = true)
    @NotNull
    protected String code;
    @XmlElement(name = "MailboxAccess")
    @Valid
    protected com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT[] mailboxAccesses;

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
     * Obtiene el valor de la propiedad code.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Define el valor de la propiedad code.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * 
     * 
     * @return
     *     array of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT[] getMailboxAccesses() {
        if (this.mailboxAccesses == null) {
            return new com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT[0];
        }
        com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT[] retVal = new com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT[this.mailboxAccesses.length];
        System.arraycopy(this.mailboxAccesses, 0, retVal, 0, this.mailboxAccesses.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT getMailboxAccesses(
            int idx) {
        if (this.mailboxAccesses == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.mailboxAccesses[idx];
    }

    public int getMailboxAccessesLength() {
        if (this.mailboxAccesses == null) {
            return 0;
        }
        return this.mailboxAccesses.length;
    }

    /**
     * 
     * 
     * @param values
     *     allowed objects are
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT }
     *     
     */
    public void setMailboxAccesses(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT[] values) {
        int len = values.length;
        this.mailboxAccesses = ((com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT[]) new com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT[len]);
        for (int i = 0; (i < len); i++) {
            this.mailboxAccesses[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT setMailboxAccesses(
            int idx, com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.MailboxAccess_DTO_OUT value) {
        return this.mailboxAccesses[idx] = value;
    }

}
