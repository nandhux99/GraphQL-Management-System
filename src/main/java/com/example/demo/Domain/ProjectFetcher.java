package com.example.demo.Domain;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

import com.example.demo.Model.Project;
import com.example.demo.Repository.ProjectRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
    public class ProjectFetcher {
    ProjectRepository projectRepository;
    public List<Project> projectList = List.of(
            new Project("Facilgo", 1),
            new Project("Star", 2),
            new Project("Lenovo", 3)
    );

    public ProjectFetcher(ProjectRepository projectRepository
                        ) {
        this.projectRepository = projectRepository;

    }

@Modifying
    @DgsQuery
    public List<Project> getAllProject() {
        projectRepository.saveAll(projectList);
        return projectRepository.findAll();
    }
    @DgsMutation
    public Project newProject(@InputArgument String ProjectName, Integer ProjectId) {
        Project project = new Project();
        project.setProjectName(ProjectName);
        project.setProjectId(ProjectId);

       return   projectRepository.save(project);
    }

    @DgsMutation
    public long deleteProject(@InputArgument Integer ProjectId) {
       return projectRepository.deleteByProjectId(ProjectId);
    }

@DgsMutation
    public int updateProject (@InputArgument Integer ProjectId, String ProjectName){
        return projectRepository.updateProject(ProjectName,ProjectId);
}

@DgsQuery
    public List<Project>findByProjectId(@InputArgument Integer ProjectId){
        return  projectRepository.findByProjectId(ProjectId);
}
}