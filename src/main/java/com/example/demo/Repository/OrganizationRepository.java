package com.example.demo.Repository;

import com.example.demo.Model.Organization;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public interface OrganizationRepository extends JpaRepository< Organization,String> {

    @Transactional
    @Modifying
    @Query("delete from Organization o where o.OrganizationId = ?1")
    int deleteOrg(int OrganizationId);


   @Modifying
    @Query("update Organization o set o.OrgName = :OrgName,o.Website =:Website where o.OrganizationId =:OrganizationId")
    int updateOrg(@InputArgument String OrgName,String Website,Integer OrganizationId);


}
