package com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.telefonica.tran.comarq.cc.adaptadores.XSDAdaptadorLong;

/**
 * Customer feature that groups customer demands and is attended by the different work units: loyalty, retention, recruitment, selling .. 
 *  
 * #ESPAÑOL#  FUNCION ESTRATEGICA
 * Clasificación tanto de las demandas del catálogo como de los patrones de actuación y de las UF desde el punto de vista de la funcionalidad del cliente que se atiende. Por ejemplo: Fidelización, Retención, Captación, Prevención, etc. Se estructura en niveles para facilitar la administración, por ejemplo, la función Venta puede subclasificarse en Venta Personalizada y Venta Genérica por catálogo. Incluye también funciones no directamente relacionadas con el catálogo de la demanda, como es la instalación.
 * 
 * <p>Clase Java para EnterpriseFunction_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EnterpriseFunction_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Overflow" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnterpriseFunction_DTO_OUT", propOrder = { "id", "name", "overflow" })
public class EnterpriseFunction_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true, type = String.class)
    @XmlJavaTypeAdapter(XSDAdaptadorLong.class)
    @XmlSchemaType(name = "integer")
    @NotNull
    protected Long id;
    @XmlElement(name = "Name", required = true)
    @NotNull
    protected String name;
    @XmlElement(name = "Overflow")
    @NotNull
    protected boolean overflow;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad overflow.
     * 
     */
    public boolean isOverflow() {
        return overflow;
    }

    /**
     * Define el valor de la propiedad overflow.
     * 
     */
    public void setOverflow(boolean value) {
        this.overflow = value;
    }

}
