package com.example.rapidapply.repository;

import com.example.rapidapply.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EducationRepository extends JpaRepository<Education,String> {
}
