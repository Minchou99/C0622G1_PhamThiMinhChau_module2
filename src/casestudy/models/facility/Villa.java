package casestudy.models.facility;

public class Villa extends Facility {
    private String roomStandard;
    private double floor;
    private double poolArea;

    public Villa() {
    }

    public Villa(String id, String name, double area, double price, int amountOfPeople, String roomStandard, double floor, double poolArea) {
        super(id, name, area, price, amountOfPeople);
        this.roomStandard = roomStandard;
        this.floor = floor;
        this.poolArea = poolArea;
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String toString() {
        return "Villa " + super.toString() +
                "roomStandard= " + roomStandard +
                ", floor= " + floor +
                ", poolArea=" + poolArea;
    }
}
