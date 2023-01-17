package com.example.demo.Domain;

import java.util.List;

import com.example.demo.Model.Organization;
import com.example.demo.Repository.OrganizationRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class OrganizationFetcher {
OrganizationRepository organizationRepository;

    public List<Organization> organizationList= List.of(
            new Organization(1,"World Health Organization","www.who.com")
    );



    public OrganizationFetcher(OrganizationRepository organizationRepository
                             ) {
        this.organizationRepository = organizationRepository;

    }

    @DgsQuery
    public List <Organization> getAll(){
        organizationRepository.saveAll(organizationList);
        return organizationRepository.findAll();
    }

    @DgsMutation
    public Organization newOrg( @InputArgument String OrgName, Integer OrganizationId, String Website){

        Organization organization= new Organization();
        organization.setOrganizationId(OrganizationId);
        organization.setWebsite(Website);
        organization.setOrgName(OrgName);

        organizationRepository.save(organization);

        return organization;


    }

@DgsMutation
    public long deleteOrg(@InputArgument Integer OrganizationId){
    return organizationRepository.deleteOrg(OrganizationId);
}
@DgsMutation
    public int updateOrg(@InputArgument String OrgName, Integer OrganizationId ,String Website ){
        return organizationRepository.updateOrg(OrgName,Website,OrganizationId);
}

}
