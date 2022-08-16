package ss12_java_collection_framework.model;

public class MotoBike extends Product {
    private String color;
    private String typeOfManufacturer;

    public MotoBike() {
    }

    public MotoBike(String color, String typeOfManufacturer) {
        this.color = color;
        this.typeOfManufacturer = typeOfManufacturer;
    }

    public MotoBike(int id, String name, String origin, String dateOfManufacture, String color, String typeOfManufacturer) {
        super(id, name, origin, dateOfManufacture);
        this.color = color;
        this.typeOfManufacturer = typeOfManufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTypeOfManufacturer() {
        return typeOfManufacturer;
    }

    public void setTypeOfManufacturer(String typeOfManufacturer) {
        this.typeOfManufacturer = typeOfManufacturer;
    }

    @Override
    public String toString() {
        return "MotoBike{" + super.toString()+
                "color='" + color + '\'' +
                ", typeOfManufacturer='" + typeOfManufacturer + '\'' +
                "} " ;
    }
}
