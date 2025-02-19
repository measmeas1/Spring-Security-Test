package business.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import business.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
  Optional<User> findByUsername(String username);
} 
  
