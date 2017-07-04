//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.03.02 a las 02:20:12 PM CET 
//

package com.telefonica.cana.srv.nuc.taskmailbox.msg.getmanagerbytaskmailbox;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.telefonica.tran.comarq.cc.adaptadores.XSDAdaptadorDateTime;

/**
 * A base / value business entity used to represent a period of time, between two timepoints
 * 
 * <p>Clase Java para TimePeriod complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TimePeriod"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EndDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="StartDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimePeriod", propOrder = { "endDateTime", "startDateTime" })
public class TimePeriod implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "EndDateTime", type = String.class)
    @XmlJavaTypeAdapter(XSDAdaptadorDateTime.class)
    @XmlSchemaType(name = "dateTime")
    protected Date endDateTime;
    @XmlElement(name = "StartDateTime", required = true, type = String.class)
    @XmlJavaTypeAdapter(XSDAdaptadorDateTime.class)
    @XmlSchemaType(name = "dateTime")
    @NotNull
    protected Date startDateTime;

    /**
     * Obtiene el valor de la propiedad endDateTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getEndDateTime() {
        return endDateTime;
    }

    /**
     * Define el valor de la propiedad endDateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDateTime(Date value) {
        this.endDateTime = value;
    }

    /**
     * Obtiene el valor de la propiedad startDateTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getStartDateTime() {
        return startDateTime;
    }

    /**
     * Define el valor de la propiedad startDateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDateTime(Date value) {
        this.startDateTime = value;
    }

}
