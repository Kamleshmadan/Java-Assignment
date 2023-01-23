package com.emp.login.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.login.model.Employee;
import com.emp.login.repository.EmpRepository;



@Service
public class EmpService 
{
	@Autowired 
	private EmpRepository registerRepository;
	public List<Employee> getAllUsers()
{
		List<Employee> empRecords = new ArrayList<>();
		registerRepository.findAll().forEach(empRecords::add);
		return empRecords;
}
	public void addUser(Employee userRecord)  
	{    
		registerRepository.save(userRecord);    
	} 
	public Employee getEmployeeById(Long id)
	{
		return registerRepository.findById(id).get();
	}
	
	
	public Employee updateEmployee(Employee employee)
	{
		return registerRepository.save(employee);
	}
	public Employee employee(String name)
	{
		Employee e = registerRepository.findByName(name);
		return e;
	}
	
	public void deleteEmpById(Long id)
	{
		registerRepository.deleteById(id);
	}
	
}
