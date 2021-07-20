package com.example.rapidapply.repository;

import com.example.rapidapply.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ExperienceRepository extends JpaRepository<Experience,String> {
}
