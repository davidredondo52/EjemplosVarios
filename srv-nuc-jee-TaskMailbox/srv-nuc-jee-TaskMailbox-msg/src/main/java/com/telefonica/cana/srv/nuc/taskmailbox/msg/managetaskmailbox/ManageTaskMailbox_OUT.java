package com.telefonica.cana.srv.nuc.taskmailbox.msg.managetaskmailbox;

import java.io.Serializable;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Clase Java para ManageTaskMailbox_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ManageTaskMailbox_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TaskMailbox" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/manageTaskMailbox-v3}TaskMailbox_DTO_OUT" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ManageTaskMailbox_OUT", propOrder = { "taskMailbox" })
@XmlRootElement(name = "ManageTaskMailbox_OUT")
public class ManageTaskMailbox_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "TaskMailbox")
    @Valid
    protected TaskMailbox_DTO_OUT taskMailbox;

    /**
     * Obtiene el valor de la propiedad taskMailbox.
     * 
     * @return
     *     possible object is
     *     {@link TaskMailbox_DTO_OUT }
     *     
     */
    public TaskMailbox_DTO_OUT getTaskMailbox() {
        return taskMailbox;
    }

    /**
     * Define el valor de la propiedad taskMailbox.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskMailbox_DTO_OUT }
     *     
     */
    public void setTaskMailbox(TaskMailbox_DTO_OUT value) {
        this.taskMailbox = value;
    }

}
