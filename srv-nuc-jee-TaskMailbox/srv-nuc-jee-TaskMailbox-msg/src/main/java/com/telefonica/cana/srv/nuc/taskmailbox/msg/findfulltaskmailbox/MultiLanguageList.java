package com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox;

import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.telefonica.tran.comarq.cc.adaptadores.XSDAdaptadorLong;

/**
 * Represents a list of multi-language values of an instance.
 * 
 * <p>Clase Java para MultiLanguageList complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MultiLanguageList"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MultiLanguage" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="languageCode" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiLanguageList", propOrder = { "multiLanguages" })
public class MultiLanguageList implements Serializable {

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "MultiLanguage", required = true)
    @NotNull
    @Size(min = 1)
    @Valid
    protected MultiLanguageList.MultiLanguage[] multiLanguages;

    /**
     * 
     * 
     * @return
     *     array of
     *     {@link MultiLanguageList.MultiLanguage }
     *     
     */
    public MultiLanguageList.MultiLanguage[] getMultiLanguages() {
        if (this.multiLanguages == null) {
            return new MultiLanguageList.MultiLanguage[0];
        }
        MultiLanguageList.MultiLanguage[] retVal = new MultiLanguageList.MultiLanguage[this.multiLanguages.length];
        System.arraycopy(this.multiLanguages, 0, retVal, 0, this.multiLanguages.length);
        return (retVal);
    }

    /**
     * 
     * 
     * @return
     *     one of
     *     {@link MultiLanguageList.MultiLanguage }
     *     
     */
    public MultiLanguageList.MultiLanguage getMultiLanguages(int idx) {
        if (this.multiLanguages == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.multiLanguages[idx];
    }

    public int getMultiLanguagesLength() {
        if (this.multiLanguages == null) {
            return 0;
        }
        return this.multiLanguages.length;
    }

    /**
     * 
     * 
     * @param values
     *     allowed objects are
     *     {@link MultiLanguageList.MultiLanguage }
     *     
     */
    public void setMultiLanguages(MultiLanguageList.MultiLanguage[] values) {
        int len = values.length;
        this.multiLanguages = ((MultiLanguageList.MultiLanguage[]) new com.telefonica.cana.srv.nuc.taskmailbox.msg.findfulltaskmailbox.MultiLanguageList.MultiLanguage[len]);
        for (int i = 0; (i < len); i++) {
            this.multiLanguages[i] = values[i];
        }
    }

    /**
     * 
     * 
     * @param value
     *     allowed object is
     *     {@link MultiLanguageList.MultiLanguage }
     *     
     */
    public MultiLanguageList.MultiLanguage setMultiLanguages(int idx, MultiLanguageList.MultiLanguage value) {
        return this.multiLanguages[idx] = value;
    }

    /**
     * Represents a multi-language value of an instance in a particular language.
     * 
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="languageCode" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
     *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "languageCode", "value" })
    public static class MultiLanguage implements Serializable {

        private final static long serialVersionUID = 1L;
        @XmlElement(required = true, type = String.class)
        @XmlJavaTypeAdapter(XSDAdaptadorLong.class)
        @XmlSchemaType(name = "integer")
        @NotNull
        protected Long languageCode;
        @XmlElement(required = true)
        @NotNull
        protected String value;

        /**
         * Obtiene el valor de la propiedad languageCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public Long getLanguageCode() {
            return languageCode;
        }

        /**
         * Define el valor de la propiedad languageCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLanguageCode(Long value) {
            this.languageCode = value;
        }

        /**
         * Obtiene el valor de la propiedad value.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Define el valor de la propiedad value.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

    }

}
