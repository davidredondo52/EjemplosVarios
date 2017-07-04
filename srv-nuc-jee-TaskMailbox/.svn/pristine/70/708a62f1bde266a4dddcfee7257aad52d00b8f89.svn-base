package com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction;

import java.io.Serializable;
import javax.validation.Valid;
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
 * <p>Clase Java para EnterpriseFunctionTreeNode_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="EnterpriseFunctionTreeNode_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="EnterpriseFunction" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getTaskMailboxTreeByEnterpriseFunction-v3}EnterpriseFunction_DTO_OUT"/&gt;
 *         &lt;element name="EnterpriseFunctionTreeNodeSon" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getTaskMailboxTreeByEnterpriseFunction-v3}EnterpriseFunctionTreeNode_DTO_OUT" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnterpriseFunctionTreeNode_DTO_OUT", propOrder = { "id", "enterpriseFunction",
        "enterpriseFunctionTreeNodeSons" })
public class EnterpriseFunctionTreeNode_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true, type = String.class)
    @XmlJavaTypeAdapter(XSDAdaptadorLong.class)
    @XmlSchemaType(name = "integer")
    @NotNull
    protected Long id;
    @XmlElement(name = "EnterpriseFunction", required = true)
    @NotNull
    @Valid
    protected EnterpriseFunction_DTO_OUT enterpriseFunction;
    @XmlElement(name = "EnterpriseFunctionTreeNodeSon")
    @Valid
    protected EnterpriseFunctionTreeNode_DTO_OUT[] enterpriseFunctionTreeNodeSons;

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
     * Obtiene el valor de la propiedad enterpriseFunction.
     * 
     * @return
     *     possible object is
     *     {@link EnterpriseFunction_DTO_OUT }
     *     
     */
    public EnterpriseFunction_DTO_OUT getEnterpriseFunction() {
        return enterpriseFunction;
    }

    /**
     * Define el valor de la propiedad enterpriseFunction.
     * 
     * @param value
     *     allowed object is
     *     {@link EnterpriseFunction_DTO_OUT }
     *     
     */
    public void setEnterpriseFunction(EnterpriseFunction_DTO_OUT value) {
        this.enterpriseFunction = value;
    }

    /**
     * 
     * 
     * @return
     *     array of
     *     {@link EnterpriseFunctionTreeNode_DTO_OUT }
     *     
     */
    public EnterpriseFunctionTreeNode_DTO_OUT[] getEnterpriseFunctionTreeNodeSons() {
        if (this.enterpriseFunctionTreeNodeSons == null) {
            return new EnterpriseFunctionTreeNode_DTO_OUT[0];
        }
        EnterpriseFunctionTreeNode_DTO_OUT[] retVal = new EnterpriseFunctionTreeNode_DTO_OUT[this.enterpriseFunctionTreeNodeSons.length];
        System.arraycopy(this.enterpriseFunctionTreeNodeSons, 0, retVal, 0, this.enterpriseFunctionTreeNodeSons.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link EnterpriseFunctionTreeNode_DTO_OUT }
     *     
     */
    public EnterpriseFunctionTreeNode_DTO_OUT getEnterpriseFunctionTreeNodeSons(int idx) {
        if (this.enterpriseFunctionTreeNodeSons == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.enterpriseFunctionTreeNodeSons[idx];
    }

    public int getEnterpriseFunctionTreeNodeSonsLength() {
        if (this.enterpriseFunctionTreeNodeSons == null) {
            return 0;
        }
        return this.enterpriseFunctionTreeNodeSons.length;
    }

    /**
     * 
     * 
     * @param values
     *     allowed objects are
     *     {@link EnterpriseFunctionTreeNode_DTO_OUT }
     *     
     */
    public void setEnterpriseFunctionTreeNodeSons(EnterpriseFunctionTreeNode_DTO_OUT[] values) {
        int len = values.length;
        this.enterpriseFunctionTreeNodeSons = ((EnterpriseFunctionTreeNode_DTO_OUT[]) new com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction.EnterpriseFunctionTreeNode_DTO_OUT[len]);
        for (int i = 0; (i < len); i++) {
            this.enterpriseFunctionTreeNodeSons[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link EnterpriseFunctionTreeNode_DTO_OUT }
     *     
     */
    public EnterpriseFunctionTreeNode_DTO_OUT setEnterpriseFunctionTreeNodeSons(int idx,
            EnterpriseFunctionTreeNode_DTO_OUT value) {
        return this.enterpriseFunctionTreeNodeSons[idx] = value;
    }

}
