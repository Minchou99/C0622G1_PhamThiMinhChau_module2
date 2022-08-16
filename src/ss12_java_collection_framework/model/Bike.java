package ss12_java_collection_framework.model;

public class Bike extends Product{
    private String color;
    private String type;

    public Bike() {
    }

    public Bike(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public Bike(int id, String name, String origin, String dateOfManufacture, String color, String type) {
        super(id, name, origin, dateOfManufacture);
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bike{" +
                super.toString()+
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                "} ";
    }
}
