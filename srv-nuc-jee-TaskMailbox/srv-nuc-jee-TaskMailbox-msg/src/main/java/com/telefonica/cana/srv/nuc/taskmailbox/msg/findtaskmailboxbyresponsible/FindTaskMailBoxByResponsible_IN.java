package com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible;

import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Clase Java para FindTaskMailBoxByResponsible_IN complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FindTaskMailBoxByResponsible_IN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TaskMailbox" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailBoxByResponsible-v3}TaskMailbox_DTO_IN" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindTaskMailBoxByResponsible_IN", propOrder = { "taskMailboxes" })
@XmlRootElement(name = "FindTaskMailBoxByResponsible_IN")
public class FindTaskMailBoxByResponsible_IN implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "TaskMailbox", required = true)
    @NotNull
    @Size(min = 1)
    @Valid
    protected com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[] taskMailboxes;

    /**
     * 
     * 
     * @return
     *     array of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[] getTaskMailboxes() {
        if (this.taskMailboxes == null) {
            return new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[0];
        }
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[] retVal = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[this.taskMailboxes.length];
        System.arraycopy(this.taskMailboxes, 0, retVal, 0, this.taskMailboxes.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN getTaskMailboxes(
            int idx) {
        if (this.taskMailboxes == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.taskMailboxes[idx];
    }

    public int getTaskMailboxesLength() {
        if (this.taskMailboxes == null) {
            return 0;
        }
        return this.taskMailboxes.length;
    }

    /**
     * 
     * 
     * @param values
     *     allowed objects are
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN }
     *     
     */
    public void setTaskMailboxes(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[] values) {
        int len = values.length;
        this.taskMailboxes = ((com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[]) new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN[len]);
        for (int i = 0; (i < len); i++) {
            this.taskMailboxes[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN setTaskMailboxes(
            int idx, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.TaskMailbox_DTO_IN value) {
        return this.taskMailboxes[idx] = value;
    }

}
