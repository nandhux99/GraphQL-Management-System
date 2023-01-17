package com.example.demo.Repository;

import com.example.demo.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Transactional
    @Modifying
    @Query("delete from Employee e where e.UserId = ?1")
    int deleteByUserId(int UserId);

    @Modifying
    @Query("update Employee e set e.UserName = :UserName, e.Password = :Password, e.Email = :Email where e.UserId = :UserId")
    int update(String UserName,  String Password, String Email, int UserId);





}
