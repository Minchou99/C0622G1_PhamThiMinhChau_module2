package casestudy.models.person;

public class Customer extends Person {
    private String address;
    private String customerType;

    public Customer() {
    }

    public Customer(String id, String name, String dateOfBirth, String gender, double phoneNumber, String email, String address, String customerType) {
        super(id, name, dateOfBirth, gender, phoneNumber, email);
        this.address = address;
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", customerType='" + customerType + '\'' +
                "} " + super.toString();
    }
}
