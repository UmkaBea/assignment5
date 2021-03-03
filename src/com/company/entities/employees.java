package com.company.entities;




public class employees {
    private int id; //id of an employee
    private String name; //name of an employee
    private String surname; //surname of an employee
    private int age; //age of an employee
    private String emp_pos; //position of an employee
    public employees (){ //getters and setters for each fields
    }
    public employees(int id, String name, String surname, int age, String emp_pos){ //constructor
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.emp_pos = emp_pos;
    }
    public employees( String name, String surname, int age, String emp_pos){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.emp_pos = emp_pos;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmp_pos() {
        return emp_pos;
    }

    public void setEmp_pos(String emp_pos) {
        this.emp_pos = emp_pos;
    }



    @Override //the message that appear in the console or just overriding
    public String toString() {
        return "Employee's" +
                " id = " + id +
                ", name = " + name +
                ", surname = " + surname +
                ", age = " + age +
                ", position = " + emp_pos
                ;
    }
}

