package com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool;

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
 * <p>Clase Java para GetOrganizationTaskMailboxByFunctionalPool_IN complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetOrganizationTaskMailboxByFunctionalPool_IN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FunctionalPool" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getOrganizationTaskMailboxByFunctionalPool-v3}FunctionalPool_DTO_IN" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetOrganizationTaskMailboxByFunctionalPool_IN", propOrder = { "functionalPools" })
@XmlRootElement(name = "GetOrganizationTaskMailboxByFunctionalPool_IN")
public class GetOrganizationTaskMailboxByFunctionalPool_IN implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "FunctionalPool", required = true)
    @NotNull
    @Size(min = 1)
    @Valid
    protected com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN[] functionalPools;

    /**
     * 
     * 
     * @return
     *     array of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN[] getFunctionalPools() {
        if (this.functionalPools == null) {
            return new com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN[0];
        }
        com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN[] retVal = new com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN[this.functionalPools.length];
        System.arraycopy(this.functionalPools, 0, retVal, 0, this.functionalPools.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN getFunctionalPools(
            int idx) {
        if (this.functionalPools == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.functionalPools[idx];
    }

    public int getFunctionalPoolsLength() {
        if (this.functionalPools == null) {
            return 0;
        }
        return this.functionalPools.length;
    }

    /**
     * 
     * 
     * @param values
     *     allowed objects are
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN }
     *     
     */
    public void setFunctionalPools(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN[] values) {
        int len = values.length;
        this.functionalPools = ((com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN[]) new com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN[len]);
        for (int i = 0; (i < len); i++) {
            this.functionalPools[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN setFunctionalPools(
            int idx,
            com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool.FunctionalPool_DTO_IN value) {
        return this.functionalPools[idx] = value;
    }

}
