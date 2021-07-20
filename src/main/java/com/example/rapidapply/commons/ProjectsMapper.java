package com.example.rapidapply.commons;

import com.example.rapidapply.entity.Projects;
import com.example.rapidapply.helpers.PowerStringTokenizer;
import com.example.rapidapply.models.ImmutableProjects;

import java.sql.Date;
import java.util.UUID;

public class ProjectsMapper {

    public static Projects modelToEntity(com.example.rapidapply.models.Projects projectsModel) {
        Projects projects = new Projects();
        if (projects.getProjectId() == null)
            projects.setProjectId(UUID.randomUUID().toString());
        else
            projects.setProjectId(projectsModel.getProjectId().toString());

        projects.setProjectName(projectsModel.getProjectName().trim());
        if (projectsModel.getLanguages() != null)
            projects.setLanguages(PowerStringTokenizer.listToString(projectsModel.getLanguages()));

        if (projectsModel.getTechStack() != null)
            projects.setTechstack(PowerStringTokenizer.listToString(projectsModel.getTechStack()));

        projects.setDescription(projectsModel.getDescription());
        projects.setStartingDate(Date.valueOf(projectsModel.getStartingDate()));
        projects.setWip(projectsModel.getWIP()==0 ? 'N' : 'Y');

        if(projectsModel.getEndingDate()!=null)
        projects.setEndingDate(Date.valueOf(projectsModel.getEndingDate()));

        projects.setProjectLink(projectsModel.getProjectLink());

        return projects;
    }

    public static com.example.rapidapply.models.Projects entityToModel(Projects projects){
        return ImmutableProjects.builder().projectId(UUID.fromString(projects.getProjectId()))
                .projectName(projects.getProjectName()).addAllLanguages(PowerStringTokenizer.stringToList(projects.getLanguages()))
                .techStack(PowerStringTokenizer.stringToList(projects.getTechstack())).description(projects.getDescription())
                .projectLink(projects.getProjectLink()==null ? null : projects.getProjectLink()).wIP(projects.getWip()=='Y'?1:0)
                .startingDate(projects.getStartingDate().toString()).endingDate(projects.getEndingDate().toString()).build();
    }
}
