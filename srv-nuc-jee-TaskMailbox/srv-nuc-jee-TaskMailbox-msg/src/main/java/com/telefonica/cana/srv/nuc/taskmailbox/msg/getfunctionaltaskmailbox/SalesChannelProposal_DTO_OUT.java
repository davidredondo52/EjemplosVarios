package com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * These processes create and document proposals for sales processes and sales channels. The processes define proposals to change existing sales processes and/or channels, or to develop new sales processes and/or channels. These processes undertake the necessary identification of the needs of products, and an analysis of the existing or proposed enterprise sales process and/or channel capabilities. The proposals can be based on industry analysis from the Monitoring Sales and Channel Best Practice processes, on feedback of the effectiveness of existing sales channels from the Selling processes, or on specific requirements associated with the development of new or enhanced products. These processes include defining product sales targets for each channel, as well as sales and sales personnel performance indicators for each channel. #ESPAÑOL# Al recibir una demanda de actuación del canal de áreas como marketing, supervisión de canales, estrategia, etc. (las posibles áreas solicitantes estan predefinidas en Gestores), el primer paso es comprobar si la información proporcionada en la demanda de adecuación es suficiente. En caso negativo, la demanda queda en estado 'Requiere mas información' y no se genera propuesta.
 * En caso positivo, el siguiente paso es generar y tipificar la propuesta. Hay dos posibles tipos: estándar y no estándar; las primeras tienen Spec, que se asigna a la propuesta yen función de ese spec quedan predeterminadas las áreas impactadas. Las segundas no tienen Spec y se seleccionan las areas impactadas sin ninguna guía.
 * Una vez clasificada la propuesta y asignadas las áreas impactadas, el tercer paso es el análisis de viabilidad.
 * En cualquier paso, la propuesta puede ser rechazada; en caso de rechazo es preceptivo informar un motivo de rechazo y, opcionalmente, un comentario.
 * 
 * <p>Clase Java para SalesChannelProposal_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SalesChannelProposal_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="PlanificationWorkflow" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getFunctionalTaskMailbox-v3}PlanificationWorkflow_DTO_OUT" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalesChannelProposal_DTO_OUT", propOrder = { "id", "planificationWorkflows" })
public class SalesChannelProposal_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true)
    @NotNull
    protected BigDecimal id;
    @XmlElement(name = "PlanificationWorkflow")
    @Valid
    protected com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT[] planificationWorkflows;

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
     * 
     * 
     * @return
     *     array of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT[] getPlanificationWorkflows() {
        if (this.planificationWorkflows == null) {
            return new com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT[0];
        }
        com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT[] retVal = new com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT[this.planificationWorkflows.length];
        System.arraycopy(this.planificationWorkflows, 0, retVal, 0, this.planificationWorkflows.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT getPlanificationWorkflows(
            int idx) {
        if (this.planificationWorkflows == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.planificationWorkflows[idx];
    }

    public int getPlanificationWorkflowsLength() {
        if (this.planificationWorkflows == null) {
            return 0;
        }
        return this.planificationWorkflows.length;
    }

    /**
     * 
     * 
     * @param values
     *     allowed objects are
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT }
     *     
     */
    public void setPlanificationWorkflows(
            com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT[] values) {
        int len = values.length;
        this.planificationWorkflows = ((com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT[]) new com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT[len]);
        for (int i = 0; (i < len); i++) {
            this.planificationWorkflows[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT }
     *     
     */
    public com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT setPlanificationWorkflows(
            int idx,
            com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox.PlanificationWorkflow_DTO_OUT value) {
        return this.planificationWorkflows[idx] = value;
    }

}
