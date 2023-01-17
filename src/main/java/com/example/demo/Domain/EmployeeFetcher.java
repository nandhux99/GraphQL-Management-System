package com.example.demo.Domain;

import java.util.List;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class EmployeeFetcher{

  public EmployeeFetcher(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  EmployeeRepository employeeRepository;


  public List<Employee> employeeList = List.of(
          new Employee("Jessie Pinkman", "!123344dfs", "jessiepinkman@meth.com", 62));

  @DgsQuery
  public List<Employee> getAllEmp() {
    employeeRepository.saveAll(employeeList);
     return employeeRepository.findAll();
  }



  @DgsMutation
  public Employee newEmployee(@InputArgument String UserName, String Password, String Email, Integer UserId){
    Employee employee= new Employee();
    employee.setEmail(Email);
    employee.setPassword(Password);
    employee.setUserName(UserName);
    employee.setUserId(UserId);

   return employeeRepository.save(employee);


  }
@DgsMutation
  public long deleteEmployee(@InputArgument Integer UserId){

  return employeeRepository.deleteByUserId(UserId);

}

@DgsMutation
  public int updateEmployee(@InputArgument Integer UserId,String UserName,String Password,String Email){
  return employeeRepository.update(UserName, Password,Email,UserId);

}

}




