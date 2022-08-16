package ss12_collection.model;

public class Bike extends Product {
    private String manufacturer;
    private int price;

    public Bike() {
    }

    public Bike(String manufacturer, int price) {
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Bike(String id, String name, String color, String origin, String manufacturer, int price) {
        super(id, name, color, origin);
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bike{" +
                super.toString() +
                "manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                "} ";
    }
}
