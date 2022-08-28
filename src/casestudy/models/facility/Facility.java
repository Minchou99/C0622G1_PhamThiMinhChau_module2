package casestudy.models.facility;

public abstract class Facility {
    private String serviceCode;
    private String serviceName;
    private double area;
    private double price;
    private int amountOfPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceCode, String serviceName, double area, double price, int amountOfPeople, String rentalType) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.area = area;
        this.price = price;
        this.amountOfPeople = amountOfPeople;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    @Override
    public String toString() {
        return serviceCode + "," +
                serviceName + "," +
                area + "," +
                price + "," +
                amountOfPeople + "," +
                rentalType+ "," ;
    }
}
