package business.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import business.demo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  
}
