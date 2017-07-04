package com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible;

import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Grouping Taskmailbox. Contains a mailbox and the list of operators for which there is to be the work of those operators in the mailbox.
 * 
 * <p>Clase Java para GroupingTaskMailbox_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GroupingTaskMailbox_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TaskMailbox" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailBoxByResponsible-v3}TaskMailbox_DTO_OUT"/&gt;
 *         &lt;element name="OrganizationRole" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailBoxByResponsible-v3}OrganizationRole_DTO_OUT" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupingTaskMailbox_DTO_OUT", propOrder = { "taskMailbox", "organizationRoles" })
public class GroupingTaskMailbox_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "TaskMailbox", required = true)
    @NotNull
    @Valid
    protected TaskMailbox_DTO_OUT taskMailbox;
    @XmlElement(name = "OrganizationRole", required = true)
    @NotNull
    @Size(min = 1)
    @Valid
    protected com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT[] organizationRoles;

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

    /**
     * 
     * 
     * @return
     *     array of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT[] getOrganizationRoles() {
        if (this.organizationRoles == null) {
            return new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT[0];
        }
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT[] retVal = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT[this.organizationRoles.length];
        System.arraycopy(this.organizationRoles, 0, retVal, 0, this.organizationRoles.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT getOrganizationRoles(
            int idx) {
        if (this.organizationRoles == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.organizationRoles[idx];
    }

    public int getOrganizationRolesLength() {
        if (this.organizationRoles == null) {
            return 0;
        }
        return this.organizationRoles.length;
    }

    /**
     * 
     * 
     * @param values
     *     allowed objects are
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT }
     *     
     */
    public void setOrganizationRoles(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT[] values) {
        int len = values.length;
        this.organizationRoles = ((com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT[]) new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT[len]);
        for (int i = 0; (i < len); i++) {
            this.organizationRoles[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT setOrganizationRoles(
            int idx,
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxbyresponsible.OrganizationRole_DTO_OUT value) {
        return this.organizationRoles[idx] = value;
    }

}
