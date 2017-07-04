package com.telefonica.cana.srv.nuc.taskmailbox.msg.getfunctionaltaskmailbox;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * <p>Clase Java para SalesChannelProposal_DTO_IN complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SalesChannelProposal_DTO_IN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalesChannelProposal_DTO_IN", propOrder = { "id" })
public class SalesChannelProposal_DTO_IN implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true)
    @NotNull
    protected BigDecimal id;

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

}
