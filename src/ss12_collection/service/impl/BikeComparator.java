package ss12_collection.service.impl;

import ss12_collection.model.Bike;

import java.util.Comparator;

public class BikeComparator implements Comparator<Bike> {
    public int compare(Bike o1, Bike o2) {
        double price1 = o1.getPrice();
        double price2 = o2.getPrice();
        return Double.compare(price1, price2);
   }
}
