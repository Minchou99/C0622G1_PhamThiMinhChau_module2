package ss12_java_collection_framework.controller;

import ss12_collection.service.IBikeService;
import ss12_collection.service.impl.BikeService;

import java.util.Scanner;

public class BikeController {
    public static Scanner scanner = new Scanner(System.in);
    private static final IBikeService bikeService = (IBikeService) new BikeService();
    public static void managementBike() {

    }
}
