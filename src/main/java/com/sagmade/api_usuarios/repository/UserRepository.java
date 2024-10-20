package com.sagmade.api_usuarios.repository;

import com.sagmade.api_usuarios.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}