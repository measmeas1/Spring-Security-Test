package business.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import business.demo.entities.Employee;
import business.demo.services.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class EmployeeController {
  private final EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
    return ResponseEntity.ok(employeeService.addEmployee(employee));
  }

  @GetMapping
  public ResponseEntity<List<Employee>> getEmployees(){
    return ResponseEntity.ok(employeeService.getAllEmployees());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
    return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
    employeeService.deleteEmployee(id);
    return ResponseEntity.noContent().build();
  }
}