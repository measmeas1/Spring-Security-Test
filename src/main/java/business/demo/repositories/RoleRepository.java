package business.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import business.demo.entities.Role;

public interface RoleRepository extends JpaRepository <Role, Long>{

  Role findByName(String name);
} 


