package com.example.rapidapply.repository;

import com.example.rapidapply.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SkillsRepository extends JpaRepository<Skills,String> {
}
