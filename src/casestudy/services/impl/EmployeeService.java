package casestudy.services.impl;

import casestudy.controllers.FuramaController;
import casestudy.services.IEmployeeService;
import ss10_dsa_mvc.exercise1.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);


    @Override
    public void displayListEmployee() {

    }

    @Override
    public void addNewEmployee() {

    }

    @Override
    public void editEmployee() {

    }

    @Override
    public void returnMainMenu() {
        FuramaController.displayMainMenu();
    }
}
