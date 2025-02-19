package business.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import business.demo.entities.Employee;
import business.demo.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
  private final EmployeeRepository employeeRepository;

  public Employee addEmployee(Employee employee){
    return employeeRepository.save(employee);
  }

  public List<Employee> getAllEmployees(){
    return employeeRepository.findAll();
  }

  public Employee updateEmployee(Employee newEmployee, Long id){
    return employeeRepository.findById(id).map(emp -> {
      emp.setName(newEmployee.getName());
      emp.setPosition(newEmployee.getPosition());
      emp.setSalary(newEmployee.getSalary());
      return employeeRepository.save(emp);
    }).orElseThrow(() -> new RuntimeException("Employee not found"));
  }

  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
  }

}
