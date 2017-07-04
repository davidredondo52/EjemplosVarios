//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.05.04 a las 03:13:29 PM CEST 
//


package com.telefonica.cana.srv.util.commonutilities.msg.getlanguagesheader;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.telefonica.tran.comarq.cc.adaptadores.XSDAdaptadorLong;


/**
 * <p>Clase Java para GetLanguagesHeader_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GetLanguagesHeader_OUT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Idiomas" type="{http://www.w3.org/2001/XMLSchema}integer" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetLanguagesHeader_OUT", propOrder = {
    "idiomas"
})
@XmlRootElement(name = "GetLanguagesHeader_OUT")
public class GetLanguagesHeader_OUT
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Idiomas", required = true, type = String.class)
    @XmlJavaTypeAdapter(XSDAdaptadorLong.class)
    @XmlSchemaType(name = "integer")
    @NotNull
    @Size(min = 1)
    protected Long[] idiomas;

    /**
     * 
     * 
     * @return
     *     array of
     *     {@link String }
     *     
     */
    public Long[] getIdiomas() {
        if (this.idiomas == null) {
            return new Long[ 0 ] ;
        }
        Long[] retVal = new Long[this.idiomas.length] ;
        System.arraycopy(this.idiomas, 0, retVal, 0, this.idiomas.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link String }
     *     
     */
    public Long getIdiomas(int idx) {
        if (this.idiomas == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.idiomas[idx];
    }

    public int getIdiomasLength() {
        if (this.idiomas == null) {
            return  0;
        }
        return this.idiomas.length;
    }

    /**
     * 
     * 
     * @param values
     *     allowed objects are
     *     {@link String }
     *     
     */
    public void setIdiomas(Long[] values) {
        int len = values.length;
        this.idiomas = ((Long[]) new Long[len] );
        for (int i = 0; (i<len); i ++) {
            this.idiomas[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public Long setIdiomas(int idx, Long value) {
        return this.idiomas[idx] = value;
    }

}
