package com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox;

import java.io.Serializable;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Clase Java para GetManagerByTaskMailbox_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetManagerByTaskMailbox_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TaskMailbox" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getManagerByTaskMailbox-v3}TaskMailbox_DTO_OUT" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetManagerByTaskMailbox_OUT", propOrder = { "taskMailboxes" })
@XmlRootElement(name = "GetManagerByTaskMailbox_OUT")
public class GetManagerByTaskMailbox_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "TaskMailbox")
    @Valid
    protected com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT[] taskMailboxes;

    /**
     * 
     * 
     * @return
     *     array of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT[] getTaskMailboxes() {
        if (this.taskMailboxes == null) {
            return new com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT[0];
        }
        com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT[] retVal = new com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT[this.taskMailboxes.length];
        System.arraycopy(this.taskMailboxes, 0, retVal, 0, this.taskMailboxes.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT getTaskMailboxes(
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
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT }
     *     
     */
    public void setTaskMailboxes(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT[] values) {
        int len = values.length;
        this.taskMailboxes = ((com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT[]) new com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT[len]);
        for (int i = 0; (i < len); i++) {
            this.taskMailboxes[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT setTaskMailboxes(
            int idx, com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox.TaskMailbox_DTO_OUT value) {
        return this.taskMailboxes[idx] = value;
    }

}
