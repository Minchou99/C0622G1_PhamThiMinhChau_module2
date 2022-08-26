package casestudy.models.facility;

public class Room extends Facility {
    private String freeStuff;

    public Room() {
    }

    public Room(String serviceCode, String serviceName, double area, double price, int amountOfPeople, String rentalType, String freeStuff) {
        super(serviceCode, serviceName, area, price, amountOfPeople, rentalType);
        this.freeStuff = freeStuff;
    }

    public String getFreeStuff() {
        return freeStuff;
    }

    public void setFreeStuff(String freeStuff) {
        this.freeStuff = freeStuff;
    }

    @Override
    public String toString() {
        return "Room " + super.toString() +
                "freeStuff= " + freeStuff;
    }
}
