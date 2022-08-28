package casestudy.controllers;

import casestudy.services.IFacilityService;
import casestudy.services.impl.FacilityService;
import casestudy.utils.exception.FacilityException;

import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);
    private static IFacilityService facilityService = new FacilityService();

    public static void managementFacility() {
        while (true) {
            int choice;
            while (true) {
                try {
                    System.out.println("--------------------------------------");
                    System.out.println("Chào mừng bạn đến với hệ thống quản lí cơ sở vật chất của FURAMA");
                    System.out.println("1. Hiển thị danh sách cơ sở vật chất");
                    System.out.println("2. Thêm mới cơ sở vật chất");
                    System.out.println("3. Bảo trì cơ sở vật chất");
                    System.out.println("4. Trở về hệ thống quản lí chính");
                    System.out.println("Mời bạn nhập chức năng 1 -> 4: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 4) {
                        throw new FacilityException("Bạn nhập sai. Vui lòng nhập số lớn hơn 0 và nhỏ hơn 5");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Bạn nhập không đúng yêu cầu. Vui lòng nhập số.");
                } catch (FacilityException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Bạn nhập không hợp lệ.");
                }
            }

            switch (choice) {
                case 1:
                    facilityService.displayListFacility();
                    break;
                case 2:
                    facilityService.addNewFacility();
                    break;
                case 3:
                    facilityService.displayListFacilityMaintenance();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng.");
            }
        }
    }
}
