package com.dao;

import java.util.List;

import com.model.Employee;

public interface EmployeeDAO {
	
	int add(Employee employee);
	int update(Employee employee);
	int delete(int id);
	List<Employee> view();
	Employee view(int id);

}