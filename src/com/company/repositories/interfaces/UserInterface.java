package com.company.repositories.interfaces;
import com.company.entities.employees;
import java.util.ArrayList;

public interface UserInterface { //all the methods that will be shown in the console
    ArrayList<employees> showAllEmp();
    public employees getEmpById(int id);
    public boolean addEmployee(employees employee);
    ArrayList<employees> empByPosition(String position);
    public boolean fireEmployeeById(int id);
}