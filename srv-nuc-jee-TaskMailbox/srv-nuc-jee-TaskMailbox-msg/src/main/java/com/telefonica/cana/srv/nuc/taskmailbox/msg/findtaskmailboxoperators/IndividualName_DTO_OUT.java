package com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailboxoperators;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A word, term, or phrase by which an individual is known and distinguished from other individuals.A name is an informal way of identifying an object [Fowler]This entity allows for international naming variations. An IndividualName is a type of PartyName.
 * 
 * <p>Clase Java para IndividualName_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="IndividualName_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FormattedName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndividualName_DTO_OUT", propOrder = { "formattedName" })
public class IndividualName_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "FormattedName", required = true)
    @NotNull
    protected String formattedName;

    /**
     * Obtiene el valor de la propiedad formattedName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormattedName() {
        return formattedName;
    }

    /**
     * Define el valor de la propiedad formattedName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormattedName(String value) {
        this.formattedName = value;
    }

}
