package com.emp.login.model;
import jakarta.persistence.*;

@Entity
@Table(name="data")

public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Department;
    private String Title;
    private String mob;
 	
	public String getName() {
		return name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String Department) {
		this.Department = Department;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", Department=" + Department + ", Title=" + Title + ", mob=" + mob
				+ "]";
	}
	
}
