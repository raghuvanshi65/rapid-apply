package com.example.rapidapply.repository;

import com.example.rapidapply.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProjectRepository extends JpaRepository<Projects,String> {
}
