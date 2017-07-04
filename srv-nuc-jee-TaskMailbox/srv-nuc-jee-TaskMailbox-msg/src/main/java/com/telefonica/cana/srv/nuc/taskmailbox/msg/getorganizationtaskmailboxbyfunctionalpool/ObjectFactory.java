package com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.telefonica.cana.srv.nuc.taskmailbox.msg.getorganizationtaskmailboxbyfunctionalpool
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetOrganizationTaskMailboxByFunctionalPool_IN }
     * 
     */
    public GetOrganizationTaskMailboxByFunctionalPool_IN createGetOrganizationTaskMailboxByFunctionalPool_IN() {
        return new GetOrganizationTaskMailboxByFunctionalPool_IN();
    }

    /**
     * Create an instance of {@link FunctionalPool_DTO_IN }
     * 
     */
    public FunctionalPool_DTO_IN createFunctionalPool_DTO_IN() {
        return new FunctionalPool_DTO_IN();
    }

    /**
     * Create an instance of {@link GetOrganizationTaskMailboxByFunctionalPool_OUT }
     * 
     */
    public GetOrganizationTaskMailboxByFunctionalPool_OUT createGetOrganizationTaskMailboxByFunctionalPool_OUT() {
        return new GetOrganizationTaskMailboxByFunctionalPool_OUT();
    }

    /**
     * Create an instance of {@link OrganizationPoolAssignment_DTO_OUT }
     * 
     */
    public OrganizationPoolAssignment_DTO_OUT createOrganizationPoolAssignment_DTO_OUT() {
        return new OrganizationPoolAssignment_DTO_OUT();
    }

    /**
     * Create an instance of {@link FunctionalPool_DTO_OUT }
     * 
     */
    public FunctionalPool_DTO_OUT createFunctionalPool_DTO_OUT() {
        return new FunctionalPool_DTO_OUT();
    }

    /**
     * Create an instance of {@link OrganizationRole_DTO_OUT }
     * 
     */
    public OrganizationRole_DTO_OUT createOrganizationRole_DTO_OUT() {
        return new OrganizationRole_DTO_OUT();
    }

    /**
     * Create an instance of {@link TaskMailbox_DTO_OUT }
     * 
     */
    public TaskMailbox_DTO_OUT createTaskMailbox_DTO_OUT() {
        return new TaskMailbox_DTO_OUT();
    }

}
