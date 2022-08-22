package assignment.exercise1.view;

import assignment.exercise1.controller.Controller;

public class MainView {
    public static void main(String[] args) {
        Controller studentController = new Controller();
        studentController.menuManagement();

        Controller teacherController = new Controller();
        teacherController.menuManagement();
    }
}
