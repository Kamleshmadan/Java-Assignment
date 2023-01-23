package com.emp.login.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.login.model.Employee;



public interface EmpRepository extends JpaRepository<Employee, Long> 
{
	Employee findByName(String name);
}

