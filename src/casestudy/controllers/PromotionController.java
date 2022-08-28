package casestudy.controllers;

import casestudy.services.IPromotionService;
import casestudy.services.impl.PromotionService;
import casestudy.utils.exception.PromotionException;

import java.util.Scanner;

public class PromotionController {
    private static Scanner scanner = new Scanner(System.in);
    private static IPromotionService promotionService = new PromotionService();

    public static void managementPromotion() {
        while (true) {
            int choice;
            while (true) {
                try {
                    System.out.println("--------------------------------------");
                    System.out.println("Chào mừng bạn đến với hệ thống quản lí chương trình khuyến mãi của FURAMA");
                    System.out.println("1. Hiển thị danh sách khách hàng sử dụng dịch vụ");
                    System.out.println("2. Hiển thị danh sách khách hàng ");
                    System.out.println("3. Trở về hệ thống quản lí chính");
                    System.out.println("Mời bạn nhập chức năng 1 -> 3: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 3) {
                        throw new PromotionException("Bạn nhập sai. Vui lòng nhập số lớn hơn 0 và nhỏ hơn 4");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Bạn nhập không đúng yêu cầu. Vui lòng nhập số.");
                } catch (PromotionException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Bạn nhập không hợp lệ.");
                }
            }

            switch (choice) {
                case 1:
                    promotionService.displayListCustomersUseService();
                    break;
                case 2:
                    promotionService.displayListCustomersGetVoucher();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng.");
            }
        }
    }
}
