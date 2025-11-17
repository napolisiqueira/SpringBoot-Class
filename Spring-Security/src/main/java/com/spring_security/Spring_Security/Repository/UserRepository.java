package com.spring_security.Spring_Security.Repository;

import com.spring_security.Spring_Security.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT e FROM User e JOIN FETCH e.roles  WHERE e.username= (:username)")
    public static User findByUsername(@Param("username") String username) {
        return null;
    }
}
