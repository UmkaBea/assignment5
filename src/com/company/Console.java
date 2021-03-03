package com.company;
import com.company.controller.EmployeeController;

import com.company.repositories.interfaces.UserInterface;

import java.sql.SQLOutput;
import java.util.Scanner;
public class Console {
    private final EmployeeController employeeController;
    private final Scanner scanner;

    public Console(EmployeeController employeeController) {
        this.employeeController = employeeController;
        scanner = new Scanner(System.in);
    }

    public void start() { //method to start the program
        while (true) {
            System.out.println("Welcome to our IT company. You can choose an option below:\n 1) Show all employees of the company\n 2) Search employees by ID\n 3) Add an employee\n 4) Search employee by position\n 5) Fire the employee\n 0) Close\n");
            int choice = scanner.nextInt();
            if (choice == 1) {
                showAllEmp();
            }
            if (choice == 2) {
                searchEmpByIdMenu();
            }
            if (choice == 3) {
                addEmployeeMenu();
            }
            if (choice == 4) {
                empByPositionMenu();
            }
            if (choice == 5) {
                fireEmployeeMenu();
            }


            else {
                break;
            }
            System.out.println("---------------------------------------------------");

        }
    }
// choosing an options from console
    public void showAllEmp() {
        System.out.println("Thess are all employees that work in our company");
        String result = employeeController.showAllEmp();
        System.out.println(result);
    }

    public void searchEmpByIdMenu() {
        System.out.println("Write the ID of an employee");
        int id = scanner.nextInt();
        String result = employeeController.getEmpById(id);
        System.out.println(result);
    }

    public void addEmployeeMenu() {
        System.out.println("Write the name of an employee");
        String name = scanner.next();
        System.out.println(" Write the surname of an employee");
        String surname = scanner.next();
        System.out.println(" Write the age of an employee");
        int age = scanner.nextInt();
        System.out.println(" Write the position of an employee");
        String position = scanner.next();
        String result = employeeController.addEmployee(name, surname, age, position);
        System.out.println(result);
    }
    public void empByPositionMenu() {
        System.out.println("Write the position of an employee");
        String position = scanner.next();
        String result = employeeController.empByPosition(position);
        System.out.println(result);
    }

    public void fireEmployeeMenu() {
        System.out.println("Write ID of an employee that you want to fire");
        int id = scanner.nextInt();
        String result = employeeController.fireEmployeeById(id);
        System.out.println(result);
    }


}