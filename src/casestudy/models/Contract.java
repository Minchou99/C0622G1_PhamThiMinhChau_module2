package casestudy.models;

public class Contract {
    private String contractNumber;
    private String bookingId;
    private double prepay;
    private double totalPayment;
    private String customerId;

    public Contract() {
    }

    public Contract(String contractNumber, String bookingId, double prepay, double totalPayment, String customerId) {
        this.contractNumber = contractNumber;
        this.bookingId = bookingId;
        this.prepay = prepay;
        this.totalPayment = totalPayment;
        this.customerId = customerId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getPrepay() {
        return prepay;
    }

    public void setPrepay(double prepay) {
        this.prepay = prepay;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber='" + contractNumber + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", prepay=" + prepay +
                ", totalPayment=" + totalPayment +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
