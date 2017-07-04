package com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox;

import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.telefonica.tran.comarq.cc.adaptadores.XSDAdaptadorLong;

/**
 * <p>Clase Java para ManageTaskMailbox_IN complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ManageTaskMailbox_IN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OperationType" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="TaskMailbox" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/manageTaskMailbox-v3}TaskMailbox_DTO_IN"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManageTaskMailbox_IN", propOrder = { "operationType", "taskMailbox" })
@XmlRootElement(name = "ManageTaskMailbox_IN")
public class ManageTaskMailbox_IN implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "OperationType", required = true, type = String.class)
    @XmlJavaTypeAdapter(XSDAdaptadorLong.class)
    @XmlSchemaType(name = "integer")
    @NotNull
    protected Long operationType;
    @XmlElement(name = "TaskMailbox", required = true)
    @NotNull
    @Valid
    protected TaskMailbox_DTO_IN taskMailbox;

    /**
     * Obtiene el valor de la propiedad operationType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Long getOperationType() {
        return operationType;
    }

    /**
     * Define el valor de la propiedad operationType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationType(Long value) {
        this.operationType = value;
    }

    /**
     * Obtiene el valor de la propiedad taskMailbox.
     * 
     * @return
     *     possible object is
     *     {@link TaskMailbox_DTO_IN }
     *     
     */
    public TaskMailbox_DTO_IN getTaskMailbox() {
        return taskMailbox;
    }

    /**
     * Define el valor de la propiedad taskMailbox.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskMailbox_DTO_IN }
     *     
     */
    public void setTaskMailbox(TaskMailbox_DTO_IN value) {
        this.taskMailbox = value;
    }

}
