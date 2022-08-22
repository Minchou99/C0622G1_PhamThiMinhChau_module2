package casestudy.models.facility;

public class House extends Facility {
    private String roomStandard;
    private double floor;

    public House() {
    }

    public House(String roomStandard, double floor) {
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public House(String id, String name, double area, double price, int amountOfPeople, String roomStandard, double floor) {
        super(id, name, area, price, amountOfPeople);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getFloor() {
        return floor;
    }

    public void setFloor(double floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House: " + super.toString() +
                "roomStandard= " + roomStandard +
                ", floor= " + floor;
    }
}
