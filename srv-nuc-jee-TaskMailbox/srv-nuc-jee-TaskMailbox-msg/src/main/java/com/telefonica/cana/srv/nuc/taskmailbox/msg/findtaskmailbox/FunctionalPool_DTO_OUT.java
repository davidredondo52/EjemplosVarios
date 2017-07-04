package com.telefonica.cana.srv.nuc.taskmailbox.msg.findtaskmailbox;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Group of managers with the same capabilities to perform the same type of activity. For example: sales consulting, to
 * open claims, to query current instalation works... If telephone service, there are many Functional Pool as
 * communication patterns.
 * 
 * #ESPAÑOL# UNIDAD FUNCIONAL Agupación de gestores con las mismas capacidades de actuación, de forma de trabajo
 * (función estratégica, tipo de canal, segmento y territorio asignado), de equipamiento (herramientas disponibles) y de
 * conocimientos (habilidades y permisos reconocidos) para realizan el mismo tipo de actividad (catálogo de demanda
 * asignado a través de su patrón de actuación). Por ejemplo: -CONSULTA TRAMITACIONES EN CURSO -CONSULTA LIQUIDACIONES
 * -APERTURA RECLAMACION SOBRE LIQUIDACION -SOLICITUD MATERIAL PLV -ACCESO A PUBLICACIONES MOVISTAR En caso de atención
 * telefónica (Tipo de canal = Telefónico), se generan tantas UF como patrones de comunicación para una empresa/sede. En
 * caso de tiendas, todas las tiendas de un mismo proveedor (p.ej. tiendas de Telyco) puede constituir una sola UF.
 * 
 * <p>
 * Clase Java para FunctionalPool_DTO_OUT complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FunctionalPool_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
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
@XmlType(name = "FunctionalPool_DTO_OUT", propOrder = { "id", "name" })
public class FunctionalPool_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true)
    @NotNull
    protected BigDecimal id;
    @XmlElement(name = "Name", required = true)
    @NotNull
    protected String name;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return possible object is {@link BigDecimal }
     * 
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *            allowed object is {@link BigDecimal }
     * 
     */
    public void setId(BigDecimal value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setName(String value) {
        this.name = value;
    }

}
