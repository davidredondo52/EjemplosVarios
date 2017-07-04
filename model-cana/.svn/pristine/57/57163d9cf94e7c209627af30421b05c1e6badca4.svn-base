package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Convert;

/**
 * The persistent class for the CecacLoggedManagerS database table.
 */
@Entity
@NamedQuery(name = "CecacLoggedManager.findAll", query = "SELECT c FROM CecacLoggedManager c")
@Table(name = "CECAC_LOGGED_MANAGER")
public class CecacLoggedManager implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "CHAT_ID_CHANNEL_TYPE", precision = 2)
    private Long chatIdChannelType;

    @Column(name = "ENFU_ID_ENTERPRISE_FUNCTION_N1", precision = 3)
    private Long enfuIdEnterpriseFunctionN1;

    @Column(name = "ENFU_ID_ENTERPRISE_FUNCTION_N2", precision = 3)
    private Long enfuIdEnterpriseFunctionN2;

    @Column(name = "ENFU_ID_ENTERPRISE_FUNCTION_N3", precision = 3)
    private Long enfuIdEnterpriseFunctionN3;

    @Column(name = "FPAS_IN_DEFAULT_POOL", precision = 1)
    private Long fpasInDefaultPool;

    @Column(length = 80, name = "FUPO_NA_FUNCTIONAL_POOL")
    private String fupoNaFunctionalPool;

    @Column(length = 20, name = "LCHT_NA_CHANNEL_TYPE")
    private String lchtNaChannelType;

    @Column(length = 50, name = "LEFU_NA_ENTERPRISE_FUNCTION_N1")
    private String lefuNaEnterpriseFunctionN1;

    @Column(length = 50, name = "LEFU_NA_ENTERPRISE_FUNCTION_N2")
    private String lefuNaEnterpriseFunctionN2;

    @Column(length = 50, name = "LEFU_NA_ENTERPRISE_FUNCTION_N3")
    private String lefuNaEnterpriseFunctionN3;

    @Column(name = "LOMA_IN_LOGGED", nullable = false)
    @Convert("BigDecimalBooleanConverter")
    private Boolean lomaInLogged;

    @Column(length = 160, name = "PANA_NA_FATHER_PARTY")
    private String panaNaFatherParty;

    @Column(length = 160, name = "PANA_NA_PROVIDER")
    private String panaNaProvider;

    @Column(name = "PARO_ID_FUNCTIONAL_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdFunctionalRole;

    @Column(name = "PART_ID_FATHER_PARTY", precision = 38)
    private BigDecimal partIdFatherParty;

    @Column(name = "PART_ID_PROVIDER_PARTY", precision = 38)
    private BigDecimal partIdProviderParty;

    @Column(length = 50, name = "PRTY_NA_FUNCTIONAL_ROLE_SPEC", nullable = false)
    private String prtyNaFunctionalRoleSpec;

    @Column(name = "ROTY_ID_FATHER_ROLE_SPEC", precision = 4)
    private Long rotyIdFatherRoleSpec;

    @Column(name = "ROTY_ID_FUNCTIONAL_ROLE_SPEC", nullable = false, precision = 4)
    private Long rotyIdFunctionalRoleSpec;

    @Column(name = "SEGM_ID_MARKET_SEGMENT", precision = 3)
    private Long segmIdMarketSegment;

    @Column(name = "SEGM_ID_MARKET_TERRITORY", precision = 3)
    private Long segmIdMarketTerritory;

    @Column(length = 25, name = "SEGM_NA_MARKET_SEGMENT")
    private String segmNaMarketSegment;

    @Column(length = 25, name = "SEGM_NA_MARKET_TERRITORY")
    private String segmNaMarketTerritory;

    @Column(name = "WPOO_ID_FUNCTIONAL_POOL", precision = 38)
    private BigDecimal wpooIdFunctionalPool;

    @EmbeddedId
    private CecacLoggedManagerPK id;

    public Long getChatIdChannelType() {
        return this.chatIdChannelType;
    }

    public void setChatIdChannelType(Long chatIdChannelType) {
        this.chatIdChannelType = chatIdChannelType;
    }

    public Long getEnfuIdEnterpriseFunctionN1() {
        return this.enfuIdEnterpriseFunctionN1;
    }

    public void setEnfuIdEnterpriseFunctionN1(Long enfuIdEnterpriseFunctionN1) {
        this.enfuIdEnterpriseFunctionN1 = enfuIdEnterpriseFunctionN1;
    }

    public Long getEnfuIdEnterpriseFunctionN2() {
        return this.enfuIdEnterpriseFunctionN2;
    }

    public void setEnfuIdEnterpriseFunctionN2(Long enfuIdEnterpriseFunctionN2) {
        this.enfuIdEnterpriseFunctionN2 = enfuIdEnterpriseFunctionN2;
    }

    public Long getEnfuIdEnterpriseFunctionN3() {
        return this.enfuIdEnterpriseFunctionN3;
    }

    public void setEnfuIdEnterpriseFunctionN3(Long enfuIdEnterpriseFunctionN3) {
        this.enfuIdEnterpriseFunctionN3 = enfuIdEnterpriseFunctionN3;
    }

    public Long getFpasInDefaultPool() {
        return this.fpasInDefaultPool;
    }

    public void setFpasInDefaultPool(Long fpasInDefaultPool) {
        this.fpasInDefaultPool = fpasInDefaultPool;
    }

    public String getFupoNaFunctionalPool() {
        return this.fupoNaFunctionalPool;
    }

    public void setFupoNaFunctionalPool(String fupoNaFunctionalPool) {
        this.fupoNaFunctionalPool = fupoNaFunctionalPool;
    }

    public String getLchtNaChannelType() {
        return this.lchtNaChannelType;
    }

    public void setLchtNaChannelType(String lchtNaChannelType) {
        this.lchtNaChannelType = lchtNaChannelType;
    }

    public String getLefuNaEnterpriseFunctionN1() {
        return this.lefuNaEnterpriseFunctionN1;
    }

    public void setLefuNaEnterpriseFunctionN1(String lefuNaEnterpriseFunctionN1) {
        this.lefuNaEnterpriseFunctionN1 = lefuNaEnterpriseFunctionN1;
    }

    public String getLefuNaEnterpriseFunctionN2() {
        return this.lefuNaEnterpriseFunctionN2;
    }

    public void setLefuNaEnterpriseFunctionN2(String lefuNaEnterpriseFunctionN2) {
        this.lefuNaEnterpriseFunctionN2 = lefuNaEnterpriseFunctionN2;
    }

    public String getLefuNaEnterpriseFunctionN3() {
        return this.lefuNaEnterpriseFunctionN3;
    }

    public void setLefuNaEnterpriseFunctionN3(String lefuNaEnterpriseFunctionN3) {
        this.lefuNaEnterpriseFunctionN3 = lefuNaEnterpriseFunctionN3;
    }

    public Boolean getLomaInLogged() {
        return this.lomaInLogged;
    }

    public void setLomaInLogged(Boolean lomaInLogged) {
        this.lomaInLogged = lomaInLogged;
    }

    public String getPanaNaFatherParty() {
        return this.panaNaFatherParty;
    }

    public void setPanaNaFatherParty(String panaNaFatherParty) {
        this.panaNaFatherParty = panaNaFatherParty;
    }

    public String getPanaNaProvider() {
        return this.panaNaProvider;
    }

    public void setPanaNaProvider(String panaNaProvider) {
        this.panaNaProvider = panaNaProvider;
    }

    public BigDecimal getParoIdFunctionalRole() {
        return this.paroIdFunctionalRole;
    }

    public void setParoIdFunctionalRole(BigDecimal paroIdFunctionalRole) {
        this.paroIdFunctionalRole = paroIdFunctionalRole;
    }

    public BigDecimal getPartIdFatherParty() {
        return this.partIdFatherParty;
    }

    public void setPartIdFatherParty(BigDecimal partIdFatherParty) {
        this.partIdFatherParty = partIdFatherParty;
    }

    public BigDecimal getPartIdProviderParty() {
        return this.partIdProviderParty;
    }

    public void setPartIdProviderParty(BigDecimal partIdProviderParty) {
        this.partIdProviderParty = partIdProviderParty;
    }

    public String getPrtyNaFunctionalRoleSpec() {
        return this.prtyNaFunctionalRoleSpec;
    }

    public void setPrtyNaFunctionalRoleSpec(String prtyNaFunctionalRoleSpec) {
        this.prtyNaFunctionalRoleSpec = prtyNaFunctionalRoleSpec;
    }

    public Long getRotyIdFatherRoleSpec() {
        return this.rotyIdFatherRoleSpec;
    }

    public void setRotyIdFatherRoleSpec(Long rotyIdFatherRoleSpec) {
        this.rotyIdFatherRoleSpec = rotyIdFatherRoleSpec;
    }

    public Long getRotyIdFunctionalRoleSpec() {
        return this.rotyIdFunctionalRoleSpec;
    }

    public void setRotyIdFunctionalRoleSpec(Long rotyIdFunctionalRoleSpec) {
        this.rotyIdFunctionalRoleSpec = rotyIdFunctionalRoleSpec;
    }

    public Long getSegmIdMarketSegment() {
        return this.segmIdMarketSegment;
    }

    public void setSegmIdMarketSegment(Long segmIdMarketSegment) {
        this.segmIdMarketSegment = segmIdMarketSegment;
    }

    public Long getSegmIdMarketTerritory() {
        return this.segmIdMarketTerritory;
    }

    public void setSegmIdMarketTerritory(Long segmIdMarketTerritory) {
        this.segmIdMarketTerritory = segmIdMarketTerritory;
    }

    public String getSegmNaMarketSegment() {
        return this.segmNaMarketSegment;
    }

    public void setSegmNaMarketSegment(String segmNaMarketSegment) {
        this.segmNaMarketSegment = segmNaMarketSegment;
    }

    public String getSegmNaMarketTerritory() {
        return this.segmNaMarketTerritory;
    }

    public void setSegmNaMarketTerritory(String segmNaMarketTerritory) {
        this.segmNaMarketTerritory = segmNaMarketTerritory;
    }

    public BigDecimal getWpooIdFunctionalPool() {
        return this.wpooIdFunctionalPool;
    }

    public void setWpooIdFunctionalPool(BigDecimal wpooIdFunctionalPool) {
        this.wpooIdFunctionalPool = wpooIdFunctionalPool;
    }

    public CecacLoggedManagerPK getId() {
        return this.id;
    }

    public void setId(CecacLoggedManagerPK id) {
        this.id = id;
    }

}
