package com.telefonica.cana.srv.nuc.taskmailbox.msg.findtasksmailboxesmanager;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Functional Role with access and / or responsability over mailbox.
 * #ESPAÑOL# Gestor funcional con permiso de acceso y /o responsabilidad sobre buzones. Debe validarse contra Gestores que las organizaciones a cuyo buzón se da acceso y/o de cuyo buzón se hace responsable sea una de las organizaciones de la estructura jerárquica del gestor. También debe validarse que el gestor esté asignado a las UFs a cuyos buzones tenga acceso o de los que sea responsable.
 * 
 * <p>Clase Java para MailboxAccess_DTO_OUT complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MailboxAccess_DTO_OUT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="MailboxAccess" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="MailboxResponsible" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MailboxAccess_DTO_OUT", propOrder = { "id", "mailboxAccess", "mailboxResponsible" })
public class MailboxAccess_DTO_OUT implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Id", required = true)
    @NotNull
    protected BigDecimal id;
    @XmlElement(name = "MailboxAccess")
    @NotNull
    protected boolean mailboxAccess;
    @XmlElement(name = "MailboxResponsible")
    @NotNull
    protected boolean mailboxResponsible;

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
     * Obtiene el valor de la propiedad mailboxAccess.
     * 
     */
    public boolean isMailboxAccess() {
        return mailboxAccess;
    }

    /**
     * Define el valor de la propiedad mailboxAccess.
     * 
     */
    public void setMailboxAccess(boolean value) {
        this.mailboxAccess = value;
    }

    /**
     * Obtiene el valor de la propiedad mailboxResponsible.
     * 
     */
    public boolean isMailboxResponsible() {
        return mailboxResponsible;
    }

    /**
     * Define el valor de la propiedad mailboxResponsible.
     * 
     */
    public void setMailboxResponsible(boolean value) {
        this.mailboxResponsible = value;
    }

}
