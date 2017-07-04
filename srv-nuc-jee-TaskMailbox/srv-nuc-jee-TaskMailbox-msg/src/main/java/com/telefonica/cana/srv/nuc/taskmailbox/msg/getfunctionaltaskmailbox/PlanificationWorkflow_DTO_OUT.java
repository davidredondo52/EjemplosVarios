package com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Response for each requested subareas. The first task is to determine the feasibility of the proposal in the requisitaded date; only if the proposal is feasible, the other fields about duration and cost of the work to be performed is estimated. 
 * #ESPAÑOL# Respuesta de cada una de las subáreas impactadas. La primera labor es determinar la viabilidad de la propuesta en la fechas requisitadas; sólo si la propuesta es viable, se habilitan los demás campos donde se estima la duración y coste de los trabajos a realizar. Todos los campos son opcionales porque la selección de subáreas impactadas es tarea del analista de la propuesta y luego se pasa el control a estas subáreas para que informen.
 * 
 * <p>Clase Java para PlanificationWorkflow_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="PlanificationWorkflow_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="ProposalReady" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="TaskMailbox" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getFunctionalTaskMailbox-v3}TaskMailbox_DTO_OUT"/&gt;
 *         &lt;element name="Viability" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getFunctionalTaskMailbox-v3}Viability" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlanificationWorkflow_DTO_OUT", propOrder = { "id", "proposalReady", "taskMailbox", "viability" })
public class PlanificationWorkflow_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true)
    @NotNull
    protected BigDecimal id;
    @XmlElement(name = "ProposalReady")
    protected Boolean proposalReady;
    @XmlElement(name = "TaskMailbox", required = true)
    @NotNull
    @Valid
    protected TaskMailbox_DTO_OUT taskMailbox;
    @XmlElement(name = "Viability")
    @Pattern(regexp = "0|1|2|3|4")
    protected String viability;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setId(BigDecimal value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad proposalReady.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isProposalReady() {
        return proposalReady;
    }

    /**
     * Define el valor de la propiedad proposalReady.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setProposalReady(Boolean value) {
        this.proposalReady = value;
    }

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

    /**
     * Obtiene el valor de la propiedad viability.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViability() {
        return viability;
    }

    /**
     * Define el valor de la propiedad viability.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViability(String value) {
        this.viability = value;
    }

}
