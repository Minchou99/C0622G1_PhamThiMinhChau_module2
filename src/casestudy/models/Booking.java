package casestudy.models;

import java.time.LocalDate;

public class Booking {
    private String bookingId;
    private LocalDate startDay;
    private LocalDate endDay;
    private String customerId;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }

    public Booking(String bookingId, LocalDate startDay, LocalDate endDay, String customerId, String serviceName, String serviceType) {
        this.bookingId = bookingId;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerId = customerId;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return bookingId + "," +
                startDay + "," +
                endDay + "," +
                customerId + "," +
                serviceName + "," +
                serviceType;
    }
}
