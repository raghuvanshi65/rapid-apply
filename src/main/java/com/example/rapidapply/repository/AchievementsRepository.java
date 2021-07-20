package com.example.rapidapply.repository;


import com.example.rapidapply.entity.Achievements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AchievementsRepository extends JpaRepository<Achievements,String> {
}
