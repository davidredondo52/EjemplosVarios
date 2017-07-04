package com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool;

import java.io.Serializable;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Clase Java para GetOrganizationTaskMailboxByFunctionalPool_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetOrganizationTaskMailboxByFunctionalPool_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrganizationPoolAssignment" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getOrganizationTaskMailboxByFunctionalPool-v3}OrganizationPoolAssignment_DTO_OUT" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetOrganizationTaskMailboxByFunctionalPool_OUT", propOrder = { "organizationPoolAssignments" })
@XmlRootElement(name = "GetOrganizationTaskMailboxByFunctionalPool_OUT")
public class GetOrganizationTaskMailboxByFunctionalPool_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "OrganizationPoolAssignment")
    @Valid
    protected com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT[] organizationPoolAssignments;

    /**
     * 
     * 
     * @return
     *     array of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT[] getOrganizationPoolAssignments() {
        if (this.organizationPoolAssignments == null) {
            return new com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT[0];
        }
        com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT[] retVal = new com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT[this.organizationPoolAssignments.length];
        System.arraycopy(this.organizationPoolAssignments, 0, retVal, 0, this.organizationPoolAssignments.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT getOrganizationPoolAssignments(
            int idx) {
        if (this.organizationPoolAssignments == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.organizationPoolAssignments[idx];
    }

    public int getOrganizationPoolAssignmentsLength() {
        if (this.organizationPoolAssignments == null) {
            return 0;
        }
        return this.organizationPoolAssignments.length;
    }

    /**
     * 
     * 
     * @param values
     *     allowed objects are
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT }
     *     
     */
    public void setOrganizationPoolAssignments(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT[] values) {
        int len = values.length;
        this.organizationPoolAssignments = ((com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT[]) new com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT[len]);
        for (int i = 0; (i < len); i++) {
            this.organizationPoolAssignments[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT setOrganizationPoolAssignments(
            int idx,
            com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.OrganizationPoolAssignment_DTO_OUT value) {
        return this.organizationPoolAssignments[idx] = value;
    }

}
