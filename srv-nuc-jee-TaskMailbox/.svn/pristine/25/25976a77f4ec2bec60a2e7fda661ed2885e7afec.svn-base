package com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox;

import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Clase Java para GetFunctionalTaskMailbox_IN complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetFunctionalTaskMailbox_IN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SalesChannelProposal" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getFunctionalTaskMailbox-v3}SalesChannelProposal_DTO_IN"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFunctionalTaskMailbox_IN", propOrder = { "salesChannelProposal" })
@XmlRootElement(name = "GetFunctionalTaskMailbox_IN")
public class GetFunctionalTaskMailbox_IN implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "SalesChannelProposal", required = true)
    @NotNull
    @Valid
    protected SalesChannelProposal_DTO_IN salesChannelProposal;

    /**
     * Obtiene el valor de la propiedad salesChannelProposal.
     * 
     * @return
     *     possible object is
     *     {@link SalesChannelProposal_DTO_IN }
     *     
     */
    public SalesChannelProposal_DTO_IN getSalesChannelProposal() {
        return salesChannelProposal;
    }

    /**
     * Define el valor de la propiedad salesChannelProposal.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesChannelProposal_DTO_IN }
     *     
     */
    public void setSalesChannelProposal(SalesChannelProposal_DTO_IN value) {
        this.salesChannelProposal = value;
    }

}
