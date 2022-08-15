package ss10_dsa_mvc.exercise1.view;

import ss10_dsa_mvc.exercise1.controller.Controller;

public class MainView {
    public static void main(String[] args) {
        Controller studentController = new Controller();
        studentController.menuManagement();

        Controller teacherController = new Controller();
        teacherController.menuManagement();
    }
}
