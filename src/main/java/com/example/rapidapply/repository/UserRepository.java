package com.example.rapidapply.repository;

import com.example.rapidapply.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User,String> {
    public abstract User getUserByEmail(String email);
}
