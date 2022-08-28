package casestudy.models.facility;

public class House extends Facility {
    private String roomStandard;
    private int floor;

    public House() {
    }

    public House(String serviceCode, String serviceName, double area, double price, int amountOfPeople, String rentalType, String roomStandard, int floor) {
        super(serviceCode, serviceName, area, price, amountOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return super.toString() +
                roomStandard + "," +
                floor;
    }
}
