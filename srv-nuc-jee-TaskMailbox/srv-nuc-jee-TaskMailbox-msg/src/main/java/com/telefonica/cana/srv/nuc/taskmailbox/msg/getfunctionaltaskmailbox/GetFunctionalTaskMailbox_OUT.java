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
 * <p>Clase Java para GetFunctionalTaskMailbox_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetFunctionalTaskMailbox_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SalesChannelProposal" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getFunctionalTaskMailbox-v3}SalesChannelProposal_DTO_OUT"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFunctionalTaskMailbox_OUT", propOrder = { "salesChannelProposal" })
@XmlRootElement(name = "GetFunctionalTaskMailbox_OUT")
public class GetFunctionalTaskMailbox_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "SalesChannelProposal", required = true)
    @NotNull
    @Valid
    protected SalesChannelProposal_DTO_OUT salesChannelProposal;

    /**
     * Obtiene el valor de la propiedad salesChannelProposal.
     * 
     * @return
     *     possible object is
     *     {@link SalesChannelProposal_DTO_OUT }
     *     
     */
    public SalesChannelProposal_DTO_OUT getSalesChannelProposal() {
        return salesChannelProposal;
    }

    /**
     * Define el valor de la propiedad salesChannelProposal.
     * 
     * @param value
     *     allowed object is
     *     {@link SalesChannelProposal_DTO_OUT }
     *     
     */
    public void setSalesChannelProposal(SalesChannelProposal_DTO_OUT value) {
        this.salesChannelProposal = value;
    }

}
