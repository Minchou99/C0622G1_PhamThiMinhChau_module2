package casestudy.models.facility;

public abstract class Facility {
    private String id;
    private String name;
    private double area;
    private double price;
    private int amountOfPeople;

    public Facility() {
    }

    public Facility(String id, String name, double area, double price, int amountOfPeople) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.price = price;
        this.amountOfPeople = amountOfPeople;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Facility: " +
                "id= " + id +
                ", name= " + name  +
                ", area= " + area +
                ", price= " + price +
                ", amountOfPeople= " + amountOfPeople ;
    }
}
