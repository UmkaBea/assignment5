package com.company.controller;
import com.company.entities.employees;
import com.company.repositories.interfaces.UserInterface;
import com.company.controller.EmployeeController;


public class EmployeeController {
    private final UserInterface employeeRepository;
    public EmployeeController(UserInterface employeeRepository){
        this.employeeRepository = employeeRepository;

    }
    public String showAllEmp(){
        String result = employeeRepository.showAllEmp().toString();
        result = result.substring(1, result.length()-1);
        return result;
    }
    public String getEmpById (int id){
        String result = employeeRepository.getEmpById(id).toString();
        result = result.substring(1, result.length()-1);
        return result;
    }
    public String addEmployee(String name, String surname, int age, String emp_pos) {


        boolean added = employeeRepository.addEmployee(new employees(name, surname, age, emp_pos));
        if (added) {
            return "Employee was added";
        }

        return "Employee was not added";

    }
    public String empByPosition(String position){
        String result = employeeRepository.empByPosition(position).toString();
        result = result.substring(1, result.length()-1);
        return result;

    }
    public String fireEmployeeById(int id){
        boolean fired = employeeRepository.fireEmployeeById(id);
        if (fired) {
            return "The employee was fired";
        }
        return "The employee was not fired";
    }



}

