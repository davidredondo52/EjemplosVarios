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
 * <p>Clase Java para FindTaskMailBoxByResponsible_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FindTaskMailBoxByResponsible_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GroupingTaskMailbox" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailBoxByResponsible-v3}GroupingTaskMailbox_DTO_OUT" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindTaskMailBoxByResponsible_OUT", propOrder = { "groupingTaskMailboxes" })
@XmlRootElement(name = "FindTaskMailBoxByResponsible_OUT")
public class FindTaskMailBoxByResponsible_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "GroupingTaskMailbox", required = true)
    @NotNull
    @Size(min = 1)
    @Valid
    protected com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT[] groupingTaskMailboxes;

    /**
     * 
     * 
     * @return
     *     array of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT[] getGroupingTaskMailboxes() {
        if (this.groupingTaskMailboxes == null) {
            return new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT[0];
        }
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT[] retVal = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT[this.groupingTaskMailboxes.length];
        System.arraycopy(this.groupingTaskMailboxes, 0, retVal, 0, this.groupingTaskMailboxes.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT getGroupingTaskMailboxes(
            int idx) {
        if (this.groupingTaskMailboxes == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.groupingTaskMailboxes[idx];
    }

    public int getGroupingTaskMailboxesLength() {
        if (this.groupingTaskMailboxes == null) {
            return 0;
        }
        return this.groupingTaskMailboxes.length;
    }

    /**
     * 
     * 
     * @param values
     *     allowed objects are
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT }
     *     
     */
    public void setGroupingTaskMailboxes(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT[] values) {
        int len = values.length;
        this.groupingTaskMailboxes = ((com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT[]) new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT[len]);
        for (int i = 0; (i < len); i++) {
            this.groupingTaskMailboxes[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT setGroupingTaskMailboxes(
            int idx,
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.GroupingTaskMailbox_DTO_OUT value) {
        return this.groupingTaskMailboxes[idx] = value;
    }

}
