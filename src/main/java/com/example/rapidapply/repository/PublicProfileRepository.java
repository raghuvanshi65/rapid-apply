package com.example.rapidapply.repository;

import com.example.rapidapply.entity.PublicProfile;
import com.example.rapidapply.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PublicProfileRepository extends JpaRepository<PublicProfile,String> {
//    List<PublicProfile> getPublicProfileByUser(User user);
}
