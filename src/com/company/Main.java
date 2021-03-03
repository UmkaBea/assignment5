package com.company;

import com.company.controller.EmployeeController;
import com.company.data.DBManager;
import com.company.data.interfaces.IDBManager;
import com.company.repositories.repository;
import com.company.repositories.interfaces.UserInterface;

public class Main {

    public static void main(String[] args) {
        IDBManager idbManager = new DBManager();
        UserInterface Repository = new repository(idbManager);
        EmployeeController employeeController = new EmployeeController(Repository);
        Console myApplication = new Console(employeeController);
        myApplication.start();
    }
}
