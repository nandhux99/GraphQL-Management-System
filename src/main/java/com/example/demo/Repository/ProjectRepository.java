package com.example.demo.Repository;

import com.example.demo.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {


    @Transactional
    @Modifying
    @Query("delete from Project p where p.ProjectId = ?1")
    int deleteByProjectId(Integer ProjectId);

    @Modifying
    @Query("update Project p set p.ProjectName = :ProjectName where p.ProjectId = :ProjectId")
    int updateProject( String ProjectName, Integer ProjectId);

    @Query("select p from Project p where p.ProjectId = :ProjectId")
    List<Project> findByProjectId(@Param("ProjectId") Integer ProjectId);



}