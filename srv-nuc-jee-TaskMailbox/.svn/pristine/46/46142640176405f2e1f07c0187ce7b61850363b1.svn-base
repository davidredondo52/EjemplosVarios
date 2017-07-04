package com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox;

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
 * Delivery / distribution criteria of Business Interaction.
 * #ESPAÑOL# Criterio de reparto/distribución de BI como puedan ser problemas de cliente, órdenes de provisión, llamadas entrantes... Es decir solicitudes asignadas a una función empresarial concreta. Por eso, la función empresarial es el discriminante que se emplea como primer nivel de distribución al que se asigna un criterio de distribución en base al cual determinar la UF (su buzón) a la que asignar la tarea. El primer nivel puede tener, por ejemplo, criterios de distribución por tipo de día y tramo horario, en los que no intervienen las condiciones de la solicitud recibida.
 * Una vez identificada la UF (su buzón), se recuperan las sedes que participan de esa UF y se aplica el segundo nivel de distribución para determinar la sede (su buzón) a la que distribuir la tarea. En el segundo nivel los criterios de distribución son en función de la caracterización de la solicitud  recibida.
 * El tercer nivel es la asignación a un gestor dentro de la sede a la que se ha distribuido la tarea.
 * Por tanto la distribución es escalonada: Función empresarial -> buzón UF -> buzón sede -> buzón personal gestor.
 * Sólo hay tres tipos de distribución: 1- regla, 2- volumen y 3- mixto (volumen + regla).
 * 
 * <p>Clase Java para DistributionCriteria_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DistributionCriteria_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DistributionCriteria_DTO_OUT", propOrder = { "id", "name" })
public class DistributionCriteria_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true, type = String.class)
    @XmlJavaTypeAdapter(XSDAdaptadorLong.class)
    @XmlSchemaType(name = "integer")
    @NotNull
    protected Long id;
    @XmlElement(name = "Name", required = true)
    @NotNull
    protected String name;

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

}
