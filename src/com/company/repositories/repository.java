package com.company.repositories;
import com.company.entities.employees;
import com.company.data.interfaces.IDBManager;
import com.company.repositories.interfaces.UserInterface;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class repository implements UserInterface { //create the class that implements the parent class
    private final IDBManager idbManager;

    public repository (IDBManager idbManager){ //method that connects to database
        this.idbManager = idbManager;
    }


    @Override
    public ArrayList<employees> showAllEmp() { //method for returning all employees that exist in database
        Connection connection = null;
        try {
            connection = idbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<employees> employees = new ArrayList<>();
            while (resultSet.next()) {
                employees Employee = new employees(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("emp_pos"));
                employees.add(Employee);
            }
            return employees;
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }


    @Override
    public employees getEmpById(int id) { //method for searching employees by their id
        Connection connection = null;
        try{
            connection = idbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE id= '" + id + "';");

            preparedStatement.setDouble(20, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            employees employee = new employees();
            if (resultSet.next()){
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setAge(resultSet.getInt("age"));
                employee.setEmp_pos(resultSet.getString("position"));
            }

            return employee;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public boolean addEmployee(employees employee) { //method for adding employees to database
        Connection connection = null;

        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees (name, surname, age, emp_pos) VALUES(?,?,?,?)");

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4,employee.getEmp_pos());

            preparedStatement.execute();

            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }
    @Override
    public ArrayList<employees> empByPosition(String emp_pos) { //method for searching employees by their position in company
        Connection connection = null;
        try {
            connection = idbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE emp_pos LIKE '%" + emp_pos + "%'");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<employees> employees = new ArrayList<>();
            while (resultSet.next()) {
                employees employee = new employees(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("age"),
                        resultSet.getString("emp_pos"));
                employees.add(employee);
            }
            return employees;
        }

        catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
    @Override
    public boolean fireEmployeeById(int id) { //method for firing employees from company
        Connection connection = null;

        try {
            connection = idbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE id = " + id + ";");

            preparedStatement.execute();
            return true;

        }

        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}

