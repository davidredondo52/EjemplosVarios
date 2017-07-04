package com.telefonica.cana.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CecacOrgRoleAssociationS database table.
 */
@Entity
@NamedQuery(name = "CecacOrgRoleAssociation.findAll", query = "SELECT c FROM CecacOrgRoleAssociation c")
@Table(name = "CECAC_ORG_ROLE_ASSOCIATION")
public class CecacOrgRoleAssociation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "PARO_ID_FUNCTIONAL_ROLE", nullable = false, precision = 38)
    private BigDecimal paroIdFunctionalRole;

    @Column(name = "PART_ID_FATHER_PARTY", precision = 38)
    private BigDecimal partIdFatherParty;

    @Column(name = "PART_ID_PARTY", nullable = false, precision = 38, unique = true)
    @Id
    private BigDecimal partIdParty;

    @Column(length = 50, name = "PRTY_NA_FUNCTIONAL_ROLE_SPEC", nullable = false)
    private String prtyNaFunctionalRoleSpec;

    @Column(name = "ROTY_ID_FATHER_ROLE_SPEC", precision = 4)
    private Long rotyIdFatherRoleSpec;

    @Column(name = "ROTY_ID_FUNCTIONAL_ROLE_SPEC", nullable = false, precision = 4)
    private Long rotyIdFunctionalRoleSpec;

    @Column(length = 50, name = "ROTY_NA_FATHER_ROLE_SPEC")
    private String rotyNaFatherRoleSpec;

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

    public BigDecimal getPartIdParty() {
        return this.partIdParty;
    }

    public void setPartIdParty(BigDecimal partIdParty) {
        this.partIdParty = partIdParty;
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

    public String getRotyNaFatherRoleSpec() {
        return this.rotyNaFatherRoleSpec;
    }

    public void setRotyNaFatherRoleSpec(String rotyNaFatherRoleSpec) {
        this.rotyNaFatherRoleSpec = rotyNaFatherRoleSpec;
    }

}
