package com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators;

import java.io.Serializable;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Clase Java para FindTaskMailboxOperators_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FindTaskMailboxOperators_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrganizationRole" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/findTaskMailboxOperators-v3}OrganizationRole_DTO_OUT" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindTaskMailboxOperators_OUT", propOrder = { "organizationRoles" })
@XmlRootElement(name = "FindTaskMailboxOperators_OUT")
public class FindTaskMailboxOperators_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "OrganizationRole")
    @Valid
    protected com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT[] organizationRoles;

    /**
     * 
     * 
     * @return
     *     array of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT[] getOrganizationRoles() {
        if (this.organizationRoles == null) {
            return new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT[0];
        }
        com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT[] retVal = new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT[this.organizationRoles.length];
        System.arraycopy(this.organizationRoles, 0, retVal, 0, this.organizationRoles.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT getOrganizationRoles(
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
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT }
     *     
     */
    public void setOrganizationRoles(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT[] values) {
        int len = values.length;
        this.organizationRoles = ((com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT[]) new com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT[len]);
        for (int i = 0; (i < len); i++) {
            this.organizationRoles[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT setOrganizationRoles(
            int idx, com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators.OrganizationRole_DTO_OUT value) {
        return this.organizationRoles[idx] = value;
    }

}
