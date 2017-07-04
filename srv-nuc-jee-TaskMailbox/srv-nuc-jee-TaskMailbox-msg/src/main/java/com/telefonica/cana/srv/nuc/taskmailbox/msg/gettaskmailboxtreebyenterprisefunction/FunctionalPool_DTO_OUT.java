package com.telefonica.cana.srv.nuc.taskmailbox.msg.gettaskmailboxtreebyenterprisefunction;

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
 * Group of managers with the same capabilities to perform the same type of activity. For example: sales consulting, to open claims, to query current instalation works...
 * If telephone service, there are many Functional Pool as communication patterns.
 *  
 * #ESPAÑOL#  UNIDAD FUNCIONAL
 * Agupación de gestores con las mismas capacidades de actuación, de forma de trabajo (función estratégica, tipo de canal, segmento y territorio asignado), de equipamiento (herramientas disponibles) y de conocimientos (habilidades y permisos reconocidos) para realizan el mismo tipo de actividad (catálogo de demanda asignado a través de su patrón de actuación). Por ejemplo:
 * -CONSULTA TRAMITACIONES EN CURSO
 * -CONSULTA LIQUIDACIONES
 * -APERTURA RECLAMACION SOBRE LIQUIDACION
 * -SOLICITUD MATERIAL PLV
 * -ACCESO A PUBLICACIONES MOVISTAR
 * En caso de atención telefónica (Tipo de canal = Telefónico), se generan tantas UF como patrones de comunicación para una empresa/sede. En caso de tiendas, todas las tiendas de un mismo proveedor (p.ej. tiendas de Telyco) puede constituir una sola UF.
 * 
 * <p>Clase Java para FunctionalPool_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="FunctionalPool_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="EnterpriseFunctionTreeNode" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getTaskMailboxTreeByEnterpriseFunction-v3}EnterpriseFunctionTreeNode_DTO_OUT"/&gt;
 *         &lt;element name="MailboxStatus" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getTaskMailboxTreeByEnterpriseFunction-v3}MailboxState"/&gt;
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="PoolType" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getTaskMailboxTreeByEnterpriseFunction-v3}FuncPoolType"/&gt;
 *         &lt;element name="WorkMode" type="{http://telefonica.com/cana/srv/TaskMailbox/msg/getTaskMailboxTreeByEnterpriseFunction-v3}WorkMode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FunctionalPool_DTO_OUT", propOrder = { "id", "enterpriseFunctionTreeNode", "mailboxStatus", "name",
        "poolType", "workMode" })
public class FunctionalPool_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true)
    @NotNull
    protected BigDecimal id;
    @XmlElement(name = "EnterpriseFunctionTreeNode", required = true)
    @NotNull
    @Valid
    protected EnterpriseFunctionTreeNode_DTO_OUT enterpriseFunctionTreeNode;
    @XmlElement(name = "MailboxStatus", required = true)
    @NotNull
    @Pattern(regexp = "0|1|2")
    protected String mailboxStatus;
    @XmlElement(name = "Name", required = true)
    @NotNull
    protected String name;
    @XmlElement(name = "PoolType", required = true)
    @NotNull
    @Pattern(regexp = "0|1|2")
    protected String poolType;
    @XmlElement(name = "WorkMode", required = true)
    @NotNull
    @Pattern(regexp = "0|1|2")
    protected String workMode;

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
     * Obtiene el valor de la propiedad enterpriseFunctionTreeNode.
     * 
     * @return
     *     possible object is
     *     {@link EnterpriseFunctionTreeNode_DTO_OUT }
     *     
     */
    public EnterpriseFunctionTreeNode_DTO_OUT getEnterpriseFunctionTreeNode() {
        return enterpriseFunctionTreeNode;
    }

    /**
     * Define el valor de la propiedad enterpriseFunctionTreeNode.
     * 
     * @param value
     *     allowed object is
     *     {@link EnterpriseFunctionTreeNode_DTO_OUT }
     *     
     */
    public void setEnterpriseFunctionTreeNode(EnterpriseFunctionTreeNode_DTO_OUT value) {
        this.enterpriseFunctionTreeNode = value;
    }

    /**
     * Obtiene el valor de la propiedad mailboxStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailboxStatus() {
        return mailboxStatus;
    }

    /**
     * Define el valor de la propiedad mailboxStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailboxStatus(String value) {
        this.mailboxStatus = value;
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
     * Obtiene el valor de la propiedad poolType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoolType() {
        return poolType;
    }

    /**
     * Define el valor de la propiedad poolType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoolType(String value) {
        this.poolType = value;
    }

    /**
     * Obtiene el valor de la propiedad workMode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkMode() {
        return workMode;
    }

    /**
     * Define el valor de la propiedad workMode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkMode(String value) {
        this.workMode = value;
    }

}
