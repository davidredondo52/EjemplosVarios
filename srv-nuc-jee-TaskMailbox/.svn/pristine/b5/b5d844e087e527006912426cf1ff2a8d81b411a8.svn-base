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
 * Customer feature that groups as a tree customer demands and is attended by the different work units: loyalty, retention, recruitment, selling...  
 * The same enterprise function instance can be in more than one tree node. 
 * Only nodes without children can be used for relationship with functional pool. 
 *   
 * #ESPAÑOL#   ARBOL FUNCION ESTRATEGICA 
 * Árbol que permite agrupar las demandas de cliente que son atendidas por las diferentes UF en función de una concatenación de funciones estratégicas. 
 * La misma función estratégica puede ser empleada en más de un nodo (de más de un árbol). 
 * Sólo los nodos finales (sin hijos) pueden asignarse a las UF.
 * El nodo asignado determina qué otra información requiere la UF. Por ejemplo, para las funciones de atención y comercial es obligatorio el tipo de canal y el canal comercial, mientras que para funciones de provisión y mantenimiento, no se informa el canal, pero sí la relación de ServiceSpec y de resourceSpec para los que está habilitada la UF. En caso de requerir tipo de canal, el patrón de actuación de la UF debe ser uno de los válidos para ese tipo de canal.
 * 
 * <p>Clase Java para EnterpriseFunctionTreeNode_DTO_IN complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EnterpriseFunctionTreeNode_DTO_IN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnterpriseFunctionTreeNode_DTO_IN", propOrder = { "id" })
public class EnterpriseFunctionTreeNode_DTO_IN implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true, type = String.class)
    @XmlJavaTypeAdapter(XSDAdaptadorLong.class)
    @XmlSchemaType(name = "integer")
    @NotNull
    protected Long id;

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

}
