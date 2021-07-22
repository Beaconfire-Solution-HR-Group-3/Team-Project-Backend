package com.example.hrteamproject.Dao;

import com.example.hrteamproject.Pojo.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,String> {
    Employee findById(int id);
}
