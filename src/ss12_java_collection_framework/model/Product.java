package ss12_java_collection_framework.model;

public abstract class Product {
    private int id;
    private String name;
    private String origin;
    private String dateOfManufacture;

    public Product() {
    }

    public Product(int id, String name, String origin, String dateOfManufacture) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.dateOfManufacture = dateOfManufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", dateOfManufacture='" + dateOfManufacture + '\'' +
                '}';
    }
}
