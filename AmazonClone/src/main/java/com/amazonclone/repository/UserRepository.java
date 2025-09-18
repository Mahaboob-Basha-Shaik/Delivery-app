package com.amazonclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amazonclone.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email); // For login functionality
}
