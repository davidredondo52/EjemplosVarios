package com.telefonica.cana.dao.taskmailbox.dto;

import java.math.BigDecimal;

public class OrganizationPoolAssignmentDTO {

    private BigDecimal id;
    private BigDecimal idOrganizationRole;
    private BigDecimal idFunctionalPool;
    private BigDecimal idTaskMailbox;
    private String codeTaskMailbox;

    public OrganizationPoolAssignmentDTO() {
        super();
    }

    public OrganizationPoolAssignmentDTO(BigDecimal id, BigDecimal idOrganizationRole, BigDecimal idFunctionalPool,
            BigDecimal idTaskMailbox, String codeTaskMailbox) {
        super();
        this.id = id;
        this.idOrganizationRole = idOrganizationRole;
        this.idFunctionalPool = idFunctionalPool;
        this.idTaskMailbox = idTaskMailbox;
        this.codeTaskMailbox = codeTaskMailbox;
    }

    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getIdOrganizationRole() {
        return this.idOrganizationRole;
    }

    public void setIdOrganizationRole(BigDecimal idOrganizationRole) {
        this.idOrganizationRole = idOrganizationRole;
    }

    public BigDecimal getIdFunctionalPool() {
        return this.idFunctionalPool;
    }

    public void setIdFunctionalPool(BigDecimal idFunctionalPool) {
        this.idFunctionalPool = idFunctionalPool;
    }

    public BigDecimal getIdTaskMailbox() {
        return this.idTaskMailbox;
    }

    public void setIdTaskMailbox(BigDecimal idTaskMailbox) {
        this.idTaskMailbox = idTaskMailbox;
    }

    public String getCodeTaskMailbox() {
        return this.codeTaskMailbox;
    }

    public void setCodeTaskMailbox(String codeTaskMailbox) {
        this.codeTaskMailbox = codeTaskMailbox;
    }

}
